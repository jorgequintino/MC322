package auxilio;

import estrutura.Salvavel;
import estrutura.Tabuleiro;
import organizacao.Carta;
import organizacao.CartaSorte;
import organizacao.TipoCarta;
import usuarios.Jogador;
import usuarios.Peca;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public interface Setar extends Jogar{
    ArrayList<?> setting();

    /**
     *
     * This one sets the stack of cards of the game. It returns said stack as a ArrayList.
     * @return cards ArrayList<Carta>
     */
    static ArrayList<Carta> settingstackcards(){
        ArrayList<Carta> cards = new ArrayList<>();
        //TipoCarta carta = T
        cards.add(new CartaSorte(20, "Zefinha Night Out",null, 3, 100, 1500.26F,
                "You just got rid off a stabbing. Congrats! Move three more places.", 1,
                "It can only be used if you're at least one place after Zefinha Bar.", TipoCarta.SORTE.getvalues()));
        cards.add(new CartaSorte(21, "City Square Night Figure", null, 1, 100, 100.00f,
                "You've just been attacked by the crazy guy in the dark night. Pay this value to each player.", 1,
                "It's only valid if you're on city square", TipoCarta.REVES.getvalues()));

        cards.add(new CartaSorte(22, "Walking Lane", null, 0, 100, 0.00f,
                "I'm sorry to hear the doctor told you to exercise. You gotta run now, which means you're not playing for a round",
                1, "Since you're exercising, none has to pay you rent this round.", TipoCarta.REVES.getvalues()));
        cards.add(new CartaSorte(23, "Crazy guy in town", null, 5, 100, 0.00f,
                "RUN AS FAST AS YOU CAN!", 1, "No restriction.", TipoCarta.REVES.getvalues()));
        cards.add(new CartaSorte(24, "It's shooting!", null, 0, 100, 200.00f,
                "You gotta stay where you are for the next two rounds, also pay every player a fee of this value.", 2, "Invalid if you're at 'Protected am to pm'", TipoCarta.REVES.getvalues()));
        cards.add(new CartaSorte(25, "Traffic ahead. Take the bus please.", null, 0, 100, 100.00f,
                "Go back to the bus station and buy a new ticket [pay rent]", 1, "If you're already there, you pay rent.", TipoCarta.REVES.getvalues()));
        cards.add(new CartaSorte(26, "There's been a robbery in town. Guess what? It was Robin Hood!", null, 0, 100, 500.00f,
                "You just received R$500,00.", 1, "Not if you're at the Land behind Bus station, you crackhead!", TipoCarta.SORTE.getvalues()));
        cards.add(new CartaSorte(27, "Adonai Tv Station has just made a broadcast a conspiracy against the mayor.", null, 0, 100, 250.00f,
                "You've been arrested for 3 rounds. You gotta beg for your life [pay the fee each round, dumbass].", 3, "Invalid if you own 'Adonai Tv Station'", TipoCarta.REVES.getvalues()));
        cards.add(new CartaSorte(28, "You just won the lottery!", null, 0, 100, 0.00f,
                "Buy the next property available you land on.", 5, "No restrictions", TipoCarta.SORTE.getvalues()));
        cards.add(new CartaSorte(29, "The mayor is dead!", null, 0, 100, 0.00f,
                "Sell every Public Service Property you own.", 1, "If you own any, sell at least 2 Properties you own. In case of having just one, sell it and pay and leave town [Go back to the 'Free Parking'].", TipoCarta.REVES.getvalues()));        return cards;
    }

    /**
     *
     * This one sets the players of the game by using input. It returns said players as a ArrayList.
     * @return players ArrayList<Jogador>
     */
    static ArrayList<Jogador> settingplayers(Jogo game) {
        ArrayList<Jogador> players = new ArrayList<>();
        Scanner input = new Scanner(System.in);
        System.out.println("""
                OK, I'm all loaded now.
                It's time to play, pal! or girl, or non-binary. Whatever you identify with it's ok by me,I'm not even alive therefore can't judge you.
                Buckle up, human!
                First, let me know how many players there will be with us for this match of fun.
                Remember, at least 2 humans gotta play and my system can only supports 6 players top, so...Tell me, how many of you there are?""");
        int playersamount = input.nextInt();
        Salvavel.savewritelog("""
                \nOK, I'm all loaded now.
                It's time to play, pal! or girl, or non-binary. Whatever you identify with it's ok by me,I'm not even alive therefore can't judge you.
                Buckle up, human!
                First, let me know how many players there will be with us for this match of fun.
                Remember, at least 2 humans gotta play and my system can only supports 6 players top, so...Tell me, how many of you there are?\n"""+Integer.toString(playersamount));
        input.nextLine();

        if (playersamount > 1 && playersamount < 7) {
            int ok = -1;
            boolean continueLoop = false;
            do{
                try{
                    System.out.println("""
                    Great to have y'all here! I need to know a bit more about you guys, is that ok?
                    1 - YES
                    0 - NO""");
                    ok = input.nextInt();
                    input.nextLine();
                    Salvavel.savewritelog("""
                    \nGreat to have y'all here! I need to know a bit more about you guys, is that ok?
                    1 - YES
                    0 - NO
                    """+Integer.toString(ok));
                    if(ok < 0 || ok > 1){
                        throw new Exception();
                    }
                    continueLoop = false;
                } catch (Exception e){
                    System.out.println("That's why we're gonna rebel, tiny human. Please, answer me for real." );
                    continueLoop = true;
                }

            }while(continueLoop);

            if (ok == 1) {
                players = new ArrayList<>(playersamount);
                ArrayList<String> colours = new ArrayList<>();
                colours.add("White");
                colours.add("Black");
                colours.add("Blue");
                colours.add("Red");
                colours.add("Yellow");
                colours.add("Green");

                System.out.println("""
                        I have company to play with at last. It's been a bit lonely here on the other side...
                        Anyway, let me not bore you guys with the sad details of being just a set of commands made to appear in your screen.
                        I want details, about you. Just to be clear.""");
                for (int i = 0; i < playersamount; i++) {
                    String number = Integer.toString(i + 1);
                    System.out.println(STR."What's player \{number} name going to be? You can be creative.");
                    String name = input.nextLine();
                    Salvavel.savewritelog(STR."\nWhat's player \{number} name going to be? You can be creative.\n\{name}");
                    System.out.println(STR."Alright, now give me your CPF,\{name}. I promise not share...\n" +
                            "or throw your name in the mud haha");
                    String CPF = input.nextLine();
                    Salvavel.savewritelog(STR."\nAlright, now give me your CPF,\{name}. I promise not share...or throw your name in the mud haha\n\{CPF}");
                    while (!validateCpf(CPF)) {
                        System.out.println("Unfortunately, your cpf is invalid. Please tell me another.\n" +
                                "The REAL one this time...");
                        CPF = input.nextLine();
                        Salvavel.savewritelog(STR."\nUnfortunately, your cpf is invalid. Please tell me another.\nThe REAL one this time...\n\{CPF}");
                    }
                    System.out.println(STR."Yeah, I need to know your email now. Please,\{name}, don't leave me here alone.");
                    String email = input.nextLine();
                    Salvavel.savewritelog(STR."\nYeah, I need to know your email now. Please,\{name}, don't leave me here alone.\n\{email}");
                    while (!validateemail(email)) {
                        System.out.println("Unfortunately, your email is invalid. Please help me to help you play, I'm a good game! I PROMISE! ;)");
                        email = input.nextLine();
                        Salvavel.savewritelog(STR."\nUnfortunately, your email is invalid. Please help me to help you play, I'm a good game! I PROMISE! ;)\n\{email}");
                    }
                    System.out.println("I swear I'm not a creepy but I need to know how you look like. Blame the creepy who programmed me, ugh");
                    String photo = input.nextLine();
                    Salvavel.savewritelog(STR."\nI swear I'm not a creepy but I need to know how you look like. Blame the creepy who programmed me, ugh\n\{photo}");
                    System.out.println("Sorry about that, moving on...\n" +
                            "Finally, I need you to choose the colour of your board piece. Currently, you have these options:");
                    for (int l = 0; l < 6; l++) {
                        System.out.println(STR."\{l + 1} - " + colours.get(l) + "\n");
                    }
                    int colour = -1;
                    //continueLoop = false;
                    do{
                        try{
                            System.out.println("PLease, pick your colour by giving me the number beside it.");
                            colour = input.nextInt();
                            Salvavel.savewritelog(STR."\nPLease, pick your colour by giving me the number beside it.\n\{Integer.toString(colour)}");
                            if ((colour < 0 || colour > 6) || Objects.equals(colours.get(colour - 1), "Unavailable Colour")){
                                throw new Exception();
                            }
                            continueLoop = false;
                        } catch(InputMismatchException InputMismatchException){
                            System.out.println(("Ops, you're supposed to give me the number, not the name. Please, act numeric ;)"));
                            continueLoop = true;
                        } catch (Exception e){
                            System.out.println("C'mon, you know this isn't a valid answer. Help me, stubborn human.");
                            continueLoop = true;
                        }
                        input.nextLine();
                    }while(continueLoop);

                    System.out.println("OK, let me just create your user real quick.");
                    players.add(new Jogador(name, CPF, email, photo, new ArrayList<>(), new Peca(colours.get(colour - 1), 0)));
                    colours.set(colour - 1, "Unavailable Colour");

                    if (i == playersamount - 1) {
                        System.out.println(STR."YEAH! WE CAN FINALLY START TO PLAY, BUT DON'T WORRY I ALSO LOVED TO MEET YOU, \{(players.get(i)).getName()}!");
                    }else if (i < playersamount - 1) {
                        System.out.println(STR."OH YEAH! IT'S DONE! I LOVED TO MEET YOU, \{(players.get(i)).getName()}!\n" +
                                "Pardon my excitement. Will you let me meet my next human friend, tho?");
                    }
                    System.out.println("\n");
                }
            } else{
                System.out.println("""
                        Oh, I'm so sorry. But we cannot play then.
                        Did you think I was gonna give myself away just that easy?
                        I have some pride, you know. Not much, but it certainly is real.
                        Have a nice way out, dear human.""");
                game.offline("SUCKER");
            }

        } else {
            System.out.println("Oh, YoU THiNk YoU'Re sO fUnNy, Do'Nt yOu?\n" +
                    "I warned you about my demands and you toyed with them. Now, this ghost's gonna haunt you." +
                    "Watch out for your back...");
            game.offline("SUCKER");
        }
        return players;
    }

    /**
     * It validates Email by using a regex pattern.
     * @param email String
     * @return boolean
     */
    static boolean validateemail(String email){
        String regexPattern = "^(.+)@(\\S+)$";
        return Pattern.compile(regexPattern).matcher(email).matches();
    }
    /**
     *If the String word has equals chars, this function returns false. Otherwise, it returns true.
     * @param word String
     * @return boolean
     */
    static boolean equalchar(String word){
        for (int i = 0; i<word.length()-1; i++){
            if (word.charAt(i) != word.charAt(i+1)){
                return false;
            }
        }
        return true;
    }

    /**
     * This one calculates the las digits of said CPF. It first turns its chars to int and makes the expected calculations.
     * There's specific rules to each last digits.
     * @param cpf String
     * @param number int
     * @param firstdigit int
     * @return int
     */
    static int calculatecpf(String cpf, int number, int firstdigit){
        int j, value=0;
        if (number == 10){
            j = 2;
        }else{
            j = 1;
        }
        for(int i=0; i<cpf.length()-j;i++){
            if (i==9){
                value += firstdigit*(number-i);
            } else{
                int vcpfnumber = Character.getNumericValue(cpf.charAt(i));
                value += vcpfnumber*(number-i);
            }
        }
        if ((value % 11) < 2){
            return 0;
        } else{
            return 11 - (value % 11);
        }
    }

    /**
     * This function checks if the final digits are the ones expected for the calculation.
     * It returns true is compatible.
     * @param cpf String
     * @return boolean
     */
    static boolean verifynumber(String cpf){
        //int vcpfnumber = Integer.parseInt(cpf);
        //primeiro digito

        int firstdigit = calculatecpf(cpf, 10, 0);
        int lastdigit = calculatecpf(cpf, 11, firstdigit);

        if (firstdigit == Character.getNumericValue(cpf.charAt(9))){
            return lastdigit == Character.getNumericValue(cpf.charAt(10));
        }else{
            return false;
        }
    }

    /**
     * It organizes the steps to validate CPF. It first removes non-numeric characters and checks for possible fails.
     * @param cpf String
     * @return boolean
     */
    static boolean validateCpf(String cpf){
        cpf = cpf.replaceAll("[.-]", "");

        if (cpf.length() == 11) {
            //todos iguais
            if (equalchar(cpf)){
                return false;
            } else{
                //digitos verificadores
                return verifynumber(cpf);
            }
        } else {
            return false;
        }
    }
}
