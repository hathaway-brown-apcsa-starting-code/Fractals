/**
 * Interface for a color map for Mandelbrot Set and Julia Set objects.
 *
 * @author Michael Buescher and APCS-A @ Hathaway Brown
 * @version 2021-05-13
 */

import java.awt.Color;

public interface ColorMap
{
    /** Returns the color for the inside of the Mandelbrot / Julia Set */
    public Color getInsideColor();
    
    /** Returns the color associated with escaping after n iterations  */
    public Color getColor (int n);
   
}
