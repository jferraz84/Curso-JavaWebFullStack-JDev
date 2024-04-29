import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class EscreverApachePoi {
    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\arquivo_excel.xls");

        if (!file.exists()) {
            file.createNewFile();
        }

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

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(); /* Vai ser usado para escrever na planilha*/
        HSSFSheet linhasPessoa = hssfWorkbook.createSheet("Plannilha de pessoas JDev Treinamentos");/*Criar a planilha*/

        int numeroLinha = 0;
        for (Pessoa p : pessoas) {
            Row linha = linhasPessoa.createRow(numeroLinha ++); /*Criando a linha na planilha*/

            int celula = 0;
            Cell celNome = linha.createCell(celula ++);/*Célula 1*/
            celNome.setCellValue(p.getName());

            Cell celIdade = linha.createCell(celula ++);/*Célula 2*/
            celIdade.setCellValue(p.getIdade());

            Cell celEmail = linha.createCell(celula ++);/*Célula 3*/
            celEmail.setCellValue(p.getEmail());
        }/*Terminou de montar a planilha*/

        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);/*Escreve a planilha em Arquivo*/
        saida.flush();
        saida.close();

        System.out.println("Planilha Criada !!!!!");


    }
}
