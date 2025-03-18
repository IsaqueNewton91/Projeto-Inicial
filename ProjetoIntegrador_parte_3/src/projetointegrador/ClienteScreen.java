import javax.swing.*;
import java.awt.*;

public class ClienteScreen {
    public static void showClienteScreen() {
        JFrame frame = new JFrame("Gestão Simples - Cadastro Clientes");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel(new GridLayout(4, 2));
        frame.add(panel);

        panel.add(new JLabel("Nome:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Endereço:"));
        panel.add(new JTextField(20));
        panel.add(new JLabel("Telefone:"));
        panel.add(new JTextField(20));

        JButton backButton = new JButton("Voltar");
        JButton registerButton = new JButton("Cadastrar");

        panel.add(backButton);
        panel.add(registerButton);

        backButton.addActionListener(e -> frame.dispose());
        registerButton.addActionListener(e -> JOptionPane.showMessageDialog(panel, "Cliente cadastrado!"));

        frame.setVisible(true);
    }
}
