package construcoes;

import organizacao.Propriedade;
import usuarios.Jogador;

public class ServicoPublico extends Propriedade {

    //Constructor
    public ServicoPublico(int ID, String description, Jogador player, String name, int price, float rent) {
        super(ID, description, player, name, price, rent);
    }

    /**
     * It returns the value calculated by the mother function multiplies by a constant.
     * @param data int
     * @return boolean
     */
    public float calculaterent(int data) {
        return super.calculaterent() * data;
    }

    @Override
    public String toString() {
        return STR."Public Service:\n\{super.toString(this.calculaterent(this.getId()))}";
    }
}