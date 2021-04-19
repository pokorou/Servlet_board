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
</head>
<body>
	<jsp:include page="header.jsp" flush="true" />

	<main class="container">
		<h2>スレッド一覧</h2>
		<%
		List<ThreadBean> list = (List<ThreadBean>) request.getAttribute("data");
		for (ThreadBean tb : list) {
		%>
		<div class=" p-5 rounded">
			<div class="bg-light">
				<h3 class="colorblue"><%=tb.getTitle()%></h3>
				<p class="lead">名前:<%=tb.getName() %></p>
				<p class="lead">コメント:<%=tb.getMessage() %></p>
				<div align=right>
				<form action="IndexController"  method="POST">
				<input type="hidden" name="buttonName" value="commentView">
				<input type="hidden" name="threadNumber" value=<%=tb.getId() %>>
					<button class="btn btn-lg btn-primary" type="submit"
						role="button">詳細を見る &raquo;</button>
						</form>
				</div>
			</div>
		</div>
		<%
		}
		%>
		<hr noshade></hr>
		<h2>スレッド新規作成</h2>
		<div class="bg-light p-5 rounded">
			<form action="IndexController" method="POST">
				<div class="lead">
					タイトル名: <input type="text" name=title required>
				</div>
				<div class="lead">コメント:</div>
				<textarea rows="5" cols="30" name=message required></textarea>
				<input type="hidden" name="buttonName" value=newThread> <input
					type="submit" value="書き込み">
			</form>
		</div>
	</main>

	<jsp:include page="footer.jsp" flush="true" />

</body>
</html>
