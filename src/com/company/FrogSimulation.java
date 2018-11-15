package com.company;

//The method hopDistance() is implemented for you and the main in right in the class to make it simpler.
public class FrogSimulation {
    /**
     * Distance, in inches, from the starting position to the goal.
     */

    /**
     * Maximum number of hops allowed to reach the goal.
     */

    /**
     * Constructs a FrogSimulation where dist is the distance, in inches, from the starting
     * position to the goal, and numHops is the maximum number of hops allowed to reach the goal.
     * Precondition: dist > 0; numHops > 0
     */

    public int[] testHops;
    public int nextHopIndex;
    private int goalDistance;
    private int maxHops;


    public FrogSimulation(int dist, int numHops) {
        goalDistance = dist;
        maxHops = numHops;
    }

    /**
     * Returns an integer representing the distance, in inches, to be moved when the frog hops.
     */
    private int hopDistance() {
        int hop = testHops[nextHopIndex];
        nextHopIndex++;
        if (nextHopIndex >= testHops.length)
            nextHopIndex = 0;

        return hop;
    }

/********************** Part (a) *************************/

    /**
     * Simulates a frog attempting to reach the goal as described in part (a).
     * Returns true if the frog successfully reached or passed the goal during the simulation;
     * false otherwise.
     */
    public boolean simulate() {
        int currentDist = 0;
        int currentHop = 0;
        while (currentHop < maxHops) {
            currentDist += hopDistance();
            if (currentDist < 0) {
                return false;
            }
            if (currentDist >= goalDistance) {
                return true;
            }
            currentHop++;
            nextHopIndex++;
        }
        if (currentDist >= goalDistance)
            return true;
        else
            return false;
    }

/********************** Part (b) *************************/

    /**
     * Runs num simulations and returns the proportion of simulations in which the frog
     * successfully reached or passed the goal.
     * Precondition: num > 0
     */
    public double runSimulations(int num) {
        int simulateN = 0;
        double SSN = 0.0;
        while (simulateN < num) {
            if (simulate()) {
                SSN++;
            }
            simulateN++;
            this.nextHopIndex = 0;
        }
        return SSN / num;
    }
}
