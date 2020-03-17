import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class LoginFrame2 extends JFrame {
	public LoginFrame2(){
		this.setSize(500, 350);
		this.setLocation(400, 200);
		this.setLayout(null);
		this.setVisible(true);
		
		JLabel userNameLabel =new JLabel("PassWord:");
		userNameLabel.setSize(75,25);
		userNameLabel.setLocation(100,50);
		this.add(userNameLabel);
		
		final JTextField userNameField =new JTextField();
		userNameField.setSize(100, 25);
		userNameField.setLocation(170, 50);
		this.add(userNameField);
		
		JButton loginBtn =new JButton("Login");
		loginBtn.setSize(75,25);
		loginBtn.setLocation(100, 100);
		this.add(loginBtn);
		
		loginBtn.addMouseListener(new MouseListener(){

			@Override
			public void mouseClicked(MouseEvent e) {
				 System.out.println(userNameField.getText());
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	}
	public static void main(String[] args) {
		 new LoginFrame2();
		 
	}
}
