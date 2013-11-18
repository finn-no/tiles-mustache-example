package no.finntech.example.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomServiceTest {

    private RandomService service;

    @Before
    public void setUp() throws Exception {
        service = new RandomService();
    }

    @Test
    public void should_return_a_list_of_then_numbers() throws Exception {
        assertEquals(10, service.createListOfRandoms().size());
    }
}
