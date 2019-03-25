package net.openurp.sfu.platform.portal.web

import org.beangle.cdi.bind.BindModule

import net.openurp.sfu.platform.portal.web.action.{ AdminAction, EducationAction, IndexAction, NewsAction, OfficeAction, PublicAction, ResearchAction, StudentAction, StudyAction }
import net.openurp.sfu.platform.info.NewsCrawler2

/**
 * @author chaostone
 */
class DefaultModule extends BindModule {

  override def binding() {
    bind(classOf[IndexAction])
    bind(classOf[AdminAction], classOf[PublicAction], classOf[EducationAction])
    bind(classOf[OfficeAction], classOf[ResearchAction], classOf[StudyAction], classOf[StudentAction])
    bind(classOf[NewsCrawler2]).constructor(ref("cache.Caffeine"))
    bind(classOf[NewsAction])
  }
}