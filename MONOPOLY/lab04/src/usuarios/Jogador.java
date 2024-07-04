package usuarios;

import construcoes.Terreno;
import organizacao.Carta;
import organizacao.Propriedade;

import java.util.ArrayList;

public class Jogador {
    private int id;
    static int count=0;
    private int money;
    private String name;
    private String cpf;
    private String foto;
    private String email;
    private ArrayList<Carta> cards;
    private Peca boardpiece;

    //Constructor
    public Jogador(String name, String cpf, String email, String foto, ArrayList<Carta> cards, Peca boardpiece){
        this.id = count;
        this.name = name;
        this.cpf = cpf;
        this.email = email;
        this.foto = foto;
        this.money = 15000;
        this.cards = cards;
        this.boardpiece = boardpiece;
        count +=1;
    }

    //Getters and Setters
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
    public ArrayList<Carta> getCards() {
        return cards;
    }
    public Peca getBoardpiece() {
        return boardpiece;
    }
    public void setCards(ArrayList<Carta> cards) {
        this.cards = cards;
    }
    public void setBoardpiece(Peca boardpiece) {
        this.boardpiece = boardpiece;
    }

    /**
     *
     * This one buys a property. It also sets the details confirming its buying.
     * @param property Propriedade
     * @return boolean
     */
    public boolean buyProperty(Propriedade property){
        if(property.getPrice()>0){
            if(this.money < property.getPrice()){
                try{
                    throw new Exception();
                } catch(Exception exception){
                    System.out.println("Oh, looks like you don't have money.");
                    return false;
                }
            } else if((property.getOwner() != null)){
                try{
                    throw new Exception();
                } catch(Exception exception){
                    System.out.println("Oh, looks like it already has a owner.");
                    return false;
                }
            } else {
                this.money -= property.getPrice();
                (this.getCards()).add(property);
                property.setOwner(this);
                return true;
            }
        } else{
            return false;
        }
    }

    /**
     *
     * This one builds a house on a property. It also sets the hotel number on it.
     * @param property Propriedade
     * @return boolean
     */
    public boolean buildHouse(Propriedade property){
        if(property instanceof Terreno){
            if(this.money< 0){
                try{
                    throw new Exception();
                } catch(Exception exception){
                    System.out.println("Oh, looks like you don't have money.");
                    return false;
                }
            }else{
                ((Terreno) property).setHousesnumber(1);
                return true;
            }
        }else{
            return false;
        }
    }

    /**
     *
     * This one builds a hotel on a property. It also sets the hotel number on it.
     * @param property Propriedade
     * @return boolean
     */
    public boolean buildHotel(Propriedade property){
        if(property instanceof Terreno){
            if(this.money< 0){
                try{
                    throw new Exception();
                } catch(Exception exception){
                    System.out.println("Oh, looks like you don't have money.");
                    return false;
                    }
                }else{
                    ((Terreno) property).setHotelnumber(1);
                    return true;
                }

        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        StringBuilder card = new StringBuilder("\n");
        for (Carta carta : this.cards) {
            card.append("\n");
            card.append(carta.toString());
            card.append("\n");
        }
        return STR."Jogador \{id+1}:\nName = \{name}\nWallet = R$\{money}\nCPF = \{cpf}\nPhoto = \{foto}\nEmail = \{email}\nCards = \{(cards.isEmpty()) ? "{}" : card}\n" + STR."Boardpiece = \t{\{boardpiece.toString()}}\n";
    }
}
