
package br.com.login.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
    public static EntityManagerFactory emf = Persistence.createEntityManagerFactory("estoque");

	public EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
}
