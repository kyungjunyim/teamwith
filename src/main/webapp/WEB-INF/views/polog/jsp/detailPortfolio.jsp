<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="/resources/polog/css/contact.css">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">
<title>Insert title here</title>
<script>
$(function(){
    var selNum = 0,
        $proList = $(".product_lis, li"),
        totalNum = $proList.length,
        $btnprev = $(".product_con .btn_prev"),
        $btnnext = $(".product_con .btn_next"),
        oldNum;

    $proList.css({display:"none"});
    $proList.eq(selNum).fadeIn(1000);

    function prevItem() {
        oldNum = selNum;
        selNum = selNum - 1;
        if(selNum < 0) {
            selNum = totalNum - 1;
        }
        setting('-1');
    }

    function nextItem() {
        oldNum = selNum;
        selNum = selNum + 1;
        if(selNum >= totalNum) {
            selNum = 0;
        }
        setting('1');
    }

    $btnprev.on('click', prevItem);
    $btnnext.on('click', nextItem);

    function setting(adjust) {
        var adjust1 = adjust * 1,
                adjust2 = adjust * -1;
        if(setting.caller == indicate) {
            if(selNum < oldNum) {
                adjust1 = adjust * -1,
                        adjust2 = adjust;
            }
        }
        $proList.eq(selNum).css({ left : adjust1 * 1000 + 'px', display : 'block', opacity :1 })
        $proList.eq(oldNum).stop().animate({
                    left : adjust2 * 2000 + 'px', opacity : 1}
        );
        $proList.eq(selNum).stop().animate({left : 0, opacity : 1},500, function(){});

    }

    function indicate(){
        oldNum = selNum;
        selNum = $(this).index();
        if( selNum == oldNum) return;
        setting('1')
    }

    $('.numlist a').on('click', indicate)

});
</script>
<style>
 @font-face {
  font-family: 'Material Icons';
  font-style: normal;
  font-weight: 400;
  src: url(https://fonts.gstatic.com/s/materialicons/v39/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2) format('woff2');
}
.material-icons {
  font-family: 'Material Icons';
  font-weight: normal;
  font-style: normal;
  font-size: 100px;
  color:#ff4111;
  line-height: 1;
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
  line-height:700px;
  word-wrap: normal;
  direction: ltr;
  -webkit-font-feature-settings: 'liga';
  -webkit-font-smoothing: antialiased;

}
@font-face {
	font-family: nanumSquareRound;
	src: url(/resources/fonts/NanumSquareRoundEB.eot) format('embedded-opentype'),
		url(/resources/fonts/NanumSquareRoundEB.woff) format('woff'),
		url(/resources/fonts/NanumSquareRoundEB.ttf) format('truetype');
	font-weight: bold;
}

body {
	font-family: nanumSquareRound;
}
*{ margin:0;padding:0;text-decoration:none}
li{list-style:none}

.product_con{ position:relative; width:100%; height:100vh;margin:0 auto; border:1px solid #e4ecf4;;background-color: #ffecdf;}
.product_con .product_list{overflow:hidden;position:relative;width:100%; height:97vh;}
.product_con .product_list li{ width:100%;position:absolute;left:0;}
.product_con .product_list li:nth-child(1){left:0px;}
.product_con .product_list li:nth-child(2){left:200px;}
.product_con .product_list li:nth-child(3){left:200px;}
.product_con .product_list li:nth-child(4){left:200px;}
.product_con .product_list li:nth-child(5){left:200px;}

/* .product_con .product_list li div{display:block; width:100%;height:100vh;color:#fff;text-align: center} */

/* .product_con .product_list li:nth-child(1) a{background:#abe8cd;left:-200px;}
.product_con .product_list li:nth-child(2) a{background:#abe8cd}
.product_con .product_list li:nth-child(3) a{background:#abe8cd;left:200px;}
.product_con .product_list li:nth-child(4) a{background:#abe8cd;left:200px;}
.product_con .product_list li:nth-child(5) a{background:#abe8cd;left:200px;} */

*{
-ms-user-select: none; -moz-user-select: -moz-none; -webkit-user-select: none; -khtml-user-select: none; user-select:none;
}
.product_con .btn_prev,.product_con .btn_next { position:absolute;top:5%;
}
.product_con .btn_prev { left:0px;}
.product_con .btn_next { right:0px;}
.btn_prev:hover,.btn_next:hover{cursor: pointer;}
.numlist {width:105px; margin:0 auto;}
.left_box{
	display:block; 
/* 	color:#fff; */
	text-align: center;
	width:40%;	
	height:90vh;	
	margin-left: 8%; 
	margin-top:5%; 
	float:left;
}
.second_content_box{
	display:block; 
/* 	color:#fff; */
	font-size:400%;
	width:78%;	
	height:90vh;
	margin-left:15%;	
	margin-top:8%; 
}
.content_box{
width:45%;height:400px; float:left; font-size:270%; margin-top:5%
}
.first_content{
	width:100%;
	margin-top:2%;
}
.first_content_child{
font-size:80%;margin-left:11%;margin-top:2%
}
.center_content{
	width:40%;
	height:50vh;
	margin-left:33%;
	margin-top:90px;
	text-align:center;
	border-radius: 20px;
}
.bottom_content{
	width:1000px;
	height:350px;
	font-size:25px;
	margin:0 auto;
	
}
.second_content{
	font-size:60%;
	margin-left:3%;
	margin-top:1%;
	
}
.portfolioExitBtn{
	position:fixed;
	bottom:5%;
	right:5%;
}
.portfolioRemoveBtn{
	position:fixed;
	bottom:5%;
	right:12%;
}
.portfolioModifyBtn{
	position:fixed;
	top:5%;
	right:5%;
}
.pic_box{
width:80%;
 height:73%;
margin:0 auto;
background-color: #ffddc9;
}
</style>
</head>
<body>
<div class="product_con">
    <ul class="product_list">
   
        <li>
        	<div class="left_box" >
        		<img src="${portfolio.portfolioPic}" width="500px" height="500px"/>
        		<div style="font-size:230%;margin-top:30px">${portfolio.portfolioTitle }</div>
        		 
        	</div>
        	<div class="content_box">
	        	<div class="first_content" >Category<div class="first_content_child">${applicationScope.projectList[portfolio.projectCategoryId ] }</div></div>
	        	
	        	<div class="first_content" >Intro<div class="first_content_child">
	        	${portfolio.portfolioIntro }
	        	</div>
	        	</div>
	        	
	        	<div class="first_content" >Skills<div class="first_content_child">
	        	${portfolio.portfolioSkill }<br>
	        	</div></div>
        	
        	</div>
        </li>
     
        <li>
	        
	          <div class="second_content_box">
	        
	        	<div>Team Info</div>
	        	<div class="row second_content"><div class="col">Team name</div>
	        	<div class="col-8">${portfolio.portfolioTeamName }</div></div>
	        	<div class="row second_content"><div class="col">People Number</div>
	        	<div class="col-8">${portfolio.portfolioPeopleNum }</div></div>
	        	<div class="row second_content"><div class="col-4">Development period</div>
	        	<div class="col-8" >${portfolio.portfolioStartDate } ~ ${portfolio.portfolioEndDate }</div></div>
	        	<div class="row second_content"><div class="col">My Role</div>
	        	<div class="col-8">${portfolio.portfolioRole }</div></div>
	        	<div class="row second_content"><div class="col">My Work</div>
	        	<div class="col-8">${portfolio.portfolioWork }</div></div>
	        </div>
        </li>
        <!-- 3번부터 동적으로 생성해야 하는 부분 (시용자가 추가했을 경우) -->
        <c:forEach items="${requestScope.portfolioContent }" var="content" varStatus="i">
        	<%-- <c:if test="${content.portfolioContentOrder!=portfolioContent[i.index-1].portfolioContentOrder }"> --%>
        		<c:set var="contentTemp" value="${content}" scope="request"/>
	        	<c:choose>
	        		<c:when test="${content.layoutId=='layout-1'}">
	        			<li>
				        	<jsp:include page="portfolioContentLayout1.jsp"/>
				        </li>
	        		</c:when>
	        		<c:when test="${content.layoutId=='layout-2'}">
	        			<li>
	        				<jsp:include page="portfolioContentLayout2.jsp"/>
	        			</li>
	        		</c:when>
	        	</c:choose>
        <%-- 	</c:if> --%>
        </c:forEach>
        
    </ul>
    <i class="btn_prev material-icons">arrow_left</i>
    <i class="btn_next material-icons">arrow_right</i>	
	<form action="/polog/${portfolio.memberId }">
		<button type="submit" class="btn portfolioExitBtn btn-warning">돌아가기</button>
	</form>
	<!-- controller에 지우고 여긴 memberSimpleVO 바꾸기 테스트용임-->
	<c:if test="${portfolio.memberId eq sessionScope.memberSimpleVO.memberId }">
	<form action="/portfolio/remove/${portfolio.portfolioId}" method="post">
		<input type="hidden" name="memberId" value="${portfolio.memberId }">
		<button type="submit" class="btn portfolioRemoveBtn btn-warning">삭제하기</button>
	</form>
	<form action="/portfolio/edit/${portfolio.portfolioId }" method="get">
		<button type="submit" class="btn portfolioModifyBtn btn-warning">수정하기</button>
	</form>
	</c:if>
    
</div>
</body>
</html>