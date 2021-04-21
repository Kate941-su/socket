import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GuiEventTest extends JFrame implements MouseListener,MouseMotionListener {
	private JButton buttonArray[];
	private Container c;

	public GuiEventTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("EventTest");
		setSize(400,400);
		c = getContentPane();	
		c.setLayout(null);
		buttonArray = new JButton[5];
		for(int i=0;i<5;i++){
			buttonArray[i] = new JButton(Integer.toString(i));
			c.add(buttonArray[i]);
			buttonArray[i].setBounds(i*50,10,50,50);
			buttonArray[i].addMouseListener(this);
			buttonArray[i].addMouseMotionListener(this);
			buttonArray[i].setActionCommand(Integer.toString(i));
		}
		
	}
		
	public static void main(String[] args) {
		GuiEventTest gui = new GuiEventTest();
		gui.setVisible(true);
	}
  	
	public void mouseClicked(MouseEvent e) {
		System.out.println("click");
		JButton theButton = (JButton)e.getComponent();
		String theArrayIndex = theButton.getActionCommand();
        if (theButton.getText().equals("*"+theArrayIndex)){
            theButton.setText(theArrayIndex);
        } else {
		    theButton.setText("*"+theArrayIndex);
        }
        System.out.println(theButton.getText());
	}
	
	public void mouseEntered(MouseEvent e) {
		System.out.println("enter");
	}
	
	public void mouseExited(MouseEvent e) {
		System.out.println("exit");
	}
	
	public void mousePressed(MouseEvent e) {
		System.out.println("press");
	}
	
	public void mouseReleased(MouseEvent e) {
		System.out.println("release");
	}
	
	public void mouseDragged(MouseEvent e) {
		System.out.println("Drag");
		JButton theButton = (JButton)e.getComponent();
		String theArrayIndex = theButton.getActionCommand();
		Point theMLoc = e.getPoint();
		System.out.println(theMLoc);
		Point theBtnLocation = theButton.getLocation();
		theBtnLocation.x += theMLoc.x-15;
		theBtnLocation.y += theMLoc.y-15;
		theButton.setLocation(theBtnLocation);
		repaint();
	}
	public void mouseMoved(MouseEvent e) {
		System.out.println("move");
		int theMLocX = e.getX();
		int theMLocY = e.getY();
		System.out.println(theMLocX+","+theMLocY);
	}
}
