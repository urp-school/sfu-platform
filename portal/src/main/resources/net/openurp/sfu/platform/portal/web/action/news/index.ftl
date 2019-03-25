<!DOCTYPE html>
<head>
<title></title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<style>
TD {
    font-size: 12px;font-family: Verdana,Arial,Helvetica,sans-serif;
}
a:visited {  color: #000000; text-decoration: none}
a:hover {  color: #ff0000; text-decoration: none}
a:link {  text-decoration: none; color: #07519a;}
</style>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0">
    <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="36"><img src="${base}/static/images/02-titleleft1.jpg" width="36" height="37" /></td>
        <td background="${base}/static/images/02-titlemiddle1.jpg" style="color: #819A95;font-size: 14px;font-weight:bold;">校园新闻</td>
        <td width="17"><img src="${base}/static/images/02-titleright1.jpg" width="17" height="37" /></td>
      </tr>
        <tr>
        <td>&nbsp;</td>
        <td height="150" valign="top"  class="text">
        ${news}
        </td>
        <td>&nbsp;</td>
      </tr>
    </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="36"><img src="${base}/static/images/02-titleleft1.jpg" width="36" height="37" /></td>
        <td background="${base}/static/images/02-titlemiddle1.jpg" style="color: #819A95;font-size: 14px;font-weight:bold;">校园公告</td>
        <td width="17"><img src="${base}/static/images/02-titleright1.jpg" width="17" height="37" /></td>
      </tr>
      <tr>
        <td>&nbsp;</td>
        <td height="150" valign="top"  class="text">
             ${notices}
        </td>
        <td>&nbsp;</td>
      </tr>
      <tr>
        <td height="6"></td>
        <td></td>
        <td></td>
      </tr>
    </table>
</body>
</html>