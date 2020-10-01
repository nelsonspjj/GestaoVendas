
package br.com.login.dao;
import br.com.login.model.UsuarioModel;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import br.com.login.util.JPAUtil;


public class UsuariosDAO {
    private ArrayList<UsuarioModel> lista = new ArrayList<>();

	public void adiciona(UsuarioModel usuario) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		em.close();
	}

	public UsuarioModel existeUsuario(String email, String senha) {
		this.getUsuarios();
		for(UsuarioModel usuario : lista) {
			if(usuario.ehIgual(email, senha)) {
				return usuario;
			}
		}
		return null;
	}
	
	public ArrayList<UsuarioModel> getUsuarios() {
                EntityManager em = new JPAUtil().getEntityManager();		
		em.getTransaction().begin();

        Query query = em.createQuery("SELECT u FROM UsuarioModel u");
        List<UsuarioModel> usuarios = query.getResultList();
        for(UsuarioModel usuario : usuarios){
    		lista.add(usuario);
        }

		em.getTransaction().commit();
		em.close();
		return lista;
	}
}
