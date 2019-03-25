[#assign username=user.name/]
<table class="navbar">
 <tbody>
     <tr width="100%">
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/index/index'] class="active" [/#if]href="${base}/">我的首页</a>&nbsp;</td>
      [#--
      <td class="TabSeperator"></td>
      [#if user.details['category'] == 2 ]
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/study/index'] class="active" [/#if]href="${base}/study">我的学习</a> &nbsp;</td>
      <td class="TabSeperator"></td>
      [#else]
      [#--
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/office/index'] class="active" [/#if]href="${base}/office">我的办公</a> &nbsp;</td>
      <td class="TabSeperator"></td>
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/research/index'] class="active" [/#if]href="${base}/research">我的科研</a>&nbsp;</td>
      <td class="TabSeperator"></td>
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/education/index'] class="active" [/#if]href="${base}/education">我的教学</a> &nbsp;</td>
      <td class="TabSeperator"></td>
      [/#if]
      --]
      <td class="TabSeperator"></td>
      [#if username=='0713' || username=='0876' ||username=='2014004'||username=='center']
      <td valign="middle"  class="TabMiddle">&nbsp;<a [#if self_action =='/admin/index'] class="active" [/#if]href="${base}/admin">管理中心</a> &nbsp;</td>
      <td class="TabSeperator"></td>
      [/#if]
      <td class="TabTail" >&nbsp;</td>
    </tr>
  </tbody>
 </table>
