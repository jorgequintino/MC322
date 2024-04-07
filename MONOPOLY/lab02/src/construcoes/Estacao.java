package construcoes;

public class Estacao extends Propriedade {

    //Construtor.
    public Estacao(int ID, String name, String owner, String price, float rent) {
        super(ID, name, owner, price, rent);
    }

    /**
     * It returns the value calculated by the mother function.
     * @param "NULL"
     * @return float
     */
    public float calculaterent() {
        return super.calculaterent();
    }

}