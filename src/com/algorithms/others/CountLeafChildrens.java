package com.algorithms.others;

/**
 * @Author ZhongYangyixiong
 * @CreateTime 11/6/2023 10:58 AM
 * @Description:
 */

import java.util.*;

/**
 * 
 */
public class CountLeafChildrens {
    //    删除某个菜单下的所有子菜单，返回最终删除的菜单数量（用map类比数据库中的树形菜单结构）
    public int getCount(Map<Integer, List<Integer>> map, int menuId) {
        List<Integer> nodeLists = map.get(menuId);
        int sum = 0;
        if (Objects.nonNull(nodeLists)) {
            for (Integer node : nodeLists) {
                sum += getCount(map, node);
            }
        }
        return 1 + sum;
    }

    public static void main(String[] args) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        map.put(1, Arrays.asList(2, 3, 4));
        map.put(2, Arrays.asList(5, 7, 8));
        map.put(5, Arrays.asList(8, 9));

        CountLeafChildrens solution = new CountLeafChildrens();
        System.out.println("the result is :" + solution.getCount(map, 1));

    }

}
