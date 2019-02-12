/* Given an array with values ranging from 1 to length of the array,
find all duplicates in the array.

1 <= x <= len(array)

array = []  -> result = []
array = [1, 1, 1]   -> result = [1]
array = [1, 2]  -> result = []
array = [1,2,1,2] -> result = [1,2]
*/

    // Brute Force solution
    // Time Complexity - O(N^2)
    // Space Complexity - O(N)
public List<Integer> findDuplicatesBrute(int [] arr) {
    Set<Integer> result = new HashSet<>();
    for(int i = 0; i < arr.length; i++) {
        for(int j = i + 1; j < arr.length; j++) {
            if(arr[i] == arr[j]) {
                result.add(arr[i]);
            }
        }
        return new ArrayList<>(result);
    }
}


    // Optimal Solution with O(N) time
public List<Integer> findDuplicates(int [] arr) {
    Set<Integer> result = new HashSet<>();

    for(int i = 0; i < arr.length; i++) {
        int index = Math.abs(arr[i]) - 1;
        if(arr[index] > 0) {
            arr[index] = -arr[index];
        }
        else {
            result.add(arr[i]);
        }
    }
    // Set all array values back to original - optional step but nice to do
    for(int i = 0; i < arr.length; i++) {
        arr[i] = Math.abs(arr[i]);
    }

    return new ArrayList<>(result);
}