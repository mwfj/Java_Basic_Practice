package mwfj.demo.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/getValidateImage.jpg")
public class GetValidateImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 产生一个随机下标值 min - max 之间
	 * @param min
	 * @param max
	 * @return
	 */
	private int getRandomNumber(int min, int max) {
		int num = 0;
		num = ((int) (Math.random() * (max - min))) + min;
		return num;
	}
	
	/**
	 * 算随机数 （验证码）
	 * 验证码：一般情况下4个字符
	 * @return
	 */
	private String getValidateCode() {
		
		String codes = "";
		
		/**
		 * 随机数源
		 * 0 - 61
		 * 长度是62
		 */
		String str = 
				"abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		// 随机的抽4个字符组成验证码
		/**
		 * 随机数： 0.0 -----》1.0 之间
		 * 0.1234
		 * 0.456
		 * 0.789
		 * ........
		 *  0 * 62 ---> 0
		 *  1 * 62 ---> 61.....
		 */
		char[] chars = new char[str.length()];
		chars = str.toCharArray();
		
		for(int i = 0; i < 4; i++) {
			char c = chars[this.getRandomNumber(0, str.length())];
			codes += String.valueOf(c);
		}
		return codes;
	}
	
	/**
	 * 
	 * @param g
	 * @param code
	 */
	private void drawCode(Graphics g, String str) {
		/**
		 * 画的时候拆成字符
		 * 
		 */
		char[] chars = str.toCharArray();
		int x = 0; // 设定 x轴的位置
		int y = 40;// 设置y轴的位置
		g.setColor(Color.white); // 设置字体的颜色
		g.setFont(new Font("宋体", Font.ITALIC, 40));
		for (int i = 0; i < chars.length; i++) {
			x = x + 40; // (40, 40)
			g.drawString(String.valueOf(chars[i]), x, y);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletOutputStream out = null;
		try {

			response.setContentType("image/jpeg");
			out = response.getOutputStream();
			int width = 240;
			int height = 60;
			BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
			// 用此图片对象创建一个画笔
			Graphics g = image.createGraphics();
			// 设置图片的色彩（底色）
			g.setColor(Color.GRAY);
			// 矩形，填充色
			g.fillRect(0, 0, width, height);
			
			String validateCode = this.getValidateCode();
			
			System.out.println("产生的随机数验证码： " + validateCode);
			
			/**
			 * 1) 你要把这个验证码保存起来
			 * 2) 画到Image对象上去返回给客户端
			 */
			// 会话保存
			HttpSession session = request.getSession();
			session.setAttribute("ValidateCode", validateCode);
			
			// 画
			this.drawCode(g, validateCode);
			
			
			ImageIO.write(image, "JPEG", out);
		} finally {
			if(out != null) {
				out.close();
			}
		}
		
		
	}

}
