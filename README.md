Webengage- Sample Application 
==============================================================

System Requirements
-------------------

The application this project produces is designed to be run on Red Hat JBoss Enterprise Application Platform (EAP) 6.1 or 
later with the Red Hat JBoss Web Framework Kit (WFK) 2.7.

To run the webengage with the provided build script, you need the following:

1. Java 1.6, to run JBoss and Maven. You can choose from the following:
    * OpenJDK
    * Oracle Java SE
    * Oracle JRockit

2. Maven 3.0.0 or later, to build and deploy the examples
    * If you have not yet installed Maven, see the [Maven Getting Started Guide](http://maven.apache.org/guides/getting-started/index.html) for details.
    * If you have installed Maven, you can check the version by typing the following in a command line:

            mvn --version 

3. The JBoss EAP distribution ZIP.
    * For information on how to install and run JBoss, refer to the product documentation.


Configure Maven
---------------




Start the JBoss EAP Server
-------------------------

1. Open a command line and navigate to the root of the JBoss EAP directory.
2. The following shows the command line to start the server:

        For Linux:   EAP_HOME/bin/standalone.sh
        For Windows: EAP_HOME\bin\standalone.bat

Create Database and run the script
---------------
1. Install MySQL database and create a schema hrmsdb
2. Create tables in hrmsdb schema using tables.sql and 
  run the insert statements to create seed data
  
Create Container managed datasource
---------------
 1. Create container managed datasource to connect to hrmsdb and name it java:/hrmsDataSource
 
Build and Deploy the Webengage
-------------------------

_1. Make sure you have started the JBoss EAP server as described above.
2. Open a command line and navigate to the root directory of this webengage project.
3. Type this command to build and deploy the archive:

        mvn clean install jboss-as:deploy

4. This will deploy `target/webengage.war` to the running instance of the server.


Access the application
----------------------

The application will be running at the following URL: http://localhost:8080/webengage

Run the Junit Tests
----------------------
1. The Junit tests can be found in the package com.webengage.hrms.test. 
2. Run them as Junit tests



