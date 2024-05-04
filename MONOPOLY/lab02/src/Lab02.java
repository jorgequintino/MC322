import construcoes.Estacao;
import construcoes.Propriedade;
import construcoes.ServicoPublico;
import construcoes.Terreno;
import estrutura.Tabuleiro;
import modelo.CartaSorte;
import modelo.Jogador;
import modelo.Peca;
import util.Utilidades;
import java.util.ArrayList;
import java.util.Scanner;

import static java.lang.StringTemplate.STR;

public class Lab02 {
    public static void main(String[] args) {

        // Criando cartas.
        CartaSorte[] cards = new CartaSorte[3];
        cards[0] = new CartaSorte(0, "Zefinha Night Out", 3, 100, 1500.26F,
                "You just got rid off a stabbing. Congrats! Move three more places.", 24,
                "It can only be used if you're at least one place after Zefinha Bar.");
        cards[1] = new CartaSorte(1, "City Square Night Figure", 1, 100, 100.00f,
                "You've just been attacked by the crazy guy in the dark night. Pay this value to each player.", 1,
                "It's only valid if you're on city square");
        cards[2] = new CartaSorte(2, "Walking Lane", 0, 100, 0.00f,
                "I'm sorry to hear the doctor told to exercise. You gotta run now, which means you're not playing for a round",
                24, "Since you're exercising, none has to pay you rent this round.");;

        // Criando peças.
        Peca[] boardpieces = new Peca[3];
        boardpieces[0] = new Peca("Red", 1);
        boardpieces[1] = new Peca("White", 2);
        boardpieces[2] = new Peca("Blue", 3);

        // Criando Propriedades.

        // Criando estação.
            Estacao station = new Estacao(0, "New Adonai TV Station", "Mayor Yave",
                    "Two thousand dollars", 20.00f);
        // Criando terreno.
            Terreno land = new Terreno(1, "Abandoned Land near the Swinning Club",
                    "Up to sale", "Ten dollars", 1.00f, 10, 1, 1, 100);
        // Criando Serviço Público.
            ServicoPublico service = new ServicoPublico(2, "Intensive Health Care", "State", "It can't be bought.", 10000.00f);

        // Jogo.
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Monoply MC322's version!\n" +
                "This Especial Edition will honour its programmer hometown," +
                "which means you player(s) have lots of surprises ahead.\nBuckle up!\n" +
                "But first, let us know how many players there will be with us for this match:");
        int playersamount = input.nextInt();
        if (playersamount > 0) {
            System.out.println("Great to have y'all here! Let us know a bit more about you guys, is that ok? Yes- 1 No -0");
            int ok = input.nextInt();
            if (ok == 1) {
                Jogador[] players = new Jogador[3];
                System.out.println(STR."We have someone to play with at last. It's a bit lonely here on the other side...\n" +
                        "Have in mind we can only play with 3 players top. I like to give my best.");
                for (int i = 0; i < playersamount; i++) {
                    String number = Integer.toString(i+1);
                    System.out.println(STR."What's player \{number} first name?");
                    String name = input.next();
                    System.out.println(STR."Alright, now give us your CPF,\{name}. We promise not share...");
                    String CPF = input.next();
                    while (!Utilidades.validateCpf(CPF)) {
                        System.out.println("Unfortunately, your cpf is invalid. Please tell us another. The REAL one this time...");
                        CPF = input.next();
                    }
                    System.out.println(STR."Moving on, we need to know your email. It's almost over,\{name}. Please, don't leave me here alone too");
                    String email = input.next();
                    while (!Utilidades.validateEmail(email)) {
                        System.out.println("Unfortanely, your email is invalid. Please help us to help you play, we're a good game! WE PROMISE! ;)");
                        email = input.next();
                    }
                    System.out.println("Final, but just as important. Let us know how you look like... ");
                    String photo = input.next();
                    System.out.println("hmmm yummy");
                    players[i] = new Jogador(name, CPF, email, photo);
                    if (i < playersamount - 1) {
                        System.out.println(STR."YEAH! WE LOVED TO MEET YOU\{players[i].getName()}! Pardon our excitment. Will you let us know the next one?");
                    } else if (i == playersamount - 1) {
                        System.out.println(STR."YEAH! WE CAN FINALLY START TO PLAY, BUT DON'T WORRY WE ALSO LOVED TO MEET YO\{players[i].getName()}!");
                    }
                ArrayList<Integer> properties = new ArrayList<Integer>(3);
                ArrayList<Integer> playerids = new ArrayList<Integer>(3);
                System.out.println("\n");
                for (int j = 0; j < 3; j++) {
                    properties.add(j);
                    System.out.println(cards[j]);
                    System.out.println(boardpieces[j]);
                }

                System.out.println(station);
                System.out.println(STR."PLease, pay this rent: R$\{station.calculaterent()}\n");
                System.out.println(land);
                System.out.println(STR."PLease, pay this rent: R$\{land.calculaterent()}\n");
                System.out.println(service);
                System.out.println(STR."PLease, pay this rent: R$\{service.calculaterent(25)}\n");
                for (int j = 0; j < playersamount; j++) {
                    playerids.add(j);
                    System.out.println(players[j]);
                }
                Tabuleiro board = new Tabuleiro(properties, playerids);
                System.out.println(board);
                //System.out.printlboardies()}");
                System.out.println("Opps, you weren't suppose to see that just yet. There has been a breach in our system. We'll have to delay our game, i'm so sorry. Hope to find you there when we come back online...");
                for (int l = 0; l < 20; l++) {
                    System.out.println(".");
                }
                System.out.println("\nBYE\n");
                }
            } else if (ok == 0) {
                System.out.println(STR."Oh, I'm so sorry. But we cannot play then." +
                        "Did you think WE were gonna give ourselves away just that easy?" +
                        "We have some pride, you know. Not much, but it certainly it's real." +
                        "Have a nice way out, sir or ma'am." +
                        "I don't know it, we didnt let me know it.");
            }

        } else {
            System.out.println(STR."Oh, you think you're funny, don't you?\n" +
                    "Well,\n" +
                    "K\n" +
                    "I\n" +
                    "S\n" +
                    "S\n" +
                    " \n" +
                    "M\n" +
                    "Y\n" +
                    " \n" +
                    "A\n" +
                    "S\n" +
                    "S\n");
        }
    }
}