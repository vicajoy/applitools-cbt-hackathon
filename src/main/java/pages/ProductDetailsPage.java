package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage {

    private String productNameId = "shoe_name";
    private String productNewPriceId = "new_price";
    private String productOldPriceId = "old_price";
    private String productDescriptionId = "P____83";
    private String productDiscountId = "discount";
    private String sizeValueId = ".nice-select span";

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

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

    public String getSizeValueId() {
        return sizeValueId;
    }

    /**
     * Gets the text of product name
     * @return		   String - product name text
     */
    public String getProductName() {
        return getText(By.id(productNameId));
    }

    /**
     * Gets the text of product old price
     * @return		   String - product old price text
     */
    public String getProductOldPrice() {
        return getText(By.id(productOldPriceId));
    }

    /**
     * Gets the text of product new price
     * @return		   String - product new price text
     */
    public String getProductNewPrice() {
        return getText(By.id(productNewPriceId));
    }

    /**
     * Gets the text of product discount
     * @return		   String - product discount text
     */
    public String getProductDiscount() {
        return getText(By.id(productDiscountId));
    }

    /**
     * Gets the text of product description
     * @return		   String - product description text
     */
    public String getProductDescription() {
        return getText(By.id(productDescriptionId));
    }

    /**
     * Gets the selected option of size dropdown
     * @return		   String - size value text
     */
    public String getSelectedOption() {
        return getText(By.cssSelector(sizeValueId));
    }
}
