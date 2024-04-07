package estrutura;

import java.util.ArrayList;
import java.util.List;

public class Tabuleiro {
    private ArrayList<Integer> players;
    private ArrayList<Integer> properties;

    // Construtor
    public Tabuleiro(ArrayList<Integer> properties, ArrayList<Integer> playerids) {
        this.players = playerids;
        this.properties = properties;
    }

    public ArrayList<Integer> getPlayers() {
        return players;
    }

    public ArrayList<Integer> getProperties() {
        return properties;
    }

    public void setPlayers(ArrayList<Integer> players) {
        this.players = players;
    }

    public void setProperties(ArrayList<Integer> properties) {
        this.properties = properties;
    }


    public boolean addPlayer(int id){
        return this.players.add(id);
    }

    public Integer removePlayer(int id){
        return this.players.remove(id);
    }

    public boolean addProperty(int id){
        return this.properties.add(id);
    }

    public Integer removeProperty(int id){
        return this.properties.remove(id);
    }

    public String toString() {
        return STR."estrutura.Tabuleiro{players=\{players}, proprerties=\{properties}\{'}'}";
    }
}