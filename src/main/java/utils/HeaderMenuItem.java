package utils;

public enum HeaderMenuItem {
    SEARCH("//a[@id ='0']"),
    LET_THE_CAR_WORK("//a[@id ='1']"),
    TERMS_OF_USE("//a[@id ='2']"),
    LOGOUT("//a[text() =' Logout ']"),
    DELLETE_ACCOUNT("//a[text() ='Delete account']");


    private final String locator;

    HeaderMenuItem(String locator) {
        this.locator = locator;
    }

    public String getLocator() {
        return locator;
    }
}
