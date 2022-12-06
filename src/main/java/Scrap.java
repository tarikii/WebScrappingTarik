import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Scrap {

    File file;

    List<Character> characters = new ArrayList<>();
    List<Variant> variants = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public void start() {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        System.out.println("Que quieres scrappear: 1 - Plantas, 2 - Zombies, 0 - Salir");

        int opcionScrap = scanner.nextInt();

        if (opcionScrap == 1) {
            // Ir a la pagina Web.
            driver.get("https://plantsvszombies.fandom.com/wiki/Plants_(PvZ:_GW2)");
            // Este es la lista de links.
            List<String> li;
            // Este es la lista de campeones.
            List<Plant> zombies = new ArrayList<>();
            // Este es la variable que tiene el valor que usas para la espera.
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
            clicarBotonCookie(driver, driverWait);
            getCharacterInfoTable(driver);
            //getVariantInfoTable(driver);
        } else if (opcionScrap == 2) {
            // Ir a la pagina Web.
            driver.get("https://plantsvszombies.fandom.com/wiki/Zombies_(PvZ:_GW2)");
            // Este es la lista de links.
            List<String> li;
            // Este es la lista de campeones.
            List<Zombie> zombies = new ArrayList<>();
            // Este es la variable que tiene el valor que usas para la espera.
            WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

            //LLama a los metodos creados mas abajo de este codigo
            clicarBotonCookie(driver, driverWait);


        } else if (opcionScrap == 0) {
            System.out.println("Grasias vuelva pronto!");
            return;
        } else {
            System.out.println("Esta opcion no es valida para scrappear, las unicas opciones validas son la 1 y la 2");
        }
    }

    //En este metodo utilizamos el webdriver para aceptar las cookies de la pagina que queramos scrappear
    public static void clicarBotonCookie(WebDriver driver, WebDriverWait driverWait) {
            driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U"))); //NN0_TB_DIsNmMHgJWgT7U XHcr6qf5Sub2F2zBJ53S_"
            driver.findElement(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")).click();
    }

    public List<String> getCharactersURL(WebDriver driver){
        List<WebElement> links = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[2]/div/table/tbody/tr//th/a"));
        List<String> urls = new ArrayList<>();
        int counting = 0;

        for(WebElement link : links){
            counting++;
            if(counting != 1){
                urls.add(link.getAttribute("href"));
            }
        }
        return urls;
    }

    public List<Character> getCharacterInfoURL(WebDriver driver, List<String> urls){
        String descriptions, strategies;
        WebElement description, strategy;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        for(String info : urls){
            driver.get(info);
            try{
                wait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")));
            }catch (Exception e){
                description = driver.findElement(new By.ByXPath("/html/body/div[4]/div[3]/div[3]/main/div[3]/div[2]/div/p[4]/i"));
                descriptions = description.getText();
                strategy = driver.findElement(new By.ByXPath("/html/body/div[4]/div[3]/div[3]/main/div[3]/div[2]/div/p[11]"));
                strategies = strategy.getText();
                characters.add(new Character(descriptions,strategies));

            }
        }
        return characters;
    }


    public List<Character> getCharacterInfoTable(WebDriver driver) {
        int counting = 0;
        String name = "", image = "", health = "", variants = "", primaryWeapon = "", weaponDamage = "", abilties = "", fpsClass = "";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        List<WebElement> tableCharacters = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[2]/div/table/tbody//tr"));
        for (WebElement cells : tableCharacters) {
            counting++;
            if (counting != 1) {
                WebElement names = cells.findElement(new By.ByXPath("th/a"));
                name = names.getText();
            }

            List<WebElement> charactersLink = cells.findElements(new By.ByXPath("td[1]/a/img"));
            for (WebElement lin : charactersLink) {
                WebDriverWait drWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                javascriptExecutor.executeScript("window.scrollBy(0,900)");
                image = lin.getAttribute("src");
            }

            List<WebElement> characterHealths = cells.findElements(new By.ByXPath("td[2]"));
            for (WebElement hp : characterHealths) {
                health = hp.getText();
            }

            List<WebElement> characterVariants = cells.findElements(new By.ByXPath("td[3]/a"));
            for (WebElement var : characterVariants) {
                variants = var.getText();
            }

            List<WebElement> primaryWeapons = cells.findElements(new By.ByXPath("td[4]"));
            for (WebElement pr : primaryWeapons) {
                primaryWeapon = pr.getText();
            }

            List<WebElement> weaponsDamage = cells.findElements(new By.ByXPath("td[5]"));
            for (WebElement wpDmg : weaponsDamage) {
                weaponDamage = wpDmg.getText();
            }

            List<WebElement> characterAbilities = cells.findElements(new By.ByXPath("td[6]/a"));
            for (WebElement abi : characterAbilities) {
                abilties = abi.getText();
            }

            List<WebElement> characterFps = cells.findElements(new By.ByXPath("td[7]"));
            for (WebElement fps : characterFps) {
                fpsClass = fps.getText();
            }

            if (counting != 1) {
                characters.add(new Character(name, image, health, variants, primaryWeapon, weaponDamage, abilties, fpsClass));


                System.out.println("Character Name: " + name);
                System.out.println("Character pngLink: " + image);
                System.out.println("Character Health: " + health);
                System.out.println("Character Variants: " + variants);
                System.out.println("Character PrimaryWeapon: " + primaryWeapon);
                System.out.println("Character DamageWeapon: " + weaponDamage);
                System.out.println("Character Abilities: " + abilties);
                System.out.println("Character FPSClass: " + fpsClass);

            }
        }
        return characters;
    }

    /*public List<Variant> getVariantInfoTable(WebDriver driver) {
        int counting = 0;
        int counting2 = 0;
        String name = "", image = "", health = "", primaryWeapon = "", weaponDamage = "", variantPerk = "", rarity = "";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        List<WebElement> tableVariants = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[2]/div//table"));
        for (WebElement tables : tableVariants) {
            counting++;
            if(counting != 1){
                List<WebElement> trVariants = tables.findElements(new By.ByXPath("//tr"));

                for(WebElement cells : trVariants){
                    counting2++;

                    if(counting2 != 1){
                        WebElement names = tables.findElement(new By.ByXPath("th/a"));
                        name = names.getText();
                    }

                    List<WebElement> linksVariants = tables.findElements(new By.ByXPath("td[1]/a/img"));
                    for (WebElement im : linksVariants) {
                        WebDriverWait drWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                        javascriptExecutor.executeScript("window.scrollBy(0,2150)");
                        image = im.getAttribute("src");
                    }

                    List<WebElement> healthVariants = tables.findElements(new By.ByXPath("td[2]"));
                    for (WebElement he : healthVariants) {
                        health = he.getText();
                    }

                    List<WebElement> weaponsVariants = tables.findElements(new By.ByXPath("td[3]"));
                    for (WebElement we : weaponsVariants) {
                        primaryWeapon = we.getText();
                    }

                    List<WebElement> damageVariants = tables.findElements(new By.ByXPath("td[4]"));
                    for (WebElement weDmg : damageVariants) {
                        weaponDamage = weDmg.getText();
                    }

                    List<WebElement> perksVariants = tables.findElements(new By.ByXPath("td[5]"));
                    for (WebElement per : perksVariants) {
                        variantPerk = per.getText();
                    }

                    List<WebElement> rarityVariants = tables.findElements(new By.ByXPath("td[6]"));
                    for (WebElement rar : rarityVariants) {
                        rarity = rar.getText();
                    }
                }
            }
        }

        return variants;
    }*/
}