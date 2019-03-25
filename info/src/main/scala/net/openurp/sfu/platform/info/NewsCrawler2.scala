package net.openurp.sfu.platform.info

import java.io.{ BufferedReader, IOException, InputStreamReader }
import java.net.{ URL, UnknownHostException }
import java.text.SimpleDateFormat
import java.util.ArrayList

import org.beangle.cache.CacheManager

/**
 * @author chaostone
 */
class NewsCrawler2(cacheManager: CacheManager) {
  private val cacheName = "news"
  private val cache = cacheManager.getCache(cacheName, classOf[String], classOf[java.util.ArrayList[_]])
  private val NewsKey = "news"
  private val NoticesKey = "notices"

  private val maxLine = 20
  var newsite = "http://xww.sfu.edu.cn/info/iList.jsp?cat_id=12741"
  var noticesite = "http://www.sfu.edu.cn/info/iList.jsp?cat_id=12707"

  def getNews(): java.util.List[_] = {
    val data = cache.get(NewsKey)
    if (data.isDefined) return data.get

    var in: BufferedReader = null
    try {
      val url = new URL(newsite)
      val connection = url.openConnection()
      connection.setConnectTimeout(5 * 1000)
      connection.setReadTimeout(5 * 1000)
      connection.setDoOutput(true)

      in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))
      val hrefs = Array.ofDim[String](maxLine)
      val titles = Array.ofDim[String](maxLine)
      val dates = Array.ofDim[String](maxLine)

      val fmt = new SimpleDateFormat("yyyy-MM-dd")
      val nowDays = System.currentTimeMillis / (1000 * 60 * 60 * 24)

      val news = new java.util.ArrayList[News]
      var i = 0
      var blnstart = false
      var inputLine: String = in.readLine()
      while (i < maxLine && inputLine != null) {
        if (inputLine.indexOf("<div class=\"xjr_list\">") != -1) blnstart = true
        if (blnstart) {
          if (inputLine.indexOf("<span>") != -1) {
            dates(i) = inputLine.substring(inputLine.indexOf("<span>") + 6, inputLine.indexOf("</span>"))
          } else if (inputLine.indexOf("<a href") != -1) {
            hrefs(i) = "http://xww.sfu.edu.cn" + inputLine.substring(inputLine.indexOf("href=\"") + 6, inputLine.indexOf("\" target"))
            titles(i) = inputLine.substring(inputLine.indexOf("title=\"") + 7, inputLine.indexOf("\">"))
            i += 1
          }
        }
        inputLine = in.readLine()
      }
      (0 until maxLine) foreach (i => addLine(news, hrefs(i), titles(i), dates(i)))
      cache.put(NewsKey, news)
      news
    } catch {
      case e: UnknownHostException =>
        cache.put(NewsKey, new ArrayList[News](0)); new ArrayList[News](0)
      case e: IOException =>
        cache.put(NewsKey, new ArrayList[News](0)); new ArrayList[News](0)
      case t: Throwable => throw new RuntimeException(t)
    } finally {
      if (in != null) in.close()
    }
  }

  def getNotices(): java.util.List[_] = {
    val data = cache.get(NoticesKey)
    if (data.isDefined) return data.get

    var in: BufferedReader = null
    try {
      val url = new URL(noticesite)
      val connection = url.openConnection()
      connection.setConnectTimeout(5 * 1000)
      connection.setReadTimeout(5 * 1000)
      connection.setDoOutput(true)

      val news = new java.util.ArrayList[News]
      in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))
      val hrefs = Array.ofDim[String](maxLine)
      val titles = Array.ofDim[String](maxLine)
      val dates = Array.ofDim[String](maxLine)

      val fmt = new SimpleDateFormat("yyyy-MM-dd")
      val nowDays = System.currentTimeMillis / (1000 * 60 * 60 * 24)

      var i = 0
      var blnstart = false
      var inputLine = in.readLine()
      //读取新闻标题
      while (inputLine != null && i < maxLine) {
        if (inputLine.indexOf("<div class=\"xjr_list\">") != -1) blnstart = true
        if (blnstart) {
          if (inputLine.indexOf("<span>") != -1) {
            dates(i) = inputLine.substring(inputLine.indexOf("<span>") + 7, inputLine.indexOf("</span>") - 1)
          } else if (inputLine.indexOf("<a href") != -1) {
            hrefs(i) = "http://www.sfu.edu.cn" + inputLine.substring(inputLine.indexOf("href=\"") + 6, inputLine.indexOf("\" target"))
            titles(i) = inputLine.substring(inputLine.indexOf("title=\"") + 7, inputLine.indexOf("\">"))
            i += 1
          }
        }
        inputLine = in.readLine()
      }
      (0 until maxLine) foreach (i => addLine(news, hrefs(i), titles(i), dates(i)))
      cache.put(NoticesKey, news)
      news
    } catch {
      case e: UnknownHostException =>
        cache.put(NoticesKey, new ArrayList[News](0)); new ArrayList[News](0)
      case e: IOException =>
        cache.put(NoticesKey, new ArrayList[News](0)); new ArrayList[News](0)
      case t: Throwable => throw new RuntimeException(t)
    } finally {
      if (in != null) in.close()
    }
  }

  private def addLine(news: java.util.List[News], href: String, title: String, date: String): Unit = {
    news.add(new News(title, href, date))
  }
}
