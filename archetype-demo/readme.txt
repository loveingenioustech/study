
Example:

create a custom archetype
mvn archetype:create -DgroupId=demo -DartifactId=archetype-demo -DarchetypeArtifactId=maven-archetype-archetype

create a project based on custom archetype
mvn archetype:create -DgroupId=demo -DartifactId=temp1 -Dpackage=demo -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=demo -DarchetypeArtifactId=archetype-demo -DarchetypeVersion=1.0

Ref:
使用maven2自定义项目结构创建项目

1. 首先使用命令：

mvn archetype:create -DgroupId=lb.flex -DartifactId=flex-spring-hibernate-archetype -DarchetypeArtifactId=maven-archetype-archetype

创建一个基本原型 arche type。

该命令在当前目录创建了一个名为 flex-spring-hibernate-archetype 的 maven项目，具有 src目录和 pom.xml文件。


2. 然后修改 archetype descriptor文件 archetype.xml，在 \flex-spring-hibernate-archetype\src\main\resources\META-INF\maven 目录下：

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">
  <modelVersion>4.0.0</modelVersion>
  <groupId>lb.flex</groupId>
  <artifactId>flex-spring-hibernate-archetype</artifactId>
  <version>1.0</version>
  <name>Archetype - flex-spring-hibernate-archetype</name>
  <url>http://maven.apache.org</url>
 
  <build>

    <defaultGoal>install</defaultGoal>

          <extensions>
               <extension>
                    <groupId>org.apache.maven.wagon</groupId>
                    <artifactId>wagon-webdav</artifactId>
                    <version>1.0-beta-2</version>
               </extension>
          </extensions>


      <plugins>
             <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-javadoc-plugin</artifactId>
                    <configuration>
                         <javadocVersion>1.5</javadocVersion>
                         <excludePackageNames>com.jaxen</excludePackageNames>
                    </configuration>
               </plugin>
               <plugin>
                    <groupId>org.apache.maven.plugins</groupId>
                    <artifactId>maven-release-plugin</artifactId>
                    <configuration>
                         <!-- <goals>source:jar javadoc:jar deploy site:site site:deploy changes:announcement-generate</goals> -->
                         <goals>source:jar deploy</goals>
                    </configuration>
               </plugin>
               <plugin>
                    <artifactId>maven-clean-plugin</artifactId>
                    <configuration>
                         <filesets>
                              <fileset>
                                   <directory>.</directory>
                                   <includes>
                                        <include>velocity*.log*</include>
                                        <include>res</include>
                                   </includes>
                                   <followSymlinks>false</followSymlinks>
                              </fileset>
                         </filesets>
                    </configuration>
               </plugin>

      <plugin>
                    <artifactId>maven-compiler-plugin</artifactId>
                    <version>2.0.2</version>
                    <configuration>
                         <source>1.5</source>
                         <target>1.5</target>
                    </configuration>
               </plugin>
               <plugin>
                    <artifactId>maven-eclipse-plugin</artifactId>
                    <version>2.4</version>
                    <configuration>
                         <additionalProjectnatures>
                              <projectnature>
                                   org.springframework.ide.eclipse.core.springnature
                              </projectnature>
                         </additionalProjectnatures>
                         <additionalBuildcommands>
                              <buildcommand>
                                   org.springframework.ide.eclipse.core.springbuilder
                              </buildcommand>
                         </additionalBuildcommands>
                         <downloadSources>true</downloadSources>
                         <downloadJavadocs>true</downloadJavadocs>
                         <wtpversion>1.5</wtpversion>
                    </configuration>
               </plugin>
      <plugin>
                    <groupId>org.codehaus.mojo</groupId>
                    <artifactId>hibernate3-maven-plugin</artifactId>
                    <version>2.1</version>
                    <dependencies>
                         <dependency>
                              <groupId>${jdbc.groupId}</groupId>
                              <artifactId>${jdbc.artifactId}</artifactId>
                              <version>${jdbc.version}</version>
                         </dependency>
                    </dependencies>
               </plugin>

               <plugin>
                    <groupId>org.mortbay.jetty</groupId>
                    <artifactId>maven-jetty-plugin</artifactId>
                    <version>6.1.19</version>
                    <configuration>
                         <contextPath>/usermanager</contextPath>
                         <systemProperties>
                           <systemProperty>
                                  <name>MAVEN_OPTS</name>
                                   <value>"-Xms512m -Xmx1024m -XX:MaxPermSize=384m"</value>
                           </systemProperty>
                           <systemProperty>
                                  <name>JVM-ARG</name>
                                   <value>"-XX:MaxPermSize=386m"</value>
                           </systemProperty>
                           <systemProperty>
                                  <name>JAVA_OPTS</name>
                                   <value>"-Xms512m -Xmx1024m"</value>
                           </systemProperty>
                           <!-- <jvm-arg>-XX:MaxPermSize=256m</jvm-arg> -->

                        </systemProperties>
                         <scanIntervalSeconds>4</scanIntervalSeconds>
                         <connectors>
                      <connector implementation="org.mortbay.jetty.nio.SelectChannelConnector">
                        <port>8080</port>
                        <maxIdleTime>60000</maxIdleTime>
                      </connector>
                    </connectors>
                         <scanTargetPatterns>
                              <scanTargetPattern>
                                   <directory>
                                        src/main/webapp/WEB-INF
                                   </directory>
                                   <excludes>
                                        <exclude>**/*.jsp</exclude>
                                   </excludes>
                                   <includes>
                                        <include>**/*.properties</include>
                                        <include>**/*.xml</include>
                                   </includes>
                              </scanTargetPattern>
                         </scanTargetPatterns>
                         <maxIdleTime>0</maxIdleTime>
                    </configuration>
               </plugin>
               <plugin>
                    <artifactId>maven-war-plugin</artifactId>
                    <version>2.0.2</version>
                    <configuration>
                         <dependentWarExcludes>
                              **/jdbc.properties,**/hibernate.cfg.xm,**/sql-map-config.xml,**/web.xml,WEB-INF/classes/META-INF/**
                         </dependentWarExcludes>
                    </configuration>
               </plugin>
        </plugins>
        <resources>
               <resource>
                    <directory>src/main/resources</directory>
                    <excludes>
                         <exclude>applicationContext-*.xml</exclude>
                    </excludes>
                    <filtering>true</filtering>
               </resource>
               <resource>
                    <directory>src/main/resources</directory>
                    <includes>
                         <include>applicationContext-*.xml</include>
                    </includes>
                    <filtering>false</filtering>
               </resource>
          </resources>
          <testResources>
               <testResource>
                    <directory>src/test/resources</directory>
                    <filtering>true</filtering>
               </testResource>
               <testResource>
                    <directory>src/main/webapp</directory>
                    <filtering>true</filtering>
                    <includes>
                         <include>**/*.xml</include>
                         <include>**/*.xsd</include>
                    </includes>
               </testResource>
          </testResources>
    </build>
   
  <repositories>
          <repository>
              <id>thirdparty</id>
              <url>http://localhost:8081/nexus/content/repositories/thirdparty</url>
          </repository>
     </repositories>
    
     <dependencies>
          <dependency>
               <groupId>junit</groupId>
               <artifactId>junit</artifactId>
               <version>4.4</version>
               <scope>test</scope>
          </dependency>
          <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring</artifactId>
               <version>2.5.6</version>
          </dependency>
          <dependency>
               <groupId>org.springframework</groupId>
               <artifactId>spring-test</artifactId>
               <version>2.5.6</version>
               <optional>true</optional>
          </dependency>
          <dependency>
               <groupId>org.springframework.security</groupId>
               <artifactId>spring-security-core</artifactId>
               <version>2.0.4</version>
          </dependency>
          <dependency>
              <groupId>org.springframework.flex</groupId>
              <artifactId>spring-flex</artifactId>
              <version>1.0.1.RELEASE</version>
          </dependency>
          <dependency>
               <groupId>org.aspectj</groupId>
               <artifactId>aspectjrt</artifactId>
               <version>1.5.4</version>
          </dependency>
          <dependency>
               <groupId>org.aspectj</groupId>
               <artifactId>aspectjweaver</artifactId>
               <version>1.5.4</version>
          </dependency>
          <dependency>
               <groupId>net.sf.ehcache</groupId>
               <artifactId>ehcache</artifactId>
               <version>${ehcache.version}</version>
          </dependency>
          <dependency>
               <groupId>org.hibernate</groupId>
               <artifactId>hibernate</artifactId>
               <version>3.2.6.ga</version>
               <exclusions>
                    <exclusion>
                         <artifactId>ehcache</artifactId>
                         <groupId>net.sf.ehcache</groupId>
                    </exclusion>
                    <exclusion>
                         <artifactId>commons-collections</artifactId>
                         <groupId>commons-collections</groupId>
                    </exclusion>
               </exclusions>
          </dependency>
          <dependency>
               <groupId>org.hibernate</groupId>
               <artifactId>hibernate-annotations</artifactId>
               <version>3.3.0.ga</version>
          </dependency>
          <dependency>
               <groupId>org.hibernate</groupId>
               <artifactId>hibernate-commons-annotations</artifactId>
               <version>3.3.0.ga</version>
          </dependency>
          <dependency>
               <groupId>com.adobe.blazeds</groupId>
               <artifactId>blazeds-common</artifactId>
               <version>3.2.0.3978</version>
          </dependency>
          <dependency>
               <groupId>com.adobe.blazeds</groupId>
               <artifactId>blazeds-core</artifactId>
               <version>3.2.0.3978</version>
          </dependency>
          <dependency>
               <groupId>com.adobe.blazeds</groupId>
               <artifactId>blazeds-remoting</artifactId>
               <version>3.2.0.3978</version>
          </dependency>
          <dependency>
               <groupId>backport-util-concurrent</groupId>
               <artifactId>backport-util-concurrent</artifactId>
               <version>3.1</version>
          </dependency>
          <dependency>
               <groupId>javax.servlet</groupId>
               <artifactId>servlet-api</artifactId>
               <version>2.5</version>
               <scope>provided</scope>
          </dependency>
          <dependency>
               <groupId>mysql</groupId>
               <artifactId>mysql-connector-java</artifactId>
               <version>5.1.6</version>
               <type>jar</type>
               <scope>compile</scope>
          </dependency>
          <dependency>
               <groupId>com.oracle</groupId>
               <artifactId>classes12</artifactId>
               <version>10.2.0.2.0</version>
          </dependency>
          <dependency>
               <groupId>commons-dbcp</groupId>
               <artifactId>commons-dbcp</artifactId>
               <version>1.2.2</version>
          </dependency>
          <dependency>
               <groupId>jmock</groupId>
               <artifactId>jmock</artifactId>
               <version>1.1.0</version>
               <optional>true</optional>
          </dependency>
          <dependency>
               <groupId>org.jmock</groupId>
               <artifactId>jmock-junit4</artifactId>
               <version>2.4.0</version>
               <scope>test</scope>
          </dependency>
          <dependency>
               <groupId>org.dbunit</groupId>
               <artifactId>dbunit</artifactId>
               <version>2.2</version>
          </dependency>
          <dependency>
               <groupId>log4j</groupId>
               <artifactId>log4j</artifactId>
               <version>1.2.13</version>
          </dependency>
          <dependency>
               <groupId>commons-io</groupId>
               <artifactId>commons-io</artifactId>
               <version>1.3.1</version>
          </dependency>
          <dependency>
           <groupId>javax.mail</groupId>
           <artifactId>mail</artifactId>
           <version>${javax.mail.version}</version>
         </dependency>
         <dependency>
           <groupId>xom</groupId>
           <artifactId>xom</artifactId>
           <version>${xom.version}</version>
         </dependency>
         <dependency>
               <groupId>javax.servlet</groupId>
               <artifactId>jstl</artifactId>
               <version>${jstl.version}</version>
          </dependency>
          <dependency>
               <groupId>taglibs</groupId>
               <artifactId>standard</artifactId>
               <version>${jstl.version}</version>
          </dependency>
          <dependency>
               <groupId>velocity</groupId>
               <artifactId>velocity</artifactId>
               <version>${velocity.version}</version>
          </dependency>
     </dependencies>
    
     <properties>
       <jdbc.groupId>mysql</jdbc.groupId>
          <jdbc.artifactId>mysql-connector-java</jdbc.artifactId>
          <jdbc.version>5.1.5</jdbc.version>
          <jdbc.driverClassName>
               com.mysql.jdbc.Driver
          </jdbc.driverClassName>
          <jdbc.url><![CDATA[jdbc\:mysql\://localhost\:3306/apress_usermanager?createDatabaseIfNotExist\=true&amp;useUnicode\=true&amp;characterEncoding\=utf-8&amp;enableQueryTimeouts\=false]]></jdbc.url>
          <jdbc.username>root</jdbc.username>
          <jdbc.password></jdbc.password>
          <hibernate.dialect>
               org.hibernate.dialect.MySQL5InnoDBDialect
          </hibernate.dialect>

<!--            <jdbc.groupId>com.oracle</jdbc.groupId>-->
<!--          <jdbc.artifactId>classes12</jdbc.artifactId>-->
<!--          <jdbc.version>10.2.0.2.0</jdbc.version>-->
<!--          <jdbc.driverClassName>-->
<!--               oracle.jdbc.driver.OracleDriver-->
<!--          </jdbc.driverClassName>-->
<!--          <jdbc.url><![CDATA[jdbc:oracle:thin:@localhost:1521:LONGBIN]]></jdbc.url>-->
<!--          <jdbc.username>lbbm</jdbc.username>-->
<!--          <jdbc.password>lbbm</jdbc.password>-->
<!--          <hibernate.dialect>-->
<!--               org.hibernate.dialect.Oracle10gDialect-->
<!--          </hibernate.dialect>-->
         
             <ehcache.version>1.3.0</ehcache.version>
               <javax.mail.version>1.4</javax.mail.version>
             <xom.version>1.1d2</xom.version>
             <jstl.version>1.1.2</jstl.version>
             <velocity.version>1.4</velocity.version>
     </properties>  
</project>


这里面不能指定空的目录，只能指定单个的文件。 resources目录会作为默认目录创建。


3. 然后再修改模板 pom.xml 文件，该文件会作为以后项目生成时的模板，只要把根目录下的POM的稍作修改即可
  <groupId>${groupId}</groupId>
  <artifactId>${artifactId}</artifactId>
  <version>${version}</version>

它们将被创建项目时指定的值代替。


4. 准备资源，修改Java源文件，删除java文件的包声明。

这里为了方便，可以把要创建的 archetype指定一个简单的版本号，默认为 1.0-SNAPSHOT。

修改在 \jwu-archetype目录下的 pom.xml文件如下：
<version>1.0</version> 


5. 进入 \flex-spring-hibernate-archetype 目录，执行 mvn install命令，安装该 archetype。安装完成之后，在该目录会产生一个 target目录，
同时在 maven的 repository目录生成 mavenRepo\m2\com\jwu\jwu-archetype\1.0\ jwu-archetype-1.0.jar及 jwu-archetype-1.0.pom等文件。

如果重复安装，可以用 mvn clean install

安装成功后就可以使用这个自定义的 archetype了。


6、创建测试项目： lbbm

执行 mvn命令：
FlexSpace>mvn archetype:create -DgroupId=lb.flex.lbbm -DartifactId=lbbm -Dpackage=com.lb.lbbm -Dversion=1.0-SNAPSHOT -DarchetypeGroupId=lb.flex -DarchetypeArtifactId=flex-spring-hibernate-archetype -DarchetypeVersion=1.0

测试一下生成的项目： lbbm>mvn test

生成 eclipse项目：

\lbbm>mvn eclipse:eclipse -Dwtpversion=2.0

这样就可以导入到 eclipse IDE中进行进一步开发了。

7、注意问题

<!--                    <executions>
                         <execution>
                              <phase>process-test-resources</phase>
                              <goals>
                                   <goal>hbm2ddl</goal>
                              </goals>
                         </execution>
                    </executions>     -->    
这一段必须注释，不然构建不会成功，报找不到 hibernate.cfg.xml 文件    


