package pages;

import elements.ClickElement;
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
    String clickCharacteristicsXpath = "//a[contains(text(),'Характеристики')]";
    //    Модель/Производитель
    String clickModelXpath = "//span[contains(text(),'Модель')]/ancestor::td/following-sibling::td/div";
    // хедер - перекрывает вечно элементы - убрать его
    String mainBlockLogoContainerXpath = "//nav[@id='header-search']";
    //Диагональ экрана
    String clickScreenDiagonalInchXpath = "//span[contains(text(),' Диагональ экрана ')]/ancestor::td/following-sibling::td/div";
    //Частота обновления экрана
    String clickScreenRefreshXpath = "//span[contains(text(),' Частота обновления экрана ')]/ancestor::td/following-sibling::td/div";
    //Тип подсветки экрана
    String clickBacklightTypeXpath = "//span[contains(text(),'Тип подсветки экрана')]/ancestor::td/following-sibling::td/div";


    //Получение заголовка текущей страницы
    public String getPageTitle() {
        String title = driver.getTitle();
        logger.info("Заголовок страницы: " + title);
        return title;
    }

    // Нажать  на ссылку 'Характеристика'
    public void linkCharacteristicsClick() {
        ClickElement clickCharacteristics = new ClickElement(driver, By.xpath(clickCharacteristicsXpath));
        clickCharacteristics.click();
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
        ClickElement clickModel = new ClickElement(driver, By.xpath(clickModelXpath));
        String model = clickModel.getText();
        logger.info("Модель телевизора(производитель): " + model);
        return model;
    }

    //Получение диагонали экрана телевизора
    public String getScreenDiagonalInchText() {
        ClickElement clickScreenDiagonal = new ClickElement(driver, By.xpath(clickScreenDiagonalInchXpath));
        String diagonal = clickScreenDiagonal.getText();
        logger.info("Диагональ экрана: " + diagonal);
        return diagonal;
    }

    //    Получение Типа подсветки экрана
    public String getBacklightText() {
        ClickElement clickBacklightType = new ClickElement(driver, By.xpath(clickBacklightTypeXpath));
        String backlightType = clickBacklightType.getText();
        logger.info("Тип подсветки экрана: " + backlightType);
        return backlightType;
    }

    //Получение Частоты обновления экрана
    public String getScreenRefreshText() {
        ClickElement clickScreenRefresh = new ClickElement(driver, By.xpath(clickScreenRefreshXpath));
        String screenRefresh = clickScreenRefresh.getText();
        logger.info("Частота обновления экрана: " + screenRefresh);
        return screenRefresh;
    }


}
