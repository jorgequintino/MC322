import java.util.regex.Pattern;
public class Jogador {
        private String name;
        private String cpf;
        private String foto;
        private String email;

    //Construtor
        public Jogador(String name, String cpf, String email, String foto){
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
    }

    // getters setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getCpf(){
        return cpf;
    }
    public void setCpf(String cpf){
        this.cpf = cpf ;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getFoto(){
        return foto;
    }
    public void setFoto(String foto){
        this.foto = foto;
    }

    public boolean validateEmail(String email){
        String regexPattern = "^(.+)@(\\S+)$";
        //if( string.indexof("@") <= 0 || )
        return Pattern.compile(regexPattern).matcher(email).matches();
    }
    private boolean equalchar(String word){
            for (int i = 0; i<word.length()-1; i++){
                if (word.charAt(i) != word.charAt(i+1)){
                    return false;
                }
            }
            return true;
    }

    private int calculatecpf(String cpf, int number, int firstdigit){
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
    private boolean verifynumber(String cpf){
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
    public boolean validateCpf(String cpf){
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

    @Override
    public String toString() {
        return "Jogador: {" +
                "Nome = " + name +
                ", CPF = '" + cpf + '\'' +
                ", CPF válido = " + validateCpf(cpf) +
                ", Foto = '" + foto + '\'' +
                ", Email = '" + email + '\'' +
                ", Email válido = " + validateEmail(email) +
                '}';
    }
}
