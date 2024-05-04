package auxilio;

public class Jogo implements Jogar{
   public boolean gameon;

   /**
    *
    * This one calls the interface function responsible to turn on the game.
    */
   public void online() {
      this.gameon=true;
      System.out.println(this);
      on();
   }

   /**
    *
    * This one calls the interface function responsible to turn off the game.
    * @param finalWord String
    */
   public void offline(String finalWord) {
      this.gameon = false;
      off(finalWord);
      System.out.println(this);
   }

   @Override
   public String toString() {
      if(gameon) {
         return "This game is online! :)";
      }else {
         return "This game is offline! :/";
      }
   }
}
