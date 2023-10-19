package stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.AventajaPage;

public class AventajaStepDefinition {
    AventajaPage aventajaPage = new AventajaPage();


    @Given("^se abre el Aventaja$")
    public void navigateToAventaja(){
        aventajaPage.navigateToAventaja();

    }

    @When("^Se presiona el icono User$")
    public void clickUser() { aventajaPage.clickLinkById( "menuUserLink"); }


    @When("^Se ingresan las credenciales$")
    public void fillLogin() throws InterruptedException{
        aventajaPage.FillLoginForm("adminUsers", "Ajca#123");
    }


    @Then("^Se presiona el button login$")
    public void clickButton () {aventajaPage.ClickSignInButton("sign_in_btn");}


    @When("^Se debe seleccionar categoria$")
    public  void selectCateg () throws InterruptedException {
        aventajaPage.selectCategoryAfterDelay("LAPTOPS", 10); // Espera 5 segundos antes de seleccionar la categoría
    }

    @And("^Se debe seleccionar un producto y agregarlo$")
    public void selectProduct () throws InterruptedException{
        aventajaPage.selectProductAfterDelay("Notebook", 15);

    }


    @And ("^Se presiona boton para agregar$")
          public void buttonAdd (){aventajaPage.clickAddToCartButton();

    }


  @And("^Se presiona button de carrito$")
    public void buttonCar(){
        aventajaPage.clickCartImage();
        aventajaPage.clickCheckout();
        aventajaPage.clickAdvantageNextButton();
    }

    @And("^Se confirma el  pago$")
    public void formPay() throws InterruptedException{
       //aventajaPage.FormCompra("admin_User", "Adm#12ps3");
        aventajaPage.clickPayButton();
    }

    @When("^Se retorna a la pagina de inicio$")
    public  void returnPag(){
        aventajaPage.clickHomeLink();
    }

    @And("^Se llena formulario Contacto$")
    public void formAdd()throws InterruptedException{
        aventajaPage.selectCategoria();
        aventajaPage.selectProduct();
        aventajaPage.selectEmail("testing@gmail.com");
        aventajaPage.enterTextarea("Opiniones o observaciones acerca de producto");

    }


    @And("^Se selecciona boton enviar$")
        public void buttonSend(){
        aventajaPage.clickSend();
    }



    @When("^Seleccionar icono cerrar Sesion$")
    public void buttonSign(){
        aventajaPage.clickSignOut("menuUserLink");
    }


    @And("^Cerrar Sesion$")
    public void closeAvanteja() {
        aventajaPage.SignOff();
    }


   @And("^Cerrar el navegador$")
    public void closeChrome() {
        aventajaPage.cerrarNavegadorclose();
    }
}
