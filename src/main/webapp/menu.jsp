<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<div class="fixed-bottom bg-light py-3 px-4 smallfooter">
	<ul class="nav justify-content-around">
		<li class="nav-item"><a class="nav-link nav-link-footer" href="TrickServlet"><i
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
		<li class="nav-item px-3"><a class="nav-link" href="TrickServlet">プロフィール</a>
		</li>
		<li class="nav-item px-3"><a class="nav-link"
			href="ScheduleServlet">スケジュール</a></li>
		<li class="nav-item px-3"><a class="nav-link"
			href="createsession.jsp">イベント作成</a></li>
		<li class="nav-item px-3"><a class="nav-link" href="index.jsp">ログアウト</a>
		</li>
	</ul>
</div>
