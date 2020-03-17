<%@ page language="java" pageEncoding="gb2312" contentType="text/html; charset=gb2312"%>
<%@ include file="tools.jsp" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String superTypeId = request.getParameter("superTypeId");	
String subTypeId=request.getParameter("subTypeId"); 
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加品牌</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
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
		function sendSubRequest(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = showSub;
			req.open("get",url,true);
			req.send(null);
		}
		function showSuper() {
			var superid="<%=superTypeId%>";
			if(req.readyState == 4) {
				if(req.status == 200) {
					var superTypeXml = req.responseXML;
					var superTypes = superTypeXml.getElementsByTagName("super");
					var superTypeId = document.getElementById("superTypeId");
					var superType;
					if(superTypes.length > 0) {
						for(var i=0;i<superTypes.length;i++) {
							superType=superTypes[0].getElementsByTagName("superId").item(0).firstChild.data;
							var superId = superTypes[i].getElementsByTagName("superId").item(0).firstChild.data;
							var superName = superTypes[i].getElementsByTagName("superName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",superId);
							var txt = document.createTextNode(superName);
							op.appendChild(txt);
							superTypeId.appendChild(op);
							superTypeId.style.width = "auto";
						}
						<%
							if(!"".equals(superTypeId) && superTypeId!=null){
						%>
							document.getElementById("superTypeId").value=superid;
							sendSubRequest("getSubTypeBySuperTypeId?superTypeId="+superid);
						<%
							}else{
						%>
							sendSubRequest("getSubTypeBySuperTypeId?superTypeId="+superType);
						<%
							}
						%>
					} else {
						typeDiv.innerHTML = "还没有大类";
					}
				}
			}
		}
		
		function getSubType(){
			var superTypeId=document.getElementById("superTypeId").value;
			var subTypeId = document.getElementById("subTypeId");
			subTypeId.length=0;
			sendSubRequest("getSubTypeBySuperTypeId?superTypeId="+superTypeId);
		}
		
		function showSub() {
			var subid="<%=subTypeId%>";
			if(req.readyState == 4) {
				if(req.status == 200) {
					var subTypeXml = req.responseXML;
					var subTypes = subTypeXml.getElementsByTagName("subType");
					var subTypeId = document.getElementById("subTypeId");
					if(subTypes.length > 0) {
						for(var i=0;i<subTypes.length;i++) {
							var subId = subTypes[i].getElementsByTagName("subTypeId").item(0).firstChild.data;
							var subName = subTypes[i].getElementsByTagName("subTypeName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",subId);
							var txt = document.createTextNode(subName);
							op.appendChild(txt);
							subTypeId.appendChild(op);
							subTypeId.style.width = "auto";
						}
						<%
							if(!"".equals(subTypeId) && subTypeId!=null){
						%>
								document.getElementById("subTypeId").value=subid;
						<%
							}
						%>
					} else {
						typeDiv.innerHTML = "还没有小类";
					}
				}
			}
		}
		
		function checkSubTypeName() {
			var subTypeName = document.getElementById("subTypeName");
			var brandDiv = document.getElementById("brandDiv");
			if(subTypeName.value == "") {
				brandDiv.innerHTML = "小类名不能为空";
			} else {
				checkSubTypeNameIsExist();
			}
		}
		function checkSubTypeNameIsExist() {
			var subTypeName = document.getElementById("subTypeName");
			var url = "checkSubTypeIsExist?subTypeName="+subTypeName.value;
			sendSubTypeName(url);
		}
		function sendSubTypeName(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = subTypeNameIsExist;
			req.open("get",url,true);
			req.send(null);
		}
		var subTypeName_IsExist;
		
		function subTypeNameIsExist() {
			if(req.readyState == 4) {
				if(req.status == 200) {
					var returnXml = req.responseXML;
					var brandDiv = document.getElementById("brandDiv");
					var state = returnXml.getElementsByTagName("state")[0].firstChild.data;
					var content = returnXml.getElementsByTagName("content")[0].firstChild.data;
					if(state == "true") {
						subTypeName_IsExist = true;
					} else {
						subTypeName_IsExist = false;
					}
					brandDiv.innerHTML = content;
				}
			}
		}
		
		function addBrand() {
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
		
		/**
		 * 点击类型按钮时切换选项的禁用状态
		 */
		function radioClicked(n)
		{
		  document.forms['theForm'].elements["attrValues"].disabled = n > 0 ? false : true;
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
		
		function removeBrand(pageOffset,pageSize) {
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
				+pageOffset+"&pageSize="+pageSize+"&type=brand";
			dform.submit();
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
		<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
    	<tr>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">小类ID</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">品牌ID</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">品牌名称</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"><input type="checkbox" id="selectAll" onclick="selectAll()">全/反选</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"></th>
    	</tr>
    	<form method="post" id="deleteForm" name="deleteForm">
	    	<c:forEach var="brand" items="${brandList}">
	    		<tr align="center">
	    			<td bgcolor="#FFFFFF" class="STYLE2">${brand.subtypeid}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${brand.brandid}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${brand.brandname}</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><input type="checkbox" name="delete" value="${brand.brandid }"></td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><a href="getOneBrandServlet?id=${brand.brandid}">详情</a></td>
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
    			<pg:pager items="${brandPager.totalNum }" maxPageItems="${brandPager.pageSize}"
    				 export="currentPageNo = pageNumber" url="Admin/controller/brandController.jsp">
			         <pg:param name="pageSize" value="${brandPager.pageSize }"/>
			         <pg:param name="pageNo" value="${currentPageNo}"/> 
			         <pg:first>
			            <a href="${pageUrl}"><img src="Admin/images/first.gif" border="0"></a>
			         </pg:first>
			         <pg:prev>
			            <a href="${pageUrl}"><img src="Admin/images/back.gif" border="0" /></a>
			         </pg:prev>
			         <pg:pages>
				         <c:choose>
				            <c:when test="${brandPager.pagecurrentPageNo eq pageNumber}">
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
    		<input type="button" value="删除" onclick="removeBrand(${brandPager.pageOffset},${brandPager.pageSize})">
    		</td>
        <td width="14"><img src="Admin/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</td>
</tr>
	<form id="addForm" action="addBrandServlet" method="post" name="theForm">
    <table id="t2" align="center">
		<tr>
			<td align="left">
			所属类:<select name="superTypeId" onchange="getSubType()">
					<c:forEach var="superType" items="${superTypes }">
						<option value="${superType.superTypeId }">${superType.typeName}</option>
					</c:forEach>
					</select>
			</td>
			<td align="left">
				小类名称:<select name="subTypeId">
					<c:forEach var="subType" items="${superTypes }">
						<option value="${superType.superTypeId }">${superType.typeName}</option>
					</c:forEach>
					</select>
			</td>
			<td align="left">
				品牌名称：<input type="text" id="brandName" name="brandName" />
			</td>
			<td  align="center">
				<input type="button" value="添加" onclick="addBrand()"/><font color="red">${message}</font>
			    <div id="brandDiv"></div>
			</td>
		</tr>
	</table>
	</form>
</table>
  </body>
</html>