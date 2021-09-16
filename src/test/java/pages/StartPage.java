package pages;

import elements.ClickElement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class StartPage extends BasePage {
    // Логгер
    private Logger logger = LogManager.getLogger(StartPage.class);
    //URL страницы
    private final String URL = "https://www.dns-shop.ru/";

    //          ***** Локаторы *****
    //    Ссылка на "ТВ и мультимедиа"
    String clickTvAndMultimediaXpath = "//a[contains(text(),'ТВ и мультимедиа')]";
    //    Ссылка на "Телевизоры"
    String clickTvXpath = "(//a[contains(text(), 'Телевизоры')])[position()='2']";

    //    Конструктор класса
    public StartPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // Получение URL страницы
    public String getURL() {
        return this.URL;
    }

    // Открытие страницы
    public void openPage() {
        driver.get(this.URL);
        logger.info("Открыта страница https://www.dns-shop.ru/");
    }

    //    Наведение курсора на ссылку "ТВ и мультимедиа"
    public void clickTvAndMultimediaMove() {
        ClickElement clickTvAndMultimedia = new ClickElement(driver, By.xpath(clickTvAndMultimediaXpath));
        clickTvAndMultimedia.focusOnLink();
        logger.info("Курсор мыши наведен на ссылку 'ТВ и мультимедиа'");
}

    //Нажатие на ссылку "Телевизоры"
    public void clickTvClick() {
        ClickElement clickTv = new ClickElement(driver, By.xpath(clickTvXpath));
        clickTv.click();
        logger.info("Нажата ссылка 'Телевизоры'");
    }

}
