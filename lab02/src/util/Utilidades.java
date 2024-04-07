package util;

import java.util.regex.Pattern;

public class Utilidades {
    /**
     * Se a string tiver '@', a função retorna true indicando ser um email válido. Do contrário, retorna false.
     * @param email String
     * @return boolean
     */
    public static boolean validateEmail(String email){
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }

    /**
     * Se a String tiver caracteres iguais, a função retorna false. Do contrário, retorna true.
     * @param word String
     * @return boolean
     */
    private static boolean equalchar(String word){
        for (int i = 0; i<word.length()-1; i++){
            if (word.charAt(i) != word.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    /**
     * Calcula os últimos digitos esperados do CPF. Primeiro transforma o caracter da String em numerico e efetua o cálculo.
     * Há regras específica para cada um dos dois últimos dígitos.
     * @param cpf String
     * @param number int
     * @param firstdigit int
     * @return int
     */
    private static int calculatecpf(String cpf, int number, int firstdigit){
        int j, value=0;
        if (number == 10){
            j = 2;
        }else{
            j = 1;
        }
        for(int i=0; i<cpf.length()-j;i++){
            if (i==9){
                value += firstdigit*(number-i);
            } else{
                int vcpfnumber = Character.getNumericValue(cpf.charAt(i));
                value += vcpfnumber*(number-i);
            }
        }
        if ((value % 11) < 2){
            return 0;
        } else{
            return 11 - (value % 11);
        }
    }

    /**
     * Esta função verifica se os digitos finais são os esperados pelo cálculo. Retorna true se compatível.
     * @param cpf String
     * @return boolean
     */
    private static boolean verifynumber(String cpf){
        //int vcpfnumber = Integer.parseInt(cpf);
        //primeiro digito

        int firstdigit = calculatecpf(cpf, 10, 0);
        int lastdigit = calculatecpf(cpf, 11, firstdigit);

        if (firstdigit == Character.getNumericValue(cpf.charAt(9))){
            return lastdigit == Character.getNumericValue(cpf.charAt(10));
        }else{
            return false;
        }
    }

    /**
     * Organiza os procedimentos para validação do cpf. Primeiro removendo os carcteres não númericos e checando possíveis falhas.
     * @param cpf String
     * @return boolean
     */
    public static boolean validateCpf(String cpf){
        cpf = cpf.replaceAll("[.-]", "");

        if (cpf.length() == 11) {
            //todos iguais
            if (equalchar(cpf)){
                return false;
            } else{
                //digitos verificadores
                return verifynumber(cpf);
            }
        } else {
            return false;
        }
    }

    /**
     * Retorna ums string correspondente à validade do cpf.
     * @return String
     */
    public static String cpfvalidity(String cpf){
        if (validateCpf(cpf)){
            return "[válido]";
        } else{
            return "[inválido]";
        }
    }

    /**
     * Retorna uma String correspondente à validade do email.
     * @return String
     */
    public static String emailvalidity(String email){
        if (validateEmail(email)){
            return "[válido]";
        } else{
            return "[inválido]";
        }
    }
}
