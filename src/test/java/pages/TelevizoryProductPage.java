package pages;

import elements.Link;
import elements.MainBlock;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Страница "Продукт. Телевизор"
public class TelevizoryProductPage extends BasePage {
    //логгер
    private Logger logger = LogManager.getLogger(TelevizoryProductPage.class);

    //    конструктор
    public TelevizoryProductPage(WebDriver driver) {
        super(driver);
    }

    // ***** Локаторы *****

    //Характиристики продукта
    String linkCharacteristicsXpath = "//a[contains(text(),'Характеристики')]";
    //    Модель/Производитель
    String linkModelXpath = "//span[contains(text(),'Модель')]/ancestor::td/following-sibling::td/div";

    String mainBlockLogoContainerXpath = "//nav[@id='header-search']";
    //Диагональ экрана
    String linkScreenDiagonalInchXpath = "//span[contains(text(),' Диагональ экрана ')]/ancestor::td/following-sibling::td/div";
    //Частота обновления экрана
    String linkScreenRefreshXpath = "//span[contains(text(),' Частота обновления экрана ')]/ancestor::td/following-sibling::td/div";
    //
    String linkBacklightTypeXpath = "//span[contains(text(),'Тип подсветки экрана')]/ancestor::td/following-sibling::td/div";


    //Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    // Нажать  на ссылку 'Характеристика'
    public void linkCharacteristicsClick() {
        Link linkCharacteristics = new Link(driver, By.xpath(linkCharacteristicsXpath));
        linkCharacteristics.click();
        logger.info("Нажата ссылка 'Характеристики'");
    }

    // скрыть хедер, чтобы не мешал)
    public void mainBlockLogoContainerHide() {
        MainBlock mainBlockLogoContainer = new MainBlock(driver, By.xpath(mainBlockLogoContainerXpath));
        mainBlockLogoContainer.hide();
        logger.info("Скрываем перекрывающий контейнер");
    }


    public void linkModelGetText() {
        Link linkModel = new Link(driver, By.xpath(linkModelXpath));
        String s = linkModel.getText();
        logger.info("Модель телевизора(производитель): " + s);
    }

}
