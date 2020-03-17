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
    
    <title>商户管理</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/tab.css">
	
	<script type="text/javascript">
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
		
		function removeMerchants(pageOffset,pageSize) {
			var deletes = document.getElementsByName("delete");
			var count = 0;
			var users = new Array();
			for(var i = 0;i<deletes.length;i++) {
				if(deletes[i].checked) {
					count++;
					users.push(deletes[i].value);
				}
			}
			if(count == 0) {
				alert("还没有选中删除项");
				return false;
			}
			var oform = document.getElementsByTagName("form")[0];
			oform.action = "deleteMerchantServlet?merchantIds="+users+"&pageOffset="+pageOffset+"&pageSize="+pageSize;
			oform.submit();
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
	<table width="99%" border="0" align="center" cellpadding="0" cellspacing="1" bgcolor="#c0de98" >
    	<tr>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">商户ID</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">商户名</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">联系方式</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1">邮箱</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"><input type="checkbox" id="selectAll" onclick="selectAll()">全/反选</th>
    		<th background="Admin/images/tab_14.gif" class="STYLE1"></th>
    	</tr>
    	<form method="post" name="deleteForm">
	    	<c:forEach var="merchant" items="${merchantList}">
	    		<tr align="center">
	    			<td bgcolor="#FFFFFF" class="STYLE2">${merchant.id }</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${merchant.name }</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${merchant.mobile }</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2">${merchant.email }</td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><input type="checkbox" name="delete" value="${merchant.id }"></td>
	    			<td bgcolor="#FFFFFF" class="STYLE2"><a href="getOneMerchantServlet?id=${merchant.id}">详情</a></td>
	    		</tr>
	    	</c:forEach>
    	</form>
    </table>
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
           <td align="center">
    			<pg:pager items="${merchantPager.totalNum }" maxPageItems="${merchantPager.pageSize}" export="currentPageNo = pageNumber" url="getUserPagerServlet">
			         <pg:param name="pageSize" value="${merchantPager.pageSize }"/>
			         <pg:param name="pageNo" value="${currentPageNo}"/> 
			         <pg:first>
			            <a href="${pageUrl}"><img src="Admin/images/first.gif" border="0"></a>
			         </pg:first>
			         <pg:prev>
			            <a href="${pageUrl}"><img src="Admin/images/back.gif" border="0" /></a>
			         </pg:prev>
			         <pg:pages>
				         <c:choose>
				            <c:when test="${merchantPager.pagecurrentPageNo eq pageNumber}">
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
    		<input type="button" value="删除" onclick="removeMerchants(${merchantPager.pageOffset},${merchantPager.pageSize})">
    		</td>
        <td width="14"><img src="Admin/images/tab_22.gif" width="14" height="29" /></td>
      </tr>
    </table></td>
  </tr>
</table>
</td>
</tr>
</table>
  </body>
</html>


    	
    	
    	
    	