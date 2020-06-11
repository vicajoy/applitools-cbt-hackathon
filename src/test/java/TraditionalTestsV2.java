import org.testng.annotations.Test;


public class TraditionalTestsV2 extends BaseTests {

    @Test(priority = 1)
    public void testElements() {
        goHomeV2();
        softAssert.assertThat(reporterV2(1, "Profile icon is displayed", homePage.getProfileIcon(),
                homePage.isProfileIconVisible()));
        softAssert.assertThat(reporterV2(1, "Cart icon is displayed", homePage.getCartIcon(),
                homePage.isCartIconVisible()));

        if (deviceName.equals("Laptop")) {
            softAssert.assertThat(reporterV2(1, "Wishlist icon is displayed", homePage.getWishlistIcon(),
                    homePage.isWishlistIconVisible()));
            softAssert.assertThat(reporterV2(1, "Grid view icon is displayed", homePage.getGridViewIconV2(),
                    homePage.isGridViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "List view icon is displayed", homePage.getListViewIconV2(),
                    homePage.isListViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "Search field is displayed", homePage.getSearchField(),
                    homePage.isSearchFieldVisible()));
            softAssert.assertThat(reporterV2(1, "Filters icon is not displayed", homePage.getFiltersIconV2(),
                    !homePage.isFiltersIconVisibleV2()));
            softAssert.assertAll();
        }
        else if (deviceName.equals("Tablet")) {
            softAssert.assertThat(reporterV2(1, "Wishlist icon is not displayed", homePage.getWishlistIcon(),
                    !homePage.isWishlistIconVisible()));
            softAssert.assertThat(reporterV2(1, "Grid view icon is not displayed", homePage.getGridViewIconV2(),
                    !homePage.isGridViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "List view icon is not displayed", homePage.getListViewIconV2(),
                    !homePage.isListViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "Search field is displayed", homePage.getSearchField(),
                    homePage.isSearchFieldVisible()));
            softAssert.assertThat(reporterV2(1, "Filters icon is displayed", homePage.getFiltersIconV2(),
                    homePage.isFiltersIconVisibleV2()));
            softAssert.assertAll();
        }
        else if (deviceName.equals("Mobile")) {
            softAssert.assertThat(reporterV2(1, "Wishlist icon is not displayed", homePage.getWishlistIcon(),
                    !homePage.isWishlistIconVisible()));
            softAssert.assertThat(reporterV2(1, "Grid view icon is not displayed", homePage.getGridViewIconV2(),
                    !homePage.isGridViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "List view icon is not displayed", homePage.getListViewIconV2(),
                    !homePage.isListViewIconVisibleV2()));
            softAssert.assertThat(reporterV2(1, "Search field is not displayed", homePage.getSearchField(),
                    !homePage.isSearchFieldVisible()));
            softAssert.assertThat(reporterV2(1, "Filters icon is displayed", homePage.getFiltersIconV2(),
                    homePage.isFiltersIconVisibleV2()));
            softAssert.assertAll();
        }
    }

    @Test(priority = 3)
    public void testShoppingExperience() {
        goHomeV2();
        homePage.filterShoesByBlackColorV2();
        softAssert.assertThat(reporterV2(2, "Filter results' count is 2", homePage.getResultItem(),
                homePage.getFilterResultsCount() == 2));
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void testProductDetails() {
        var productDescription = "These boots are comfortable enough to wear all day. Well made. I love the “look”. " +
                "Best Used For Casual Everyday Walk fearlessly into the cooler months in the Sorel Joan Of " +
                "Arctic Wedge II Chelsea Boot. Boasting the iconic wedge platform that's as comfortable as it is " +
                "stylish, this boot features a waterproof upper";

        goHomeV2();
        homePage.filterShoesByBlackColorV2();
        var productDetailsPage = homePage.clickResultItem(1);
        softAssert.assertThat(reporterV2(3, "Product name is correct", productDetailsPage.getProductNameId(),
                productDetailsPage.getProductName().equals("Appli Air x Night")));
        softAssert.assertThat(reporterV2(3, "Product old price is correct", productDetailsPage.getProductOldPriceId(),
                productDetailsPage.getProductOldPrice().equals("$48.00")));
        softAssert.assertThat(reporterV2(3, "Product new price is correct", productDetailsPage.getProductNewPriceId(),
                productDetailsPage.getProductNewPrice().equals("$33.00")));
        softAssert.assertThat(reporterV2(3, "Product discount is correct", productDetailsPage.getProductDiscountId(),
                productDetailsPage.getProductDiscount().equals("-30% discount")));
        softAssert.assertThat(reporterV2(3, "Product description is correct", productDetailsPage.getProductDescriptionId(),
                productDetailsPage.getProductDescription().contains(productDescription)));
        softAssert.assertAll();
    }
}
