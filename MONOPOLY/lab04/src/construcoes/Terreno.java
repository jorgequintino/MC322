package construcoes;

import organizacao.Propriedade;
import usuarios.Jogador;

public class Terreno extends Propriedade {
    private int Housesnumber;
    private int Housevalue;
    private int Hotelnumber;
    private int Hotelvalue;

    //Constructor
    public Terreno(int ID, String description, Jogador player, String name, int price, float rent, int housesnumber, int housevalue, int hotelnumber, int hotelvalue) {
        super(ID, description, player, name, price, rent);
        Housesnumber = housesnumber;
        Housevalue = housevalue;
        Hotelnumber = hotelnumber;
        Hotelvalue = hotelvalue;
    }

    //Getters and Setters
    public int getHousesnumber() {
        return Housesnumber;
    }
    public void setHousesnumber(int housesnumber) {
        Housesnumber += housesnumber;
    }
    public int getHousevalue() {
        return Housevalue;
    }
    public void setHousevalue(int housevalue) {
        Housevalue = housevalue;
    }
    public int getHotelnumber() {
        return Hotelnumber;
    }
    public void setHotelnumber(int hotelnumber) {
        Hotelnumber += hotelnumber;
    }
    public int getHotelvalue() {
        return Hotelvalue;
    }
    public void setHotelvalue(int hotelvalue) {
        Hotelvalue = hotelvalue;
    }

    /**
     * It returns the value of rent calculated by the mother function plus constants according to hotels and houses on the land.
     * @return boolean
     */
    public float calculaterent() {
        return super.calculaterent() + (Housesnumber * Housevalue) + (Hotelnumber * Hotelvalue);
    }

    @Override
    public String toString() {
        return "\n\nLand:\n" + super.toString(0) + STR."\nHouses Numbers = \{Housesnumber} \nHouses Values = R$\{Housevalue} \nHotel Numbers = \{Hotelnumber} \nHotel values = R$\{Hotelvalue}";
    }
}