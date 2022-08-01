package Engine;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Engine {
    private WebDriver webDriver;
    JavascriptExecutor javascriptExecutor;
    public Engine(WebDriver webDriver){
        this.webDriver = webDriver;
        javascriptExecutor = (JavascriptExecutor) webDriver;
    }

    public void urlCycle(String url){
        webDriver.get(url);

        List<WebElement> li = webDriver.findElements(By.tagName("a"));
        for(WebElement we : li){
            System.out.println(we.getAttribute("href"));
        }
    }
}
