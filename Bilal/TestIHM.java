import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class TestIHM {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		GraphicsDevice device;
		ApplicationSondage c = new ApplicationSondage();
        device = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
		if (device.isFullScreenSupported()) {
			device.setFullScreenWindow(c);
        } else {
            System.err.println("Le mode plein ecran n'est pas disponible");
        }

		
	}
	
}
