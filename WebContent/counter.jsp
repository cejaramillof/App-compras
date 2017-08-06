<%@page import="java.sql.ResultSet" %>
<jsp:useBean id="cx" class="compras.modelo.Conectar" scope="page" />
<html>
<head>
<%
	HttpSession sesionOK = request.getSession(true);
	String s_time = "1";
	String f_close = request.getParameter("fin"); if(f_close==null){f_close="1";}
	if(f_close.equals("1")){
%>
<script>
	var timerID = null;
	var timerRunning = false;
	var ver = 0;
	
	function stopclock(){
		if(timerRunning) clearTimeout(timerID);
		timerRunning = false;
	}
	
	function startclock(){
		stopclock();
		showtime();
	}
	
	function showtime(){
		//var now = new Date();
		timerID = setTimeout("startclock()",10000);
		if (ver==1){
			document.date.submit();
		}
		ver = 1;
		timerRunning = true;
	}
</script>
</head>
<body onLoad="startclock()">
	<form action="counter.jsp" name="dato" method="post">
		<input type="hidden" name="fin" value="0"/>
		<b>&lt;</b> Cerrar en <b><%= s_time %></b>&nbsp;Min.<b>&gt;</b>
	</form>
<%
	} else {
		cx.desconectar();
		sesionOK.invalidate();
%>
	<script type="text/javascript">
		alert("Su conección ha caducado");
		top.window.close();
	</script>
	</head>
	<body bgcolor="#d8bfbc" leftmargin="0" topmargin="0">
<% } %>
</body>
</html>
<% cx.desconectar(); %>