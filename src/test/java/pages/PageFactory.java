package pages;

import models.valueobjects.Company;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import steps.StartPageSteps;
import steps.TelevizoryPageSteps;
import steps.TelevizoryProductPageSteps;
import models.TelevizoryVO;

import static helpers.ScreenShot.captureScreen;

public class PageFactory extends BasePage{
    // Логгер
    private static Logger logger = LogManager.getLogger(PageFactory.class);
    private static TelevizoryVO televizoryVO;


    public PageFactory(WebDriver driver) {
        super(driver);
    }


    // Получение экземпляра страницы (пейдж обджекта)
    public static BasePage getPage(WebDriver driver, PageName name) {
        switch (name) {
//Стартовая страница
            case START_PAGE:
                logger.info("Стартовая страница");
                StartPage startPage = new StartPage(driver);
                // ***** Стартовая страница сайта DNS *****
                StartPageSteps startPageSteps = new StartPageSteps(new StartPage(driver));
                // Наведение курсора мыши на ссылку "Телевизоры и медиа"
                // Нажатие на ссылку "Телевизоры"
                startPageSteps.clickLinkTV();
//        скрин экрана
                captureScreen(driver, "temp\\1.png");
                return startPage;
//Страница 'Телевизоры'
            case TELEVIZORY_PAGE:
                logger.info("Страница 'Телевизоры'");
                TelevizoryPage televizoryPage = new TelevizoryPage(driver);
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
                return televizoryPage;

//            Страница 'Продукт. Телевизор'
            case TELEVIZORY_PRODUCT_PAGE:
                logger.info("Страница 'Продукт. Телевизор'");
                TelevizoryProductPage televizoryProductPage = new TelevizoryProductPage(driver);
                // ***** Страница "Продукт.Телевизор" *****
                TelevizoryProductPageSteps televizoryProductPageSteps = new TelevizoryProductPageSteps(new TelevizoryProductPage(driver));
                // Получить заголовок страницы
                televizoryProductPageSteps.pageTitle();
                // нажатие ссылки 'Характеристика продукта'
                televizoryProductPageSteps.characteristicsClick();
                // сделать скрин
                captureScreen(driver, "temp\\5.png");
                return televizoryProductPage;
// по умолчанию
            default:
                throw new RuntimeException("Некорректное название страницы");
        }


    }
}
