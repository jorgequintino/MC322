package modelo;

public class Jogador {
    private int id;
    static int count=0;
    private String name;
    private String cpf;
    private String foto;
    private String email;
    private int money;

    //Construtor
    public Jogador(String name, String cpf, String email, String foto){
        this.id = count;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
        this.money = 10000;
        count +=1;
    }

    // getters and setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
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
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }


    @Override
    public String toString() {
        return STR."Jogador: {\nID = \{this.id}\nNome = \{this.name}\nCPF = \{this.cpf} \nFoto = \{this.foto}\nEmail = \{this.email} \n";
    }
}
