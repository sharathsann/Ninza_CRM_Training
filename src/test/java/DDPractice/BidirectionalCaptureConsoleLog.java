package DDPractice;

import java.util.Optional;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v144.log.Log;
import org.openqa.selenium.devtools.v144.network.Network;
import org.testng.annotations.Test;

public class BidirectionalCaptureConsoleLog {

    @Test
    public void bidiTest()
    {
        ChromeDriver driver = new ChromeDriver();

        DevTools devTool = driver.getDevTools();

        // Create session ONLY ONCE
        devTool.createSession();

        // Enable console logs
        devTool.send(Log.enable());

        devTool.addListener(Log.entryAdded(), entry -> {
            System.out.println("Console Log: " + entry.getText());
        });

        // Enable network logs
        devTool.send(Network.enable(
                Optional.empty(), 
                Optional.empty(), 
                Optional.empty(), 
                Optional.empty(), 
                Optional.empty()
        ));


        // Capture network request
        devTool.addListener(Network.requestWillBeSent(), request -> {
            System.out.println("Request URL: " + request.getRequest().getUrl());
        });

        // Capture network response
        devTool.addListener(Network.responseReceived(), response -> {
            System.out.println("Response URL: " + response.getResponse().getUrl());
            System.out.println("Status Code: " + response.getResponse().getStatus());
        });

        driver.get("https://www.flipkart.com");
    }
}
