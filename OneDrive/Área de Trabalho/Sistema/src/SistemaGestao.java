
import java.util.ArrayList;
import java.util.List;

class SistemaGestao {
    List<Usuario> usuarios = new ArrayList<>();
    List<Cliente> clientes = new ArrayList<>();
    CadastroProduto cadastroProduto = new CadastroProduto();
    CadastroVenda cadastroVenda = new CadastroVenda();
    
    public void adicionarUsuario(Usuario u) {
        usuarios.add(u);
    }
    
    public void adicionarCliente(Cliente c) {
        clientes.add(c);
    }
    
    public boolean login(String nome, String senha) {
        for (Usuario u : usuarios) {
            if (u.nome.equals(nome) && u.autenticar(senha)) {
                return true;
            }
        }
        return false;
    }
}