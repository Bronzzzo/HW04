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
    // хедер - перекрывает вечно элементы - убрать его
    String mainBlockLogoContainerXpath = "//nav[@id='header-search']";
    //Диагональ экрана
    String linkScreenDiagonalInchXpath = "//span[contains(text(),' Диагональ экрана ')]/ancestor::td/following-sibling::td/div";
    //Частота обновления экрана
    String linkScreenRefreshXpath = "//span[contains(text(),' Частота обновления экрана ')]/ancestor::td/following-sibling::td/div";
    //Тип подсветки экрана
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

    //Получение Модель телевизора(производитель)
    public String getModelTvText() {
        Link linkModel = new Link(driver, By.xpath(linkModelXpath));
        String model = linkModel.getText();
        logger.info("Модель телевизора(производитель): " + model);
        return model;
    }

    //Получение диагонали экрана телевизора
    public String getScreenDiagonalInchText() {
        Link linkScreenDiagonal = new Link(driver, By.xpath(linkScreenDiagonalInchXpath));
        String diagonal = linkScreenDiagonal.getText();
        logger.info("Диагональ экрана: " + diagonal);
        return diagonal;
    }

    //    Получение Типа подсветки экрана
    public String getBacklightText() {
        Link linkBacklightType = new Link(driver, By.xpath(linkBacklightTypeXpath));
        String backlightType = linkBacklightType.getText();
        logger.info("Тип подсветки экрана: " + backlightType);
        return backlightType;
    }

    //Получение Частоты обновления экрана
    public String getScreenRefreshText() {
        Link linkScreenRefresh = new Link(driver, By.xpath(linkScreenRefreshXpath));
        String screenRefresh = linkScreenRefresh.getText();
        logger.info("Частота обновления экрана: " + screenRefresh);
        return screenRefresh;
    }


}
