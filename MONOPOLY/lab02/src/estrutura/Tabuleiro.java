package estrutura;

import java.util.List;

public class Tabuleiro {
    private List<int> players;
    private List<int> properties;

    public List<int> getPlayers() {
        return players;
    }

    public List<int> getProperties() {
        return properties;
    }

    public void setPlayers(List<int> players) {
        this.players = players;
    }

    public void setProperties(List<int> properties) {
        this.properties = properties;
    }

    public Tabuleiro(List<int> players, List<int> proprerties) {
        this.players = players;
        this.properties = proprerties;
    }

    @Override
    public String toString() {
        return STR."estrutura.Tabuleiro{players=\{players}, proprerties=\{properties}\{'}'}";
    }

    public boolean addPlayer(int id){
        return this.players.add(id);
    }

    public boolean removePlayer(int id){
        return this.players.remove(id);
    }

    public boolean addProperty(int id){
        return this.properties.add(id);
    }

    public boolean removeProperty(int id){
        return
    }
}