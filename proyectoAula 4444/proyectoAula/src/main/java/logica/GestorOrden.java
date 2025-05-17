package logica;

import vista.GestionSistema;
import interfaz.Gestionable;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;

public class GestorOrden implements Gestionable {
    private List<OrdenTrabajo> ordenes = new ArrayList<>();
    private List<Factura> facturas = new ArrayList<>();
    private int ordenesHoy = 0;
    private LocalDate fechaUltimoRegistro = LocalDate.now();
    private final int limiteDiario = 10;

    public GestorOrden() {
    // Las listas ya se inicializan al declararlas
}

    public List<Factura> getFacturas() {
        return facturas;
    }

    public void setFacturas(List<Factura> facturas) {
        this.facturas = facturas;
    }
    
    
    public List<OrdenTrabajo> getOrdenes() {
        return ordenes;
    }

    public void setOrdenes(List<OrdenTrabajo> ordenes) {
        this.ordenes = ordenes;
    }


    
    
public void MostrarOrdenesPendientes(){
      System.out.println("Ordenes de trabajo PENDIENTES:");
      boolean hayPendientes = false;
      for (OrdenTrabajo orden : ordenes) {
        if (orden.getEstado() == EstadoOrden.PENDIENTE) {
            hayPendientes = true;
            System.out.println("Serial: " + orden.getSerial());
            System.out.println("Fecha de creacion: " + orden.getFechaCreacion());
            System.out.println("Fecha limite: " + orden.getFechaLimite());
            System.out.println("Cliente: " + orden.getCliente().getNombre()); 
            System.out.println("Estado: " + orden.getEstado());
            System.out.println("Costo: $" + orden.getCostoTrabajo());
            System.out.println("----------");
        }
    }
      if (!hayPendientes) {
        System.out.println("No hay ordenes pendientes.");
    }
}    
      
                  
  public void mostrarOrdenesEnProgreso() {
    System.out.println("Ordenes de trabajo EN PROCESO:");
    boolean hayEnProceso = false;

    for (OrdenTrabajo orden : ordenes) {
        if (orden.getEstado() == EstadoOrden.EN_PROGRESO) {
            hayEnProceso = true;
            System.out.println("Serial: " + orden.getSerial());
            System.out.println("Fecha de creacion: " + orden.getFechaCreacion());
            System.out.println("Fecha limite: " + orden.getFechaLimite());
            System.out.println("Cliente: " + orden.getCliente().getNombre()); 
            System.out.println("Estado: " + orden.getEstado());
            System.out.println("Costo: $" + orden.getCostoTrabajo());
            System.out.println("----------");
        }
    }

    if (!hayEnProceso) {
        System.out.println("No hay ordenes en progreso.");
    }
}     

  

  public void MostrarOrdenesCompletadas(){
      System.out.println("Ordenes de trabajo COMPLETADAS");
      boolean hayComplet=false;
      for(OrdenTrabajo orden : ordenes){
          if(orden.getEstado()==EstadoOrden.COMPLETADA){
              hayComplet=true;
            System.out.println("Serial: " + orden.getSerial());
            System.out.println("Fecha de creacion: " + orden.getFechaCreacion());
            System.out.println("Fecha limite: " + orden.getFechaLimite());
            System.out.println("Cliente: " + orden.getCliente().getNombre()); 
            System.out.println("Estado: " + orden.getEstado());
            System.out.println("Costo: $" + orden.getCostoTrabajo());
            System.out.println("----------");
          }
          
      } 
      if (!hayComplet) {
        System.out.println("No hay ordenes completadas.");
    }
  }



  public void MostrarOrdenesCanceladas(){
      System.out.println("Ordenes de trabajo CANCELADAS");
      boolean hayCancel=false;
      for(OrdenTrabajo orden : ordenes){
          if(orden.getEstado()==EstadoOrden.CANCELADA){
              hayCancel= true;
              System.out.println("Serial: " + orden.getSerial());
            System.out.println("Fecha de creacion: " + orden.getFechaCreacion());
            System.out.println("Fecha limite: " + orden.getFechaLimite());
            System.out.println("Cliente: " + orden.getCliente().getNombre()); 
            System.out.println("Estado: " + orden.getEstado());
            System.out.println("Costo: $" + orden.getCostoTrabajo());
            System.out.println("----------");
          }
      }
      if(!hayCancel){
          System.out.println("No hay ordenes canceladas");
      }
  }
  
  //metodos de el interfaz 
    @Override
 public void facturarOrden(String serial){
     for(OrdenTrabajo orden : ordenes){
         if(orden.getSerial().equalsIgnoreCase(serial)){
             String serialFactura = "FAC-" + serial.toUpperCase();
                LocalDate fechaEmision = LocalDate.now();
                 double totalMateriales = 0;
                for (Material m : orden.getCantMateriales()) {
                    totalMateriales += m.getCosto() * m.getUnidad();
                }
                
                 double totalFactura = orden.getCostoTrabajo() + totalMateriales;
                 
                 Factura factura = new Factura(serialFactura, fechaEmision, orden.getCantMateriales());
                facturas.add(factura);
                 
                System.out.println("——– FACTURA GENERADA ——–");
                System.out.println("Serial factura : " + factura.getSerialFactura());
                System.out.println("Fecha emisión  : " + factura.getFechaEmision());
                System.out.println("Cliente        : " + orden.getCliente().getNombre());
                System.out.println("Mano de obra   : $" + orden.getCostoTrabajo());
                System.out.println("Materiales:");
                for (Material m : factura.getMateriales()) {
                    System.out.printf("  - %s (x%d): $%.2f%n",
                        m.getNombre(), m.getUnidad(), m.getCosto() * m.getUnidad());
                }
                System.out.println("TOTAL A PAGAR  : $" + totalFactura);
                System.out.println("———————————————");
                return;  
         }     
     }
       System.out.println("No se encontro orden con seral: " + serial);
 }

 
 
    @Override
    public void agregar() {
        verificarDia();
        if (ordenesHoy >= limiteDiario) {
            System.out.println("Límite diario alcanzado. No se pueden agregar más órdenes hoy.");
            return;
        }
        OrdenTrabajo nuevaOrden = GestionSistema.crearOrden().get(0); 
        ordenes.add(nuevaOrden);
        ordenesHoy++;
        System.out.println("Orden agregada: " + nuevaOrden.getSerial());
    }
    
    @Override
    public void eliminar() {
        if (ordenes.isEmpty()) {
            System.out.println("No hay odenes para eliminar.");
            return;
        }
        OrdenTrabajo ordenEliminada = ordenes.remove(0);
        System.out.println("Orden eliminada: " + ordenEliminada.getSerial());
    }
    

    public void mostrar() {
    
    if (ordenes.isEmpty()) {
            System.out.println("No hay ordenes registradas.");
            return;
        }
        
        System.out.println("=== Ordenes Registradas ===");
        for (OrdenTrabajo orden : ordenes) {
            System.out.println("-----------");
            System.out.println("Serial: " + orden.getSerial());
            System.out.println("Fecha de creacion: " + orden.getFechaCreacion());
            System.out.println("Estado: " + orden.getEstado());
            System.out.println("Costo: $" + orden.getCostoTrabajo());
            System.out.println("----------");
        }
}

    @Override
    public void cambiarEstadoOrden(String serial) {
      
         Scanner sc = new Scanner(System.in);
    for (OrdenTrabajo orden : ordenes) {
        if (orden.getSerial().equalsIgnoreCase(serial)) {
            System.out.println("Seleccione el nuevo estado para la orden " + serial + ":");
                System.out.println("1. PENDIENTE");
                System.out.println("2. EN_PROGRESO");
                System.out.println("3. COMPLETADA");
                System.out.println("4. CANCELADA");
                System.out.print("Opcion: ");
                int opcion = sc.nextInt();
                sc.nextLine(); 

                switch (opcion) {
                    case 1:
                        orden.setEstado(EstadoOrden.PENDIENTE);
                        break;
                    case 2:
                        orden.setEstado(EstadoOrden.EN_PROGRESO);
                        break;
                    case 3:
                        orden.setEstado(EstadoOrden.COMPLETADA);
                        break;
                    case 4:
                        orden.setEstado(EstadoOrden.CANCELADA);
                        break;
                    default:
                        System.out.println("Opcion invalida. No se modifico el estado.");
                        return;
                }
              System.out.println("Estado actualizado a: " + orden.getEstado());
                return;
        }
    }
    System.out.println("No se encontro ninguna orden con el serial: " + serial);
        
        
        
    }
   private void verificarDia() {
    LocalDate hoy = LocalDate.now();
    if (!hoy.equals(fechaUltimoRegistro)) {
        ordenesHoy = 0;
        fechaUltimoRegistro = hoy;
    }
}
}

