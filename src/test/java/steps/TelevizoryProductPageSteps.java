package steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TelevizoryProductPage;

public class TelevizoryProductPageSteps{
    // Логгер
    private Logger logger = LogManager.getLogger(TelevizoryPageSteps.class);
    // Ссылка на объект класса
    private TelevizoryProductPage televizoryProductPage;

    //    конструктор
    public TelevizoryProductPageSteps(TelevizoryProductPage televizoryProductPage) {
        //        Страница Продукт -> Телевизор
        this.televizoryProductPage = televizoryProductPage;
        logger.info("Открыта страница конкретной модели телевизора");
    }

    //    получение title страницы
    public String pageTitle() {
        return televizoryProductPage.getPageTitle();
    }

    // Нажать  на ссылку 'Характеристика'
    public void characteristicsClick() {
        televizoryProductPage.mainBlockLogoContainerHide();
        televizoryProductPage.linkCharacteristicsClick();
    }

    // скрыть хедер, чтобы не мешал)
    public void logoContainerHide() {
        televizoryProductPage.mainBlockLogoContainerHide();
    }

    //Получение Модель телевизора(производитель)
    public String modelTv() {
        return televizoryProductPage.getModelTvText();
    }

    //Получение диагонали экрана телевизора
    public String screenDiagonalInch() {
        return televizoryProductPage.getScreenDiagonalInchText();
    }

    //    Получение Типа подсветки экрана
    public String backlight() {
        return televizoryProductPage.getBacklightText();
    }

    //Получение Частоты обновления экрана
    public String screenRefresh() {
        return televizoryProductPage.getScreenRefreshText();
    }

}
