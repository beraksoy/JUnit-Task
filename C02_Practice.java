package javapractice_day02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class C02_Practice {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver(new ChromeOptions().addArguments("--remote-allow-origins=*"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // https://www.google.com/ adresine gidin
        driver.get("https://google.com");

        // sayfa baslıgının "Google" kelimesini icerdigini test edin
        String title = driver.getTitle();
        if (title.contains("Google")){
            System.out.println(" title google kelimesi iceriyor");
        }else {
            System.out.println("title google kelimesi icermiyor");
        }
        Thread.sleep(2000);


        // arama cubuguna "Nutella" yazıp aratın
       driver.findElement(By.xpath("//input [@class='gLFyf']")).sendKeys("Nutella" + Keys.ENTER);

        // bulunan sonuc sayısını yazdırın
        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@id='result-stats']"));

        //  System.out.println(sonucYazisi.getText());

        String arr[] = sonucYazisi.getText().split(" ");

        String sonuc = arr[1];

        System.out.println(sonuc);
        // sonuc sayısının 100000000  fazla oldugunu test edin
        String sonucc = sonuc.replaceAll("\\D","");
        if (Integer.parseInt(sonucc)>100000000){
            System.out.println("sonuc sayisi 10000000 dan fazla");
        }else {
            System.out.println("sonuc sayisi 10000000 dan fazla degil");
        }


        // sayfayı kapatın
        driver.close();




    }
}
