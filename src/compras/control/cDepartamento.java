package compras.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compras.modelo.Departamento;

/**
 * Servlet implementation class cDepartamento
 */
@WebServlet("/cDepartamento")
public class cDepartamento extends HttpServlet {
	Departamento d = new Departamento();
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cDepartamento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		d.setArea(request.getParameter("f_area")); //variable agregada
		d.setNombre(request.getParameter("f_nombre"));
		d.setCodigoa(request.getParameter("f_codigoa"));
		d.setCodigob(request.getParameter("f_codigob"));
		d.setEstado(request.getParameter("f_estado"));
		d.registrar_Departamento(d);
		response.sendRedirect("departamento.jsp");		
	}

}
