<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	String msj = request.getParameter("error"); 
	if(msj==null){
		msj="";
	}else{
		if(msj.equals("v")){
			msj="Datos incorrectos, por favor intente de nuevo. <br/> Contacte con el administrador.";
		}else{
			msj="Acceso solo a personas autorizadas";
		}
	} 
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<label style="color: red;"><b><%= msj %></b></label>
		<form action="cLogin" method="post">
			<fieldset>
				<legend> Datos de acceso</legend>
				<table>
					<tr>
						<td>Usuario</td>
						<td><input type="text" name="f_user" placeholder="Ingrese su usuario" size="20" required /></td>
					</tr>
					<tr>
						<td>Password</td>
						<td><input type="password" name="f_passw" placeholder="Ingrese su contraseña" size="20" required /></td>
					</tr>	
					<tr>
						<td colspan="2" align="center">
							<input type="submit" name="opc" value="Enviar" />
						</td>
					</tr>				
				</table>
			</fieldset>
		</form>
	</div>
</body>
</html>