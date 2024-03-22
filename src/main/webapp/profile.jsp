<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
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
</head>
<body>
	<jsp:include page="header.jsp" />

	<div class="container">
		<div class="pagetitle showtop gapbottom">
			<h3 class="center">プロフィール</h3>
		</div>

		<div class="row justify-content-center">

			<div class="col-lg-3 mb-3">
				<div class="p-3 bg-light imgcontainer">
					<img src="uploads/${newprofileModel.img}" class="img-fluid">
				</div>
			</div>

			<div class="col-lg-6">
				<div class="card mb-4">
					<div class="card-body">

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">ユーザネーム</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.username }</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">都道府県</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.pref }</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">車の有無</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.car}</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">滑りのスタイル</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.style}</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">ギア</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.geer}</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">Instagram アカウント</p>
							</div>
							<div class="col-7">
								<p class="semi">
									<a href="${newprofileModel.insta}" target="_blank"
										class="text-muted">${newprofileModel.insta}</a>
								</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">X アカウント</p>
							</div>
							<div class="col-7">
								<p class="semi">
									<a href="${newprofileModel.x}" target="_blank"
										class="text-muted">${newprofileModel.x}</a>
								</p>
							</div>
						</div>

						<div class="row mt-2 underline">
							<div class="col-5">
								<p class="mini">メッセージ</p>
							</div>
							<div class="col-7">
								<p class="text-muted">${newprofileModel.selfintro}</p>
							</div>
						</div>

						<div>
							<a href="profile_edit.jsp" class="center"><span
								class="btn btn-success btn-sm mt-2">編集</span></a>
						</div>
					</div>
				</div>

				<div class="card showbottom">
					<div class="card-body">
						<div class="row underline">

							<div class="col-lg-5">
								<p class="mt-1 mb-2 mini">教えられるトリック</p>
							</div>
							<div class="col-lg-7">
								<div class="text-muted mt-1 mb-2">
									<c:forEach var="i" items="${trickModel.getTrick_aList()}">
										<div class="d-inline-block mb-1">
											<c:out value="${i}" />
											<a href="TrickServlet?deleteValuea=${i}" class="minus ms-1"><i
												class="fa-solid fa-minus"></i></a>
										</div>
									</c:forEach>

									<div class="d-inline-block mb-0">
										<form action="TrickServlet" method="get">
											<div class="d-flex">
												<input type="text" name="trick_a" placeholder=""
													class="mb-2" size="10">
												<button type="submit" class="plus ms-1">
													<i class="fa-solid fa-plus"></i>
												</button>
											</div>
										</form>
									</div>

								</div>
							</div>
						</div>
						<!-- row -->

						<div class="row">
							<div class="col-lg-5">
								<p class="mt-1 mb-2 mini">練習中トリック</p>
							</div>
							<div class="col-lg-7">
								<div class="text-muted mt-1 mb-2">
									<c:forEach var="i" items="${trickModel.getTrick_bList()}">
										<div class="d-inline-block mb-1">
											<c:out value="${i}" />
											<a href="TrickServlet?deleteValueb=${i}" class="minus ms-1"><i
												class="fa-solid fa-minus"></i></a>
										</div>
									</c:forEach>

									<div class="d-inline-block mb-0">
										<form action="TrickServlet" method="get">
											<div class="d-flex">
												<input type="text" name="trick_b" placeholder=""
													class="mb-2" size="10">
												<button type="submit" class="plus ms-1">
													<i class="fa-solid fa-plus"></i>
												</button>
											</div>
										</form>
									</div>
								</div>
							</div>
						</div>
						<!-- row -->



					</div>
				</div>
			</div>
		</div>
	</div>

	<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
	<ul class="nav justify-content-around">
		<li class="nav-item"><a class="nav-link nav-link-footer menuhere" href="TrickServlet"><i
				class="fa-solid fa-user center"></i>
			<p class="smallfooterletter">プロフィール</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer" href="ScheduleServlet"><i
				class="fa-regular fa-calendar-days center"></i>
			<p class="smallfooterletter">スケジュール</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer" href="createsession.jsp"><i
				class="fa-solid fa-pen-to-square center"></i>
			<p class="smallfooterletter">イベント作成</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer" href="index.jsp"><i
				class="fa-solid fa-arrow-right-from-bracket center"></i>
			<p class="smallfooterletter">ログアウト</p></a></li>

	</ul>
</div>


<div class="fixed-bottom widefooter">
	<ul class="nav bg-light justify-content-center widefooterchild">
		<li class="nav-item px-3"><a class="nav-link menuhere" href="TrickServlet">プロフィール</a>
		</li>
		<li class="nav-item px-3"><a class="nav-link"
			href="ScheduleServlet">スケジュール</a></li>
		<li class="nav-item px-3"><a class="nav-link"
			href="createsession.jsp">イベント作成</a></li>
		<li class="nav-item px-3"><a class="nav-link" href="index.jsp">ログアウト</a>
		</li>
	</ul>
</div>

</body>
</html>