package bonoloto.src.app;

import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomButtons extends JButton {

    private float opacity = 0.6f;

    public CustomButtons() {
        super();
        addMouseListener(new EventButton());
    }

    public CustomButtons(String text) {
        super(text);
        addMouseListener(new EventButton());
    }

    public CustomButtons(Icon icon) {
        super(icon);
        addMouseListener(new EventButton());
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
        repaint();
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2 = (Graphics2D) g; // casteo g a g2
        g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, opacity));
        super.paintComponent(g2);
    }

    public class EventButton extends MouseAdapter {

        @Override
        public void mouseClicked(MouseEvent e) {
            super.mouseClicked(e);
            efectHover(1f,0.6f,0.03f,10,false);
        }

        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            efectHover(0.6f,1f,0.03f,10,true);
        }

        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            efectHover(1f,0.6f,0.03f,10,false);
        }

        private void efectHover(float index, float range, float cont, int sleep, boolean event) {
            new Thread(() -> {
                for (float i = index; (event) ? i <= range : i >= range; i = (event) ? i + cont : i - cont) {
                    setOpacity(i);
                    try {
                        Thread.sleep(sleep);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
