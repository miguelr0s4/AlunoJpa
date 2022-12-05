
package main;

import java.sql.SQLException;
import java.util.Scanner;

import actions.AtualizarAluno;
import actions.BuscarAlunosInicial;
import actions.InserirAluno;
import actions.ListarAlunos;
import actions.RemoverAluno;


public class Menu {

	public static void main(String[] args) throws SQLException {
		
		int opContinua; 
		opContinua = 1;
		
		do {
			System.out.println("\n\n=======   AGENDA   =======");
			System.out.println("1 – Cadastrar Aluno");
			System.out.println("2 – Listar alunos com Id");
			System.out.println("3 – Pesquisar alunos por inicial");
			System.out.println("4 - Atualizar Aluno");
			System.out.println("5 - Excluir Aluno");
			System.out.println("6 - Encerrar programa");
			System.out.println("\nInsira a opção desejada: ");
			
			Scanner sc = new Scanner(System.in);
			
			int op = Integer.
					parseInt(sc.nextLine());
			
			switch (op) {
		     case 1:
		    	 InserirAluno.main(args);
		    	 
		       break;

		     case 2:	
		    	 ListarAlunos.main(args);

				break;
     
		     case 3:		
		    	 BuscarAlunosInicial.main(args);

		       break;		
		       
		     case 4:
		    	 AtualizarAluno.main(args);

		       break;		       
		       
		     case 5:		
				RemoverAluno.main(args);
				
		       break;			       
		       
		     case 6:
		    	System.out.println("\nCerteza que deseja fechar o programa? Digite qualquer letra para sim e 0 para retornar ao menu.");
		    	String return6 = sc.next();
				if (return6.equals("0")) {
					break;	
				}else {
					opContinua = 0;
				}
				
		       break;

		     default:
		    	 System.out.println("\nOpção inválida.");
		    	 
		       break;
			}
		}while(opContinua == 1);
		
   	 System.out.println("Obrigado por usar!");
   	 System.exit(0);
		
	}
	
}
