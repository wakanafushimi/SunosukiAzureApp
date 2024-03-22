package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.RegisterDAO;
import model.LoginLogic;
import model.LoginModel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    //登録
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		LoginModel loginModel=new LoginModel(id,password);
		RegisterDAO registerDAO=new RegisterDAO();
		loginModel.setRegisterFlag(registerDAO.Register(loginModel));
		
		HttpSession session=request.getSession();
		session.setAttribute("loginModel",loginModel);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("registerCompleted.jsp");
		dispatcher.forward(request,response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	//ログイン
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String id=request.getParameter("id");
		String password=request.getParameter("password");
		
		LoginModel loginModel=new LoginModel(id,password);
		LoginLogic loginLogic=new LoginLogic();
		boolean flag=loginLogic.execute(loginModel);
		
		String forwardPath="";
		
		if(flag) {
			forwardPath="top.jsp";
		}else {
			forwardPath="loginFail.jsp";
		}
		
		HttpSession session=request.getSession();
		session.setAttribute("loginModel",loginModel);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher(forwardPath);
		dispatcher.forward(request,response);
	}

}
