import java.util.Arrays;

public class Grupo {
    private String nombre;
    private Contacto[] contactos;
    private Categoria categoria;
    public Grupo(String nombre, Contacto[] contactos, Categoria categoria) {
        this.nombre = nombre;
        this.categoria = categoria;
        contactos = new Contacto[4];
        System.out.println(toString());
    }
    public boolean agregarContacto(Contacto contacto) {
        boolean agregado = false;
        for (int i = 0; i < contactos.length; i++) {
            if (contactos[i] == null) {
                contactos[i] = contacto;
            }
        }
        return agregado;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Contacto[] getContactos() {
        return contactos;
    }
    public void setContactos(Contacto[] contactos) {
        this.contactos = contactos;
    }
    public Categoria getTipo() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String toString() {
        return "Nombre: " + nombre + "\nCategoria: " + categoria;
    }
}
