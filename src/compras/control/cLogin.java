package compras.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compras.modelo.Login;

/**
 * Servlet implementation class cLogin
 */
@WebServlet("/cLogin")
public class cLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Login l = new Login();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		l.setUsuario(request.getParameter("f_user"));
		l.setPassword(request.getParameter("f_passw"));
		int v = l.validarUsuario(l);
		if(v==1){
			response.sendRedirect("menu.jsp");
		}else{
			response.sendRedirect("login.jsp?error=v");
		}
	}

}
