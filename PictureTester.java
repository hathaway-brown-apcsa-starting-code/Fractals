/**
 * This class contains class (static) methods
 * that will help you test the Picture class 
 * methods.  Uncomment the methods and the code
 * in the main to test.
 * 
 * @author Barbara Ericson 
 */
public class PictureTester
{

public static void testSetBackground()
  {
      Picture flower = new Picture("moon-surface.jpg");
      flower.explore();
      flower.setBackground();
      flower.explore();
    }
    
public static void testSepia()
  {
      Picture myPic = new Picture("blueMotorcycle.jpg");
      myPic.explore();
      myPic.sepia();
      myPic.explore(); 
    }
//Goes in picture tester. Tests the method with the gorge image. 

  public static void testSaturate()
  {
      Picture myPic = new Picture ("gorge.jpg");
      myPic.explore();
      myPic.saturate();
      myPic.explore();
  }    
//method for PictureTester class
  public static void testMyMethod()
  {
    Picture test = new Picture("Julia_Running_small.jpg");
    test.explore();
    Picture bkg = new Picture("beach.jpg");
    test.merge(bkg);
    test.explore();
  }
  
    public static void testInvert()
    {
      Picture redMotorcycle = new Picture("butterfly1.jpg");
      redMotorcycle.explore();
      redMotorcycle.invert();
      redMotorcycle.explore();
    }
    
  /** Method to test mirrorKoala  */  
  public static void testMirrorKoala()
  {
      Picture koala = new Picture("koala.jpg");
      koala.explore();
      koala.mirrorKoala();
      koala.explore();
  }
  
    
  /** Method to test zeroBlue */
  public static void testZeroBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.zeroBlue();
    beach.explore();
  }
    
  /** Method to test keepOnlyBlue */
  public static void testKeepOnlyBlue()
  {
    Picture beach = new Picture("beach.jpg");
    beach.explore();
    beach.keepOnlyBlue();
    beach.explore();
  }
  
  /** Method to test mirrorVertical */
  public static void testMirrorVertical()
  {
    Picture caterpillar = new Picture("caterpillar.jpg");
    caterpillar.explore();
    caterpillar.mirrorVertical();
    caterpillar.explore();
  }
  
  /** Method to test mirrorTemple */
  public static void testMirrorTemple()
  {
    Picture temple = new Picture("temple.jpg");
    temple.explore();
    temple.mirrorTemple();
    temple.explore();
  }
  
  /** Method to test the collage method */
  public static void testCollage()
  {
    Picture canvas = new Picture("640x480.jpg");
    canvas.createCollage();
    canvas.explore();
  }
  
  /** Method to test edgeDetection */
  public static void testEdgeDetection()
  {
    Picture swan = new Picture("swan.jpg");
    swan.edgeDetection(10);
    swan.explore();
  }
  
  public static void testDoesWhat()
  {
    Picture motorcycle = new Picture("blueMotorcycle.jpg");
    motorcycle.explore();
    motorcycle.doesWhat();
    motorcycle.explore();
  }
      
  public static void testGreenScreen()
  {
    Picture myPic = new Picture("Julia_Running_small.jpg");
    Picture background = new Picture("moon-surface.jpg");
    myPic.explore();
    myPic.greenScreen(background);
    myPic.explore();
  }
      
  /** Main method for testing.  Every class can have a main
    * method in Java */
  public static void main(String[] args)
  {
    // uncomment a call here to run a test
    // and comment out the ones you don't want
    // to run
    testMirrorKoala();
    //testGreenScreen();
    //testDoesWhat();
    //testZeroBlue();
    //testKeepOnlyBlue();
    //testKeepOnlyRed();
    //testKeepOnlyGreen();
    //testNegate();
    //testGrayscale();
    //testFixUnderwater();
    //testMirrorVertical();
    //testMirrorTemple();
    //testMirrorArms();
    //testMirrorGull();
    //testMirrorDiagonal();
    //testCollage();
    //testCopy();
    //testEdgeDetection();
    //testEdgeDetection2();
    //testChromakey();
    //testEncodeAndDecode();
    //testGetCountRedOverValue(250);
    //testSetRedToHalfValueInTopHalf();
    //testClearBlueOverValue(200);
    //testGetAverageForColumn(0);
  }
}