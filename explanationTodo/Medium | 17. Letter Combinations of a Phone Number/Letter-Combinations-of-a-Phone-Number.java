1class Solution {
2    public void recursiveCombinations(String digits, int index, StringBuilder current, List<String> result, HashMap<Character, String> digitMap) {
3        if (index == digits.length()) {
4            result.add(current.toString());
5            return;
6        }
7
8        String letters = digitMap.get(digits.charAt(index));
9        for (char letter : letters.toCharArray()) {
10            current.append(letter);
11            recursiveCombinations(digits, index + 1, current, result, digitMap);;
12            current.deleteCharAt(current.length() - 1);
13        }
14    }
15
16    public List<String> letterCombinations(String digits) {
17        List<String> result = new ArrayList<>();
18        if (digits == null || digits.length() == 0) {
19            return result;
20        }
21
22        // brute force method
23        HashMap<Character, String> digitMap = new HashMap<>();
24        digitMap.put('2', "abc");
25        digitMap.put('3', "def");
26        digitMap.put('4', "ghi");
27        digitMap.put('5', "jkl");
28        digitMap.put('6', "mno");
29        digitMap.put('7', "pqrs");
30        digitMap.put('8', "tuv");
31        digitMap.put('9', "wxyz");
32
33        recursiveCombinations(digits, 0, new StringBuilder(), result, digitMap);
34
35       return result;
36    }
37}