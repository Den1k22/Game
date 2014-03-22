package game.Rules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class GUI extends JFrame {

    RulesForGUI g = new  RulesForGUI();

    private JPanel panel;
    private  JButton closeButton;
    private  JLabel label3 = new JLabel("");
    int num = g.getHumanAll()+1;
    private JButton choseButton[] = new JButton[num];

    public GUI() {

        initUI();
        actionListener =  new TestActionListener();
        {
            for (int i = 0;i<=g.getHumanAll();i++)
            {
                choseButton[i].addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        int a = Integer.valueOf(((JButton) e.getSource()).getText());
                        g.StartPart(a);
                        System.out.println(g.getHumanChoice());
                        label3.setName(String.valueOf(a));
                    }
                });
            }
        }
    }

    public final void initUI() {

        panel = new JPanel();
        panel.setLayout(null);

        JLabel label = new JLabel("You have "+g.getHumanAll()+ " stones");
        label.setBounds(5, 5, 105, 20);

        JLabel label2 = new JLabel("Chose how much stones you take");
        label2.setBounds(5, 20, 205, 35);

        for (int i = 0;i<=g.getHumanAll();i++)
        {
          choseButton[i] = new JButton(String.valueOf(i));
          choseButton[i].setBounds(5+(i*50),60,50,30);
          panel.add(choseButton[i]);
        }

        label3.setBounds(5, 100, 205, 35);

        panel.add(label);
        panel.add(label2);
        panel.add(label3);
        add(panel);

        setTitle("Derived class");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    ActionListener actionListener;

    public class TestActionListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            int a = Integer.valueOf(((JButton) e.getSource()).getText());
            g.StartPart(a);
        }
    }

//    class MyButton extends JButton implements ActionListener {
//
//        public MyButton(String text) {
//            super.setText(text);
//            addActionListener(this);
//        }
//
//        public void actionPerformed(ActionEvent e) {
//           // System.exit(0);
//            panel.remove(closeButton);
//        //    revalidate();
//            panel.repaint();
//        }
//    }

    public static void go() {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }
}