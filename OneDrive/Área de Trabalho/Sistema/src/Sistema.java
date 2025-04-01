
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Sistema {
    static SistemaGestao sistema = new SistemaGestao();
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> criarInterface());
    }
    
    private static void criarInterface() {
        JFrame frame = new JFrame("Sistema de Gestão");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        colocarComponentes(panel);
        
        frame.setVisible(true);
    }
    
    private static void colocarComponentes(JPanel panel) {
        panel.setLayout(new GridLayout(5, 1));
        
        JButton btnUsuario = new JButton("Cadastrar Usuário");
        JButton btnCliente = new JButton("Cadastrar Cliente");
        JButton btnProduto = new JButton("Cadastrar Produto");
        JButton btnVenda = new JButton("Realizar Venda");
        JButton btnSair = new JButton("Sair");
        
        btnUsuario.addActionListener(e -> new TelaCadastroUsuario());
        btnCliente.addActionListener(e -> new TelaCadastroCliente());
        btnProduto.addActionListener(e -> new TelaCadastroProduto());
        btnVenda.addActionListener(e -> new TelaCadastroVenda());
        btnSair.addActionListener(e -> System.exit(0));
        
        panel.add(btnUsuario);
        panel.add(btnCliente);
        panel.add(btnProduto);
        panel.add(btnVenda);
        panel.add(btnSair);
    }
}
