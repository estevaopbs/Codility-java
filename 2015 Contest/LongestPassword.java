class Solution {
    public int solution(String S) {
        int maxLen = -1;
        for (String candidate : S.split(" ")) {
            int len = 0;
            boolean evenLetters = true;
            boolean oddNumbers = false;
            for (int _char : candidate.chars().toArray()) {
                if ((65 <= _char && _char <= 90) || (97 <= _char && _char <= 122)) {
                    evenLetters = !(evenLetters);
                } else if (48 <= _char && _char <= 57) {
                    oddNumbers = !(oddNumbers);
                } else {
                    len = -1;
                    break;
                }
                len += 1;
            }
            if (evenLetters && oddNumbers) {
                maxLen = Math.max(len, maxLen);
            }
        }
        return maxLen;
    }
}