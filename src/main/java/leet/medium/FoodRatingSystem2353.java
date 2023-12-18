package leet.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class FoodRatingSystem2353 {
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};
        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
        System.out.println(foodRatings.highestRated("korean"));
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese"));
        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese"));
    }
}

// time : O(nlogn + m(log(n+m))), space: O(n+m)
class FoodRatings {

    private Map<String, Integer> foodRatingMap;
    private Map<String, String> foodCuisineMap;
    private Map<String, PriorityQueue<Food>> cuisineFoodMap;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodRatingMap = new HashMap<>();
        foodCuisineMap = new HashMap<>();
        cuisineFoodMap = new HashMap<>();
        for(int i = 0 ; i < foods.length ; i++) {
            foodRatingMap.put(foods[i], ratings[i]);
            foodCuisineMap.put(foods[i], cuisines[i]);
            cuisineFoodMap.computeIfAbsent(cuisines[i], k -> new PriorityQueue<>()).add(new Food(ratings[i], foods[i]));
        }
    }

    public void changeRating(String food, int newRating) {
        foodRatingMap.put(food, newRating);
        String cuisineName = foodCuisineMap.get(food);
        cuisineFoodMap.get(cuisineName).add(new Food(newRating, food));
    }

    public String highestRated(String cuisine) {
        Food highestRated = cuisineFoodMap.get(cuisine).peek();
        while(foodRatingMap.get(highestRated.foodName) != highestRated.foodRating) {
            cuisineFoodMap.get(cuisine).poll();
            highestRated = cuisineFoodMap.get(cuisine).peek();
        }
        return highestRated.foodName;
    }
}

class Food implements Comparable<Food>{
    public int foodRating;
    public String foodName;
    public Food(int foodRating, String foodName) {
        this.foodRating = foodRating;
        this.foodName = foodName;
    }
    @Override
    public int compareTo(Food other) {
        if(foodRating == other.foodRating) {
            return foodName.compareTo(other.foodName);
        }
        return -1 * Integer.compare(foodRating, other.foodRating);
    }
}



/*
Design a food rating system that can do the following:

Modify the rating of a food item listed in the system.
Return the highest-rated food item for a type of cuisine in the system.
Implement the FoodRatings class:

FoodRatings(String[] foods, String[] cuisines, int[] ratings) Initializes the system. The food items are described by foods, cuisines and ratings, all of which have a length of n.
foods[i] is the name of the ith food,
cuisines[i] is the type of cuisine of the ith food, and
ratings[i] is the initial rating of the ith food.
void changeRating(String food, int newRating) Changes the rating of the food item with the name food.
String highestRated(String cuisine) Returns the name of the food item that has the highest rating for the given type of cuisine. If there is a tie, return the item with the lexicographically smaller name.
Note that a string x is lexicographically smaller than string y if x comes before y in dictionary order, that is, either x is a prefix of y, or if i is the first position such that x[i] != y[i], then x[i] comes before y[i] in alphabetic order.
Example 1:

Input
["FoodRatings", "highestRated", "highestRated", "changeRating", "highestRated", "changeRating", "highestRated"]
[[["kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"], ["korean", "japanese", "japanese", "greek", "japanese", "korean"], [9, 12, 8, 15, 14, 7]], ["korean"], ["japanese"], ["sushi", 16], ["japanese"], ["ramen", 16], ["japanese"]]
Output
[null, "kimchi", "ramen", null, "sushi", null, "ramen"]
Constraints:

1 <= n <= 2 * 104
n == foods.length == cuisines.length == ratings.length
1 <= foods[i].length, cuisines[i].length <= 10
foods[i], cuisines[i] consist of lowercase English letters.
1 <= ratings[i] <= 108
All the strings in foods are distinct.
food will be the name of a food item in the system across all calls to changeRating.
cuisine will be a type of cuisine of at least one food item in the system across all calls to highestRated.
At most 2 * 104 calls in total will be made to changeRating and highestRated.

One way is to search for the food in the foods array and then update the rating at the respective index in the ratings array. However, searching for food in the foods array for every update will not be efficient.
Instead, we should keep the food names mapped with their ratings, we can use a hash map (named foodRatingMap) and this hash map will enable quick retrieval and modification of the respective food's rating.
To change the rating of any food, we simply update the rating stored in this foodRatingMap.
However, retrieving the highest-rated food would require iterating over all the foods of that particular cuisine each time. If we could maintain the food in cuisineFoodMap arrays in a sorted order (sorted according to ratings) then it might save us some time.
You might be thinking of sorting the array using the in-built sort() method, but if any element of the array changes (i.e. rating of any food changes) we will have to again sort the whole array using the sort() method, this will make the algorithm inefficient.
Max-heap data structure is a complete binary tree, where the parent nodes are always bigger than the corresponding child nodes, in order to keep the maximum-valued element at the root node of the tree. Here, pushing and popping an element are both logarithmic time operations, but getting the maximum-valued element is a constant time operation.
We will use priority queues which are internally implemented using a heap.
Firstly, searching for elements in the priority queue is a time-consuming task as in the worst case we would have to iterate over all elements stored in the priority queue.
Secondly, we can avoid the deletion of old rating elements.

 */
