package tests;

import helpers.JSExec;

import static helpers.ScreenShot.captureScreen;

import org.junit.jupiter.api.Test;
import pages.StartPage;
import pages.TelevizoryPage;
import pages.TelevizoryProductPage;


public class TelevizorPage_Test extends BaseTest {
    @Test
    public void selectedProduct_Is_TV() {
        // 1. Arrange
        String company = "Samsung  "; // производитель
        String refreshValue = "120 Гц  ";
        String backlightType = "Direct LED  ";
        String minValueScreenDiagonal = "60";
        String maxValueScreenDiagonal = "80";


        // 2. Act

        TelevizoryPage televizoryPage = getProductPage(company, refreshValue, backlightType, minValueScreenDiagonal, maxValueScreenDiagonal);


    }

    public TelevizoryPage getProductPage(String company, String refreshValue, String backlightType, String minValueScreenDiagonal, String maxValueScreenDiagonal) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");
        // ***** Стартовая страница сайта DNS *****
        StartPage startPage = new StartPage(driver);
        // Наведение курсора мыши на ссылку "Телевизорф и медиа"
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
        televizoryPage.chbxCompanyClick(company);
        //    Нажать на выпадашку "Выбор диагонали экрана"
        televizoryPage.accordeonValueScreenDiagonalClick();
//        скрыть нижний контейнер сайта
        televizoryPage.mainСontainerBlockHide();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        //    Выбор минимальной диагонали экрана
        televizoryPage.inputMinValueScreenDiagonal(minValueScreenDiagonal);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        //    Выбор максимальной диагонали экрана
        televizoryPage.inputMaxValueScreenDiagonal(maxValueScreenDiagonal);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1000);
        //    Нажать на выпадашку "тип подсветки экрана"
        televizoryPage.accordeonBacklightTypeClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        // Установка фильтра 'Тип подсветки' - 'Direct LED'
        televizoryPage.chbxBacklightTypeClick(backlightType);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1500);
        //Нажатие на выпадашку "Частота обновления экрана"
        televizoryPage.accordeonScreenRefreshClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1800);
        // Установка фильтра "Частота обновления экрана - 120 Гц"
        televizoryPage.chbxScreenRefreshClick(refreshValue);
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

        return new TelevizoryPage(driver);

    }

}
