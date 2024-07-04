package construcoes;

import organizacao.Propriedade;
import usuarios.Jogador;

public class ServicoPublico extends Propriedade {
    private int multiplier ;

    public int getMultiplier() {
        return multiplier;
    }

    public void setMultiplier(int multiplier) {
        this.multiplier = multiplier;
    }

    //Constructor
    public ServicoPublico(int ID, String description, Jogador player, String name, int price, float rent, int multiplier) {
        super(ID, description, player, name, price, rent);
        this.multiplier = multiplier;
    }

    /**
     * It returns the value calculated by the mother function multiplies by a constant.
     * @return boolean
     */
    public float calculaterent() {
        return super.calculaterent() * this.multiplier;
    }

    @Override
    public String toString() {
        return STR."Public Service:\n\{super.toString(this.calculaterent())}";
    }
}