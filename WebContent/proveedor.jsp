<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.ResultSet"  %>
<jsp:useBean id="p" class="compras.modelo.Proveedor" scope="page" />
<jsp:useBean id="cx" class="compras.modelo.Conectar" scope="page" />
<% 
String mensaje = (""); int msj;
if(request.getParameter("msj") != null){
	msj = Integer.valueOf(request.getParameter("msj"));
	}else{
		msj=0;
	}
switch (msj) {
	case 1: mensaje = "Se ha eliminado correctamente"; break;
	case 2: mensaje = "Hubo un problema al eliminar, contacte al administrador"; break;
	case 3: mensaje = "Los datos se han actualizado correctamente"; break;
	case 4: mensaje = "Hubo un problema al actualizar, contacte al administrador"; break;
	case 5: mensaje = "Dato registrado correctamente"; break;
	case 6: mensaje = "Hubo un problema al registrar, contacte al administrador"; break;
	default: break;
}
String opc = request.getParameter("op"); if(opc==null){opc="";}
String pg = request.getParameter("pg"); if(pg==null){pg="";}

int id;
if(request.getParameter("id")==null) {
	id=0;
}else {
	id = Integer.valueOf(request.getParameter("id"));
}
String razon = "";
String ruc = "";
String fono = "";
String dir = "";
String est = "";

p.setIdproveedor(id);
ResultSet rsp = p.buscar_proveedor(p);
while (rsp.next()){
	id = rsp.getInt(1);
	razon = rsp.getString(2);
	ruc = rsp.getString(3);
	dir = rsp.getString(4);
	fono = rsp.getString(5);	
	est = rsp.getString(6);
}
cx.desconectar();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento proveedor</title>
</head>
<body>
	<div align="center">
		<label style="color:red;"><%= mensaje %></label>
		<form action="cProveedor" method="post">
			<fieldset>
				<legend><b>Mantenimiento de proveedor</b></legend>			
				<table>
					<tr>
						<td align="right">Razon Social</td>
						<td><input type="text" name="f_rs" value ="<%= razon %>" /></td>
					</tr>
					<tr>
						<td align="right">RUC</td>
						<td><input type="text" name="f_ruc" value ="<%= ruc %>" /></td>
					</tr>
					<tr>
						<td align="right">Teléfono</td>
						<td><input type="text" name="f_fono" value ="<%= fono %>" /></td>
					</tr>
					<tr>
						<td align="right">Dirección</td>
						<td><input type="text" name="f_direccion" value ="<%= dir %>" /></td>
					</tr>
					<tr>
						<td align="right">Estado</td>
						<td>
							<input type="radio" name="f_estado" value="1" <% if(est.equals("1")){%>checked="checked" <%} %> />Activo
							<input type="radio" name="f_estado" value="0" <% if(est.equals("0")){%>checked="checked" <%} %> />Inactivo
						</td>
					</tr>
					<!--
					<tr>
						<td align="right">Estado Select</td>
						<td>
							<select name="f_estado2">
								<option value="">---Seleccione---</option>							
								<option value="1">Activo</option>
								<option value="0">Inactivo</option>
							</select>
						</td>
					</tr>
					-->					
					<tr>
						<td align="center" colspan="2">
						<% if(opc.equals("up")){ %>
							<input type="hidden" name="id" value="<%=id%>"/>
							<input type="hidden" name="opc" value="up"/>
							<input type="hidden" name="pg" value="<%=pg%>"/>
							<input type="submit" name="update" value="Actualizar"/>
						<%}else{ %>
							<input type="hidden" name="opc" value="in"/>
							<input type="submit" name="guardar" value="Registrar"/>
						<%} %>
						</td>						
					</tr>			
				</table>
			</fieldset>	
		</form>
		<jsp:include page="listadeproveedor.jsp" flush="true" />
	</div>		
</body>
</html>