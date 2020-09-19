package br.com.login.dao;

import br.com.login.database.MySQL;
import br.com.login.adapter.Persistencia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.login.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao implements Persistencia {

    private final Connection conn;
    private final MySQL conexao;

    public UsuarioDao() {
        conexao = new MySQL();
        conn = conexao.getConnection();
    }

    public boolean validarLogin(String pEmail, String pSenha) {
        boolean logado = false;

        try {
            PreparedStatement ps = conn.prepareStatement("select * from Usuario where email=? and senha=?");
            ps.setString(1, pEmail);
            ps.setString(2, pSenha);

            ResultSet rs = ps.executeQuery();
            logado = rs.next();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return logado;
    }

    public UsuarioModel usuarioSessao(String pEmail) {
        UsuarioModel sessao = new UsuarioModel();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from Usuario where email=?");
            ps.setString(1, pEmail);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sessao.setUsuarioId(rs.getInt("usuarioId"));
                sessao.setLogin(rs.getString("login"));
                sessao.setNome(rs.getString("nome"));
                sessao.setSenha(rs.getString("senha"));
                sessao.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return sessao;
    }

    @Override
    public void salvar(Object object) {
        UsuarioModel usuario = (UsuarioModel) object;

        try {
            PreparedStatement ps = conn.prepareStatement("insert into usuario(nome, login, senha, email) values (?,?,?,?)");
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getLogin());
            ps.setString(3, usuario.getSenha());
            ps.setString(4, usuario.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Object findById(Long id) {
        UsuarioModel usuario = new UsuarioModel();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from usuario where usuarioId = ?");
            ps.setLong(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setUsuarioId(rs.getInt("usuarioId"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return usuario;
    }

    @Override
    public void update(Object object) {
        UsuarioModel usuario = (UsuarioModel) object;

        try {
            PreparedStatement ps = conn.prepareStatement("update usuario set login = ?, senha = ? where usuarioId = ?");
            ps.setString(1, usuario.getLogin());
            ps.setString(2, usuario.getSenha());
            ps.setInt(3, usuario.getUsuarioId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            PreparedStatement ps = conn.prepareStatement("delete from usuario where usuarioId = ?");
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Object> findAll() {
        List<Object> userList = new ArrayList<>();

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from usuario");
            while (rs.next()) {
                UsuarioModel user = new UsuarioModel();
                user.setUsuarioId(rs.getInt("usuarioId"));
                user.setLogin(rs.getString("login"));
                user.setSenha(rs.getString("senha"));
                user.setEmail(rs.getString("email"));
                userList.add(user);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return userList;
    }
}
