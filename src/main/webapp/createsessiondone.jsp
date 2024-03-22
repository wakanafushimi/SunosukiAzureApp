<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<title>Sunosuki</title>
<link rel="stylesheet" href="style01.css">
<script src="https://kit.fontawesome.com/5235b688ad.js" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="pagetitle showtop gapbottom">
<h3 class="center">Done</h3>
</div>
<div class="center"><a href="SessionListServlet?date=datenull"><i class="fa-solid fa-arrow-left"></i>View all Sessions</a></div>

<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
		<ul class="nav justify-content-around">
			<li class="nav-item"><a class="nav-link" href="TrickServlet"><i
					class="fa-solid fa-user"></i></a></li>
			<li class="nav-item"><a class="nav-link" href="ScheduleServlet"><i
					class="fa-regular fa-calendar-days"></i></a></li>
			<li class="nav-item"><a class="nav-link menuhere"
				href="createsession.jsp"><i class="fa-solid fa-pen-to-square"></i></a></li>
			<li class="nav-item"><a class="nav-link" href="index.jsp"><i
					class="fa-solid fa-arrow-right-from-bracket"></i></a></li>

		</ul>
	</div>


	<div class="fixed-bottom widefooter">
		<ul class="nav bg-light justify-content-center widefooterchild">
			<li class="nav-item px-3"><a class="nav-link"
				href="TrickServlet">Profile</a></li>
			<li class="nav-item px-3"><a class="nav-link"
				href="ScheduleServlet">Schedule</a></li>
			<li class="nav-item px-3"><a class="nav-link menuhere"
				href="createsession.jsp">Create Session</a></li>
			<li class="nav-item px-3"><a class="nav-link" href="index.jsp">Sign
					out</a></li>
		</ul>
	</div>

</body>
</html>