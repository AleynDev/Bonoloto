package bonoloto.src.app;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class BetPanel extends JPanel implements ActionListener {

    Controllers controllers = new Controllers();
    public ArrayList<Integer> betList = new ArrayList<>();
    public ArrayList<Boolean> checkClickBtnList = new ArrayList<>();
    public ArrayList<JButton> buttonList;
    public JButton acceptBnt;
    public JTextField betInstructionText;

    final Integer MAX_NUM_BTN = 49;
    final Integer MAX_NUM_BET = 6;


    public BetPanel() {
        setLayout(null);
        generateLabel();
        generateAcceptBtn();
        generateNumsBtn();

    }

    private void generateLabel() {
        betInstructionText = new JTextField();
        betInstructionText.setText("Introduce 6 números");
        betInstructionText.setEditable(false);
        betInstructionText.setBounds(20,10,300,40);
        betInstructionText.setForeground(new Color(49, 71, 38));
        betInstructionText.setOpaque(false);
        betInstructionText.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
        add(betInstructionText);
    }

    private void generateAcceptBtn() {
        acceptBnt = new JButton("Aceptar");
        acceptBnt.setBounds(380,10,80,35);
        acceptBnt.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
        acceptBnt.setBorder(new RoundedBorder(10));
        acceptBnt.setBackground(new Color(0,153,117));
        acceptBnt.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        acceptBnt.setFocusable(false);
        add(acceptBnt);
    }

    private void generateNumsBtn() {
        int x = 20, y = 55;
        buttonList = new ArrayList<>();
        for (int i = 0; i < MAX_NUM_BTN; i ++) {
            buttonList.add(new JButton("" + (i + 1)));
            buttonList.get(i).setLayout(null);
            buttonList.get(i).setBounds(x, y, 35, 35);
            buttonList.get(i).setFont(new Font("Comic Sans MS", Font.BOLD, 16));
            buttonList.get(i).setForeground(Color.WHITE);
            buttonList.get(i).setBackground(new Color(49, 71, 38));
            buttonList.get(i).setBorder(new RoundedBorder(5));
            buttonList.get(i).setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            buttonList.get(i).setFocusable(false);
            buttonList.get(i).addActionListener(this);

            x += 45;
            if (buttonList.size() % 10 == 0) {
                y += 40;
                x = 20;
            }
            add(buttonList.get(i));
            checkClickBtnList.add(false);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        int index = (Integer.parseInt(e.getActionCommand()) - 1);
        if (betList.size() == 0) {
            betInstructionText.setText("Introduce 6 números");
        }

        if (betList.size() <= MAX_NUM_BET) {

            System.out.println(index);
            if (e.getSource().equals(buttonList.get(index))) {
                if ((betList.size() < MAX_NUM_BET) && (!checkClickBtnList.get(index))) {
                    buttonList.get(index).setBackground(new Color(49, 170, 62));
                    betList.add(Integer.parseInt(e.getActionCommand()));
                    checkClickBtnList.set(index, controllers.checkClick(checkClickBtnList.get(index)));
                } else {
                    buttonList.get(index).setBackground(new Color(49, 71, 38));
                    checkClickBtnList.set(index, controllers.checkClick(checkClickBtnList.get(index)));
                    if (controllers.positionList(Integer.parseInt(e.getActionCommand()), betList) != -1) {
                        betList.remove(controllers.positionList(Integer.parseInt(e.getActionCommand()), betList));
                    }
                }
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "ya ha introducido 6 números");
        }

        Collections.sort(betList);
        betInstructionText.setText(betList.toString());
        
    }

    private Image betPanelImage;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File fileBetImg = new File("src/img/bet_img.png");
        try {
            betPanelImage = ImageIO.read(fileBetImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension dimension = this.getSize();
        g.drawImage(betPanelImage, 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
    }

}
