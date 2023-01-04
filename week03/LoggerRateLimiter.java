// TC = O(1) for each call made for shouldPrintMessage()
// MC = O(N); Where N is total number of calls will be made for shouldPrintMessage()
// Problem link : https://leetcode.com/problems/logger-rate-limiter/description/

class Logger {

    Map<String, Integer> cache;

    public Logger() {
        cache = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (cache.getOrDefault(message, 0) <= timestamp) {
            cache.put(message, timestamp + 10);
            return true;
        } else {
            return false;
        }
    }
}

