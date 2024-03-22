package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SessionDAO;
import model.LoginModel;
import model.SessionModel;

/**
 * Servlet implementation class SessionServlet
 */
@WebServlet("/SessionServlet")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String date=request.getParameter("date");
		String location=request.getParameter("location");
		String message=request.getParameter("message");
		
		SessionModel sessionModel=new SessionModel();
		if(date!=null && location!=null && message!=null) {
			sessionModel.setDate(date);
			sessionModel.setLocation(location);
			sessionModel.setMessage(message);
		}
		
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		SessionDAO sessionDAO=new SessionDAO();
		sessionDAO.setSession(sessionModel, loginModel);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("createsessiondone.jsp");
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
