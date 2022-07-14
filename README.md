# CurrencyCalculator - Simple Currency Calcualtor  :smiley: :computer:
 
This is a simple Maven project written in Java

### How to run Application :

In order to run application you have to import folder with project into any Java IDE
and run Main class which is in Main package 

## Project allows to :

- Calculate from EU currency to destinated currency
- Show all currencies and rate of currency
- Quit program

### Projects contains 3 Classes:

- Calculator
  * Logic of application
- CurrencyFileParser
  * Parsing XML file 
- Main
  * Launching application
  
#### Libaries used in project 

* Librares used for parsing XML 
  - javax.xml.parsers.DocumentBuilder
  - javax.xml.parsers.DocumentBuilderFactory
  - org.w3c.dom.Document
  - org.w3c.dom.Node
  - org.w3c.dom.NodeList
* Librares used for Unit testing 
  - org.junit (jUnit)
* Other libraries used for Structures and IO manipulation
  - java.util.HashMap
  - java.util.Map
  - java.io.IOException
  - java.io.File
  - java.io.BufferedReader
  - java.io.InputStreamReader
