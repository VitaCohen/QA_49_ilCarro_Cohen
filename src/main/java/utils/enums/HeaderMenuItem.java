package utils.enums;

public enum HeaderMenuItem {
    SEARCH("//a[@id ='0']"),
    LET_THE_CAR_WORK("//a[@id ='1']"),
    TERMS_OF_USE("//a[@id ='2']"),
    SIGNUP(" //a[text() = ' Sign up ']"),
    LOGIN(" //a[text() = ' Log in ']"),
    LOGOUT("//a[text() =' Logout ']"),
    DELETE_ACCOUNT("//a[text() ='Delete account']");


    private final String locator;

    HeaderMenuItem(String locator) {

        this.locator = locator;
    }

    public String getLocator() {

        return locator;
    }
}
