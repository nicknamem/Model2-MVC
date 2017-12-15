<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>강아지 목록 보기</title>
<style type="text/css">
#listForm {
	width: 1000px;
	height: 500px;
	border: 1px solid gray;
	margin: auto;
	padding-bottom: 30px;
}
h2, h4 {
	text-align: center;
}
table {
	margin: auto;
	width: 900px;
}
.div_empty {
	background-color: red;
	width: 100%;
	height: 100%;
	text-align: center;
}
#todayImageList {
	text-align: center;
}
#productImage {
	width: 150px;
	height: 150px;
	border: none;
}
#todayImage {
	width: 50px;
	height: 50px;
	border: none;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
<section id = "listForm">
<c:if test="${puppyList != null}">
<h2>강아지 목록</h2>
<h4><a href="puppyRegistForm.pu">강아지 등록</a></h4>
<table>
	<tr>
		<c:forEach var="puppy" items="${puppyList }" varStatus="status">
		<td>
			<a href="puppyView.pu?id=${puppy.id}">
				<img src="images/${puppy.image}" id="productImage"/>
			</a><br>
			강아지 종류 : ${puppy.kind}<br>
			가격 : ${puppy.price}<br>
		</td>
		<c:if test="${((status.index+1) mod 5)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</c:if>
<c:if test="${puppyList==null }">
	<div class="div_empty">
	강아지가 없습니다. 분양 불가
	</div>
</c:if>
<c:if test="${todayImageList !=null }">
<div id ="todayImageList">
	<br><br>
	<h4>오늘 본 강아지 목록</h4>
<table>
	<tr>
		<c:forEach var="todayImage" items="${todayImageList}" varStatus="status">
		<td>
			<img src="images/${todayImage}" id="todayImage"/>
		</td>
			<c:if test="${((status.index+1) mod 10)==0 }">
			</tr>
			<tr>
		</c:if>
		</c:forEach>
	</tr>
</table>
</div>
</c:if>
</section>
</body>
</html>