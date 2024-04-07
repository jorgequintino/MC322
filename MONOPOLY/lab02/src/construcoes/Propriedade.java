package construcoes;

public class Propriedade{
    private int id;
    private String name;
    private String owner;
    private String price;
    private float rent;

    public String getOwner() {
        return owner;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public float getRent() {
        return rent;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setRent(float rent) {
        this.rent = rent;
    }

    //Construtor
    public Propriedade(int ID, String name, String owner, String price, float rent) {
        this.id = ID;
        this.name = name;
        this.owner = owner;
        this.price = price;
        this.rent = rent;
    }

    @Override
    public String toString() {
        return STR."Propriedade: {\nID = \{id} \nName = '\{name}\{'\''} \nOwner = '\{owner}\{'\''} \nPrice = '\{price}\{'\''} \nRent = R$\{rent} reais\{'}'}";
    }

    /**
     * It returns the value of rent.
     * @param
     * @return boolean
     */
    public float calculaterent(){
        return rent;
    }

}