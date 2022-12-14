import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Scrap {

    File file;

    List<Character> characters = new ArrayList<>();

    List<Character> charactersTables = new ArrayList<>();
    List<Character> charactersURLs = new ArrayList<>();
    List<Variant> variants = new ArrayList<>();
    List<Variant> variantsTables = new ArrayList<>();
    List<Variant> variantsURLs = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    boolean salir = false;

    /**
     * Este metodo hara absolutamente todo1 el scrappeo, tanto el de las tablas como el de las URLs
     */
    public void start() {
        System.out.println(System.getenv("PATH"));
        System.out.println(System.getenv("HOME"));

        System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
        FirefoxOptions options = new FirefoxOptions();
        WebDriver driver = new FirefoxDriver(options);

        /**
         * Aqui mostrara un bucle, donde mostrara 3 opciones, que decidira el usuario que scrappear
         */

        while (!salir){
            System.out.println("Que quieres scrappear: 1 - Plantas, 2 - Zombies, 0 - Salir");

            int opcionScrap = scanner.nextInt();

            if (opcionScrap == 1) {
                // Ir a la pagina Web.
                driver.get("https://plantsvszombies.fandom.com/wiki/Plants_(PvZ:_GW2)");
                // Esta es la lista de las URLs de characters.
                List<String> urls = null;
                // Esta es la lista de las URLs de variantes.
                List<String> urlsSupport = null;
                //Creamos un driverWait para ir esperando por si queremos cambiar de pagina o darle click a un boton.
                WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(120));
                //LLama al metodo creado abajo de este codigo que nos clicka las cookies
                clicarBotonCookie(driver, driverWait);
                charactersTables = getCharacterInfoTable(driver, driverWait);
                CSVCharactersTable csvTables = new CSVCharactersTable(charactersTables);
                variantsTables = getVariantInfoTable(driver,driverWait);
                CSVariantsTable csVariantsTables = new CSVariantsTable(variantsTables);
                JAXBCharacter xmlCharacterTables = new JAXBCharacter(charactersTables);
                JAXBVariant xmlVariantTables = new JAXBVariant(variantsTables);
                urls = getCharactersURL(driver,driverWait);
                urlsSupport = getVariantsURL(driver,driverWait);
                charactersURLs = getCharacterInfoURL(driver,urls,driverWait);
                CSVCharactersURLs urlsCSV = new CSVCharactersURLs(charactersURLs);
                variantsURLs = getVariantInfoURL(driver,urlsSupport,driverWait);
                CSVariantsURLs urlsVariantsCSV = new CSVariantsURLs(variantsURLs);

            } else if (opcionScrap == 2) {
                // Ir a la pagina Web.
                driver.get("https://plantsvszombies.fandom.com/wiki/Zombies_(PvZ:_GW2)");
                // Esta es la lista de las URLs de characters.
                List<String> urls = null;
                // Esta es la lista de las URLs de variantes.
                List<String> urlsSupport = null;
                // Creamos un driverWait para ir esperando por si tiene que cambiar de pagina o darle click a algo.
                WebDriverWait driverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
                //LLama al metodo creado abajo de este codigo que nos clicka las cookies
                clicarBotonCookie(driver, driverWait);
                getCharacterInfoTable(driver, driverWait);
                urls = getCharactersURL(driver,driverWait);
                getCharacterInfoURL(driver,urls,driverWait);


            } else if (opcionScrap == 0) {
                salir = true;
                System.out.println("Grasias vuelva pronto!");
                return;
            } else {
                System.out.println("Esta opcion no es valida para scrappear, las unicas opciones validas son la 1 y la 2");
            }
        }
    }

    //En este metodo utilizamos el webdriver para aceptar las cookies de la pagina que queramos scrappear
    public static void clicarBotonCookie(WebDriver driver, WebDriverWait driverWait) {
            try{
                driverWait.until(ExpectedConditions.elementToBeClickable(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U"))); //NN0_TB_DIsNmMHgJWgT7U XHcr6qf5Sub2F2zBJ53S_"
                driver.findElement(new By.ByClassName("NN0_TB_DIsNmMHgJWgT7U")).click();
            }catch (Exception e){

            }

    }

    /**
     * Pilla las URLs de los characters
     */
    public List<String> getCharactersURL(WebDriver driver, WebDriverWait wait){
        List<WebElement> links = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[2]/div//table/tbody//tr//th/a"));
        List<String> urls = new ArrayList<>();
        int counting = 0;

        for(WebElement link : links){
            counting++;
            if(counting != 1){
                urls.add(link.getAttribute("href"));
            }
        }
        urls.forEach(System.out::println);
        return urls;
    }

    /**
     * Pilla las URLs de las variantes
     */
    public List<String> getVariantsURL(WebDriver driver, WebDriverWait wait){
        List<WebElement> links = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[3]/div//table/tbody//tr//th/a"));
        List<String> urls = new ArrayList<>();
        int counting = 0;

        for(WebElement link : links){
            counting++;
            if(counting != 1){
                urls.add(link.getAttribute("href"));
            }
        }
        urls.forEach(System.out::println);
        return urls;
    }

    /**
     * Pilla la informacion de las URLs
     */
    public List<Character> getCharacterInfoURL(WebDriver driver, List<String> urls, WebDriverWait wait){
        String names = "", descriptions = "", strategies = "";


        for(String info : urls){
            driver.get(info);
            WebElement informationCube = driver.findElement(new By.ByCssSelector(".portable-infobox"));

            try{
                names = informationCube.findElement(new By.ByCssSelector(".pi-title > b:nth-child(1)")).getText();
            }catch (Exception e){
                names = informationCube.findElement(new By.ByCssSelector("h2.pi-item")).getText();
            }

            informationCube = driver.findElement(new By.ByCssSelector(".mw-parser-output"));
            try{
                descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
            }catch (Exception e){
                try{
                    descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(19) > i:nth-child(1)")).getText();
                }catch (Exception e2){
                    try{
                        descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(20) > i:nth-child(1)")).getText();
                    }catch (Exception e3){
                        try{
                            descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
                        }catch (Exception e4){
                            try{
                                descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(16) > i:nth-child(1)")).getText();
                            }catch (Exception e5){
                                try{
                                    descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(13) > i:nth-child(1)")).getText();
                                }catch (Exception e6){
                                    try{
                                        descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(14) > i:nth-child(1)")).getText();
                                    }catch (Exception e7){
                                        try{
                                            descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
                                        }catch (Exception e8){

                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            try{
                strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(53)")).getText();
            }catch (Exception e){
                try{
                    strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(42)")).getText();
                }catch (Exception e2){
                    try{
                        strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(54)")).getText();
                    }catch (Exception e3){
                        try{
                            strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(41)")).getText();
                        }catch (Exception e4){
                            try{
                                strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(31)")).getText();
                            }catch (Exception e5){
                                try{
                                    strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(34)")).getText();
                                }catch (Exception e6){
                                    try{
                                        strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > ul:nth-child(35) > li:nth-child(4)")).getText();
                                    }catch (Exception e7){
                                        try{
                                            strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(29)")).getText();
                                        }catch (Exception e8){

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                }

            characters.add(new Character(names,descriptions,strategies));

            System.out.println("Character Name: " + names);
            System.out.println("Character Description: " + descriptions);
            System.out.println("Character Strategy: " + strategies);
        }
        return characters;
    }

    public List<Variant> getVariantInfoURL(WebDriver driver, List<String> urls, WebDriverWait wait){
        String names = "", descriptions = "", strategies = "";


        for(String info : urls){
            driver.get(info);
            WebElement informationCube = driver.findElement(new By.ByCssSelector(".portable-infobox"));

            try{
                names = informationCube.findElement(new By.ByCssSelector(".pi-title > b:nth-child(1)")).getText();
            }catch (Exception e){
                names = informationCube.findElement(new By.ByCssSelector("h2.pi-item")).getText();
            }

            informationCube = driver.findElement(new By.ByCssSelector(".mw-parser-output"));
            try{
                descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
            }catch (Exception e){
                try{
                    descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(19) > i:nth-child(1)")).getText();
                }catch (Exception e2){
                    try{
                        descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(20) > i:nth-child(1)")).getText();
                    }catch (Exception e3){
                        try{
                            descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
                        }catch (Exception e4){
                            try{
                                descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(16) > i:nth-child(1)")).getText();
                            }catch (Exception e5){
                                try{
                                    descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(13) > i:nth-child(1)")).getText();
                                }catch (Exception e6){
                                    try{
                                        descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(14) > i:nth-child(1)")).getText();
                                    }catch (Exception e7){
                                        try{
                                            descriptions = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(17) > i:nth-child(1)")).getText();
                                        }catch (Exception e8){

                                        }
                                    }
                                }
                            }
                        }

                    }
                }
            }
            try{
                strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(53)")).getText();
            }catch (Exception e){
                try{
                    strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(42)")).getText();
                }catch (Exception e2){
                    try{
                        strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(54)")).getText();
                    }catch (Exception e3){
                        try{
                            strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(41)")).getText();
                        }catch (Exception e4){
                            try{
                                strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(31)")).getText();
                            }catch (Exception e5){
                                try{
                                    strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(34)")).getText();
                                }catch (Exception e6){
                                    try{
                                        strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > ul:nth-child(35) > li:nth-child(4)")).getText();
                                    }catch (Exception e7){
                                        try{
                                            strategies = informationCube.findElement(new By.ByCssSelector(".mw-parser-output > p:nth-child(29)")).getText();
                                        }catch (Exception e8){

                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            variants.add(new Variant(names,descriptions,strategies));

            System.out.println("Character Name: " + names);
            System.out.println("Character Description: " + descriptions);
            System.out.println("Character Strategy: " + strategies);
        }
        return variants;
    }


    public List<Character> getCharacterInfoTable(WebDriver driver, WebDriverWait wait) {
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

    public List<Variant> getVariantInfoTable(WebDriver driver, WebDriverWait wait) {
        int counting = 0;
        String name = "", image = "", health = "", primaryWeapon = "", weaponDamage = "", variantPerk = "", rarity = "";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        List<WebElement> tableCharacters = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div/div[3]/div/table/tbody//tr"));
        for (WebElement cells : tableCharacters) {
            counting++;
            if (counting != 1) {
                WebElement names = cells.findElement(new By.ByXPath("th/a"));
                name = names.getText();
            }

            List<WebElement> variantsLink = cells.findElements(new By.ByXPath("td[1]/a/img"));
            for (WebElement lin : variantsLink) {
                WebDriverWait drWait = new WebDriverWait(driver, Duration.ofSeconds(10));
                javascriptExecutor.executeScript("window.scrollBy(0,900)");
                image = lin.getAttribute("src");
            }

            List<WebElement> variantsHealths = cells.findElements(new By.ByXPath("td[2]"));
            for (WebElement hp : variantsHealths) {
                health = hp.getText();
            }

            List<WebElement> primaryWeapons = cells.findElements(new By.ByXPath("td[3]"));
            for (WebElement pr : primaryWeapons) {
                primaryWeapon = pr.getText();
            }

            List<WebElement> weaponsDamage = cells.findElements(new By.ByXPath("td[4]"));
            for (WebElement wpDmg : weaponsDamage) {
                weaponDamage = wpDmg.getText();
            }

            List<WebElement> variantsPerk = cells.findElements(new By.ByXPath("td[5]"));
            for (WebElement var : variantsPerk) {
                variantPerk = var.getText();
            }

            List<WebElement> variantsRarity = cells.findElements(new By.ByXPath("td[6]"));
            for (WebElement rar : variantsRarity) {
                rarity = rar.getText();
            }

            if (counting != 1) {
                variants.add(new Variant(name, image, health, primaryWeapon, weaponDamage,variantPerk,rarity));


                System.out.println("Character Name: " + name);
                System.out.println("Character pngLink: " + image);
                System.out.println("Character Health: " + health);
                System.out.println("Character PrimaryWeapon: " + primaryWeapon);
                System.out.println("Character DamageWeapon: " + weaponDamage);
                System.out.println("Character variantPerk: " + variantPerk);
                System.out.println("Character Rarity: " + rarity);

            }
        }
        return variants;
    }

    /*public List<Variant> getVariantInfoTable(WebDriver driver) {
        int counting = 0;
        int counting2 = 0;
        String name = "", image = "", health = "", primaryWeapon = "", weaponDamage = "", variantPeak = "", rarity = "";
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        List<WebElement> tableCharacters = driver.findElements(new By.ByXPath("/html/body/div[4]/div[3]/div[2]/main/div[3]/div[2]/div//div/div/table/tbody"));
        for(WebElement tables : tableCharacters){
            counting2++;
            if(counting2 != 1 && counting2 != 9 && counting2 != 10){
                List<WebElement> trs = tables.findElements(new By.ByXPath("//tr"));
                for (WebElement cells : trs) {
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

                    List<WebElement> primaryWeapons = cells.findElements(new By.ByXPath("td[3]"));
                    for (WebElement pr : primaryWeapons) {
                        primaryWeapon = pr.getText();
                    }

                    List<WebElement> weaponsDamage = cells.findElements(new By.ByXPath("td[4]"));
                    for (WebElement wpDmg : weaponsDamage) {
                        weaponDamage = wpDmg.getText();
                    }

                    List<WebElement> variantPeaks = cells.findElements(new By.ByXPath("td[5]"));
                    for (WebElement var : variantPeaks) {
                        variantPeak = var.getText();
                    }

                    List<WebElement> variantRarities = cells.findElements(new By.ByXPath("td[6]"));
                    for (WebElement rar : variantRarities) {
                        rarity = rar.getText();
                    }

                    if (counting != 1) {
                        variants.add(new Variant(name,image,health,primaryWeapon,weaponDamage,variantPeak,rarity));


                        System.out.println("Character Name: " + name);
                        System.out.println("Character pngLink: " + image);
                        System.out.println("Character Health: " + health);
                        System.out.println("Character PrimaryWeapon: " + primaryWeapon);
                        System.out.println("Character DamageWeapon: " + weaponDamage);
                        System.out.println("Character variantPerk: " + variantPeak);
                        System.out.println("Character Rarity: " + rarity);

                    }
                }
            }
        }
        return variants;
    }*/
}