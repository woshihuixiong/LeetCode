题目：全排列
难度：中等

心得：一道非常简单的回溯法，解空间树非常直观，虽然我自己回溯法都快忘了，还好很快想起来了。
学会了两个新操作，一个是调用函数（方法）中的参数可以直接当场new，比如这道题：backtrack(ans, nums, new ArrayList<Integer>(), visited);
第二是将一个ArrayList加到一个ArrayList的List中去：ans.add(new ArrayList<>(tmp));其中ans是List<List<Integer>>，tmp是一个现成的ArrayList<Integer>。
反正感觉这个ArrayList的操作我不熟练（毕竟刚刚从C++转到Java），还有很多东西要学，但是这个回溯法我自我感觉掌握的不错，比广度优先算法反正简单多了，多加练习就行了。