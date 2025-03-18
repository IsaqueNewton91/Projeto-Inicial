import javax.swing.*;
import java.awt.*;

public class ProdutoScreen {
    public static void showProdutoScreen() {
        JFrame frame = new JFrame("Gestão Simples - Cadastro Produtos");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(5, 2));
        frame.add(panel);

        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Descrição:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Preço Venda:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Quantidade:"));
        panel.add(new JTextField(20));

        JButton backButton = new JButton("Voltar");
        JButton registerButton = new JButton("Cadastrar");

        panel.add(backButton);
        panel.add(registerButton);

        backButton.addActionListener(e -> frame.dispose());
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Produto cadastrado!"));

        frame.setVisible(true);
    }
}
