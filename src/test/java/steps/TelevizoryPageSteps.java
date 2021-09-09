package steps;

import helpers.JSExec;
import models.valueobjects.BacklightType;
import models.valueobjects.Company;
import models.valueobjects.RefreshScreenValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.TelevizoryPage;

//    Шаги на странице "Телевизоры"
public class TelevizoryPageSteps {
    // Логгер
    private Logger logger = LogManager.getLogger(TelevizoryPageSteps.class);
    // Ссылка на объект класса
    private TelevizoryPage televizoryPage;

    //    конструктор
    public TelevizoryPageSteps(TelevizoryPage televizoryPage) {
//        Страница Телевизоры
        this.televizoryPage = televizoryPage;
        logger.info("Открыта страница 'Телевизоры'");
    }

    //   Установка сортировки "Сначала дорогие"
    public void orderByExpensiveFirst() {
        // Нажатие на выпадашку "Сортировка"
        televizoryPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        televizoryPage.rbtnExpensiveClick();
    }

    //    Установка фильтра "Производитель"
    public void filterByCompany(Company company) {
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 300);
        // Установка фильтра "Производитель"
        televizoryPage.chbxCompanyClick(company.getCompany());
    }

    //Установка фильтра "Частота обновления экрана"
    public void filterByRefreshScreen(RefreshScreenValue refreshScreenValue) {
//        Прокрутка страницы вниз
        JSExec.scrollBy(0, 1500);
//        Нажатие на гармошку "Частота обновления экрана"
        televizoryPage.accordeonScreenRefreshClick();
//        Прокрутка страницы вниз
        JSExec.scrollBy(0, 1500);
//        Установка фильтра "Частота обновления экрана"
        televizoryPage.chbxScreenRefreshClick(refreshScreenValue.getRefreshScreenValue() + "Гц");
    }

    //    Установка фильтра "Тип подсветки экрана"
    public void filterByBacklightType(BacklightType backlightType) {
//        Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
//        Нажатие на гармошку "Тип подсветки экрана"
        televizoryPage.accordeonBacklightTypeClick();
//         Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
//        Установка фильтра "Тип подсветки экрана"
        televizoryPage.chbxBacklightTypeClick(backlightType.getBacklightType());
    }


}