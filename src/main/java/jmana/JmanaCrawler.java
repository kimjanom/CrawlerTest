package jmana;

import Engine.Engine;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class JmanaCrawler extends Thread{
    private WebDriver webDriver;
    private JavascriptExecutor javascriptExecutor;
    private String url;

    public JmanaCrawler(WebDriver webDriver,String url){
        this.url = url;
        this.webDriver = webDriver;
         javascriptExecutor = (JavascriptExecutor) webDriver;
    }

    @Override
    public void run(){
        Engine engine = new Engine(webDriver);
        engine.urlCycle(url);
    }
}
