package organizacao;

public enum TipoCarta {
    SORTE(1),
    REVES(-1);

    public final int model;

    TipoCarta(int values) {
        this.model = values;
    }

    public int getvalues(){
        return model;
    }
}
