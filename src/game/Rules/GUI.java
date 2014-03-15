package game.Rules;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import game.Rules. RulesForGUI;

public class GUI extends JFrame {
    RulesForGUI g = new  RulesForGUI();

    private JPanel panel;
    private  JButton closeButton;

    public GUI() {

        initUI();
    }

    public final void initUI() {

        panel = new JPanel();
        panel.setLayout(null);

        closeButton = new MyButton("Close");
        closeButton.setBounds(40, 50, 80, 25);

        JLabel label = new JLabel("You have "+g.getHumanAll()+ " stones");
        label.setBounds(5, 5, 105, 25);

        panel.add(closeButton);
        panel.add(label);
        add(panel);

        setTitle("Derived class");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class MyButton extends JButton implements ActionListener {

        public MyButton(String text) {
            super.setText(text);
            addActionListener(this);
        }

        public void actionPerformed(ActionEvent e) {
           // System.exit(0);
            panel.remove(closeButton);
        //    revalidate();
            panel.repaint();
        }
    }

    public static void go() {

        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                GUI ex = new GUI();
                ex.setVisible(true);
            }
        });
    }
}