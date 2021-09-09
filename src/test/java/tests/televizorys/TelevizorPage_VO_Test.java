package tests.televizorys;

import helpers.JSExec;
import models.TelevizoryVO;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.DiagonalScreen;
import models.valueobjects.RefreshScreenValue;
import org.junit.jupiter.api.Test;
import pages.StartPage;
import pages.TelevizoryPage;
import pages.TelevizoryProductPage;
import tests.BaseTest;

import static helpers.ScreenShot.captureScreen;

public class TelevizorPage_VO_Test extends BaseTest {
    @Test
    public void selectedProduct_Is_TV_new() {
        // 1. Arrange
        String company = "Samsung  "; // производитель
        int refreshValue = 120;
        String backlightType = "Direct LED  ";
        int minValueScreenDiagonal = 60;
        int maxValueScreenDiagonal = 80;
        TelevizoryVO televizoryVO = new TelevizoryVO(
                new Company(company),
                new RefreshScreenValue(refreshValue),
                new BacklightType(backlightType),
                new DiagonalScreen(minValueScreenDiagonal, maxValueScreenDiagonal)
        );


        // 2. Act

        TelevizoryProductPage televizoryProductPage = getProductPage(televizoryVO);

// 3. Assert
        //  String expected = "Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296";
        String expected = "Технические характеристики 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый | 8165296 . Интернет-магазин DNS";
        TelevizorProductPageAssert televizorProductPageAssert = new TelevizorProductPageAssert(televizoryProductPage);
        televizorProductPageAssert.pageTitleEquals(expected);
    }


    public TelevizoryProductPage getProductPage(TelevizoryVO televizoryVO) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(driver);
        // Наведение курсора мыши на ссылку "Телевизоры и медиа"
        startPage.linkTvAndMultimediaMove();
        //Нажатие на ссылку "Телевизоры"
        startPage.linkTvClick();
//        скрин экрана
        captureScreen(driver, "temp\\1.png");
        // ***** Страница "Телевизоры" *****
        TelevizoryPage televizoryPage = new TelevizoryPage(driver);
//        скрыть шапку сайта
        televizoryPage.mainBlockHide();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1000);
        // Установка фильтра "Производитель"
        televizoryPage.chbxCompanyClick(televizoryVO.getCompany().getCompany());
        //    Нажать на выпадашку "Выбор диагонали экрана"
        televizoryPage.accordeonValueScreenDiagonalClick();
//        скрыть нижний контейнер сайта
        televizoryPage.mainСontainerBlockHide();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        //    Выбор минимальной диагонали экрана
        televizoryPage.inputMinValueScreenDiagonal(televizoryVO.getDiagonalScreen().getMinDiagonalScreen() + " дюймов");
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        //    Выбор максимальной диагонали экрана
        televizoryPage.inputMaxValueScreenDiagonal(televizoryVO.getDiagonalScreen().getMaxDiagonalScreen() + " дюймов");
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1000);
        //    Нажать на выпадашку "тип подсветки экрана"
        televizoryPage.accordeonBacklightTypeClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        // Установка фильтра 'Тип подсветки' - 'Direct LED'
        televizoryPage.chbxBacklightTypeClick(televizoryVO.getBacklightType().getBacklightType());
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1500);
        //Нажатие на выпадашку "Частота обновления экрана"
        televizoryPage.accordeonScreenRefreshClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1800);
        // Установка фильтра "Частота обновления экрана - 120 Гц"
        televizoryPage.chbxScreenRefreshClick(televizoryVO.getRefreshScreenValue().getRefreshScreenValue() + " Гц");
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1800);
        // Нажать на кнопку 'Применить'
        televizoryPage.btnApplyClick();
        // скрин экрана
        captureScreen(driver, "temp\\2.png");
        // Нажатие на выпадашку "Сортировка"
        televizoryPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        televizoryPage.rbtnExpensiveClick();
        // скрин экрана
        captureScreen(driver, "temp\\3.png");
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 500);
        // Нажатие на ссылку первого продукта в списке
        televizoryPage.linkFirstProductClick("Телевизор LED Samsung QE75Q950TSUXRU");
        // сделать скрин
        captureScreen(driver, "temp\\4.png");
        // ***** Страница "Продукт.Телевизор" *****
        TelevizoryProductPage televizoryProductPage = new TelevizoryProductPage(driver);
        televizoryProductPage.mainBlockLogoContainerHide();
        // Получить заголовок страницы
        televizoryProductPage.getPageTitle();
        // нажатие ссылки 'Характеристика продукта'
        televizoryProductPage.linkCharacteristicsClick();
        // сделать скрин
        captureScreen(driver, "temp\\5.png");

        televizoryProductPage.linkModelGetText();

        return new TelevizoryProductPage(driver);

    }

}
