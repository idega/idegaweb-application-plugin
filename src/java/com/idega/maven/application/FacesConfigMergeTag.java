package com.idega.maven.application;

import java.io.File;
import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.idega.util.FacesConfigMerger;

/**
 * A Class to merge contents of many faces-config.xml's into one destination faces-config.xml file.
 * 
 * @author tryggvil
 *
 */
public class FacesConfigMergeTag extends TagSupport//BaseTagSupport
{
    /** log for debug output */
    //private static final Log log = LogFactory.getLog(BaseTagSupport.class);
	private static final Log log = LogFactory.getLog(TagSupport.class);
	
    /** the resources to copy */
    private String bundlesFolder;

    /** the file to merge into */
    private String toFile;

    /**
     * @see org.apache.commons.jelly.Tag#doTag(org.apache.commons.jelly.XMLOutput)
     */
    public void doTag(XMLOutput output) throws MissingAttributeException, JellyTagException
    {
        if (bundlesFolder == null){
        		throw new MissingAttributeException("bundlesFolder");
        }
        //System.out.println("doTag: bundlesFolder = " + bundlesFolder);
        if (toFile == null){
    			throw new MissingAttributeException("toFile");
        }
        //System.out.println("doTag: toFile = " + toFile);
        try{
	        FacesConfigMerger merger = new FacesConfigMerger();
	        merger.setOutputFile(new File(toFile));
	        merger.setBundlesFolder(new File(bundlesFolder));
	        merger.process();
        }
        catch(Exception e){
        		e.printStackTrace();
        }
    }

    /**
     * @param bundlesFoler the source bundles folder
     */
    public void setBundlesfolder(String bundlesFolder)
    {
		//System.out.println("setting bundlesFolder: "+bundlesFolder);
    		this.bundlesFolder=bundlesFolder;
    }

    /**
     * @param webXmlFilePath the directory to copy them to
     */
    public void setTofile(String xmlFilePath)
    {
    		//System.out.println("setting webXmlFilePath: "+webXmlFilePath);
    		toFile = xmlFilePath;
    }

}