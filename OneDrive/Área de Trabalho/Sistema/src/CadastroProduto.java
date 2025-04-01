
import java.util.ArrayList;
import java.util.List;

class CadastroProduto {
    List<Produto> produtos = new ArrayList<>();
    
    public void cadastrarProduto(Produto produto) {
        produtos.add(produto);
    }
}