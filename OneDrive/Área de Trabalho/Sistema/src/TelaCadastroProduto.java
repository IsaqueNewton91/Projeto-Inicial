
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class TelaCadastroProduto extends JFrame {
    public TelaCadastroProduto() {
        setTitle("Cadastro de Produto");
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));
        
        JTextField txtNome = new JTextField();
        JTextField txtDescricao = new JTextField();
        JTextField txtPreco = new JTextField();
        JTextField txtQuantidade = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        
        btnSalvar.addActionListener(e -> {
            double preco = Double.parseDouble(txtPreco.getText());
            int quantidade = Integer.parseInt(txtQuantidade.getText());
            Sistema.sistema.cadastroProduto.cadastrarProduto(new Produto(txtNome.getText(), txtDescricao.getText(), preco, quantidade));
            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            dispose();
        });
        
        add(new JLabel("Nome:")); add(txtNome);
        add(new JLabel("Descrição:")); add(txtDescricao);
        add(new JLabel("Preço:")); add(txtPreco);
        add(new JLabel("Quantidade:")); add(txtQuantidade);
        add(btnSalvar);
        
        setVisible(true);
    }
}