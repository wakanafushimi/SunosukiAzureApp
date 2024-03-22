<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width,initial-scale=1">
        <title>Sunosuki</title>
        <script src="https://kit.fontawesome.com/5235b688ad.js" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
		<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    	<link rel="stylesheet" href="style01.css">
    </head>

    <body>
    	<jsp:include page="header.jsp"/>
    	
    	<div class="container">
    	<div class="row justify-content-center">
    	<div class="topbutton col-12 col-md-4 p-3">
        <ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link" href="SessionListServlet?date=datenull">Look For Sessions </a>
  </li>
  </ul>
  
  <ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link" href="PeersServlet">Look For Peers </a>
  </li>
  </ul>
  </div>
  </div>
  </div>
        <jsp:include page="menu.jsp"/>
       
        
    </body>
</html>