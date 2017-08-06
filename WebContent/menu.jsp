<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ include file="seguridad.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	HttpSession sesionOK = request.getSession();
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de Pedidos</title>
</head>
<body>
<fieldset>
	<legend>Accesos</legend>
	<ul>
		<li><a href="proveedor.jsp">Proveedores</a></li>
		<li><a href="producto.jsp">Productos</a></li>
		<li><a href="departamento.jsp">Departamentos</a></li>
		<li><a href="cerrarsesion.jsp">Cerrar sesion</a></li>
	</ul>
ID Usuario: <%= sesionOK.getAttribute("iduser") %><br/>
Código: <%= sesionOK.getAttribute("codigo") %><br/>
Nombre de usuario: <%= sesionOK.getAttribute("usuario") %><br/>
Nombre y Apellido: <%= sesionOK.getAttribute("usuario2") %><br/>
Estado: <%= sesionOK.getAttribute("estado") %><br/>
IP: <%= sesionOK.getAttribute("ip") %><br/>
</fieldset>
<jsp:include page="counter.jsp"></jsp:include>
</body>
</html>