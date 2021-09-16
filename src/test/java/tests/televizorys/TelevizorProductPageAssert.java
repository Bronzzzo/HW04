package tests.televizorys;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import pages.TelevizoryProductPage;
import steps.TelevizoryProductPageSteps;


// Матчер с проверками страницы "Продукт.Телевизоры
public class TelevizorProductPageAssert {
    //    Страница "Продукт.Телевизоры
    TelevizoryProductPageSteps televizoryProductPageSteps;

//    String company ; // производитель
//    int refreshValue;
//    String backlightType;
//    int minValueScreenDiagonal;
//    int maxValueScreenDiagonal;
//    String expected;
//
//
//    public TelevizorProductPageAssert(TelevizoryProductPage page, String company, int refreshValue, String backlightType, int minValueScreenDiagonal, int maxValueScreenDiagonal, String expected) {
//
//        this.page = page;
//        this.company = company;
//        this.refreshValue = refreshValue;
//        this.backlightType = backlightType;
//        this.minValueScreenDiagonal = minValueScreenDiagonal;
//        this.maxValueScreenDiagonal = maxValueScreenDiagonal;
//        this.expected = expected;
//    }

    //    логгер
    private Logger logger = LogManager.getLogger(TelevizorProductPageAssert.class);
    //    Конструктор


    public TelevizorProductPageAssert(TelevizoryProductPageSteps televizoryProductPageSteps) {
        this.televizoryProductPageSteps = televizoryProductPageSteps;
    }

    //    Проверка / Утверждение (Матчер)
    //    проверка заголовка страницы
    public void pageTitleEquals(String expectedTitle) {
        String actual = televizoryProductPageSteps.pageTitle();
        Assertions.assertEquals(expectedTitle, actual, "Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }


    // проверка модели телевизора
    public void pageModelTvEquals(String expectedModelTv) {
        String actual = televizoryProductPageSteps.modelTv().replaceAll(" .*", "");
        Assertions.assertEquals(expectedModelTv, actual, "Ошибка! Модель телевизора не соответствует ожидаемому!");
    }
    // проверка диагонали экрана
    public void pageScreenDiagonalInch(int minExpected, int maxExpected) {
        String actualString = televizoryProductPageSteps.screenDiagonalInch();
        int actualInt = Integer.parseInt(actualString.replaceAll("[^\\d]", ""));
        Assertions.assertTrue(actualInt >= minExpected && actualInt <= maxExpected, "Ошибка! Диагональ экрана телевизора не соответствует ожидаемому!");

    }
    //  проверка тиа подсветки экрана
    public void pageBacklight(String expectedBacklight) {
        String actual = televizoryProductPageSteps.backlight();
        Assertions.assertEquals(expectedBacklight, actual, "Ошибка! Тип подсветки экрана телевизора не соответствует ожидаемому!");
    }
    //  проверка частоты обновления экрана
    public void pageScreenRefresh(int expectedScreenRefresh) {
        String actual = televizoryProductPageSteps.screenRefresh();
        int actualInt = Integer.parseInt(actual.replaceAll("[^\\d]", ""));
        Assertions.assertEquals(expectedScreenRefresh, actualInt, "Ошибка! Частота обновления экрана телевизора не соответствует ожидаемому!");
    }


}
