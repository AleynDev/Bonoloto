package bonoloto.src.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AwardsPanel extends JPanel {

    ArrayList<Integer> winningNums; // = new WinningNum().winningBet;
    ArrayList<Integer> betNums;
    //JLabel infoAwards;

    public AwardsPanel(ArrayList<Integer> winningNums) {
        this.winningNums = winningNums;
        this.betNums = new ArrayList<>();
        setLayout(null);
        //generateLabelInfo();
    }

    public void setBetNums(ArrayList<Integer> betNums) {
        this.betNums = betNums;
    }

    /*public void generateLabelInfo() {
        infoAwards = new JLabel();
        infoAwards.setText(
                "<html>El número ganador es:<br>"+ this.winningNums.toString() + "<br><br>" +
                "Su número es:<br>"+ this.betNums.toString() + "</html>");
        infoAwards.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        infoAwards.setForeground(new Color(29,31,33));
        infoAwards.setBounds(20,20,400,200);
        add(infoAwards);
    }*/

    private Image awardsPanelImg;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File fileBetImg = new File("src/img/bet_img.png");
        try {
            awardsPanelImg = ImageIO.read(fileBetImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension dimension = this.getSize();
        g.drawImage(awardsPanelImg, 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
    }

}
