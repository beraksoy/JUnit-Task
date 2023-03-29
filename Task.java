package javapractice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.List;

public class Task {
//    *** Aşağıdaki Task'i Junit framework'u ile yapınız
//- http://the-internet.herokuapp.com/add_remove_elements/ adresine gidiniz
//- Add Element butonuna 100 defa basınız
//- 100 defa basıldığını test ediniz
//- 90 defa delete butonuna basınız
//- 90 defa basıldığını doğrulayınız
//- Sayfayı kapatınız
WebDriver driver;
    @Before
    public void sistem(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @Test
    public void test01(){
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        for (int i =1 ; i<101 ;i++){
            driver.findElement(By.xpath("//button[@onclick='addElement()']")).click();
            System.out.println("100 defa click lendi");
        }
        for (int i =1; i<91;i++){
           driver.findElement(By.xpath("//button[@onclick='deleteElement()']")).click();
            System.out.println("delete butonuna tıklanma sayisi" );
        }


    }

    @After
    public void kapatma(){
        driver.close();
    }



}
