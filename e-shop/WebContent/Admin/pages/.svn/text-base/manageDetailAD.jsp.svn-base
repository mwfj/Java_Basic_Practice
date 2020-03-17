<%@page import="com.common.ImgUtil"%>
<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="tools.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ImgUtil imgUtil=new ImgUtil();
String imgPath=ImgUtil.imgPath;
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>广告详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<script language="javascript" src="<%=path%>/resource/jquery-1.4.2.min.js"></script>
	
	<script type="text/javascript">
		function modifAD(){
			document.getElementById("description").readOnly=false;
			document.getElementById("beginTime").readOnly=false;
			document.getElementById("endTime").readOnly=false;
			document.getElementById("flag").disabled=false;
			document.getElementById("save").style.display="block";
			document.getElementById("modif").style.display="none";
		}
		function saveAD(){
			document.getElementById("save").style.display="none";
			document.getElementById("modif").style.display="block";
			var oForm = document.getElementsByTagName("form")[0];
			oForm.submit();
		}
	</script>
  </head>
  
  <body>
  	<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="30"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="30"><img src="Admin/images/tab_03.gif" width="15" height="30" /></td>
        <td width="1101" background="Admin/images/tab_05.gif">&nbsp;</td>
        <td width="281" background="Admin/images/tab_05.gif"><table border="0" align="right" cellpadding="0" cellspacing="0">
            <tr>
              <td width="60"><table width="87%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"></div></td>
                    <td class="STYLE1"><div align="center"></div></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"></td>
                  </tr>
              </table></td>
              <td width="60"><table width="90%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"><div align="center"><br></div></td>
                  </tr>
              </table></td>
              <td width="52"><table width="88%" border="0" cellpadding="0" cellspacing="0">
                  <tr>
                    <td class="STYLE1"><div align="center"><br></div></td>
                    <td class="STYLE1"><div align="center"><br></div></td>
                  </tr>
              </table></td>
            </tr>
        </table></td>
        <td width="14"><img src="Admin/images/tab_07.gif" width="14" height="30" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="9" background="Admin/images/tab_12.gif">&nbsp;</td>
        <td bgcolor="#f3ffe3">
<center>
<form action="updateADServlet" method="post" 
  			ENCTYPE="multipart/form-data">
	<table>
    	<tr>
    		<td>广告ID</td>
    		<td><input type="text" id="id" name="id" value="${ad.id}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>广告类型</td>
    		<td>
    			<input type="radio" name="adType" value="0"  ${ad.adtype==0?'checked':'' } 
					onclick="radioClicked(0)" disabled="disabled"/>商品推荐          
				<input type="radio" name="adType" value="1"  ${ad.adtype==1?'checked':'' }
					onclick="radioClicked(1)" disabled="disabled"/>商品促销
    		</td>
    	</tr>
    	<tr>
    		<td>描述</td>
    		<td><textarea id="description" name="description" rows="3" cols="20" readonly="readonly"/>
    				${ad.description}
    			</textarea>
    		</td>
    	</tr>
    	<tr>
    		<td>图片</td>
    		<td><img src="<%=imgPath%>${ad.picture}" width="60"/>
    			<input type="FILE" id="FILE1" name="FILE1"/>
    		</td>
    	</tr>
    	<tr>
    		<td>起始时间</td>
    		<td><input type="text" id="beginTime" name="beginTime" value="${ad.begintime}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>截止时间</td>
    		<td><input type="text" id="endTime" name="endTime" value="${ad.endtime}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>状态</td>
    		<td>
    			<select id="flag" name="flag" disabled="disabled">
					<option value="0" ${ad.flag==0?'selected':''}>0</option>
					<option value="1" ${ad.flag==1?'selected':''}>1</option>
				</select>
    		</td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" id="modif" value="修改" onclick="modifAD()"/>
    			<input type="button" id="save" value="保存" onclick="saveAD()" style="display:none"/>
    		</td>
    		<td><a href="getADPagerServlet">返回</a>&nbsp;<font color="red">${message }</font></td>
    	</tr>
    </table>
    <input type="hidden" id="pricute" name="pricute" value="${ad.picture}" />
 </form>
</center>
		</td>
        <td width="9" background="Admin/images/tab_16.gif">&nbsp;</td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="Admin/images/tab_20.gif" width="15" height="29" /></td>
        <td background="Admin/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
            <td width="25%" height="29" nowrap="nowrap">&nbsp;</td>
            <td width="75%" valign="top" class="STYLE1">&nbsp;</td>
          </tr>
        </table></td>
        <td width="14"><img src="Admin/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
  </body>
</html>
