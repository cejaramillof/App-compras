package compras.modelo;

import java.sql.ResultSet;

public class Departamento {
//Atributos de la clase
	private String iddepa;
	private String area;
	private String codigoa;
	private String codigob;
	private String nombre;
	private String estado;
	
	Conectar cx = new Conectar();
	
	//metodo constructor
	public Departamento() {
		// TODO Auto-generated constructor stub
	}
	// metodos getters y setters	
	public String getIddepa() {
		return iddepa;
	}
	public void setIddepa(String iddepa) {
		this.iddepa = iddepa;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}	
	public String getCodigoa() {
		return codigoa;
	}
	public void setCodigoa(String codigoa) {
		this.codigoa = codigoa;
	}
	public String getCodigob() {
		return codigob;
	}
	public void setCodigob(String codigob) {
		this.codigob = codigob;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	// METODOS U OPERACIONES	----------------------
	public int registrar_Departamento(Departamento d){	
		cx.con(); //ABRIMOS LAS CONEXION
		String com = "INSERT INTO DEPARTAMENTO (iddepa,area,codigoa,codigob,nombre,estado) "+
						"VALUES (null,'"+d.getArea()+"','"+
										d.getCodigoa()+"','"+
										d.getCodigob()+"','"+
										d.getNombre()+"','"+
										d.getEstado()+"')"; //hacemos la consulta SQL
		
		int res = cx.execQuery(com); //ejecutamos la consulta
		System.out.println(com);
		cx.desconectar(); //cerramos la conexion
		return res;
	}
	
	public int actualizar_Departamento(Departamento d){
		int res = 0;
	return res;	
	}
	public int eliminar_Departamento(Departamento d){
		int res = 0;
	return res;	
	}
	public ResultSet listar_Departamento(){
		String com = "SELECT * FROM DEPARTAMENTO";
		ResultSet rs = cx.getDatos(com); 	
		return rs;
	}
}
