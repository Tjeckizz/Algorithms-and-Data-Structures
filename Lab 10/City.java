package Labb10;

public class City {
    String name;
    Connections[] neighbors;

    public City(String name) {
        this.name = name;
        this.neighbors = null;
    }

    public void addConnection(City dest, Integer minutes) {
        if (neighbors == null) {
            neighbors = new Connections[1];
            neighbors[0] = new Connections(dest, minutes);
        } else {
            Connections[] tmp = new Connections[this.neighbors.length + 1];
            int i = 0;
            for (; i < neighbors.length; i++) {
                tmp[i] = neighbors[i];
            }
            tmp[i] = new Connections(dest, minutes);
            neighbors = tmp;
        }

    /*public City(String cityname){
        this.name = cityname;
        this.neighbors = new Connections[10];
    }

    public void addConnenction(City city, Integer distance){

        for(int i = 0; i < this.neighbors.length; i++) {
            if (this.neighbors[i] == null) {
                this.neighbors[i] = new Connections(city, distance);
                return;
            }
        }
    }*/
    }
}
