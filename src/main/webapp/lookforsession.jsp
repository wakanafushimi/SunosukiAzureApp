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
					<li class="nav-item"><a
						class="nav-link headermenu menuhere semi"
						href="SessionListServlet?date=datenull">イベントを探す</a></li>
					<li class="nav-item"><a class="nav-link headermenu semi"
						href="PeersServlet">仲間を探す</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="container">
		<form action="ForSessionServlet" method="get">
			<div class="row justify-content-center showtop gapbottom">
				<div class="row col-lg-6">
					<div class="col-lg-5 col-12">日付で検索</div>
					<div class="col-lg-5 col-9">
						<input type="date" name="date" class="form-control inline-block">
					</div>
					<div class="col-1">
						<button type="submit">
							<i class="fa-solid fa-magnifying-glass"></i>
						</button>
					</div>
				</div>
			</div>
		</form>

		<div class="row justify-content-center">
			<div class="col-lg-6 col-12 sessionitems">
				<ul class="list-group">

					<c:forEach var="sessiondetail"
						items="${sessionListModel.sessiondetailList}">
						<li class="list-group-item bg-light mt-3 peerslist">
							<div class="row">
								<div class="col-9">
									<div class="row mb-1">
										<div class="col-lg-5">
											<c:out value="${sessiondetail[1]}" />
										</div>
										<div class="col-lg-6">
											<c:out value="${sessiondetail[2]}" />
										</div>
									</div>
									<div class="row">
										<div class="col-lg-5 semi">
											<span class="">作成者：</span>
											<c:out value="${sessiondetail[4]}" />
										</div>
										<div class="col-lg-2 col-4 mini openmodal">
											<i class="fa-solid fa-user"></i>
											<c:out value="${sessiondetail[5]}" />
										</div>
										<div class="col-lg-2 col-4 mini">
											<i class="fa-solid fa-car"></i>
											<c:out value="${sessiondetail[6]}" />
										</div>
									</div>
								</div>

								<c:if test="${loginModel.id!= sessiondetail[7]}">
									<%--<c:out value="id:${loginModel.id }"/>
									<c:out value="主催者id:${sessiondetail[7]}"/>--%>

									<%--<%System.out.println("主催者ではない"); --%>

									<%
									boolean ismember = false;
									pageContext.setAttribute("ismember", ismember);
									%>
									<c:forEach var="memberids"
										items="${sessionListModel.memberidList}">
										<%--<c:out value="メンバー:${memberid}"/> --%>
										<c:if test="${memberids.get(0)==sessiondetail[0]}">
											<c:forEach var="memberid" items="${memberids}">
												<c:if test="${memberid==loginModel.id}">
													<%--<%System.out.println("メンバーである"); --%>
													<div class="col-3 center">
														<a
															href="NotjoinServlet?action=${sessiondetail[0]}&date=datenull"
															class="btn btn-secondary btn-sm mini">キャンセル</a>
													</div>
													<%
													ismember = true;
													%>
													<%
													pageContext.setAttribute("ismember", ismember);
													%>
												</c:if>
											</c:forEach>
										</c:if>
									</c:forEach>

									<c:if test="${ismember!=true}">
										<%--<c:out value="${sessiondetail[0]}"/>--%>
										<div class="col-3 center">
											<a
												href="JoinServlet?action=${sessiondetail[0]}&date=datenull"
												class="btn btn-primary btn-sm mini">参加</a>
										</div>
									</c:if>
								</c:if>
							</div>


							<div class="popup mt-2">
								<!-- modal -->
								<!-- listにlist-group,list-group-itemをつけるとimgが横並びにならないから注意 -->
								<ul class="d-flex memberlist">
									<c:forEach var="memberdetailList"
										items="${sessionListModel.memberdetailListList}">
										<c:forEach var="memberdetail" items="${memberdetailList}">
											<c:if test="${memberdetail[0]==sessiondetail[0]}">
												<li class="row">
													<div class="openmemberdetail">
														<div class="imgcontainerSession img-fluid m-1">
															<img src="uploads/${memberdetail[2]}"
																class="rounded-circle" />
														</div>
													</div>


													<div class="memberdetailpopup shadow-lg col-9">
														<!-- peerdetailpopup -->
														<div class="row d-flex my-1">
															<div class="">
																<div class="imgcontainerSessiondetail img-fluid">
																	<img src="uploads/${memberdetail[2]}"
																		class="rounded-circle" />
																</div>
															</div>
															<div class="">
																<c:out value="${memberdetail[3]}" />
															</div>
														</div>
														<div class="row underline">
															<div class="col-5">
																<p class="mini">都道府県</p>
															</div>
															<div class="col-7">
																<p class="semi text-muted mt-2">${memberdetail[4]}</p>
															</div>
														</div>


														<div class="row underline">
															<div class="col-5">
																<p class="mini">車の有無</p>
															</div>
															<div class="col-7">
																<p class="semi text-muted mt-2">${memberdetail[5]}</p>
															</div>
														</div>

														<div class="row underline">
															<div class="col-5">
																<p class="mini">滑りのスタイル</p>
															</div>
															<div class="col-7">
																<p class="semi text-muted mt-2">${memberdetail[6]}</p>
															</div>
														</div>

														<div class="row underline">
															<div class="col-5">
																<p class="mini">ギア</p>
															</div>
															<div class="col-7">
																<p class="semi text-muted mt-2">${memberdetail[7]}</p>
															</div>
														</div>

														<div class="row underline">
															<div class="col-5">
																<p class="mini">SNS</p>
															</div>

															<div class="col-7">
																<p class="mt-2">
																	<c:if test="${memberdetail[9]!=null}">
																		<a href="${memberdetail[9]}" target="_blank"
																			class="text-muted"><i
																			class="fa-brands fa-instagram"></i></a>
																	</c:if>
																	<c:if test="${memberdetail[10]!=null}">
																		<a href="${memberdetail[10]}" target="_blank"
																			class="text-muted"><i
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
																<p class="semi text-muted mt-2">${memberdetail[8]}</p>
															</div>
														</div>

														<c:forEach var="id" items="${existinguser}">
															<!--教えられる技 -->
															<c:if test="${memberdetail[1]==id}">
																<div class="row underline">
																	<div class="col-5">
																		<p class="mini">教えられる</p>
																	</div>
																	<div class="col-7">
																		<c:forEach var="trick_aArray" items="${peersTrick_a}">
																			<c:if test="${trick_aArray[0]==memberdetail[1]}">
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


														<div class="row">
															<!-- 練習中技 -->
															<div class="col-5">
																<p class="mini">練習中</p>
															</div>
															<div class="col-7">
																<c:forEach var="trick_bArray" items="${peersTrick_b}">
																	<c:if test="${trick_bArray[0]==memberdetail[1]}">
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

														<div class="cancelmemberdetail">
															<i class="fa-solid fa-xmark"></i>
														</div>
													</div>
												</li>
											</c:if>
										</c:forEach>
									</c:forEach>
								</ul>
								<div class="row">
									<div class="sessionmessage mt-2">
										<i class="fa-regular fa-message mini"></i>
										<p class="mini">
											<c:out value="${sessiondetail[3]}" />
										</p>
									</div>
								</div>
								<div class="cancel cancelsession">
									<i class="fa-solid fa-chevron-up"></i>
								</div>
							</div>
						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
	</div>
	<jsp:include page="menu.jsp" />
</body>
</html>
