import com.mathworks.toolbox.javabuilder.*;
import testScript_v2_0.*;

class getmagic
{
   public static void main(String[] args)
   {
      Object[] result = null;
      Class1 theMagic = null;


      try
      {
	System.out.println(System.getenv("MATLAB_INPUTFILE"));
   	System.out.println(System.getenv("MATLAB_OUTPUTFILE"));
        theMagic = new Class1();

         result = theMagic.testScript_v2_0();
      }
      catch (Exception e)
      {
         System.out.println("Exception: " + e.toString());
      }
      finally
      {
         theMagic.dispose();
      }
   }
}

