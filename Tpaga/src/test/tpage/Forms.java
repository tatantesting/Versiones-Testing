package test.tpage;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class Forms {

    static WebDriver driver;


    public static void main(String[] args){

        String chomePath = "./drivers/chromedriver";
        System.setProperty("webdriver.chrome.driver", chomePath);
        String baseURL = "https://tpaga.co/soluciones-empresariales/";
        driver = new ChromeDriver();
        driver.get(baseURL);
        driver.manage().window().maximize();

        try{

            driver.findElement(By.linkText("Empresa")).click();

            //Estas son las formas que se realiza el llenado de un campo
            WebElement txtFirstName = driver.findElement(By.name("et_pb_contact_nombre_0"));
            txtFirstName.sendKeys("Jonathan Javier Rodriguez Madero");
            Thread.sleep(1500);


            WebElement txtUserName =driver.findElement(By.name("et_pb_contact_email_0"));
            txtUserName.sendKeys("Samtesting.qa@gmail.com");

            WebElement txtphone = driver.findElement(By.name("et_pb_contact_telefono_0"));
            txtphone.sendKeys("3174249877");



            WebElement txtTarea = driver.findElement(By.name("et_pb_contact_mensaje_0"));
            txtTarea.sendKeys("Como puedo tener mas informacion de sus productos");

            txtTarea.submit();
            Thread.sleep(10000);




        } catch (NoSuchElementException ne){
            System.err.println("NO se encontro el WebElement: " + ne.getMessage());
        } catch (WebDriverException we){
            System.err.println("WebDriver Fallo: ");
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            driver.quit();
        }



    }






}

