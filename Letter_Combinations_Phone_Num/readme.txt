题目：电话号码的字母组合
难度：中等

心得：回溯法，自己写的，还算顺利，就是特么输入为空的时候返回值搞了半天，我也是醉（应该用digits.equals("")，而不是digits==null）
时间复杂度肯定不会变，但是我运行速度真的慢，应该是组装子字符串str的方法太蠢，加一个字母还行，减一个字母够呛，看了答案用StringBulider比较好。
某个答案的代码：

public class Solution17_1 {

    private String letterMap[] = {        //应该要学会用map，别老是天天用数组
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    private ArrayList<String> res;

    public List<String> letterCombinations(String digits) {

        res = new ArrayList<String>();
        if(digits.equals(""))
            return res;

        findCombination(digits, 0, "");
        return res;
    }
	
	private void findCombination(String digits, int index, StringBuilder sb) {

        if (index == digits.length()) {
            res.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);
        String letters = letterMap[c - '0'];
        for (int i = 0; i < letters.length(); i++) {
            findCombination(digits, index + 1, sb.append(letters.charAt(i)));
            sb.deleteCharAt(sb.length()-1);
        }

    }
}

其实思路和我一模一样，只不过用了map和StringBuilder，不但写起来方便，运行时间也会缩短，说到底，还是对java掌握不够熟练。