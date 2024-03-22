package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EditmessageDAO;
import dao.SessionListDAO;
import model.SessionListModel;

/**
 * Servlet implementation class EditmessageServlet
 */
@WebServlet("/EditmessageServlet")
public class EditmessageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditmessageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String message=null;
		int sessionid=Integer.parseInt(request.getParameter("sessionid"));
		if(request.getParameter("message")!=null&&request.getParameter("message").length()!=0) {
			message=request.getParameter("message");
		}
		request.setAttribute("message",message);		
		EditmessageDAO editmessageDAO =new EditmessageDAO();
		editmessageDAO.editmessage(sessionid,message);
		
		SessionListModel sessionListModel=new SessionListModel();
		SessionListDAO sessionListDAO= new SessionListDAO();
		sessionListDAO.setSession(sessionListModel);
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionListModel",sessionListModel);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("schedule.jsp");
		dispatcher.forward(request, response);
	}

}
