题目：三数之和
难度：中等

心得：主要熟悉List的一系列操作，顺便实践一下git的版本回退。
eg: List<List<Integer>> ans = new ArrayList<List<Integer>>();新建一个List，元素依旧是List，数据类型为Integer；
    Arrays.sort(nums);将nums数组按从小到大重新排列；
	ans.add(Arrays.asList(***);重点：往ans队列中添加新元素，此处元素数据类型为List<Integer>，添加形式为Arrays.asList(***)，其中***例子：1,2,3，元素之间用逗号分隔；
	List元素调用:List.get(Index)，此处例子：ans.get(0).get(1)：ans的第0个List的第1个元素，此处应为一个整数。
此次为第二次commit，第二次push。