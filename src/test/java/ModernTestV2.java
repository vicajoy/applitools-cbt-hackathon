import base.BaseTest;
import org.testng.annotations.Test;


public class ModernTestV2 extends BaseTest {

    @Test
    public void testElements() {
        goHomeV2();
        eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
    }

    @Test
    public void testShoppingExperience() {
        goHomeV2();
        homePage.filterShoesByBlackColorV2();
        eyesManager.validateElement(homePage.getResultGrid(), "Task 2", "Filter Results Test");

    }

    @Test
    public void testProductDetails() {
        goHomeV2();
        homePage.filterShoesByBlackColorV2();
        homePage.clickResultItem(1);
        eyesManager.validateWindow("Task 3", "Product Details Test");
    }
}
