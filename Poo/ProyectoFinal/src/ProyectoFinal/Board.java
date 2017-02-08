package ProyectoFinal;
import java.awt.Image;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Board extends JPanel implements ActionListener {
    private Image image, image2;
    private Timer timer;
    private boolean cambio;

    public Board(){
        ImageIcon b1 = new ImageIcon(this.getClass().getResource("/imh/1.jpg"));
        image = b1.getImage();
        ImageIcon b2 = new ImageIcon(this.getClass().getResource("/imh/2.jpg"));
        image2 = b2.getImage();
        this.cambio=true;
        this.setPreferredSize(new Dimension(800,600));
        this.setBackground(Color.white);
  
        timer = new Timer(5, this);
        timer.start();
    }

    public void paint(Graphics g){
        super.paint(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(image, 50, 50, 150, 150, this);
        g2d.drawImage(image2, 50, 200, 150, 150, this);
        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void actionPerformed(ActionEvent e){
    	while(true){
    		
    		repaint();
    	}
    }
}