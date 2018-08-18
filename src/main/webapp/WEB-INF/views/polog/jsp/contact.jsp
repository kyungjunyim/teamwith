<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>

<link rel="stylesheet" type="text/css" href="/teamwith15/polog/css/contact.css">
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
<script type="text/javascript" async="" src="https://www.google-analytics.com/analytics.js"></script>
</head>
<body>
	<div class="container" style="padding: 20px;">
		<div id="contact" class="section scrollspy">
			<h3 style="text-align: center;">Contact</h3>
			<div class="card medium">
				<div class="card-image waves-effect waves-block waves-light">
					<img class="activator" src="/teamwith15/image/contact.gif">
				</div>
				<div class="card-content">
				<!-- 버튼 -->
					<span class="card-title activator" style="text-align: right;"><a
						class="btn-floating waves-effect waves-light red pulse"><i
							class="large material-icons">arrow_drop_up</i></a></span>
					<div class="row" style="text-align: center">
						<a class="waves-effect waves-light btn grey darken-1"

							target="_blank" href="https://github.com/HWANGKYUJIN/fastbooster"><i
							class="material-icons right">code</i>Github</a> <a
							class="waves-effect waves-light btn green darken-2"
							target="_blank" href=""><i

							class="material-icons right">library_books</i>Medium</a>
					</div>
				</div>
				<div class="card-reveal">
					<span class="card-title grey-text text-darken-4">Contact Me<i
						size="large" class="material-icons right">close</i></span>
					<form class="col s12"
						action="https://formspree.io/a@gmail.com" method="POST">
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
</body>
<script src="/teamwith15/polog/js/contact.js"></script>
</html>