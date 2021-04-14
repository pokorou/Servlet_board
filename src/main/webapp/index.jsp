<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<!-- <link rel="canonical"
	href="https://getbootstrap.com/docs/5.0/examples/navbar-fixed/">
 -->




<!-- Bootstrap core CSS -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="css/navbar-top-fixed.css">

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
</head>
<body>
 <jsp:include page="header.jsp" flush="true" />
	
	<main class="container">
		<h2>スレッド一覧</h2>
		<div class="bg-light p-5 rounded">
			<h3>タイトル:</h3>
			<p class="lead">名前:</p>
			<p class="lead">コメント:</p>
			<div align=right>
				<a class="btn btn-lg btn-primary" href="../components/navbar/"
					role="button">詳細を見る &raquo;</a>
			</div>
		</div>
		<hr noshade></hr>
		<h2>スレッド新規作成</h2>
		<div class="bg-light p-5 rounded">
			<form action="/ServletSample/IndexController" method="POST">
				<div class="lead">
					タイトル名: <input type="text" name=title>
				</div>
				<div class="lead">コメント:</div>
				<textarea rows="5" cols="30" name=message></textarea>
				<input type="hidden" name="buttonName" value=newThread>
				<input type="submit" value="書き込み">
			</form>
		</div>
	</main>

<jsp:include page="footer.jsp" flush="true" />

</body>
</html>
