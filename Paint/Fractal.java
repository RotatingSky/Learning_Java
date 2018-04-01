/**
 *	FileName:	Fractal.java
 *	@auther		Sny
 *	@date		2018-03-24
 *	@version	1.00
 *	@brief		An abstract class for drawing fractal figure.
 */

import java.awt.Graphics;
import javax.swing.JFrame;

public abstract class Fractal extends JFrame {
	
	// Define a protected for all child classes.
	protected Graphics g;

	/**
	 *	Initialize the frame window to show.
	 *	@param	frameName	The name of frame window.
	 *	@return
	 */
	protected void initWindow(String frameName) {
		this.setTitle(frameName);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	/**
	 *	An abstract function for all child classes to draw.
	 *	@param
	 *	@return
	 */
	public abstract void drawFractal();
}