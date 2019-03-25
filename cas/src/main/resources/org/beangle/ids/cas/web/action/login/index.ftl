<!DOCTYPE html>
<head>
<TITLE>欢迎访问上海立信会计金融学院教学管理系统平台</TITLE>
<link href="${base}/static/css/default.css" rel="stylesheet" type="text/css" />
</head>

<body onload="document.getElementById('username').focus();">
<table width="1000px"  height="84" border="0" align="center" cellpadding="0" cellspacing="0" background="${base}/static/images/loginbanner.jpg">
  <tr>
    <td width="20%" align="center"> </td>
    <td align="center"></td>
    <td width="20%" align="center"><img src="${base}/static/images/blank.gif" width="1" height="1" /></td>
  </tr>
</table>

<table width="1000px" border="0" align="center" bgcolor="#F1F1F1">
  <tr>
    <td style="width:240px" valign="top">
     <table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="36"><img src="${base}/static/images/01-titleleft.jpg" width="36" height="41" /></td>
        <td background="${base}/static/images/01-titlemiddle.jpg" style="color: #FFFFFF;font-size: 13px;font-weight:bold;">用户登录</td>
        <td width="10"><img src="${base}/static/images/01-titleright.jpg" width="21" height="41" /></td>
      </tr>
      <tr>
        <td></td>
        <td align="center" style="font-size: 13;color: #FF0000;font-weight:bold;">${error!}</td>
        <td></td>
      </tr>
    </table>

   <table border="0" align="center">
    <tr>
    <td></td>
    <td>
    <form method="post" name="login_form" action="${base}/login">
	[#if Parameters['service']??]
	 <input type="hidden" name="service" value="${Parameters['service']}">
	[/#if]
	[#if Parameters['sid_name']??]
	 <input type="hidden" name="sid_name" value="${Parameters['sid_name']}">
	[/#if]
     <table border="0" align="center" cellpadding="1" cellspacing="2">
     <tr>
      <td rowspan="2"><img src="${base}/static/images/logo.jpg" alt="统一身份认证Logo,凡有此小钥匙标记的页面皆可使用学校信息平台的账号和密码登录" longdesc="凡有此小钥匙标记的页面皆可使用学校信息平台的账号和密码登录" /></td>
      <td align="right"><nobr>用户名：</nobr></td>
      <td><input size="12" value="${Parameters['username']!}" id="username" name="username" maxlength="25" type="text" class="input_text" style="width:100px;height:18px" tabindex="1" /></td>
     </tr>
     <tr>
      <td align="right"><nobr>密&nbsp;&nbsp;&nbsp;&nbsp;码：</nobr></td>
      <td><input size="12" value="" name="password" type="password" class="input_text" style="width:100px;height:18px" tabindex="2" /></td>
     </tr>
     <tr>
      <td colspan="3" align="center">
          <input name="Submit" type="submit" value="登&nbsp;&nbsp;录">
          <input type="submit" name="Submit2" value="重&nbsp;&nbsp;置" onClick="javascript:document.forms[0].reset(); return false;"/>
      </td>
     </tr>
    </table>
      </form>

     </td>
     <td >&nbsp;</td>
    </tr>
    </table>
    
    
    <table width="100%" cellspacing="0" cellpadding="0" border="0">
        <tbody><tr>
          <td width="11"></td>
          <td><b>登录提示</b></td>
          <td width="10"></td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td class="text">
		          <table width="90%" cellspacing="0" cellpadding="0" border="0">
		        <tbody><tr>
			        <td height="35"><span class="STYLE1">1、教职工：使用新工号（8位）和数字校园密码（同OA密码）。</span></td>
			        <td>&nbsp;</td>
		        </tr>
		        <tr>
			        <td height="35"><span class="STYLE1">2、学生：用户名为学号，密码为数字校园密码（同无线上网密码），若未修改，初始密码为身份证后六位(后六位若有字符为大写字符)。</span></td>
			        <td>&nbsp;</td>
		        </tr>
		        <tr>
			        <td height="35">
			            <span class="STYLE1">3、使用中遇到的问题，查看<a target="_blank" href="http://jwc.lixin.edu.cn/tzgg/58454.htm"><U>密码修改说明</U></a>。
			        </span></td>
			        <td>&nbsp;</td>
		        </tr>
		        <tr>
		          <td height="11"></td>
		          <td>&nbsp;</td>
		        </tr>
		      </tbody></table>
      
          </td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td height="6"></td>
          <td></td>
          <td></td>
        </tr>
      </tbody></table>
      
      
    
    </td>
    <td valign="top">
     <IFRAME src="${base}/news" id="" width="100%" height="400px" name="" scrolling="no" frameborder="0" marginwidth="0" allowTransparency="true"></IFRAME>
    </td>
  </tr>
</table>
<table width="1000px" border="0" align="center" cellpadding="0" cellspacing="0" class="fontsize_10_linehi12"  bgcolor="#F1F1F1">
  <tr>
    <td align="center" height="28">
        <img src="${base}/static/images/bottom_line.jpg" width="982" height="7" />
    </td>
  </tr>
    <tr>
        <td valign="middle" height="20">
            <div class="STYLE1" align="center">上海立信会计金融学院 Copyright &copy; 2007 Allright Reserved&nbsp;&nbsp;|&nbsp;&nbsp;<a href="mailto:meduc@shfc.edu.cn" target="_blank">联系我们</a>&nbsp;&nbsp;|&nbsp;&nbsp;<a href="http://www.miibeian.gov.cn/" target="_blank">沪ICP备05052064号</a>
      </div>
    </td>
  </tr>
    <tr>
    <td valign="middle" height="20">
            <div class="STYLE1" align="center"> 院址：上海上川路995号&nbsp;&nbsp;邮编：201209&nbsp;&nbsp;&nbsp;|&nbsp;&nbsp;&nbsp;总机：021-50218899&nbsp;&nbsp;院办：021-50218814&nbsp;&nbsp;招办：021-50218552 <br />
      </div>
    </td>
    </tr>
</table>
</body>
</html>