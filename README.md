#Proyecto Webscrapping Tarik Aabouch:

>- Este proyecto trata de hacer un WebScrapping con ayuda de la clase WebDriver a dos webs, una que contiene una tabla de Plantas y otra de Zombies. Las informaciones se recogen con WebElement y se generan luego en formato CSV y XML con la libreria de Maven openCSV y JAXB.
>- El proyecto también contiene un JavaDoc, que explica cada clase, sus metodos y sus atributos


# Como funciona?
>- Funciona de tal manera que tu cuando ejecutas aparecera un menu en el terminal, te dara 2 opciones para scrappear, la pagina de plantas y la pagina de zombies, otra opcion es por si quieres salir del programa. Tardara un rato ya que aunque WebScrappear una pagina ya tarde, ademas se ha metido un WebDriverWait, para que le de tiempo al driver de cambiar de paginas y entrar en los links, ya sea de plantas o de zombies.
>- Imaginemos que le hemos dado a la opcion de Plantas. Entraremos en la pagina de plantas, scrappearemos las primeras 2 tablas (las plantas principales y sus variantes). Una vez hecho este scrappeo, entrara a los links, que estan enlazados a los nombres de los personajes, y por cada link sacara la informacion que interesa en el codigo.
>- Una vez hecho todo este scrappeo, envias esos datos a las clases CSV y JAXB, donde se crearan los ficheros CSV y XML por separado, tanto las URL como las tablas.
