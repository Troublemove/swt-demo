package swt;

public class Quar {
	public static boolean isInside(Point left, Point top, Point right, Point buttom, Point pointToCheck) {
		Line line1 = Line.getLine(left, top);
		Line line2 = Line.getLine(top, right);
		Line line3 = Line.getLine(right, buttom);
		Line line4 = Line.getLine(buttom, left);
		if (Line.getValue(line1, pointToCheck) >= 0 && Line.getValue(line2, pointToCheck) >= 0
				&& Line.getValue(line3, pointToCheck) <= 0 && Line.getValue(line4, pointToCheck) <= 0) {
			return true;
		} else
			return false;
	}

	public static void main(String[] args) {
		System.out.println(
				isInside(new Point(0, 1), new Point(1, 8), new Point(2, 7), new Point(1, 1), new Point(1.2, 7)));
	}
}

class Line {
	double a;
	double b;
	double c;

	Line(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	static Line getLine(Point p1, Point p2) {
		// cy=ax+b
		double a = (p1.y - p2.y) / (p1.x - p2.x), b, c;
		if (Double.isNaN(a))
			throw new NumberFormatException("输入的两点有重合");
		else if (Double.isInfinite(a)) {
			a = 1;
			b = p1.x;
			c = 0;
		} else {
			b = (p1.x * p2.y - p2.x * p1.y) / (p1.x - p2.x);
			c = 1;
		}
		return new Line(a, b, c);
	}

	static double getValue(Line l, Point p) {
		return l.a * p.x + l.b - l.c * p.y;
	}
}