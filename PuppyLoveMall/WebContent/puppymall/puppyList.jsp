<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String[] icons = {
	"custom_1.gif", "custom_2.gif", "custom_3.gif", "custom_4.gif", "custom_5.gif",
	"custom_6.gif", "custom_7.gif", "custom_8.gif", "custom_9.gif", "custom_10.gif",	
	"custom_11.gif", "custom_12.gif", "custom_13.gif", "custom_14.gif", "custom_15.gif",	
	"custom_16.gif", "custom_17.gif", "custom_18.gif", "custom_19.gif", "custom_20.gif",	
	"custom_21.gif", "custom_22.gif", "custom_23.gif", "custom_24.gif", "custom_25.gif",	
	"custom_26.gif", "custom_27.gif", "custom_28.gif", "custom_29.gif", "custom_30.gif",
	"custom_31.gif", "custom_32.gif", "custom_33.gif", "custom_34.gif", "custom_35.gif",
	"custom_36.gif", 
};
%>
<!DOCTYPE html>
<html lang="kor">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Puppy Love Mall</title>

    <!-- Bootstrap core CSS -->
    <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/shop-homepage.css" rel="stylesheet">
    
    <style type="text/css">
    	#pageList{
    		text-align: center;
    	}
    	#main-header{
    		width: 100%;
    		height: 200px;
    		background: url(images/main_puppy.jpg) no-repeat right;
    		background-size: 200px;
    		background-color: rgb(239, 239, 239);
    		margin-top: -50px;
    	}
    	#main-title{
    		padding-left: 100px;
    		padding-top: 100px;
    	}
    	#top-image{
    		width: 900px;
    		height: 350px;
    	}
    </style>

  </head>

  <body>
  
  	<div id="main-header">
  		<h1 id="main-title">Puppy Love Mall</h1>
  	</div>

    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
      <div class="container">
        <a class="navbar-brand" href="#">Puppy Love Mall</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
          <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
          <ul class="navbar-nav ml-auto">
            <li class="nav-item active">
            <c:if test="${sessionScope.id == null }">
              <a class="nav-link" href="memberLogin.me">Login
                <span class="sr-only">(current)</span>
              </a>
    		</c:if>
    		
    		<c:if test="${sessionScope.id != null}">
               <a class="nav-link" href="memberLogoutAction.me">Logout
                <span class="sr-only">(current)</span>
              </a>
            </c:if>
            </li>
            <!-- admin(관리자)일 때 처리 -->
            <c:if test="${sessionScope.id == 'admin' }">
            <li class="nav-item">
              <a class="nav-link" href="/memberListAction.me">Member List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="puppyRegistForm.pu">Puppy Register</a>
            </li>
            </c:if>
            <c:if test="${sessionScope.id == null }">
            <li class="nav-item">
              <a class="nav-link" href="memberJoin.me">Members</a>
            </li>
            </c:if>
            <li class="nav-item">
              <a class="nav-link" href="#">Cart</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">My Page</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Wish List</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Notice</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="boardList.boq">QA</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="boardList.bor">Review</a>
            </li>
          </ul>
        </div>
      </div>
    </nav>

    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-2">

          <h6 class="my-4">품종별 리스트</h6>
          <div class="list-group">
            <a href="#" class="list-group-item">말티즈</a>
            <a href="#" class="list-group-item">요크셔테리어</a>
            <a href="#" class="list-group-item">푸들</a>
            <a href="#" class="list-group-item">시츄</a>
            <a href="#" class="list-group-item">포메리안</a>
            <a href="#" class="list-group-item">치와와</a>
            <a href="#" class="list-group-item">스피츠</a>
            <a href="#" class="list-group-item">기타</a>
          </div>
          
          <h6 class="my-4">가격대별 리스트</h6>
          <div class="list-group">
            <a href="#" class="list-group-item">100,000 ~ 200,000</a>
            <a href="#" class="list-group-item">200,000 ~ 400,000</a>
            <a href="#" class="list-group-item">400,000 ~ 600,000</a>
            <a href="#" class="list-group-item">600,000 ~ 800,000</a>
            <a href="#" class="list-group-item">800,000 ~ 1,000,000</a>
            <a href="#" class="list-group-item">1,000,000 이상</a>
          </div>

        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-10">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <ol class="carousel-indicators">
              <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="2"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="3"></li>
              <li data-target="#carouselExampleIndicators" data-slide-to="4"></li>
            </ol>
            <div class="carousel-inner" role="listbox">
              <div class="carousel-item active">
                <img id="top-image" class="d-block img-fluid" src="images/top_puppy_01.jpg" alt="First slide">
              </div>
              <div class="carousel-item">
                <img id="top-image" class="d-block img-fluid" src="images/top_puppy_02.jpg" alt="Second slide">
              </div>
              <div class="carousel-item">
                <img id="top-image" class="d-block img-fluid" src="images/top_puppy_03.jpg" alt="Third slide">
              </div>
              <div class="carousel-item">
                <img id="top-image" class="d-block img-fluid" src="images/top_puppy_04.jpg" alt="Third slide">
              </div>
              <div class="carousel-item">
                <img id="top-image" class="d-block img-fluid" src="images/top_puppy_05.jpg" alt="Third slide">
              </div>
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row">
<!--  -->
			<c:forEach var="puppy" items="${puppyList }" varStatus="status">
            <div class="col-lg-3 col-md-6 mb-4">
              <div class="card h-100">
                <a href="puppyView.pu?id=${puppy.id }">
                	<img class="card-img-top" src="images/${puppy.image }" width="150" height="150" alt=""></a>
                <div class="card-body">
                  <h6 class="card-title">
                    <a href="#">${puppy.kind }</a>
                  </h6>
                  <p style="text-decoration: line-through;">분양가:${puppy.price }</p>
                  <p><b>실분양가:${puppy.price*0.9 }</b></p>
                </div>
                <div class="card-footer">
                  <img alt="" height="15" src="icons/<%=icons[(int)(Math.random()*36)] %>">
                </div>
              </div>
            </div>
            </c:forEach>
            
<!--  -->            

          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->
        
        <section id="pageList">
			<c:choose>
			<c:when test="${pageInfo.page <= 1 }">
				[이전]&nbsp;
			</c:when>
			<c:otherwise>
				<a href="puppyList.pu?page=${pageInfo.page-1 }">[이전]</a>&nbsp;
			</c:otherwise>
			</c:choose>
		
			<c:forEach var="a" begin="${pageInfo.startPage }" end="${pageInfo.endPage }" step="1">
				<c:choose>
				<c:when test="${a == pageInfo.page }">
					[${a }]&nbsp;
				</c:when>
				<c:otherwise>
					<a href="puppyList.pu?page=${a }">[${a }]</a>&nbsp;
				</c:otherwise>
				</c:choose>
			</c:forEach>
		
			<c:choose>
			<c:when test="${pageInfo.page >= pageInfo.maxPage }">
				[다음]
			</c:when>
			<c:otherwise>
				<a href="puppyList.pu?page=${pageInfo.page+1 }">[다음]</a>
			</c:otherwise>
			</c:choose>
		</section>
		<br>

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <!-- Footer -->
    <footer class="py-5 bg-dark">
      <div class="container">
        <p class="m-0 text-center text-white">Copyright &copy; Your Website 2017</p>
      </div>
      <!-- /.container -->
    </footer>

    <!-- Bootstrap core JavaScript -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  </body>

</html>
