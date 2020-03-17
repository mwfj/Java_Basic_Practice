package basic;

public class Rectangular implements Shape{
	private int length;
	private int width;
	
	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	@Override
	public int area() {
		// TODO Auto-generated method stub
		return length*width;
	}

	@Override
	public int perimeter() {
		// TODO Auto-generated method stub
		return 2*(length+width);
	}

}
