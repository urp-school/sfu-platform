package net.openurp.sfu.platform.cas.web

import org.beangle.cdi.bind.BindModule

import net.openurp.sfu.platform.cas.web.action.NewsAction
import net.openurp.sfu.platform.info.NewsCrawler

/**
 * @author chaostone
 */
class DefaultModule extends BindModule {

  override def binding() {
    bind(classOf[NewsCrawler]).constructor(ref("cache.Caffeine"))
    bind(classOf[NewsAction])
  }
}