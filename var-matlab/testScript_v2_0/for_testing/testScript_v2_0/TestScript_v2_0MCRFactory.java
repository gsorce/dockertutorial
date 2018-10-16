/*
 * MATLAB Compiler: 6.3 (R2016b)
 * Date: Wed Oct 10 16:38:54 2018
 * Arguments: "-B" "macro_default" "-W" "java:testScript_v2_0,Class1" "-T" "link:lib" 
 * "-d" "C:\\Users\\Giuseppe Paterno\\Documents\\MATLAB\\testScript_v2_0\\for_testing" 
 * "class{Class1:C:\\OneDrive - Engineering Ingegneria Informatica 
 * S.p.A\\Engineering\\_INTEGRIDY\\Test Docker\\testScript_v2_0.m}" 
 */

package testScript_v2_0;

import com.mathworks.toolbox.javabuilder.*;
import com.mathworks.toolbox.javabuilder.internal.*;

/**
 * <i>INTERNAL USE ONLY</i>
 */
public class TestScript_v2_0MCRFactory
{
   
    
    /** Component's uuid */
    private static final String sComponentId = "testScript_v_CB267E14011CFFF0C729560CCA516A93";
    
    /** Component name */
    private static final String sComponentName = "testScript_v2_0";
    
   
    /** Pointer to default component options */
    private static final MWComponentOptions sDefaultComponentOptions = 
        new MWComponentOptions(
            MWCtfExtractLocation.EXTRACT_TO_CACHE, 
            new MWCtfClassLoaderSource(TestScript_v2_0MCRFactory.class)
        );
    
    
    private TestScript_v2_0MCRFactory()
    {
        // Never called.
    }
    
    public static MWMCR newInstance(MWComponentOptions componentOptions) throws MWException
    {
        if (null == componentOptions.getCtfSource()) {
            componentOptions = new MWComponentOptions(componentOptions);
            componentOptions.setCtfSource(sDefaultComponentOptions.getCtfSource());
        }
        return MWMCR.newInstance(
            componentOptions, 
            TestScript_v2_0MCRFactory.class, 
            sComponentName, 
            sComponentId,
            new int[]{9,1,0}
        );
    }
    
    public static MWMCR newInstance() throws MWException
    {
        return newInstance(sDefaultComponentOptions);
    }
}
