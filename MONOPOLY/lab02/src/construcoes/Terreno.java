package construcoes;

public class Terreno {
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

    public Terreno(int housesnumber, int housevalue, int hotelnumber, int hotelvalue) {
        Housesnumber = housesnumber;
        Housevalue = housevalue;
        Hotelnumber = hotelnumber;
        Hotelvalue = hotelvalue;
    }

    @Override
    public String toString() {
        return STR."construções.Terreno{Housesnumber=\{Housesnumber}, Housevalue=\{Housevalue}, Hotelnumber=\{Hotelnumber}, Hotelvalue=\{Hotelvalue}\{'}'}";
    }
}