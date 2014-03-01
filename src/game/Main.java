package game;

import game.Rules.Game;

public class Main {

    public static void main(String[] args)
    {
        Game g = new Game();

        do
        {
            g.StartPart();
            if (g.getWinner() == true)
            {
                g.AskHuman();
                g.AskBot();
            }
            else
            {
                g.AskBot();
                g.AskHuman();
            }
            g.EndStep();
        }while (g.EndGame() == true);
    }

}