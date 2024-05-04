package organizacao;

import construcoes.ServicoPublico;
import usuarios.Jogador;

public class Propriedade extends Carta {
    private String name;
    private int price;
    private float rent;

    //Constructor
    public Propriedade(int ID, String description, Jogador owner, String name, int price, float rent) {
        super(ID, description, owner);
        this.name = name;
        this.price = price;
        this.rent = rent;
    }

    //Getters and Setters
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public float getRent() {
        return rent;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public void setRent(float rent) {
        this.rent = rent;
    }

    /**
     * It returns the value of rent.
     * @return boolean
     */
    public float calculaterent(){
        return rent;
    }


    public String toString(float extra) {
        return super.toString() + STR."\nName = \{name}\nPrice = \{price}\nRent = R$\{(extra>0)? extra: calculaterent()}";
    }

}