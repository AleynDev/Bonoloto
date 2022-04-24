package bonoloto.src.app;

import java.awt.*;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.*;

public class StartPanel extends JPanel {

    public CustomButtons startbtn;

    public StartPanel() {
        setLayout(null);
        startbtn = new CustomButtons();
        startbtn = new CustomButtons();
        startbtn.setLayout(null);
        startbtn.setBounds(135, 200, 200, 38);
        startbtn.setBorderPainted(false);
        //startbtn.setContentAreaFilled(false); // quitar el area al rededor del contenido del boton
        startbtn.setIcon(new ImageIcon("src/img/jugar_1.png"));
        startbtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        startbtn.setBorder(new RoundedBorder(20));
        add(startbtn);
    }

    private Image firstImage;

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        File fileStartImg = new File("src/img/start_img.jpg");
        try {
            firstImage = ImageIO.read(fileStartImg);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Dimension dimension = this.getSize();
        g.drawImage(firstImage, 0, 0, dimension.width, dimension.height, null);
        setOpaque(false);
    }

}
