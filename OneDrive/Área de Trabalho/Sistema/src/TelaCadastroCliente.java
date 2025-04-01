
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class TelaCadastroCliente extends JFrame {
    public TelaCadastroCliente() {
        setTitle("Cadastro de Cliente");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        
        JTextField txtNome = new JTextField();
        JTextField txtEndereco = new JTextField();
        JTextField txtTelefone = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        
        btnSalvar.addActionListener(e -> {
            Sistema.sistema.adicionarCliente(new Cliente(txtNome.getText(), txtEndereco.getText(), txtTelefone.getText()));
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            dispose();
        });
        
        add(new JLabel("Nome:")); add(txtNome);
        add(new JLabel("Endereço:")); add(txtEndereco);
        add(new JLabel("Telefone:")); add(txtTelefone);
        add(btnSalvar);
        
        setVisible(true);
    }
}