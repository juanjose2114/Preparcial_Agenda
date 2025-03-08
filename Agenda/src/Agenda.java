import javax.swing.*;
import java.util.ArrayList;

public class Agenda {

    private static ArrayList<Contacto> contactos;
    private static ArrayList<Reunion> reuniones;
    private static ArrayList<Contacto> contactosReunion;

    public static void main(String[] args) {

        contactos = new ArrayList<>();
        reuniones = new ArrayList<>();
        contactosReunion = new ArrayList<>();

        int opcion1 = 0;
        int opcion2;
        int opcion3;
        String mensaje = "";
        String salto = "------------------------------------------------";

        Contacto contacto;
        //atributos contacto
        String nombre;
        String alias;
        String telefono;
        String email;
        String direccion;

        Reunion reunion;
        //atributos reunion
        String distintivo;
        String descripcion;
        String fecha;
        String hora;

        boolean existe;

        for (int i = 4; i != opcion1;) {
            opcion1 = 0;
            opcion2 = 0;
            opcion3 = 0;

            opcion1 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                    Menu: \
                    
                    1.Contactos\
                    
                    2.reuniones\
                    
                    3.Grupos\
                    
                    4.Salir"""));

            //menu general
            switch (opcion1) {

                case 1://gestionar contactos
                    for (int j = 5; j != opcion2;) {
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Contactos: \
                                
                                1.agregar contacto\
                                
                                2.revizar contacto\
                                
                                3.modificar contacto\
                                
                                4.eliminar contacto\
                                
                                5.Salir"""));

                        switch (opcion2) {
                            case 1://1.agregar contacto
                                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                alias = JOptionPane.showInputDialog(null, "Apellido: ");
                                telefono = JOptionPane.showInputDialog(null, "Telefono: ");
                                email = JOptionPane.showInputDialog(null, "Email: ");
                                direccion = JOptionPane.showInputDialog(null, "direccion: ");

                                contacto = new Contacto(nombre, alias, telefono, email, direccion);

                                existe = Agenda.agregarContacto(contacto);

                                if (existe) {
                                    JOptionPane.showMessageDialog(null, "Contacto agregado");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Contacto NO agrregado");
                                }
                                break;
                            case 2://2.revizar contacto
                                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                        Menu: \
                                        
                                        1.Consultar un contacto\
                                        
                                        2.Consultar lista de contactos"""));

                                switch (opcion3) {
                                    case 1://1.Consultar un contacto
                                        JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a contultar");
                                        nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                        telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                        Contacto contactoAux = revizarContacto(nombre, telefono);
                                        if (contactoAux != null) {
                                            JOptionPane.showMessageDialog(null, contactoAux.toString());
                                        }

                                        break;
                                    case 2://2.Consultar lista de contactos
                                        for (Contacto c : contactos) {
                                            if (c != null) {
                                                JOptionPane.showMessageDialog(null, "Imprimiendo contactos en la terminal");
                                                System.out.println("\n" + c.toString() + "\n");
                                            }
                                        }
                                        break;
                                    default:
                                        System.out.println("Obcion " + opcion3 + " no valida");
                                }
                                break;
                            case 3://3.modificar contacto
                                JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a modificar");
                                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                existe = modificarContacto(nombre, telefono);
                                if (existe) {
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
                                if (existe) {
                                    JOptionPane.showMessageDialog(null, "Contacto Eliminado");
                                    System.out.println("Contecto " + nombre + telefono + "eliminado");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Contacto no Eliminado");
                                }
                                break;
                            case 5://salir
                                JOptionPane.showMessageDialog(null, "Saliendo");
                                break;
                            default://otros
                                System.out.println("Obcion " + opcion2 + " no valida");
                        }
                        System.out.println(salto);
                    }
                    break;

                case 2://gestionar reuniones
                    for (int j = 6; j != opcion2;) {
                        opcion2 = 0;
                        opcion2 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                Reuniones: \
                                
                                1.agregar reunion.\
                                
                                2.revizar reunion\
                                
                                3.modificar reunion\
                                
                                4.eliminar reunion\
                                
                                5.Asistentes\
                                
                                6.Salir"""));
                        switch (opcion2) {
                            case 1://1.agregar reunion
                                distintivo = JOptionPane.showInputDialog(null, "Distintivo: ");
                                descripcion = JOptionPane.showInputDialog(null, "Descripcion: ");
                                fecha = JOptionPane.showInputDialog(null, "Fecha: ");
                                hora = JOptionPane.showInputDialog(null, "Hora: ");

                                reunion = new Reunion(distintivo, descripcion, fecha, hora);

                                existe = agregarReunion(reunion);

                                if (existe) {
                                    JOptionPane.showMessageDialog(null, "Reunion agregada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Reunion NO agregada");
                                }
                                break;
                            case 2://2.revizar reunion1
                                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                        Menu: \
                                        
                                        1.Consultar una Reunion\
                                        
                                        2.Consultar lista de Reuniones"""));

                                switch (opcion3) {
                                    case 1://Consultar una Reunion
                                        distintivo = JOptionPane.showInputDialog(null, "ingrese el distintivo del Reunion: ");
                                        Reunion reunionAux = revizarReunion(distintivo);
                                        if (reunionAux != null) {
                                            JOptionPane.showMessageDialog(null, reunionAux.toString());
                                        }
                                        break;
                                    case 2://Consultar lista de Reuniones
                                        for (Reunion r : reuniones) {
                                            if (r != null) {
                                                System.out.println(r.toString());
                                            }
                                        }
                                }
                                break;
                            case 3://3.modificar reunion
                                distintivo = JOptionPane.showInputDialog(null, "ingrese el distintivo del Reunion: ");
                                existe = modificarReunion(distintivo);
                                if (existe) {
                                    JOptionPane.showMessageDialog(null, "Reunion Modificada");
                                }else {
                                    JOptionPane.showMessageDialog(null, "Reunion no Modificada");
                                }
                                break;
                            case 4://4.eliminar reunion
                                distintivo = JOptionPane.showInputDialog(null, "distintivo de la reunion a eliminar: ");
                                existe = eliminarReunion(distintivo);
                                if (existe) {
                                    JOptionPane.showMessageDialog(null, "Reunion Eliminada");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Reunion NO Eliminada");
                                }
                                break;
                            case 5://Asistentes

                                for (int k = 5; k != opcion3;) {

                                    opcion3 = 0;

                                    distintivo = JOptionPane.showInputDialog(null, "Distintivo de la reunion a operar: ");
                                    reunion = revizarReunion(distintivo);

                                    if (reunion != null) {
                                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                Asitentes: \
                                                
                                                1.agregar Asistentes\
                                                
                                                2.revizar Asistentes\
                                                
                                                3.modificar Asistentes\
                                                
                                                4.eliminar Asistente\
                                                
                                                5. Salir"""));


                                        switch (opcion3) {
                                            case 1://agregar Asistentes
                                                JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a agregar a la reunion");
                                                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                                telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                                contacto = revizarContactoReunion(reunion, nombre, telefono);
                                                if (contacto != null) {
                                                    reunion.agregarContacto(contacto);
                                                    JOptionPane.showMessageDialog(null, "Contacto agregado");
                                                } else {
                                                    System.out.println("Contacto NO encontrado");
                                                }
                                                break;
                                            case 2://revizar Asistentes
                                                opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, """
                                                        Menu Contactos de la reunion: \
                                                        
                                                        1.Consultar un contacto\
                                                        
                                                        2.Consultar lista de contactos"""));

                                                switch (opcion3) {
                                                    case 1://1.Consultar un contacto
                                                        JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a contultar");
                                                        nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                                        telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                                        Contacto contactoAux = revizarContactoReunion(reunion, nombre, telefono);
                                                        if (contactoAux != null) {
                                                            JOptionPane.showMessageDialog(null, contactoAux.toString());
                                                        } else {
                                                            JOptionPane.showMessageDialog(null, "Contacto NO encontrado");
                                                        }
                                                        break;
                                                    case 2://2.Consultar lista de contactos
                                                        for (Contacto c : reunion.getContactos()) {
                                                            if (c != null) {
                                                                System.out.println("\n" + c.toString() + "\n");
                                                            JOptionPane.showMessageDialog(null, "Imprimiendo en la terminal");
                                                            }
                                                        }
                                                        break;
                                                    default:
                                                        System.out.println("Obcion " + opcion3 + " no valida");
                                                }
                                                break;
                                            case 3://modificar Asistentes
                                                JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a modifiar a la reunion");
                                                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                                telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                                existe = modificarContactoReunion(reunion, nombre, telefono);
                                                if (existe) {
                                                    JOptionPane.showMessageDialog(null, "Contacto modificado modificado");
                                                } else {
                                                    System.out.println("Reunion NO encontrada");
                                                }
                                                break;
                                            case 4://eliminar Asistente
                                                JOptionPane.showMessageDialog(null, "Ingrese el nombre y telefono del contacto a eliminar");
                                                nombre = JOptionPane.showInputDialog(null, "Nombre: ");
                                                telefono = JOptionPane.showInputDialog(null, "telefono: ");
                                                existe = eliminarContactoReunion(reunion, nombre, telefono);
                                                if (existe) {
                                                    JOptionPane.showMessageDialog(null, "Contacto Eliminado");
                                                } else {
                                                    JOptionPane.showMessageDialog(null, "Contacto NO Eliminado");
                                                }
                                                break;
                                            case 5://salir
                                                JOptionPane.showMessageDialog(null, "Saliendo a menu Reuniones");
                                                break;
                                            default://otros
                                                break;
                                        }
                                    } else{
                                        opcion3 = Integer.parseInt(JOptionPane.showInputDialog(null, "reunion no encontrada\nSalir? preciona 1"));
                                        opcion3 += 4;
                                    }
                                    System.out.println(salto);
                                }
                            case 6://salir
                                JOptionPane.showMessageDialog(null, "Saliendo al menu");
                                break;
                            default://otros
                                System.out.println("Obcion " + opcion1 + " no valida");
                                break;
                        }
                    }
                    break;

                case 3://gestionar grupos
                    for (int j = 0; j != opcion2;){
                        j = 5;
                    }
                    break;

                case 4://salir
                    JOptionPane.showMessageDialog(null, "Saliendo");
                    break;

                default://otros
                    System.out.println("Obcion " + opcion1 + " no valida");
            }
            System.out.println(salto);
        }
    }

    //CRUD contacto
    private static boolean agregarContacto(Contacto contacto) {
        boolean agregado = false;
        Contacto c = revizarContacto(contacto.getNombre(), contacto.getTelefono());
        if (c == null) {
            contactos.add(contacto);
            agregado = true;
        }
        return agregado;
    }
    private static Contacto revizarContacto(String nombre, String telefono) {
        for (Contacto contacto : contactos) {
            if (contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        return null;
    }
    private static boolean modificarContacto(String nombre, String telefono) {
        boolean agregado = false;
        Contacto contacto = revizarContacto(nombre, telefono);
        if (contacto != null) {

            JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a editar");
            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
            String alias = JOptionPane.showInputDialog(null, "Alias: ");
            telefono = JOptionPane.showInputDialog(null, "Telefono: ");
            String email = JOptionPane.showInputDialog(null, "Email: ");
            String direccion = JOptionPane.showInputDialog(null, "direccion: ");

            if (revizarContacto(nombre, telefono) == null) {
                contacto.setNombre(nombre);
                contacto.setAlias(alias);
                contacto.setTelefono(telefono);
                contacto.setEmail(email);
                contacto.setDireccion(direccion);
                System.out.println(contacto.toString());
                agregado = true;
            }
        }
        return agregado;
    }
    private static boolean eliminarContacto(String nombre, String telefono) {
        boolean eliminado = false;
        Contacto contacto = revizarContacto(nombre, telefono);
        if (contacto != null) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
                contactos.remove(contacto);
                eliminado = true;
            }
        }
        return eliminado;
    }

    //CRUD runion
    private static boolean agregarReunion(Reunion reunion) {
        boolean agregado = false;
        Reunion r = revizarReunion(reunion.getDistintivo());
        if (r == null) {
            reuniones.add(reunion);
            agregado = true;
        } else{
            System.out.println("Reunion no Agregada");
        }
        return agregado;
    }
    private static Reunion revizarReunion(String distintivo) {
        for (Reunion reunion : reuniones) {
            if (reunion.getDistintivo().equals(distintivo)) {
                return reunion;
            }
        }
        return null;
    }
    private static boolean modificarReunion(String distintivo) {
        boolean agregado = false;
        Reunion reunion = revizarReunion(distintivo);
        if (reunion != null) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos de la reunion a modificar");
            distintivo = JOptionPane.showInputDialog(null, "distintivo: ");
            String descripcion = JOptionPane.showInputDialog(null, "descripcion: ");
            String fecha = JOptionPane.showInputDialog(null, "fecha: ");
            String hora = JOptionPane.showInputDialog(null, "hora: ");

            if (revizarReunion(distintivo) == null) {
                reunion.setDistintivo(distintivo);
                reunion.setDescribcion(descripcion);
                reunion.setFecha(fecha);
                reunion.setHora(hora);
                System.out.println(reunion.toString());
                agregado = true;
            }

        }
        return agregado;
    }
    private static boolean eliminarReunion(String distintivo) {
        boolean eliminado = false;
        Reunion reunion = revizarReunion(distintivo);
        if (reunion != null) {
            if (reunion.getDistintivo().equals(distintivo)) {
                reuniones.remove(reunion);
                eliminado = true;
            }
        }
        return eliminado;    }

    private static Contacto revizarContactoReunion(Reunion reunion, String nombre, String telefono) {
        for (Contacto contacto : reunion.getContactos()) {
            if (contacto.getNombre().equals(nombre)&&contacto.getTelefono().equals(telefono)) {
                return contacto;
            }
        }
        return null;
    }
    private static boolean modificarContactoReunion(Reunion reunion, String nombre, String telefono) {
        boolean agregado = false;
        Contacto contacto = revizarContactoReunion(reunion, nombre, telefono);
        if (contacto != null) {
            JOptionPane.showMessageDialog(null, "Ingrese los datos del contacto a editar");
            nombre = JOptionPane.showInputDialog(null, "Nombre: ");
            String alias = JOptionPane.showInputDialog(null, "Alias: ");
            telefono = JOptionPane.showInputDialog(null, "Telefono: ");
            String email = JOptionPane.showInputDialog(null, "Email: ");
            String direccion = JOptionPane.showInputDialog(null, "direccion: ");

            if (revizarContactoReunion(reunion, nombre, telefono) == null) {
                contacto.setNombre(nombre);
                contacto.setAlias(alias);
                contacto.setTelefono(telefono);
                contacto.setEmail(email);
                contacto.setDireccion(direccion);

                agregado = true;
            }
        }
        return agregado;
    }
    private static boolean eliminarContactoReunion(Reunion reunion, String nombre, String telefono) {
        boolean eliminado = false;
        Contacto contacto = revizarContactoReunion(reunion, nombre, telefono);
        if (contacto != null) {
            if (contacto.getNombre().equals(nombre) && contacto.getTelefono().equals(telefono)) {
                contactos.remove(contacto);
                eliminado = true;
            }
        }
        return eliminado;
    }
    //CRUD grupos

}

