<%@ page language="java" pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<%@ include file="tools.jsp" %>
<%@ page import="java.net.URLDecoder"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加小类</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="<%=path%>/resource/jquery-1.4.2.min.js"></script>
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<style type="text/css">
		#t2{
		   	height: 150px;
		 	width: 650px;
			text-align: center;
		}
	</style>
	<script type="text/javascript">
		var req;
		function getSuperType() {
			var url = "getSuperType";
			sendRequest(url);
		}
		function sendRequest(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = showSuper;
			req.open("get",url,true);
			req.send(null);
		}
		function showSuper() {
			if(req.readyState == 4) {
				if(req.status == 200) {
					var subTypeXml = req.responseXML;
					var superTypes = subTypeXml.getElementsByTagName("super");
					var superTypeId = document.getElementById("superTypeId");
					var searchSuperType = document.getElementById("searchSuperType");
					if(superTypes.length > 0) {
						for(var i=0;i<superTypes.length;i++) {
							var superId = superTypes[i].getElementsByTagName("superId").item(0).firstChild.data;
							var superName = superTypes[i].getElementsByTagName("superName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",superId);
							var txt = document.createTextNode(superName);
							op.appendChild(txt);
							var sop = document.createElement("option");
							sop.setAttribute("value",superId);
							var txt = document.createTextNode(superName);
							sop.appendChild(txt);
							superTypeId.appendChild(op);
							superTypeId.style.width = "auto";
							searchSuperType.appendChild(sop);
							searchSuperType.style.width = "auto";
						}
					} else {
						typeDiv.innerHTML = "还没有大类";
					}
				}
			}
		}
		function checkSubTypeName() {
			var subTypeName = document.getElementById("subTypeName");
			var subTypeNameDiv = document.getElementById("subTypeNameDiv");
			if(subTypeName.value == "") {
				subTypeNameDiv.innerHTML = "小类名不能为空";
			} else {
				checkSubTypeNameIsExist();
			}
		}
		var subTypeName_IsExist;
		function checkSubTypeNameIsExist() {
			var subTypeName=$("#subTypeName").val();
			var param="subTypeName="+subTypeName;
			$.get('<%=path%>/Admin/controller/checkSubTypeIsExist.jsp',param,function(data){
				try{
			         var data=$.parseJSON(data);             
			       }catch(e){
			         alert(e);
			       }
			       var state=data["STATE"]; 
			       var content=data["CONTENT"];
			       if(state == "true") {
						subTypeName_IsExist = true;
					} else {
						subTypeName_IsExist = false;
					}
					subTypeNameDiv.innerHTML = content;
			});
		}
		
		function addSubType() {
			var oForm = document.getElementById("addForm");
			var subTypeName = document.getElementById("subTypeName");
			var superTypeId = document.getElementsByName("superTypeId")[0];
			var superId;
			for(var i=0;i<superTypeId.length;i++) {
				if(superTypeId[i].selected == true) {
					superId = superTypeId[i].value;
				}
			}
			if(!subTypeName_IsExist) {
				oForm.submit();
			}
		}
		
		function removeSubTypes(pageOffset,pageSize) {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var types = new Array();
			for(var i = 0;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					types.push(deletes[i].value);
				}
			}
			if(count == 0) {
				alert("还没有选中删除项");
				return false;
			}
			var dform = document.getElementById("deleteForm");
			dform.action = "deleteTypeServlet?typeIds="+types+"&pageOffset="
				+pageOffset+"&pageSize="+pageSize+"&type=sub";
			dform.submit();
		}
		function searchSubType(pageOffset,pageSize) {
			var superTypeId = document.getElementById("searchSuperType");
			var searchDiv = document.getElementById("searchDiv");
			var oform = document.getElementById("deleteForm");
			if(superTypeId.value != "") {
				oform.action = "getSubTypeByIdServlet?superTypeId="+superTypeId.value;
				oform.submit();
			} else {
				searchDiv.innerHTML = "请输入关键字";
			}	
		}
		function selectAll() {
			var deletes =document.getElementsByName("delete");
			var selectAll = document.getElementById("selectAll");
			for(var i = 0;i<deletes.length;i++) {
				if(selectAll.checked == true) {
				 	deletes[i].checked = true;
				}
				else {
					deletes[i].checked = false;
				}
			}
		}
	</script>
  </head>
  
  <body onload="getSuperType()">
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
        <div align="left">按大类查询:<select name="searchSuperType">
									<c:forEach var="superType" items="${superTypes }">
										<option value="${superType.superTypeId }">${superType.typeName}</option>
									</c:forEach>
									</select>
								<input type="button" value="查询" onclick="searchSubType(${subTypePager.pageOffset},${subTypePager.pageSize})">
								<div id="searchDiv" style="display: inline"></div>
	    </div>
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
    	<tr>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">大类ID</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">小类ID</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">小类名称</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"><input type="checkbox" id="selectAll" onclick="selectAll()">全/反选</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"></th>
    	</tr>
    	<form method="post" id="deleteForm" name="deleteForm">
	    	<c:forEach var="subType" items="${subTypeList}">
	    		<tr align="center">
	    			<td bgcolor="#FFFFFF" class="STYLE2">${subType.superTypeId}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${subType.subTypeId}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${subType.typeName}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><input type="checkbox" name="delete" value="${subType.subTypeId }"></td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><a href="getOneSubTypeServlet?id=${subType.subTypeId}">详情</a></td>
	    		</tr>
	    	</c:forEach>
    	</form>
     </table>	
     	</td>
     	<td width="9" background="Admin/images/tab_16.gif">&nbsp;</td>
     	</tr>
     	</table>
     </td>
  </tr>
    <tr>
    <td height="29"><table width="100%" border="0" cellspacing="0" cellpadding="0">
      <tr>
        <td width="15" height="29"><img src="Admin/images/tab_20.gif" width="15" height="29" /></td>
        <td background="Admin/images/tab_21.gif"><table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr>
           <td align="center">
    			<pg:pager items="${subTypePager.totalNum }" maxPageItems="${subTypePager.pageSize}"
    				 export="currentPageNo = pageNumber" url="Admin/controller/subTypeController.jsp">
			         <pg:param name="pageSize" value="${subTypePager.pageSize }"/>
			         <pg:param name="pageNo" value="${currentPageNo}"/> 
			         <pg:first>
			            <a href="${pageUrl}"><img src="Admin/images/first.gif" border="0"></a>
			         </pg:first>
			         <pg:prev>
			            <a href="${pageUrl}"><img src="Admin/images/back.gif" border="0" /></a>
			         </pg:prev>
			         <pg:pages>
				         <c:choose>
				            <c:when test="${subTypePager.pagecurrentPageNo eq pageNumber}">
				              <font color="red">${pageNumber}</font>
				            </c:when>
				            <c:otherwise>
				            <a href="${pageUrl}">${pageNumber}</a>
				            </c:otherwise>
				         </c:choose>
			         </pg:pages>
			         <pg:next>
			            <a href="${pageUrl}"><img src="Admin/images/next.gif" border="0"/></a>
			         </pg:next>
			         <pg:last>
			            <a href="${pageUrl}"><img src="Admin/images/last.gif" border="0"/></a>
			         </pg:last>
			      </pg:pager>
    		</td>
    		<td colspan="1" align="right">
    		<input type="button" value="删除" onclick="removeSubTypes(${subTypePager.pageOffset},${subTypePager.pageSize})">
    		</td>
        <td width="14"><img src="Admin/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</td>
</tr>
 	<form id="addForm" action="addSubTypeServlet" method="post" name="theForm">
    <table id="t2" align="center">
    	<tr>
			<td align="left">
			所属类:<select name="superTypeId">
					<c:forEach var="superType" items="${superTypes }">
						<option value="${superType.superTypeId }">${superType.typeName}</option>
					</c:forEach>
					</select>
			</td>
			<td align="left">
				小类名称:<input type="text" id="subTypeName" name="subTypeName" onblur="checkSubTypeName()"/>
			</td>
			<td  align="left">
				<input type="button" value="添加" onclick="addSubType()"/><font color="red">${message}</font>
			    <div id="subTypeNameDiv"></div>
			</td>
		</tr>
	</table>
	</form>

</table>
  </body>
</html>