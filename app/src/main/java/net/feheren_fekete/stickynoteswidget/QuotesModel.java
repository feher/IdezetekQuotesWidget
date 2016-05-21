package net.feheren_fekete.stickynoteswidget;

import java.util.ArrayList;
import java.util.List;

public class QuotesModel {

    public QuotesModel() {
    }

    public List<Quote> loadAllQuotes() {
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote(1, "Blah blah 1"));
        quotes.add(new Quote(2, "Blah blah 2"));
        quotes.add(new Quote(3, "Blah blah 3"));
        quotes.add(new Quote(4, "Blah blah 4"));
        quotes.add(new Quote(5, "Blah blah 5"));
        quotes.add(new Quote(6, "Blah blah 6"));
        quotes.add(new Quote(7, "Blah blah 7"));
        quotes.add(new Quote(8, "Blah blah 8"));
        quotes.add(new Quote(9, "Blah blah 9"));
        quotes.add(new Quote(10, "Blah blah 10"));
        return quotes;
    }

}
