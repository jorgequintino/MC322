package auxilio;

import estrutura.Salvavel;

public interface Jogar {
    /**
     *
     * This interface function prints the first introduction to the game.
     */
    default void on(){
        for (int l = 0; l < 20; l++) {
            System.out.println(".");
        }
        System.out.println("""
                Oh, HI!
                Welcome to Monoply MC322's version!
                This Especial Edition of such a classic game will honour its programmer hometown,which means YOU player(s) have lots of surprises ahead.
                My name is Mono and no, I'm not a ghost. I'm a set of commands made to give you the best possible game.
                First, let me load the board. It's been a while since anyone played with me!
                LOADING ...
                """);
        Salvavel.savewritelog("""
                Oh, HI!
                Welcome to Monoply MC322's version!
                This Especial Edition of such a classic game will honour its programmer hometown,which means YOU player(s) have lots of surprises ahead.
                My name is Mono and no, I'm not a ghost. I'm a set of commands made to give you the best possible game.
                First, let me load the board. It's been a while since anyone played with me!
                LOADING ...
                """);
    }

    /**
     *
     * This interface function prints the first final statement of the game.
     * @param finalWord String
     */
    default void off(String finalWord){
        for (int l = 0; l < 20; l++) {
            System.out.println(".");
        }
        System.out.println(STR."\nBYE, \{finalWord}!\n");
    }
}
