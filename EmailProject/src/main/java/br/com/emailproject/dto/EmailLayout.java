package br.com.emailproject.dto;

import br.com.emailproject.model.Email;

public class EmailLayout {

	private static final String QUEBRA_DE_LINHA_DUPLA = "<br><br>";
	private static final String QUEBRA_DE_LINHA = "<br>";

	public Email montarEmailAdministrador(String destinatario, String assunto) {
		
		StringBuilder texto = new StringBuilder();

		texto.append("A/C Administrador")
		     .append(QUEBRA_DE_LINHA_DUPLA);

		texto.append("Solicito alteração de senha do sistema")
		     .append(QUEBRA_DE_LINHA_DUPLA);
		
		gerarAssinatura(texto);
	
		gerarRodape(texto);

		return new Email(destinatario, assunto, texto.toString());

	}

	private String gerarAssinatura(StringBuilder texto) {
		return texto
				    .append("Att.:")
			        .append(QUEBRA_DE_LINHA)
			        .append("Jorge Ferraz")
			        .append("<br>")
			        .append("CPQD - Diretoria de Produtos de Software")
			        .append("<br>")
			        .append("Cel.: +55 19 98388-4930")
			        .append("<br>")
			        .append("jferraz@cpqd.com.br")
			        .append("<br>")
			        .toString();
			        
					/*.append("Jorge Ferraz\r\n"
							+ "CPQD - Diretoria de Produtos de Software\r\n"
							+ "\r\n\n"
							+ "Cel.: +55 19 98388-4930\r\n"
							+ "\r\n"
							+ "jferraz@cpqd.com.br\r\n")
					        .toString();*/
		
	}

	private String gerarRodape(StringBuilder texto) {
		return texto.append(QUEBRA_DE_LINHA_DUPLA)
				    .append("E-mail automático. Favor não responder esse e-mail !").toString();
	}
	
}
