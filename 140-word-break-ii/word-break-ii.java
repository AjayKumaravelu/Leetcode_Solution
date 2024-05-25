class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<>(wordDict);
        return wordBreakHelper(s, wordSet, new HashMap<>());
    }

    private List<String> wordBreakHelper(String s, Set<String> wordSet, Map<String, List<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }

        List<String> result = new ArrayList<>();
        
        if (s.isEmpty()) {
            result.add("");
            return result;
        }

        for (int end = 1; end <= s.length(); end++) {
            String prefix = s.substring(0, end);
            if (wordSet.contains(prefix)) {
                List<String> subList = wordBreakHelper(s.substring(end), wordSet, memo);
                for (String sub : subList) {
                    result.add(prefix + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }

        memo.put(s, result);
        return result;
    }
}