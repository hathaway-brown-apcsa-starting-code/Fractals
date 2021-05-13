
/**
 * Represents a complex number a + bi
 *
 * @author Michael Buescher and APCS-A @ Hathaway Brown
 * @version 2021-05-13
 */
public class Complex
{
    private double rPart;
    private double iPart;
    
    /**  No-arg constructor constructs the complex number 0 + 0i   */
    public Complex()
    {
        rPart = 0.0;
        iPart = 0.0;
    }
    
    /**  Constructor constructs the complex number a + bi   */
    public Complex(double a, double b)
    {
        rPart = a;
        iPart = b;
    }
    
    // ---------------------------------------------------------------
    //   Accessor methods
    // ---------------------------------------------------------------
    public double getReal()       { return rPart;  }
    public double getImaginary()  { return iPart;  }
    
    // ---------------------------------------------------------------
    //   Mutator methods
    // ---------------------------------------------------------------
    public void setReal(double x)      { rPart = x;  }
    public void setImaginary(double y) { iPart = y;  }
    
    // ---------------------------------------------------------------
    //   Calculation methods
    // ---------------------------------------------------------------
    
    /** Adds two complex numbers   */
    
    
    /** Multiplies two complex numbers    */
}
