<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mantenimiento de producto</title>
</head>
<body>
	<div align="center">
		<form action="" method="post" name="p">
			<table>
				<tr><th colspan="2" >Mantenimiento de Productos</th></tr>
				<tr>
					<td align="right">Código</td>
					<td align="left"><input type="text" name="f_codigo" /></td>
				</tr>
				<tr>
					<td align="right">Nombre</td>
					<td align="left"><input type="text" name="f_nombre" /></td>
				</tr>
				<tr>
					<td align="right">Categoria</td>
					<td align="left">
					<select name="f_categoria" >
						<option value="1">Oficina</option>
						<option value="2">Muebles</option>
						<option value="3">Informatica</option>
					</select>
					</td>
				</tr>
				<tr>
					<td valign="top" align="right">Descripción</td>
					<td align="left"><textarea rows="3" cols="20" name="f_descripcion"></textarea></td>
				</tr>
				<tr>
					<td align="right">Estado</td>
					<td align="left">
						<input type="radio" name="f_estado" value="1" /> Activo 
						<input type="radio" name="f_estado" value="0" /> Inactivo
					</td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" name="Aceptar" value="Aceptar"/>
					</td> 
				</tr>		
			</table>		
		</form>
	</div>
</body>
</html>