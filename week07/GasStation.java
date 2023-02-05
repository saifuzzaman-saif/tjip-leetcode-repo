/**
 * TC = O(n); where n is the length of gas array.
 * MC = O(1);
 * Problem Link : https://leetcode.com/problems/gas-station/
 */

class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total_tank = 0, curr_tank = 0, starting_station = 0;

        for (int i = 0; i < gas.length; i++) {
            total_tank += gas[i] - cost[i];
            curr_tank += gas[i] - cost[i];

            if (curr_tank < 0) {
                curr_tank = 0;
                starting_station = i  + 1;
            }
       }

       return (total_tank >= 0) ? starting_station : -1;
    }
}
