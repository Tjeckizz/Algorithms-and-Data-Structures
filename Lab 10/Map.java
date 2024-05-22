package Labb10;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private final City[] cities;
    private final int mod = 541;

    public Map(String file) {
        cities = new City[mod];

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                //Node current = new Node(row[0], row[1], Integer.valueOf(row[2]));
                City from = lookup(row[0]);
                City to = lookup(row[1]);
                //System.out.println("add connection A");
                lookup(row[0]).addConnection(to, Integer.valueOf(row[2]));
                //System.out.println("add connection B");
                lookup(row[1]).addConnection(from, Integer.valueOf(row[2]));
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash * 31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    /*public City lookup(String name)
    {
        int hashIndex = hash(name);
        for (int i = hashIndex; i < cities.length; i++) {
            if(cities[i] == null)
            {
                hashIndex = i;
                break;
            }
            else if(cities[i].name.equals(name))
            {
                return cities[i];
            }
        }
        cities[hashIndex] = new City(name);
        return cities[hashIndex];
    }*/

    public City lookup(String name) {
        //System.out.println("lookup" + name);
        int i = hash(name);
        while (true) {
            if (cities[i] == null) {
                cities[i] = new City(name);
                break;
            }
            if (cities[i].name.equals(name)) {
                break;
            }
            i = i + 1 % mod;
        }
        return cities[i];
    }

    public static void main(String[] Args) {
        Map file = new Map("C:\\Users\\tjeck\\IdeaProjects\\Sorted\\src\\Labb10\\trains.csv");
        System.out.println(file.lookup("Uppsala").neighbors[2].city.name);
        /*for (int i = 0; i < file.cities.length; i++) {
            System.out.println();
            System.out.println(file.cities[i].name);
            System.out.println();

            int j = 0;
            while (file.cities[i].neighbors[j] != null) {
                System.out.println(file.cities[i].neighbors[j].city);
                j++;
            }
        }*/
    }
}
