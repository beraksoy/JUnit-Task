package javapractice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C01_Practice {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // https://www.amazon.com/ adresine gidin
        driver.get("https://amazon.com/");

        // arama kutusunun, tagName'inin 'input' oldugunu test ediniz
        WebElement aramakutusu=driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        String actualtagname= aramakutusu.getTagName();
        String expectedTagname="input";
        if (actualtagname.equals(expectedTagname)){
            System.out.println("tagname input");
        }else {
            System.out.println("tagname input degil");
        }

        // arama kutusunun, name attribute'nun degerinin 'field-keywords' oldugunu test edin
        String actualName = aramakutusu.getAttribute("name");
        String expectedName ="field-keywords";
        if (actualName.equals(expectedName)){
            System.out.println("name field-keywords");
        }else {
            System.out.println("name field-keywords degil");
        }
        // sayfayi kapatiniz
        driver.close();




    }
}
