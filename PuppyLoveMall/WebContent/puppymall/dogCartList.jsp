<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강아지 장바구니 목록</title>
<style type="text/css">
#listForm {
   width: 640px;
   border: 1px solid gray;
   margin: auto;
}
h2 {
   text-align: center;
}
table {
   width: 550px;
   margin: auto;
   text-align: center;
   border-color: lightgray;
   border-collapse: collapse;
}
.tr_top {
   background-color: gray;
}
.div_empty {
   text-align: center;
   background-color:
}
.td_command {
   text-align: right;
}
#todayImageList{
   text-align: center;
}
#productImage{
   width:150px;
   height:150px;
   border:none;
}
#cartImage{
   width:70px;
   height:70px;
   border:none;
}
#select{
	text-align: right;
}
#commandList{
	text-align: center;
}
#upImage{
	width: 15px;
}
#downImage{
	width: 15px;
}
a {
	text-decoration: none;
}
</style>
<script>
function checkAll(theForm){
	if(theForm.remove.length == undefined){
		theForm.remove.checked = theForm.allCheck.checked;
	} else {
		for(var i=0;i<theForm.remove.length;i++){
			theForm.remove[i].checked = theForm.allCheck.checked;
		}
	}
}

function checkQty(kind,qty){
	if(qty != 1){
		location.href="dogCartQtyDown.dog?kind="+ encodeURIComponent(kind);
	}
}
</script>
</head>
<body>
<c:if test="${startMoney != null }">
	<c:set var="startMoney" value="${startMoney }"></c:set>
</c:if>
<c:if test="${endMoney != null }">
	<c:set var="endMoney" value="${endMoney }"></c:set>
</c:if>
<section id="listForm">
	<c:if test="${cartList !=null && cartList.size()>0 }">
<h2>장바구니 목록</h2>
<form method="post">
      <table border="1">
    	<tr id="select">
    		<td colspan="6">
    		<select id="startMoney" name="startMoney">
    			<option value="0">~최하~</option>
    			<c:choose>
    				<c:when test="${startMoney==100000 }">
    					<option selected>100000</option>
    					<option>200000</option>
    					<option>300000</option>
	    				<option>400000</option>
    				</c:when>
    				<c:when test="${startMoney==200000 }">
    					<option>100000</option>
    					<option selected>200000</option>
    					<option>300000</option>
	    				<option>400000</option>
    				</c:when>
    				<c:when test="${startMoney==300000 }">
    					<option>100000</option>
    					<option>200000</option>
    					<option selected>300000</option>
	    				<option>4000</option>
    				</c:when>
    				<c:when test="${startMoney==400000 }">
    					<option>100000</option>
    					<option>200000</option>
    					<option>300000</option>
	    				<option selected>400000</option>
    				</c:when>
    				<c:otherwise>
    					<option>100000</option>
    					<option>200000</option>
    					<option>300000</option>
    					<option>400000</option>
    				</c:otherwise>
    			</c:choose>
    		</select> ~ 
    		<select id="endMoney" name="endMoney">
    			<option value="900000">~최고~</option>
    			<c:choose>
    				<c:when test="${endMoney==100000 }">
    					<option selected>100000</option>
    					<option>200000</option>
    					<option>300000</option>
	    				<option>400000</option>
    				</c:when>
    				<c:when test="${endMoney==200000 }">
    					<option>100000</option>
    					<option selected>200000</option>
    					<option>300000</option>
	    				<option>400000</option>
    				</c:when>
    				<c:when test="${endMoney==300000 }">
    					<option>100000</option>
    					<option>200000</option>
    					<option selected>300000</option>
	    				<option>400000</option>
    				</c:when>
    				<c:when test="${endMoney==400000 }">
    					<option>100000</option>
    					<option>200000</option>
    					<option>300000</option>
	    				<option selected>400000</option>
    				</c:when>
    				<c:otherwise>
    					<option>100000</option>
    					<option>200000</option>
    					<option>300000</option>
    					<option>400000</option>
    				</c:otherwise>
    			</c:choose>
    		</select>
    		<input type="submit" value="검색" formaction="dogCartSearch.dog"/>
    		</td>
    	</tr>
        <tr class="tr_top">
        	<td><input type="checkbox" id="allCheck" name="allCheck" onclick="checkAll(this.form)"/> </td>
            <td>번호</td>
            <td>강아지 이미지</td>
            <td>상품명</td>
            <td>가격</td>
            <td>수량</td>
         </tr>
	<c:forEach var="cart" items="${cartList }" varStatus="status">   
        <tr>
        	<td><input type="checkbox" id="remove" name="remove" value="${cart.kind }"/></td>
            <td>${status.index+1}</td>
            <td><img src="images/${cart.image }" id="cartImage"/></td>
            <td>${cart.kind }</td>
            <td>${cart.price }</td>
            <td>
            	<a href="dogCartQtyUp.dog?kind=${cart.kind }">
            		<img src="images/up.jpg" id="upImage" border=0/></a><br>
             	${cart.qty }<br>
             	<a href="javascript:checkQty('${cart.kind}',${cart.qty})">
             		<img src="images/down.jpg" id="downImage" border=0/></a>
            </td>
         </tr>
	</c:forEach>
      <tr>
         <td colspan="6">총 금액 : ${totalMoney}원
         </td>
      </tr>
      <tr>
         <td colspan="6">
         	<input type="submit" value="삭제" formaction="dogCartRemove.dog"/>
         </td>
      </tr>
      </table>
</form>
	</c:if>
	<c:if test="${cartList == null }">
      <section class="div_empty">
      	개정보가 없습니다.
      </section>
	</c:if>
   <nav id="commandList">
   		<a href="dogList.dog">쇼핑 계속하기</a>
   </nav>
   
</section>
</body>
</html> 