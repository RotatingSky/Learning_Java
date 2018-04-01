/**
 *	FileName: Complex.java
 *	@auther		Sny
 *	@Date		2018-03-24
 *	@version	1.00
 */

public class Complex {

	public double re;
	public double im;

	/**
	 *	@param	real Real part of complex
	 *	@param	image Image part of complex
	 *	@return	Complex
	 */
	public Complex(double real, double image) {
		this.re = real;
		this.im = image;
	}

	/**
	 *	@param
	 *	@return	double
	 */
	public double modulus() {
		return Math.sqrt(re * re + im * im);
	}

	/**
	 *	@param
	 *	@return	double
	 */
	public double argument() {
		return Math.atan2(im, re);
	}

	/**
	 *	@param	z Complex number to add
	 *	@return	Complex
	 */
	public Complex add(Complex z) {
		double addRe = re + z.re;
		double addIm = im + z.im;
		return new Complex(addRe, addIm);
	}

	/**
	 *	@param	z Complex number to multiply
	 *	@return	Complex
	 */
	public Complex mul(Complex z) {
		double mulRe = re * z.re - im * z.im;
		double mulIm = im * z.re + re * z.im;
		return new Complex(mulRe, mulIm);
	}
}