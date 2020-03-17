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
    
    <title>属性详情</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<script language="javascript" src="<%=path%>/resource/jquery-1.4.2.min.js"></script>
	
	<script type="text/javascript">
		function createXHR(){
			var xhr = null;
			if(window.ActiveXObject){
				xhr = new ActiveXObject("Microsoft.XMLHTTP");
			}else if(window.XMLHttpRequest){
				xhr = new XMLHttpRequest();
			}else{
				alert("can't create xhr object!");
			}
			
			return xhr;
		}
		function modif(){
			document.getElementById("attrtype").readOnly=false;
			document.getElementById("attrname").readOnly=false;
			document.getElementById("attrvalue").disable=false;
			document.getElementById("save").style.display="block";
			document.getElementById("modif").style.display="none";
		}
		function save(){
			var attrName=$("#attrname").val();
			var id=$("#attrid").val();
			var attrType=document.getElementsByName("attrtype");
			for(var i=0;i<attrType.length;i++){
				if(attrType[i].checked==true){
				  attrType=attrType[i].value;
				  break;
				}
		    }
			var attrValue=$("#attrvalue").val();
			var param="name="+attrName+"&id="+id+"&attrType="+attrType+"&attrValue="+attrValue+"&type=attr";
			
			var xhr = createXHR();
			xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					var ret = xhr.responseText;
					if(ret){
						alert("更新成功");
					}
				}
			}
		};
			xhr.open("post", "<%=path%>/Admin/controller/updateTypeController.jsp");
			xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
			xhr.send(param);
		}
		
		function radioClicked(n)
		{
		  document.getElementById("attrvalue").disabled = n > 0 ? false : true;
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
    		<td>小类ID</td>
    		<td><input type="text" id="typeid" name="typeid" value="${attribute.subtypeid}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>属性ID</td>
    		<td><input type="text" id="attrid" name="attrid" value="${attribute.attrid}" readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>属性名称</td>
    		<td><input type="text" id="attrname" name="attrname" value="${attribute.attrname } " readonly="readonly"/></td>
    	</tr>
    	<tr>
    		<td>属性类型</td>
    		<td>
				<input type="radio" name="attrtype" value="0"  ${attribute.attrtype==0?'checked':'' }
					onclick="radioClicked(0)"/>手工录入          
				<input type="radio" name="attrtype" value="1"  ${attribute.attrtype==1?'checked':'' }
					onclick="radioClicked(1)"/>从下面的列表中选择（一行代表一个可选值）
			</td>
    	</tr>
    	<tr>
    		<td>属性值</td>
    		<td><textarea id="attrvalue" name="attrvalue" cols="20" rows="5" disabled="disabled">${attribute.attrvalue }</textarea></td>
    	</tr>
    	<tr>
    		<td>
    			<input type="button" id="modif" value="修改" onclick="modif()"/>
    			<input type="button" id="save" value="保存" onclick="save()" style="display:none"/>
    		</td>
    		<td><a href="Admin/controller/attributeController.jsp">返回</a></td>
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
