import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ListagemVIEW1 extends javax.swing.JFrame {

    public ListagemVIEW1() {
        initComponents();
        listarProdutos(); // Carregar a lista de produtos ao iniciar
    }

    private void initComponents() {
        btnVender = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnVendas = new javax.swing.JButton();
        btnVoltar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        listaProdutos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        id_produto_venda = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVender.setText("Vender");
        btnVender.addActionListener(this::btnVenderActionPerformed);

        btnVendas.setText("Consultar Vendas");
        btnVendas.addActionListener(this::btnVendasActionPerformed);

        btnVoltar.setText("Voltar");
        btnVoltar.addActionListener(this::btnVoltarActionPerformed);

        listaProdutos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Valor", "Status"
            }
        ));
        jScrollPane1.setViewportView(listaProdutos);

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 18)); 
        jLabel1.setText("Lista de Produtos");

        jLabel2.setFont(new java.awt.Font("Lucida Fax", 0, 14)); 
        jLabel2.setText("Vender Produto (ID)");

        jScrollPane2.setViewportView(id_produto_venda);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnVender))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btnVoltar)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addGap(187, 187, 187)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnVender))
                .addGap(29, 29, 29)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVendas)
                    .addComponent(btnVoltar))
                .addGap(37, 37, 37))
        );

        pack();
    }

    private void btnVenderActionPerformed(java.awt.event.ActionEvent evt) {                                          
        String id = id_produto_venda.getText();
        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, insira o ID do produto.");
            return;
        }

        ProdutoSDAO produtosdao = new ProdutoSDAO();
        boolean sucesso = produtosdao.venderProduto(Integer.parseInt(id));

        if (sucesso) {
            JOptionPane.showMessageDialog(this, "Produto vendido com sucesso!");
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao vender produto.");
        }

        listarProdutos(); // Atualizar a lista após a venda
    }

    private void btnVendasActionPerformed(java.awt.event.ActionEvent evt) {                                          
        // Exibir apenas os produtos vendidos
        listarVendas();
    }

    private void btnVoltarActionPerformed(java.awt.event.ActionEvent evt) {                                          
        this.dispose();  // Fecha a tela atual
    }

    private void listarProdutos() {
        List<Object[]> produtos = getProdutosAVenda();
        String[] colunas = {"ID", "Nome", "Valor", "Status"};
        Object[][] dados = new Object[produtos.size()][4];

        for (int i = 0; i < produtos.size(); i++) {
            dados[i] = produtos.get(i);
        }

        listaProdutos.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
    }

    private List<Object[]> getProdutosAVenda() {
        List<Object[]> produtos = new ArrayList<>();
        try (Connection con = Conexao2.getConnection()) {
            String sql = "SELECT * FROM produtos WHERE status = 'A Venda'";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int valor = rs.getInt("valor");
                String status = rs.getString("status");
                produtos.add(new Object[]{id, nome, valor, status});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar produtos: " + e.getMessage());
        }
        return produtos;
    }

    // Novo método para listar apenas produtos vendidos
    private void listarVendas() {
        List<Object[]> produtosVendidos = getProdutosVendidos();
        String[] colunas = {"ID", "Nome", "Valor", "Status"};
        Object[][] dados = new Object[produtosVendidos.size()][4];

        for (int i = 0; i < produtosVendidos.size(); i++) {
            dados[i] = produtosVendidos.get(i);
        }

        listaProdutos.setModel(new javax.swing.table.DefaultTableModel(dados, colunas));
    }

    private List<Object[]> getProdutosVendidos() {
        List<Object[]> produtos = new ArrayList<>();
        try (Connection con = Conexao2.getConnection()) {
            String sql = "SELECT * FROM produtos WHERE status = 'Vendido'";  // Alterado para buscar apenas produtos vendidos
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                int valor = rs.getInt("valor");
                String status = rs.getString("status");
                produtos.add(new Object[]{id, nome, valor, status});
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao consultar produtos: " + e.getMessage());
        }
        return produtos;
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new ListagemVIEW1().setVisible(true);
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnVendas;
    private javax.swing.JButton btnVender;
    private javax.swing.JButton btnVoltar;
    private javax.swing.JTextPane id_produto_venda;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable listaProdutos;
    // End of variables declaration                   

}
