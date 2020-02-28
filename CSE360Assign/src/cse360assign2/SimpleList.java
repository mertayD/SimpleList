package cse360assign2;

/* @Author Mertay Dayanc
* Class ID: 198
* Assignment 2
* Version: 2
* This file contains the implementation of the class SimpleList.
* SimpleList class, is a class that has basic properties such as adding elements to the first index and shift rest by 1.
* It acts pretty much like stack, Last In First Out (LIFO) but SimpleList has capability to increase it's size by 50% if needed
* and also if 25% of the array is empty it decreases it's size 25% ensuring.
* User can get the actual number of elements and also display the SimpleList in string as well as getting last element, first element and
* learning size of the list and appending an element to the end.
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
	 * if any overflow it increases the size of the array by 50% so there is always room
	 * @param int item to be inserted
	 * @return void
	 */
	void add (int item)
	{
		if(count != list.length)
		{
			count++;
		}
		else {
			int new_size = (int)(count + Math.floor(count/2));
			int[] temp = new int[new_size];
			for(int i = 0; i < count; i++)
			{
				temp[i] = list[i];
			}
			list = temp;
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
		if(list.length != 1)
		{
			double percent = count/list.length;
			if(percent < 0.75)
			{
				int new_size = (int)(list.length - Math.floor(list.length/4));
				int[] temp = new int[new_size];
				for(int i = 0; i < count; i++)
				{
					temp[i] = list[i];
				}
				list = temp;
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
	 * Returns the index of the given item, if not found returns -1 denoting not found
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
	/*
	 * Adds the int item at the end of the list
	 * @param int item to be added
	 * @return void
	 */
	void append(int item)
	{
		if(count == list.length)
		{
			int new_size = (int)(count + Math.floor(count/2));
			int[] temp = new int[new_size];
			for(int i = 0; i < count; i++)
			{
				temp[i] = list[i];
			}
			list = temp;
		}
		list[count] = item;
		count++;
	}
	/*
	 * Returns the value of the first item, if not found returns -1 denoting not found
	 * @return int item value at 0th index in SimpleList
	 */
	int first()
	{
		if(count == 0)
		{
			return -1;
		}
		return list[0];
	}
	
	/*
	 * Returns the value of the last index, if not found returns -1 denoting not found
	 * @return int last item value in SimpleList
	 */
	int last() {
		if(count == 0)
		{
			return -1;
		}
		return list[count-1];
	}
	
	/*
	 * Returns the size of the list
	 * @return int size of SimpleList
	 */
	int size() {
		return list.length;
	}
	
}
