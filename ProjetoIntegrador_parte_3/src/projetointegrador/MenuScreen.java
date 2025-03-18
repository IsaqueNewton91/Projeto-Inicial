import javax.swing.*;
import java.awt.*;

public class MenuScreen {
    public static void showMenu() {
        JFrame frame = new JFrame("Gestão Simples - Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        JPanel panel = new JPanel();
        frame.add(panel);
        panel.setLayout(new GridLayout(4, 1));

        JButton vendasButton = new JButton("Lançamento de Vendas");
        JButton produtosButton = new JButton("Cadastro de Produtos");
        JButton clientesButton = new JButton("Cadastro de Clientes");
        JButton voltarButton = new JButton("Voltar");

        vendasButton.addActionListener(e -> VendaScreen.showVendaScreen());
        produtosButton.addActionListener(e -> ProdutoScreen.showProdutoScreen());
        clientesButton.addActionListener(e -> ClienteScreen.showClienteScreen());
        voltarButton.addActionListener(e -> frame.dispose());

        panel.add(vendasButton);
        panel.add(produtosButton);
        panel.add(clientesButton);
        panel.add(voltarButton);

        frame.setVisible(true);
    }
}
