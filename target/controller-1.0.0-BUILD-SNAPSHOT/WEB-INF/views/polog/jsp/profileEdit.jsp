<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<!--
	Forty by HTML5 UP
	html5up.net | @ajlkn
	Free for personal and commercial use under the CCA 3.0 license (html5up.net/license)
-->
<html>

<head>
<title>Polog</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>

<script src="/resources/js/jquery.scrolly.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.scrollex/0.2.1/jquery.scrollex.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/skel/3.0.1/skel.min.js"></script>
<script src="/resources/polog/js/contact.js"></script>

<link rel="stylesheet" href="/resources/css/bootstrap.min.css" />

<link rel="stylesheet" href="/resources/polog/css/main.css" />
<link rel="stylesheet" href="/resources/polog/css/profile.css" />

<link rel="stylesheet" href="/resources/polog/css/bestPortfolio.css" />

<style type="text/css">
@font-face {
	font-family: 'Material Icons';
	font-style: normal;
	font-weight: 400;
	src:
		url(https://fonts.gstatic.com/s/materialicons/v39/flUhRq6tzZclQEJ-Vdg-IuiaDsNc.woff2)
		format('woff2');
}

a:not([href]):not([tabindex])
{
color:inherit;
text-decoration:none;
}
.btn-floating.btn-large {
	width: 56px;
	height: 56px;
	background-color: #436786;
}

.pulse {
	overflow: initial;
	position: relative;
}

.waves-effect {
	position: relative;
	cursor: pointer;
	display: inline-block;
	overflow: hidden;
	-webkit-user-select: none;
	-moz-user-select: none;
	-ms-user-select: none;
	user-select: none;
	-webkit-tap-highlight-color: transparent;
	vertical-align: middle;
	z-index: 1;
	-webkit-transition: .3s ease-out;
	transition: .3s ease-out;
}

.btn-large {
	height: 54px;
	line-height: 54px;
}

.btn-floating {
	display: inline-block;
	color: #fff;
	position: relative;
	overflow: hidden;
	z-index: 1;
	width: 40px;
	height: 40px;
	line-height: 40px;
	padding: 0;
	background-color: #26a69a;
	border-radius: 50%;
	-webkit-transition: .3s;
	transition: .3s;
	cursor: pointer;
	vertical-align: middle;
}

.btn-floating.btn-large i {
	line-height: 56px;
}

.btn-large i {
	font-size: 1.6rem;
}

.btn-floating i {
	width: inherit;
	display: inline-block;
	text-align: center;
	color: #fff;
	font-size: 1.6rem;
	line-height: 40px;
}

.btn, .btn-large {
	text-decoration: none;
	color: #fff;
	background-color: #26a69a;
	text-align: center;
	letter-spacing: .5px;
	-webkit-transition: .2s ease-out;
	transition: .2s ease-out;
	cursor: pointer;
	border: 0;
}

.btn, .btn-large, .btn-floating, .btn-large, .btn-flat {
	font-size: 1rem;
	outline: 0;
	border-radius: 50%;
}

.material-icons {
	font-family: 'Material Icons';
	font-weight: normal;
	font-style: normal;
	font-size: 24px;
	line-height: 1;
	letter-spacing: normal;
	text-transform: none;
	display: inline-block;
	white-space: nowrap;
	word-wrap: normal;
	direction: ltr;
	-webkit-font-feature-settings: 'liga';
	-webkit-font-smoothing: antialiased;
}
</style>

</head>
<body id="pBody">

	<!-- Wrapper -->
	<div id="wrapper">

		<!-- Header -->
		<header id="header" class="alt">
			<jsp:include page="header.jsp"></jsp:include>

		</header>

		<!-- Banner -->
		<section id="banner" class="major">
			<jsp:include page="banner.jsp"></jsp:include>
		</section>

		<!-- Profile -->
		<div class="profile" id="profile">

			<jsp:include page="profileInput.jsp"></jsp:include>

		</div>
	</div>

	<!-- footer -->
	<footer>
		<jsp:include page="footer.jsp"></jsp:include>
	</footer>


	<!-- Scripts -->



</body>
<script>
	$(document).ready(function() {
					console.log(document.getElementById('pBody').style.background = "${pologVO.pologBgColor}");
						var str = '${pologVO.pologBgPic}';
						console.log(str);
						console.log(document.getElementById('pBody').style.backgroundImage = "url('${pologVO.pologBgPic}')");
					})
</script>
</html>
