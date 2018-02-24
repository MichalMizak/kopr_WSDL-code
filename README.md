# kopr_WSDL-code
A simple SOAP project generated from a WSDL file using eclipse tools

Assignment: "Od WSDL ku kódu - zaregistrovanie nového účastníka"

Project usage is demonstrated through a JUnit test - src/test/client/ClientTest and class src/server/Server,
Server MUST BE RUNNING in order to test this project. Client/Server code is divided into two packages named,
respectively, client/server, which are independent of each other.

Note the "delete" and "getCount" methods of UserDao aren't used anywhere else but the test as they aren't 
specified by the WSDL. Also note there is no duplicity of users being verified as two people can have the
same name and surname.

WSDL - src/ajs.wsdl

MySql database create statement - ajs_SQL_CREATE_STATEMENT.sql

Client generation METRO script: 
wsimport -keep -wsdllocation http://localhost:8080/ajs?wsdl -d bin src/ajs.wsdl -p client -s src -b src/schema.xsd

Server generation METRO script:
wsimport -keep -s src -d bin ajs.wsdl -b schema.xsd
