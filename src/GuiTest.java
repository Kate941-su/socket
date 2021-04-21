import javax.swing.*;
import java.lang.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class GuiTest extends JFrame {
	private JButton buttonArray[][];
	private Container c;

	public GuiTest() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Gui Test");
		this.setSize(1000,1000);
		c = this.getContentPane();
		c.setLayout(null);
        int count = 0;
		buttonArray = new JButton[8][8];
		for(int i = 0;i < 8;i++){
            for(int j = 0; j < 8; j++){
                buttonArray[i][j] = new JButton(Integer.toString(count));
                c.add(buttonArray[i][j]);
                buttonArray[i][j].setBounds(j*45,45*i,50,50);
                count++;
		    }
        }
	}
    public static void main(String[] args) {
		GuiTest gui = new GuiTest();
		gui.setVisible(true);
	}
}
