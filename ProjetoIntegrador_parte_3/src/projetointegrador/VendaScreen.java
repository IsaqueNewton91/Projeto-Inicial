import javax.swing.*;
import java.awt.*;

public class VendaScreen {
    public static void showVendaScreen() {
        JFrame frame = new JFrame("Gestão Simples - Lançamento de Vendas");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        frame.add(panel);

        panel.add(new JLabel("Data:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Produto:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Valor:"));
        panel.add(new JTextField(20));

        JButton backButton = new JButton("Voltar");
        JButton registerButton = new JButton("Cadastrar");

        panel.add(backButton);
        panel.add(registerButton);

        backButton.addActionListener(e -> frame.dispose());
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Venda registrada!"));

        frame.setVisible(true);
    }
}
