package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage {

    private String profileIcon = "A__accesslink__56";
    private String wishlistIcon = "A__wishlist__52";
    private String cartIcon = "A__cartbt__49";
    private String gridViewIconV1 = "I__tiviewgrid__202";
    private String gridViewIconV2 = "I__tiviewgrid__203";
    private String listViewIconV1 = "I__tiviewlist__204";
    private String listViewIconV2 = "I__tiviewlist__205";
    private String filtersIconV1 = "A__openfilter__206";
    private String filtersIconV2 = "A__openfilter__207";
    private String searchField = "INPUTtext____42";
    private String blackColorCheckbox = "LABEL__containerc__104";
    private String filterBtn = "filterBtn";
    private String sidebar = "filter_col";
    private String resultItem = "grid_item";
    private By resultGrid = (By.id("product_grid"));


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getProfileIcon() {
        return profileIcon;
    }

    public String getWishlistIcon() {
        return wishlistIcon;
    }

    public String getCartIcon() {
        return cartIcon;
    }

    public String getGridViewIconV1() {
        return gridViewIconV1;
    }

    public String getListViewIconV1() {
        return listViewIconV1;
    }

    public String getFiltersIconV1() {
        return filtersIconV1;
    }

    public String getGridViewIconV2() {
        return gridViewIconV2;
    }

    public String getListViewIconV2() {
        return listViewIconV2;
    }

    public String getFiltersIconV2() {
        return filtersIconV2;
    }

    public String getSearchField() {
        return searchField;
    }

    public String getResultItem() {
        return resultItem;
    }

    public By getResultGrid() {
        return resultGrid;
    }

    /**
     * Checks whether profile icon is visible
     * @return		   boolean - true if profile icon is visible, false if not
     */
    public boolean isProfileIconVisible() {
        return find(By.id(profileIcon)).isDisplayed();
    }

    /**
     * Checks whether wishlist icon is visible
     * @return		   boolean - true if wishlist icon is visible, false if not
     */
    public boolean isWishlistIconVisible() {
        return find(By.id(wishlistIcon)).isDisplayed();
    }

    /**
     * Checks whether cart icon is visible
     * @return		   boolean - true if cart icon is visible, false if not
     */
    public boolean isCartIconVisible() {
        return find(By.id(cartIcon)).isDisplayed();
    }

    /**
     * Checks whether grid view icon is visible for Version 1
     * @return		   boolean - true if grid view icon is visible, false if not
     */
    public boolean isGridViewIconVisibleV1() {
        return find(By.id(gridViewIconV1)).isDisplayed();
    }

    /**
     * Checks whether list view icon is visible for Version 1
     * @return		   boolean - true if list view icon is visible, false if not
     */
    public boolean isListViewIconVisibleV1() {
        return find(By.id(listViewIconV1)).isDisplayed();
    }

    /**
     * Checks whether grid view icon is visible for Version 2
     * @return		   boolean - true if grid view icon is visible, false if not
     */
    public boolean isGridViewIconVisibleV2() {
        return find(By.id(gridViewIconV2)).isDisplayed();
    }

    /**
     * Checks whether list view icon is visible for Version 2
     * @return		   boolean - true if list view icon is visible, false if not
     */
    public boolean isListViewIconVisibleV2() {
        return find(By.id(listViewIconV2)).isDisplayed();
    }

    /**
     * Checks whether search field is visible
     * @return		   boolean - true if search field is visible, false if not
     */
    public boolean isSearchFieldVisible() {
        return find(By.id(searchField)).isDisplayed();
    }

    /**
     * Checks whether filter icon is visible for Version 1
     * @return		   boolean - true if filter icon is visible, false if not
     */
    public boolean isFiltersIconVisibleV1() {
        return find(By.id(filtersIconV1)).isDisplayed();
    }

    /**
     * Checks whether filter icon is visible for Version 2
     * @return		   boolean - true if filter icon is visible, false if not
     */
    public boolean isFiltersIconVisibleV2() {
        return find(By.id(filtersIconV2)).isDisplayed();
    }

    /**
     * Checks whether sidebar is visible
     * @return		   boolean - true if sidebar is visible, false if not
     */
    public boolean isSidebarVisible() {
        return find(By.id(sidebar)).isDisplayed();
    }

    /** Filters shoes by black color by clicking the Black checkbox on the sidebar (Version 1) */
    public void filterShoesByBlackColorV1() {
        if (!isSidebarVisible()) {
            click(By.id(filtersIconV1));
        }
        click(By.id(blackColorCheckbox));
        click(By.id(filterBtn));
    }

    /** Filters shoes by black color by clicking the Black checkbox on the sidebar (Version 2) */
    public void filterShoesByBlackColorV2() {
        if (!isSidebarVisible()) {
            click(By.id(filtersIconV2));
        }
        click(By.id(blackColorCheckbox));
        click(By.id(filterBtn));
    }

    /**
     * Gets filtered results' count
     * @return		   int - count of filtered results
     */
    public int getFilterResultsCount() {
        List<WebElement> results = findAll(By.className(resultItem));
        return results.size();
    }

    /**
     * Clicks on the result by index and redirects to the Product Details page
     * @param index       int - index of the result item
     * @return            ProductDetailsPage
     */
    public ProductDetailsPage clickResultItem(int index) {
        click(By.className(resultItem), index);
        return new ProductDetailsPage(driver);
    }
}

