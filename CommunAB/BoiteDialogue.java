import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.Timer;


public class BoiteDialogue extends JOptionPane {
	Timer t;
	private class ActionTuer implements ActionListener{
		BoiteDialogue bt;
		
		public ActionTuer(BoiteDialogue bt) {
			super();
			this.bt = bt;
		}

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			bt.getRootFrame().dispose();
			
		}
		
	}
	private void init(int tps){
		ActionListener ac= new ActionTuer(this);
		t=new Timer(tps, ac);

	}
	public void start(){
		t.start();
	}
	public BoiteDialogue(int tps) {
		super();
		init(tps);
		
		// TODO Auto-generated constructor stub
	}



}
