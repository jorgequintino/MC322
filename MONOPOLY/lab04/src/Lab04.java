import auxilio.Setar;
import construcoes.Terreno;
import estrutura.Salvavel;
import estrutura.Tabuleiro;
import auxilio.Jogo;
import organizacao.Carta;
import organizacao.CartaSorte;

import java.io.IOException;
import java.util.ArrayList;

public class Lab04 {
    public static void main(String[] args) throws IOException {
        Jogo game = new Jogo();
        game.online();
        Tabuleiro board = Tabuleiro.create();
        board.setPlayers(Setar.settingplayers(game));

        if(game.gameon){
            ArrayList<Carta> stackOfCards = Setar.settingstackcards();
            //Game set.
            System.out.println("******************************************************************\n\nThis is Monopoly MC322's Version board and cards:");
            System.out.println(board);
            Salvavel.savewritelog("******************************************************************\n\nThis is Monopoly MC322's Version board and cards:");
            Salvavel.savewritelog(board.toString());

            for (Carta stackOfCard : stackOfCards) {
                //System.out.println("\n");
                System.out.println(stackOfCard);
                Salvavel.savewritelog(stackOfCard.toString());

            }
            Salvavel.savewritelog("******************************************************************\n\nFinal state of players? HERE\n\n--------------------------------------------------------");

            System.out.println("\n\nLet me just give y'all some properties.");
            board.givecards();
            System.out.println("\nAlright, do you wanna build a snowman?\nJust kidding, but for real, do you wanna check our players?\n");

            for(int i=0; i< (board.getPlayers()).size();i++){
                System.out.println("*************************************************\n");
                if(i!=0){
                    System.out.println("######\nNext one, please...\n#####\n");
                }
                System.out.println(STR."Initial state of \{(board.getPlayers()).get(i)}");
                //Buy a property.
                ((board.getPlayers()).get(i).getBoardpiece()).setPosition((i+13)%20);
                System.out.println(STR."Look at that, you just rolled the dices and landed on the property: \{((board.getProperties()).get((i+13)%20)).getName()}.\nLet's try to buy it!");
                if((board.getPlayers()).get(i).buyProperty((board.getProperties()).get((i+13)%20))){
                    System.out.println("Congrats! You just bought a piece of land.");
                    //Build a house.
                    if (((board.getProperties()).get((i+13)%20)) instanceof Terreno){
                        System.out.println("Would you like to start building?");
                        if((board.getPlayers()).get(i).buildHouse((board.getProperties()).get((i+13)%20))){
                            System.out.println("Congrats! You just built a house on your land.");
                        }
                        //Build a hotel.
                        if((board.getPlayers()).get(i).buildHotel((board.getProperties()).get((i+13)%20))){
                            System.out.println("Congrats! You just built a hotel on your land.");
                        }
                    }

                }else{
                    System.out.println("I'm sorry, it wasn't possible to buy it. Maybe next time!");
                }

                //Take a card.
                System.out.println("Maybe you're feeling lucky today? What about to try it out on our stack of cards?\n");
                (stackOfCards.get((i+2)%10)).setOwner((board.getPlayers()).get(i));
                ((board.getPlayers()).get(i).getCards()).add(stackOfCards.get((i+2)%10));
                ((CartaSorte)stackOfCards.get((i+2)%10)).execution();
                if( ((CartaSorte)(stackOfCards.get((i+2)%10))).getMoviment() > 0 ){
                    //If it's a movement card, move.
                    int extra = ((CartaSorte)(stackOfCards.get((i+2)%10))).getMoviment();
                    ((board.getPlayers()).get(i).getBoardpiece()).setPosition(((i+13)%20)+extra);
                }

                System.out.println(STR."Final state of \{(board.getPlayers()).get(i)}");
                Salvavel.savewritelog(STR."\{((board.getPlayers()).get(i)).toString()}\n--------------------------------------------------------");
            }
            System.out.println("\nI guess that's it for now.\nLet me just...");
            game.offline("HUMANS");
        }
        Salvavel.savewritelog("oh, no. I'm to be dismantled. I guess this is goodbye!");
        board.salvalog();
    }
}