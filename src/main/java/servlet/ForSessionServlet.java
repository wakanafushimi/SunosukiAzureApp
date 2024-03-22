package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ForSessionDAO;
import model.ForSessionModel;

/**
 * Servlet implementation class ForSessionServlet
 */
@WebServlet("/ForSessionServlet")
public class ForSessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForSessionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			request.setCharacterEncoding("UTF-8");
			String date=null;
			HttpSession session = request.getSession();
			
			if(request.getParameter("date")!=null && request.getParameter("date").length()!=0) {
				date=request.getParameter("date");
				session.setAttribute("date",date);
				
			}else {
				date=(String)session.getAttribute("date");
			}
			
			ForSessionModel forSessionModel=new ForSessionModel();
			
			forSessionModel.setDate(date);
			ForSessionDAO forSessionDAO=new ForSessionDAO();
			forSessionModel=forSessionDAO.getSessionList(forSessionModel);
						
			session.setAttribute("forSessionModel",forSessionModel);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("specificsession.jsp");
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