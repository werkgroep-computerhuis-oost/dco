## DCO en OpenLiberty in development mode

Installeer de [websphere plugin](https://plugins.jetbrains.com/plugin/18723-websphere),
deze plugin wordt in de laatste versie niet meer standaard meegeleverd.

# Installeer OpenLiberty

Download de laatste Open Liberty 'All GA Features' versie [hier](https://openliberty.io/start/#runtime_releases) en pak
de zip uit in `%USERPROFILE%\runtimes`.

Open een terminal en voer het commando uit:

```shell
cd %USERPROFILE%\runtimes\wlp
bin\server create dco
```

*TIP:* de `%USERPROFILE%\runtimes\wlp\README.TXT` bevat handige informatie!

## Setup https

Voer het volgende commando via de terminal uit, gebruik als wachtwoord `[geheim]`.

```shell
cd %USERPROFILE%\runtimes\wlp\usr\servers
keytool -genkeypair -alias computerhuis -keyalg RSA -keysize 2048 -storetype PKCS12 -keystore computerhuis.p12 -validity 3650
```

# Configureer OpenLiberty - dco

Creëer het bestand `%USERPROFILE%\runtimes\wlp\usr\servers\dco\server.env` met de volgende inhoud:

```ini
JAVA_HOME=%USERPROFILE%\scoop\apps\openjdk23\current
```

Creëer het bestand `%USERPROFILE%\runtimes\wlp\usr\servers\dco\jvm.options` met de volgende inhoud:

```
-XX:+UseParallelGC
-Xmx2048m
```

Creëer het bestand `%USERPROFILE%\runtimes\wlp\usr\servers\dco\server.xml` met de volgende inhoud:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<server description="dco">

    <!-- https://openliberty.io/docs/latest/reference/feature/feature-overview.html -->
    <featureManager>
        <!-- connection pools -->
        <feature>jndi-1.0</feature>
        <feature>jdbc-4.3</feature>

        <!-- application dependencies -->
        <feature>transportSecurity-1.0</feature>
        <feature>servlet-6.0</feature>
        <feature>websocket-2.1</feature>
        <feature>expressionLanguage-5.0</feature>

        <!-- show more info -->
        <feature>monitor-1.0</feature>
        <feature>localConnector-1.0</feature>
    </featureManager>

    <!-- load needed jars -->
    <library id="dco_libs">
        <fileset dir="${server.config.dir}libs" includes="*.jar"/>
    </library>

    <!-- setup database - https://openliberty.io/docs/latest/relational-database-connections-JDBC.html#unknown -->
    <dataSource jndiName="jdbc/dco" type="javax.sql.XADataSource">
        <jdbcDriver libraryRef="dco_libs"
                    javax.sql.XADataSource="org.mariadb.jdbc.MariaDbDataSource"/>
        <properties url="jdbc:mariadb://192.168.99.11:3306/dco"
                    user="dco"
                    password="[geheim]"/>
    </dataSource>

    <!-- To access this server from a remote client add a host attribute to the following element, e.g. host="*" -->
    <httpEndpoint id="defaultHttpEndpoint"
                  httpPort="9080"
                  httpsPort="9443"/>

    <!-- Default SSL configuration enables trust for default certificates from the Java runtime -->
    <ssl id="defaultSSLConfig" trustDefaultCerts="true"/>
    <keyStore id="defaultKeyStore" location="${wlp.install.dir}/servers/computerhuis.p12" type="PKCS12"
              password="[geheim]"/>

    <!-- EARS -->
    <enterpriseApplication location="%USERPROFILE%\Projecten\computerhuis\dco-desktop\target\dco.ear">
        <classloader commonLibraryRef="dco_libs" delegation="parentFirst"/>
    </enterpriseApplication>
</server>

```

Creëer het bestand `%USERPROFILE%\runtimes\wlp\usr\servers\dco\conf\logback.xml` en pas dit aan naar:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<configuration>

    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder>
            <!-- PATTERN: http://logback.qos.ch/manual/layouts.html#conversionWord -->
            <pattern>%date [%thread] %-5level %logger\(%mdc{IP}\) - [%mdc{RID}] %message%n</pattern>
        </encoder>
    </appender>


    <logger name="com.github.computerhuis.dco" level="debug"/>
    
    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>

```

## Installeer benodigde libraries

Maak de folder `%USERPROFILE%\runtimes\wlp\usr\servers\dco\libs` aan en download de volgende jars en plaats die in deze
folder:

- [MariaDB driver](https://repo1.maven.org/maven2/org/mariadb/jdbc/mariadb-java-client/3.5.1/mariadb-java-client-3.5.1.jar)
