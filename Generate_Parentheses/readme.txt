题目：括号生成
难度：中等

心得：一开始想到了回溯法和动态规划，图方便嘛，直接回溯法。
运行时间有点长，看了答案，我还用了栈。。写的时候就感觉有点多此一举，果然回溯法的写法可以很简单，唉，还是要多练。
也看了下动规的方法，算了，因为懒，不看了。

官方回溯法代码，甚至不需要手动归位。。一定要多学习：

class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max);
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max);
    }
}

你看看这代码，多么的beautiful。再看看我的，就是一坨屎。