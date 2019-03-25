package net.openurp.sfu.platform.portal.web.action

import org.beangle.data.dao.EntityDao
import org.beangle.security.realm.cas.CasConfig
import org.beangle.webmvc.api.action.{ ActionSupport, ServletSupport }

class AbstractPortalAction extends ActionSupport with ServletSupport {
  var entityDao: EntityDao = _
  var casConfig: CasConfig = _

}