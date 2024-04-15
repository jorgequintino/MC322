package construcoes;

public class Terreno extends Propriedade{
    private int Housesnumber;
    private int Housevalue;
    private int Hotelnumber;
    private int Hotelvalue;

    public int getHousesnumber() {
        return Housesnumber;
    }

    public void setHousesnumber(int housesnumber) {
        Housesnumber = housesnumber;
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
        Hotelnumber = hotelnumber;
    }

    public int getHotelvalue() {
        return Hotelvalue;
    }

    public void setHotelvalue(int hotelvalue) {
        Hotelvalue = hotelvalue;
    }

    // Construtor
    public Terreno(int ID, String name, String owner, String price, float rent, int housesnumber, int housevalue, int hotelnumber, int hotelvalue) {
        super(ID, name, owner, price, rent);
        Housesnumber = housesnumber;
        Housevalue = housevalue;
        Hotelnumber = hotelnumber;
        Hotelvalue = hotelvalue;
    }

    /**
     * It returns the value of rent calculated by the mother function plus constants according to hotels and houses on the land.
     * @param
     * @return boolean
     */
    public float calculaterent() {
        return super.calculaterent() + (Housesnumber * Housevalue) + (Hotelnumber * Hotelvalue);
    }

    @Override
    public String toString() {
        return String.format(super.toString() + STR."\nBONUS:" +STR."\nHouses Numbers = \{Housesnumber} \nHouses Values = \{Housevalue} \nHotel Numbers = \{Hotelnumber} \nHotel values = \{Hotelvalue}\{'}'}");
    }

}