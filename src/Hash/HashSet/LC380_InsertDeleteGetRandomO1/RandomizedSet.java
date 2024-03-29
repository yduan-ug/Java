package Hash.HashSet.LC380_InsertDeleteGetRandomO1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
/**
 * Implement the RandomizedSet class:
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false
 * otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false
 * otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element
 * exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 * Example 1:
 * Input
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]
 * [[], [1], [2], [2], [], [1], [2], []]
 * Output
 * [null, true, false, true, 2, true, false, 2]
 * Explanation
 * RandomizedSet randomizedSet = new RandomizedSet();
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].
 * randomizedSet.insert(2); // 2 was already in the set, so return false.
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.
 *
 * Constraints:
 * -231 <= val <= 231 - 1
 * At most 2 * 105 calls will be made to insert, remove, and getRandom.
 * There will be at least one element in the data structure when getRandom is called.
 **/

// Time GetRandom O(1), insert/delete O(1) ~ O(N) | Space O(N)
public class RandomizedSet {
    List<Integer> data;
    HashMap<Integer, Integer> valToIndex;
    Random random;

    public RandomizedSet() {
        data = new ArrayList<>();
        valToIndex = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (valToIndex.containsKey(val)) return false;
        data.add(val);
        // record the index of val
        valToIndex.put(val, data.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!valToIndex.containsKey(val)) return false;
        // get the original index of val
        int index = valToIndex.get(val);
        int lastData = data.get(data.size() - 1);
        // swap the last element with the val to remove
// move the last element to the place idx of the element to delete, because it's hashset no need to consider the order
        data.set(index, lastData);
        data.remove(data.size() - 1);
        valToIndex.put(lastData, index);
        valToIndex.remove(val);
        return true;
    }

    public int getRandom() {
        return data.get(random.nextInt(data.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */