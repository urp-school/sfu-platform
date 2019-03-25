package net.openurp.sfu.platform.portal.web.action

import org.beangle.commons.codec.digest.Digests
import org.beangle.commons.collection.Collections
import org.beangle.data.dao.{ EntityDao, OqlBuilder }
import org.beangle.security.context.SecurityContext
import org.beangle.security.realm.cas.CasConfig
import org.beangle.security.session.Session
import org.beangle.security.web.authc.WebClient
import org.beangle.webmvc.api.context.ActionContext
import org.beangle.webmvc.api.view.View
import org.openurp.app.Urp
import org.openurp.app.security.Securities
import org.openurp.platform.config.model.App
import org.openurp.platform.security.model.FuncPermission
import org.openurp.platform.user.model.{ Root, User }
import org.openurp.platform.user.service.UserService

import net.openurp.sfu.platform.info.NewsCrawler2

/**
 * @author chaostone
 */
class IndexAction extends BaseAction {

  var config: CasConfig = _

  var newsCrawler: NewsCrawler2 = _

  var userService: UserService = _

  var entityDao: EntityDao = _

  override def index(): View = {
    super.index()
    val session = SecurityContext.session
    profile(session)
    request.getServletContext.setAttribute("static_base", System.getProperty("static_base"))
    put("client", WebClient.get(ActionContext.current.request))
    put("webappBase", Urp.webappBase)
    val user = getUser
    val apps = entityDao.search(OqlBuilder.from[App](classOf[FuncPermission].getName, "fp").join("fp.role.members", "m")
      .where("m.user=:user and m.member=true", user)
      .where("fp.resource.app.enabled=true")
      .where("fp.resource.app.appType='web-app'")
      .select("distinct fp.resource.app").cacheable(true))

    val rootsQuery = OqlBuilder.from(classOf[Root], "root")
      .where("root.user=:user and root.app.enabled=true and root.app.appType='web-app'", user)
      .cacheable()
    val roots = entityDao.search(rootsQuery)
    val allApps = Collections.newSet[App]
    allApps ++= apps
    allApps ++= roots.map(_.app)
    allApps.dropWhile(_.domain.name.startsWith("platform"))
    put("apps", allApps)
    put("news", newsCrawler.getNews)
    put("newsite", newsCrawler.newsite)
    put("noticesite", newsCrawler.noticesite)
    put("notices", newsCrawler.getNotices())
    forward()
  }

  def logout(): View = {
    redirect(to(config.casServer + "/logout"), null)
  }

  private def profile(session: Session): Unit = {
    val photoUrl = "http://service.urp.sfu.edu.cn/sns/photo/" + Digests.md5Hex(session.principal.getName + "@sfu.edu.cn") + ".jpg"
    put("photoUrl", photoUrl)
  }

  private def getUser: User = {
    val userCode = Securities.user
    userService.get(userCode).get
  }

}