<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento departamento</title>
</head>
<body>
	<div align="center">
		<form action="cDepartamento" method="post" >
			<table>
				<tr>
					<th colspan="2">Registrar Departamento</th>
				</tr>
				<tr>
					<td>Áreas</td>
					<td>
						<select name="f_area" >
							<option value="" >--Seleccione--</option>
							<option value="01">ITSAE</option>
							<option value="02">CADE</option>
							<option value="03">ALIMENTOS CADE</option>
						</select>					
					</td>
				</tr>
				<tr>
					<td>Código A</td>
					<td><input type="text" name="f_codigoa" /></td>
				</tr>
				<tr>
					<td>Código B</td>
					<td><input type="text" name="f_codigob" /></td>
				</tr>
				<tr>
					<td>Nombre</td>
					<td><input type="text" name="f_nombre" /></td>
				</tr>
				<tr>
					<td>Estado</td>
					<td>
						<input type="radio" name="f_estado" value="1" >Activar<br>
						<input type="radio" name="f_estado" value="0" >Desactivar
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">								
						<input type="submit" value="Registrar" />
					</td>
				</tr>
			</table>
		</form>
		<jsp:include page="listadepartamento.jsp" flush="true" />
	</div>	
</body>
</html>