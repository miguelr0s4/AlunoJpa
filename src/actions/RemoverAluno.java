package actions;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class RemoverAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        
		Scanner sc = new Scanner(System.in);                                                                                        

        
        System.out.println("\nInsira o id do Aluno que deseja excluir:  ");
		Long idExcluir = sc.nextLong();
		
        Aluno a1 = manager.find(Aluno.class, idExcluir);
        manager.remove(a1);
        manager.getTransaction().commit();
        
		System.out.println("O contato de " + a1.getNome() + " foi excluído com sucesso.");

        manager.close();
        factory.close();
        
    }
}
