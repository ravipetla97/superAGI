# superAGI
ASSESMENYT UI AUTOMATION SCRIPT
# Amazon Product Scraper using Selenium

This project is a Selenium-based Java automation script that performs the following steps on Amazon.in:

1. Opens Amazon.in
2. Searches for "LG soundbar"
3. Extracts product names and their associated main prices from the first search result page
4. Stores product names and prices as key-value pairs
5. Sorts the products by price and prints them in ascending order, considering missing prices as zero.

## Prerequisites

1. **Java Development Kit (JDK)**: Ensure that JDK 8 or above is installed on your system.
   - [Download JDK](https://www.oracle.com/java/technologies/javase-downloads.html)

2. **Selenium WebDriver**: Download the Selenium WebDriver library.
   - [Download Selenium WebDriver](https://www.selenium.dev/downloads/)

3. **ChromeDriver**: Download ChromeDriver matching your Chrome browser version.
   - [Download ChromeDriver](https://chromedriver.chromium.org/downloads)

4. **Maven** (Optional): If you are using Maven for dependency management, include the Selenium dependencies in your `pom.xml`.

## Setting Up the Project

## **Clone the Repository**:
   
##Configure ChromeDriver:
Download ChromeDriver and place it in a known location on your system.
Update the System.setProperty line in the AmazonScraper.java file:
java
Copy code
System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
Replace "path/to/chromedriver" with the correct path to your downloaded ChromeDriver.


##Compile and Run:


##Expected Output

The script will output the list of LG soundbars on the first search results page sorted by price. If a product does not have a price, it will be considered zero. 

