package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.JoinDAO;
import model.LoginModel;

/**
 * Servlet implementation class JoinServlet
 */
@WebServlet("/JoinServlet")
public class JoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String sessionId=request.getParameter("action");
		System.out.println("JoinServletの"+sessionId);
		JoinDAO joinDAO=new JoinDAO();
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		joinDAO.setMember(sessionId,loginModel);
		
		//join後にpeersscheduleに遷移するためのforwardの値
		String id=null;
		String name=null;
		String forward="SessionListServlet";
		if(request.getParameter("id")!=null && request.getParameter("id").length()!=0) {
			id=request.getParameter("id");
			name=request.getParameter("name");
			session.setAttribute("id",id);
			session.setAttribute("name", name);
			forward="PeersScheduleServlet";
		}else if(request.getAttribute("id")!=null){
			request.removeAttribute("id");
		}
		
		response.sendRedirect(forward);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

}