package organizacao;

import usuarios.Jogador;

public class CartaSorte extends Carta{
    private int moviment;
    private int effect;
    private float value;
    private String action;
    private int period;
    private String restriction;

    //Constructor
    public CartaSorte(int id, String description, Jogador player, int moviment, int effect, float value, String action, int period, String restriction){
        super(id, description, player);
        this.moviment = moviment;
        this.effect = effect;
        this.value = value;
        this.action = action;
        this.period = period;
        this.restriction = restriction;
    }

    //Getters and Setters
    public int getMoviment(){
            return moviment;
    }
    public int getEffect(){
            return effect;
    }
    public float getValue(){
            return value;
    }
    public String getAction(){
            return action;
    }
    public int getPeriod(){
            return period;
    }
    public String getRestriction(){
            return restriction;
    }
    public void setMoviment(int moviment){
            this.moviment = moviment;
    }
    public void setEffect(int effect){
            this.effect = effect;
    }
    public void setValue(float value){
            this.value = value;
    }
    public void setAction(String action){
            this.action = action;
    }
    public void setPeriod(int period){
            this.period = period;
    }
    public void setRestriction(String restriction){
            this.restriction = restriction;
    }

    @Override
    public String toString() {
        return "Carta Sorte:\n" + super.toString() + STR."\nMoviment = \{moviment} clockwise squares\nEffect = +\{effect}\nValue = R$\{value}\nAction = \{action}\nPeriod = \{period} rounds\nRestriction = \{restriction}";
    }
}
