package no.finntech.example.model;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public final class RandomNumberView {

    private static final NumberFormat formatter = NumberFormat.getNumberInstance(Locale.ENGLISH);

    private final String number;
    private final boolean positive;

    public static List<RandomNumberView> of(List<Integer> numbers) {
        List<RandomNumberView> numberViews = new ArrayList<>(numbers.size());
        for (int number: numbers) {
            numberViews.add(new RandomNumberView(number));
        }
        return numberViews;
    }

    public RandomNumberView(int number) {
        this.number = formatNumber(number);
        this.positive = (number >= 0);
    }

    public String getNumber() {
        return number;
    }

    public boolean isPositive() {
        return positive;
    }

    private String formatNumber(int number) {
        return formatter.format(number);
    }
}
