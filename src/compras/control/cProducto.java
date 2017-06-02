package compras.control;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compras.modelo.Producto;

/**
 * Servlet implementation class cProducto
 */
@WebServlet("/cProducto")
public class cProducto extends HttpServlet {
	Producto p = new Producto(); //Siempre primero iniciamos el objeto
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public cProducto() {
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
		p.setCodigo(request.getParameter("f_codigo"));
		p.setNombre(request.getParameter("f_nombre"));
		p.setCategoria(request.getParameter("f_categoria"));
		p.setDescripcion(request.getParameter("f_descripcion"));
		p.setEstado(request.getParameter("f_estado"));
		p.registrar_Producto(p);
		response.sendRedirect("producto.jsp");		
	}

}
