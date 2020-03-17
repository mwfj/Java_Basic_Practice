<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="tools.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>大类详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<script language="javascript" src="<%=path%>/resource/jquery-1.4.2.min.js"></script>
	
	<script type="text/javascript">
		function modif(){
			document.getElementById("typename").readOnly=false;
			document.getElementById("save").style.display="block";
			document.getElementById("modif").style.display="none";
		}
		function save(){
			var typeName=$("#typename").val();
			var id=$("#typeid").val();
			var param="name="+typeName+"&id="+id+"&type=super";
			$.get("<%=path%>/Admin/controller/updateTypeController.jsp",param,function(data){
				if(data){
					alert("更新成功");
					document.getElementById("typename").readOnly=true;
					document.getElementById("save").style.display="none";
					document.getElementById("modif").style.display="block";
				}
			});
			
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
	<table>
    	<tr>
    		<td>ID</td>
    		<td><input type="text" id="typeid" name="typeid" value="${superType.superTypeId}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>大类名称</td>
    		<td><input type="text" id="typename" name="typename" value="${superType.typeName } " readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" id="modif" value="修改" onclick="modif()"/>
    			<input type="button" id="save" value="保存" onclick="save()" style="display:none"/>
    		</td>
    		<td><a href="Admin/controller/superTypeController.jsp">返回</a></td>
    	</tr>
    </table>
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
