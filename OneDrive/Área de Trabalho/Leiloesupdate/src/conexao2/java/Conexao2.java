import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao2 {

    public static Connection getConnection() throws SQLException {
        try {
            // Carregar o driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Conectar ao banco de dados
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/Leiloesupdate", "root", "04022002");
        } catch (ClassNotFoundException | SQLException e) {
            throw new SQLException("Erro ao conectar com o banco de dados", e);
        }
    }
}
