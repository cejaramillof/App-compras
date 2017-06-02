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
	
	public Conectar() {
		this.server = "127.0.0.1"; // Localhost
		this.DB = "compras"; // nombre db
		this.userDB = "admin"; // user db
		this.passwDB = ""; // pw db
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
	//metodo para ejecutar SELECT
}
