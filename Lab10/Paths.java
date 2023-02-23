package Labb10;

public class Paths {
    City[] path;
    int sp;

    public Paths() {
        path = new City[54];
        sp = 0;
    }

    private Integer shortest(City from, City to, Integer max) {
        /*// final destination reached
        if (from == to) {
            return 0;
        }

        // check if the city is in the path already
        for(int i = 0; i < sp; i++) {
            if(path[i] == from)
                return null;
        }
        path[sp++] = from;

        // find the shortest path using the connections
        Integer shrt = null;

        for(int i = 0; i < from.neighbors.length; i++) {

            if(from.neighbors[i] != null) {
                Connections con = from.neighbors[i];

                shrt = shortest(con.city, to, max);
                if(shrt != null) {
                    if(max == null)
                        max = con.distance + shrt;
                    else if( (con.distance + shrt) < max)
                        max = (con.distance + shrt);
                }
            }
        }
        path[--sp] = null;
        return max;*/

        if (max < 0)
            return null;
        if (from == to)
            return 0;

        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;

        Integer min = max;
        Integer shrt = null;

        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connections conn = from.neighbors[i];
                shrt = shortest(conn.city, to, max - conn.distance);
                if (shrt != null) {
                    shrt = shrt + conn.distance;
                    if (shrt < min) {
                        min = shrt;
                    }
                }
            }
        }
        if (min < max) {
            shrt = min;
        }
        path[--sp] = null;
        return shrt;
    }

    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\tjeck\\IdeaProjects\\Sorted\\src\\Labb10\\trains.csv");
        Paths path = new Paths();
        City from = map.lookup("Malmö");
        City to = map.lookup("Kiruna");
        Integer max = Integer.valueOf("10000");
        long t0 = System.nanoTime();
        Integer dist = path.shortest(from, to, max);
        long time = (System.nanoTime() - t0) / 1_000_000;

        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }
}
