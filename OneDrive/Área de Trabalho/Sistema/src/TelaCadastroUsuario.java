
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class TelaCadastroUsuario extends JFrame {
    public TelaCadastroUsuario() {
        setTitle("Cadastro de Usuário");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        
        JTextField txtNome = new JTextField();
        JTextField txtSenha = new JTextField();
        JTextField txtEmail = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        
        btnSalvar.addActionListener(e -> {
            Sistema.sistema.adicionarUsuario(new Usuario(txtNome.getText(), txtSenha.getText(), txtEmail.getText()));
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            dispose();
        });
        
        add(new JLabel("Nome:")); add(txtNome);
        add(new JLabel("Senha:")); add(txtSenha);
        add(new JLabel("Email:")); add(txtEmail);
        add(btnSalvar);
        
        setVisible(true);
    }
}