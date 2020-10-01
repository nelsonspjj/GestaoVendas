package br.com.login.dao;

import br.com.login.adapter.Persistencia;
import br.com.login.database.MySQL;
import br.com.login.database.SQLServer;
import br.com.login.model.Produto;
import br.com.login.model.UsuarioModel;
import br.com.login.util.JPAUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public class ProdutoDAO  {

    private Connection connection;
    private MySQL
            sqlServer;

    public ProdutoDAO() {
        sqlServer = new MySQL();
        connection = sqlServer.getConnection();
    }

   // @Override
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

   // @Override
    public Object findById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public void update(Object object) {
        Produto produto = (Produto) object;
        
       // sqlServer = new SQLServer();
        
        connection = sqlServer.getConnection();

        try {
            PreparedStatement ps = connection.prepareStatement("update produto set nome = ?, preco = ?, observacao = ? where produtoid = ?");
            ps.setString(1, produto.getNome());
            ps.setDouble(2, produto.getPreco());
            ps.setString(3, produto.getObservacao());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

   // @Override
    public void deleteById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   // @Override
    public List<Object> findAll2() {
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
    
        public void adiciona(Produto produto) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(produto);
		em.getTransaction().commit();
		em.close();
	}

	public void alterar(Produto produto) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Produto novo_produto = em.find(Produto.class, produto.getId());
		novo_produto.setNome(produto.getNome());
		novo_produto.setPreco(produto.getPreco());
		novo_produto.setObservacao(produto.getObservacao());
		em.getTransaction().commit();
		em.close();
	}

	public void remove(Long valor) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		Produto produto = em.find(Produto.class, valor);
		em.remove(produto);
		em.getTransaction().commit();
		em.close();
	}
    
    public ArrayList<Produto> findAll() {
        ArrayList<Produto> lista = new ArrayList<>();
        
	EntityManager em = new JPAUtil().getEntityManager();
	em.getTransaction().begin();

	Query query = em.createQuery("SELECT u FROM Produto u");
        List<Produto> produtos = query.getResultList();
        for(Produto produto : produtos){
    		lista.add(produto);
        }

		em.getTransaction().commit();
		em.close();
		return lista;
	}

}
