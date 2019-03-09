package Week6;

import java.util.Scanner;

public class Search {

    static int[][] map;
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = 10; //scanner.nextInt();
        GenerateMap();
        DeeplySearch(6,0,n-1,n-1);

        System.out.println("***********************************************************8");
        GenerateMap();
        WidelySearch(6,0,n-1,n-1);

    }

    /**
     * @ -1  end
     * @ 0  road
     * @ 1  have been /wall
     *
     * @param startX start point
     * @param startY start point
     * @param endX end point
     * @param endY end point
     */

    public static void WidelySearch(int startX, int startY, int endX, int endY){
        if(endX >= map.length)
            endX = map.length -1;
        if (endY >= map[0].length)
            endY = map[0].length -1;

        int num = 2;
        map[endX][endY] = 0;
        ws(startX, startY, num);
        drawMap();
    }

    private static void ws(int x, int y, int num){

        map[x][y] = num;

        // to down
        if (x+1 < map.length && map[x + 1][y] == 0){
            ws(x+1,y ,num+1);
        }

        // to right
        if (y+1 < map[0].length && map[x][y + 1] == 0){
            ws(x, y+1 , num+1);
        }

        // to up
        if (x-1 >= 0 && map[x - 1][y] == 0){
            ws(x-1, y , num+1);
        }

        // to left
        if (y-1 >= 0 && map[x][y - 1] == 0){
            ws(x, y-1, num + 1);
        }
    }


    public static void DeeplySearch(int startX, int startY, int endX, int endY){
        if(endX >= map.length)
            endX = map.length -1;
        if (endY >= map[0].length)
            endY = map[0].length -1;

        System.out.println("endX = " + endX);
        System.out.println("endY = " + endY);

        int x = startX, y = startY;
        Location l = new Location(x, y);
        Stack WalkedRoad = new Stack();

        while(x != endX || y != endY){

            x = l.x;
            y = l.y;
            System.out.println("("+x+", "+y+ ")");
            map[x][y] = 1;

            // to down
            if (x+1 < map.length && map[x + 1][y] == 0){
                map[x][y] = 1;
                WalkedRoad.push(new Location(x,y));
                l.x++;
                System.out.println("down");
                continue;

            }

            // to right
            if (y+1 < map[0].length && map[x][y + 1] == 0){
                map[x][y] = 1;
                WalkedRoad.push(new Location(x,y));
                l.y++;
                System.out.println("right");
                continue;
            }

            // to up
            if (x-1 >= 0 && map[x - 1][y] == 0){
                map[x][y] = 1;
                WalkedRoad.push(new Location(x,y));
                l.x--;
                System.out.println("up");
                continue;
            }

            // to left
            if (y-1 >= 0 && map[x][y - 1] == 0){
                map[x][y] = 1;
                WalkedRoad.push(new Location(x,y));
                l.y--;
                System.out.println("left");
                continue;
            }

            // if program be here means there is no way to go, so we should go back


            if(WalkedRoad.isEmpty()){ // when we back to origin point and we find no way to go, then we stop here
                System.out.println("No such road");
                return;
            }

            if (l.x == endX && l.y == endY){ // good jop! we find it !
                System.out.println("found it");
                break;
            }

            l = (Location)WalkedRoad.pop();
            System.out.println("back");

        }

        while(!WalkedRoad.isEmpty()) {
            Location ls = (Location)(WalkedRoad.pop());
            System.out.print("("+ls.x+", "+ls.y+ ")");
            map[ls.x][ls.y] = 6;
        }
        System.out.println();

        drawMap();

    }

    private static void drawMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + "  ");
            }
            System.out.println();
        }
    }
    private static void GenerateMap(int n){
        map = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = (int)(Math.random()*2);
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void GenerateMap(){
        int[][] ma = {
                {0,0,0,1,0,1,0,1,1,1},
                {1,0,1,0,1,0,0,0,1,1},
                {1,0,1,0,1,0,1,0,1,1},
                {1,0,1,0,1,0,1,0,0,1},
                {1,0,1,0,0,0,1,1,0,1},
                {1,0,1,0,1,0,1,0,0,0},
                {1,0,1,0,1,0,1,0,1,0},
                {1,0,0,0,1,1,0,0,1,0}
        };
        map = ma;
    }

}

class Location{
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int x;
    int y;
}

class Stack{

    private Node top;

    public Stack(Object obj) {
        top = new Node(obj);
    }

    public Stack() {
    }

    public void push(Object obj){

        if(top == null){
            top = new Node(obj);
            return;
        }
        Node temp = top;
        top = new Node(obj, temp);
    }

    public Object getTop() {
        return top.getObj();
    }

    public Object pop(){
        Object get = getTop();
        top = top.getNextNode();
        return get;
    }

    public boolean isEmpty(){
        return top == null;
    }

    public void makeEmpty(){
        top = null;
    }
}

class Node{
    private Object obj;
    private Node nextNode;

    Node(Object obj) {
        this.obj = obj;
    }

    Node(Object obj, Node nextNode) {
        this.obj = obj;
        this.nextNode = nextNode;
    }

    Object getObj() {
        return obj;
    }

    Node getNextNode() {
        return nextNode;
    }
}