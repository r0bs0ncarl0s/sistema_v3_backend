package br.com.teste.projeto.service;

import java.util.InputMismatchException;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

@Service
public class UtilsService {

	private static final String REGRA_EMAIL = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

	public static boolean isEmail(String email) {
		try {
			if(email!=null && !email.equals("")) {
				String[] auxEmail = email.split("\"");
				if(auxEmail!=null && auxEmail.length==5 && auxEmail[3]!=null && !auxEmail[3].trim().equals("")) {
					return Pattern.compile(REGRA_EMAIL).matcher(auxEmail[3].trim()).matches();
				}
			}
		} catch (Exception e) {
			System.out.println("Email inválido!");
			e.printStackTrace();
		}
		return false;
	}

	public static boolean isCPF(String CPF) {
		if(CPF!=null && !CPF.equals("")) {
			String[] auxCpf = CPF.split("\"");
			if(auxCpf!=null && auxCpf[3]!=null && !auxCpf[3].trim().equals("")) {
				CPF = auxCpf[3].trim();
			}else {
				return false;
			}
		}	
		// considera-se erro CPF's formados por uma sequencia de numeros iguais
		if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
				|| CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
				|| CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
				|| CPF.equals("99999999999") || (CPF.length() != 11))
			return (false);

		char dig10, dig11;
		int sm, i, r, num, peso;

		// "try" - protege o codigo para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 10;
			for (i = 0; i < 9; i++) {
				// converte o i-esimo caractere do CPF em um numero:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posicao de '0' na tabela ASCII)
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig10 = '0';
			else
				dig10 = (char) (r + 48); // converte no respectivo caractere numerico

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 11;
			for (i = 0; i < 10; i++) {
				num = (int) (CPF.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso - 1;
			}

			r = 11 - (sm % 11);
			if ((r == 10) || (r == 11))
				dig11 = '0';
			else
				dig11 = (char) (r + 48);

			// Verifica se os digitos calculados conferem com os digitos informados.
			if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}

	public static boolean isCNPJ(String CNPJ) {
		if(CNPJ!=null && !CNPJ.equals("")) {
			String[] auxCnpj = CNPJ.split("\"");
			if(auxCnpj!=null && auxCnpj[3]!=null && !auxCnpj[3].trim().equals("")) {
				CNPJ = auxCnpj[3].trim();
			}else {
				return false;
			}
		}
		// considera-se erro CNPJ's formados por uma sequencia de numeros iguais
		if (CNPJ.equals("00000000000000") || CNPJ.equals("11111111111111") || CNPJ.equals("22222222222222")
				|| CNPJ.equals("33333333333333") || CNPJ.equals("44444444444444") || CNPJ.equals("55555555555555")
				|| CNPJ.equals("66666666666666") || CNPJ.equals("77777777777777") || CNPJ.equals("88888888888888")
				|| CNPJ.equals("99999999999999") || (CNPJ.length() != 14))
			return (false);

		char dig13, dig14;
		int sm, i, r, num, peso;

		// "try" - protege o código para eventuais erros de conversao de tipo (int)
		try {
			// Calculo do 1o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 11; i >= 0; i--) {
				// converte o i-ésimo caractere do CNPJ em um número:
				// por exemplo, transforma o caractere '0' no inteiro 0
				// (48 eh a posição de '0' na tabela ASCII)
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig13 = '0';
			else
				dig13 = (char) ((11 - r) + 48);

			// Calculo do 2o. Digito Verificador
			sm = 0;
			peso = 2;
			for (i = 12; i >= 0; i--) {
				num = (int) (CNPJ.charAt(i) - 48);
				sm = sm + (num * peso);
				peso = peso + 1;
				if (peso == 10)
					peso = 2;
			}

			r = sm % 11;
			if ((r == 0) || (r == 1))
				dig14 = '0';
			else
				dig14 = (char) ((11 - r) + 48);

			// Verifica se os dígitos calculados conferem com os dígitos informados.
			if ((dig13 == CNPJ.charAt(12)) && (dig14 == CNPJ.charAt(13)))
				return (true);
			else
				return (false);
		} catch (InputMismatchException erro) {
			return (false);
		}
	}
	
	public static boolean isNIP(String valor) {
		if(valor!=null && !valor.equals("")) {
			String[] auxNip = valor.split("\"");
			if(auxNip!=null && auxNip[3]!=null && !auxNip[3].trim().equals("")) {
				valor = auxNip[3].trim();
			}else {
				return false;
			}
		}
		if (valor == null) {
			return false;
		}
		String nip = String.valueOf(valor).replace("-", "").replace("_", "").replace(".", "").trim();
		boolean resultado = false;
		int iCalculoDV;
		String cDV;
		if (nip.length() == 0 || nip.length() != 8 || nip.indexOf('.') == 0) {
			return resultado;
		} else {
			iCalculoDV = (11 - (((new Integer(nip.substring(0, 1))) * 8)
					+ new Integer(nip.substring(1, 2)) * 7
					+ new Integer(nip.substring(2, 3)) * 6
					+ new Integer(nip.substring(3, 4)) * 5
					+ new Integer(nip.substring(4, 5)) * 4
					+ new Integer(nip.substring(5, 6)) * 3 + new Integer(
							nip.substring(6, 7)) * 2) % 11);
			if (iCalculoDV == 11) {
				cDV = "1";
			} else {
				if (iCalculoDV == 10) {
					cDV = "0";
				} else {
					cDV = Integer.toString(iCalculoDV);
				}
			}
			resultado = cDV.equals(nip.substring(7, 8));
		}
		return resultado;
	}

}
