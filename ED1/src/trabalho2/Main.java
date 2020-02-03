package trabalho2;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
    	Scanner entrada = new Scanner(System.in);
		System.out.println("Digite arquivo a verificar: ");
		String nome = entrada.next();
		entrada.close();
		File arquivo = new File("C:\\Users\\raf4a\\eclipse-workspace\\ED1\\src\\trabalho2" + nome + ".txt");

		// fazendo um try para inserir o arquivo no bufferedReader e le-lo com maior facilidade
		BufferedReader buffer = null;
		try {
			buffer = new BufferedReader(new FileReader(arquivo));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// declarando lista que recebera cada palavra
		LSEO<String> listaOrdenada = new LSEO<String>();
		String linha;

		// le linha por linha e insere palavra/token em um nó diferente
		while ((linha = buffer.readLine()) != null) {
			StringTokenizer iteraArquivo = new StringTokenizer(linha);
			while (iteraArquivo.hasMoreTokens()) {
				String novoNo = new String(iteraArquivo.nextToken().toLowerCase());
				// insere na lista simplesmente ordenada
				listaOrdenada.inserirListaCrescente(novoNo);
		}
    }
}
}
