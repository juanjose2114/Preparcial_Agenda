import java.util.ArrayList;

public class Reunion {

    private String distintivo;
    private String describcion;
    private String fecha;
    private String hora;
    private ArrayList<Contacto> contactos;

    public Reunion(String distintivo, String describcion, String fecha, String hora) {
        contactos = new ArrayList<>();
        this.distintivo = distintivo;
        this.describcion = describcion;
        this.fecha = fecha;
        this.hora = hora;
        System.out.println(toString());
    }


    public String getDistintivo() {
        return distintivo;
    }
    public void setDistintivo(String distintivo) {
        this.distintivo = distintivo;
    }
    public String getDescribcion() {
        return describcion;
    }
    public void setDescribcion(String describcion) {
        this.describcion = describcion;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }

    public ArrayList<Contacto> getContactos() {
        return contactos;
    }
    public void setContactos(ArrayList<Contacto> contactos) {
        this.contactos = contactos;
    }

    public String toString() {
        return "Distintivo: " + distintivo + "\nDescribción: " + describcion + "\nFecha: " + fecha + "\nHora: " + hora + "\n";
    }
}
