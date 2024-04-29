import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Iterator;

public class ApachePoiEditandoNEW {

    public static void main(String[] args) throws Exception {

        File file = new File("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\arquivo_excel.xls");
        FileInputStream entrada = new FileInputStream(file);

        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(entrada);/*Prepara a entrada do arquivo xls excel para ler*/
        HSSFSheet planilha = hssfWorkbook.getSheetAt(0);/*Pega a primeira planilha do nosso arquivo excel*/

        Iterator<Row> linhaIterator = planilha.iterator();

        while (linhaIterator.hasNext()){ /*Enquanto tiver linha no arquivo excel*/
            Row linha = linhaIterator.next(); /*Dados da pessoa na linha*/

            String valorCelula = linha.getCell(0).getStringCellValue();
            linha.getCell(0).setCellValue(valorCelula + " * Valor gravado na aula");
        }
        entrada.close();
        FileOutputStream saida = new FileOutputStream(file);
        hssfWorkbook.write(saida);
        saida.flush();
        saida.close();

        System.out.println("Planilha Atualizada !!");

    }
}
