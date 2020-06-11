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


    public boolean isProfileIconVisible() {
        return find(By.id(profileIcon)).isDisplayed();
    }

    public boolean isWishlistIconVisible() {
        return find(By.id(wishlistIcon)).isDisplayed();
    }

    public boolean isCartIconVisible() {
        return find(By.id(cartIcon)).isDisplayed();
    }

    public boolean isGridViewIconVisibleV1() {
        return find(By.id(gridViewIconV1)).isDisplayed();
    }

    public boolean isListViewIconVisibleV1() {
        return find(By.id(listViewIconV1)).isDisplayed();
    }

    public boolean isGridViewIconVisibleV2() {
        return find(By.id(gridViewIconV2)).isDisplayed();
    }

    public boolean isListViewIconVisibleV2() {
        return find(By.id(listViewIconV2)).isDisplayed();
    }

    public boolean isSearchFieldVisible() {
        return find(By.id(searchField)).isDisplayed();
    }

    public boolean isFiltersIconVisibleV1() {
        return find(By.id(filtersIconV1)).isDisplayed();
    }

    public boolean isFiltersIconVisibleV2() {
        return find(By.id(filtersIconV2)).isDisplayed();
    }

    public boolean isSidebarVisible() {
        return find(By.id(sidebar)).isDisplayed();
    }

    public void filterShoesByBlackColorV1() {
        if (!isSidebarVisible()) {
            click(By.id(filtersIconV1));
        }
        click(By.id(blackColorCheckbox));
        click(By.id(filterBtn));
    }

    public void filterShoesByBlackColorV2() {
        if (!isSidebarVisible()) {
            click(By.id(filtersIconV2));
        }
        click(By.id(blackColorCheckbox));
        click(By.id(filterBtn));
    }

    public int getFilterResultsCount() {
        List<WebElement> results = findAll(By.className(resultItem));
        return results.size();
    }

    public ProductDetailsPage clickResultItem(int index) {
        click(By.className(resultItem), index);
        return new ProductDetailsPage(driver);
    }
}

