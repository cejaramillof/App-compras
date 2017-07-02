package compras.modelo;

// import com.mysql.jdbc.Connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conectar {
	private Connection con = null;
	private Statement consulta = null;
	private ResultSet data = null;
	private String server;
	private String DB;
	private String userDB;
	private String passwDB;
	public int MAXROW = 5;
	
	public Conectar() {
		this.server = "127.0.0.1"; // Localhost
		this.DB = "compras"; // nombre db
		this.userDB = "root"; // user db
		this.passwDB = "123456"; // pw db
	}
	//metodo para abrir conexion
	public void con(){
		try {
			Class.forName("com.mysql.jdbc.Driver"); //Cargamos el driver
			String url = "jdbc:mysql://"+this.server+"/"+this.DB;
			this.con = DriverManager.getConnection(url,this.userDB,this.passwDB); // abrimos la conexion
			System.out.println("Conexión exitosa..");
			this.consulta = con.createStatement(); // inicializamos el objeto statement
		} catch (Exception e) {
			System.out.println("Error de conexión "+e.getMessage());
		}
	}
	//Metodo para cerrar la conexion
	public void desconectar(){
		try {
			if (con!=null){
				this.con.close();
			}
		} catch (Exception e) {
			System.out.println("Error de desconexión "+e.getMessage());
		}
	}
	//Metodo para ejecutar SQL Insert Update Delete
	public int execQuery(String com) {
		int res = 0;
		try {
			this.con();
			res = this.consulta.executeUpdate(com);
		} catch (Exception e) {
			System.out.println("Error de ejecución.. "+e.getMessage());
		}
		return res;
	}
	//metodo para ejectuar SELECT
	public ResultSet getDatos(String com){
		try {
			this.con();
			this.data = this.consulta.executeQuery(com);			
		} catch (Exception e) {
			System.out.println("Error de la consulta "+e.getMessage());
		}
		return data;
	}
	//Metodo que devuelve el numero de filas o registros
	public int contarFilas(String com){
		try {
			this.con();
			this.data = this.consulta.executeQuery(com);
			int contador = 0;
			while(data.next()){// recorre todo el resulset
				contador++;// sumar las veces que haya registros
			}
			return contador; // devuelve cantidad de registros
		} catch (Exception e) {
			System.out.println("Error al contar registros "+e.getMessage());
			System.out.println(com);
			return 0;
		}
	}
}
