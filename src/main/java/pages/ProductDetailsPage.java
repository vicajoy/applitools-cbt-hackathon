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

    /**
     * Getter for the element of product name
     * @return		   String - DOM ID of product name
     */
    public String getProductNameId() {
        return productNameId;
    }

    /**
     * Getter for the element of product new price
     * @return		   String - DOM ID of product new price
     */
    public String getProductNewPriceId() {
        return productNewPriceId;
    }

    /**
     * Getter for the element of product old price
     * @return		   String - DOM ID of product old price
     */
    public String getProductOldPriceId() {
        return productOldPriceId;
    }

    /**
     * Getter for the element of product description
     * @return		   String - DOM ID of product description
     */
    public String getProductDescriptionId() {
        return productDescriptionId;
    }

    /**
     * Getter for the element of product discount
     * @return		   String - DOM ID of product discount
     */
    public String getProductDiscountId() {
        return productDiscountId;
    }

    /**
     * Getter for selected option of size dropdown
     * @return		   String - DOM ID of selected option of size dropdown
     */
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
