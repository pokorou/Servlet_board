<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">掲示板</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarCollapse" aria-controls="navbarCollapse"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarCollapse" >
			<ul class="navbar-nav me-auto mb-2 mb-md-0 " >
				<li class=" active nav-link "  >名前：</li>
				<li class="nav-item  active nav-link"><%=session.getAttribute("name")%></li>
				<li class="nav-item nav-link"><form class="d-flex" action="/ServletSample/IndexController" method="POST">
				<input type="hidden" name="buttonName" value="changeName">
				<button class="btn btn-outline-success" type="submit">名前の変更</button>
			</form></li>
			</ul>



			<form class="d-flex" action="IndexController" method="post">
				<input type="hidden" name="buttonName" value="search">
				<input class="form-control me-2" type="search" placeholder="Search" name="searchWord"
					aria-label="Search">
				<button class="btn btn-outline-success" type="submit">Search</button>
			</form>
		</div>
	</div>
</nav>