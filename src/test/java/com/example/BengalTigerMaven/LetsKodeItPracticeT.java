package com.example.BengalTigerMaven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static com.example.BengalTigerMaven.BengalTigerMavenApplication.setup;
import static com.example.BengalTigerMaven.BengalTigerMavenApplication.waitFor;

public class LetsKodeItPracticeT {
    WebDriver driver;

    @BeforeTest
    public void setup (){
        System.setProperty("webdriver.gecko.driver", "C:/Users/13477/IdeaProjects/MavenProject/.idea/Driver/geckodriver.exe");

        driver = new FirefoxDriver();
        driver.get("https://www.letskodeit.com/practice");

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }
    @Test
    public void radioButton()throws InterruptedException{
        WebElement bmwRadioBtn=driver.findElement(By.id("bmwradio"));
        bmwRadioBtn.click();
        waitFor(2);
        WebElement benzRadioBtn=driver.findElement(By.id("benzradio"));
        benzRadioBtn.click();
        System.out.println("BMW Radio Button is selected" +" " +bmwRadioBtn.isSelected());
        System.out.println("BENZ Radio Button is selected" +" " + benzRadioBtn.isSelected());
    }


    @Test
    public void checkBoxs() throws InterruptedException {

        WebElement bmwCheckBox=driver.findElement(By.id("bmwcheck"));
        bmwCheckBox.click();
        System.out.println("BMW Check Box is selected" +" " + bmwCheckBox.isSelected());
        waitFor(2);
        WebElement benzCheckBox=driver.findElement(By.id("benzcheck"));
        benzCheckBox.click();
        System.out.println("BENZ Check Box is selected" +" " + benzCheckBox.isSelected());
        waitFor(2);
        WebElement hondaCheckBox=driver.findElement(By.id("hondacheck"));
        hondaCheckBox.click();
        System.out.println("HONDA Check Box is selected" +" " + hondaCheckBox.isSelected());

    }
    @Test
    public void switchWindow() throws InterruptedException {
        /*System.setProperty("webdriver.gecko.driver", "C:/Users/13477/IdeaProjects/MavenProject/.idea/Driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");*/
        String parentWindow=driver.getWindowHandle();
        System.out.println("parent window-"+parentWindow);

        driver.findElement(By.xpath("//button[@id='openwindow']")).click();
        waitFor(2);
        Set<String> handles=driver.getWindowHandles();
        for(String handle:handles){
            System.out.println(handle);
            if (!handle.equals(parentWindow)){
                driver.switchTo().window(handle);
                driver.findElement(By.xpath("//a[contains(text(),'HOME')]")).click();
                waitFor(3);
                driver.close();

            }
        }
        driver.switchTo().window(parentWindow);
        driver.findElement(By.xpath("//button[@id='openwindow']"));
        waitFor(3);

        System.out.println(driver.getCurrentUrl());

        //driver.quit();


    }



    @Test
    public void  switchTabHandle()throws InterruptedException{
        /*System.setProperty("webdriver.gecko.driver","C:/Users/13477/IdeaProjects/BengalTigerMaven/BengalTigerMaven/driver/geckodriver.exe");
        WebDriver driver=new FirefoxDriver();
        driver.navigate().to("https://www.letskodeit.com/practice");
        driver.manage().window().maximize();
        //System.out.println(driver.getTitle());
        Thread.sleep(3000);*/
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        Thread.sleep(2000);
        //System.out.println(driver.getTitle());
        driver.findElement(By.xpath("//a[@id='opentab']")).click();
        Thread.sleep(2000);

        //System.out.println(driver.getTitle());
        String mainTab=driver.getWindowHandle();
        List<String> childTabs= new ArrayList<String>(driver.getWindowHandles());
        // childTabs={"window1"  ,"window2" ,"window3"};
        //childTabs.remove(mainTab);
        driver.switchTo().window(childTabs.get(1));
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        driver.switchTo().window(childTabs.get(0));
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());


    }
    @Test
    public void dropDown() throws InterruptedException {
       /* System.setProperty("webdriver.gecko.driver", "C:/Users/13477/IdeaProjects/MavenProject/.idea/Driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");*/
        WebElement dropDown=driver.findElement(By.xpath("//select[@id='carselect']"));
        Select selectObj=new Select(dropDown);
        waitFor(2);
        selectObj.selectByVisibleText("Benz");
        waitFor(2);
        selectObj.selectByVisibleText("Honda");
        waitFor(2);
        //driver.quit();
        System.out.println("Done");

    }

    @Test
    public void multipleSelect() throws InterruptedException {
        /*System.setProperty("webdriver.gecko.driver", "C:/Users/13477/IdeaProjects/MavenProject/.idea/Driver/geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.letskodeit.com/practice");*/
        WebElement multiSelect=driver.findElement(By.id("multiple-select-example"));
        Select selectObj=new Select(multiSelect);
        selectObj.selectByVisibleText("Apple");
        waitFor(2);
        selectObj.selectByVisibleText("Orange");
        waitFor(2);
        selectObj.selectByVisibleText("Peach");
        waitFor(1);
        selectObj.deselectByVisibleText("Orange");
        List<WebElement>listOfOptions=selectObj.getAllSelectedOptions();
        for (WebElement option:listOfOptions){
            System.out.println(option.getText());
        }

        //driver.quit();
        System.out.println("Done");

    }
    @Test
    public void isEnabledIsDisplayed(){
        driver.findElement(By.xpath("//input[@id='enabled-example-input']")).sendKeys("Hello");
        boolean b1=driver.findElement(By.xpath("//input[@id='enabled-example-input']")).isEnabled();
        System.out.println("Field is enable-" +b1);
        driver.findElement(By.xpath("//input[@id='hide-textbox']")).click();
        boolean b2=driver.findElement(By.xpath("//input[@id='displayed-text']")).isDisplayed();
        System.out.println("Field is displayed-" +b2);

    }
    @Test
    public void switchAlert() throws InterruptedException {

        driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/fieldset[1]/input[1]")).sendKeys("Rumel");
        waitFor(1);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        waitFor(1);
        driver.switchTo().alert().accept();
        waitFor(1);
        driver.findElement(By.xpath("//body/div[@id='page']/div[2]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[3]/fieldset[1]/input[1]")).sendKeys("Rumel");
        waitFor(1);
        driver.findElement(By.xpath("//input[@id='confirmbtn']")).click();
        waitFor(1);
        driver.switchTo().alert().dismiss();
        waitFor(1);

    }

   /* @Test
    public void handleMouseHover(){
        Actions act=new Actions(driver);
        WebElement mouseHover= driver.findElement(By.xpath("//button[@id='mousehover']"));
        act.moveToElement(mouseHover).click().perform();

    }*/

    @Test
    public void webTable(){
        int rowCount=driver.findElements(By.xpath("//tbody/tr[1]")).size();
        int columCount=driver.findElements(By.xpath("//th[contains(text(),'Author')]")).size();

        for (int i=1; i<rowCount;i++){
            for (int j=1; j<=columCount; j++){
                String actValue=driver.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td["+j+"]")).getText();
                if(actValue.equals("Python Programming Language")){
                    System.out.println(i+" : "+j);
                    break;
                }
            }
        }


    }



}
