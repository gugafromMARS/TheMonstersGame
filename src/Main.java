public class Main {

    public static void main(String[] args) {


        Game game = new Game();
        int numberOfMonsters = game.config();
        Player player1 = new Player("Pablo");
        Player player2 = new Player("Mary");

        player1.enterGame(game, numberOfMonsters);
        player2.enterGame(game, numberOfMonsters);


        game.start();
    }
}
