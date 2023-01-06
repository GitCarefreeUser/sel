package com.eurotech.tests.karisik;

public class SwitchToConcept {
    /*
    1-alertte  switch
         drver.switchTo().alert()
       when selenium see this switchto.alert , it knows if there is any alert on your web page

     2-new tab acilinca switch
        Set<String> windowHandles = driver.getWindowHandles(); //   [firstPageId,secondPageId]
        Iterator<String> it = windowHandles.iterator();
        String firstPage=it.next();  //  ilk index-->firstPageId
        String secondPage=it.next(); //set'teki ikinci element--secondPageId
        driver.switchTo().window(secondPage); // burda da selenium'a kontrolu 2. sayfaya al diyoruz

        newtab folder'inda LoginRahul classinda 104. satirda gecti bu konu

      3-frame de switch

      driver.switchTo().frame(0);  indexNo ile
      driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));    webElement ile

      bir de frame disina cikmak icin
      driver.switchTo().defaultContent();


     */
}
