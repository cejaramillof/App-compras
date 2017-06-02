<%@ page import="java.sql.ResultSet" %>
<jsp:useBean id="d" class="compras.modelo.Departamento" scope="page" />
<jsp:useBean id="cx" class="compras.modelo.Conectar" scope="page" />
<table>
	<tr>
		<th>Nº</th>
		<th>Área</th>
		<th>Código A</th>
		<th>Código B</th>
		<th>Nombre</th>
		<th>Estado</th>
		<th>Opciones</th>
	</tr>
<% int i = 1;
	ResultSet rs = d.listar_Departamento();
	while(rs.next()){
%>
	<tr>
		<td align="center"><%=i%></td>
		<td><%= rs.getString("area") %></td>
		<td><%= rs.getString("codigoa") %></td>
		<td><%= rs.getString("codigob") %></td>
		<td><%= rs.getString("nombre") %></td>
		<td align="center"><%= rs.getString("estado") %></td>
		<td>[Editar][Eliminar]</td>
	</tr>
<%
i++;
}
cx.desconectar(); %>
</table>
