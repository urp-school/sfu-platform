package net.openurp.sfu.platform.cas.web.action

import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.annotation.action
import org.beangle.cache.CacheManager
import org.beangle.webmvc.api.util.CacheControl
import org.beangle.webmvc.api.view.View
import net.openurp.sfu.platform.info.NewsCrawler

/**
 * @author chaostone
 */
@action("news")
class NewsAction(newsCrawler: NewsCrawler) extends ActionSupport {

  def index(): View = {
    put("news", newsCrawler.getNews)
    put("notices", newsCrawler.getNotices)
    CacheControl.expiresAfter(10)
    forward()
  }
}