/**
 * TC :
        For ls(path) method : O(|s| + L + n log n) ; where |s| is length of path, L is level of last directories 
	and n is the number of item the path contained.

        For mkdir(path), addContent(path), readContent(path) method : O(|s| + L);

 * MC : O(M) ; where M is total characters in all inputs to call mkdir() and addContents()

 * Problem link : https://leetcode.com/problems/design-in-memory-file-system/description/
 */

class FileSystem {

    TrieNode root;

    class TrieNode {

        Map<String, String> files;
        Map<String, TrieNode> directories;

        TrieNode() {
            files = new HashMap<>();
            directories = new HashMap<>();
        }
    }

    public FileSystem() {
        root = new TrieNode();
    }
    
    public List<String> ls(String path) {
        String[] s = path.split("/", 0);
        int len = s.length;
        TrieNode curr = root;
        List<String> items = new ArrayList<>();
        
        if (len > 0) {
            for (int i = 1; i < len - 1; i++) {
                curr = curr.directories.get(s[i]);
            }

            if (curr.files.containsKey(s[len-1])) {
                items.add(s[len-1]);
                return items;
            }

            curr = curr.directories.get(s[len-1]);
        }

        items.addAll(new ArrayList<>(curr.directories.keySet()));
        items.addAll(new ArrayList<>(curr.files.keySet()));
        Collections.sort(items);

        return items;
    }
    
    public void mkdir(String path) {
        TrieNode curr = root;
        String[] strs = path.split("/");
        int len = strs.length;

        for (int i = 1; i < len; i++) {
            String str = strs[i];

            if (!curr.directories.containsKey(str)) {
                curr.directories.put(str, new TrieNode());
            }

            curr = curr.directories.get(str);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] strs = filePath.split("/");
        int len = strs.length;
        TrieNode curr = root;

        for (int i = 1; i < len - 1; i++) {
            curr = curr.directories.get(strs[i]);
        }

        String originalContent = curr.files.getOrDefault(strs[len-1], "");
        curr.files.put(strs[len-1], originalContent + content);
    }
    
    public String readContentFromFile(String filePath) {
        String[] strs = filePath.split("/");
        int len = strs.length;
        TrieNode curr = root;

        for (int i = 1; i < len - 1; i++) {
            curr = curr.directories.get(strs[i]);
        }

        return curr.files.get(strs[len-1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */