/**
 *	FileName:	Leaf.java
 *	@auther		Sny
 *	@date		2018-03-26
 *	@version	1.00
 *	@brief		Draw fractal like leaf
 */

import java.awt.Graphics;
import java.awt.Color;
import java.util.Random;

public class Leaf extends Fractal {
	// Define some constant value
	public static final double PI = Math.PI / 180;
	private static Random random = new Random();

	/**
	 *	Draw leaf figure.
	 *	@param	x
	 *	@param	y
	 *	@param	L
	 *	@param	a
	 *	@return
	 */
	public void drawLeaf(double x, double y, double L, double a) {
		int red = random.nextInt(127);
		int green = random.nextInt(127);
		int blue = random.nextInt(127);
		super.g.setColor(new Color(red, green, blue));
		double x1, x2, x1L, x2L, x2R, x1R;
		double y1, y2, y1L, y2L, y2R, y1R;
		float deflection = 50 -random.nextInt(20);
		float intersection = random.nextInt(40) - 20;
		float depth	= 2 + random.nextInt(2);
		float ratio = 3f;
		float ratio2 = 1.2f;
		if(L > depth) {
			x2 = x + L * Math.cos(a * PI);
			y2 = y + L * Math.sin(a * PI);
			x2R = x2 + L / ratio * Math.cos((a + deflection) * PI);
			y2R = y2 + L / ratio * Math.sin((a + deflection) * PI);
			x2L = x2 + L / ratio * Math.cos((a - deflection) * PI);
			y2L = y2 + L / ratio * Math.sin((a - deflection) * PI);
			x1 = x + L / ratio * Math.cos(a * PI);
			y1 = y + L / ratio * Math.sin(a * PI);
			x1L = x1 + L / ratio * Math.cos((a - deflection) * PI);
            y1L = y1 + L / ratio * Math.sin((a - deflection) * PI);
            x1R = x1 + L / ratio * Math.cos((a + deflection) * PI);
            y1R = y1 + L / ratio * Math.sin((a + deflection) * PI);
            super.g.drawLine((int)x, (int)y, (int)x2, (int)y2);
            super.g.drawLine((int)x2, (int)y2, (int)x2R, (int)y2R);
            super.g.drawLine((int)x2, (int)y2, (int)x2L, (int)y2L);
            super.g.drawLine((int)x1, (int)y1, (int)x1L, (int)y1L);
            super.g.drawLine((int)x1, (int)y1, (int)x1R, (int)y1R);
            drawLeaf(x2, y2, L / ratio2, a + intersection);
            drawLeaf(x2R, y2R, L / ratio, a + deflection);
            drawLeaf(x2L, y2L, L / ratio, a - deflection);
            drawLeaf(x1L, y1L, L / ratio, a - deflection);
            drawLeaf(x1R, y1R, L / ratio, a + deflection);
		}
	}

	/**
	 *	Realization of abstract function of Fractal class.
	 *	@param
	 *	@return
	 */
	public void drawFractal() {
		super.g = super.getGraphics();
		drawLeaf(300, 600, 100, 200 + random.nextInt(100));
	}

	/**
	 *	@param	args	Console parameters
	 *	@return
	 */
	public static void main(String[] args) {
		Leaf leaf = new Leaf();
		leaf.initWindow("Leaf");
		leaf.drawFractal();
	}
}