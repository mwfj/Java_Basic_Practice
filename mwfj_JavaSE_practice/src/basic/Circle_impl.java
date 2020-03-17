package basic;

public class Circle_impl implements Shape{
	public static final double π = 3.1415926;
	private double radius;
	
	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	@Override
	public int area() {
		// TODO Auto-generated method stub
		return (int) (π*(radius*radius));
	}

	@Override
	public int perimeter() {
		// TODO Auto-generated method stub
		return (int) (2*π*radius);
	}


}
