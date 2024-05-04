package construcoes;

import organizacao.Propriedade;
import usuarios.Jogador;

public class Estacao extends Propriedade {

    //Constructor.
    public Estacao(int ID, String description, Jogador player, String name, int price, float rent) {
        super(ID, description, player, name, price, rent);
    }

    /**
     * It returns the value calculated by the mother function.
     * @return float
     */
    public float calculaterent() {
        return super.calculaterent();
    }

    @Override
    public String toString() {
        return STR."Station:\n\{super.toString(0)}";
    }
}