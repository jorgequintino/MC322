package construcoes;

import organizacao.Propriedade;
import usuarios.Jogador;

public class Estacao extends Propriedade {
    private int tax;

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    //Constructor.
    public Estacao(int ID, String description, Jogador player, String name, int price, float rent, int tax) {
        super(ID, description, player, name, price, rent);
        setTax(tax);
    }

    /**
     * It returns the value calculated by the mother function.
     * @return float
     */
    public float calculaterent() {
        return super.calculaterent() * getTax();
    }

    @Override
    public String toString() {
        return STR."\n\nStation:\n\{super.toString(0)}";
    }
}