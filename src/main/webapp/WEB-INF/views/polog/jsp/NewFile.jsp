<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="/assets/css/materialize.css">
<link rel="stylesheet"
	href="https://cdn.rawgit.com/konpa/devicon/df6431e323547add1b4cf45992913f15286456d3/devicon.min.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
<title>James Hamann</title>
<script type="text/javascript">
	screen.width <= 699 && (document.location = "mobile.html");
</script>
</head>
<body>
	<div id="home" class="section scrollspy">
		<div id="index-banner" class="parallax-container">
			<div class="section no-pad-bot">
				<div class="container">
					<br>
					<br>
					<h1 class="header center teal-text text-lighten-2">James
						Hamann</h1>
					<div class="row center">
						<h5 class="header col s12 light">Software Developer</h5>
					</div>
					<p style="text-align: center;">
						<a class="waves-effect waves-light btn grey darken-3 z-depth-3"
							href="/blog/index.html"><i class="material-icons right">library_books</i>Blog</a>
					</p>
					<br>
					<br>
				</div>
			</div>
			<div class="parallax">
				<img src="assets/images/startup3.jpg"
					alt="Unsplashed background img 1">
			</div>
		</div>
	</div>
	<div id="cookies" style="display: show">
		<p style="text-align: left; padding-left: 8px">
			<a value="hide/show" id="check"
				class="waves-effect waves-light green lighten-1 btn btn-floating pulse"
				onclick="Materialize.toast('Thanks!', 2000)"><i
				class="material-icons">check</i></a>
		</p>
		<div class="tap-target" data-activates="check">
			<div class="tap-target-content">
				<h5 style="color: black;">Cookie Policy</h5>
				<p>We use Cookies on this website to track usage. By contiuning
					to use this website, you agree to the use of Cookies.</p>
				<br>
				<br>
				<br>
				<p>
					<b>For more information visit the <a href>Cookie Law
							Website.</a><b></b></b>
				</p>
			</div>
		</div>
	</div>
	<div class="container" style="padding: 20px;">
		<div id="portfolio" class="section scrollspy">
			<h3 style="text-align: center;">Portfolio</h3>
			<div class="row">
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/jekyll.jpg">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">Jekyll
								Display Medium Posts<i class="material-icons right">more_vert</i>
							</span>
							<p>
								<a
									href="https://github.com/jameshamann/jekyll-display-medium-posts">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>A Ruby Gem that fetches your RSS feed, parses and saves
								the request to be used within your Jekyll Site.</p>
							<a class="waves-effect grey darken-2 z-depth-4 waves-light btn"
								href="https://rubygems.org/gems/jekyll-display-medium-posts"
								target="_blank"><i class="material-icons right">web</i>View
								Gem</a>
						</div>
					</div>
				</div>
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/ethe.jpg">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">CrypCheck<i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="https://github.com/jameshamann/crypto-price-check">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>A Chrome Extension that allows a user to check the price,
								in real time, of Bitcoin (BTC), Ethereum (ETH) and Litecoin
								(LTC). Built with Javascript.</p>
							<a class="waves-effect grey darken-2 z-depth-4 waves-light btn"
								href="https://chrome.google.com/webstore/detail/crypcheck/lafbodcgahbokcblephohaafmmnnffhp"
								target="_blank"><i class="material-icons right">web</i>View
								in Chrome Store</a>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/searcher.svg"
								style="height: 366px;">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">Searcher<i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="https://github.com/jameshamann/searcher-reactnative">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>An iOS/Android App which allows users to search ratings
								and reviews for TVShows and Movies. Built using React Native.</p>
						</div>
					</div>
				</div>
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/beer.jpg">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">Crafty<i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="https://github.com/jameshamann/crafty-webapp">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>A web app that allows a user to check and rate craft
								beers. Built using Rails, Materialize, RSpec, Capybara and
								deployed on AWS Elastic Beanstalk. A mobile version is also in
								development and coming soon!</p>
						</div>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/jekyll.png">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">Jekyll
								Material Theme<i class="material-icons right">more_vert</i>
							</span>
							<p>
								<a href="https://github.com/jameshamann/jekyll-material-theme">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>A Jekyll Gem Theme based on Material Design using
								Materialize, currently being used on this site.</p>
							<a class="waves-effect grey darken-2 z-depth-4 waves-light btn"
								href="https://rubygems.org/gems/jekyll-material-theme"
								target="_blank"><i class="material-icons right">web</i>View
								Gem</a>
						</div>
					</div>
				</div>
				<div class="col s12 m6">
					<div class="card medium sticky-action">
						<div class="card-image waves-effect waves-block waves-light">
							<img class="activator" src="../assets/images/turfy.png" style="">
						</div>
						<div class="card-action">
							<span class="card-title activator grey-text text-darken-4">Turfy<i
								class="material-icons right">more_vert</i></span>
							<p>
								<a href="https://github.com/Lawrence-Dawson/turfy">Github</a>
							</p>
						</div>
						<div class="card-reveal">
							<span class="card-title grey-text text-darken-4"><i
								class="material-icons right">close</i></span>
							<p>A group project building an iOS app for location based
								messaging using XCode, Swift 3 and Firebase.</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="container" style="padding: 20px;">
		<div id="skills" class="section scrollspy">
			<h3 style="text-align: center;">Tools and Experience</h3>
			<div class="row">
				<div class="col s12">
					<div class="card">
						<div class="card-image">
							<span class="card-title"><a style="color: white" href=""></a></span>
						</div>
						<div class="card-content">
							<p style="font-size: 50px">
								<i class="devicon-amazonwebservices-original colored"></i> <i
									class="devicon-atom-original colored"></i> <i
									class="devicon-bitbucket-plain-wordmark colored"></i> <i
									class="devicon-bootstrap-plain-wordmark colored"></i> <i
									class="devicon-github-plain-wordmark colored"></i> <i
									class="devicon-heroku-line-wordmark colored"></i> <i
									class="devicon-jasmine-plain-wordmark colored"></i> <i
									class="devicon-javascript-plain colored"></i> <i
									class="devicon-jquery-plain-wordmark colored"></i> <i
									class="devicon-nginx-original colored"></i> <i
									class="devicon-nodejs-plain colored"></i> <i
									class="devicon-postgresql-plain-wordmark colored"></i> <i
									class="devicon-rails-plain-wordmark colored"></i> <i
									class="devicon-react-original-wordmark colored"></i> <i
									class="devicon-ruby-plain-wordmark colored"></i> <i
									class="devicon-ubuntu-plain-wordmark colored"></i> <i
									class="devicon-wordpress-plain colored"></i>
							</p>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<div class="parallax-container valign-wrapper">
		<div class="section no-pad-bot">
			<div class="container">
				<div class="row center"></div>
			</div>
		</div>
		<div class="parallax">
			<img src="assets/images/startup3.jpg"
				alt="Unsplashed background img 3">
		</div>
	</div>
	<div class="container" style="padding: 20px;">
		<div id="contact" class="section scrollspy">
			<h3 style="text-align: center;">Contact</h3>
			<div class="card medium">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="assets/images/contact4.png">
				</div>
				<div class="card-content">
					<span class="card-title activator" style="text-align: right;"><a
						class="btn-floating waves-effect waves-light red pulse"><i
							class="large material-icons">arrow_drop_up</i></a></span>
					<div class="row" style="text-align: center">
						<a class="waves-effect waves-light btn grey darken-1"
							target="_blank" href="https://github.com/jameshamann"><i
							class="material-icons right">code</i>Github</a> <a
							class="waves-effect waves-light btn green darken-2"
							target="_blank" href="https://medium.com/@jameshamann/"><i
							class="material-icons right">library_books</i>Medium</a>
					</div>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Contact Me<i
						size="large" class="material-icons right">close</i></span>
					<form class="col s12"
						action="https://formspree.io/jameshamann0@gmail.com" method="POST">
						<div class="row">
							<div class="input-field col s6">
								<i class="material-icons prefix">account_circle</i> <input
									class="validate" id="icon_prefix" type="text" name="name">
								<label for="icon_prefix">Name</label>
							</div>
							<div class="input-field col s6">
								<i class="material-icons prefix">email</i> <input
									class="validate" id="email" type="email" name="_replyto">
								<label for="email"
									data-error="Please enter a valid Email Address"
									data-success="Verified!">Email</label>
							</div>
						</div>
						<div class="row">
							<div class="input-field col s12">
								<i class="material-icons prefix">message</i>
								<textarea id="icon_prefix2" class="materialize-textarea"
									name="message"></textarea>
								<label for="icon_prefix2">Message</label>
							</div>
						</div>
						<button
							class="btn waves-effect grey waves-dark darken-3 white-text z-depth-4"
							type="submit" name="action">
							Submit <i class="material-icons right">send</i>
						</button>
					</form>
				</div>
			</div>
		</div>
	</div>
	<div class="fixed-action-btn horizontal click-to-toggle">
		<a class="btn-floating btn-large waves-effect waves-default pulse">
			<i class="material-icons">menu</i>
		</a>
		<ul>
			<li><a
				class="btn-floating yellow darken-3 waves-effect waves-default"
				href="#home"><i class="material-icons">arrow_upward</i></a></li>
			<li><a
				class="btn-floating green darken-2 waves-effect waves-default"
				href="#portfolio"><i class="material-icons">code</i></a></li>
			<li><a
				class="btn-floating red darken-1 waves-effect waves-default"
				href="#contact"><i class="material-icons">person</i></a></li>
		</ul>
	</div>
	<script async
		src="https://www.googletagmanager.com/gtag/js?id=UA-110869900-1"></script>
	<script>
		function gtag() {
			dataLayer.push(arguments)
		}
		window.dataLayer = window.dataLayer || [], gtag("js", new Date), gtag(
				"config", "UA-110869900-1");
	</script>
	<script type="text/javascript" src="/assets/js/jquery-3.2.1.min.js"></script>
	<script type="text/javascript" src="/assets/js/materialize.min.js"></script>
	<script src="/assets/js/init.js"></script>
</body>
<footer class="page-footer">
	<div class="footer-copyright" style="padding-left: 30px">
		<i class="material-icons" style="padding-right: 5px">copyright</i>
		<p>2018 Copyright James Hamann | All rights reserved</p>
	</div>
</footer>
</html>