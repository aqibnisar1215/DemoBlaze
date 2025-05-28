package Tests;

import Pages.HomePage;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ProductFilter extends BaseTest{

    SoftAssert softAssert =  new SoftAssert();


    @Test

    public void productDetails() throws InterruptedException {

        HomePage home = new HomePage(driver);

        // click on the click btn

        home.ClickLapTopsBtn();

        //Retrieyin the loptop list of product names

       List<String> laptopList = home.getProductList();

       System.out.println("Laptop List :"+laptopList);

       //click on the phone link

       home.ClickPhoneBtn();

       //Retriying the Phone list of product name

       List<String> phoneList = home.getProductList();

        System.out.println("Loptop list" + phoneList);

        //verify the phone list of product name

       for (String laptop : laptopList){
           softAssert.assertFalse(phoneList.equals(laptop),"Product"+laptop+"from Laptops is also found in Phones");
       }

       softAssert.assertAll();
    }
}
