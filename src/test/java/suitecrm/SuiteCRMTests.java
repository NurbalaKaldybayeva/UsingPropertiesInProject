package suitecrm;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import static utilities.ConfigReader.*;

public class SuiteCRMTests extends TestBase {
//WebDriver driver;
LoginPage loginPage;
HomePage homePage;
CreateTaskPage createTaskPage;
TaskOverviewPage taskOverviewPage;


@BeforeMethod
public void navigate(){
	driver.get(getProperty("suitecrm.url"));
	loginPage = new LoginPage(driver);
	homePage= new HomePage(driver);
	createTaskPage= new CreateTaskPage(driver);
	taskOverviewPage= new TaskOverviewPage(driver);
}

@Test
public void createTaskInSuiteCRM(){
//	driver.get(ConfigReader.getMyValue("suitecrm.url"));
//	loginPage = new LoginPage(driver);
	loginPage.login(getProperty("suitecrm.username"), getProperty("suitecrm.password"));
homePage.createNewItem("Create Task");
createTaskPage.subject.sendKeys(getProperty("suitecrm.tasksubject"));
new Select(createTaskPage.status).selectByVisibleText(getProperty("suitecrm.taskstatus"));
createTaskPage.description.sendKeys(getProperty("suitecrm.description")+"-"+LocalDateTime.now());
createTaskPage.save.click();
}
}
