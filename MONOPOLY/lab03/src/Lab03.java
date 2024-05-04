import auxilio.Setar;
import estrutura.Tabuleiro;
import auxilio.Jogo;
import organizacao.Carta;
import organizacao.CartaSorte;

import java.util.ArrayList;

public class Lab03 {
    public static void main(String[] args) {
        Jogo game = new Jogo();
        game.online();
        Tabuleiro board = Tabuleiro.create();
        board.setPlayers(Setar.settingplayers(game));
        if(game.gameon){
            ArrayList<Carta> stackOfCards = Setar.settingstackcards();
            //Game set.
            System.out.println("This is Monopoly MC322's Version board:\n\n");
            System.out.println(board);
            System.out.println("And this is our stack of cards:");
            for (Carta stackOfCard : stackOfCards) {
                System.out.println("\n");
                System.out.println(stackOfCard);
            }
            System.out.println("\nDo you wanna build a snowman?\nJust kidding, but for real, do you wanna check our players?\n");
            for(int i=0; i< (board.getPlayers()).size();i++){
                if(i!=0){
                    System.out.println("Next one, please...\n");
                }
                System.out.println((board.getPlayers()).get(i));
                //Buy a property.
                ((board.getPlayers()).get(i).getBoardpiece()).setPosition((i+13)%20);
                System.out.println(STR."Look at that, you just rolled the dices and landed on the property: \{((board.getProperties()).get((i+13)%20)).getName()}.\nLet's try to buy it!");
                if((board.getPlayers()).get(i).buyProperty((board.getProperties()).get((i+13)%20))){
                    System.out.println("Congrats! You just bought a piece of land.");
                    //Build a house.
                    if((board.getPlayers()).get(i).buildHouse((board.getProperties()).get((i+13)%20))){
                        System.out.println("Congrats! You just built a house on your land.");
                    }
                    //Build a hotel.
                    if((board.getPlayers()).get(i).buildHotel((board.getProperties()).get((i+13)%20))){
                        System.out.println("Congrats! You just built a hotel on your land.");
                    }
                }else{
                    System.out.println("I'm sorry, it wasn't possible to buy it. Maybe next time!");
                }

                //Take a card.
                System.out.println("Maybe you're feeling lucky today? What about to try it out on our stack of cards?\n");
                (stackOfCards.get((i+2)%10)).setOwner((board.getPlayers()).get(i));
                ((board.getPlayers()).get(i).getCards()).add(stackOfCards.get((i+2)%10));
                if( ((CartaSorte)(stackOfCards.get((i+2)%10))).getMoviment() > 0 ){
                    //If it's a movement card, move.
                    int extra = ((CartaSorte)(stackOfCards.get((i+2)%10))).getMoviment();
                    ((board.getPlayers()).get(i).getBoardpiece()).setPosition(((i+13)%20)+extra);
                }

                System.out.println((board.getPlayers()).get(i));
            }
            System.out.println("\nI guess that's it for now.\nLet me just...");
            game.offline("HUMANS");
        }
    }
}