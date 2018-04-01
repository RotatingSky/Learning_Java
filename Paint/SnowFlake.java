/**
 *	FileName:	SnowFlake.java
 *	@auther		Sny
 *	@date		2018-03-26
 *	@version	1.00
 *	@brief		Draw fractal like snowflake
 */

import java.awt.Graphics;
import java.awt.Color;

public class SnowFlake extends Fractal {
	/**
	 *	Draw snowflake curve function.
	 *	@param	x1
	 *	@param	y1
	 *	@param	x2
	 *	@param	y2
	 *	@param	depth
	 *	@return
	 */
	public void drawSnowFlake(int x1, int y1, int x2, int y2, int depth) {
		super.g.drawLine(x1, y1, x2, y2);
		if(depth <= 1) {
			return;
		}
		else {
			double x11 = (x1 * 2 + x2) / 3;
			double y11 = (y1 * 2 + y2) / 3;
			double x22 = (x1 + x2 * 2) / 3;
			double y22 = (y1 + y2 * 2) / 3;
			double x33 = (x11 + x22) / 2 - (y11 - y22) * Math.sqrt(3) / 2;
			double y33 = (y11 + y22) / 2 - (x22 - x11) * Math.sqrt(3) / 2;
			super.g.setColor(super.getBackground());
			super.g.drawLine((int)x1, (int)y1, (int)x2, (int)y2);
			super.g.setColor(Color.black);
			drawSnowFlake((int)x1, (int)y1, (int)x11, (int)y11, depth - 1);
			drawSnowFlake((int)x11, (int)y11, (int)x33, (int)y33, depth - 1);
			drawSnowFlake((int)x33, (int)y33, (int)x22, (int)y22, depth - 1);
			drawSnowFlake((int)x22, (int)y22, (int)x2, (int)y2, depth - 1);
		}
	}

	/**
	 *	Realization of abstract function of Fractal class.
	 *	@param
	 *	@return
	 */
	public void drawFractal() {
		super.g = super.getGraphics();
		drawSnowFlake(126, 200, 474, 200, 10);
		drawSnowFlake(474, 200, 300, 500, 10);
		drawSnowFlake(300, 500, 126, 200, 10);
	}

	/**
	 *	@param	args	Console parameters
	 *	@return
	 */
	public static void main(String[] args) {
		SnowFlake snowflake = new SnowFlake();
		snowflake.initWindow("Snow Flake");
		snowflake.drawFractal();
	}
}