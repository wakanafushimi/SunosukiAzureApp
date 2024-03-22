package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PeersScheduleDAO;
import dao.SessionListDAO;
import model.PeersScheduleModel;
import model.SessionListModel;

/**
 * Servlet implementation class PeersScheduleServlet
 */
@WebServlet("/PeersScheduleServlet")
public class PeersScheduleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeersScheduleServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id=null;
		String name=null;
		HttpSession session = request.getSession();
		if(request.getParameter("id")!=null) {
			id=(String)request.getParameter("id");
			name=(String)request.getParameter("name");
		}else {
			id=(String)session.getAttribute("id");
			name=(String)session.getAttribute("name");
		}
		PeersScheduleModel peersScheduleModel=new PeersScheduleModel();
		PeersScheduleDAO peersScheduleDAO=new PeersScheduleDAO();
		peersScheduleDAO.getPeersSchedule(id,peersScheduleModel);
		
		SessionListModel sessionListModel=new SessionListModel();
		SessionListDAO sessionListDAO =new SessionListDAO();
		sessionListModel=sessionListDAO.setSession(sessionListModel);
		
		
		session.setAttribute("peersScheduleModel",peersScheduleModel);
		session.setAttribute("sessionListModel",sessionListModel);
		session.setAttribute("id",id);
		session.setAttribute("name",name);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("peersschedule.jsp");
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
