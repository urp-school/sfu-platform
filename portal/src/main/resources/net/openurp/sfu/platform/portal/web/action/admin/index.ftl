[#include "../common/lib.ftl"/]

[@head/]
[#include "../common/top.ftl"/]
[#include "../common/nav.ftl"/]

<div style="width:1000px;margin:auto">
<table width="100%"><tbody><tr><td style="background-color: #FFFFFF">

<div style="float: left ;  width:20%; "  >
  <table >
     <tbody>
       <tr>
         <td><img class="MenuImage"  src="${static_base}/images/app/id.jpg"></td>
         <td class="TabFont"><a href='javascript:void(0)' onclick="loadSite('${base}/admin/id')">身份管理</a></td>
       </tr>
       [#--
       <tr>
         <td><img class="MenuImage"  src="${static_base}/images/app/website.jpg"></td>
         <td class="TabFont"><a href='javascript:void(0)' onclick="loadSite('${base}/admin/content')">网站管理</a></td>
       </tr>

       <tr>
         <td><img class="MenuImage"  src="${static_base}/images/app/security.jpg"></td>
         <td class="TabFont"><a href='javascript:void(0)' onclick="loadSite('${base}/admin/security')">会话</a></td>
       </tr>
       <tr>
         <td><img class="MenuImage"  src="${static_base}/images/app/datacenter.jpg"></td>
         <td class="TabFont"><a href='javascript:void(0)' onclick="loadSite('${base}/admin/datacenter')">数据中心管理</a></td>
       </tr>
       --]
      </tbody>
    </table>
</div>

<div style="float: right ;  width:80%; " id="admin_content" >
</div>

</td></tr></tbody></table>
</div>

[@foot]
<script>
var contextPath="${base}"
</script>
<script src="${static_base}/scripts/default.js" type="text/javascript" language="JavaScript"></script>
<script src="${static_base}/scripts/jquery.min-2.0.0.js" type="text/javascript" language="JavaScript"></script>
<script>
function loadSite(url){
 var target="#admin_content"
 jQuery.ajax({
        url: url,cache:false,
        type: "GET",dataType: "html",
        complete: function(jqXHR) {
          jQuery(target).html(jqXHR.responseText);
        }
      });
}
loadSite('${base}/admin/id')
</script>
[/@]