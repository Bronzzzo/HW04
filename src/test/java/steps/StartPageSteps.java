package steps;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import pages.StartPage;

public class StartPageSteps {
    // Логгер
    private static Logger logger = LogManager.getLogger(StartPageSteps.class);
    // Ссылка на объект класса StartPage
    private StartPage startPage;
//    Конструктор

    public StartPageSteps(StartPage startPage) {
//        Стартовая страница сайта
        this.startPage = startPage;
        logger.info("Открыта стартовая страница DNS");
    }

    //    Нажатие на ссылку Телевизоры
    public void clickLinkTV() {
//        Наведение курсора на "ТВ и мультимедиа"
        startPage.linkTvAndMultimediaMove();
//        Нажатие на ссылку "ТВ"
        startPage.linkTvClick();
    }
}
