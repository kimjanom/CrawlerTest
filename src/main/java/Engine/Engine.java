package Engine;

import com.sun.xml.internal.ws.resources.UtilMessages;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Engine {
    private WebDriver webDriver;
    JavascriptExecutor javascriptExecutor;

    public Engine(WebDriver webDriver) {
        this.webDriver = webDriver;
        javascriptExecutor = (JavascriptExecutor) webDriver;
    }

    public void urlCycle(String url) {
        webDriver.get(url);
        List<String> list = new ArrayList<>();
        final List<WebElement> li = webDriver.findElements(By.xpath("//*[@href]"));
//        WebElement li1 =  webDriver.findElement(By.xpath("//@href"));
//        List<WebElement> li = webDriver.findElements(By.tagName("a"));
        System.out.println("띠용띠용" + li);

        for (WebElement we : li) {
            try {
                String a = we.getAttribute("href");
                list.add(a);
            } catch (StaleElementReferenceException e) {
            }
        }
        //중복제거
        List<String> newList = list.stream().distinct().collect(Collectors.toList());
    }

    public void imageCollecter(String url){
        JSONObject jsonObject = null;
        JSONParser jsonParser = new JSONParser();
        webDriver.get(url);
        ArrayList<String> a = (ArrayList<String>) javascriptExecutor.executeScript("var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;");
        Object a1 =  javascriptExecutor.executeScript("var performance = window.performance || window.mozPerformance || window.msPerformance || window.webkitPerformance || {}; var network = performance.getEntries() || {}; return network;");
        try {
            jsonObject = (JSONObject) jsonParser.parse(String.valueOf(a1));
        }catch (org.json.simple.parser.ParseException e){
            System.out.println("실패");

        }System.out.println("띠용띠용"+jsonObject);
        System.out.println("띠용띠용"+a);
        System.out.println("띠용띠용"+a1);
    }
}

//js 이미지 수집
//    var li = []
//        function a(asd){
//        for(i in asd){
//        if(asd[i].initiatorType == 'img'){
//        li.push(asd[i].name)
//        }
//        }
//        }