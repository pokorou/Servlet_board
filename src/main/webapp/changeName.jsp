<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List" import="sample.ThreadBean"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.79.0">
<title>ｊｓｐ掲示板トップ</title>
<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/navbar-top-fixed.css">
<link rel="stylesheet" href="css/sample.css">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}
</style>

<!-- Custom styles for this template -->
<link href="navbar-top-fixed.css" rel="stylesheet">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />

	<div align=center>

		<div class="card mb-4 shadow-sm position-absolute" align="center">
			<div class="card-body">
				<div>
					新しい名前：
					<form action="/ServletSample/NameController" method="POST">
						<input type=text name="newName"> <input type="submit"
							value=変更する>
					</form>
				</div>

			</div>
		</div>
	</div>
</body>
</html>