package ru.stqa.trainings.selenium;

        import org.junit.Test;
        import org.openqa.selenium.By;
        import org.openqa.selenium.support.ui.ExpectedConditions;


public class CartTest extends TestBase {

    @Test
    public void testVerifyCart() throws NullPointerException, InterruptedException {
        for(int i = 0; i < 3; i++) {
            goToHomepage();
            int id = i + 1;
            driver.findElement(By.xpath("//li[@class='product column shadow hover-light'][" + id + "]//div[@class='name']")).click();
            driver.findElement(By.name("add_cart_product")).click();
            wait.until(ExpectedConditions.textToBePresentInElement(driver.findElement(By.className("quantity")), Integer.toString(id)));
        }

        //
        
    }
}
