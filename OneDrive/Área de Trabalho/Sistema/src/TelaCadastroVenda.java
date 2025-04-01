
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

class TelaCadastroVenda extends JFrame {
    public TelaCadastroVenda() {
        setTitle("Realizar Venda");
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));
        
        JTextField txtData = new JTextField();
        JTextField txtProduto = new JTextField();
        JTextField txtValor = new JTextField();
        JButton btnSalvar = new JButton("Salvar");
        
        btnSalvar.addActionListener(e -> {
            String data = txtData.getText();
            String nomeProduto = txtProduto.getText();
            double valor = Double.parseDouble(txtValor.getText().replace("R$", "").trim());
            
            for (Produto p : Sistema.sistema.cadastroProduto.produtos) {
                if (p.nome.equalsIgnoreCase(nomeProduto)) {
                    Venda venda = new Venda(data, p, valor);
                    Sistema.sistema.cadastroVenda.cadastrarVenda(venda);
                    dispose();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Produto não encontrado!");
        });
        
        add(new JLabel("Data:")); add(txtData);
        add(new JLabel("Produto:")); add(txtProduto);
        add(new JLabel("Valor (R$):")); add(txtValor);
        add(btnSalvar);
        
        setVisible(true);
    }
}
