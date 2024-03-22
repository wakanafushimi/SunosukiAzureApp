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
<script defer type="module" src="script.js"></script>
<link rel="stylesheet" href="style01.css">
</head>

<body>
	<jsp:include page="header.jsp" />


	<form action="ProfileServlet" method="post"
		enctype="multipart/form-data">
		<div class="container">

			<div class="pagetitle showtop gapbottom">
				<h3 class="center">Edit Your Profile</h3>
			</div>
			<div class="row justify-content-center">
				<div class="col-lg-3 mb-3">
					<div class="p-3 bg-light imginput">
						<div class="">
							プロフィール画像<input type="file" name="img">
						</div>
					</div>
				</div>

				<div class="col-lg-6 showbottom">
					<div class="card mb-4">
						<div class="card-body">

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">ユーザネーム</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<input type="text" name="username"
											placeholder="${newprofileModel.username}"
											class="form-control">
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">都道府県</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<select name="pref" class="form-select">
											<option value="">${newprofileModel.pref }</option>
											<option value="北海道">北海道</option>
											<option value="青森県">青森県</option>
											<option value="岩手県">岩手県</option>
											<option value="宮城県">宮城県</option>
											<option value="秋田県">秋田県</option>
											<option value="山形県">山形県</option>
											<option value="福島県">福島県</option>
											<option value="茨城県">茨城県</option>
											<option value="栃木県">栃木県</option>
											<option value="群馬県">群馬県</option>
											<option value="埼玉県">埼玉県</option>
											<option value="千葉県">千葉県</option>
											<option value="東京都">東京都</option>
											<option value="神奈川県">神奈川県</option>
											<option value="新潟県">新潟県</option>
											<option value="富山県">富山県</option>
											<option value="石川県">石川県</option>
											<option value="福井県">福井県</option>
											<option value="山梨県">山梨県</option>
											<option value="長野県">長野県</option>
											<option value="岐阜県">岐阜県</option>
											<option value="静岡県">静岡県</option>
											<option value="愛知県">愛知県</option>
											<option value="三重県">三重県</option>
											<option value="滋賀県">滋賀県</option>
											<option value="京都府">京都府</option>
											<option value="大阪府">大阪府</option>
											<option value="兵庫県">兵庫県</option>
											<option value="奈良県">奈良県</option>
											<option value="和歌山県">和歌山県</option>
											<option value="鳥取県">鳥取県</option>
											<option value="島根県">島根県</option>
											<option value="岡山県">岡山県</option>
											<option value="広島県">広島県</option>
											<option value="山口県">山口県</option>
											<option value="徳島県">徳島県</option>
											<option value="香川県">香川県</option>
											<option value="愛媛県">愛媛県</option>
											<option value="高知県">高知県</option>
											<option value="福岡県">福岡県</option>
											<option value="佐賀県">佐賀県</option>
											<option value="長崎県">長崎県</option>
											<option value="熊本県">熊本県</option>
											<option value="大分県">大分県</option>
											<option value="宮崎県">宮崎県</option>
											<option value="鹿児島県">鹿児島県</option>
											<option value="沖縄県">沖縄県</option>
										</select>
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">車の有無</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<input type="radio" name="car" id="yes" value="あり"
											class="form-check-input">あり<input type="radio"
											name="car" id="no" value="なし" class="form-check-input">なし
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">滑りのスタイル</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<input type="text" name="style" class="form-control"
											placeholder="${newprofileModel.style}">
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">ギア</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<textarea name="geer" class="form-control"
											placeholder="${newprofileModel.geer}"></textarea>
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">Instagram アカウント</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<input type="text" name="insta" class="form-control"
											placeholder="${newprofileModel.insta}">
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">X アカウント</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<input type="text" name="x" class="form-control"
											placeholder="${newprofileModel.x}">
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="row mt-2 underline">
								<div class="col-4">
									<p class="mini">メッセージ</p>
								</div>
								<div class="col-8">
									<p class="text-muted">
										<textarea name="selfintro"
											placeholder="${newprofileModel.selfintro }"
											class="form-control"></textarea>
									</p>
								</div>
							</div>
							<!-- row -->

							<div class="center">
								<input type="submit" class="btn-primary btn btn-sm mt-2"
									value="更新">
							</div>
						</div>
						<!-- card-body -->
					</div>
					<!-- card mb-4 -->
				</div>
				<!-- col-lg-8 profile -->
			</div>
			<!-- row -->

		</div>
		<!-- container -->
	</form>



	<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
		<ul class="nav justify-content-around">
			<li class="nav-item"><a class="nav-link menuhere"
				href="TrickServlet"><i class="fa-solid fa-user"></i></a></li>
			<li class="nav-item"><a class="nav-link" href="ScheduleServlet"><i
					class="fa-regular fa-calendar-days"></i></a></li>
			<li class="nav-item"><a class="nav-link"
				href="createsession.jsp"><i class="fa-solid fa-pen-to-square"></i></a></li>
			<li class="nav-item"><a class="nav-link" href="index.jsp"><i
					class="fa-solid fa-arrow-right-from-bracket"></i></a></li>

		</ul>
	</div>


	<div class="fixed-bottom widefooter">
		<ul class="nav bg-light justify-content-center widefooterchild">
			<li class="nav-item px-3"><a class="nav-link menuhere"
				href="TrickServlet">Profile</a></li>
			<li class="nav-item px-3"><a class="nav-link"
				href="ScheduleServlet">Schedule</a></li>
			<li class="nav-item px-3"><a class="nav-link"
				href="createsession.jsp">Create Session</a></li>
			<li class="nav-item px-3"><a class="nav-link" href="index.jsp">Sign
					out</a></li>
		</ul>
	</div>


</body>
</html>