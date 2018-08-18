<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>황규진님의 폴로그입니다.</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />

<style type="text/css">
@font-face {
	font-family: bmjua;
	src: url(/fonts/BMJUA.eot) format('embedded-opentype'),
		url(/fonts/BMJUA.woff) format('woff'), url(/fonts/BMJUA.ttf)
		format('truetype');
}

@font-face {
	font-family: yanoljaBold;
	src: url(/fonts/yanoljaBold.eot) format('embedded-opentype'),
		url(/fonts/yanoljaBold.woff) format('woff'),
		url(/fonts/yanoljaBold.ttf) format('truetype');
	font-weight: bold;
}

body {
	background: #002b5a;
	font: yanoljaBold;
}
#banner {
	-moz-align-items: center;
	-webkit-align-items: center;
	-ms-align-items: center;
	align-items: center;
	background-image: url("../images/banner.jpg");
	display: -moz-flex;
	display: -webkit-flex;
	display: -ms-flex;
	display: flex;
	padding: 6em 0 2em 0;
	background-attachment: fixed;
	background-position: center;
	background-repeat: no-repeat;
	background-size: cover;
	border-bottom: 0 !important;
	cursor: default;
	height: 60vh;
	margin-bottom: -3.25em;
	max-height: 32em;
	min-height: 22em;
	position: relative;
	top: -3.25em;
	color:white;
}

#banner:after {
	-moz-transition: opacity 2.5s ease;
	-webkit-transition: opacity 2.5s ease;
	-ms-transition: opacity 2.5s ease;
	transition: opacity 2.5s ease;
	-moz-transition-delay: 0.75s;
	-webkit-transition-delay: 0.75s;
	-ms-transition-delay: 0.75s;
	transition-delay: 0.75s;
	-moz-pointer-events: none;
	-webkit-pointer-events: none;
	-ms-pointer-events: none;
	pointer-events: none;
	background-color: #242943;
	content: '';
	display: block;
	height: 100%;
	left: 0;
	opacity: 0.85;
	position: absolute;
	top: 0;
	width: 100%;
	z-index: 1
}

#banner h1 {
	font-size: 3.25em
}

#banner>.inner {
	-moz-transition: opacity 1.5s ease, -moz-transform 0.5s ease-out,
		-moz-filter 0.5s ease, -webkit-filter 0.5s ease;
	-webkit-transition: opacity 1.5s ease, -webkit-transform 0.5s ease-out,
		-webkit-filter 0.5s ease, -webkit-filter 0.5s ease;
	-ms-transition: opacity 1.5s ease, -ms-transform 0.5s ease-out,
		-ms-filter 0.5s ease, -webkit-filter 0.5s ease;
	transition: opacity 1.5s ease, transform 0.5s ease-out, filter 0.5s ease,
		-webkit-filter 0.5s ease;
	padding: 0 !important;
	position: relative;
	z-index: 2
}

#banner>.inner .image {
	display: none
}

#banner>.inner header {
	width: auto
}

#banner>.inner header>:first-child {
	width: auto
}

#banner>.inner header>:first-child:after {
	max-width: 100%
}

#banner>.inner .content {
	display: -moz-flex;
	display: -webkit-flex;
	display: -ms-flex;
	display: flex;
	-moz-align-items: center;
	-webkit-align-items: center;
	-ms-align-items: center;
	align-items: center;
	margin: 0 0 2em 0
}

#banner>.inner .content>* {
	margin-left: 1.5em;
	margin-bottom: 0
}

#banner>.inner .content>:first-child {
	margin-left: 0
}

#banner>.inner .content p {
	font-size: 0.7em;
	font-weight: 600;
	letter-spacing: .25em;
	text-transform: uppercase
}

#banner.major {
	height: 75vh;
	min-height: 30em;
	max-height: 50em
}

#banner.major.alt {
	opacity: 0.75
}

#banner.style1:after {
	background-color: #6fc3df
}

#banner.style2:after {
	background-color: #8d82c4
}

#banner.style3:after {
	background-color: #ec8d81
}

#banner.style4:after {
	background-color: #e7b788
}

#banner.style5:after {
	background-color: #8ea9e8
}

#banner.style6:after {
	background-color: #87c5a4
}

.teamwith_logo {
	width: 40px;
}
</style>
</head>
<body>
	<div id="wrapper">
		<header id="header" class="alt">
			<a href="../../teambuilding/jsp/main.jsp" class="logo"><img
				class="teamwith_logo" src="../../image/logo/logoBox.png"> </a>

		</header>
		<!-- Banner -->
		<section id="banner" class="major">
			<div class="inner">
				<header class="major">
					<h1>황규진의 폴로그입니다~</h1>
				</header>
				<div class="content">
					<p style="text-transform: uppercase;">
						A responsive site template designed by HTML5 Up<br /> and
						released under the Creative Commons.
					</p>
					<ul class="actions">
						<li><a href="#one" class="button next scrolly">Get
								Started</a></li>
					</ul>
				</div>
			</div>
		</section>

	</div>

</body>
</html>