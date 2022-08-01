package connection;

import jmana.JmanaCrawler;
import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Connecter {
    public static String WEB_DRIVER_ID = "webdriver.chrome.driver";
    public static String WEB_DRIVER_PATH = "C:/Users/e2on/IdeaProjects/myproject/chromedriver.exe";
    private static final String UserAgent = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/101.0.4951.67 Safari/537.36";
    private static final String USER_AGENT = "User-Agent";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String MULTIPART_FORM_DATA = "multipart/form-data";
    private static final String FORM_URL_ENCODED = "application/x-www-form-urlencoded";
    WebDriver driver;
    String url;
    HttpURLConnection conn;
    public Connecter(String url) {
        this.url = url;
        System.setProperty(WEB_DRIVER_ID, WEB_DRIVER_PATH);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    public void start() {
        JmanaCrawler jmanaCrawler = new JmanaCrawler(driver, url);
        jmanaCrawler.start();
//        driver.get(url);
//        System.out.println(driver.getPageSource());
    }

// https://stackoverflow.com/questions/53286828/how-to-get-browser-network-logs-using-python-selenium
    //var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;
}


