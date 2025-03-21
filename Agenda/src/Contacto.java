

public class Contacto {

    private String nombre;
    private String alias;
    private String telefono;
    private String email;
    private String direccion;

    public Contacto(String nombre, String alias, String telefono, String email, String direccion) {
        this.nombre = nombre;
        this.alias = alias;
        this.telefono = telefono;
        this.email = email;
        this.direccion = direccion;
        System.out.println("Contacto creado:\n" + toString());
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getAlias() {
        return alias;
    }
    public void setAlias(String alias) {
        this.alias = alias;
    }
    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre + "\nAlias: " + alias + "\nTelefono " + telefono + "\nEmail: " + email + "\nDireccion: " + direccion;
    }
}
