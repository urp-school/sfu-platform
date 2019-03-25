[#include "../common/lib.ftl"/]

[@head/]
[#include "../common/top.ftl"/]
[#include "../common/nav.ftl"/]

<div style="width:1000px;margin:auto">
<table width="100%"><tbody><tr><td style="background-color: #FFFFFF">

<div style="float: left ;  width:25%; "  >
  [#include "tools.ftl"/]
  [#include "staff.ftl"/]
  [#include "download.ftl"/]
</div>

<div style="float: left ;  width:45%; "  >
  [#include "notices.ftl"/]
  [#include "documents.ftl"/]
  [#include "secret.ftl"/]
</div>

<div style="float: right ;  width:30%; "  >
  [#include "financial.ftl"/]
  [#include "service-guide.ftl"/]
  [#include "archives.ftl"/]
</div>


</td></tr></tbody></table>
</div>


[@foot]
<script>
var contextPath="${base}"
</script>
<script src="${static_base}/scripts/default.js" type="text/javascript" language="JavaScript"></script>
[/@]