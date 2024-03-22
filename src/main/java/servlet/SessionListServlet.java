package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.SessionListDAO;
import model.SessionListModel;

/**
 * Servlet implementation class SessionListServlet
 */
@WebServlet("/SessionListServlet")
public class SessionListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SessionListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		SessionListModel sessionListModel=new SessionListModel();
		SessionListDAO sessionListDAO=new SessionListDAO();
		sessionListModel=sessionListDAO.setSession(sessionListModel);
		
		HttpSession session = request.getSession();
		session.setAttribute("sessionListModel",sessionListModel);
		
		//lookforsession.jspかspecificsession.jspかの分岐
		String forward=null;
		String date=request.getParameter("date");
		if(date==null) {
			date=(String)session.getAttribute("date");
		}
		
		System.out.println(date);
		
		if(date==null || date.equals("datenull")) {
			forward="lookforsession.jsp";
			session.removeAttribute("date");
		}else{
			forward="ForSessionServlet";
		}
		
		response.sendRedirect(forward);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}