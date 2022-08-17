package com.manoj.memoization.gridtraveller;

import java.util.HashMap;
import java.util.Map;

public class GridTraveller {
    private static Map<String, Long> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(gridTraveller(2, 3, map));
        System.out.println(gridTraveller(18, 18, map));
    }

    private static Long gridTraveller(int row, int col, Map<String, Long> map) {
        String mapKey = row +"," +col;

        if(map.containsKey(mapKey)) return map.get(mapKey);

        if(row == 1 && col == 1) return 1L;
        if(col == 0 || row == 0) return 0L;

        Long result = gridTraveller(row - 1, col, map) + gridTraveller(row, col - 1, map);

        map.put(mapKey, result);

        return result;
    }


}
