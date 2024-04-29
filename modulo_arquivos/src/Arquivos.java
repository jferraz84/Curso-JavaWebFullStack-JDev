import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Arquivos {
    public static void main(String[] args) throws IOException {

        Pessoa pessoa1 = new Pessoa();
        pessoa1.setName("Jorge");
        pessoa1.setIdade(39);
        pessoa1.setEmail("jferraz@cpqd.com.br");

        Pessoa pessoa2 = new Pessoa();
        pessoa2.setName("Aline");
        pessoa2.setIdade(37);
        pessoa2.setEmail("aferraz@cpqd.com.br");

        Pessoa pessoa3 = new Pessoa();
        pessoa3.setName("Heloyse");
        pessoa3.setIdade(12);
        pessoa3.setEmail("helo@cpqd.com.br");

        Pessoa pessoa4 = new Pessoa();
        pessoa4.setName("Heloa");
        pessoa4.setIdade(07);
        pessoa4.setEmail("heloaIsa@cpqd.com.br");

        List<Pessoa> pessoas = new ArrayList<>();
        pessoas.add(pessoa1);
        pessoas.add(pessoa2);
        pessoas.add(pessoa3);
        pessoas.add(pessoa4);


        File arquivo = new File("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\arquivo.csv");

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }
        FileWriter escrever_no_arquivo = new FileWriter(arquivo);

        for (Pessoa p : pessoas){
            escrever_no_arquivo.write( p.getName() +";" + p.getIdade() +";" + p.getEmail() + "\n");
        }

        /*escrever_no_arquivo.write("Meu texto do Arquivo");
        escrever_no_arquivo.write("\n");
        escrever_no_arquivo.write("Digitando minha segunda linha no Arquivo de texto em Java \n");

        for (int i = 1; i <= 10; i++) {
            escrever_no_arquivo.write("Esse é o texto da linha n°: " + i + "\n");
        }*/


        escrever_no_arquivo.flush();

        escrever_no_arquivo.close();

        System.out.println("Escrita no Arquivo executado com SUCESSO !!1");


    }
}