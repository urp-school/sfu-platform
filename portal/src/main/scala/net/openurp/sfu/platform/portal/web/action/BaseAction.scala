package net.openurp.sfu.platform.portal.web.action

import org.beangle.commons.web.util.CookieUtils
import org.beangle.security.context.SecurityContext
import org.beangle.webmvc.api.action.{ ActionSupport, ServletSupport }
import org.beangle.webmvc.execution.Handler
import org.beangle.webmvc.api.view.View

class BaseAction extends ActionSupport with ServletSupport {

  def index(): View = {
    val session = SecurityContext.session
    put("user", session.principal)
    val theme = CookieUtils.getCookie(request, "theme")
    put("self_action", Handler.mapping.url)
    put("theme", (if (null == theme) "blue" else theme.getValue))
    forward()
  }
}