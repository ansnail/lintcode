package top.androidman.lintcode;

import java.util.ArrayList;
import java.util.List;

public class LintCode_22 {

	public static void main(String[] args) {

	}
	
	List<Integer> results = new ArrayList<Integer>();
	
	/**
	 * 递归方法
	 * @param nestedList
	 * @return
	 */
	public List<Integer> flattenI(List<NestedInteger> nestedList) {
		// Write your code here
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				results.add(nestedInteger.getInteger());
			} else {
				flattenI(nestedInteger.getList());
			}
		}
		return results;
	}
	
	
	//暂时没想到非递归的方法，以后想到的话补上
	public List<Integer> flattenII(List<NestedInteger> nestedList) {
		
		
		
		return results;
	}
	

}

interface NestedInteger {

	// @return true if this NestedInteger holds a single integer,
	// rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds,
	// if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds,
	// if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
