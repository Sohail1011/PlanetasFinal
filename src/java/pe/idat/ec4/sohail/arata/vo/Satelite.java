package pe.idat.ec4.sohail.arata.vo;

public class Satelite {

    private int id_satelite;
    private String nombre;
    private double altura;
    private double masa;
    private Planeta planeta;

    public Satelite() {
    }

    public Satelite(int id_satelite, String nombre, double altura, double masa, Planeta planeta) {
        this.id_satelite = id_satelite;
        this.nombre = nombre;
        this.altura = altura;
        this.masa = masa;
        this.planeta = planeta;
    }

    @Override
    public String toString() {
        return "Satelite {" + "id_satelite: " + id_satelite + "nombre: " + nombre
                + "altura: " + altura + "masa: " + masa
                + "planeta: " + planeta.getNombre() + '}';
    }

    public int getId_satelite() {
        return id_satelite;
    }

    public void setId_satelite(int id_satelite) {
        this.id_satelite = id_satelite;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa = masa;
    }

    public Planeta getPlaneta() {
        return planeta;
    }

    public void setPlaneta(Planeta planeta) {
        this.planeta = planeta;
    }
}
