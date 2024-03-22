package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ForCoachDAO;
import model.ForCoachModel;

/**
 * Servlet implementation class ForCoachServlet
 */
@WebServlet("/ForCoachServlet")
public class ForCoachServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForCoachServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		if(request.getParameter("trick").length()!=0 && request.getParameter("trick")!=null) {
			
			String trick=request.getParameter("trick");
			ForCoachModel forCoachModel=new ForCoachModel();
			forCoachModel.setTrick(trick);
			
			ForCoachDAO forCoachDAO=new ForCoachDAO();
			forCoachModel=forCoachDAO.getCoaches(forCoachModel);
			List<String> coachesList=forCoachModel.getCoachesList();
			String[] coaches=new String[coachesList.size()];
			coaches=forCoachModel.getCoaches();
			
			request.setAttribute("coaches",coaches);
			
//			for(String coach:coaches) {
//				System.out.println("forに入った");
//				System.out.println(coach);
//			}
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("lookforcoaches.jsp");
			dispatcher.forward(request, response);
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
