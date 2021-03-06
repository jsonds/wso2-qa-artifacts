package com.wso2_apimanager;

import java.util.HashMap;
import java.util.List;

import com.virtusa.isq.vtaf.aspects.VTAFRecoveryMethods;
import com.virtusa.isq.vtaf.runtime.SeleniumTestBase;
import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import com.virtusa.isq.vtaf.runtime.VTAFTestListener;


/**
 *  Class ts_PublishAPIs implements corresponding test suite
 *  Each test case is a test method in this class.
 */

@Listeners (VTAFTestListener.class)
public class ts_PublishAPIs extends SeleniumTestBase {



    /**
     * Data provider for Test case tc_PrototypeAPIs.
     * @return data table
     */
    @DataProvider(name = "tc_PrototypeAPIs")
    public Object[][] dataTable_tc_PrototypeAPIs() {     	
    	return this.getDataTable("URLs","PrototypeAPIs");
    }

    /**
     * Data driven test case tc_PrototypeAPIs.
     *
     * @throws Exception the exception
     */
    @VTAFRecoveryMethods(onerrorMethods = {}, recoveryMethods = {}) 
    @Test (dataProvider = "tc_PrototypeAPIs")
    public final void tc_PrototypeAPIs(final String URLs_carbonURL, final String URLs_publisherURL, final String URLs_storeURL, final String PrototypeAPIs_domain, final String PrototypeAPIs_APIVersion, final String PrototypeAPIs_imagePath, final String PrototypeAPIs_UrlPattern, final String PrototypeAPIs_ApiNameOne, final String PrototypeAPIs_tagName) throws Exception {	
    	writeToReport("Start of TS PrototypeAPIs");
    	lib_Common.bc_PublisherLogin(this, URLs_publisherURL,PrototypeAPIs_domain);
    	lib_TestCase.APIM_23(this, PrototypeAPIs_APIVersion,PrototypeAPIs_UrlPattern,PrototypeAPIs_ApiNameOne,PrototypeAPIs_tagName,URLs_storeURL,PrototypeAPIs_domain);
    	//Retrive API Name
    	String varAPINameOnePrototype = retrieveString("keyAPINamePrototype");
    	lib_TestCase.APIM_25(this, varAPINameOnePrototype,URLs_storeURL,PrototypeAPIs_domain);
    	lib_TestCase.APIM_26(this, PrototypeAPIs_domain,varAPINameOnePrototype,URLs_storeURL);
    	lib_TestCase.APIM_27(this, PrototypeAPIs_tagName,URLs_storeURL,PrototypeAPIs_domain);
    	lib_Common.bc_DeleteAPI(this, varAPINameOnePrototype,URLs_publisherURL);
    	writeToReport("End of TS PrototypeAPIs");
    } 
    	

    public final Object[][] getDataTable(final String... tableNames) {
        String[] tables = tableNames;
        return this.getTableArray(getVirtualDataTable(tables));
    }

}