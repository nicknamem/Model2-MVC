<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"> 
<title>MVC 게시판</title>
<style>
#passForm{
	width: 300px;
	margin: auto;
	border : 1px solid orange;
}
table {
	text-align: center;
}
</style>
</head>
<body>
<section id="passForm">
<form name="deleteForm" action="boardDeletePro.bor?board_num=${board_num }" method="post">
<input type="hidden" name="page" value="${page }"/>
<table>
<tr>
	<td>
		<label>글 비밀번호 : </label>
	</td>
	<td>
		<input name="BOARD_PASS" type="password">
	</td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="삭제"/>&nbsp;&nbsp;
		<input type="button" value="돌아가기" onClick="javascript:history.go(-1)"/>
	</td>
</tr>
</table>
</form>
</section>
</body>
</html>