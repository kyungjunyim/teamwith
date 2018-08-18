<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script type="text/javascript">
	var profileEdit = function() {
		$('#memberId').val('${sessionScope.memberSimpleVO.memberId}');
		$('#memberId_form').submit();
	}
</script>
<body>
	<form action="profileEdit" method="post" id="memberId_form">
		<input type="hidden" name="memberId" id="memberId">
	</form>

	<a href="/teamwith15/home.do" class="logo"><img
		class="teamwith_logo" src="/teamwith15/image/logo/logoBox.png">

	</a>
	<div>

		<div class="fixed-action-btn horizontal click-to-toggle">
			<a class="btn-floating btn-large waves-effect waves-default pulse">
				<i class="material-icons">menu</i>
			</a>
			<ul style="width: 700px">

				<c:if
					test="${sessionScope.memberSimpleVO.memberId == memberVO.memberId }">
					<li><a
						class="btn-floating gray darken-2 waves-effect waves-default">
						<i onclick="profileEdit()" class="material-icons">how_to_reg</i></a></li>
					<li><a
						class="btn-floating gray darken-2 waves-effect waves-default"
						href="pologEdit.jsp"><i class="material-icons">build</i></a></li>
					<li><a
						class="btn-floating gray darken-2 waves-effect waves-default"
						href="#one"><i class="material-icons">add</i></a></li>
				</c:if>
				<li><a
					class="btn-floating yellow darken-3 waves-effect waves-default"
					href="#banner"><i class="material-icons">arrow_upward</i></a></li>
				<li><a
					class="btn-floating blue darken-2 waves-effect waves-default"
					href="#profile"><i class="material-icons">person</i></a></li>
				<li><a
					class="btn-floating green darken-2 waves-effect waves-default"
					href="#one"><i class="material-icons">library_books</i></a></li>
				<li><a
					class="btn-floating red darken-1 waves-effect waves-default"
					href="#contact"><i class="material-icons">contact_mail</i></a></li>
			</ul>
		</div>
	</div>
</body>
</html>