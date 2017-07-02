<%@page session="true" %>
<%
	String usuario = "";
	HttpSession sesionOk = request.getSession();
	if (sesionOk.getAttribute("usuario") == null) {
%>
<jsp:forward page="login.jsp">
	<jsp:param name="error" value="Es obligatorio identificarse" />
</jsp:forward>
<%
	} else {
		usuario = (String) sesionOk.getAttribute("usuario");
	}
%>