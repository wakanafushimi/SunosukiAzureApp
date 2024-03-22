package servlet;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dao.ProfileDAO;
import model.LoginModel;
import model.ProfileModel;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/ProfileServlet")
@MultipartConfig
public class ProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		ProfileDAO profileDAO=new ProfileDAO();
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		ProfileModel newprofileModel=new ProfileModel();
		newprofileModel=profileDAO.getDetail(loginModel);
		
		session.setAttribute("newprofileModel", newprofileModel);
		RequestDispatcher dispatcher=request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String img=null;
		
		//画像の受け取り
		Part filePart = request.getPart("img");
		if(filePart.getSize()!=0) {
			// ファイルの保存先パス
			String uploadPath = request.getServletContext().getRealPath("/uploads");
			// 保存するファイル名
			String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
			// アップロードされたファイルを保存
			Path filePath = Paths.get(uploadPath, fileName);
			filePart.write(filePath.toString());
			
			img=fileName;
		}
//		System.out.println("img入力値:"+img);
		
		String username=null;
		username=request.getParameter("username");
//		System.out.println("username入力値:"+username);
		
		String pref=null;
		pref=request.getParameter("pref");
//		System.out.println("pref入力値:"+pref);
		
		String car=null;
		car=request.getParameter("car");
//		System.out.println("car入力値:"+car);
		
		String style=null;
		style=request.getParameter("style");
//		System.out.println("style入力値:"+style);
		
		String geer=null;
		geer=request.getParameter("geer");
//		System.out.println("geer入力値:"+geer);
		
		String selfintro=null;
		selfintro=request.getParameter("selfintro");
//		System.out.println("selfintro入力値:"+selfintro);
		
		String insta=null;
		insta=request.getParameter("insta");
		
		String x=null;
		x=request.getParameter("x");
		
		
		//入力がnullだったときはgetDetailして↑に代入
		ProfileModel profileModel=new ProfileModel();
		ProfileDAO profileDAO=new ProfileDAO();
		HttpSession session = request.getSession();
		LoginModel loginModel=(LoginModel)session.getAttribute("loginModel");
		profileModel=profileDAO.getDetail(loginModel);
		
		if(img==null) {
			img=profileModel.getImg();
		}
		if(username.length()==0) {
			username=profileModel.getUsername();
		}
		if(pref.length()==0) {
			pref=profileModel.getPref();
		}
		if(car==null) {
			car=profileModel.getCar();
		}
		if(style.length()==0) {
			style=profileModel.getStyle();
		}
		if(geer.length()==0) {
			geer=profileModel.getGeer();
		}
		if(selfintro.length()==0) {
			selfintro=profileModel.getSelfintro();
		}
		if(insta.length()==0) {
			insta=profileModel.getInsta();
		}
		if(x.length()==0) {
			x=profileModel.getX();
		}
				
		//profileModelには入力値またはgetDetailが入ってるからそれをsetDetail
		profileModel.setImg(img);
		profileModel.setUsername(username);
		profileModel.setPref(pref);
		profileModel.setCar(car);
		profileModel.setStyle(style);
		profileModel.setGeer(geer);
		profileModel.setInsta(insta);
		profileModel.setX(x);
		profileModel.setSelfintro(selfintro);

		profileDAO.setDetail(loginModel, profileModel);
		
		//データベース更新後の値をgetDetail
		ProfileModel newprofileModel=new ProfileModel();
		newprofileModel=profileDAO.getDetail(loginModel);
		session.setAttribute("newprofileModel", newprofileModel);	
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("profile.jsp");
		dispatcher.forward(request, response);
	}

}
