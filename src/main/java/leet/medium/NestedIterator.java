package leet.medium;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class NestedIterator implements Iterator<Integer> {
    private List<Integer> integers;
    private int position;

    public NestedIterator(List<NestedInteger> nestedList) {
        integers = new ArrayList<>();
        position = 0;
        flattenList(nestedList) ;
    }
    public void flattenList(List<NestedInteger> nestedList) {
        for(NestedInteger element : nestedList) {
            if(element.isInteger()) {
                integers.add(element.getInteger());
            }
            else {
                flattenList(element.getList());
            }
        }
    }

    @Override
    public Integer next() {
        if(!hasNext()) throw new NoSuchElementException();
        return integers.get(position++);
    }

    @Override
    public boolean hasNext() {
        return position < integers.size();
    }

}

/*
You are given a nested list of integers nestedList. Each element is either an integer or a list whose elements may also be integers or other lists. Implement an iterator to flatten it.

Implement the NestedIterator class:

NestedIterator(List<NestedInteger> nestedList) Initializes the iterator with the nested list nestedList.
int next() Returns the next integer in the nested list.
boolean hasNext() Returns true if there are still some integers in the nested list and false otherwise.
Your code will be tested with the following pseudocode:

initialize iterator with nestedList
res = []
while iterator.hasNext()
    append iterator.next() to the end of res
return res
If res matches the expected flattened list, then your code will be judged as correct.
Example 1:

Input: nestedList = [[1,1],2,[1,1]]
Output: [1,1,2,1,1]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,1,2,1,1].
Example 2:

Input: nestedList = [1,[4,[6]]]
Output: [1,4,6]
Explanation: By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,4,6].


Constraints:

1 <= nestedList.length <= 500
The values of the integers in the nested list is in the range [-10^6, 10^6].

======

Complexity Analysis

Let N be the total number of integers within the nested list, L be the total number of lists within the nested list, and D be the maximum nesting depth (maximum number of lists inside each other).

Time complexity:

We'll analyze each of the methods separately.

Constructor: O(N+L)

The constructor is where all the time-consuming work is done.

For each list within the nested list, there will be one call to flattenList(...). The loop within flattenList(...) will then iterate nnn times, where nnn is the number of integers within that list. Across all calls to flattenList(...), there will be a total of NNN loop iterations. Therefore, the time complexity is the number of lists plus the number of integers, giving us O(N+L)

Notice that the maximum depth of the nesting does not impact the time complexity.

next(): O(1)

Getting the next element requires incrementing position by 1 and accessing an element at a particular index of the integers list. Both of these are O(1) operations.

hasNext(): O(1)

Checking whether or not there is a next element requires comparing the length of the integers list to the position variable. This is an O(1) operation.

Space complexity : O(N+D)

The most obvious auxiliary space is the integers list. The length of this is O(N)

The less obvious auxiliary space is the space used by the flattenList(...) function. Recall that recursive functions need to keep track of where they're up to by putting stack frames on the runtime stack. Therefore, we need to determine what the maximum number of stack frames there could be at a time is. Each time we encounter a nested list, we call flattenList(...) and a stack frame is added. Each time we finish processing a nested list, flattenList(...) returns and a stack frame is removed. Therefore, the maximum number of stack frames on the runtime stack is the maximum nesting depth, D

Because these two operations happen one-after-the-other, and either could be the largest, we add their time complexities together giving a final result of O(N+D)


 */