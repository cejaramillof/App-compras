package compras.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import compras.modelo.Proveedor;

/**
 * Servlet implementation class cProveedor
 */
@WebServlet("/cProveedor")
public class cProveedor extends HttpServlet {
	Proveedor p = new Proveedor();
	private static final long serialVersionUID = 1L;
 
    public cProveedor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out;		
		String titulo ="Salida de un simple servlet";
		//Declaramos el tipo de contenido
		response.setContentType("text/html");
		//Escribimos los datos de la respuesta
		out = response.getWriter();
		out.println("<html>");
			out.println("<head>");
				out.println("<title>");
					out.println(titulo);
				out.println("</title>");
			out.println("</head>");
			out.println("<body>");
				out.println("<h1>");
					out.println(titulo);
				out.println("</h1>");
				out.println("<h2>");
					out.println("Carlos Jaramillo");
				out.println("</h2>");		
			out.println("</body>");
		out.println("</html>");
		out.close();
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		p.setRazonsocial(request.getParameter("f_rs"));
		p.setRuc(request.getParameter("f_ruc"));
		p.setTelefono(request.getParameter("f_fono"));
		p.setDireccion(request.getParameter("f_direccion"));
		p.setEstado(request.getParameter("f_estado"));
		p.registrar_proveedor(p);
		response.sendRedirect("proveedor.jsp");
		System.out.println(p.getRuc()+"-Paso por el control cProveedor");
		//doGet(request, response);
	}

}
