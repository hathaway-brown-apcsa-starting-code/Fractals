import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture.  This class inherits from 
 * SimplePicture and allows the student to add functionality to
 * the Picture class.  
 * 
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture 
{
  ///////////////////// constructors //////////////////////////////////
  
  /**
   * Constructor that takes no arguments 
   */
  public Picture ()
  {
    /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
     */
    super();  
  }
  
  /**
   * Constructor that takes a file name and creates the picture 
   * @param fileName the name of the file to create the picture from
   */
  public Picture(String fileName)
  {
    // let the parent class handle this fileName
    super(fileName);
  }
  
  /**
   * Constructor that takes the width and height
   * @param height the height of the desired picture
   * @param width the width of the desired picture
   */
  public Picture(int height, int width)
  {
    // let the parent class handle this width and height
    super(width,height);
  }
  
  /**
   * Constructor that takes a picture and creates a 
   * copy of that picture
   * @param copyPicture the picture to copy
   */
  public Picture(Picture copyPicture)
  {
    // let the parent class do the copy
    super(copyPicture);
  }
  
  /**
   * Constructor that takes a buffered image
   * @param image the buffered image to use
   */
  public Picture(BufferedImage image)
  {
    super(image);
  }
  
  ////////////////////// methods ///////////////////////////////////////
  
  /**
   * Method to return a string with information about this picture.
   * @return a string with information about the picture such as fileName,
   * height and width.
   */
  public String toString()
  {
    String output = "Picture, filename " + getFileName() + 
      " height " + getHeight() 
      + " width " + getWidth();
    return output;
    
  }
  
  /** Method to set the blue to 0 */
  public void zeroBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setBlue(0);
      }
    }
  }
  
  public void invert()
{
  Pixel[][] pixels = this.getPixels2D();
  for (int r = 0; r < pixels.length; r++)
  {
    for (int c = 0; c < pixels[0].length - 1; c++)
    {
      //checks if there's a contrast between this pixel and the one right next to it
      //if so, the pixel is changed to black (creates the image outline)
      if ((pixels[r][c].getBlue() - pixels[r][c + 1].getBlue()) > 5 &&
          (pixels[r][c].getRed() - pixels[r][c + 1].getRed()) > 5 &&
          (pixels[r][c].getGreen() - pixels[r][c + 1].getGreen()) > 5)
      {
          pixels[r][c].setColor(Color.BLACK);
      }
      //if not, the pixel color is inverted
      else
      {
          pixels[r][c].setBlue(255-pixels[r][c].getBlue());
          pixels[r][c].setRed(255-pixels[r][c].getRed());
          pixels[r][c].setGreen(255-pixels[r][c].getGreen());
      }
    }
  }
}
  
  /** Method to keep only the blue values */
  public void keepOnlyBlue()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        pixelObj.setRed(0);
        pixelObj.setGreen(0);
      }
    }
  }
  
  public void mirrorKoala()
  {
      Pixel[][] pixels = this.getPixels2D();
      for (int row = 0; row < pixels.length; row++)
      {
          int rowLen = pixels[row].length;
          for (int col = 0; col < pixels[row].length / 2; col++)
          {
              Color left = pixels[row][col].getColor();
              Color right = pixels[row][rowLen - 1 - col].getColor();
              pixels[row][col].setColor(right);
              pixels[row][rowLen - 1 - col].setColor(left);
          }
      }
  }
  
  public void doesWhat()
    {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        int avg = (pixelObj.getRed() + pixelObj.getBlue()
                    + pixelObj.getGreen()) / 3;
        
        pixelObj.setRed(avg);
        pixelObj.setGreen(avg);
        pixelObj.setBlue(avg);
      }
    }
  }
  
  /** Method to tell whether a Pixel is green  */
  public boolean isGreen (Pixel p)
  {
      //if (p.getGreen() > p.getRed()  && p.getGreen() - p.getBlue() > 10)
      //if (p.getGreen() > 90 && p.getBlue() < 120 && p.getRed() < 170)
      if (p.getGreen() > 90 && 
          ((1.0 *p.getGreen()) / p.getRed() > 1.5) &&
          ((1.0 *p.getGreen()) / p.getBlue() > 1.5))
      {
        return true;
      }
      else
      {
        return false;
      }
  }
  
  /** Method to manipulate a Green Screen image
   * 
   * PRECONDITION: background picture dimensions >= this picture dimensions
   */
  public void greenScreen(Picture background)
  {
      Pixel[][] pixels = this.getPixels2D();
      Pixel[][] bgPix = background.getPixels2D();
      int numRows = pixels.length;
      int numCols = pixels[0].length;
      
      for (int r = 0; r < numRows; r++)
      {
          for (int c = 0; c < numCols; c++)
          {
              if (isGreen(pixels[r][c]))
              {
                  pixels[r][c].setColor(bgPix[r][c].getColor());
              }
          }
      }
  }
  
  
  /** Method that mirrors the picture around a 
    * vertical mirror in the center of the picture
    * from left to right */
  public void mirrorVertical()
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int width = pixels[0].length;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < width / 2; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][width - 1 - col];
        rightPixel.setColor(leftPixel.getColor());
      }
    } 
  }
  
  /** Mirror just part of a picture of a temple */
  public void mirrorTemple()
  {
    int mirrorPoint = 276;
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    int count = 0;
    Pixel[][] pixels = this.getPixels2D();
    
    // loop through the rows
    for (int row = 27; row < 97; row++)
    {
      // loop from 13 to just before the mirror point
      for (int col = 13; col < mirrorPoint; col++)
      {
        
        leftPixel = pixels[row][col];      
        rightPixel = pixels[row]                       
                         [mirrorPoint - col + mirrorPoint];
        rightPixel.setColor(leftPixel.getColor());
      }
    }
  }
  
  /** copy from the passed fromPic to the
    * specified startRow and startCol in the
    * current picture
    * @param fromPic the picture to copy from
    * @param startRow the start row to copy to
    * @param startCol the start col to copy to
    */
  public void copy(Picture fromPic, 
                 int startRow, int startCol)
  {
    Pixel fromPixel = null;
    Pixel toPixel = null;
    Pixel[][] toPixels = this.getPixels2D();
    Pixel[][] fromPixels = fromPic.getPixels2D();
    for (int fromRow = 0, toRow = startRow; 
         fromRow < fromPixels.length &&
         toRow < toPixels.length; 
         fromRow++, toRow++)
    {
      for (int fromCol = 0, toCol = startCol; 
           fromCol < fromPixels[0].length &&
           toCol < toPixels[0].length;  
           fromCol++, toCol++)
      {
        fromPixel = fromPixels[fromRow][fromCol];
        toPixel = toPixels[toRow][toCol];
        toPixel.setColor(fromPixel.getColor());
      }
    }   
  }

  /** Method to create a collage of several pictures */
  public void createCollage()
  {
    Picture flower1 = new Picture("flower1.jpg");
    Picture flower2 = new Picture("flower2.jpg");
    this.copy(flower1,0,0);
    this.copy(flower2,100,0);
    this.copy(flower1,200,0);
    Picture flowerNoBlue = new Picture(flower2);
    flowerNoBlue.zeroBlue();
    this.copy(flowerNoBlue,300,0);
    this.copy(flower1,400,0);
    this.copy(flower2,500,0);
    this.mirrorVertical();
    this.write("collage.jpg");
  }
  
  //method for Picture class
  public void merge(Picture background)
  {
    Pixel[][] pixels = this.getPixels2D();
    Pixel[][] bkg = background.getPixels2D();
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; col < pixels[0].length; col++)
      {
        if ((row % 2 == 0 && col % 2 == 0)||(row % 2 != 0 && col % 2 != 0))
        {
         pixels[row][col].setRed(bkg[row][col].getRed());
         pixels[row][col].setBlue(bkg[row][col].getBlue());
         pixels[row][col].setGreen(bkg[row][col].getGreen());
        }
      }
    }
  }
    

//Goes in the picture class. Increases the amount of the dominant color (RBG) 
// and decreases the other two. This saturates the image. 
public void saturate()
  {
    Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
    {
      for (Pixel pixelObj : rowArray)
      {
        if (pixelObj.getGreen() > pixelObj.getBlue() && pixelObj.getGreen() > pixelObj.getRed())
              {
                  pixelObj.setGreen(pixelObj.getGreen() + 20);
                  pixelObj.setBlue(pixelObj.getBlue() - 20);
                  pixelObj.setRed(pixelObj.getRed() - 20);
                }
        else if (pixelObj.getBlue() > pixelObj.getRed() && pixelObj.getBlue() > pixelObj.getGreen())
              {
                  pixelObj.setBlue(pixelObj.getBlue() + 20);
                  pixelObj.setGreen(pixelObj.getGreen() - 20);
                  pixelObj.setRed(pixelObj.getRed() - 20);
                }
        else 
              {
                  pixelObj.setRed(pixelObj.getRed() + 20);
                  pixelObj.setGreen(pixelObj.getGreen() - 20);
                  pixelObj.setBlue(pixelObj.getBlue() - 20);
                }
      }
    }
  }

  
//belongs to the picture class; takes the values of the original RGB values of a pixel, puts them through a formula to calculate the new values, and then assigns the new values to the pixel

public void sepia()
    {
        Pixel [][] pixels = this.getPixels2D();
        int numRows = pixels.length;
        int numCols= pixels[0].length;
        //are variables for recording new values for RGB
        int red;
        int green;
        int blue;
        //are variables for recording original RGB values
        int or;
        int og;
        int ob;
        
        //for loops go over every pixel in the image and change the RGB values
        for (int r = 0; r < numRows; r++)
        {
            for(int c = 0; c < numCols; c++)
            {  
                //stores original RGB values for the new pixel
                or = pixels[r][c].getRed();
                og = pixels[r][c].getGreen();
                ob = pixels[r][c].getBlue();
                //calculates new RGB values to convert to sepia and stores it
                //also casts the calculation to int 
                red = (int)((or * 0.393) + (og * 0.769) + (ob * 0.189));
                green = (int)((or * 0.349) + (og * 0.686) + (ob * 0.168));
                blue = (int)((or * 0.272) + (og * 0.543) + (ob * 0.131));
                
                //test conditions in case a calculated value is above 225
                //if it is, then the set value will be 225.
                //if not, the new value is used
                if(red > 225)
                {
                 pixels[r][c].setRed(225);   
            }
            else
            {
                pixels[r][c].setRed(red);
            }
            if(green > 225)
                {
                 pixels[r][c].setGreen(225);   
            }
            else
            {
                pixels[r][c].setGreen(green);
            }
            if(blue > 225)
                {
                 pixels[r][c].setBlue(225);   
            }
            else
            {
                pixels[r][c].setBlue(blue);
            }
        }
    }
}

public void setBackground()
{
  Pixel[][] pixels = this.getPixels2D();
    for (Pixel[] rowArray : pixels)
      {
      for (Pixel pixelObj : rowArray)
        {
          //checks if the color values are equal to see if they're white
            if (pixelObj.getGreen()==(pixelObj.getRed()) && pixelObj.getRed()==(pixelObj.getBlue()))
            {
              pixelObj.setColor(Color.CYAN);
            }
            //checks the differences of the colors from white
            if (pixelObj.colorDistance(Color.WHITE) < 38)
            {
              pixelObj.setColor(Color.CYAN);
            }
        }
    }      
}

  /** Method to show large changes in color 
    * @param edgeDist the distance for finding edges
    */
  public void edgeDetection(int edgeDist)
  {
    Pixel leftPixel = null;
    Pixel rightPixel = null;
    Pixel[][] pixels = this.getPixels2D();
    Color rightColor = null;
    for (int row = 0; row < pixels.length; row++)
    {
      for (int col = 0; 
           col < pixels[0].length-1; col++)
      {
        leftPixel = pixels[row][col];
        rightPixel = pixels[row][col+1];
        rightColor = rightPixel.getColor();
        if (leftPixel.colorDistance(rightColor) > 
            edgeDist)
          leftPixel.setColor(Color.BLACK);
        else
          leftPixel.setColor(Color.WHITE);
      }
    }
  }
  
  
  /* Main method for testing - each class in Java can have a main 
   * method 
   */
  public static void main(String[] args) 
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
  
} // this } is the end of class Picture, put all new methods before this
