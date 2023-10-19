package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;


public class AventajaPage extends BasePage{
    public AventajaPage(){
        super(driver);
    }

    public void navigateToAventaja(){
        navigateTo("https://www.advantageonlineshopping.com/#/");
    }


    //Metodo Button para abrir el formulario y loguearse
    public void clickLinkById(String linkId){
        WebDriverWait wait = new WebDriverWait(driver, 90);
        WebElement linkElement = wait.until(ExpectedConditions.elementToBeClickable(By.id(linkId)));
        linkElement.click();
    }

    //Metodo inputs para ingresar las credenciales
    public void FillLoginForm (String username, String password) throws InterruptedException {
        //Identificadores para los campos de entrada de usuario y contraseña
        WebElement usernameInput = driver.findElement(By.name("username"));
        WebElement passwordInput = driver.findElement(By.name("password"));

        // Esperar durante unos segundos
        Thread.sleep( 6000);

        //Ingresamos las credenciales correspondientes
        slowType(usernameInput, username);
        slowType(passwordInput, password);
    }

    //Metodo-Button para poder loguearse
    public void ClickSignInButton(String buttonId){
        WebDriverWait wait = new WebDriverWait(driver,95);
        WebElement signInButton = wait.until(ExpectedConditions.elementToBeClickable(By.id(buttonId))); //Este se identifica el button por medio del id
        sleep(15000);
        signInButton.click();
    }

    public void selectCategoryAfterDelay(String categoryName, long delayInSeconds) throws InterruptedException {

        // Esperar durante el tiempo especificado (en segundos)
        sleep(60000);

        // Encontrar el elemento de la categoría por el texto visible
        WebElement categoryElement = driver.findElement(By.xpath("//span[contains(text(), '" + categoryName + "')]"));
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.elementToBeClickable(categoryElement));
        // Hacer clic en el elemento de la categoría para seleccionarlo
        categoryElement.click();
        sleep(20000);
    }

    //Seleccionar un producto
    public void selectProductAfterDelay(String productName, long delayInSeconds) throws InterruptedException {
        // Esperar durante el tiempo especificado (en segundos)
        sleep(40000);

        // Encpntrar el elemento del producto
        WebElement productElement = driver.findElement(By.xpath("//img[@id='40' and @alt='' and contains(@class, 'imgProduct')]"));
        WebDriverWait wait = new WebDriverWait(driver, 80);
        wait.until(ExpectedConditions.elementToBeClickable(productElement));

        productElement.click();
    }

    private void slowType(WebElement element, String text) {
        for (char c : text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            sleep(90); // Espera 300 milisegundos entre cada carácter (ajusta el tiempo según tu preferencia)
        }
    }

    private void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    //DARLE CLIC PARA AGREGAR PRODUCTO
    public void clickAddToCartButton() {
// Esperar durante el tiempo especificado (en segundos)
        sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 95);
        WebElement addToCartButton = wait.until(ExpectedConditions.elementToBeClickable(By.name("save_to_cart")));
        addToCartButton.click();
    }


    //CLIC CARRITO DE COMPRA
    public void clickCartImage() {
        // Esperar durante el tiempo especificado (en segundos)
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 95);
        WebElement cartImage = wait.until(ExpectedConditions.elementToBeClickable(By.id("menuCart")));

        cartImage.click();
    }

    //BOTON PARA COMPRAR
    public void clickCheckout() {
        // Esperar durante el tiempo especificado (en segundos)
        sleep(3000);
        WebDriverWait wait = new WebDriverWait(driver, 95);
        WebElement checkoutButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkOutPopUp")));
        checkoutButton.click();
    }

    //BOTON PARA NEXT
    public void clickAdvantageNextButton() {
// Esperar durante el tiempo especificado (en segundos)
        sleep(4000);
        WebDriverWait wait = new WebDriverWait(driver, 95);
        WebElement nextButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("next_btn")));
        nextButton.click();
    }
    //CAMPO PARA LLENAR DATOS

    //CONFIRMAR PAGO
    public void clickPayButton() {
        sleep(15000);
        WebDriverWait wait = new WebDriverWait(driver, 80);

        WebElement payButton = wait.until(ExpectedConditions.elementToBeClickable(By.id("pay_now_btn_SAFEPAY")));
        payButton.click();
    }


    //Regresar a la página de inicio "HOME"
    public void clickHomeLink(){
        sleep(6000);
        WebDriverWait wait = new WebDriverWait(driver, 85);
        WebElement homeLink = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("HOME")));
        homeLink.click();
    }


    //---TERCERA PRUEBA A REALIZAR, ENVIAR CONTACT US
    //Se llena el formulario a mandar

    public void selectCategoria(){
        sleep(60000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement categoryselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("categoryListboxContactUs")));
        categoryselect.click();

        WebElement categoryOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(), 'Laptops')]")));
        categoryOption.click();
    }

    public void selectProduct(){
        sleep(30000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement producselect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("productListboxContactUs")));
        producselect.click();
        WebElement productOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//option[contains(text(), 'Notebook')]")));
        productOption.click();
    }

    public void selectEmail (String email) throws InterruptedException {
        sleep(30000);
        //Identificadores para los campos de entrada de usuario y contraseña
        WebElement usernameInput = driver.findElement(By.name("emailContactUs"));
          Thread.sleep( 6000);
           slowType(usernameInput, email);

    }

    public void enterTextarea(String text){
        sleep(20000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement textarea = wait.until(ExpectedConditions.presenceOfElementLocated(By.name("subjectTextareaContactUs")));
        textarea.click();

        textarea.clear();
        textarea.sendKeys(text);

    }

    public void clickSend(){
        sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement buttonSend = wait.until(ExpectedConditions.elementToBeClickable(By.id("send_btn")));
        buttonSend.click();


    }


    //CUARTA PRUEBA---- CERRAR SESIÓN
    public void clickSignOut(String linkIdOut){
        sleep(10000);
        WebDriverWait wait = new WebDriverWait(driver, 80);
        WebElement signOut = wait.until(ExpectedConditions.elementToBeClickable(By.id(linkIdOut)));
        signOut.click();
    }

    public void SignOff() {
        sleep(2000);
        // Usar JavascriptExecutor para hacer clic en el botón "Sign out"
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement buttonSignOut = driver.findElement(By.xpath("//label[contains(text(), 'Sign out')]"));
        executor.executeScript("arguments[0].click();", buttonSignOut);
    }













    @Override
    public void cerrarNavegadorclose() {
        super.cerrarNavegadorclose();
    }


}
