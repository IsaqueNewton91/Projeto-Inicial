
import javax.swing.JOptionPane;

class CadastroVenda {
    public void cadastrarVenda(Venda venda) {
        JOptionPane.showMessageDialog(null, "Venda realizada com sucesso!\nProduto: " + venda.produto.nome + "\nData: " + venda.data + "\nValor: R$" + venda.valor);
    }
}