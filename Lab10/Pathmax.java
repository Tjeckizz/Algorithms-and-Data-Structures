package Labb10;

public class Pathmax {
    City[] path;
    int sp;

    public Pathmax() {
        path = new City[54];
        sp = 0;
    }

    private Integer shortest1(City from, City to, Integer max) {
        if (max != null && max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        for (int i = 0; i < sp; i++) {
            if (path[i] == from)
                return null;
        }
        path[sp++] = from;
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connections con = from.neighbors[i];
                Integer time_left;
                if (max != null)
                    time_left = max - con.distance;
                else
                    time_left = max;
                shrt = shortest1(con.city, to, time_left);
                if (shrt != null) {                            // a path could be found
                    if (max == null)                            // no previous path found
                        max = con.distance + shrt;
                    else if ((con.distance + shrt) < max)    // if new path is shorter than current shortest
                        max = (con.distance + shrt);
                }
            }
        }
        path[--sp] = null;
        return max;
    }

    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\tjeck\\IdeaProjects\\Sorted\\src\\Labb10\\trains.csv");
        Pathmax path = new Pathmax();
        City from = map.lookup("Malmö");
        City to = map.lookup("");
        Integer max = Integer.valueOf("10000");
        long t0 = System.nanoTime();
        Integer dist = path.shortest1(from, to, max);
        long time = (System.nanoTime() - t0) / 1_000;
        System.out.println("shortest: " + dist + " min (" + time + " micros)");
    }
}

