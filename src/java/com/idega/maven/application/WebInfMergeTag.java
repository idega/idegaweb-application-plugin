package com.idega.maven.application;


import java.io.File;

import org.apache.commons.jelly.JellyTagException;
import org.apache.commons.jelly.MissingAttributeException;
import org.apache.commons.jelly.TagSupport;
import org.apache.commons.jelly.XMLOutput;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.idega.util.BundleFileMerger;

/**
 * A tag to copy resources to a given directory
 * 
 * @author tryggvil
 *
 */
public class WebInfMergeTag extends TagSupport//BaseTagSupport
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
	        BundleFileMerger merger = new BundleFileMerger();
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
    public void setTofile(String webXmlFilePath)
    {
    		//System.out.println("setting webXmlFilePath: "+webXmlFilePath);
    		toFile = webXmlFilePath;
    }

}