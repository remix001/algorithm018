# 常用操作
删除右边：fn+delete

移到行头/尾：command+left/right

以单词为单位移动； option+ left/right

删除以单词为单位的内容：option+delete

选中整行：shift+command+right

# 栈和队列笔记
用Ddequeue(用StackList) 代替Stack

Stack 原始是用vector(vector 和arrayList 类似，但vector是线程安全的，arrayList不是)

Dequeue是double-end queue

# 用 add first 或 add last 这套新的 API 改写 Deque 的代码

## Deque:
https://github.com/chenghanpeng/jdk10u/blob/4112b540a64794c52b6b223b5ce461246ce5f806/src/java.base/share/classes/java/util/Deque.java

Dequeue的方法具体实施可在LinkedList找到。（据Oracle文件： https://docs.oracle.com/javase/10/docs/api/java/util/Deque.html 可以得知Implementing Classes有哪些，不止linkedList）
## LinkedList
https://github.com/chenghanpeng/jdk10u/blob/4112b540a64794c52b6b223b5ce461246ce5f806/src/java.base/share/classes/java/util/LinkedList.java

【代码】：https://github.com/remix001/algorithm018/blob/master/week01/DequeueTest.java

# 分析 Queue 和 Priority Queue 的源码

## Queue：
 https://github.com/chenghanpeng/jdk10u/blob/4112b540a64794c52b6b223b5ce461246ce5f806/src/java.base/share/classes/java/util/Queue.java

Extends Collection


## PriorityQueue: 
https://github.com/chenghanpeng/jdk10u/blob/4112b540a64794c52b6b223b5ce461246ce5f806/src/java.base/share/classes/java/util/PriorityQueue.java

Extends AbstractQueue
- 不是 synchronized. 
    - Multiple threads should not access a PriorityQueue instance concurrently if any of the threads modifies the queue. 
    - 碰到以上情况推荐thread-safe PriorityBlockingQueue class.
    - 
- **transient** : 将不需要序列化的属性前添加关键字transient，序列化对象的时候，这个属性就不会被序列化[https://baijiahao.baidu.com/s?id=1636557218432721275&wfr=spider&for=pc]
  
- **transient** int modCount：The number of times this priority queue has been structurally modified.
  - The modCount value that the iterator believes that the backing Queue should have. “concurrent modifaction” 通过核对 "expectedModCount=ModCount" 是识别到
  
- 使用的是 balanced binary heap
  - the two children of queue[n] are queue[2*n+1] and queue[2*(n+1)].
  - 用的queue是：**transient** Object[] queue

- Queue的操作，Priority Queue都可以用
- 用的时候，要加“comparator”
- 初始容量11个单位

# 作业
## 简单：
删除排序数组中的重复项（Facebook、字节跳动、微软在半年内面试中考过）https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/

### NOTE:
  - Time: O(n)
  - Space: O(1)
  - 双指针，有快慢两个指针，快指针负责遍历，慢指针负责找到被换位后不重复的位置
  - method：将重复和不重复的对调位置
  
  https://github.com/remix001/algorithm018/blob/master/week01/Q26.java
  
  -----------------------

旋转数组（微软、亚马逊、PayPal 在半年内面试中考过）

合并两个有序链表（亚马逊、字节跳动在半年内面试常考）

合并两个有序数组（Facebook 在半年内面试常考）

两数之和（亚马逊、字节跳动、谷歌、Facebook、苹果、微软在半年内面试中高频常考）

移动零（Facebook、亚马逊、苹果在半年内面试中考过）https://leetcode-cn.com/problems/move-zeroes/
### NOTE:
  - Time: O(n)
  - Space: O(1)
  - 双指针
  - method：将不为零的往前挪
  
  https://github.com/remix001/algorithm018/blob/master/week01/Q283.java
  
  -----------------------
加一（谷歌、字节跳动、Facebook 在半年内面试中考过）

## 中等：

设计循环双端队列（Facebook 在 1 年内面试中考过）

## 困难：

接雨水（亚马逊、字节跳动、高盛集团、Facebook 在半年内面试常考）
