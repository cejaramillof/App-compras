package compras.modelo;

import java.sql.ResultSet;

import compras.modelo.Conectar;

public class Login {
	private String iduser;
	private String codigo;
	private String usuario;
	private String password;
	private String nombre;
	private String apellidos;
	private String estado;
	// iduser, codigo, usuario, password, estado, nombre, apellido
	Conectar cx = new Conectar();
	//metodo constructor
	public Login() {
		// TODO Auto-generated constructor stub

	}
	//metodo get y set
	public String getIduser() {
		return iduser;
	}
	public void setIduser(String iduser) {
		this.iduser = iduser;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	// iduser, codigo, usuario, password, estado, nombre, apellido
	//metodos y operaciones	
	public int validarUsuario(Login l){
		cx.con();
		String com = "SELECT * FROM usuario "+ 
				"WHERE usuario='"+l.getUsuario()+"' "+
				"AND password='"+l.getPassword()+"' "+
				"AND estado=true";
		int res = cx.contarFilas(com);
		cx.desconectar();
		return res;
	}
	
	public Login getUsuario(Login l){		
		Login user = new Login();
		String com = "SELECT * FROM usuario " +
				"WHERE usuario='"+l.getUsuario()+"' " +
						"AND password='"+l.getPassword()+"' " +
								"AND estado='1'";
		try {
			cx.con();
			ResultSet rs = cx.getDatos(com);
			while(rs.next()){
				user.setIduser(rs.getString(1));
				user.setCodigo(rs.getString(2));
				user.setUsuario(rs.getString(3));
				user.setEstado(rs.getString(5));
				user.setNombre(rs.getString(6));
				user.setApellidos(rs.getString(7));				
			}
			System.out.println("1-"+com+user.getUsuario());
			cx.desconectar();
			return user;			
		} catch (Exception e) {
			System.out.println("2-"+com);
			return user=null;
		}
	}	
}