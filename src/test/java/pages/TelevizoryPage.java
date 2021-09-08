package pages;

import elements.*;
import elements.Button;
import helpers.WaitFor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Страница "Телевизоры"
public class TelevizoryPage extends BasePage {
    //    Логгер
    private Logger logger = LogManager.getLogger(TelevizoryPage.class);

    //    Конструктор класса
    public TelevizoryPage(WebDriver driver) {
        // Вызов родительского конструктора
        super(driver);
    }

    // ***** Локаторы *****

    // - Фильтр "Производитель"
    String chbxCompanyXpath = "//span[contains(text(),'company')]";
    // - Фильтр "Диагональ экрана (дюйм)"
    String accordeonScreenDiagonalInchXpath = "//span[contains(text(),'Диагональ экрана (дюйм)')]";

    String inputMinValueScreenDiagonalXpath = "(//input[@type='number'])[position()='3']";
    String inputMaxValueScreenDiagonalXpath = "(//input[@type='number'])[position()='4']";
    //  фильтр Частота обновления экрана (Гц)	120 Гц
    String accordeonScreenRefreshXpath = "//span[contains(text(),'Частота обновления экрана (Гц)')]/..";
    String chbxScreenRefreshXpath = "//span[contains(text(),'refreshValue')]";
    //    фильтр Тип подсветки	Direct LED
    String accordeonBacklightTypeXpath = "(//span[contains(text(),'Тип подсветки экрана')])[position()='1']";
    String chbxBacklightTypeXpath = "//span[contains(text(),'backlightTypeValue')]";
    //    Кнопка "Применить"
    String btnApplyXpath = "//button[contains(text(),'Применить')]";
    // - Выпадашка "Сортировка"
    String accordeonSortXpath = "(//span[@class='top-filter__icon'])[position()='1']";
    // - Переключатель "Сначала дорогие"
    String rbtnExpensiveXpath = "//span[contains(text(),'Сначала дорогие')]";
    // Телевизоры
    // - Ссылка на первый продукт в списке
    String linkFirstProductXpath = "(//a[@class='catalog-product__name ui-link ui-link_black'])[position()='1']";
    //    шапка сайта
    String mainBlockXpath = "//nav[@id='header-search']";
    //    нижний контейнер сайта
    String mainСontainerBlockXpath = "(//div[@class='container'])[2]";

    // Нажатие на выпадашку "Сортировка"
    public void accordeonSortClick() {
        Accordeon accordeonSort = new Accordeon(driver, By.xpath(accordeonSortXpath));
        accordeonSort.show();
        logger.info("Нажата выпадашка \"Сортировка\"");
    }

    // Установка сортировки "Сначала дорогие"
    public void rbtnExpensiveClick() {
        RadioButton rbtnExpensive = new RadioButton(driver, By.xpath(rbtnExpensiveXpath));
        rbtnExpensive.setSelected(true);
        logger.info("Установлена сортировка - 'Сначала дорогие'");
    }

    // Установка фильтра "Производитель"
    public void chbxCompanyClick(String company) {
        chbxCompanyXpath = chbxCompanyXpath.replace("company", company);
        CheckBox chbxCompany = new CheckBox(driver, By.xpath(chbxCompanyXpath));
        chbxCompany.setChecked(true);
        logger.info("Установлен фильтр 'Производитель' -> " + company);
    }

    //Нажатие на выпадашку "Частота обновления экрана"
    public void accordeonScreenRefreshClick() {
        Accordeon accordeonScreenRefresh = new Accordeon(driver, By.xpath(accordeonScreenRefreshXpath));
        accordeonScreenRefresh.show();
        logger.info("Нажата выпадашка - 'Частота обновления экрана'");

    }

    // Установка фильтра "Частота обновления экрана - 120 Гц"
    public void chbxScreenRefreshClick(String refreshValue) {
        chbxScreenRefreshXpath = chbxScreenRefreshXpath.replace("refreshValue", refreshValue);
        CheckBox chbxScreenRefresh = new CheckBox(driver, By.xpath(chbxScreenRefreshXpath));
        chbxScreenRefresh.setChecked(true);
        logger.info("Установлен фильтр частоты обновления экрана ->" + refreshValue);
    }

    //    Нажать на выпадашку "тип подсветки экрана"
    public void accordeonBacklightTypeClick() {
        Accordeon accordeonBacklightType = new Accordeon(driver, By.xpath(accordeonBacklightTypeXpath));
        accordeonBacklightType.show();
        logger.info("Нажата выпадашка 'Тип подсветки экрана'");
    }

    // Установка фильтра 'Тип подсветки' - 'Direct LED'
    public void chbxBacklightTypeClick(String backlightTypeValue) {
        chbxBacklightTypeXpath = chbxBacklightTypeXpath.replace("backlightTypeValue", backlightTypeValue);
        CheckBox chbxBacklightType = new CheckBox(driver, By.xpath(chbxBacklightTypeXpath));
        chbxBacklightType.setChecked(true);
        logger.info("Установлен фильтр 'Тип подсветки' ->" + backlightTypeValue);
    }

    //    Нажать на выпадашку "Выбор диагонали экрана"
    public void accordeonValueScreenDiagonalClick() {
        Accordeon accordeonValueScreenDiagonal = new Accordeon(driver, By.xpath(accordeonScreenDiagonalInchXpath));
        accordeonValueScreenDiagonal.show();
        logger.info("Нажата выпадашка 'Выбор диагонали экрана'");
    }

    //  Выбор диагонали экрана - минимальная диагональ

    public void inputMinValueScreenDiagonal(String inputMinValueScreenDiagonal) {
        InputValue inputValueScreen = new InputValue(driver, By.xpath(inputMinValueScreenDiagonalXpath));
        inputValueScreen.inputValue(inputMinValueScreenDiagonal);
        logger.info("Выбрана диагональ экрана: от ->" + inputMinValueScreenDiagonal);
    }

    //   Выбор диагонали экрана - максимальная диагональ
    public void inputMaxValueScreenDiagonal(String inputMaxValueScreenDiagonal) {
        InputValue inputValueScreen1 = new InputValue(driver, By.xpath(inputMaxValueScreenDiagonalXpath));
        inputValueScreen1.inputValue(inputMaxValueScreenDiagonal);
        logger.info("Выбрана диагональ экрана: до ->" + inputMaxValueScreenDiagonal);
    }

    // Скрытие шапки
    public void mainBlockHide() {
        MainBlock mainBlock = new MainBlock(driver, By.xpath(mainBlockXpath));
        mainBlock.hide();
        logger.info("Скрыта шапка сайта");

    }

    // скрыть контейнер
    public void mainСontainerBlockHide() {
        MainBlock mainСontainerBlock = new MainBlock(driver, By.xpath(mainСontainerBlockXpath));
        mainСontainerBlock.hide();
        logger.info("Скрыт контейнер сайта");
    }
// Нажать кнопку "Применить"
    public void btnApplyClick() {
        Button btnApply = new Button(driver, By.xpath(btnApplyXpath));
        btnApply.click();
        logger.info("Применяем выбранные фильтры");
    }

    //    Выбор первого продукта
    public void linkFirstProductClick(String product) {
        WaitFor.firstProductMustBe(By.xpath(linkFirstProductXpath), product);
        Link linkProduct = new Link(driver, By.xpath(linkFirstProductXpath));
        linkProduct.openInNewWindow();
        logger.info("Нажата ссылка первого продукта в списке");
    }

}
