[#include "../common/lib.ftl"/]

[@head/]
[#include "../common/top.ftl"/]
[#include "../common/nav.ftl"/]

<div style="width:1000px;margin:auto">
<table width="100%"><tbody><tr><td style="background-color: #FFFFFF">

<div style="float: left ;  width:25%; "  >
  [#include "services.ftl"/]
</div>

<div style="float: left ;  width:45%; "  >
  [#include "../education/system.ftl"/]
</div>

<div style="float: right ;  width:30%; "  >
[#include "info.ftl"/]
</div>


</td></tr></tbody></table>
</div>


[@foot]
<script>
var contextPath="${base}"
</script>
<script src="${static_base}/scripts/default.js" type="text/javascript" language="JavaScript"></script>
[/@]