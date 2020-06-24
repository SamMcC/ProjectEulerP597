package com.mccormack.sam;

import com.mccormack.sam.boats.Boat;
import com.mccormack.sam.boats.BoatFactory;
import com.mccormack.sam.conditions.Permutation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.lang.Float.NaN;

public class TorpidRunner {
    public float getProbabilityOfEvenPermutation(int numberOfCompetitors, int lengthOfCourse) {
        Map<Permutation, Float> permutations = getProbabilityOfAllPermutations(numberOfCompetitors, lengthOfCourse);
        List<Float> evenPermutations = new ArrayList<>();
        float sumOfEvenProbabilities = 0;

        for (Permutation permutation : permutations.keySet()) {
            if (permutation.isEvenPermutation()) {
                evenPermutations.add(permutations.get(permutation));
            }
        }

        for (float probability: evenPermutations) {
            sumOfEvenProbabilities += probability;
        }

        return sumOfEvenProbabilities;
    }

    private Map<Permutation, Float> getProbabilityOfAllPermutations(int numberOfCompetitors, int lengthOfCourse) {
        Map<Permutation, Float> permutationProbabilities = new HashMap<>();
        List<Permutation> permutations = generatePermutations(numberOfCompetitors);

        for (Permutation permutation : permutations) {
            float probability = getProbabilityOfPermutation(permutation, lengthOfCourse);
            permutationProbabilities.put(permutation, probability);
        }
        return permutationProbabilities;
    }

    private List<Permutation> generatePermutations(int numberOfCompetitors) {
        List<Boat> competitors = new ArrayList<>();
        List<Permutation> permutations;
        BoatFactory boatFactory = new BoatFactory();
        for (int i = 0; i < numberOfCompetitors; i++) {
            competitors.add(boatFactory.getBoat(i));
        }
        permutations = heapPermutationRecursive(competitors.size() + 1, competitors, competitors);
        return permutations;
    }

    private float getProbabilityOfPermutation(Permutation permutation, int lengthOfCourse) {
        List<Boat> startingPosition = permutation.getStartingOrder();
        List<Boat> finishingPosition = permutation.getFinishingOrder();
        // calculate cumulative probability of each boat beating each other boat
        // this is a function of the probability of a boat going at a high enough speed to cover the 40m gap before
        // their speed would make them complete the course.
        return NaN;
    }

    private static List<Permutation> heapPermutationRecursive(int n, List<Boat> elements, List<Boat> startingPosition) {
        List<Permutation> permutations = new ArrayList<>();
        if(n == 1) {
            permutations.add(new Permutation(startingPosition, elements));
        } else {
            for(int i = 0; i < n-1; i++) {
                permutations.addAll(heapPermutationRecursive(n - 1, elements, startingPosition));
                if(n % 2 == 0) {
                    swap(elements, i, n-1);
                } else {
                    swap(elements, 0, n-1);
                }
            }
            permutations.addAll(heapPermutationRecursive(n - 1, elements, startingPosition));
        }
        return permutations;
    }

    private static <T> void swap(List<T> input, int a, int b) {
        T tmp = input.get(a);
        input.set(a, input.get(b));
        input.set(b, tmp);
    }
}
