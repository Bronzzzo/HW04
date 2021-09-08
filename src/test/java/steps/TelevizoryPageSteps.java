package steps;

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

}
