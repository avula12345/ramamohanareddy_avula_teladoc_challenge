# ramamohanareddy_avula_teladoc_challenge
Teladoc API Challenge

**This project is a maven project with Cucumber framework to automate Rest API's.**

Automation of restfull api or webservices projects with Rest Assured
This also includes the extent reporting.

**Preconditions**
- Maven 
- Java 8
- Cucumber Eclipse plugin

**MAVEN_Dependencies**
Add the following dependencies to your pom.xml All below dependencies are compatible.

   <build>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>

            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-surefire-plugin</artifactId>
                <version>3.0.0-M1</version>
                <configuration>
                    <testFailureIgnore>true</testFailureIgnore>
                    <suiteXmlFiles>
                        <suiteXmlFile>src/test/resources/testng-xmls/API_TESTS.xml</suiteXmlFile>
                    </suiteXmlFiles>
                </configuration>
            </plugin>
        </plugins>
    </build>
    <dependencies>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>6.1.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-testng</artifactId>
            <version>6.1.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-picocontainer</artifactId>
            <version>6.1.1</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>commons-io</groupId>
            <artifactId>commons-io</artifactId>
            <version>2.7</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.dataformat</groupId>
            <artifactId>jackson-dataformat-yaml</artifactId>
            <version>2.11.0</version>
        </dependency>
        <dependency>
            <groupId>com.fasterxml.jackson.core</groupId>
            <artifactId>jackson-databind</artifactId>
            <version>2.11.0</version>
        </dependency>
        <dependency>
            <groupId>tech.grasshopper</groupId>
            <artifactId>extentreports-cucumber6-adapter</artifactId>
            <version>1.0.0</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.google.code.gson</groupId>
            <artifactId>gson</artifactId>
            <version>2.9.0</version>
        </dependency>
        <dependency>
            <groupId>org.slf4j</groupId>
            <artifactId>slf4j-nop</artifactId>
            <version>1.7.30</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.1.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>json-path</artifactId>
            <version>4.1.2</version>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>com.googlecode.json-simple</groupId>
            <artifactId>json-simple</artifactId>
            <version>1.1.1</version>
        </dependency>
        <dependency>
            <groupId>org.codehaus.groovy</groupId>
            <artifactId>groovy</artifactId>
            <version>2.5.8</version>
        </dependency>
        <dependency>
            <groupId>com.github.jknack</groupId>
            <artifactId>handlebars</artifactId>
            <version>4.1.0</version>
        </dependency>
    </dependencies>
    <properties>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>


**Steps to Run the project on local:**

1. Clone the projet - https://github.com/avula12345/ramamohanareddy_avula_teladoc_challenge.git to IntelliJ / Ecllipse
2. Compile the project with all the dependencies
3. Set SDK to 1.8 in IntelliJ

![image](https://user-images.githubusercontent.com/17126034/166627893-5f212438-f62e-4d2d-b9eb-bcd485f9dabf.png)

**4. Run the testrunner file located at - com/rest/runner/TestRunner/APITestRunner.java**

![image](https://user-images.githubusercontent.com/17126034/166628027-f2ee05db-57b8-45cf-a261-8000ee0378c1.png)


**6. After execution, extent report will be created at -  test-output folder**

![image](https://user-images.githubusercontent.com/17126034/166628115-3f00f568-2087-45c5-8780-3f79844efc06.png)

**Sample Extent Report:**

![image](https://user-images.githubusercontent.com/17126034/166628166-b973b436-e2ec-4826-a0ad-ffe952edf8fe.png)

