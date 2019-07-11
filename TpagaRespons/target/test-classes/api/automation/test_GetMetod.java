package api.automation;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class test_GetMetod {

    String baseURL = "https://tpaga.co/soluciones-empresariales/";
    WebDriver driver;
    String expectedResult = "";
    String actualResult = "";
    String chomePath = "./drivers/chromedriver";

    //Craear metodos
    @BeforeTest
    public  void launchBrowser(){
        System.setProperty("webdriver.chrome.driver", chomePath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);

    }

    @BeforeMethod
    public void verifyHomePageTitle(){ ///En este metodo creado validamos antes de ejecutar los test que el titulo del HOME PAGE sea el indicado.
        expectedResult="Tpaga";
        actualResult = driver.getTitle();
        Assert.assertEquals(actualResult,expectedResult, "Title is not equals");// aquie se hace un Assert que permite valiadar si es igual o no, y si no se genera un mensage

    }

    @AfterMethod
    public void goBackToHomePage(){ //Metodo para ir a HOME
        driver.findElement(By.linkText("Home")).click();
    }


    @Test (priority = 4)
    public void register() throws InterruptedException {
        driver.findElement(By.linkText("Empresa")).click();
        expectedResult = "Tpaga";
        actualResult = driver.getTitle();
        Thread.sleep(3000);
        Assert.assertEquals(actualResult,expectedResult,"Title is not equals");
    }


    @AfterTest
    public void tearDown(){// metodo para cerrar los navegadores despues de la ejecucion
        driver.quit();
    }




    @Test (priority = 1)
    public void tc_01_get() {

        Response response = RestAssured.get("https://tpaga.co/");
        System.out.println(response.getStatusCode());

    }

    @Test (priority = 2)
    public void tc_02_get() {

        Response response = RestAssured.get("https://tpaga.co/2019/03/05/afilia-tu-comercio-a-tpaga/");
        System.out.println(response.getStatusCode());

    }

    @Test (priority = 3)
    public void tc_03_get() {

        Response response = RestAssured.get("https://tpaga.co/soluciones-empresariales/");
        System.out.println(response.getStatusCode());

    }



}
