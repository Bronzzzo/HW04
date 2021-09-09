package tests.televizorys;

import org.junit.jupiter.api.Assertions;
import pages.TelevizoryProductPage;

// Матчер с проверками страницы "Продукт.Телевизоры
public class TelevizorProductPageAssert {
    // Страница "Продукт.Телевизоры
    TelevizoryProductPage page;

//    Конструктор

    public TelevizorProductPageAssert(TelevizoryProductPage page) {
        this.page = page;
    }

    //    Проверка / Утверждение (Матчер)
    public void pageTitleEquals(String expected) {
        String actual = page.getPageTitle();
        Assertions.assertEquals(expected,actual,"Ошибка! Заголовок страницы не соответствует ожидаемому!");
    }

}
