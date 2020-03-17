<%@ page language="java" pageEncoding="GBK"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>添加广告</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" type="text/css" href="Admin/css/body.css">
	<link rel="stylesheet" type="text/css" href="Admin/css/td_fontSize.css">
	
	<style type="text/css">
		.content {
			 vertical-align: top;
		}
	</style>
	<script type="text/javascript">
		
		function radioClicked(n){
			if(n==0){
				document.getElementById("subTypeTR").style.display="block";
				document.getElementById("prodTR").style.display="block";
				getSubType();
			}else{
				document.getElementById("subTypeTR").style.display="block";
				document.getElementById("prodTR").style.display="none";
				getSubType();
			}
		}
		function getSubType() {
			var url = "getSubTypes";
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
		
		function showSub() {
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
					}
				}
			}
		}
		
		function getProds(){
			var subtypeId=document.getElementById("subTypeId").value;
			var prodId=document.getElementById("productId");
			prodId.length=0;
			var url = "getProdBySubType?subTypeId="+subtypeId;
			sendProdRequest(url);
		}
		
		function sendProdRequest(url) {
			if(window.XMLHttpRequest) {
				req = new XMLHttpRequest();
			} else if(window.ActiveXObject) {
				req = new ActiveXObject("Microsoft.XMLHTTP");
			}
			req.onreadystatechange = showProd;
			req.open("get",url,true);
			req.send(null);
		}
		
		function showProd() {
			if(req.readyState == 4) {
				if(req.status == 200) {
					var productXml = req.responseXML;
					var products = productXml.getElementsByTagName("product");
					var productId = document.getElementById("productId");
					if(products.length > 0) {
						for(var i=0;i<products.length;i++) {
							var prodId = products[i].getElementsByTagName("productId").item(0).firstChild.data;
							var prodName = products[i].getElementsByTagName("productName").item(0).firstChild.data;
							var op = document.createElement("option");
							op.setAttribute("value",prodId);
							var txt = document.createTextNode(prodName);
							op.appendChild(txt);
							productId.appendChild(op);
							productId.style.width = "auto";
						}
					}
				}
			}
		}
		
		function checkBeginTime(){
			var beginTime =document.getElementById("beginTime").value;	
			
		}
		
		function addAD(){
			var addForm = document.getElementById("addForm");
			var adType=document.getElementsByName("adType");
			  for(var i=0;i<adType.length;i++){
				if(adType[i].checked==true){
				  adType=adType[i].value;
				  break;
				}
			  }
			  	addForm.submit();
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
        <td bgcolor="#f3ffe3" align="center">
			


<form id="addForm" action="addADServlet" method="post" ENCTYPE="multipart/form-data">
    <table id="t2">
		<tr>
			<td>广告类型:</td>
			<td>
				<input type="radio" name="adType" value="0"   
					onclick="radioClicked(0)"/>商品推荐          
				<input type="radio" name="adType" value="1"  
					onclick="radioClicked(1)"/>商品促销
			</td>
		</tr>
		<tr id="subTypeTR" style="display: none">
			<td>小类名称:</td>
			<td>
				<select id="subTypeId" name="subTypeId" onchange="getProds()">
					
				</select>
			</td>
		</tr>
		<tr id="prodTR" style="display: none">
			<td>商品名称:</td>
			<td>
				<select id="productId" name="productId">
					
				</select>
			</td>
		</tr>
		<tr>
			<td class="content">描述:</td>
			<td><textarea rows="5" cols="30"  name="adContent"></textarea></td>
		</tr>
		<tr>
			<td class="content">起始时间:</td>
			<td><input type="text" id="beginTime" name="beginTime" ><span style="color: red">（如：2012-1-1）</span></td>
		</tr>
		<tr>
			<td class="content">截止时间:</td>
			<td><input type="text" id="endTime" name="endTime" ><span style="color: red">（如：2012-12-31）</span></td>
		</tr>
		<tr>
			<td>图片:</td>
			<td colspan="2"><input type="FILE" id="FILE1" name="FILE1"/></td>	
	    </tr>
		<tr>
			<td><input type="button" value="添加" onclick="addAD()"></td>
			<td>${message }</td>
		</tr>
	</table>
</form>
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
