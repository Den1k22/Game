package game;

import game.Rules.Game;

public class Main {

    public static void main(String[] args)
    {
       Game g = new Game();
       do
       {
           g.NewGame();
           do
           {
               g.StartStep();
               if (g.getWinner())
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
           }while (g.EndGame());

       }while(g.Restart());
    }
}