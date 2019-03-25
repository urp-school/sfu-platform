package net.openurp.sfu.platform.portal.web.action

import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.security.context.SecurityContext
import org.beangle.webmvc.api.view.View
import org.beangle.security.realm.cas.CasConfig
import org.openurp.app.Urp

/**
 * @author chaostone
 */
class AdminAction extends BaseAction {

  var casConfig: CasConfig = _

  def content(): View = {
    put("user", SecurityContext.session.principal)
    forward()
  }

  def security(): View = {
     put("urp", Urp)
    put("user", SecurityContext.session.principal)
    forward()
  }

  def datacenter(): View = {
    put("user", SecurityContext.session.principal)
    forward()
  }

  def id(): View = {
    put("urp", Urp)
    put("casConfig",casConfig)
    put("user", SecurityContext.session.principal)
    forward()
  }
}