package com.eurotech.tests.fileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Upload1 {
    WebDriver driver;
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();

    }
    /*

    masaustune .txt uzantili bir dosya olusturduk
    windowsta shifte basii tutup dosyanin uzerinde sag clik deyince
    yolu kopyala secenegi ile path'i aldik
    buraya ilk yapistirinca
    aradaki slashlar sola yatik
    cikiyor bastaki ve sondaki \" lari silip
    \ lari da / haline ceviriyoruz
    ama bu yontem sadece bu bilgisayarda calisir
    her pc de calisacak sekilde yapmak icin
    frameworke'e koymaliyiz

    src folder'a sag click-- new--directory diyoruz
    resources alt kisimda hemen cikiyor onu sec enterlayinca
    framework'e resources directory olusuyor

    ona da sag click ve new ile file diyoruz
    file'a ismini veriyoruz



     */

    @Test
    public void test1() {
        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement file = driver.findElement(By.name("file"));

        file.sendKeys("C:/Users/aydin/OneDrive/Masaüstü/upload.txt");
        driver.findElement(By.id("file-submit")).click();
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploaded!",actualText);



    }

    @Test
    public void test2() {
        //isletim sistemini verir
        System.out.println(System.getProperty("os.name"));
        //projenin adini verir
        System.out.println(System.getProperty("user.dir"));

        //resources altina olusturdugumuz dosyaya
        //upload.txt uzantili dosyaya sag click copy path diyoruz ve
        // root'dan olani kopyalayip alta simdilik koyduk
        //   src/test/resources/upload.txt

        //elimizde 1-proje path'i
        //2-olusturdugumuz file path'i var


        String projectPath=System.getProperty("user.dir");
        String filePath="src/test/resources/upload.txt";

        //bu ikisini birlestielim

        String fullPath=projectPath+"/"+filePath;// araya bir slash ekledik
        System.out.println(fullPath);

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement file = driver.findElement(By.name("file"));

        //artik dynamic olarak fullpath i gonderebiliriz
        file.sendKeys(fullPath);
        driver.findElement(By.id("file-submit")).click();
        String actualText=driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals("File Uploaded!",actualText);




    }
}
