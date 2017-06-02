package compras.modelo;

import java.sql.ResultSet;

public class Producto {
//Atributos de la clase
	private String idcod; 
	private String codigo;
	private String nombre;
	private String categoria;
	private String descripcion;
	private String estado;
	Conectar cx = new Conectar();
	//metodo constructor
	public Producto() {
		// TODO Auto-generated constructor stub
	}
	// metodos getters y setters
	public String getIdcod() {
		return idcod;
	}
	public void setIdcod(String idcod) {
		this.idcod = idcod;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	// METODOS U OPERACIONES	----------------------
	public int registrar_Producto(Producto p){
		cx.con(); //ABRIMOS LAS CONEXION
		String com = "INSERT INTO PRODUCTO (idProducto,codigo,nombre,categoria,descripcion,estado) "+
						"VALUES (null,'"+p.getCodigo()+"','"+
										p.getNombre()+"','"+
										p.getCategoria()+"','"+
										p.getDescripcion()+"','"+
										p.getEstado()+"')"; //hacemos la consulta SQL
		
		int res = cx.execQuery(com); //ejecutamos la consulta
		System.out.println(com);
		cx.desconectar(); //cerramos la conexion		
		return res;						
	}
	public int actualizar_Producto(Producto p){
		int res=0;
	return res;	
	}
	public int eliminiar_Producto(Producto p){
			int res=0;
	return res;	
	}
	public ResultSet listar_Producto(){
		String com = "SELECT * FROM PRODUCTO" ;
		ResultSet rs = cx.getDatos(com); 	
		return rs;	
	}
	public ResultSet paginacion_Producto(int pg,int cant){
		String com = "SELECT * FROM PRODUCTO LIMIT "+(pg-1)*cant+","+cant;
		ResultSet rs = cx.getDatos(com); 	
		return rs;
	}	
}
