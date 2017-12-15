<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="boardqna.vo.PageInfo"%>
<%@ page import="boardqna.vo.BoardQnaBean"%>
<%@ page import="java.util.*"%>
<%@ page import="java.text.SimpleDateFormat"%>
<%
	List<BoardQnaBean> articleList = (ArrayList<BoardQnaBean>)request.getAttribute("articleList");
    PageInfo pageInfo = (PageInfo)request.getAttribute("pageInfo");
	int listCount=pageInfo.getListCount();
	int nowPage=pageInfo.getPage();
	int maxPage=pageInfo.getMaxPage();
	int startPage=pageInfo.getStartPage();
	int endPage=pageInfo.getEndPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>MVC 게시판</title>
<style type="text/css">
#registForm {
	width: 500px;
	height: 600px;
	border: 1px solid red;
	margin: auto;
}
h2, h4 {
	text-align: center;
}
table {
	margin: auto;
	width: 700px;
}
#tr_top {
	background: orange;
	text-align: center;
}
#pageList {
	margin: auto;
	width: 500px;
	text-align: center;
}
#emptyArea {
	margin: auto;
	width: 500px;
	text-align: center;
}
a {
	text-decoration: none;
}
</style>
</head>
<body>
<!-- 게시판 리스트 -->
<section id="listForm">
	<h2>글 목록</h2>
	<h4><a href="boardWriteForm.bo">게시판 글쓰기</a></h4>
	<table>
	<% if(articleList != null && listCount > 0) { %>
		<tr id="tr_top">
			<td align="center" width="80">번호</td>
			<td width="280">제목</td>
			<td align="center" width="160">작성자</td>
			<td align="center" width="100">날짜</td>
			<td align="center" width="80">조회수</td>
		</tr>
		<% for(int i=0; i<articleList.size(); i++) { %>
		<tr>
			<td align="center"><%=articleList.get(i).getBOARD_NUM()%></td>
			<td>
				<%if(articleList.get(i).getBOARD_RE_LEV()!=0){ %> 
					<%for(int a=0;a<=articleList.get(i).getBOARD_RE_LEV()*2;a++) { %>
						&nbsp; 
					<%} %>
					 ▶ 
				<%} else { %>
					 ▶
				<%} %> 
				<a href="boardDetail.bo?board_num=<%=articleList.get(i).getBOARD_NUM()%>&page=<%=nowPage%>">
					<%=articleList.get(i).getBOARD_SUBJECT()%></a>
			</td>
			<td align="center"><%=articleList.get(i).getBOARD_NAME() %></td>
			<td align="center"><%=articleList.get(i).getBOARD_DATE() %></td>
			<td align="center"><%=articleList.get(i).getBOARD_READCOUNT() %></td>
		</tr>
		<%} %>
	</table>
</section>

<section id="pageList">
	<% if(nowPage <= 1){ %>
		[이전]&nbsp;
	<%} else { %>
		<a href="boardList.bo?page=<%=nowPage-1 %>">[이전]</a>&nbsp;
	<%} %>

	<%for(int a=startPage; a<=endPage; a++) {
		if(a == nowPage) { %>
			[<%=a %>]&nbsp;
		<%} else { %>
			<a href="boardList.bo?page=<%=a %>">[<%=a %>]</a>&nbsp;
		<%} %>
	<%} %>

	<%if(nowPage >= maxPage) { %>
		[다음]
	<%} else { %>
		<a href="boardList.bo?page=<%=nowPage+1 %>">[다음]</a>
	<%} %>
</section>
<%} else {%>
	<section id="emptyArea">등록된 글이 없습니다.</section>
<%}%>
</body>
</html>