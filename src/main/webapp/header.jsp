<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%--<nav class="navbar bg-body-tertiary bg-light fixed-top">
  <div class="container-fluid">
    <a class="navbar-brand h1" href="top.jsp">Sunosuki</a>
  </div>
</nav>
--%>

<nav class="navbar navbar-expand-lg bg-body-tertiary bg-light fixed-top">
	<div class="container-fluid">
		<a class="navbar-brand" href="top.jsp">Sunosuki</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-controls="navbarNav"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link headermenu semi"
					href="SessionListServlet?date=datenull">イベントを探す</a></li>
				<li class="nav-item"><a class="nav-link headermenu semi"
					href="PeersServlet">仲間を探す</a></li>
			</ul>
		</div>
	</div>
</nav>
