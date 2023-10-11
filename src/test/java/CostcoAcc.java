import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CostcoAcc {
    WebDriver driver;

    public void setup(){
        System.setProperty("webdriver.gecko.driver","C://Users//13477//IdeaProjects//BengalTigerMaven//BengalTigerMaven//driver//geckodriver.exe");
        driver=new FirefoxDriver();
       // driver.get("https://www.costco.com/join-costco.html");

    }
    public void letsKode() throws InterruptedException {
       // System.setProperty("webdriver.gecko.driver","C://Users//13477//IdeaProjects//BengalTigerMaven//BengalTigerMaven//driver//geckodriver.exe");
       // driver=new FirefoxDriver();
        driver.get("https://www.letskodeit.com/practice");
        WebElement car=driver.findElement(By.xpath("//select[@id='carselect']"));
        Select obj=new Select(car);
        obj.selectByVisibleText("Honda");
        Thread.sleep(2000);
        obj.selectByVisibleText("Benz");


    }
    public void doTest() throws InterruptedException {
        System.setProperty("webdriver.gecko.driver","C://Users//13477//IdeaProjects//BengalTigerMaven//BengalTigerMaven//driver//geckodriver.exe");
        driver=new FirefoxDriver();
        driver.navigate().to("https://www.costco.com/");
        driver.findElement(By.xpath("//body/div[@id='footer-section']/footer[@id='footer-widget']/div[1]/div[2]/div[1]/div[2]/ul[1]/li[5]/a[1]")).click();
        driver.findElement(By.xpath("//a[@id='createAccount']")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("agarumel");
        driver.findElement(By.xpath("//input[@id='newPassword']")).sendKeys("agarumel");
        driver.findElement(By.xpath("//input[@id='reenterPassword']")).sendKeys("agarumel");
        driver.findElement(By.xpath("//button[@id='continue']")).click();

    }



    public static void main(String[] args) throws InterruptedException {
        CostcoAcc obj=new CostcoAcc();
        //obj.setup();
        //obj.doTest();
        obj.letsKode();

    }

}
