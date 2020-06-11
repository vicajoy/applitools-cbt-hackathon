package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private String productNameId = "shoe_name";
    private String productNewPriceId = "new_price";
    private String productOldPriceId = "old_price";
    private String productDescriptionId = "P____83";
    private String productDiscountId = "discount";

    public String getProductNameId() {
        return productNameId;
    }

    public String getProductNewPriceId() {
        return productNewPriceId;
    }

    public String getProductOldPriceId() {
        return productOldPriceId;
    }

    public String getProductDescriptionId() {
        return productDescriptionId;
    }

    public String getProductDiscountId() {
        return productDiscountId;
    }

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getProductName() {
        return driver.findElement(By.id(productNameId)).getText();
    }

    public String getProductOldPrice() {
        return driver.findElement(By.id(productOldPriceId)).getText();
    }

    public String getProductNewPrice() {
        return driver.findElement(By.id(productNewPriceId)).getText();
    }

    public String getProductDiscount() {
        return driver.findElement(By.id(productDiscountId)).getText();
    }

    public String getProductDescription() {
        return driver.findElement(By.id(productDescriptionId)).getText();
    }
}
