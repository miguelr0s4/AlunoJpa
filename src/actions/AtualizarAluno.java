package actions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.Aluno;

public class AtualizarAluno {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("alunos");
        EntityManager manager = factory.createEntityManager();
        manager.getTransaction().begin();
		Scanner sc = new Scanner(System.in);         
		
    	System.out.println("\nInsira o id que deseja alterar: ");
		Long idAltera = Long.parseLong(sc.nextLine());
		
        Aluno a1 = manager.find(Aluno.class, idAltera);
          


		String respostaNome="";
		String respostaEmail="";
		String respostaCpf="";
		String respostaDataNascimento="";
		String respostaNaturalidade="";
		String respostaEndereco="";
		
		String nomeAnterior = a1.getNome();
		String emailAnterior = a1.getEmail();
		String cpfAnterior = a1.getCpf();
		LocalDate dataNascimentoAnterior = a1.getDataNascimento();
		String naturalidadeAnterior = a1.getNaturalidade();
		String enderecoAnterior = a1.getEndereco();
		
		String novoNome = nomeAnterior;
		String novoEmail= emailAnterior; 
		String novoCpf= cpfAnterior; 
		LocalDate novaDataNascimento = dataNascimentoAnterior; 
		String novaNaturalidade=naturalidadeAnterior; 
		String novoEndereco=enderecoAnterior;

		
		System.out.println("\n\nAltere os dados necessários:");
		System.out.println("Nome: "+ nomeAnterior);
		System.out.println("Novo nome:");
		respostaNome = sc.nextLine();
		
		if (respostaNome != null || respostaNome != "") {
			a1.setNome(respostaNome);
			novoNome = respostaNome;
		}
	
		
		System.out.println("\nEmail: "+ emailAnterior);
		System.out.println("Novo email:");
		respostaEmail = sc.nextLine();
		
		if (respostaEmail != null || respostaEmail != "") {
			a1.setEmail(respostaEmail);
			novoEmail = respostaEmail;
		}
		
		
		System.out.println("\nCPF: "+ cpfAnterior);
		System.out.println("Novo CPF:");
		respostaCpf = sc.nextLine();
		
		if (respostaCpf != null || respostaCpf != "") {
			a1.setCpf(respostaCpf);
			novoCpf = respostaCpf;
		}
	
		
		System.out.println("\nData Nascimento: "+ dataNascimentoAnterior);
		System.out.println("Nova Data de Nascimento:");
		respostaDataNascimento = sc.nextLine();
		
		if (respostaDataNascimento != null || respostaDataNascimento != "") {
	        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	        LocalDate dataFormatada = LocalDate.parse(respostaDataNascimento, formatter);
	        a1.setDataNascimento(dataFormatada);
			novaDataNascimento = dataFormatada;
		}
		
		
		System.out.println("\nNaturalidade: "+ naturalidadeAnterior);
		System.out.println("Nova naturalidade:");
		respostaNaturalidade = sc.nextLine();
		
		if (respostaNaturalidade != null || respostaNaturalidade != "") {
			a1.setNaturalidade(respostaNaturalidade);
			novaNaturalidade = respostaNaturalidade;
		}	
		
		
		System.out.println("\nEndereço: "+ enderecoAnterior);
		System.out.println("Novo endereço:");
		respostaEndereco = sc.nextLine();				

		if (respostaEndereco != null || respostaEndereco != "") {
			a1.setEndereco(respostaEndereco);
			novoEndereco = respostaEndereco;
		}
		
		manager.merge(a1);
		
		System.out.println("\nInformações do Aluno foram alteradas! Veja como ficou: ");					
		System.out.println("\nNome: "+ novoNome);
		System.out.println("Email: "+ novoEmail);
		System.out.println("CPF: "+ novoCpf);
		System.out.println("Data de Nascimento: "+ novaDataNascimento);
		System.out.println("Naturalidade: "+ novaNaturalidade);
		System.out.println("Endereço : "+ novoEndereco +"\n");
      
        manager.getTransaction().commit();
        manager.close();
        factory.close();
    }
}
