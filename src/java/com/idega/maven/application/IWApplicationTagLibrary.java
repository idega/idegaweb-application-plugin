/*
 * Created on 6.7.2004
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package com.idega.maven.application;

import org.apache.commons.jelly.TagLibrary;

/**
 * @author tryggvil
 *
 */
public class IWApplicationTagLibrary extends TagLibrary {

	
	public IWApplicationTagLibrary(){
		registerTag("mergewebxmls",WebXmlMergeTag.class);
		registerTag("mergefacesconfigs",FacesConfigMergeTag.class);
	}
	
}
