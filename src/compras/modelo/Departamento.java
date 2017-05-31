package compras.modelo;

public class Departamento {
//Atributos de la clase
	private String iddepa;
	private String codigoa;
	private String codigob;
	private String nombre;
	private String estado;
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

}
