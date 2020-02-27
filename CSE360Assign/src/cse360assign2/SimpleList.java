package cse360assign2;
/* @Author Mertay Dayanc
* Class ID: 198
* Assignment 2
* Version: 2
* This file contains the implementation of the class SimpleList.
* SimpleList class, is a class that has basic properties such as adding elements to the first index and shift rest by 1.
* It acts pretty much like stack, Last In First Out (LIFO) but SimpleList only has capability of holding maximum 10 
* elements. User can get the actual number of elements and also display the SimpleList in string.
*/


public class SimpleList {
	
	int[] list;
	int count;
	/*
	 * Constructor for SimpleList, default size is 10, and initial count is 0 because SimpleList is empty.
	 */
	SimpleList()
	{
		list = new int[10];
		count =0;
	}
	
	/*
	 * This function adds one element to the SimpleList at 1st position and shifts other elements to right,
	 * if any overflow it just drops it
	 * @param int item to be inserted
	 * @return void
	 */
	void add (int item)
	{
		if(count != 10)
		{
			count++;
		}
		
		for(int iterator = count-1; iterator > 0; iterator--)
		{
			if(iterator != 0)
			{
				list[iterator] = list[iterator-1];
			}
		}
		list[0] = item;			
	}
	 
	//The other values in the list may need to be moved down.  Adjust the count as needed.
	/*
	 * This function removes one element to the SimpleList if it exists otherwise doesn't do anything.
	 * if match with the item is successful then removes it from the SimpleList and moves down others. 
	 * @param int item to be removed
	 * @return void
	 */
	void remove(int item)
	{
		
		int index = search(item);
		if(index != -1) {
			
			count--;
		
			for(int iterator = index; (iterator > -1 && iterator < count); iterator ++)
			{
				list[iterator] = list[iterator+1];
			}
		}
		
	}
	
	/*
	 * Returns the number of elements in the SimpleArray
	 * @return int count
	 */
	int count() {
		return count;
	}
	
	/*
	 * Returns the string representation of the SimpleList, space separated.
	 * @return string representation of the SimpleList
	 */
	String to_string()
	{
		String str = "";
		for(int iterator = 0; iterator < count; iterator++)
		{
			str += list[iterator];
			if(iterator != count - 1)
			{
				str += " ";
			}
		}
		return str;
	}
	
	/*
	 * Returns the index of the given item, if not found returns -1 denotung not found
	 * @param int item to be found
	 * @return int item index in SimpleList
	 */
	int search(int item)
	{
		int index = -1;
		for(int iterator = 0; iterator< count; iterator++)
		{
			if(list[iterator] == item)
			{
				index = iterator;
				iterator = count;
			}
		}
		return index;
	}
}