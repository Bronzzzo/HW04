package tests;

import helpers.JSExec;
import org.junit.jupiter.api.Test;
import pages.StartPage;
import pages.TelevizoryPage;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

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
        // ***** Страница "Телевизоры" *****
        TelevizoryPage televizoryPage = new TelevizoryPage(driver);
        televizoryPage.mainBlockHide();
        // Нажатие на выпадашку "Сортировка"
        televizoryPage.accordeonSortClick();
        // Установка сортировки "Сначала дорогие"
        televizoryPage.rbtnExpensiveClick();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1000);
        // Установка фильтра "Производитель"
        televizoryPage.chbxCompanyClick(company);

        //    Нажать на выпадашку "Выбор диагонали экрана"
        televizoryPage.accordeonValueScreenDiagonalClick();
        // Сделать скриншот всей веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASFullPage.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        televizoryPage.containerBlockHide();
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        //    Выбор диагонали экрана
        televizoryPage.setMinValueScreenDiagonal(minValueScreenDiagonal);
        // Прокрутка страницы вниз
        JSExec.scrollBy(0, 1200);
        televizoryPage.setMaxValueScreenDiagonal(maxValueScreenDiagonal);


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
        televizoryPage.btnApplyClick();
        // Сделать скриншот всей веб страницы
        try {
            Screenshot screenshot = new AShot()
                    .shootingStrategy(ShootingStrategies.viewportPasting(100))
                    .takeScreenshot(driver);
            ImageIO.write(screenshot.getImage(), "png", new File("temp\\ASFullPage.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return new TelevizoryPage(driver);
    }

}
