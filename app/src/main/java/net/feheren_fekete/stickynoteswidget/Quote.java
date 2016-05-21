package net.feheren_fekete.stickynoteswidget;

public class Quote {

    private final long mId;
    private final String mText;

    public Quote(long id, String text) {
        mId = id;
        mText = text;
    }

    public long getId() {
        return mId;
    }

    public String getText() {
        return mText;
    }

}
