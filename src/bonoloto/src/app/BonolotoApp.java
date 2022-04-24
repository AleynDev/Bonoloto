package bonoloto.src.app;

import javax.swing.*;
import java.awt.*;

public class BonolotoApp extends JFrame {

    public JPanel window;
    JLabel infoAwards;
    StartPanel startPanel;
    BetPanel betPanel;
    AwardsPanel awardsPanel;
    Controllers controllers = new Controllers();

    final static String START_PANEL = "Card the main panel of the app";
    final static String BET_PANEL = "Card the betting panel";
    final static String AWARDS_PANEL = "Card the awards panel";

    /**
     * Launch the application.
     * @param args
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                BonolotoApp bonolotoApp = new BonolotoApp();
                bonolotoApp.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }



    public BonolotoApp() {
        startPanel = new StartPanel();
        betPanel = new BetPanel();
        awardsPanel = new AwardsPanel(new WinningNum().winningBet);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("   ¡¡¡ Juega a la Bonoloto !!!");

        // I create the window
        window = new JPanel();
        setContentPane(window);
        window.setLayout(new CardLayout(0,0));

        // I add the panels that can be displayed
        window.add(START_PANEL, startPanel);
        window.add(BET_PANEL, betPanel);
        window.add(AWARDS_PANEL, awardsPanel);

        // Panel change [StartPanel -> BetPanle]
        startPanel.startbtn.addActionListener(e -> {
            System.out.println(awardsPanel.winningNums); //.....
            CardLayout c1 = (CardLayout) (window.getLayout());
            c1.show(window, BET_PANEL);
        });

        // Panel change [BetPanel -> AwardsPanel]
        betPanel.acceptBnt.addActionListener(e -> {
            System.out.println(betPanel.betList.toString());
            System.out.println("size: " + betPanel.betList.size());
            try {
                if (betPanel.betList.size() == 6) {
                    CardLayout c2 = (CardLayout) (window.getLayout());
                    c2.show(window, AWARDS_PANEL);
                    awardsPanel.setBetNums(betPanel.betList);
                    System.out.println("aw win:"+awardsPanel.winningNums); //.....
                    System.out.println("aw bet:"+awardsPanel.betNums); //.....
                    int pos = controllers.checkReward(awardsPanel.betNums, awardsPanel.winningNums);
                    String text = controllers.rewards(pos);
                    awardsPanel.add(generateLabelInfo(text));
                } else {
                    JOptionPane.showMessageDialog(window, "Para continuar debe\nseleccionar 6 números");
                }
            } catch (NullPointerException n) {
                JOptionPane.showMessageDialog(window, "Para continuar debe\nseleccionar 6 números");
            }
        });

    }

    public JLabel generateLabelInfo(String text) {
        infoAwards = new JLabel();
        infoAwards.setText(
                "<html>El número ganador es:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                "Su número es:     <br>" + awardsPanel.winningNums.toString() +
                 "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + awardsPanel.betNums.toString() +
                "<br><br>" + text + "</html>");
        infoAwards.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        infoAwards.setForeground(new Color(29,31,33));
        infoAwards.setBounds(10,10,480,200);
        infoAwards.setVisible(true);
        return infoAwards;
    }

}


