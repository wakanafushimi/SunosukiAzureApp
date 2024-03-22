<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Sunosuki</title>
<meta name="keywords" content="スノボ、スノーボード、スキー、ゲレンデ、グラトリ">
<meta name="description" content="スキー、スノーボードの仲間を作るサイトです">
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
			<h3 class="center">スケジュール</h3>
		</div>
		<div class="row justify-content-center">
			<div class="col-lg-6 sessionitems">
				<ul class="list-group">
					<c:forEach var="sessiondetail"
						items="${sessionListModel.sessiondetailList}">
						<c:forEach var="yoursession"
							items="${scheduleModel.yoursessionList}">

							<c:if test="${yoursession==sessiondetail[0]}">
								<li class="list-group-item bg-light mt-2">
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

										<c:choose>
											<c:when test="${sessiondetail[7]!=loginModel.id}">
												<div class="col-3 center">
													<a
														href="NotjoinServlet?action=${sessiondetail[0]}&forward=schedule"
														class="btn btn-secondary btn-sm mini">キャンセル</a>
												</div>
											</c:when>
											<c:otherwise>
												<div class="col-3 center">
													<a
														href="DeletesessionServlet?action=${sessiondetail[0]}&forward=schedule"
														class="btn btn-light btn-sm mini" id="deleteBtn">削除</a>
												</div>
											</c:otherwise>
										</c:choose>
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
																				<c:forEach var="trick_aArray"
																					items="${peersTrick_a}">
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
										<div class="mt-1">
											<c:choose>
												<c:when test="${sessiondetail[7]==loginModel.id}">

													<form
														action="EditmessageServlet?sessionid=${sessiondetail[0]}"
														method="post">
														<div class="row">
															<div class="col-9">
																<textarea name="message"
																	placeholder="${sessiondetail[3]}"
																	class="form-control mini"></textarea>
															</div>
															<div class="col-2">
																<button type="submit">
																	<i class="fa-solid fa-pen-to-square"></i>
																</button>
															</div>
														</div>
													</form>

												</c:when>
												<c:otherwise>
													<div class="row">
														<div class="sessionmessage mt-2">
															<i class="fa-regular fa-message mini"></i>
															<p class="mini">
																<c:out value="${sessiondetail[3]}" />
															</p>
														</div>
													</div>
												</c:otherwise>
											</c:choose>

										</div>
										<div class="cancel cancelsession">
											<i class="fa-solid fa-chevron-up"></i>
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
	<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
	<ul class="nav justify-content-around">
		<li class="nav-item"><a class="nav-link nav-link-footer" href="TrickServlet"><i
				class="fa-solid fa-user center"></i>
			<p class="smallfooterletter">プロフィール</p></a></li>
		<li class="nav-item"><a class="nav-link nav-link-footer menuhere" href="ScheduleServlet"><i
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
		<li class="nav-item px-3"><a class="nav-link" href="TrickServlet">プロフィール</a>
		</li>
		<li class="nav-item px-3"><a class="nav-link menuhere"
			href="ScheduleServlet">スケジュール</a></li>
		<li class="nav-item px-3"><a class="nav-link"
			href="createsession.jsp">イベント作成</a></li>
		<li class="nav-item px-3"><a class="nav-link" href="index.jsp">ログアウト</a>
		</li>
	</ul>
</div>
</body>
</html>