import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Check {
    private WebDriver webDriver;


    @BeforeTest
    public  void openDriver(){
        System.setProperty("webdriver.chrome.driver","D:\\Temp\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    @Test(description = "Deals of the  Previous button")
    public void Previous(){
        webDriver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.findElement(By.xpath("//img[@name='picture_Smartphones1']")).click();
    }

    @Test(description = "Deals of the  Previous button")
    public void Previous2(){
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.findElement(By.xpath("//a[@role='button']//span[@aria-hidden='true']")).click();
    }



    @Test(description = "open login page and enter a username and password")
    public void Login() {
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//a[@name='Login']"));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//input[@placeholder='Enter Username']"));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//input[@placeholder='Enter Password']"));
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//span[@class='btn-caption']"));
    }


    @Test(description = "sort all products price low to high ")
    public void catagorySortPriceLowToHigh() {
        System.setProperty("webdriver.chrome.driver","D:\\Temp\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/AllProducts");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//span[normalize-space()='Price - Low to High']")).click();
        webDriver.close();
    }


    @Test(description = "sort Mobile phones price high to low ")
    public void SmartPhoneSortPriceHighToLow() {
        System.setProperty("webdriver.chrome.driver","D:\\Temp\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/AllProducts");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//span[normalize-space()='Smartphones']")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Select Field = new Select(webDriver.findElement(By.xpath("//select[@name='select_sort']")));
        Field.selectByVisibleText("Price-High to Low");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.close();
    }


    @Test(description = "include out of stock products ")
    public void outOfStockProducts() {
        System.setProperty("webdriver.chrome.driver", "D:\\Temp\\chromedriver_win32\\chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/AllProducts");
        webDriver.findElement(By.xpath("//span[normalize-space()='All Products']"));
        webDriver.findElement(By.xpath("//span[@class='caption']")).click();
        webDriver.close();
    }

    @Test(description = " Open a Particular Product")
    public void OpenaProduct() throws InterruptedException {
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/AllProducts");
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//span[normalize-space()='Smartphones']")).click();
        Thread.sleep(2000);
        webDriver.findElement(By.xpath("//img[@name='picture_AllProducts']")).click();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.close();
    }
    @Test(description = " add to cart  Particular Product")
    public void addToCart(){
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Products?Id=1");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(webDriver.getCurrentUrl());
        WebElement availability= webDriver.findElement(By.xpath("//button[@name='AddToCart']"));
        availability.click();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        System.out.println(webDriver.getCurrentUrl());

        WebElement username= webDriver.findElement(By.xpath("//input[@name='j_username']"));
        WebElement password= webDriver.findElement(By.xpath("//input[@name='j_password']"));
        WebElement login= webDriver.findElement(By.xpath("//button[@name='loginbutton']"));

        username.sendKeys("user");
        password.sendKeys("user");
        login.click();

        String attribute1=webDriver.getCurrentUrl();

        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/MyCart");
        webDriver.get(webDriver.getCurrentUrl());
        WebElement myCart= webDriver.findElement(By.xpath("//a[@name='MyCart']"));
        String attribute=webDriver.findElement(By.name("MyCart")).getAttribute("value");

    }

    @Test(description = "Place Order ")
    public void placeOrder(){
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        webDriver.get(webDriver.getCurrentUrl());
        WebElement loginLink= webDriver.findElement(By.xpath("//a[@name='Login']"));
        loginLink.click();
        WebElement username= webDriver.findElement(By.xpath("//input[@name='j_username']"));
        WebElement password= webDriver.findElement(By.xpath("//input[@name='j_password']"));
        WebElement login= webDriver.findElement(By.xpath("//button[@name='loginbutton']"));
        username.sendKeys("user");
        password.sendKeys("user");
        login.click();
        WebElement myCart= webDriver.findElement(By.xpath("//a[@name='MyCart']"));
        myCart.click();
        WebElement placeOrder= webDriver.findElement(By.xpath("//button[@name='button5']"));
        placeOrder.click();
    }

    @Test(description = " Cancel a Particular Product")
    public void cancelOrder() {
        webDriver.get("http://pkhw22ds2xds.cloud.wavemakeronline.com/WaveKart/#/Main");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        webDriver.get(webDriver.getCurrentUrl());
        WebElement loginLink = webDriver.findElement(By.xpath("//a[@name='Login']"));
        loginLink.click();
        WebElement username = webDriver.findElement(By.xpath("//input[@name='j_username']"));
        WebElement password = webDriver.findElement(By.xpath("//input[@name='j_password']"));
        WebElement login = webDriver.findElement(By.xpath("//button[@name='loginbutton']"));
        username.sendKeys("user");
        password.sendKeys("user");
        login.click();
        WebElement myOrders = webDriver.findElement(By.xpath("//a[@name='MyOrders']"));
        myOrders.click();
        webDriver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        WebElement cancelOrder = webDriver.findElement(By.xpath("//button[@name='button3']"));
        cancelOrder.click();
    }



    @AfterTest
    public  void CloseDriver(){
        webDriver.close();
    }






}
