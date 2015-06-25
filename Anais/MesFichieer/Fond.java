import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;


/**
 * @author LAVOREL anais
 * @param Aucun lors de la creation du JPanel 
 * Cree le fond
 * le redimentionne si besoin pour s'adapter à la taille de la fentre
 */
 
 
public class Fond extends JPanel {
  public void paintComponent(Graphics g){
	
    try {
      Image img = ImageIO.read(new File("../Ressources/FondV4.jpg"));
      g.drawImage(img, 0, 0, super.getWidth(), super.getHeight(), this);
    } catch (IOException e) {
      e.printStackTrace();
    }                
  }               
}
