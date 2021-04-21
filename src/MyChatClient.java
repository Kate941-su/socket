import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MyChatClient extends JFrame implements ActionListener{
	JTextField tfKeyin;
	JTextArea taMain;
	String myName;
	JButton bs=new JButton("Send");
	private Container c;
	PrintWriter out;
	public MyChatClient(){
		String myName = JOptionPane.showInputDialog(null,"aiuer","hgfgdg",JOptionPane.QUESTION_MESSAGE);
		if(myName == null){
			myName = "No name";
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("MyChatClient");
		setSize(600,400);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		tfKeyin = new JTextField("",42);
		c.add(tfKeyin);
		c.add(bs);
		bs.addActionListener(this);
		taMain = new JTextArea(20,50);
		c.add(taMain);
		taMain.setEditable(false);//ここまでが装飾の設定
		Socket socket = null;//
		try {
			socket = new Socket("localhost", 10000);//接続先の設定同パソコンならローカルホスト
		} catch (UnknownHostException e) {
			System.err.println("thisIP,PORT: " + e);
		} catch (IOException e) {
			 System.err.println(":" + e);
		}
		MesgRecvThread mrt = new MesgRecvThread(socket, myName);
		mrt.start();//受信スレッドの開始
	}
	public class MesgRecvThread extends Thread {
		Socket socket;
		String myName;
		public MesgRecvThread(Socket s, String n){
			socket = s;
			myName = n;
		}
		public void run() {
			try{
				InputStreamReader sisr = new InputStreamReader(socket.getInputStream());
				BufferedReader br = new BufferedReader(sisr);
				out = new PrintWriter(socket.getOutputStream(), true);
				out.println(myName);
				while(true) {
					String inputLine = br.readLine();
					if (inputLine != null) {
						taMain.append(inputLine+"\n");
					}
					else{
						break;
					}
				}
				socket.close();
			} catch (IOException e) {
				System.err.println(":" + e);
			}
		}
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getActionCommand()=="Send") {
			String msg = tfKeyin.getText();
			tfKeyin.setText("");
			if(msg.length()>0){
				out.println(msg);
				out.flush();
			}
		}
  	}
  	public static void main(String[] args) {
		MyChatClient cc = new MyChatClient();
		cc.setVisible(true);
	}
}
