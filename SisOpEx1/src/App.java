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
		Scanner in = new Scanner(System.in);
		System.out.println("####Escolhe o Operando####");	
		System.out.println("*  -->   Multiplicacao");
		System.out.println("+  -->   Adicao");
		System.out.println("e  -->   Exit/Sair");
		
		do{		
			operando = in.nextLine();
			if(operando.equals("*")){
				System.out.println(multiplica());
			}
			if(operando.equals("+")){
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
		//o Paths.get utiliza 
		Path path = Paths.get(fileName);
		int i=0;
		try (Scanner sc = new Scanner(Files.newBufferedReader(path, Charset.forName("utf8")))){
			while (sc.hasNextLine()){
				numerosArquivo.add(Integer.parseInt(sc.next()));				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(numerosArquivo.size()==0){
			System.out.println("Arquivo vazio!");
			System.exit(1);
		}
	}

}
