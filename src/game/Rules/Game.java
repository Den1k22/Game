package game.Rules;

import java.util.Random;
import java.util.Scanner;
import game.Rules.GUI;

public class Game {

    Random rr = new Random();
    Scanner scan = new Scanner(System.in);
    int HumanAll,BotAll,HumanChoice,BotChoice,PlayersSum,SumAll,HumanThink,BotThink;
    private boolean Winner; // Чей ход true-human, false-bot

    public void NewGame()
    {
        HumanAll = 3;
        BotAll = 3;
        Winner = true;
    }

    public void StartStep()
    {
        SumAll=HumanAll + BotAll;
        System.out.println("You have " + HumanAll);
        do
        {
            System.out.println("Enter stone number(It can't be more than "+HumanAll+" or less than 0 ): ");
            String b = scan.nextLine();
            HumanChoice = Integer.parseInt(b);
        }while (HumanChoice > HumanAll || HumanChoice < 0);
        int aa = rr.nextInt(BotAll+1);
        BotChoice = aa;
        PlayersSum = BotChoice+HumanChoice;
        BotThink=-1;
        HumanThink=-1;
    }

    public boolean EndGame()
    {
        boolean game = true;
        if (HumanAll == 0 || BotAll == 0)
        {
            if (HumanAll == 0)
            {
                System.out.println("Winner ");
            }
            if (BotAll == 0)
            {
                System.out.println("Lox ");
            }
            game = false;
        }
        return game;
    }

    public void AskHuman()
    {
        do
        {
            System.out.println("Enter stone sum(It can't be more than "+SumAll+" or less than 0 ): ");
            String b = scan.nextLine();
            HumanThink = Integer.parseInt(b);
        }while (HumanThink > SumAll || HumanThink < 0 || HumanThink==BotThink);
    }

    public void AskBot()
    {
        do
        {
            int rand = rr.nextInt(HumanAll+1)+BotChoice;
            BotThink=rand;
        }while (BotThink > SumAll || BotThink < 0 || HumanThink==BotThink);
        System.out.println("Bot says " + BotThink);
    }

    public void EndStep()
    {
        System.out.println();
        System.out.println("You have " + HumanChoice + " Bot have " + BotChoice);
        if (HumanThink == PlayersSum )
        {
            Winner = true;
            HumanAll = HumanAll -1;
            System.out.println("You win Part");
        }
        else if ( BotThink== PlayersSum )
        {
            Winner = false;
            BotAll = BotAll -1;
            System.out.println("Bot win Part");
        }
        else {System.out.println("Nobody win");}
    }

    public boolean getWinner() {
        return Winner;
    }

    public boolean Restart()
    {
       boolean a = false;
       System.out.println("Continue? y-Yes, n-No");
       String b = scan.nextLine();
       if( b.equals("y") || b.equals("Y")) {a = true; }
       return a;
    }
}
