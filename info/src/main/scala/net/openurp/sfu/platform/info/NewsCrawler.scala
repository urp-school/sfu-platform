package net.openurp.sfu.platform.info

import java.io.BufferedReader
import java.io.InputStreamReader
import java.text.SimpleDateFormat
import java.net.URL
import org.beangle.cache.CacheManager
import java.net.UnknownHostException
import java.io.IOException

/**
 * @author chaostone
 */
class NewsCrawler(cacheManager: CacheManager) {
  private val cacheName = "news"
  private val cache = cacheManager.getCache(cacheName, classOf[String], classOf[String])
  private val NewsKey = "news"
  private val NoticesKey = "notices"

  var newsite = "http://xww.sfu.edu.cn/info/iList.jsp?cat_id=12741"
  var noticesite = "http://www.sfu.edu.cn/info/iList.jsp?cat_id=12707"

  def getNews(): String = {
    val data = cache.get(NewsKey)
    if (data.isDefined) return data.get

    var in: BufferedReader = null
    try {
      val url = new URL(newsite)
      val connection = url.openConnection()
      connection.setReadTimeout(3 * 1000)
      connection.setConnectTimeout(3 * 1000)
      connection.setDoOutput(true)

      in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))
      val hrefs = Array.ofDim[String](5)
      val titles = Array.ofDim[String](5)
      val dates = Array.ofDim[String](5)
      val images = Array.ofDim[String](5)

      val fmt = new SimpleDateFormat("yyyy-MM-dd")
      val nowDays = System.currentTimeMillis / (1000 * 60 * 60 * 24)

      var i = 0
      var blnstart = false
      var inputLine: String = in.readLine()
      while (i < 5 && inputLine != null) {
        if (inputLine.indexOf("<div class=\"xjr_list\">") != -1) blnstart = true
        if (blnstart) {
          if (inputLine.indexOf("<span>") != -1) {
            dates(i) = inputLine.substring(inputLine.indexOf("<span>") + 6, inputLine.indexOf("</span>"))
            val l = nowDays - fmt.parse(dates(i)).getTime() / (1000 * 60 * 60 * 24)
            if (l < 4) images(i) = "<img src=\"static/images/new.gif\" width=\"28\" height=\"12\"/>"
            else images(i) = ""
          } else if (inputLine.indexOf("<a href") != -1) {
            hrefs(i) = "http://xww.sfu.edu.cn" + inputLine.substring(inputLine.indexOf("href=\"") + 6, inputLine.indexOf("\" target"))
            titles(i) = inputLine.substring(inputLine.indexOf("title=\"") + 7, inputLine.indexOf("\">"))
            i += 1
          }
        }
        inputLine = in.readLine()
      }
      val buffer = new StringBuilder()
      addTableHead(buffer)
      (0 until 5) foreach (i => addLine(buffer, hrefs(i), titles(i), dates(i), images(i)))
      addTableFoot(buffer, newsite)
      val result = buffer.toString
      cache.put(NewsKey, result)
      result
    } catch {
      case e: UnknownHostException => ""
      case e: IOException =>
        cache.put(NewsKey, ""); ""
      case t: Throwable => throw new RuntimeException(t)
    } finally {
      if (in != null) in.close()
    }
  }

  def getNotices(): String = {
    val data = cache.get(NoticesKey)
    if (data.isDefined) return data.get

    var in: BufferedReader = null
    try {
      val url = new URL(noticesite)
      val connection = url.openConnection()
      connection.setReadTimeout(3 * 1000)
      connection.setConnectTimeout(3 * 1000)
      connection.setDoOutput(true)

      in = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"))
      val hrefs = Array.ofDim[String](5)
      val titles = Array.ofDim[String](5)
      val dates = Array.ofDim[String](5)
      val images = Array.ofDim[String](5)

      val fmt = new SimpleDateFormat("yyyy-MM-dd")
      val nowDays = System.currentTimeMillis / (1000 * 60 * 60 * 24)

      var i = 0
      var blnstart = false
      var inputLine = in.readLine()
      //读取新闻标题
      while (inputLine != null && i < 5) {
        if (inputLine.indexOf("<div class=\"xjr_list\">") != -1) blnstart = true
        if (blnstart) {
          if (inputLine.indexOf("<span>") != -1) {
            dates(i) = inputLine.substring(inputLine.indexOf("<span>") + 7, inputLine.indexOf("</span>") - 1)
            val l = nowDays - fmt.parse(dates(i)).getTime() / (1000 * 60 * 60 * 24)
            if (l < 4)
              images(i) = "<img src=\"static/images/new.gif\" width=\"28\" height=\"12\"/>"
            else images(i) = ""
          } else if (inputLine.indexOf("<a href") != -1) {
            hrefs(i) = "http://www.shfc.edu.cn" + inputLine.substring(inputLine.indexOf("href=\"") + 6, inputLine.indexOf("\" target"))
            titles(i) = inputLine.substring(inputLine.indexOf("title=\"") + 7, inputLine.indexOf("\">"))
            i += 1
          }
        }
        inputLine = in.readLine()
      }
      val buffer = new StringBuilder()
      addTableHead(buffer)
      (0 until 5) foreach (i => addLine(buffer, hrefs(i), titles(i), dates(i), images(i)))
      addTableFoot(buffer, noticesite)
      val result = buffer.toString
      cache.put(NoticesKey, result)
      result
    } catch {
      case e: UnknownHostException => ""
      case e: IOException =>
        cache.put(NoticesKey, ""); ""
      case t: Throwable => throw new RuntimeException(t)
    } finally {
      if (in != null) in.close()
    }
  }

  private def addLine(buffer: StringBuilder, href: String, title: String, date: String, image: String): Unit = {
    buffer ++= "<tr>"
    buffer ++= "<td width=\"21\"><img src=\"static/images/icon-top.gif\" width=\"14\" height=\"15\"/></td>"
    if (title.length() > 30)
      buffer ++= ("<td height=\"24\"><a href='" + href + "' title='" + title + "' target='_blank'>" + title.substring(0, 30) + "…</a>")
    else
      buffer ++= ("<td height=\"24\"><a href='" + href + "' title='" + title + "' target='_blank'>" + title + "</a>")
    buffer ++= (image + "</td>")
    buffer ++= ("<td width=\"80px\">" + date + "</td>")
    buffer ++= "</tr>"
  }

  private def addTableHead(buffer: StringBuilder): Unit = {
    buffer ++= "<table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\">"
  }

  private def addTableFoot(buffer: StringBuilder, strurl: String): Unit = {
    buffer ++= "</table>"
    buffer ++= "<table width=\"90%\" border=\"0\" align=\"center\" cellpadding=\"0\" cellspacing=\"0\"><tr>"
    buffer ++= "<td width=\"90%\"></td>"
    buffer ++= "<td width=\"10\" height=\"28\"><a href=\"" + strurl + "\" target=\"_blank\"><img src=\"static/images/9.gif\" width=\"76\" height=\"17\"  border = \"0\" alt=\"查看更多...\"/></a></td>"
    buffer ++= "</tr></table>"
  }
}
