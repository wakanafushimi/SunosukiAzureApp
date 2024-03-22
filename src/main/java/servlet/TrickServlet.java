package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.TrickDAO;
import model.LoginModel;
import model.TrickModel;

/**
 * Servlet implementation class TrickSevlet
 */
@WebServlet("/TrickServlet")
public class TrickServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TrickServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		//入力された技名をデータベースに入れる
		String trick_a=null;
		trick_a=request.getParameter("trick_a");
		String trick_b=null;
		trick_b=request.getParameter("trick_b");
		
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		
		TrickDAO trickDAO=new TrickDAO();
		if(trick_a!=null) {
			if(trick_a.length()!=0){
				trickDAO.setTrick_a(loginModel,trick_a);
			}
		}
		if(trick_b!=null) {
			if(trick_b.length()!=0) {
				trickDAO.setTrick_b(loginModel,trick_b);
			}
		}
		
		
		//trickデータベースの値をListに入れる
		TrickModel trickModel=new TrickModel();
		trickModel=trickDAO.getTrickModel(loginModel);
		
		
		//削除
		String deleteValuea=null;
		String deleteValueb=null;
		if(request.getParameter("deleteValuea")!=null) {
			deleteValuea=request.getParameter("deleteValuea");
		}
		if(deleteValuea!=null) {
			trickDAO.DeleteTrick_a(deleteValuea,loginModel);
		}
		
		if(request.getParameter("deleteValueb")!=null) {
			deleteValueb=request.getParameter("deleteValueb");
		}
		if(deleteValueb!=null) {
			trickDAO.DeleteTrick_b(deleteValueb,loginModel);
		}
		
		trickModel=trickDAO.getTrickModel(loginModel);
		
		
		session.setAttribute("trickModel", trickModel);
		RequestDispatcher dispatcher=request.getRequestDispatcher("ProfileServlet");
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
