package organizacao;

import usuarios.Jogador;

public class Carta{
    private int id;
    private String description;
    private Jogador owner;

    //Constructor
    public Carta(int id, String descricao, Jogador player) {
        this.id = id;
        this.description = descricao;
        this.owner = player;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Jogador getOwner() {
        return owner;
    }
    public void setOwner(Jogador owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return STR."ID = \{id}\nDescription = \{description}\nOwner = \{(owner == null) ? "No owner" : owner.getName()}";
    }
}
