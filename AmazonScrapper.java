import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AmazonScraper {

    public static void main(String[] args) {
        // Set up the ChromeDriver path
        System.setProperty("webdriver.chrome.driver", "path/to/chromedriver"); // Update with your ChromeDriver path

        // Initialize WebDriver
        WebDriver driver = new ChromeDriver();

        try {
            // Open Amazon.in
            driver.get("https://www.amazon.in");
            Thread.sleep(2000); // Wait for the page to load

            // Search for "lg soundbar"
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("lg soundbar");
            searchBox.submit();
            Thread.sleep(3000); // Wait for search results to load

            // Get all product containers on the first search result page
            List<WebElement> products = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));
            List<Product> productList = new ArrayList<>();

            // Loop through each product to extract name and price
            for (WebElement product : products) {
                try {
                    // Extract product name
                    String name = product.findElement(By.xpath(".//h2/a/span")).getText();

                    // Extract price, handle cases where price might not be present
                    String priceText = "0"; // Default price if not found
                    try {
                        priceText = product.findElement(By.xpath(".//span[@class='a-price-whole']")).getText().replace(",", "");
                    } catch (Exception e) {
                        // Price not found, keep default as 0
                    }

                    // Parse the price to an integer
                    int price = Integer.parseInt(priceText);
                    productList.add(new Product(name, price));
                } catch (Exception e) {
                    // Skip this product if any extraction fails
                    System.out.println("Error extracting product: " + e.getMessage());
                }
            }

            // Sort products by price
            Collections.sort(productList, Comparator.comparingInt(Product::getPrice));

            // Print sorted products
            for (Product product : productList) {
                System.out.println(product.getPrice() + " " + product.getName());
            }

        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            // Close the browser
            driver.quit();
        }
    }
}

// Helper class to store product details
class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
