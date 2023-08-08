package qtriptest.pages;

import java.util.UUID;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class RegisterPage { 
    RemoteWebDriver driver;
    String url="https://qtripdynamic-qa-frontend.vercel.app";
    public String lastGeneratedUsername = "";


    @FindBy(xpath="//a[text()='Register']")
    WebElement register;

   @FindBy(name="email")
   WebElement username_txt_box;

@FindBy(name="password")
WebElement password_txt_box;

@FindBy(name="confirmpassword")
WebElement confirm_password_txt_box;

@FindBy(xpath="//button[text()='Register Now']")
WebElement register_now_button;

    public RegisterPage(RemoteWebDriver driver) {
        this.driver=driver;
        AjaxElementLocatorFactory ajax=new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(ajax, this);
    }

    public void navigateToRegisterPage() throws InterruptedException{

       
        if(!driver.getCurrentUrl().equals(this.url)){
            driver.get(this.url);
        }
    }

    public boolean registerNewUser(String username, String password, boolean generateRandomUsername) throws InterruptedException{

        if (generateRandomUsername) {
            // Concatenate the timestamp to string to form unique timestamp
            username = UUID.randomUUID().toString()+username;
        }

       //Thread.sleep(3000);
        register.click();
        
        username_txt_box.sendKeys(username);
        password_txt_box.sendKeys(password);
        confirm_password_txt_box.sendKeys(password);
        lastGeneratedUsername = username;

               register_now_button.click();
               Thread.sleep(3000);

        return this.driver.getCurrentUrl().endsWith("/login");
    }
}
