<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
						<td><input type="text" name="f_rs" /></td>
					</tr>
					<tr>
						<td align="right">RUC</td>
						<td><input type="text" name="f_ruc" /></td>
					</tr>
					<tr>
						<td align="right">Teléfono</td>
						<td><input type="text" name="f_fono" /></td>
					</tr>
					<tr>
						<td align="right">Dirección</td>
						<td><input type="text" name="f_direccion" /></td>
					</tr>
					<tr>
						<td align="right">Estado</td>
						<td><input type="radio" name="f_estado" value="1">Activo<input type="radio" name="f_estado" value="0">Inactivo</td>
					</tr>
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
					<tr>
						<td align="center" colspan="2"><input type="submit" name="guardar" value="Registrar"/></td>
					</tr>			
				</table>
			</fieldset>	
		</form>
		<jsp:include page="listadeproveedor.jsp" flush="true" />
	</div>		
</body>
</html>