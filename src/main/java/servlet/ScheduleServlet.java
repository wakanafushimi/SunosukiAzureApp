package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ScheduleDAO;
import dao.SessionListDAO;
import model.LoginModel;
import model.ScheduleModel;
import model.SessionListModel;

/**
 * Servlet implementation class ScheduleServlet
 */
@WebServlet("/ScheduleServlet")
public class ScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		ScheduleModel scheduleModel=new ScheduleModel();
		ScheduleDAO scheduleDAO=new ScheduleDAO();
		scheduleModel=scheduleDAO.getYoursessionList(loginModel,scheduleModel);
		
		SessionListModel sessionListModel=new SessionListModel();
		SessionListDAO sessionListDAO =new SessionListDAO();
		sessionListModel=sessionListDAO.setSession(sessionListModel);
		
		session.setAttribute("sessionListModel",sessionListModel);
		session.setAttribute("scheduleModel",scheduleModel);
		RequestDispatcher dispatcher=request.getRequestDispatcher("schedule.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
