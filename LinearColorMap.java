
/**
 * Creates a color map for Mandelbrot Set and Julia Set objects
 * based on a linear function.
 *
 * @author Michael Buescher and APCS-A @ Hathaway Brown
 * @version 2021-05-13
 */

import java.awt.Color;

public class LinearColorMap implements ColorMap
{
    private int initR, initG, initB;
    private int dR, dG, dB;
    private Color inside;
    
    /** Default ColorMap starts with red and gets progressively closer to yellow  */
    public LinearColorMap ()
    {
        inside = Color.BLACK;
        initR = 127;
        initG = 0;
        initB = 0;
        dR = 1;
        dG = 2;
        dB = 0;
    }
    
    /** Constructs a ColorMap with given initial and delta values  */
    public LinearColorMap (int iR, int iG, int iB, int dlR, int dlG, int dlB)
    {
        inside = Color.BLACK;
        initR = iR;
        initG = iG;
        initB = iB;
        dR = dlR;
        dG = dlG;
        dB = dlB;
    }   
    /** Returns the color for the inside of the Mandelbrot / Julia Set */
    public Color getInsideColor()
    {
        return inside;
    }
    
    /** Returns the color associated with escaping after n iterations  */
    public Color getColor (int n)
    {
        int red   = Math.min(255, initR + n * dR);
        int green = Math.min(255, initG + n * dG);
        int blue  = Math.min(255, initB + n * dB);
        return new Color (red, green, blue);
    }
    
}
