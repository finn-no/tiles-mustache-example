package no.finntech.example.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public final class RandomService {

    public List<Integer> createListOfRandoms() {
        final List<Integer> listOfRandoms = new ArrayList<>();
        final Random generator = new Random();
        for (int i = 1; i <= 10; i++) {
            listOfRandoms.add(generator.nextInt());
        }

        return listOfRandoms;
    }
}
