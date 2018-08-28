<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.js"></script>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="/resources/css/bootstrap.min.css">

<title>Insert title here</title>
<script>
$(document).ready(function(){
	var s=Math.floor(Math.random() * 5) + 1;
	switch(s){
	
	case 1:
		$('.product_con').css('background',"url('/resources/image/배경.jpg')");
		$('.product_con').css('background-size',"100% 100%");
		$('.product_con').css('background-repeat',"no-repeat");
		$('.product_con').css('backgorund-position',"center center");
		break;
	case 2:
		$('.product_con').css('background',"url('/resources/image/배경2.jpg')");
		$('.product_con').css('background-size',"100% 100%");
		$('.product_con').css('background-repeat',"no-repeat");
		$('.product_con').css('backgorund-position',"center center");
		break;
	case 3:
		$('.product_con').css('background',"url('/resources/image/배경4.jpg')");
		$('.product_con').css('background-size',"100% 100%");
		$('.product_con').css('background-repeat',"no-repeat");
		$('.product_con').css('backgorund-position',"center center");
		break;
	case 4:
		$('.product_con').css('background',"url('/resources/image/배경5.jpg')");
		$('.product_con').css('background-size',"100% 100%");
		$('.product_con').css('background-repeat',"no-repeat");
		$('.product_con').css('backgorund-position',"center center");
		break;
	case 5:
		$('.product_con').css('background',"url('/resources/image/배경6.jpg')");
		$('.product_con').css('background-size',"100% 100%");
		$('.product_con').css('background-repeat',"no-repeat");
		$('.product_con').css('backgorund-position',"center center");
		break;
	}
});
var index=-1;
var order='${requestScope.portfolioContentSize+1}';

$(function(){
	
    var selNum = 0,
        $proList = $(".product_lis,li"),
        totalNum = $proList.length,
        $btnprev = $(".product_con .btn_prev"),
        $btnnext = $(".product_con .btn_next"),
        oldNum;

    $proList.css({display:"none"});
    $proList.eq(selNum).fadeIn(1000);

    function prevItem() {
        oldNum = selNum;
        selNum = selNum - 1;
        
       
        
        if(selNum==-1){
        	$('.btn_next').html('add_circle_outline');
        }else{
        	$('.btn_next').html('arrow_right');
        }
        if(selNum < 0) {
            selNum = totalNum - 1;
        }
        setting('-1');
    }
    function deleteParent(obj){
  	  obj.parentNode.remove();
    }
  
    function nextItem() {
    	 if(selNum<totalNum){
        	oldNum = selNum;
        	selNum = selNum + 1;
    	 }
        if(selNum==(totalNum-1)){
        	$('.btn_next').html('add_circle_outline');
        	
        	
        }
        else if(totalNum==selNum){
        	$('.btn_next').attr('data-toggle','modal');  
            $('.btn_next').attr('data-target','#myModal');
        }
        else if(selNum > totalNum) {
            selNum = 0;
            
        }
        
        if(selNum<totalNum){
        	setting('1');	
        }
        
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
    $('#closebtn').click(function(){
    	index=-1;
    });
    $('#okbtn').click(function(){
    	
		/* var $test=$($('#layout1').html()); */
		alert(order);
		var str='';
		if(index==1){
			str='<input type="file" class="btn" style="margin-top: 25%;margin-left:15%" accept=".png,.jpg,.jpeg,.bmp,.gif" name="portfolioFile"/>'
				+'<input type="hidden" name="portfolioContentName" value="image"/>'
				+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}else if(index==2){
			str='<input type="text" class="form-control registerPortfolioInput"  name="portfolioURL" style="display:inline;margin-top:30%;font-size:100%" placeholder="Youtube URL을 입력해 주세요"/>'
				+'<input type="hidden" name="portfolioContentName" value="media"/><br>'
				+'<동영상 등록하는 방법><br>1.Youtube 동영상 화면 우클릭<br>2.소스코드 복사 클릭<br>'
				+'3. src="https://www.youtube.com/embed/nelSiMnilRw?ecver=1<br>"..." 안에 내용을 복사하여 입력해 주세요'
				+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}else if(index==3){
			str='<input type="file" class="btn" style="margin-top: 25%;margin-left:15%" accept=".ppt,.pptx" name="portfolioFile"/>'
				+'<input type="hidden" name="portfolioContentName" value="ppt"/>'
				+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}else if(index==4){
			str='<input type="file" style="margin-top: 50%" accept=".png,.jpg,.jpeg,.bmp,.gif" name="portfolioFile"/>'
				+'<input type="hidden" name="portfolioContentName" value="image"/>'
				+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}else if(index==5){
			str='<input type="text" class="form-control registerPortfolioInput" name="portfolioURL" style="display:inline;margin-top:40%;font-size:100%" placeholder="Youtube URL을 입력해 주세요"/>'
			+'<input type="hidden" name="portfolioContentName" value="media"/><br>'
			+'<동영상 등록하는 방법><br>1.Youtube 동영상 화면 우클릭<br>2.소스코드 복사 클릭<br>'
			+'3. src="https://www.youtube.com/embed/nelSiMnilRw?ecver=1<br>"..." 안에 내용을 복사하여 입력해 주세요'
			+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}else if(index==6){
			str='<input type="file" style="margin-top: 50%" accept=".ppt,.pptx" name="portfolioFile">'
				+'<input type="hidden" name="portfolioContentName" value="ppt"/>'
				+'<input type="hidden" name="contentOrder" value="'+order+'"/>';
		}
		order=parseInt(order+1);
		if(index>-1&&index<4){
			
			var $layout=$('<li></li>');
			$('#layout1 .center_content').html(str);
			$layout.html($('#layout1').html());
			$('.product_list').append($layout);
			
		}else if(index>3){
			var $layout=$('<li></li>');
			$('#layout2 #l2picbox').html(str);
			$layout.html($('#layout2').html());
			$('.product_list').append($layout);
		}
		
		
		$proList = $(".product_lis, li");
		totalNum=totalNum+1;
		
		if(index!=-1){
			$('.btn_next').removeAttr('data-toggle');
			$('.btn_next').removeAttr('data-target');
			index=-1;
			setting('1');
		}
		
	});
    
    $('#l1-1btn').click(function(){
    	index=1;
    });
    $('#l1-2btn').click(function(){
    	index=2;
    });
    $('#l1-3btn').click(function(){
    	index=3;
    });
    $('#l2-1btn').click(function(){
    	index=4;
    });
    $('#l2-2btn').click(function(){
    	index=5;
    });
    $('#l2-3btn').click(function(){
    	index=6;
    });
    $( document ).on( 'click', '#deleteBtn', function () {
    	oldNum = selNum;
        selNum = selNum - 1;
        
      
        order=order-1;
        var conid=$(this).next().children().children('input[name="portfolioContentId"]').val();
        var $dcon=$('<input type="hidden" name="deleteContent" value="'+conid+'">');
        $('#removeContent').append($dcon);
	  $(this).parent().remove();
	 
	  $proList = $(".product_lis, li");
	  totalNum=totalNum-1;
	  index=index-1;
	 
	  if(selNum==(totalNum-1)){
      	$('.btn_next').html('add_circle_outline');
      	
      	
      }
      else if(totalNum==selNum){
      	$('.btn_next').attr('data-toggle','modal');  
          $('.btn_next').attr('data-target','#myModal');
      }
	  setting('-1');
	 });
    
	$('#modalOkbtn').click(function(){
		var categoryValue = $('input:radio[name="projectcategoryid"]:checked').val();
		$('#pci').attr('value',categoryValue);
	});
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
  letter-spacing: normal;
  text-transform: none;
  display: inline-block;
  white-space: nowrap;
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
	color:white;
}
*{ margin:0;padding:0;text-decoration:none}
li{list-style:none}

.product_con{ position:relative; width:100%; height:100vh;margin:0 auto;
background:url('/resources/image/배경5.jpg');
background-size: 100% 100%;
background-repeat:no-repeat;
backgorund-position:center center;

}
.product_con .product_list{overflow:hidden;position:relative;width:100%; height:97vh;}
.product_con .product_list li{ width:100%;position:absolute;left:0;}
.product_con .product_list li:nth-child(1){left:0px;}
.product_con .product_list li:nth-child(2){left:200px;}
.product_con .product_list li:nth-child(3){left:200px;}
.product_con .product_list li:nth-child(4){left:200px;}
.product_con .product_list li:nth-child(5){left:200px;}
.product_con .product_list li:nth-child(6){left:200px;}
.product_con .product_list li:nth-child(7){left:200px;}

/* .product_con .product_list li div{display:block; width:100%;height:100vh;color:#fff;text-align: center} */

/* .product_con .product_list li:nth-child(1) a{background:#abe8cd;left:-200px;}
.product_con .product_list li:nth-child(2) a{background:#abe8cd}
.product_con .product_list li:nth-child(3) a{background:#abe8cd;left:200px;}
.product_con .product_list li:nth-child(4) a{background:#abe8cd;left:200px;}
.product_con .product_list li:nth-child(5) a{background:#abe8cd;left:200px;} */
*{
-ms-user-select: none; -moz-user-select: -moz-none; -webkit-user-select: none; -khtml-user-select: none; user-select:none;
}
.product_con .btn_prev,.product_con .btn_next { position:absolute;top:45%;

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
	width:80%;	
	height:800px;
	margin-left:20%;	
	margin-top:5%; 
}
.content_box{
width:50%;height:400px; float:left; font-size:270%; margin-top:5%
}
.first_content{
	width:120%;
	
}
.first_content_child{
font-size:80%;margin-left:11%;margin-top:2%
}
.center_content{
	width:44%;
	height:50vh;
	margin:0 auto;
	margin-top:5%;
	text-align:center;
	border:2px solid white;

}
.bottom_content{
	width:55%;
	height:38vh;
	font-size:200%;
	margin:0 auto;
	
}
.pic_box{
width:80%;
 height:73%;
margin:0 auto;
border:2px solid white;
}
.registerPortfolioInput{
	color:black;
	width: 65%;
/*     height: 80%; */
    margin-top:4%;
    font-size: 50%;
   
}
.addBtn{
	position:fixed;
	bottom:5%;
	right:11%;
	z-index:1000;

}
#deleteBtn{
	right: 5%;
    position: absolute;
    top: 3%;
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
	/* The switch - the box around the slider */
.switch {
  position: relative;
  display: inline-block;
  width: 60px;
   height: 34px;
}

/* Hide default HTML checkbox */
.switch input {display:none;}

/* The slider */
.slider {
  position: absolute;
  cursor: pointer;
  top: 0;
  left: 0;
  right: 0;
  bottom: 0;
   background-color: #ccc;
  -webkit-transition: .4s;
  transition: .4s;
}

.slider:before {
  position: absolute;
  content: "";
  height: 26px;
   width: 26px;
  left: 4px;
  bottom: 4px;
  background-color: white;
  -webkit-transition: .4s;
  transition: .4s;
}

input:checked + .slider {
   background-color: #2196F3;
}

input:focus + .slider {
  box-shadow: 0 0 1px #2196F3;
}

input:checked + .slider:before {
  -webkit-transform: translateX(26px);
  -ms-transform: translateX(26px);
  transform: translateX(26px);
}

/* Rounded sliders */
.slider.round {
  border-radius: 34px;
}

.slider.round:before {
  border-radius: 50%;
} 
.porjectCategoryBtn{
font-size:50%;
}
.bottom-btn{
	color:white;
	background-color:#776e8c00;
	border:1px solid white;
}
.bottom-btn:hover{
	background-color:#776e8c;
}
.teamwith_logo {
    
    width: 40px;
}
.logo {
    border: 0;
    display: inline-block;
    font-size: 0.8em;
    position:fixed;
    top:3%;
    left:1%;
    line-height: inherit;
    padding: 0 1.5em;
    background-color:none;
}
</style>
</head>
<body style="height:100%">
<div class="product_con">
<a href="/" class="logo"><img class="teamwith_logo"  src="/resources/image/logo/logoBox.png"> </a>
<form action="/portfolio/edit/${portfolioVO.portfolioId }" method="post" enctype="multipart/form-data">
	<div id="removeContent" style="display:none"></div>
	<input type="hidden" name="portfolioId" value="${portfolioVO.portfolioId }">
    <ul class="product_list">
   
        <li>
        	<div class="left_box" >
        		<div class="pic_box" style="background-image: url(${portfolioVO.portfolioPic});background-size:100% 100%;">
        			<input type="file" style="margin-top:50%;margin-left:20%"name="portfolioFile" accept=".png,.jpg,.jpeg,.bmp,.gif">
        			<input type="hidden" name="oldPortfolioPic" value="${portfolioVO.portfolioPic}">
        			<br>
        			포트폴리오 대표 사진을 등록해 주세요
        		</div>
        		<div style="margin-top:30px;font-size:180%">Title<br>
        			<input type="text"  class="form-control " value="${portfolioVO.portfolioTitle }" style="width:80%;margin:0 auto" name="portfolioTitle" placeholder="제목을 입력하세요">
        		</div>
        	</div>
        	<div class="content_box">
	        	<div class="first_content">Category
	        		<div class="first_content_child porjectCategoryBtn">
	        			<button type="button" class="btn btn-outline-danger" data-toggle="modal" data-target="#categoryModal"
	        			id="projectCategoryBtn" >카테고리 선택</button>
	        		</div>
	        	</div>
	        	
	        	<div class="first_content" >Intro
	        		<div class="first_content_child">
	        			<textarea class="form-control registerPortfolioInput" name="portfolioIntro" rows="7" style="resize:none" placeholder="소개글을 입력하세요">${portfolioVO.portfolioIntro }</textarea>
	        		</div>
	        	</div>
	        	
	        	<div class="first_content" >Skills
	        		<div class="first_content_child">
	        	 		<input type="text" class="form-control registerPortfolioInput " value="${portfolioVO.portfolioSkill }"name="portfolioSkill"  placeholder="사용 기술을 입력하세요" ><br>
	        		</div>
	        	</div>
	        	<div class="first_content" >
					<div style="display:inline-block;">Best</div>
						<label class="switch" style="padding-top:20px">
							<input type="checkbox" name="portfolioBest"
							<c:if test="${portfolioVO.portfolioBest==1 }">
								checked
							</c:if>
							>
							<span class="slider round"></span>
						</label>
	        	</div>
        	</div>
        </li>
     
        <li>
	        <div class="second_content_box">
	        
	        	<div>Team Info</div>
	        	<div class="row second_content"><div class="col">Team name</div>
	        	<div class="col-8">  <input type="text" class="form-control registerPortfolioInput" value="${portfolioVO.portfolioTeamName }"name="portfolioTeamName" placeholder="팀명을 입력하세요"></div></div>
	        	<div class="row second_content"><div class="col">People Number</div>
	        	<div class="col-8"> <input type="number" class="form-control registerPortfolioInput" value="${portfolioVO.portfolioPeopleNum }"name="portfolioPeopleNum" placeholder="참여인원을 입력하세요"></div></div>
	        	<div class="row second_content"><div class="col-4">Development period</div>
	        	<div class="col-3" style="width:500px"><input type="date" class="form-control registerPortfolioInput" value="${portfolioVO.portfolioStartDate }" name="portfolioStartDate" >
	        	</div><div class="col-3"><input type="date" class="form-control registerPortfolioInput" value="${portfolioVO.portfolioEndDate }" name="portfolioEndDate" ></div></div>
	        	<div class="row second_content"><div class="col">My Role</div>
	        	<div class="col-8"><input type="text" class="form-control registerPortfolioInput" value="${portfolioVO.portfolioRole }"name="portfolioRole" placeholder="역할을 입력하세요"></div></div>
	        	<div class="row second_content"><div class="col">My Work</div>
	        	<div class="col-8"><textarea class="form-control registerPortfolioInput" name="portfolioWork" rows="5" cols="50portfolioStartDate" placeholder="작업 내용을 입력하세요">${portfolioVO.portfolioWork }</textarea></div></div>
	        </div>
	        
        </li>
        <!-- 3번부터 동적으로 생성해야 하는 부분 (시용자가 추가했을 경우) -->
        <c:set var="end" value="no" scope="request"/>
        <c:forEach items="${requestScope.portfolioContent }" var="content" varStatus="i">
        		<c:set var="oldContent" value="${content}" scope="request"/>
	        	<c:choose>
	        		<c:when test="${content.layoutId=='layout-1'}">
	        			<li>
	        				<div id="layout1">
	        				<button type="button" class="btn bottom-btn" id="deleteBtn">삭제</button>
				        	<jsp:include page="portfolioContentLayout1.jsp"/>
				        	<input type="hidden" name="layoutId" value="layout-1"/>
				        	
				        	</div>
				        </li>
	        		</c:when>
	        		<c:when test="${content.layoutId=='layout-2'}">
	        			<li>
	        				<div id="layout2" >
	        				<jsp:include page="portfolioContentLayout2.jsp"/>
	        				<input type="hidden" name="layoutId" value="layout-2"/>
	        				<button type="button" class="btn bottom-btn" id="deleteBtn">삭제</button>
	        				</div>
	        			</li>
	        		</c:when>
	        	</c:choose>
        </c:forEach>
        <c:set var="end" value="ok" scope="request"/>
    </ul>
    <input type="hidden" name="projectCategoryId" id="pci" value="">
    
    
    
      <input class="btn addBtn bottom-btn" type="submit" value="수정완료"/>
      
    </form>
 
     <i class="btn_prev material-icons">arrow_left</i>
    <i class="btn_next material-icons">arrow_right</i>	

   <jsp:include page="portfolioLayoutModal.jsp"/> 
</div>
<form action="/polog/${sessionScope.memberSimpleVO.memberId }">
		<button type="submit" class="btn portfolioExitBtn bottom-btn">내 폴로그로</button>
	</form>
<div id="layout1" style="display:none">
<jsp:include page="portfolioContentLayout1.jsp"/>
<button type="button" class="btn bottom-btn" id="deleteBtn" >삭제</button>
<input type="hidden" name="layoutId" value="layout-1"/>
</div>
<div id="layout2" style="display:none">
<jsp:include page="portfolioContentLayout2.jsp"/>
<button type="button" class="btn btn-warning" id="deleteBtn">삭제</button>
<input type="hidden" name="layoutId" value="layout-2"/>
</div>
<!-- 카테고리모달 -->
	<div class="modal team_regist_modal_font" id="categoryModal" style="color:black">
						<div class="modal-dialog modal-lg" style="max-width:45%;font-size:120%">
							<div class="modal-content">
								<div class="modal-header team_regist_modal_title">분야 선택</div>
								<!-- Modal body -->
								<div class="modal-body">
									<c:forEach items="${applicationScope.projectList }" var="project" varStatus="i" >
										<c:if test="${(i.index mod 3) eq 0}">
											<div class="row team_regist_big_modal_interval">
										</c:if>
										<div class="col team_regist_modal_element mycol">
											<input name="projectcategoryid" type="radio"
												class="form-check-input" value="${project.key }">${project.value }
										</div>
										<c:if test="${(i.index mod 3) eq 2}">
											</div>
										</c:if>
								</c:forEach>
								<div class="row modalrow" style="margin-left: 75%;margin-top:5%">
									<button type="button" id="modalOkbtn"
										class="btn btn-mid team_regist_btn_color"
										data-dismiss="modal">확인</button>
								</div>
							</div>
						</div>
					</div>
</body>
</html>