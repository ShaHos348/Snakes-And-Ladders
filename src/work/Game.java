package work;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Game extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5000124237017408297L;

	public Game(){
		
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		ImageIcon titleImage = new ImageIcon(getClass().getClassLoader().getResource("Title.png"));
		titleImage.paintIcon(this, g, 0, -10);
		ImageIcon board = new ImageIcon(getClass().getClassLoader().getResource("board.jpg"));
		board.paintIcon(this, g, 0, 75); 
	}
}

/*
Timer tm = new Timer(3000, new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent arg0) {
       java.awt.EventQueue.invokeLater(new Runnable() {
          @Override
          public void run() {
				
          }
       });
    }
    
 });
tm.setRepeats(false);
tm.start();
*/