package vista;

import logica.Persona;
import logica.Material;
import logica.EstadoOrden;
import logica.Cliente;
import logica.OrdenTrabajo;
import logica.GestorOrden;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.time.LocalDate;

public class GestionSistema{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GestorOrden gestor = new GestorOrden(); // Instancia directa (sin usar la interfaz como tipo)
        
        int op;
        do {
            System.out.println("\n=== MENU PRINCIPAL ===");
            System.out.println("1. Gestion de Orden");
            System.out.println("2. Mostrar todas las ordenes");
            System.out.println("3. Mostrar ordenes por estado");
            System.out.println("4. Facturar orden");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            
            op = sc.nextInt();
            sc.nextLine(); 
            
            switch (op) {
                case 1:
                    gestionOrdenes(gestor, sc);
                    break;
                    
                case 2:
                    gestor.mostrar(); 
                    break;
                    
                    
                case 3:
                    filtrarOrden(gestor, sc); 
                    break;
                    
                case 4:
                    System.out.print("Ingrese el serial a facturar: ");
                    gestor.facturarOrden(sc.nextLine()); // Implementado en la interfaz
                    break;
                    
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                    
                default:
                    System.out.println("Opcion invalida. Por favor digite 1-5.");
            }
        } while (op != 5);
        
        sc.close();
    }
    public static List<OrdenTrabajo> crearOrden() {
        List<OrdenTrabajo> ordenes = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Cuantas ordenes de trabajo desea agregar?");
        int total = sc.nextInt();
        sc.nextLine(); 

        // Crear cliente
        System.out.println("Ingrese el nombre del cliente");
        String nom = sc.nextLine();
        System.out.println("Ingrese el numero de celualr del cliente");
        String tel = sc.nextLine();
        System.out.println("Ingrese Cedula del cliente");
        String ced = sc.nextLine();
        System.out.println("Ingrese la direccion del cliente");
        String dir = sc.nextLine();
        Persona cliente = new Cliente(nom, tel, ced, dir);

        // Crear órdenes
        for (int i = 0; i < total; i++) {
            List<Material> materiales = new ArrayList<>();
            System.out.println("Orden " + (i + 1));
            System.out.println("Digite un numero de serie para identificar la orden");
            String serial = sc.nextLine();
            System.out.println("Ingrese la fecha de inicio del trabajo [AAAA-MM-DD]");
            LocalDate inicio = LocalDate.parse(sc.nextLine());
            System.out.println("Ingrese la fecha limite para terminar el trabajo [AAAA-MM-DD]");
            LocalDate fin = LocalDate.parse(sc.nextLine());
            EstadoOrden estado = EstadoOrden.PENDIENTE;
            System.out.println("Digite el costo de la mano de obra");
            double costoT = sc.nextDouble();
            sc.nextLine(); 

            System.out.println("Digite el numero de materiales que se van a usar para este trabajo");
            int cantMaterial = sc.nextInt();
            sc.nextLine(); 

            for (int j = 0; j < cantMaterial; j++) {
                System.out.println("\nMaterial " + (j + 1));
                System.out.println("Nombre del material");
                String nomM = sc.nextLine();
                System.out.println("Ingrese el precio unitario del material");
                double cost = sc.nextDouble();
                sc.nextLine();
                System.out.println("Ingrese el codigo del material");
                String cod = sc.nextLine();
                System.out.println("Ingrese cuantas unidades del material se necesitan");
                int uni = sc.nextInt();
                materiales.add(new Material(nomM, cost, cod, uni));
                sc.nextLine(); 
            }

            ordenes.add(new OrdenTrabajo(serial, inicio, fin, estado, costoT, cliente, materiales));
        }

        return ordenes;
    }
    
    
  public static void filtrarOrden(GestorOrden gestor, Scanner sc){
        int tipoOrden;
           System.out.println("1.Mostar Ordenes Pendientes");
           System.out.println("2.Mostrar Ordenes En Progreso");
           System.out.println("3.Mostrar Ordenes Completadas");
           System.out.println("4.Mostrar Ordenes Canceladas");
           System.out.println("Digite el numero segun la opcion requerida");
           tipoOrden = sc.nextInt();
           switch(tipoOrden){
               
               case 1: gestor.MostrarOrdenesPendientes();
                        break;
               case 2: gestor.mostrarOrdenesEnProgreso();
                        break;
               case 3: gestor.MostrarOrdenesCompletadas();
                        break;
               case 4: gestor.MostrarOrdenesCanceladas();
                        break;
               default: System.out.println("Opcion invalida. Digite una opcion correcta");         
                  
           }
  }  
    
    public static void gestionOrdenes(GestorOrden gestor, Scanner sc){
        System.out.println("DIGITE LA OPCION REQUERIDA: ");
        System.out.println("1.Crear Orden");
        System.out.println("2.Cambiar Estado de una Orden");
        System.out.println("3.Eliminar una Orden");
        System.out.println("4.Volver al menu");
        int op = sc.nextInt();
        switch(op){
            case 1: gestor.agregar();
                    break;
            case 2: System.out.print("Ingrese el serial de la orden: ");
                    String Nserie = sc.nextLine();
                    gestor.cambiarEstadoOrden(Nserie); // Implementado en la interfaz
                    break;
            case 3: System.out.print("Ingrese el serial de la orden que desea eliminar: ");
                     Nserie = sc.nextLine();
                    gestor.eliminar();
                    break;
            case 4: 
                    return;
            default: System.out.println("Ingrese una opcion valida");
        }
    }

}