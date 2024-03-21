public class lab01 {
    public static void main(String[] args) {
        // Criando peças.
        Jogador player = new Jogador("Jorge Felipe", "924.635.285.28", "jorge635@maildomain.com", "Fotografia");
        CartaSorte card = new CartaSorte(215823, "Copacabana Palace Hotel", 2, 100, 1500.26F, "Pague a estadia do melhor hotel de Ipanema!", 24, "Só pode ser utilizada se o jogador possuir a carta CORINGA.");
        Peca boardpiece = new Peca("Azul", 3) ;

        // Printando características.
        System.out.println(player);
        System.out.println(card);
        System.out.println(boardpiece);

    }
}