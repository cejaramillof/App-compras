package compras.control;

import java.io.IOException;
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
	String msj = "";
    public cProveedor() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("op");
		switch (opc) {
			case "del": eliminarProveedor(request, response);
				break;
			default:
				break;
		}
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String opc = request.getParameter("opc");
		switch (opc) {
			case "in": registrarProveedor(request, response); break;
			case "up": actualizarProveedor(request, response); break;
			default:
				break;
		}
		//doGet(request, response);
	}
	
	protected void eliminarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pg = request.getParameter("pg");
		p.setIdproveedor(Integer.valueOf(request.getParameter("id")));
		int valor = p.eliminar_proveedor(p);
		if(valor==1){
			msj ="1"; // para el caso de una eliminacion satisfactoria
		}else {
			msj = "2"; // erorr en la eliminacion
		}
		response.sendRedirect("proveedor.jsp?pg="+pg+"&msj="+msj);
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}	
	protected void registrarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		p.setRazonsocial(request.getParameter("f_rs"));
		p.setRuc(request.getParameter("f_ruc"));
		p.setTelefono(request.getParameter("f_fono"));
		p.setDireccion(request.getParameter("f_direccion"));
		p.setEstado(request.getParameter("f_estado"));
		String pg = request.getParameter("pg"); if(pg==null){pg="1";}
		String msj="";
		int v = p.registrar_proveedor(p);
		if(v==1){
			msj="5"; // si registró correctamente
		}else{
			msj="6"; // hubo un error en el registro
		}
		response.sendRedirect("proveedor.jsp?pg="+pg+"&msj="+msj);		
		//System.out.println(p.getRuc()+"-Paso por el control cProveedor");
	}
	protected void actualizarProveedor(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		p.setIdproveedor(Integer.valueOf(request.getParameter("id")));
		p.setRazonsocial(request.getParameter("f_rs"));
		p.setRuc(request.getParameter("f_ruc"));
		p.setTelefono(request.getParameter("f_fono"));
		p.setDireccion(request.getParameter("f_direccion"));
		p.setEstado(request.getParameter("f_estado"));
		String pg = request.getParameter("pg");
		String msj="";		
		int v = p.actualizar_proveedor(p);
		if(v==1){
			msj="3"; // si actualizó correctamente
		}else{
			msj="4"; // hubo un error en la actualizacion
		}		
		response.sendRedirect("proveedor.jsp?pg="+pg+"&msj="+msj);
	}

}
