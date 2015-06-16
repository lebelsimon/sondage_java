import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Executable {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Question question = new Question("Aimes-tu les cookies ?");
		VueSaisieQuestion QCM1 = new VueSaisieQuestion(question);
		Menu men = new Menu();
		//GraphicsDevice device;
		ApplicationSondage c = new ApplicationSondage(men, QCM1);
        /*device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (device.isFullScreenSupported()) {
			device.setFullScreenWindow(c);
        } else {
            System.err.println("Le mode plein ecran n'est pas disponible");
        }*/
		
		
	}

}
