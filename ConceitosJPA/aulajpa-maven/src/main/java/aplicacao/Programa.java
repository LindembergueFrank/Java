/*package aplicacao;

import dominio.Pessoa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Programa {

	public static void main(String[] args) {
		
		// Encapsulando conexão com BD e instanciando
		EntityManagerFactory entitymf = Persistence.createEntityManagerFactory("exemplo-jpa");
		EntityManager em = entitymf.createEntityManager();
		
		em.getTransaction().begin();
		// Buscando usuario no BD
		Pessoa pessoa = em.find(Pessoa.class, 2);
		System.out.println(pessoa);
		
		// Removendo usuario (entidade esta monitorada)
		em.remove(pessoa);
		
		em.getTransaction().commit();
		
		System.out.println("Feito!");
		entitymf.close();
		em.close();

	}

}
*/