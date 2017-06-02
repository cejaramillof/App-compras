package compras.modelo;

public class Proveedor {
//Atributos de la clase
	private int idproveedor; //Llave primaria
	private String ruc; //Identificador de la razon social
	private String razonsocial; //Nombre empresa
	private String direccion; //Direccion empresa
	private String telefono; //Telefono empresa
	private String estado;
	Conectar cx = new Conectar();
	
	//Metodo constructor
	public Proveedor() {
		// TODO Auto-generated constructor stub
	}
	// metodos getters y setters
	public int getIdproveedor() {
		return idproveedor;
	}
	public void setIdproveedor(int idproveedor) {
		this.idproveedor = idproveedor;
	}
	public String getRuc() {
		return ruc;
	}
	public void setRuc(String ruc) {
		this.ruc = ruc;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	//Metodos u Operaciones
	public int registrar_proveedor(Proveedor p){
		cx.con(); // abrimos la conexion
		String com = "INSERT INTO PROVEEDOR (idproveedor,razonsocial,ruc,direccion,telefono,estado) "+ 	
				"VALUES (null,'"+p.getRazonsocial()+"','"+
				p.getRuc()+"','"+
				p.getDireccion()+"','"+
				p.getTelefono()+"','"+
				p.getEstado()+"')"; //hacemos la consulta SQL
		
		
		int res = cx.execQuery(com); // ejecutamos la consulta
		cx.desconectar(); //cerramos la conexion
		//System.out.println(p);
		System.out.println("Llego a la clase provedor-modelo "+com);
		//int res=0;
		return res;
		
	}
	public int actualizar_proveedor(Proveedor p){
		int res=0;
		return res;
	}
	public int eliminar_proveedor(Proveedor p){
		int res=0;
		return res;
	}
	public void listar_proveedor(){
		
	}	
}
