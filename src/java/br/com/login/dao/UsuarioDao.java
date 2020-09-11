package br.com.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.login.model.UsuarioModel;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDao {

    private Connection conn;
    ConexaoDB conexao = new ConexaoDB();

    public boolean validarLogin(String pEmail, String pSenha) {
        conn = conexao.getConnection();

        boolean logado = false;

        try {
            PreparedStatement ps = conn.prepareStatement("select * from Usuario where email=? and senha=?");
            ps.setString(1, pEmail);
            ps.setString(2, pSenha);

            ResultSet rs = ps.executeQuery();
            logado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return logado;
    }

    public UsuarioModel usuarioSessao(String pEmail) {
        UsuarioModel sessao = new UsuarioModel();
        conn = conexao.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("select * from Usuario where email=?");
            ps.setString(1, pEmail);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                sessao.setUsuarioId(rs.getInt("usuarioId"));
                sessao.setLogin(rs.getString("login"));
                sessao.setSenha(rs.getString("senha"));
                sessao.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sessao;
    }

    public void criarUsuario(UsuarioModel pLogin) {
        conn = conexao.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("insert into usuario(login, senha, email) values (?,?,?)");
            ps.setString(1, pLogin.getLogin());
            ps.setString(2, pLogin.getSenha());
            ps.setString(3, pLogin.getEmail());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editarUsuario(UsuarioModel pUsuario) {
        conn = conexao.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("update usuario set login = ?, senha = ? where usuarioId = ?");
            ps.setString(1, pUsuario.getLogin());
            ps.setString(2, pUsuario.getSenha());
            ps.setInt(3, pUsuario.getUsuarioId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void excluirUsuario(int pUsuarioId) {
        conn = conexao.getConnection();
        
        try {
            PreparedStatement ps = conn.prepareStatement("delete from usuario where usuarioId = ?");
            ps.setInt(1, pUsuarioId);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UsuarioModel> listarUsuarios() {
        List<UsuarioModel> userList = new ArrayList<UsuarioModel>();
        conn = conexao.getConnection();

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
            e.printStackTrace();
        }

        return userList;
    }

    public UsuarioModel buscarUsuarioPorID(int pUsuarioId) {
        UsuarioModel usuario = new UsuarioModel();
        conn = conexao.getConnection();

        try {
            PreparedStatement ps = conn.prepareStatement("select * from usuario where usuarioId = ?");
            ps.setInt(1, pUsuarioId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                usuario.setUsuarioId(rs.getInt("pUsuarioId"));
                usuario.setLogin(rs.getString("login"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return usuario;
    }
}
