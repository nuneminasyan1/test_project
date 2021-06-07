import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends TaigaBasePage {

    private final By usernameFieldLocation = By.cssSelector("[name='username']");
    private final By passwordFieldLocation = By.cssSelector("[name='password']");
    private final By loginButtonLocation = By.cssSelector("[class*='login-password']");
    private final By avatarLocation = By.cssSelector("[class*='user-avatar']");



    public LoginPage() {
        open("https://tree.taiga.io/login");
    }

    @Override
    public String getUrl() {
        return BASE_URL;
    }

    public void clickLoginButton() {
        WebElement loginButton = find(loginButtonLocation);
        loginButton.click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(usernameFieldLocation));
        click(loginButtonLocation);
    }

    public void typeUsername(String username) {

        type(usernameFieldLocation, username);
    }

    public void typePassword(String password) {

        type(passwordFieldLocation, password);
    }

    public void clickLoginButtonLocation() {
        click(loginButtonLocation);

    }
    public boolean isAvatarDisplayed() {
        return find(avatarLocation).isDisplayed();
    }
    public boolean isUserLoggedIn() {
        WebElement avatarIcon = new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfElementLocated(avatarLocation));
        return avatarIcon.isDisplayed();
    }


}


