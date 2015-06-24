import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Fond extends JPanel {
  public void paintComponent(Graphics g){
    try {
	this.setSize(800,600);
	
      Image img = ImageIO.read(new File("../Ressources/FondV4.jpg"));
      g.drawImage(img, 0, 0, super.getWidth(), super.getHeight(), this);
      //~ System.out.print("this.getWidth(): "+this.getWidth()+ "this.getHeight(): "+this.getHeight());
      //Pour une image de fond
      //~ g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }                
  }               
}
