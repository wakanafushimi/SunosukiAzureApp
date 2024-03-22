package servlet;

import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.PeersDAO;
import model.PeersModel;

/**
 * Servlet implementation class PeersServlet
 */
@WebServlet("/PeersServlet")
public class PeersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PeersServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		PeersDAO peersDAO=new PeersDAO();
		List<String[]> peers=peersDAO.getPeers();
		List<String[]> peersTrick_b=peersDAO.getPeersTrick_b();
		
		PeersModel peersModel=new PeersModel();
		peersModel=peersDAO.getPeersTrick_a();
		List<String[]> peersTrick_a=peersModel.getList();
		Set<String> set=peersModel.getSet();
		//setを配列にする
		String[] existinguser=new String[set.size()];
		int i=0;
		for(String value:set) {
//			System.out.println(value);
			existinguser[i]=value;
			i=i+1;
		}
		
		
		HttpSession session = request.getSession();
	
		session.setAttribute("existinguser",existinguser);
		session.setAttribute("peers",peers);
		session.setAttribute("peersTrick_a",peersTrick_a);
		session.setAttribute("peersTrick_b",peersTrick_b);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("lookforpeers.jsp");
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
