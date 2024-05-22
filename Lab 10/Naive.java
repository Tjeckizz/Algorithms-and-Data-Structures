package Labb10;

public class Naive {


    public static void main(String[] args) {
        Map map = new Map("C:\\Users\\tjeck\\IdeaProjects\\Sorted\\src\\Labb10\\trains.csv");
        City from = map.lookup("Sundsvall");
        City to = map.lookup("Göteborg");
        Integer max = Integer.valueOf("800");
        long t0 = System.nanoTime();
        Integer dist = shortest(from, to, max);
        long time = (System.nanoTime() - t0) / 1_000_000;
        System.out.println("shortest: " + dist + " min (" + time + " ms)");
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0) {
            return null;
        }
        if (from == to) {
            return 0;
        }
        Integer shrt = null;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                Connections conn = from.neighbors[i];
                Integer dist = shortest(conn.city, to, (max - conn.distance));
                if ((dist != null) && ((shrt == null) || (shrt > dist + conn.distance))) {
                    shrt = dist + conn.distance;
                }
            }
        }
        return shrt;
    }
}

