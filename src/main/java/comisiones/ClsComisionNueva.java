/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comisiones;

import java.util.*;
import modelos.MdVendedor;

/**
 *
 * @author GAMERS
 */
public class ClsComisionNueva {
    List<MdVendedor> todos = new ArrayList<MdVendedor>();
    Scanner t = new Scanner(System.in);
    public void Menu(){
        String opc;
        do{
            System.out.println("Selecciona una opción.");
            System.out.println("1 - Ingrese Informacion");
            System.out.println("2 - Desplegar Datos");
            System.out.println("3 - Consultar Ventas");
            System.out.println("4 - Buscar Cantidad");
            System.out.println("5 - Salir");
            
            System.out.println("Selecciona una opción: ");
            opc=t.nextLine();
            switch(opc){
                case "1": 
                    IngresarInformacion();
                    break;
                case "2": 
                    ImprimirDatos();
                    break;
                case "3": 
                    ConsultaVentasMes();
                    break;
                case "4": 
                    BuscarCantidad();
                    break;
                case "5": 
                    break;
            }
        }while(!opc.equals("4"));
    }
    
    private void IngresarInformacion(){
        MdVendedor vendedor = new MdVendedor();
        Scanner t= new Scanner(System.in);
        
        System.out.println("Ingrese Nombre: ");
        vendedor.nombre=t.nextLine();
        
        System.out.println("Ingrese Enero: ");
        vendedor.enero=t.nextDouble();
        
        System.out.println("Ingrese Febrero: ");
        vendedor.febrero=t.nextDouble();
        
        System.out.println("Ingrese Marzo: ");
        vendedor.marzo=t.nextDouble();
        
        vendedor.total=vendedor.enero+vendedor.febrero+vendedor.marzo;
        vendedor.promedio=vendedor.total/3;
        
        todos.add(vendedor);
        
    }
    
    private void ConsultaVentasMes(){
        
        String mes;
        do{
            System.out.println("Selecciona el tipo de ventas que deseas consultar");
            System.out.println("1 - Enero");
            System.out.println("2 - Febrero");
            System.out.println("3 - Marzo");
            System.out.println("4 - De los 3 meses");
            System.out.println("5 - Regresar al menu anterior");
            
            System.out.println("Selecciona una opción: ");
            mes=t.nextLine();
            System.out.println("********************************");
            switch(mes){
                case "1": 
                    Collections.sort(todos, new OrdenarEnero());
                    System.out.println("El que vendio menos en enero fue: ");
                    ImprimirFila(todos.get(0));
                    System.out.println("El que vendio más en enero fue: ");
                    ImprimirFila(todos.get(todos.size()-1));
                    break;
                case "2": 
                    Collections.sort(todos, new OrdenarFebrero());
                    System.out.println("El que vendio menos en febrero fue: ");
                    ImprimirFila(todos.get(0));
                    System.out.println("El que vendio más en febrero fue: ");
                    ImprimirFila(todos.get(todos.size()-1));
                    break;
                case "3": 
                    Collections.sort(todos, new OrdenarMarzo());
                    System.out.println("El que vendio menos en enero fue: ");
                    ImprimirFila(todos.get(0));
                    System.out.println("El que vendio más en enero fue: ");
                    ImprimirFila(todos.get(todos.size()-1));
                    break;
                case "4": 
                    Collections.sort(todos, new OrdenarTotal());
                    System.out.println("El que vendio menos en los 3 meses fue: ");
                    ImprimirFila(todos.get(0));
                    System.out.println("El que vendio más en los 3 meses fue fue: ");
                    ImprimirFila(todos.get(todos.size()-1));
                    break;
                case "5": 
                    break; 
            }
            System.out.println("********************************");
        }while(!mes.equals("5"));
    }
    private void BuscarCantidad(){
        System.out.println("Ingresa la cantidad a buscar: ");
        String cantidad = t.nextLine();
        for(MdVendedor e: todos){
            if(e.enero.equals(cantidad) && e.febrero.equals(cantidad) && e.marzo.equals(cantidad)){
                ImprimirFila(e);
            }else{
                ////NO HAY CANTIDAD EN LA FILA
            }
        }
    }
    private void ImprimirDatos(){
        for(MdVendedor e: todos){
            ImprimirFila(e);
        }
    }
    private void ImprimirFila(MdVendedor vendedor){
        System.out.println(vendedor.nombre+"  "+vendedor.enero+"  "+vendedor.febrero+"  "+vendedor.marzo+"  "+vendedor.total+"  "+vendedor.promedio);
    }
}
class OrdenarEnero implements Comparator<MdVendedor>
{
    public int compare(MdVendedor a, MdVendedor b)
    {
        return a.enero.compareTo(b.enero);
    }
}
class OrdenarFebrero implements Comparator<MdVendedor>
{
    public int compare(MdVendedor a, MdVendedor b)
    {
        return a.febrero.compareTo(b.febrero);
    }
}
class OrdenarMarzo implements Comparator<MdVendedor>
{
    public int compare(MdVendedor a, MdVendedor b)
    {
        return a.marzo.compareTo(b.marzo);
    }
}
class OrdenarTotal implements Comparator<MdVendedor>
{
    public int compare(MdVendedor a, MdVendedor b)
    {
        return a.total.compareTo(b.total);
    }
}
class OrdenarPromedio implements Comparator<MdVendedor>
{
    public int compare(MdVendedor a, MdVendedor b)
    {
        return a.promedio.compareTo(b.promedio);
    }
}