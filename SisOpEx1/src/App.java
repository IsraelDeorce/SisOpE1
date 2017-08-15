import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Israel Deorce Vieira Junior - 16104279-1
 * @date 15 Agosto 2017
 * 
 * Este Programa le valores inteiros de um arquivo.txt, pergunta ao Usuario
 * se deseja fazer uma adicao(+) ou multiplicacao(*), e na sequencia, soma ou 
 * multiplica todos os valores do arquivo.txt e apresenta o resultado no Console.
 * O Usuario pode executar as operacoes quantas vezes quiser e pode
 * optar por terminar o programa enviando a letra e.
 *
 */
public class App {
	
	private static ArrayList<Integer> numerosArquivo = new ArrayList<>();
	
	public static void main(String[] args){		
		readFile("arquivo.txt");
		play();
	}
	
	public static void play(){
		String operando = "";
		//A classe Scanner esta sendo utilizada para gerenciador Entrada de dados informados pelo Usuario
		Scanner in = new Scanner(System.in);
		//Chamadas do sistema para apresentar frases no display
		System.out.println("####Escolhe o Operando####");	
		System.out.println("*  -->   Multiplicacao");
		System.out.println("+  -->   Adicao");
		System.out.println("e  -->   Exit/Sair");
		
		do{		
			//Chamada do Sistema para atribuir entrada do Usuario a uma variavel na memoria
			operando = in.nextLine();
			if(operando.equals("*")){
				//Mais uma vez chamada do sistema para apresentar uma frase no display
				System.out.println(multiplica());
			}
			if(operando.equals("+")){
				//Mais uma vez chamada do sistema para apresentar uma frase no display
				System.out.println(soma());
			}
			
		}while(!operando.equalsIgnoreCase("e"));
		
	}
	
	private static long multiplica() {
		long resultado = 1;
		for(Integer num : numerosArquivo){
			resultado = resultado * num;
		}
		return resultado;	
	}

	private static int soma() {
		int resultado = 0;
		for(Integer num : numerosArquivo){
			resultado = resultado + num;
		}
		return resultado;	
		
	}

	public static void readFile(String fileName){
		//O Paths.get usa o sistema para receber a localização do arquivo
		Path path = Paths.get(fileName);
		int i=0;
		//A classe Scanner esta sendo utilizada para chamar o Sistema de Gerenciamento de arquivos do O.S.
		try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))){
			while (sc.hasNextLine()){
				numerosArquivo.add(Integer.parseInt(sc.next()));				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numerosArquivo.size()==0){
			//Mais uma vez chamada do sistema para apresentar uma frase no display
			System.out.println("Arquivo vazio!");
			//chamado no sistema para interromper o processo que apresentou falha
			System.exit(1);
		}
	}

}
