package br.com.login.dao;

import br.com.login.adapter.Persistencia;
import br.com.login.database.SQLServer;
import br.com.login.model.Produto;
import br.com.login.model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO implements Persistencia {

    private final Connection connection;
    private final SQLServer sqlServer;

    public ProdutoDAO() {
        sqlServer = new SQLServer();
        connection = sqlServer.getConnection();
    }

    @Override
    public void salvar(Object object) {
        Produto produto = (Produto) object;

        try {
            PreparedStatement ps = connection.prepareStatement("insert into produto(nome, preco, observacao) values (?,?,?)");
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getObservacao());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Object> findAll() {
        List<Object> produtos = new ArrayList<>();

        try {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("select * from produto");
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getLong("produtoid"));
                produto.setNome(rs.getString("nome"));
                produto.setPreco(rs.getDouble("preco"));
                produto.setObservacao(rs.getString("observacao"));
                produtos.add(produto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return produtos;
    }

}
