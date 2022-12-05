package actions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class InserirAluno {
    public static void main(String[] args) {
    	
		Scanner sc = new Scanner(System.in);                                                                                        
   
		Aluno a1 = new Aluno();
   	 
    	System.out.println("\nInsira o nome: ");
    	a1.setNome(sc.nextLine());
						
    	System.out.println("\nInsira o e-mail: ");
    	a1.setEmail(sc.nextLine());
    	
    	System.out.println("\nInsira o CPF (somente números): ");
    	a1.setCpf(sc.nextLine());
    	
    	System.out.println("\nInsira a data de nascimento com as barras (Formato dd/mm/yyyy): ");
        String dataNascimento = sc.nextLine();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dataFormatada = LocalDate.parse(dataNascimento, formatter);
        a1.setDataNascimento(dataFormatada);


    	System.out.println("\nInsira a naturalidade: ");
    	a1.setNaturalidade(sc.nextLine());
    	
    	System.out.println("\nInsira o endereço: ");
    	a1.setEndereco(sc.nextLine());


        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
        manager.persist(a1);
        
        System.out.println("Aluno " + a1.getNome() + " foi cadastrado com sucesso! Seu id eh: " + a1.getId());
        
        manager.getTransaction().commit();
        manager.close();
        factory.close();
        
    }
}
