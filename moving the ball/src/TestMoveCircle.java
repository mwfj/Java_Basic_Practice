import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestMoveCircle extends JFrame {

	private MyPanel mp;

	public static void main(String[] args) {
		new TestMoveCircle();
	}

	public TestMoveCircle() {
		//定义窗口的参数
		this.setLocation(10, 10);
		this.setTitle("移动的小球");
		this.setSize(600, 500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		mp = new MyPanel(0, 0);
		this.add(mp);
		this.addKeyListener(new MyKeyEvent());
		
		this.setVisible(true);

		
	}

	private class MyKeyEvent extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				mp.y -= 10;
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				mp.y += 10;
			} else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				mp.x -= 10;
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				mp.x += 10;
			}
			mp.repaint();

		}

	}

	private class MyPanel extends JPanel {
		private int x;
		private int y;

		public MyPanel(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}

		@Override
		public void paint(Graphics g) {

			super.paint(g);
			g.setColor(Color.PINK);
			g.fillOval(x,y, 20, 20);
		}

	}

}