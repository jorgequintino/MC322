package construcoes;

public class ServicoPublico extends Propriedade {

    // Construtor
    public ServicoPublico(int ID, String name, String owner, String price, float rent) {
        super(ID, name, owner, price, rent);
    }

    /**
     * It returns the value calculated by the mother function multiplies by a constant.
     * @param dados int
     * @return boolean
     */
    public float calculaterent(int dados) {
        return super.calculaterent() * dados;
    }
}