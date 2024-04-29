package enviando.email;

/**
 * Unit test for simple App.
 */
public class AppTest {
	
	
	@org.junit.Test
	public void testeEmail() throws Exception{
		
		StringBuilder stringBuilderTexto = new StringBuilder();
		
		stringBuilderTexto.append("Olá, tudo bem !! <br/><br/>");
		stringBuilderTexto.append("Olá você acaba de receber o acesso ao curso de Java <br/><br/>");
		stringBuilderTexto.append("Para ter concluir o acesso clique no botão abaixo. <br/><br/>");
		
		stringBuilderTexto.append("<b>Login:</b> jferraz@gmail.com<br/>");
		stringBuilderTexto.append("<b>Senha:</b> Hha1710627<br/><br/>");
		
		
		stringBuilderTexto.append("<a target=\"_blank\" href=\"http://projetojavaweb.com/certificado-aluno/login\" style=\"color:#2525a7; padding: 14px 25px; text-align:center; text-decoration: none; display:inline-block; border-radius:30px; font-size:20px; font-family:courier; border : 3px solid green;background-color:#99DA39;\">Acessar Portal do Aluno</a><br/><br/>");
		
		
		stringBuilderTexto.append("<span style=\"font-size:12px\">Ass: Jorge Ferraz</span>");
		
		ObjetoEnviaEmail enviaEmail = 
				new ObjetoEnviaEmail("email.tst.curso@gmail.com, jferrazjorge@gmail.com",
						             "Jorge Ferraz - Curso Java",
						             "Chegou e-mail enviado com Java",
						             stringBuilderTexto.toString());
			    //"Olá você acaba de receber um e-mail enviado com Java do curso Formação Java DEV");
		
		enviaEmail.enviarEmailAnexo(true);
		
		
	}
	
}
