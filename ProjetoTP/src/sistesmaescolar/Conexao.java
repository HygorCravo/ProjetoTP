package sistesmaescolar;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.sun.jdi.connect.spi.Connection;

public class Conexao {

        private Connection conn;

        public Conexao()
        {
            conectar();
        }

        public Connection getCon() {
            return conn;
        }

        public void fechaConexao() throws IOException {
            conn.close();
        }
 
public void conectar(){
            String url = "JDBC:mysql://localhost:3306/escola?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            try{
                conn = (Connection) DriverManager.getConnection(url,"root","");
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

    }