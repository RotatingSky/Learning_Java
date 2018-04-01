/**
 *	FileName:	Mand.java
 *	@auther		Sny
 *	@date		2018-03-26
 *	@version	1.00
 *	@brief		Draw the mandaro fractal
 */

import java.awt.Graphics;
import java.awt.Color;

public class Mand extends Fractal {
	// Define the original complex number
	private static Complex z0 = new Complex(0, 0);

	/**
	 *	@param	z		Complex number to handle.
	 *	@param	maxIter	Maximum number of iteration.
	 *	@return int
	 */
	public int mand(Complex z, int maxIter) {
		Complex curComp = new Complex(0, 0);
		for(int i = 0; i < maxIter; ++i) {
			if(curComp.modulus() > 2)
				return i;
			curComp = curComp.mul(curComp).add(z);
		}
		return maxIter;
	}

	/**
	 *	Draw the mandaro fractal figure.
	 *	@param	z		Complex number to handle.
	 *	@param	scale	Scale of the figure.
	 *	@param	maxIter	Maximum number of iteration.
	 *	@return
	 */
	public void drawMand(Complex z, double scale, int maxIter) {
		double pixUnit = 3 / (600 * scale);
		double startX = z.re - 600 * pixUnit / 2;
		double startY = z.im - 600 * pixUnit / 2;
		for(int i = 0; i < 600; ++i) {
			for(int j = 0; j < 600; ++j) {
				double x0 = startX + i * pixUnit;
				double y0 = startY + j * pixUnit;
				Complex curComp = new Complex(x0, y0);
				int time = mand(curComp, maxIter);
				if(time == maxIter) {
					double x = x0 * 150 + 300;
					double y = y0 * 150 + 300;
					super.g.drawLine((int)x, (int)y, (int)x, (int)y);
				}
			}
		}
	}

	/**
	 *	Realization of abstract function of Fractal class.
	 *	@param
	 *	@return
	 */
	public void drawFractal() {
		super.g = super.getGraphics();
		drawMand(z0, 1.0, 100);
	}

	/**
	 *	@param	args	Console parameters
	 *	@return
	 */
	public static void main (String[] args) {
		Mand mandaro = new Mand();
		mandaro.initWindow("Mandaro");
		mandaro.drawFractal();
	}
}