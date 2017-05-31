package compras.modelo;

public class Producto {
//Atributos de la clase
	private String idcod; 
	private String codigo;
	private String nombre;
	private String categoria;
	private String descripcion;
	private String estado;
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
}
