package pe.idat.ec4.sohail.arata.vo;

import java.util.*;

public class Planeta {

    private int id_planeta;
    private String nombre;
    private Collection<Satelite> itemsSatelites = new ArrayList<>();

    public Planeta() {
    }

    public Planeta(int id_planeta, String nombre) {
        this.id_planeta = id_planeta;
        this.nombre = nombre;
    }

    public void addSatelite(Satelite satelite) {
        itemsSatelites.add(satelite);
    }

    public int getId_planeta() {
        return id_planeta;
    }

    public void setId_planeta(int id_planeta) {
        this.id_planeta = id_planeta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Collection<Satelite> getItemsSatelites() {
        return itemsSatelites;
    }

    public void setItemsSatelites(Collection<Satelite> itemsSatelites) {
        this.itemsSatelites = itemsSatelites;
    }
}
