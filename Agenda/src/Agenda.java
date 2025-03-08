import javax.swing.*;
import java.util.ArrayList;

public class Agenda {

    public static ArrayList<Contacto> contactos;

    public static void main(String[] args) {

        contactos = new ArrayList<>();
        int opcion1 = 0;
        int opcion2 = 0;
        String nombre;
        String alias;
        String telefono;
        String email;
        String direccion;
        boolean existe;

        for (int i = 5; i != opcion1;) {
            opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu: \
                    
                    1.agregar contacto.\
                    
                    2.revizar contacto\
                    
                    3.modificar contacto\
                    
                    4.eliminar contacto\
                    
                    5.Salir"""));

            switch (opcion1) {
                case 1://1.agregar contacto.
                    nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                    alias = JOptionPane.showInputDialog(null, "Apellido: ");
                    telefono = JOptionPane.showInputDialog(null, "Telefono: ");
                    email = JOptionPane.showInputDialog(null, "Email: ");
                    direccion = JOptionPane.showInputDialog(null, "direccion: ");

                    Contacto contacto = new Contacto(nombre, alias, telefono, email, direccion);

                    existe = Agenda.agregarContacto(contacto);

                    if (existe) {
                        JOptionPane.showMessageDialog(null, "Contacto existe");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contacto no existe");
                    }
                    break;
                case 2://2.revizar contacto
                    opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                            Menu: \
                            
                            1.Consultar un contacto\
                            
                            2.Consultar lista de contactos"""));

                    switch(opcion2){
                        case 1://1.Consultar un contacto
                            JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a contultar");
                            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                            telefono = JOptionPane.showInputDialog(null, "telefono: ");
                            existe =  revizarContacto(nombre, telefono);
                            if (existe) {
                                JOptionPane.showMessageDialog(null, "empleado existe");
                            } else {
                                JOptionPane.showMessageDialog(null, "empleado no existe");
                            }
                            break;
                        case 2://2.Consultar lista de contactos
                            for (Contacto c : contactos) {
                                if (c != null) {
                                    System.out.println("\n" + c.toString() + "\n");
                                }
                            }
                            break;
                        default:
                            break;
                    }
                    break;
                case 3://3.modificar contacto
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a modificar");
                    nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                    telefono = JOptionPane.showInputDialog(null, "telefono: ");
                    existe = modificarContacto(nombre, telefono);
                    if(existe) {
                        JOptionPane.showMessageDialog(null, "Contacto Modificado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contacto no Modificado");
                    }
                    break;
                case 4://4.eliminar contacto
                    JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a eliminar");
                    nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                    telefono = JOptionPane.showInputDialog(null, "telefono: ");
                    existe = eliminarContacto(nombre, telefono);
                    if(existe) {
                        JOptionPane.showMessageDialog(null, "Contacto Eliminado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Contacto no Eliminado");
                    }
                    break;
                default:
                    if (opcion1 == 5) {System.out.println("Saliendo");}
                    else{System.out.println("Obcion " + opcion1 + " no valida");}
                    break;
            }
        }
    }

    //CRUD contacto
    private static boolean agregarContacto(Contacto contacto) {
        boolean agregado = false;
        Contacto c = buscarContacto(contacto.getNombre(), contacto.getTelefono());
        if (c == null) {
            contactos.add(contacto);
            agregado = true;
        } else {
            JOptionPane.showMessageDialog(null, "Contacto ya existe");
        }
        return agregado;
    }
    private static boolean revizarContacto(String nombre, String telefono) {
        boolean agregado = false;
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)) {
                agregado = true;
            }
        }
        return agregado;
    }
    private static boolean modificarContacto(String nombre, String telefono) {
        boolean agregado = false;
        Contacto contacto = buscarContacto(nombre, telefono);
        if (contacto != null) {

           JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a editar");
           nombre = JOptionPane.showInputDialog(null, "Nombre: ");
           String alias = JOptionPane.showInputDialog(null, "Alias: ");
           telefono = JOptionPane.showInputDialog(null, "Telefono: ");
           String email = JOptionPane.showInputDialog(null, "Email: ");
           String direccion = JOptionPane.showInputDialog(null, "direccion: ");

           contacto.setNombre(nombre);
           contacto.setAlias(alias);
           contacto.setTelefono(telefono);
           contacto.setEmail(email);
           contacto.setDireccion(direccion);

           agregado = true;
        }
        return agregado;
    }
    private static boolean eliminarContacto(String nombre, String telefono) {
        boolean eliminado = false;
        Contacto contacto = buscarContacto(nombre, telefono);
        if (contacto != null) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
                contactos.remove(contacto);
                eliminado = true;
            }
        }
        return eliminado;
    }

    private static Contacto buscarContacto(String nombre, String telefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        JOptionPane.showMessageDialog(null, "Contacto no encontrado");
        return null;
    }
}