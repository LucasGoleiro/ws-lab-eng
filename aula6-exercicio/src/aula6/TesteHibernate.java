package aula6;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class TesteHibernate {
	
	public static void criarPets(EntityManager em) { 
		Pet p1 = new Pet();
		p1.setId("001");;
		p1.setNome("Toto");
		p1.setEspecie("cachorro");
		p1.setRaca("Pastor Alemão");
		
		Pet p2 = new Pet();
		p2.setId("002");;
		p2.setNome("Galvão");
		p2.setEspecie("cachorro");
		p2.setRaca("Pastor Alemão");
		
		em.getTransaction().begin();
		em.persist(p1);
		em.persist(p2);
		em.getTransaction().commit();
	}
	
	public static void listarPets(EntityManager em) { 
		TypedQuery<Pet> qry = 
				em.createQuery("select a from Pet p", Pet.class);
		List<Pet> lista = qry.getResultList();
		for (Pet p : lista) { 
			System.out.printf("Nome: %s\t-\tRaca: %s %n", p.getNome(), p.getRaca());
		}
	}
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("PETS");
		
		EntityManager em = emf.createEntityManager();
		criarPets(em);
		//listarPets(em);
		em.close();
		
		emf.close();
	}

}
