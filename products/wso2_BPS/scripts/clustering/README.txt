This script can be use to download and extract build and copy config files to 1 Manager and 2 worker nodes. The script initially ask the user confirmation for the build date ($bdate) should be provided in the format XX-MMM e.g. 7jan.

If require user can download the build by providing the url. Then it will be downloaded to PACK_DIR ("/home/wso2/4.2.0/packs/""$bdate")

The conf files provided for boh MySQL and Oracle. before running the script relevant db conf should be copied and rename as conf is a must.

The script & relevant conf files should be copied to all nodes before running it.


The directory structures are hard-coded. Therefore any change in installation directory then script should be updated.

Due to file size upload issue the following files removed but require for the script. Please copy to the conf and ran the script.

Oracle:

├───Mgr
│   │   
│   ├───dropins (svnkit-bundle-1.0.0.jar)
|   |	
│   └───lib (ojdbc6.jar)
└───Wrk1
|   │   
|   ├───dropins (svnkit-bundle-1.0.0.jar)
|   |	
|   └───lib (ojdbc6.jar)
└───Wrk2
    │   
    ├───dropins (svnkit-bundle-1.0.0.jar)
    |	
    └───lib (ojdbc6.jar)


MySQL:

├───Mgr
│   │   
│   ├───dropins (svnkit-bundle-1.0.0.jar)
|   |	
│   └───lib (mysql-connector-java-5.1.18-bin.jar)
└───Wrk1
|   │   
|   ├───dropins (svnkit-bundle-1.0.0.jar)
|   |	
|   └───lib (ojdbc6.jar)
└───Wrk2
    │   
    ├───dropins (svnkit-bundle-1.0.0.jar)
    |	
    └───lib (ojdbc6.jar)