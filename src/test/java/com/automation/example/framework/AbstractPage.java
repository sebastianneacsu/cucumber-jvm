package com.automation.example.framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;


public abstract class AbstractPage {

    private WebDriver driver;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait driverWait(long timeoutSeconds) {
        return new WebDriverWait(driver, timeoutSeconds);
    }

 public String getEnvironment() {
        return "local";
    }

    public HashMap <String, String> getEnvProps(){
        HashMap<String, String> hmap = new HashMap();
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("src\\test\\resources\\data\\environment.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            if (this.getEnvironment() == "local"){
                hmap.put("username", prop.getProperty("localUsername"));
                hmap.put("url", prop.getProperty("localUrl"));
                hmap.put("password", prop.getProperty("localPassword"));
            } else if (this.getEnvironment() == "test"){
                hmap.put("username", prop.getProperty("testUsername"));
                hmap.put("url", prop.getProperty("testUrl"));
                hmap.put("password", prop.getProperty("testPassword"));
            }
            else if (this.getEnvironment() == "acc"){
                hmap.put("username", prop.getProperty("accUsername"));
                hmap.put("url", prop.getProperty("accUrl"));
                hmap.put("password", prop.getProperty("accPassword"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return hmap;
    }
    public void hardWait(Integer miliseconds){
        try {
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
