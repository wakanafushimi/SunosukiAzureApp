<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sunosuki</title>
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
<link rel="stylesheet" href="style01.css">
<script defer type="module" src="script.js"></script>

</head>
<body>
	<jsp:include page="header.jsp" />
	<div class="container">
		<div class="pagetitle showtop gapbottom">
			<h3 class="center">イベント作成</h3>
		</div>
		<form action="SessionServlet" method="get">
			<div class="row justify-content-center showbottom">
				<div class="col-lg-4 bg-light p-3 peerslist">
					<div class="">
						<label class="form-label mt-3">日付</label> <input type="date"
							class="form-control" name="date"></input>
					</div>

					<%--以下js適応エリア --%>
					<div id="gerendeselect">
						<label class="form-label mt-3">ゲレンデ</label> <select
							class="prefectures form-control" id="prefecture"></select> <select
							name="location" class="gerende form-control" id="gerende"></select>
					</div>

					<div class="">
						<label class="form-label mt-3">メッセージ</label>
						<textarea name="message" class="form-control" placeholder="募集コメント"></textarea>
					</div>

					<div class="mt-2">
						<input type="submit" value="作成" class="btn btn-success btn-sm"></input>
					</div>
				</div>
			</div>
		</form>
	</div>

	<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
	<ul class="nav justify-content-around">
		<li class="nav-item"><a class="nav-link nav-link-footer" href="TrickServlet"><i
				class="fa-solid fa-user center"></i>
			<p class="smallfooterletter">プロフィール</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer" href="ScheduleServlet"><i
				class="fa-regular fa-calendar-days center"></i>
			<p class="smallfooterletter">スケジュール</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer menuhere" href="createsession.jsp"><i
				class="fa-solid fa-pen-to-square center"></i>
			<p class="smallfooterletter">イベント作成</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer" href="index.jsp"><i
				class="fa-solid fa-arrow-right-from-bracket center"></i>
			<p class="smallfooterletter">ログアウト</p></a></li>

	</ul>
</div>


<div class="fixed-bottom widefooter">
	<ul class="nav bg-light justify-content-center widefooterchild">
		<li class="nav-item px-3"><a class="nav-link" href="TrickServlet">プロフィール</a>
		</li>
		<li class="nav-item px-3"><a class="nav-link"
			href="ScheduleServlet">スケジュール</a></li>
		<li class="nav-item px-3"><a class="nav-link menuhere"
			href="createsession.jsp">イベント作成</a></li>
		<li class="nav-item px-3"><a class="nav-link" href="index.jsp">ログアウト</a>
		</li>
	</ul>
</div>


	<%--<script>
	const gerendeselect=document.getElementById("gerendeselect")
	gerendeselect.addEventListener("click",()=>{
		alert("クリック")})
</script>  --%>

</body>
</html>