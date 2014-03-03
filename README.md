Groovy Beans
=
This project contains some simple examples of creating a Spring Application Context using the Groovy Bean Builder from Java, exposed via the [GenericGroovyApplicationContext](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/context/support/GenericGroovyApplicationContext.html) introduced to the Spring framework in version 4.0. 

Running the examples
---
All the examples are run from a JUnit test, [GroovyBeanBuilderTests](https://github.com/dturanski/groovy-beans/blob/master/src/test/java/org/springframework/samples/groovy/GroovyBeanBuilderTests.java). Each test initializes and verifies one of the Application Contexts found in the [config](https://github.com/dturanski/groovy-beans/blob/master/config) directory.

This may be run in gradle:

     $gradle test
  
Or from Intellij or Eclipse, e.g. run one of these gradle tasks before importing the project. 

	$gradle idea
or

	$gradle eclipse

Note: When running from Intellij, I have found it necessary to exclude groovy from the resource path:

      File->Preferences->Compiler
      
then add `;!?*.groovy` to Resource patterns



