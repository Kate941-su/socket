import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GuiImageTest extends JFrame implements MouseListener,MouseMotionListener {
	private JButton buttonArray[];
	private Container c;
	private ImageIcon blackIcon, whiteIcon, boardIcon;

	public GuiImageTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("aiueo");
		setSize(400,400);
		c = getContentPane();
		c.setLayout(null);
		whiteIcon = new ImageIcon("White.jpg");
		blackIcon = new ImageIcon("Black.jpg");
		boardIcon = new ImageIcon("GreenFrame.jpg");
		buttonArray = new JButton[5];
		for(int i=0;i<5;i++){
			buttonArray[i] = new JButton(boardIcon);
			c.add(buttonArray[i]);
			buttonArray[i].setBounds(i*45,10,45,45);
			buttonArray[i].addMouseListener(this);
			buttonArray[i].addMouseMotionListener(this);
			buttonArray[i].setActionCommand(String.valueOf(i));
		}
	}
	public static void main(String[] args) {
		GuiImageTest gui = new GuiImageTest();
		gui.setVisible(true);
	}
	public void mouseClicked(MouseEvent e) {
		System.out.println("aiueo");
		JButton theButton = (JButton)e.getComponent();
		String theArrayIndex = theButton.getActionCommand();

		Icon theIcon = theButton.getIcon();
		System.out.println(theIcon);

		if(theIcon.equals(boardIcon)) {
			theButton.setIcon(whiteIcon);
		} else if (theIcon.equals(whiteIcon)) {
			theButton.setIcon(blackIcon);
		} else {
            theButton.setIcon(boardIcon);
        }
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {
	}
	
	public void mouseExited(MouseEvent e) {
	}
	
	public void mousePressed(MouseEvent e) {
	}
	
	public void mouseReleased(MouseEvent e) {
	}
	
	public void mouseDragged(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}
}
