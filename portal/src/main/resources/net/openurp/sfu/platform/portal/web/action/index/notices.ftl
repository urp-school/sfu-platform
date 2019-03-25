<div class="nju-5" id="portlet_pane_P-12860be1483-10001">
            <table width="100%" cellspacing="0" cellpadding="0" border="0">
            <tbody><tr><td>
<table width="100%" cellspacing="0" cellpadding="0" border="0" class="PTableBack" id="portlet_title_P-12860be1483-10001">
  <tbody><tr>
          <td class="PTitleLeft"></td>
           <td valign="middle" align="left" class="PTitle" onclick="changesrc('P-12860be1483-10001_1','P-12860be1483-10001','1','2')" id="P-12860be1483-10001_1" style="cursor:hand">
                    校内公告
                </td>
            <td class="PM"></td>
           <td valign="middle" align="left" class="PTitleL" onclick="changesrc('P-12860be1483-10001_2','P-12860be1483-10001','2','2')" id="P-12860be1483-10001_2" style="cursor:hand">
                    校内新闻
                </td>
            <td class="PTitleRightBack"></td>
      <td nowrap="true" align="right">
<img width="1" height="1" src="${base}/static/images/blank.gif">
  </td>
      <td align="right" class="PTitleRight"></td>
          </tr>
</tbody></table>

 <table width="100%" cellspacing="0" cellpadding="0" border="0" id="portlet_content_P-12860be1483-10001">
    <tbody><tr>
                    <td class="PContentLeft"></td>
                <td valign="top" align="left" class="PContent" colspan="2">
  
<table border="0" style="width:100%" style="line-height:17pt" id='P-12860be1483-10001_1_content'>
        <tbody>
        [#list notices as news]
        <tr height="23">
          <td width="80%">
             <img style="margin-left:10px" src="http://xww.sfu.edu.cn/images/listdot_03.png">
             <a target="_blank" href="${news.href}">${news.title}</a>
          </td>
          <td>
             ${news.date}
            </td>
        </tr>
        [/#list]
        <tr><td colspan="2" align="right"><a title="更多" href="javaScript:var newwin=window.open('${noticesite}')"><img width="41" height="11" border="0" src="${static_base}/images/web/index_15.jpg" id="ext-gen21"></a></td></tr>
    </tbody></table>
    
<table style="display:none;width:100%" border="0" style="line-height:17pt" id='P-12860be1483-10001_2_content'>
        <tbody>
        [#list news as news]
        <tr height="23">
          <td width="80%">
             <img style="margin-left:10px" src="http://xww.sfu.edu.cn/images/listdot_03.png">
             <a target="_blank" href="${news.href}">${news.title}</a>
          </td>
          <td>${news.date} </td>
        </tr>
        [/#list]
        <tr><td colspan="2" align="right"><a title="更多" href="javaScript:var newwin=window.open('${newsite}')"><img width="41" height="11" border="0" src="${static_base}/images/web/index_15.jpg" id="ext-gen21"></a></td></tr>
    </tbody></table>

        </td>
                    <td nowrap="true" style="font-size:1pt;" class="PContentRight">&nbsp;</td>
            </tr>
</tbody></table>
<table width="100%" cellspacing="0" cellpadding="0" border="0" id="portlet_bottom_P-12860be1483-10001">
    <tbody><tr>
        <td class="PBottomLeft"></td>
        <td nowrap="true" style="font-size:1pt;" class="PBottom">&nbsp;</td>
        <td class="PBottomRight"></td>
    </tr>
</tbody></table>
  </td></tr>
</tbody></table>
</div>