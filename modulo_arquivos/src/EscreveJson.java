import com.google.gson.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EscreveJson {

    public static void main(String[] args) throws IOException {

        Usuario usuario1 = new Usuario();
        usuario1.setNome("Jorge");
        usuario1.setCpf("050.277.939-01");
        usuario1.setLogin("jferraz");
        usuario1.setSenha("123456");

        Usuario usuario2 = new Usuario();
        usuario2.setNome("Aline");
        usuario2.setCpf("346.796.528-88");
        usuario2.setLogin("aferraz");
        usuario2.setSenha("654321");

        Usuario usuario3 = new Usuario();
        usuario3.setNome("Heloyse");
        usuario3.setCpf("123.456.789-00");
        usuario3.setLogin("helo");
        usuario3.setSenha("17052012");

        List<Usuario> usuarios = new ArrayList<Usuario>();
        usuarios.add(usuario1);
        usuarios.add(usuario2);
        usuarios.add(usuario3);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonUser = gson.toJson(usuarios);
        System.out.println(jsonUser);

        FileWriter fileWriter = new FileWriter("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\fileJson.json");
        fileWriter.write(jsonUser);
        fileWriter.flush();
        fileWriter.close();

        //****--------------- LENDO O ARQUIVO JSON ---------------**********//

        FileReader fileReader = new FileReader("C:\\Users\\jferraz\\Desktop\\primeiro-programa-java\\modulo_arquivos\\fileJson.json");

        JsonArray jsonArray = (JsonArray) JsonParser.parseReader(fileReader);

        List<Usuario> liUsuarios = new ArrayList<Usuario>();

        for (JsonElement jsonElement : jsonArray) {
            Usuario usuario = new Gson().fromJson(jsonElement, Usuario.class);
            liUsuarios.add(usuario);

        }

        System.out.println("Leitura  do arquivo JSON terminado com SUCESSO: " + liUsuarios);

    }
}
