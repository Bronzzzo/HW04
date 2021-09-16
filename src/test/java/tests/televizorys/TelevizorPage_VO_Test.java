package tests.televizorys;

import models.TelevizoryBuilder;
import models.TelevizoryVO;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.DiagonalScreen;
import models.valueobjects.RefreshScreenValue;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.*;
import steps.StartPageSteps;
import steps.TelevizoryPageSteps;
import steps.TelevizoryProductPageSteps;
import tests.BaseTest;


import static helpers.ScreenShot.captureScreen;


@Execution(ExecutionMode.CONCURRENT)


public class TelevizorPage_VO_Test extends BaseTest {


    @ParameterizedTest
    @ValueSource(strings = {"Купить 75\" (189 см) Телевизор LED Samsung QE75Q950TSUXRU серый в интернет магазине DNS. Характеристики, цена Samsung QE75Q950TSUXRU | 8165296"})

    public void selectedProduct_Is_TV_PageTitleAssertTest(String expected) {

// 1. Arrange

        TelevizoryBuilder builder = new TelevizoryBuilder(
                new Company("Samsung"),
                new RefreshScreenValue(120),
                new BacklightType("Direct LED"),
                new DiagonalScreen(60, 80)
        );
        // Создание объекта
        TelevizoryVO televizoryVO = builder.build();

        // 2. Act

        TelevizoryProductPageSteps televizoryProductPageSteps = getProductPage2(televizoryVO);

        // 3. Assert

        TelevizorProductPageAssert televizorProductPageAssert = new TelevizorProductPageAssert(televizoryProductPageSteps);
        televizorProductPageAssert.pageTitleEquals(expected);

    }

    public TelevizoryProductPageSteps getProductPage2(TelevizoryVO televizoryVO) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");

        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(new StartPage(driver));
        // Наведение курсора мыши на ссылку "Телевизоры и медиа"
        // Нажатие на ссылку "Телевизоры"
        startPageSteps.clickLinkTV();
//        скрин экрана
        captureScreen(driver, "temp\\1.png");

        // ***** Страница "Телевизоры" *****
        TelevizoryPageSteps televizoryPageSteps = new TelevizoryPageSteps(new TelevizoryPage(driver));

        // Установка фильтра "Производитель"
        televizoryPageSteps.filterByCompany(televizoryVO.getCompany());
        //    Нажать на выпадашку "Выбор диагонали экрана"
        televizoryPageSteps.filterByDiagonalScreen(televizoryVO.getDiagonalScreen());
        //    Нажать на выпадашку "тип подсветки экрана"
        televizoryPageSteps.filterByBacklightType(televizoryVO.getBacklightType());
        //Нажатие на выпадашку "Частота обновления экрана"
        televizoryPageSteps.filterByRefreshScreen(televizoryVO.getRefreshScreenValue());
        // Нажать на кнопку 'Применить'
        televizoryPageSteps.clickButtonApply();
        // скрин экрана
        captureScreen(driver, "temp\\2.png");
        // Нажатие на выпадашку "Сортировка"
        // скрыть шапку сайта->нажать на сортировку->установить Сначала дорогие
        televizoryPageSteps.orderByExpensiveFirst();
        // скрин экрана
        captureScreen(driver, "temp\\3.png");
        // Нажатие на ссылку первого продукта в списке
        televizoryPageSteps.clickLinkFirstProduct();
        // сделать скрин
        captureScreen(driver, "temp\\4.png");

        // ***** Страница "Продукт.Телевизор" *****
        TelevizoryProductPageSteps televizoryProductPageSteps = new TelevizoryProductPageSteps(new TelevizoryProductPage(driver));
        // Получить заголовок страницы
        televizoryProductPageSteps.pageTitle();


        return new TelevizoryProductPageSteps(new TelevizoryProductPage(driver));

    }

//---------------------------------------------------------



//----------------------------------------------------------

    @ParameterizedTest
    @CsvSource({
            "'Samsung', 120, 'Direct LED', 60, 80"

    })
    public void selectedProduct_Is_TV_Multi_Assert_Test(String company, int refreshValue, String backlightType, int minValueScreenDiagonal, int maxValueScreenDiagonal) {
        // 1. Arrange

        TelevizoryBuilder builder = new TelevizoryBuilder(
                new Company("Samsung"),
                new RefreshScreenValue(120),
                new BacklightType("Direct LED"),
                new DiagonalScreen(60, 80)
        );
        // Создание объекта
        TelevizoryVO televizoryVO = builder.build();


        // 2. Act

        TelevizoryProductPageSteps televizoryProductPageSteps = getProductPage(televizoryVO);

        // 3. Assert

        TelevizorProductPageAssert televizorProductPageAssert = new TelevizorProductPageAssert(televizoryProductPageSteps);
        televizorProductPageAssert.pageModelTvEquals(company);
        televizorProductPageAssert.pageScreenRefresh(refreshValue);
        televizorProductPageAssert.pageBacklight(backlightType);
        televizorProductPageAssert.pageScreenDiagonalInch(minValueScreenDiagonal, maxValueScreenDiagonal);

    }


    public TelevizoryProductPageSteps getProductPage(TelevizoryVO televizoryVO) {
        // Открыть страницу https://www.dns-shop.ru/
        driver.get("https://www.dns-shop.ru/");

        // ***** Стартовая страница сайта DNS *****
        StartPageSteps startPageSteps = new StartPageSteps(new StartPage(driver));
        // Наведение курсора мыши на ссылку "Телевизоры и медиа"
        // Нажатие на ссылку "Телевизоры"
        startPageSteps.clickLinkTV();
//        скрин экрана
        captureScreen(driver, "temp\\5.png");

        // ***** Страница "Телевизоры" *****
        TelevizoryPageSteps televizoryPageSteps = new TelevizoryPageSteps(new TelevizoryPage(driver));

        // Установка фильтра "Производитель"
        televizoryPageSteps.filterByCompany(televizoryVO.getCompany());
        //    Нажать на выпадашку "Выбор диагонали экрана"
        televizoryPageSteps.filterByDiagonalScreen(televizoryVO.getDiagonalScreen());
        //    Нажать на выпадашку "тип подсветки экрана"
        televizoryPageSteps.filterByBacklightType(televizoryVO.getBacklightType());
        //Нажатие на выпадашку "Частота обновления экрана"
        televizoryPageSteps.filterByRefreshScreen(televizoryVO.getRefreshScreenValue());
        // Нажать на кнопку 'Применить'
        televizoryPageSteps.clickButtonApply();
        // скрин экрана
        captureScreen(driver, "temp\\6.png");
        // Нажатие на выпадашку "Сортировка"
        // скрыть шапку сайта->нажать на сортировку->установить Сначала дорогие
        televizoryPageSteps.orderByExpensiveFirst();
        // скрин экрана
        captureScreen(driver, "temp\\7.png");
        // Нажатие на ссылку первого продукта в списке
        televizoryPageSteps.clickLinkFirstProduct();
        // сделать скрин
        captureScreen(driver, "temp\\8.png");

        // ***** Страница "Продукт.Телевизор" *****
        TelevizoryProductPageSteps televizoryProductPageSteps = new TelevizoryProductPageSteps(new TelevizoryProductPage(driver));
        // Получить заголовок страницы
        televizoryProductPageSteps.pageTitle();
        // нажатие ссылки 'Характеристика продукта'
        televizoryProductPageSteps.characteristicsClick();
        // сделать скрин
        captureScreen(driver, "temp\\9.png");


        return new TelevizoryProductPageSteps(new TelevizoryProductPage(driver));

    }


}
