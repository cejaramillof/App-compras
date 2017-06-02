<%@ page import="java.sql.ResultSet"  %>
<jsp:useBean id="p" class="compras.modelo.Proveedor" scope="page" />
<jsp:useBean id="cx" class="compras.modelo.Conectar" scope="page" />
<%
	int pg=0; //pagina a mostrar
	if(request.getParameter("pg") == null){
		pg = 1;
	}else {
		pg =Integer.valueOf(request.getParameter("pg"));	
	}
	int numreg = cx.contarFilas("SELECT * FROM PROVEEDOR"); //numero de registros
	int numpg = numreg/10; // numero de paginas a mostrar
	if(pg>1){
%>
		<a href="?pg=<%=pg-1%>">&lt;&lt; Anterior</a>	
<%
	}
	// calcular el inicio del arreglo
	int inipg =0; // variable del inicio del arreglo
	int r = (pg-1)%10; //
	if (r==0){
		inipg = pg-1; //emplieza desde 0 y va desde 10 en 10
	}else{
		inipg = ((pg-1)/10)*10;
	}
	for (int j=inipg;j<10+inipg;j++){ //muestra de 10 en 10 la paginacion
		if(j<numpg+1){
%>
	<a href="?pg=<%=j+1 %>"><%=j+1 %></a>
<% 
		}
	}// recorre uno a uno la paginacion
	if(pg<=numpg) {
%>
		<a href="?pg=<%=pg+1%>">Siguiente &gt;&gt;</a>
<%
	}
%>	
<table>
	<tr>
		<th>Nº</th>
		<th>Razon social</th>		
		<th>Ruc</th>
		<th>Direccion</th>
		<th>Telefono</th>
		<th>Estado</th>
		<th>Opciones</th>
	</tr>
<!--  aqui se muestran los datos de la tabla -->
<%	int i = (pg-1)*10; //Contador
	//ResultSet rs = p.listar_proveedor();
	ResultSet rs = p.paginacionProveedor(pg,10);
	while(rs.next()){
%>
	<tr>
		<td align="center"><%=i+1%></td>
		<td><%=rs.getString(2) %></td>
		<td><%=rs.getString("ruc") %></td>		
		<td><%=rs.getString(4) %></td>
		<td><%=rs.getString(5) %></td>
		<td><%=rs.getString(6) %></td>
		<td>[Editar][Eliminar]</td>
	</tr>
<%
i++;
}
cx.desconectar(); %>
</table>