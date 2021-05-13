
/**
 * Creates a Julia Set.
 * Iterates z^2 + c for lots of points and draws a picture.
 *
 * @author Michael Buescher and APCS-A @ Hathaway Brown
 * @version 2021-05-13
 */
public class JuliaSet
{
    public static final int MAX_ITERATIONS = 127;
    public static final double MIN_REAL = -1.0;
    public static final double MAX_REAL =  1.0;
    public static final double MIN_IMAG = -1.0;
    public static final double MAX_IMAG =  1.0;
    
    public Complex c;
    
    public JuliaSet (Complex initC)
    {
        c = initC;
    }
    
    /** Determines the number of iterations before z escapes.
     *  Returns the number of iterations or -1 if 
     *    z does not escape before MAX_ITERATIONS.
     */
    public int calculatePoint (Complex z)
    {
        // This is a dummy method so far. Replace this with real calculations.
        return (int)(100 * (z.getReal() - MIN_REAL));
    }
        
    public void display()
    {
        int rows = 600;
        int cols = 600;
        double dReal = (MAX_REAL - MIN_REAL) / cols;
        double dImag = (MAX_IMAG - MIN_IMAG) / rows;
        
        Picture jSet = new Picture (rows, cols);
        Pixel[][] pixels = jSet.getPixels2D();
        ColorMap colors = new LinearColorMap();
        
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                double real = MIN_REAL + c * dReal;
                double imag = MIN_IMAG + r * dImag;
                int iterations = calculatePoint (new Complex (real, imag));
                if (iterations > MAX_ITERATIONS)
                {
                    pixels[r][c].setColor(colors.getInsideColor());
                }
                else
                {
                    pixels[r][c].setColor(colors.getColor(iterations));
                }
            }
        }
        
        jSet.explore();
    }
    
    
    /** for testing  */
    public static void main (String[] args)
    {
        JuliaSet j = new JuliaSet (new Complex (0.1, 0.4));
        j.display();
    }
}
