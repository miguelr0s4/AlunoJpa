package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class ListarAlunos {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);                      
	    EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
	    EntityManager manager = factory.createEntityManager();
	    
		@SuppressWarnings("unchecked")
		List<Aluno> lista = manager.createQuery("select t from Aluno as t ").getResultList();

		for (Aluno aluno : lista) {
			System.out.println("\nId: " + aluno.getId());
			System.out.println("Nome: " + aluno.getNome());
			System.out.println("Email: " + aluno.getEmail());		
			System.out.println("CPF: " + aluno.getCpf());
		
			LocalDate dataNascimmento = aluno.getDataNascimento();
			DateTimeFormatter formatacao = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String dataFormatada = dataNascimmento.format(formatacao);  
	        
			System.out.println("Data de Nascimento: " + dataFormatada);
			System.out.println("Naturalidade: " + aluno.getNaturalidade());
			System.out.println("Endereço: " + aluno.getEndereco() + "\n");
		}

	    manager.close();
	    factory.close();
	}
}
