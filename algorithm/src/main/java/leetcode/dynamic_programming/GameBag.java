package leetcode.dynamic_programming;

import java.util.*;

/**
 * @author Fang
 * @date 2022-03-20 22:11
 */
public class GameBag {

    private static class ArrayElement {
        private int value;  // 分数
        private Set<Element> elements = new HashSet<>();

        public ArrayElement() {
            this.value = value;
            this.elements = elements;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Set<Element> getElements() {
            return elements;
        }

        public void setElements(Set<Element> elements) {
            this.elements = elements;
        }

        @Override
        public String toString() {
            String str = "value:" + value;
            for (Element element : elements) {
                str += " e: " + element.name;
            }
            return str;
        }
    }

    private static class Element {
        private String name;
        private int value;  // 分数
        private int cost;  // 消耗

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getCost() {
            return cost;
        }

        public void setCost(int cost) {
            this.cost = cost;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Element(String name, int value, int cost) {
            this.name = name;
            this.value = value;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Element{" +
                    "name='" + name + '\'' +
                    ", value=" + value +
                    ", cost=" + cost +
                    '}';
        }
    }

    public static void putBag(Element[] goods, int allCost) {
        int x = goods.length + 1;   //  扩展出多余的一行一列,都为0,方便计算
        int y = allCost + 1;
        ArrayElement arrayElement = new ArrayElement();
        int[][] calcArray = new int[x][y];
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                int goodsIndex = i - 1;
                int preRow = i - 1;
                if (i == 0) {
                    calcArray[i][j] = 0;
                } else {
                    // 当前是否能放入
                    if (goods[goodsIndex].cost > j) { //不能
                        calcArray[i][j] = calcArray[preRow][j];
                    } else {
                        int spare = j - goods[goodsIndex].cost;
                        calcArray[i][j] = Math.max(calcArray[preRow][j],
                                goods[i-1].value + calcArray[preRow][spare]);
                    }
                }
            }
        }
        int result = calcArray[x-1][y-1];
        System.out.println(result);

        List<Element> include = findWhich(x - 1, y - 1, calcArray, goods);
        for (Element element : include) {
            System.out.println(element);
        }
    }

    public static List<Element> findWhich(int x, int y, int[][] calcArray, Element[] goods) {
        ArrayList<Element> elements = new ArrayList<>();
        if (x > 0) {
            if (calcArray[x - 1][y] == calcArray[x][y]) {
                elements.addAll(findWhich(x - 1, y, calcArray, goods));
            } else {
                elements.add(goods[x - 1]);
                elements.addAll(findWhich(x - 1, y - goods[x - 1].cost, calcArray, goods));
            }
        }
        return elements;
    }



    public static void main(String[] args) {
        Element[] goods = new Element[]{
                new Element("天安门", 9, 5),
                new Element("故宫", 9, 20),
                new Element("颐和园", 9, 10),
                new Element("八达岭长城", 7, 5),
                new Element("天坛", 6, 5),
                new Element("圆明园", 8, 10)};
        putBag(goods, 30);
    }

}
