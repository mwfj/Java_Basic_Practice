<%@ page language="java" pageEncoding="GBK"%>
<%@ include file="tools.jsp" %>
<%@page import="com.Admin.dao.AdminProdDao"%>
<%@page import="com.Admin.daoimpl.AdminProdDaoImpl"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
AdminProdDao adminProdDao=new AdminProdDaoImpl();
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加商品</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script language="javascript" src="<%=path%>/resource/jquery-1.4.2.min.js"></script>
	<script type="text/javascript">
		var req;
		function getSuperType() {
			var url = "getSuperType";
			sendSuperTypeRequest(url);
		}
		function sendSuperTypeRequest(url) {
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
					if(superTypes.length > 0) {
						for(var i=0;i<superTypes.length;i++) {
							var superId = superTypes[i].getElementsByTagName("superId").item(0).firstChild.data;
							var superName = superTypes[i].getElementsByTagName("superName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",superId);
							var txt = document.createTextNode(superName);
							op.appendChild(txt);
							superTypeId.appendChild(op);
							superTypeId.style.width = "auto";
						}
					} else {
						typeDiv.innerHTML = "还没有大类";
					}
				}
			}
		}
		//得到小类
		function getSubType() {
			var id;
			var superType = document.getElementById("superTypeId");
			for(var i=0;i<superType.options.length;i++) {
				if(superType.options[i].selected) {
					id = superType.options[i].value;
				}
			}
			var url = "getSubTypeBySuperTypeId?superTypeId="+id;
			sendRequest(url);
		}
		function sendRequest(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = showSub;
			req.open("get",url,true);
			req.send(null);
		}
		function clearSubType() {
			 var subType = document.getElementById("subTypeId");
			 for(var i = subType.options.length - 1;i>=0;i--) {
			 	subType.options[i].parentNode.removeChild(subType.options[i]);
			 }
			 subType.style.width = "";
		}
		function showSub() {
			if(req.readyState == 4) {
				if(req.status == 200) {
					var subTypeXml = req.responseXML;
					clearSubType();
					var subTypes = subTypeXml.getElementsByTagName("subType");
					var subType = document.getElementById("subTypeId");
					var typeDiv = document.getElementById("typeDiv");
					if(subTypes.length > 0) {
						for(var i=0;i<subTypes.length;i++) {
							var subTypeId = subTypes[i].getElementsByTagName("subTypeId").item(0).firstChild.data;
							var subTypeName = subTypes[i].getElementsByTagName("subTypeName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",subTypeId);
							var txt = document.createTextNode(subTypeName);
							op.appendChild(txt);
							subType.appendChild(op);
							subType.style.width = "auto";
							typeDiv.innerHTML = "√";
						}
						getBrand();
					} else {
						typeDiv.innerHTML = "*";
					}
				}
			}
			//getAttr();
		}
		function getBrand(){
		getAttr();
			var id;
			var subType = document.getElementById("subTypeId");
			for(var i=0;i<subType.options.length;i++) {
				if(subType.options[i].selected) {
					id = subType.options[i].value;
				}
			}
			var url = "getBrandBySubTypeId?subTypeId="+id;
			sendBrandRequest(url);
			
		}
		function sendBrandRequest(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = showBrand;
			req.open("get",url,true);
			req.send(null);
		}
		function showBrand(){
			if(req.readyState == 4) {
				if(req.status == 200) {
					var subTypeXml = req.responseXML;
					clearBrandType();
					var brands = subTypeXml.getElementsByTagName("brand");
					var brand = document.getElementById("brandId");
					var typeDiv = document.getElementById("typeDiv");
					if(brands.length > 0) {
						for(var i=0;i<brands.length;i++) {
							var brandId = brands[i].getElementsByTagName("brandId").item(0).firstChild.data;
							var brandName = brands[i].getElementsByTagName("brandName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",brandId);
							var txt = document.createTextNode(brandName);
							op.appendChild(txt);
							brand.appendChild(op);
							brand.style.width = "auto";
							brandDiv.innerHTML = "√";
						}
					} else {
						brandDiv.innerHTML = "*";
					}
				}
			}
			
		}
		//显示商品属性
		function getAttr(){
			var rowIndex=document.getElementById("addButton").rowIndex;
			 if(rowIndex>10){
			 	for(var i=10 ;i<rowIndex;i++){
			 		document.getElementById("prodTable").deleteRow(10);
			 	}
			 }
			var subtypeId=document.getElementById("subTypeId").value;
			var param="subTypeId="+subtypeId;
			var attrValues="";
			$.get('<%=path%>/Admin/controller/getAttrBySubTypeId.jsp',param,function(data){
				if(data!=null){
					var dataObj = $.parseJSON(data);
					for(var i = 0; i < dataObj.length; i++){
						var proAttr = dataObj[i];
						var newRow = document.getElementById("prodTable").insertRow(10);
						newRow.insertCell().innerHTML = proAttr.attrName;
						if(proAttr.attrType == 0){
							var txt = '<input type="text" name='+proAttr.attrId+ ' id='+proAttr.attrId+' />';
							newRow.insertCell().innerHTML = txt;
						} else {
							var valArr = proAttr.attrValue.split(/\s/);
							var selStr = '<select name='+proAttr.attrId+ ' id='+proAttr.attrId+'>';
							for(var j = 0; j < valArr.length; j++){
								selStr += '<option value="'+valArr[j]+'">'+valArr[j]+'</option>';
							}
							selStr += '</select>';
							newRow.insertCell().innerHTML = selStr;
						}
						newRow.insertCell().innerHTML = '';
						attrValues+=proAttr.attrId+",";
					}
					document.getElementById("attrs").value=attrValues;
				}
			});
		}
		function clearBrandType() {
			 var brand = document.getElementById("brandId");
			 for(var i = brand.options.length - 1;i>=0;i--) {
			 	brand.options[i].parentNode.removeChild(brand.options[i]);
			 }
			 brand.style.width = "";
		}
		//检查商品名是否存在
		function checkProdName() {
			var prodName = document.getElementById("prodName");
			var bookNameDiv = document.getElementById("bookNameDiv");
			
			if(prodName.value == "") {
				prodNameDiv.innerHTML = "商品名不能为空";
			} else {
				checkProdNameIsExist();
			}
		}
		
		var prodName_IsExist;
		function checkProdNameIsExist() {
			var prodName = document.getElementById("prodName").value;
			var param="prodName="+prodName;
			$.get('<%=path%>/Admin/controller/checkProdNameIsExist.jsp',param,function(data){
				try{
			         var data=$.parseJSON(data);             
			       }catch(e){
			         alert(e);
			       }
		       var state=data["STATE"]; 
		       var content=data["CONTENT"];
		       if(state == "true") {
					prodName_IsExist = true;
				} else {
					prodName_IsExist = false;
				}
				prodNameDiv.innerHTML = content;
			});
		}
		
		var checkPrice_;
		function checkPrice() {
			var price = document.getElementById("price");
			var priceDiv = document.getElementById("priceDiv");
			var pattern = /^[1-9]\d*([.]\d+||\d*)$/;
			if(price.value == "") {
				priceDiv.innerHTML = "原价不能为空";
				checkPrice_ = false;
			} else if(pattern.test(price.value)) {
				priceDiv.innerHTML = "√";
				checkPrice_ = true;
			} else {
				priceDiv.innerHTML = "原价输入的格式不正确";
				checkPrice_ = false;
			}
		}
		var checkNowPrice_;
		function checkNowPrice() {
			var nowPrice = document.getElementById("nowPrice");
			var nowPriceDiv = document.getElementById("nowPriceDiv");
			var pattern = /^[1-9]\d*([.]\d+||\d*)$/;
			if(nowPrice.value == "") {
				nowPriceDiv.innerHTML = "现价不能为空";
				checkNowPrice_ = false;
			} else if(pattern.test(nowPrice.value)) {
				nowPriceDiv.innerHTML = "√";
				checkNowPrice_ = true;
			} else {
				nowPriceDiv.innerHTML = "现价输入的格式不正确";
				checkNowPrice_ = false;
			}
		}
		var checkProdNum_;
		function checkProdNum() {
			var prodNum = document.getElementById("prodNum");
			var prodNumDiv = document.getElementById("prodNumDiv");
			var pattern = /^[1-9]\d*$/;
			if(prodNum.value == "") {
				prodNumDiv.innerHTML = "数量不能为空";
				checkProdNum_ = false;
			} else if(pattern.test(prodNum.value)) {
				prodNumDiv.innerHTML = "√";
				checkProdNum_ = true;
			} else {
				prodNumDiv.innerHTML = "数量的输入格式不正确";
				checkProdNum_ = false;
			}
		}
		function add() {
			var s1 = document.getElementById("superTypeId");
			var s2 = document.getElementById("subTypeId");
			var typeDiv = document.getElementById("typeDiv");
			if(s1.value == "0" || s2.value == "0" || s2.value == "") {
				typeDiv.innerHTML = "请匹配大类和小类";
			} else if(!prodName_IsExist && checkPrice_ && checkNowPrice_ && checkProdNum_) {
				var oForm = document.getElementsByTagName("form")[0];
				oForm.submit();
			}
		}
	</script>
		
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	<style type="text/css">
		
	select{
			font-size: 12px;
		}
	div {
			color: red;
		}
	#t1{
		 	height: 350px;
		   	width: 649px;
			text-align: center;
		}
	.introduce{
		  vertical-align: top;
		}
		input{
	border: solid 1px #cadcb2;
	}
	</style>
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
			<table id="t1" align="center">
  	<tr><td>
  		<form action="addProdServlet" method="post" 
  			ENCTYPE="multipart/form-data">
    	<table id="prodTable">
    		<tr>
				<td>选择类别:</td>
				<td>大类<select id="superTypeId" name="superTypeId" onchange="getSubType()">
							<option value="0">--选择大类--</option>
							<c:forEach var="superType" items="${superTypes }">
								<option value="${superType.superTypeId }">${superType.typeName }</option>
							</c:forEach>
							</select>
				</td>
				<td>
				小类<select id="subTypeId" name="subTypeId" onchange="getBrand()">
					<option value="0">--选择小类--</option>
					</select>
					</td>
				<td><div id="typeDiv"></div></td>
			</tr>
    		<tr>
				<td>商品名称:</td>
				<td><input type="text" id="prodName" name="prodName" onblur="checkProdName()"/></td>
				<td><div id="prodNameDiv">*</div></td>
			</tr>
			<tr>
				<td >品牌:</td>
				<td><select id="brandId" name="brandId" style="width: 150px">
					<option value="0">-----选择品牌-----</option>
					</select>
				</td>
				<td><div id="brandDiv"></div></td>
			</tr>
			<tr>
    			<td class="introduce">相关介绍:</td>
				<td colspan="2"><textarea rows="3" cols="20" id="introduce" name="introduce"></textarea></td>		
			</tr>
    		<tr>
				<td>原价:</td>
				<td><input type="text" id="price" name="price" onblur="checkPrice()"/></td>
				<td><div id="priceDiv">*</div></td>
			</tr>
    		<tr>
				<td>现价:</td>
				<td><input type="text" id="nowPrice" name="nowPrice" onblur="checkNowPrice()"/></td>
				<td><div id="nowPriceDiv">*</div></td>
			</tr>
    		<tr>
				<td>图片:</td>
				<td colspan="2"><input type="FILE" id="FILE1" name="FILE1"/></td>	
			</tr>
    		<tr>
				<td>数量:</td>
				<td><input type="text" id="prodNum" name="prodNum" onblur="checkProdNum()"/></td>
				<td><div id="prodNumDiv">*</div></td>
			</tr>
			<tr>
				<td>商品来源:</td>
				<td><input type="text" id="origin" name="origin" value="admin" readonly="readonly"/></td>
				<td><div id="">*</div></td>
			</tr>
			<tr id="type">
				<td>类型:</td>
				<td colspan="2"><input type="checkbox" name="hotProds" value="1"/>热卖
					<input type="checkbox" name="newProds" value="1"/>新品
					<input type="checkbox" name="saleProds" value="1"/>特价
					<!-- <input type="checkbox" name="specialProds" value="1"/>特殊产品 -->
				</td>
			</tr>
    		<tr id="addButton">
				<td><input type="button" onclick="add()" value="添加" /></td>
				<td><font color="red">${message }</font></td>
			</tr>
    	</table>
    	<input type="hidden" name="attrs" id="attrs" />
    	</form>
    	<td></tr>
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