import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao2 {
    private static final String URL = "jdbc:mysql://localhost:3306/Leiloesupdate"; // URL do seu banco de dados
    private static final String USER = "root"; // Usuário do banco
    private static final String PASSWORD = "04022002"; // Senha do banco
    
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    private Conexao2() {
    }
}
