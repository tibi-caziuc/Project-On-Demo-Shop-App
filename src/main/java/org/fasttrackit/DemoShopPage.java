package org.fasttrackit;

public class DemoShopPage extends Page {
    private Header header;
    private Footer footer;

    public DemoShopPage() {
        this.header = new Header();
        this.footer = new Footer();
    }
    public Header getHeader() { return header;
    }

    public Footer getFooter() {
        return footer;
    }
}
