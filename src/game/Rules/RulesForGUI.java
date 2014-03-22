package game.Rules;

import java.util.Random;

public class RulesForGUI {

    Random rr = new Random();
    int HumanAll,BotAll,HumanChoice,BotChoice,PlayersSum,SumAll,HumanThink,BotThink;
    private boolean Winner; // Чей ход true-human, false-bot
    public RulesForGUI() {
        HumanAll = 3;
        BotAll = 3;
        Winner = true;
    }

    public void StartPart(int b)
    {
        SumAll=HumanAll + BotAll;
        HumanChoice = b;
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

    public void AskHuman(int a)
    {
      HumanThink = a;
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
        if (HumanThink == PlayersSum )
        {
            Winner = true;
            HumanAll = HumanAll -1;
        }
        else if ( BotThink== PlayersSum )
        {
            Winner = false;
            BotAll = BotAll -1;
        }
        else {System.out.println("Nobody win");}
    }

    public boolean getWinner() {
        return Winner;
    }
    public int getHumanAll()
    {
      return HumanAll;
    }

    public int getHumanChoice()
    {
      return HumanChoice;
    }
}
