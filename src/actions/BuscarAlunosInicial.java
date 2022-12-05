package actions;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import model.Aluno;

public class BuscarAlunosInicial {
    public static void main(String[] args) {
    	
		Scanner sc = new Scanner(System.in);                      
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
	    EntityManager manager = factory.createEntityManager();
	    
	    
	    System.out.println("\nInsira a inicial que deseja buscar: ");
		String inicial = sc.nextLine();

		Query query = manager.createQuery("select t from Aluno as t where t.nome like :paramNome");
		query.setParameter("paramNome", "%" + inicial + "%");

		@SuppressWarnings("unchecked")
		List<Aluno> lista = query.getResultList();

		for (Aluno aluno : lista) {
			System.out.println("\nId: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());		
			System.out.println("CPF: " + aluno.getCpf());
			System.out.println("Data de Nascimento: " + aluno.getDataNascimento());
			System.out.println("Naturalidade: " + aluno.getNaturalidade());
			System.out.println("Endereço: " + aluno.getEndereco() + "\n");
		}

	    manager.close();
	    factory.close();
    }



    
    
    
	
	
	
}