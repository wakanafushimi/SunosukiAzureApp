<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<nav
		class="navbar navbar-expand-lg bg-body-tertiary bg-light fixed-top">
		<div class="container-fluid">
			<a class="navbar-brand" href="top.jsp">Sunosuki</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav">
					<li class="nav-item"><a class="nav-link headermenu semi"
						href="SessionListServlet?date=datenull">Look For Sessions</a></li>
					<li class="nav-item"><a
						class="nav-link headermenu menuhere semi" href="PeersServlet">Look
							For Peers</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="row justify-content-center showtop gapbottom">
			<div class="col-lg-6">
				<div class="col-lg-5 col-12">
					<a href="PeersServlet"> <i class="fa-solid fa-arrow-left"></i>View
						all Peers
					</a>
				</div>
			</div>
		</div>

		<div class="row justify-content-center">
			<div class="col-lg-4 showbottom">
				<ul class="list-group">
					<c:forEach var="coach" items="${coaches}">
						<c:forEach var="peer" items="${peers}">
							<c:if test="${coach==peer[0] }">
								<li class="mt-2 list-group-item peerslist">
									<div class="row openmodal">
										<div class="col-3">
											<!-- 左エリア -->
											<div class="imgcontainerPeers">
												<img src="uploads/${peer[1]}"
													class="rounded-circle img-fluid">
											</div>
										</div>
										<!-- 左エリア -->
										<div class="col-7 justify-content-center">
											<!-- 右エリア -->
											<div class="peername mb-1">${peer[2]}</div>
											<!-- 名前 -->
										</div>
										<!-- 右エリア -->
									</div>
								</li>

								<!-------------------- modal -------------------->
								<li class="list-group-item popup peerslist peerpopup pb-4">
									<div class="peerslist">
										<div class="row underline">
											<div class="col-5">
												<p class="mini">都道府県</p>
											</div>
											<div class="col-7">
												<p class="semi text-muted mt-2">${peer[3]}</p>
											</div>
										</div>

										<div class="row underline">
											<div class="col-5">
												<p class="mini">車の有無</p>
											</div>
											<div class="col-7">
												<p class="semi text-muted mt-2">${peer[4]}</p>
											</div>
										</div>

										<div class="row underline">
											<div class="col-5">
												<p class="mini">滑りのスタイル</p>
											</div>
											<div class="col-7">
												<p class="semi text-muted mt-2">${peer[5]}</p>
											</div>
										</div>

										<div class="row underline">
											<div class="col-5">
												<p class="mini">ギア</p>
											</div>
											<div class="col-7">
												<p class="semi text-muted mt-2">${peer[6]}</p>
											</div>
										</div>

										<div class="row underline">
											<div class="col-5">
												<p class="mini">SNS</p>
											</div>

											<div class="col-7">
												<p class="mt-2">
													<c:if test="${peer[8]!=null}">
														<a href="${peer[8]}" target="_blank" class="text-muted"><i
															class="fa-brands fa-instagram"></i></a>
													</c:if>
													<c:if test="${peer[9]!=null}">
														<a href="${peer[9]}" target="_blank" class="text-muted"><i
															class="fa-brands fa-x-twitter"></i></a>
													</c:if>
												</p>
											</div>
										</div>

										<div class="row underline">
											<div class="col-5">
												<p class="mini">メッセージ</p>
											</div>
											<div class="col-7">
												<p class="semi text-muted mt-2">${peer[7]}</p>
											</div>
										</div>

										<c:forEach var="id" items="${existinguser}">
											<!--教えられる技 -->
											<c:if test="${peer[0]==id}">
												<div class="row underline">
													<div class="col-5">
														<p class="mini">教えられる</p>
													</div>
													<div class="col-7">
														<c:forEach var="trick_aArray" items="${peersTrick_a}">
															<c:if test="${trick_aArray[0]==peer[0]}">
																<div class="d-inline-block pe-2">
																	<p class="text-muted semi mt-2">
																		<c:out value="${trick_aArray[1]}" />
																	</p>
																</div>
															</c:if>
														</c:forEach>
													</div>
												</div>
											</c:if>
										</c:forEach>

										<div class="row underline">
											<!-- 練習中技 -->
											<div class="col-5">
												<p class="mini">練習中</p>
											</div>
											<div class="col-7">
												<c:forEach var="trick_bArray" items="${peersTrick_b}">
													<c:if test="${trick_bArray[0]==peer[0]}">
														<div class="d-inline-block pe-2">
															<p class="text-muted semi mt-2">
																<c:out value="${trick_bArray[1]}" />
															</p>
														</div>
													</c:if>
												</c:forEach>
											</div>
										</div>
										<!-- 練習中技 -->

										<div class="row pt-2">
											<div class="semi">
												<a href="PeersScheduleServlet?id=${peer[0]}&name=${peer[2]}"
													class="viewpeerssession">View <c:out value="${peer[2]}" />'s
													schedule <i class="fa-solid fa-arrow-right"></i></a>
											</div>
										</div>
										<div class="cancel">
											<i class="fa-solid fa-xmark"></i>
										</div>
									</div>
								</li>
							</c:if>
						</c:forEach>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="menu.jsp" />
</body>
</html>