/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ergjava2023.roundrobin;

/**
 *
 * @author frag.pel
 */
public class FindMin {
     public int findMinimumInSecondColumn(int[][] array) {
        if (array == null || array.length == 0 || array[0].length < 2) {
            throw new IllegalArgumentException("Invalid array. Cannot find minimum in the second column.");
        }

        int minInSecondColumn = array[0][1]; // Assume the first element in the second column is the minimum

        for (int i = 1; i < array.length; i++) {
            if (array[i][1] < minInSecondColumn) {
                minInSecondColumn = array[i][1];
            }
        }

        return minInSecondColumn;
    }
    public int findMinimumPrice(int[] prices) {
        if (prices == null || prices.length == 0) {
            throw new IllegalArgumentException("The array is empty. Cannot find minimum price.");
        }

        int minPrice = prices[0]; // Assume the first element is the minimum

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }

        return minPrice;
    }
}
