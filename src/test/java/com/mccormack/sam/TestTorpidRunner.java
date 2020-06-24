package com.mccormack.sam;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Torpid class main tests")
public class TestTorpidRunner {
    TorpidRunner torpidRunner = new TorpidRunner();

    @ParameterizedTest(name = "{index} => nCompetitors: {0}, courseLength: {1}, expected: {2}")
    @CsvSource({
            "3, 160, 0.4148148148f",
            "4, 400, 0.5107843137f"
    })
    public void testGetProbabilityOfEvenPermutationReturnsCorrectValueForParameterisedInput(int nCompetitors, int courseLength, float expected) {
        float actual = torpidRunner.getProbabilityOfEvenPermutation(nCompetitors, courseLength);
        assertEquals(expected, actual, "Probability did not match expected value for input parameters");
    }
}
