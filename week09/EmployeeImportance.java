/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

/**
 * TC = O(N) ; Where N is the number of employees.
 * MC = O(N) ;
 * Problem link : https://leetcode.com/problems/employee-importance/description/
 */

class Solution {

    private Map<Integer, Employee> empMap;

    public int getImportance(List<Employee> employees, int id) {
        empMap = new HashMap<>();

        for (Employee emp : employees) {
            empMap.put(emp.id, emp);
        }

        return dfs(id);
    }

    private int dfs(int curr) {
        int totEmportance = empMap.get(curr).importance;

        for (int subOrd : empMap.get(curr).subordinates) {
            totEmportance += dfs(subOrd);
        }

        return totEmportance;
    }
}
