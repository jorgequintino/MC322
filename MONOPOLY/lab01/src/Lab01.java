public class Lab01 {
    public static void main(String[] args) {
        // Criando peças.
        Jogador player = new Jogador("Luiz Eduardo Valente", "924.635.285.28", "valente635@maildomain.com", "Fotografia");
        CartaSorte card = new CartaSorte(215823, "Copacabana Palace Hotel", 2, 100, 1500.26F, "Pague a estadia do melhor hotel de Ipanema!", 24, "Só pode ser utilizada se o jogador tiver CPF válido.");
        Peca boardpiece = new Peca("Azul", 3) ;

        // Printando características.
        System.out.println("Estes são os dados cadastrados no Monoply MC322's version:\n");
        System.out.println(player);
        System.out.println(card);
        System.out.println(boardpiece);
        System.out.println("\nObrigado por jogar!");

    }
}
