import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoSDAO {
    // Defina a URL de conexão, usuário e senha do seu banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/leiloesupdate";
    private static final String USER = "root";
    private static final String PASSWORD = "04022002";

    // Método para cadastrar um produto
    public void cadastrarProduto(ProdutosDTO produto) throws SQLException {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sql = "INSERT INTO produtos (nome, valor, status) VALUES (?, ?, ?)";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, produto.getNome());
                stmt.setInt(2, produto.getValor());
                stmt.setString(3, produto.getStatus());
                
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Erro ao cadastrar produto");
        }
    }

    // Método para vender um produto (alterar o status para 'Vendido')
    public boolean venderProduto(int produtoId) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            // Consulta SQL para atualizar o status do produto para 'Vendido'
            String sql = "UPDATE produtos SET status = 'Vendido' WHERE id = ?";
            
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, produtoId);
                
                // Executando a atualização no banco de dados
                int linhasAfetadas = stmt.executeUpdate();
                
                // Retorna verdadeiro se a atualização foi bem-sucedida
                return linhasAfetadas > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;  // Retorna false em caso de erro
        }
    }
}
