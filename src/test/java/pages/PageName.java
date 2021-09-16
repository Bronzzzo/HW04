package pages;

import webdriverfactory.BrowserName;

public enum PageName {
    START_PAGE("Стартовая страница"),
    TELEVIZORY_PAGE("Страница 'Телевизоры'"),
    TELEVIZORY_PRODUCT_PAGE("Страница 'Продукт. Телевизор'");

    private String pageName;
//приватный конструктор
   private PageName(String pageName) {
        this.pageName = pageName;
    }
    //     переопределенный метод toString()
    @Override
    public String toString() {
        return String.valueOf(this.pageName);
    }
    // Возврат константы по строковому значению константы
    public static PageName fromString(String pageName) {
        if (pageName != null) {
            for(PageName p : PageName.values()) {
                if (pageName.equalsIgnoreCase(p.pageName)) {
                    return p;
                }
            }
        }
        return null;
    }

    // Получение имени страницы (пейдж обджекта)
    public String getPageName() {
        return this.pageName;
    }




}
