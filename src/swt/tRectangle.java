package swt;

import java.awt.Rectangle;

public class tRectangle {
	public static void main(String[] args) {
		Rectangle ectangle = new Rectangle(10, 20, 20, 20);
		boolean a = ectangle.contains(20, 30);
		System.out.println(a);
	}
}
