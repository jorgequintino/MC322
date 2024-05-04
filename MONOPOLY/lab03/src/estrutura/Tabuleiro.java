package estrutura;

import auxilio.Setar;
import construcoes.Estacao;
import construcoes.ServicoPublico;
import construcoes.Terreno;
import organizacao.Propriedade;
import usuarios.Jogador;

import java.util.ArrayList;

public class Tabuleiro implements Setar {
    private ArrayList<Jogador> players;
    private ArrayList<Propriedade> properties;

    //Constructor
    public Tabuleiro(ArrayList<Propriedade> properties, ArrayList<Jogador> playerids) {
        this.players = playerids;
        this.properties = properties;
    }

    //Getters and Setters
    public ArrayList<Jogador> getPlayers() {
        return players;
    }
    public ArrayList<Propriedade> getProperties() {
        return properties;
    }
    public void setPlayers(ArrayList<Jogador> players) {
        this.players = players;
    }
    public void setProperties(ArrayList<Propriedade> properties) {
        this.properties = properties;
    }
    public boolean addPlayer(Jogador player){
        return this.players.add(player);
    }
    public boolean removePlayer(Jogador player){
        return this.players.remove(player);
    }
    public boolean addProperty(Propriedade property) {
        return this.properties.add(property);
    }
    public boolean removeProperty(Propriedade property){
        return this.properties.remove(property);
    }

    /**
     *
     * This public static function creates the board.
     * @return board Tabuleiro
     */
    public static Tabuleiro create() {
        Tabuleiro board = new Tabuleiro(null, null);
        return new Tabuleiro(board.setting(), null);
    }

    /**
     *
     * This public function sets the board properties and returns an Array List containing them.
     * @return properties ArrayList<Propriedade>
     */
    @Override
    public ArrayList<Propriedade> setting() {
        ArrayList<Propriedade> properties = new ArrayList<>();
        properties.add(new Estacao(0, "This is a free zone. None is gonna bother you here.", null, "Parking Station", -1, 0));
        properties.add(new Terreno(1, "This a nature loving zone which means it comes with a cost to be eco friendly.", null, "Environmental Park", 300, 100, 0, 20, 0, 40));
        properties.add(new ServicoPublico(2, "Oh, you're where the mayor makes his public events. Better help your city, don't you think?", null, "Public Events Square", 200, 150));
        properties.add(new Terreno(3, "Zefinha", null, "Zefinha", 350, 200, 0, 50, 0, 80));
        properties.add(new Terreno(4, "Welcome to where all the fun in town is. We can skate, run a marathon or just on grass.", null, "Playground", 400, 100, 0, 30, 0, 50));
        properties.add(new Estacao(5, "The bus station is where all the fun, for the crackheads or ambitious people at least. Buckle up because the price of fun is high!", null, "Bus Station", -1, 500));
        properties.add(new Terreno(6, "Did you really think it was gonna be this easy to leave town? Your ticket just got high, just like these crackheads.", null, "Land Outside Bus Station", 200, 600, 0, 200, 0, 350));
        properties.add(new Terreno(7, "The one private company keeping the town. Keep in mind we're talking about the WHOLE TOWN!",null, "Protected am to pm", 550, 350, 0, 75, 0, 200));
        properties.add(new Terreno(8, "Welcome to the jungle! No, this is not just a Guns N' roses song.", null, "Abandoned Land near the Swimming Club", 100, 50, 0, 250, 0, 400));
        properties.add(new Terreno(9, "What are a fresh dip into water? Pay attention to fungus, tho.", null, "Swimming Club", 375, 200, 0, 50, 0, 70));
        properties.add(new Estacao(10, "Watch you criminals [Rivals to the wealthiest family in town]!", null, "Police Station", -1,250));
        properties.add(new Terreno(11, "I bet it's nothing much. Here, spend R$ 1000 with us!", null, "Drug Store", 400, 300, 0, 90, 0, 115));
        properties.add(new Terreno(12, "Watch out for the day light robbery!", null, "Grocery Store", 900, 700, 0, 550, 0, 800));
        properties.add(new Terreno(13, "We've been waiting on you. It's to to buy some bad clothes labeled fashion", null, "Department Store", 600, 500, 0, 400, 0, 475));
        properties.add(new ServicoPublico(14, "Oh, you're sick? I'm so sorry, blame the Mayor. Anyway, there's a lot of people ahead of you. Gotta wait [or make it private].", null, "Intensive Public Health Care", 10000, 150));
        properties.add(new Estacao(15, "News Adonai TV Station where all your politics are built. You can't scape us!", null, "Adonai TV Station", 800, 1000));
        properties.add(new Terreno(16, "This is where the first house of the town was built. Better pay your respects. We'll take it in money, please.", null, "Land of the first house in town", 300, 100, 0, 25, 0, 50));
        properties.add(new Terreno(17, "Oh, you've reached the main hotel in town. Keep on the line and we'll talk to you in a minute [or not]", null, "Main Hotel", 350, 250, 0, 50, 0 ,200));
        properties.add(new Terreno(18, "Welcome to the horrors house! WE ARE EVERYWHERE!", null, "Horrors House", 250, 200, 0, 25, 0, 50));
        properties.add(new Terreno(19, "Santa Claus House is always up and running, no matter if summer or winter.", null, "Santa Claus House", 150, 50, 0, 10, 0, 25));
        return properties;
    }

    @Override
    public String toString() {
        for(int i=0;i<this.getProperties().size();i++){
            System.out.println(this.getProperties().get(i));
            System.out.println("\n");
        }
        return "Board updated.";
    }
}