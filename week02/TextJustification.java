class Solution {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> lines = new ArrayList<>();

        for (int l = 0; l < words.length; ) {
            int r = l, cntWordInLine = 0, totCharInLine = 0;

            while (r < words.length && totCharInLine + words[r].length() + cntWordInLine <= maxWidth) {
                totCharInLine += words[r].length();
                cntWordInLine ++;
                r++;
            }

            StringBuffer line = new StringBuffer();
            boolean isLastLine = (r == words.length);
            int totSpaceNeeded = maxWidth - totCharInLine;
            
            if (cntWordInLine == 1) {
                line.append(words[l]);
                addKSpace(line, totSpaceNeeded);
            } else if (isLastLine) {
                for (int i = 0; i < cntWordInLine; i++) {
                    if (i > 0) {
                        addKSpace(line, 1);
                    }
                    line.append(words[l+i]);
                }
                addKSpace(line, totSpaceNeeded - cntWordInLine + 1);
            } else {
                for (int i = 0; i < cntWordInLine; i++) {
                    if (i > 0) {
                        addKSpace(line, totSpaceNeeded / (cntWordInLine - 1));
                        if (i <= totSpaceNeeded % (cntWordInLine - 1)) {
                            addKSpace(line, 1);
                        }
                    }
                    line.append(words[l+i]);
                }
            }

            lines.add(new String(line));
            l = r;
        }

        return lines;
    }

    private void addKSpace(StringBuffer sb, int k) {
        while (k > 0) {
            sb.append(' ');
            k--;
        }
    }
}
