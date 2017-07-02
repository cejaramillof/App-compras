package compras.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import compras.modelo.Login;
import compras.modelo.Sesion;

/**
 * Servlet implementation class cLogin
 */
@WebServlet("/cLogin")
public class cLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       Login l = new Login();
       Sesion s = new Sesion();
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
		l.setPassword(request.getParameter("f_passwe"));
		int v = l.validarUsuario(l);
		if(v==1){
			HttpSession sesionOK = request.getSession();
			s.setId_sesion(sesionOK.getId());
			s.setUsuario(request.getParameter("f_user"));
			if(s.buscarSesion(s)==1){  // busca si existe una sesion con el id y el usuario
				s.actualizarSesion(s); // si existe actualiza la fecha
			}else{ 
				registrarSesion(sesionOK.getId(), request, response); //registra sesion
			}
			Login user = new Login();
			user = l.getUsuario(l);
			//variables en sesion
			sesionOK.setAttribute("iduser", user.getIduser());
			sesionOK.setAttribute("codigo", user.getCodigo());
			sesionOK.setAttribute("usuario",user.getUsuario());
			sesionOK.setAttribute("usuario2", user.getNombre()+" "+user.getApellidos());
			sesionOK.setAttribute("estado", user.getEstado());
			sesionOK.setAttribute("ip", request.getRemoteAddr());
			//direccionamos al menu
			response.sendRedirect("menu.jsp");
		}else{
			response.sendRedirect("login.jsp?error=v");
		}
	}
	//ID_Sesion, usuario, inicio_sesion, ultimo_acceso, ip,host,servername, estado
	protected void registrarSesion(String idsesion,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		s.setId_sesion(idsesion);
		s.setUsuario(request.getParameter("f_user"));
		s.setIp(request.getRemoteAddr());
		s.setHost(request.getRemoteHost());
		s.setServername(request.getServerName());
		s.registrarSesion(s);
	}
	

}
