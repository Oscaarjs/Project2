package Proj2;

import java.util.*;

public class SimpleDataStructure {
	private String[] friends;
	private int counter;
	private int size = 5;

	public SimpleDataStructure() {
		friends = new String[size];
		counter = 0;
	}

	/*
	 * Appends the other friend name to the end of this list.
	 */
	public boolean add(String other) {
		friends[counter] = other;
		counter++;
		if (counter == friends.length) {
			String[] temp = new String[size];
			System.arraycopy(friends, 0, temp, 0, size);
			this.friends = new String[size * 2];
			System.arraycopy(temp, 0, friends, 0, size);
			this.size = size * 2;

		}

		return true;
	}

	/** returns the name at the specified index */
	public String get(int index) {
		try {
			return friends[index];
		} catch (Exception e) {
			System.out.println("IndexOutOfBounds");
		}
		return null;
	}

	/**
	 * removes the first occurrence of the specified element in this list if the
	 * list contains the name
	 */
	public boolean remove(String name) {

		for (int i = 0; i < counter; i++) {
			if (friends[i].equals(name)) {
				friends[i] = null;
				for (int j = i; j < friends.length - 1; j++) {
					friends[j] = friends[j + 1];

				}
				return true;
			}
		}
		return false;
	}

	/** prints all names in the array friends */
	public void printFriends() {
		for (int i = 0; i < friends.length; i++) {
			if (friends[i] != null) {
				System.out.print(friends[i] + " ");
			}
		}
		System.out.println();
	}

	public void addSort(String namn) {
		int index = friends.length-1;
		for (int i = 0; i < friends.length - 1; i++) {
			if (friends[i + 1] != null && friends[i] != null) {
				if (namn.compareTo(friends[i]) >= 0) {
					if (namn.compareTo(friends[i + 1]) <= 0) {
						index = i + 1;
					}

				}

			}
		}
		for (int i = friends.length - 1; i > index; i--) {
			friends[i] = friends[i - 1];
		}
		friends[index] = namn;
		counter++;

	}

	public static void main(String[] arg) {
		SimpleDataStructure myfriends = new SimpleDataStructure();
		String[] names = { "Kalle", "Oscar", "Janne", "Joel", "Lina", "Jan", "Douglas", "Axel", "Christopher", "Lovisa",
				"Patricia", "Petra" };
		Arrays.sort(names);
		for (int i = 0; i < names.length; i++) {
			myfriends.add(names[i]);
		}
		myfriends.remove("Douglas");
		myfriends.addSort("Lucas");
		myfriends.addSort("Zlbin");
		myfriends.addSort("Xlbin");
		
		myfriends.printFriends();
		System.out.println(myfriends.get(5));

	}
}