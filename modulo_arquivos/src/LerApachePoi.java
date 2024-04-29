import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LerApachePoi {
    public static void main(String[] args) throws Exception {

        FileInputStream entrada = new FileInputStream(new File("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\arquivo_excel.xls"));

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada); /*Prepara a entrada do arquivo xls para ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*Pega a primeira planilha do nosso arquivo excel*/

        Iterator<Row> linhaIterator = planilha.iterator();

        List<Pessoa>  pessoas = new ArrayList<>();

        while (linhaIterator.hasNext()){ /*Enquanto tiver linha no arquivo excel*/
            Row linha = linhaIterator.next();/*Dados da pessoa na linha*/
            Iterator<Cell> celula = linha.iterator();

            Pessoa pessoa = new Pessoa();
            while (celula.hasNext()){ /*Percorrer as células*/
                Cell cell = celula.next();
                switch (cell.getColumnIndex()){
                    case 0:
                        pessoa.setName(cell.getStringCellValue());
                        break;
                    case  1:
                        pessoa.setIdade(Double.valueOf(cell.getNumericCellValue()).intValue());
                        break;
                    case  2:
                        pessoa.setEmail(cell.getStringCellValue());
                        break;
                }
            } /*Fim das celulas da linha*/

            pessoas.add(pessoa);
        }
        entrada.close();/*Terminou de ler o arquivo excel*/

        for (Pessoa pessoa : pessoas) {
            System.out.println(pessoa);
            System.out.println("===========================================");
        }

    }
}
