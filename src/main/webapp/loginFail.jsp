<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Sunosuki</title>
<link rel="stylesheet" href="style01.css">
<script src="https://kit.fontawesome.com/5235b688ad.js"
	crossorigin="anonymous"></script>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
</head>

<body>
	<nav class="navbar bg-body-tertiary bg-light fixed-top">
		<div class="container-fluid">
			<span class="navbar-brand mb-0 h1">Sunosuki</span>
		</div>
	</nav>

	<div class="pagetitle">
		<h2 class="center">ログインに失敗しました</h2>
	</div>
	<a href="index.jsp" class="center">戻る</a>

	<jsp:include page="footer.jsp" />


</body>
</html>