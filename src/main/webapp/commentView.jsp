<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.List"
	import="sample.CommentBean"%>
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
	<main role="main">



		<div class="album py-5 bg-light">
			<h3>スレッド詳細</h3>
			<div class="container">
					<%
					List<CommentBean> list = (List<CommentBean>) request.getAttribute("data");
					for (CommentBean cb : list) {
					%>
					<div class="card mb-4 shadow-sm" align="center">
						<div class="card-body">
							<div align="left">
								投稿者：
								<p"><%=cb.getName() %></p>
								コメント
								<p class="card-text sample tovf2"><%=cb.getMessage() %></p>
							</div>
						</div>

					</div>
					<%
					}
					%>
			</div>
		</div>
		<section class="jumbotron text-left">
			<div class="container">
				<h3 class="jumbotron-heading">コメント書き込み</h3>

				<form action="CommentController" method="POST">
					<input type="text" name="message">
					 <input type="hidden" name="threadNumber" value=<%=list.get(0).getThreadNumber() %>>
					<!-- <form:textarea path="message" rows="5" cols="30"></form:textarea> -->
					<input type="submit" value="書き込む">
				</form>
			</div>
		</section>
	</main>
	<jsp:include page="footer.jsp" flush="true" />
</body>
</html>