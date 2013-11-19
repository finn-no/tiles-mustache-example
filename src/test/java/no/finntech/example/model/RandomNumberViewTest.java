package no.finntech.example.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RandomNumberViewTest {

    private RandomNumberView view;

    @Test
    public void should_format_the_numbers_given_when_creating_the_view() throws Exception {
        whenCreatingViewOf(1000);
        assertEquals("1,000", view.getNumber());
    }

    @Test
    public void number_should_be_positive_when_number_is_greater_than_zero() throws Exception {
        whenCreatingViewOf(1000);
        assertTrue(view.isPositive());
    }

    @Test
    public void number_should_not_be_positive_when_number_is_lower_than_zero() throws Exception {
        whenCreatingViewOf(-1000);
        assertFalse(view.isPositive());
    }

    private void whenCreatingViewOf(int number) {
        view = new RandomNumberView(number);
    }
}