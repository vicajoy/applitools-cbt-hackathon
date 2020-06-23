import org.testng.annotations.Test;


public class ModernTestV1 extends BaseTest {

    @Test
    public void testElements() {
        goHomeV1();
        eyesManager.validateWindow("Task 1", "Cross-Device Elements Test");
    }

    @Test
    public void testShoppingExperience() {
        goHomeV1();
        homePage.filterShoesByBlackColorV1();
        eyesManager.validateElement(homePage.getResultGrid(), "Task 2", "Filter Results Test");

    }

    @Test
    public void testProductDetails() {
        goHomeV1();
        homePage.filterShoesByBlackColorV1();
        homePage.clickResultItem(1);
        eyesManager.validateWindow("Task 3", "Product Details Test");
    }
}
