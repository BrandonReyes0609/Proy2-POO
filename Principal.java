import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        ManejoDatos listadoPacientes = new ManejoDatos();
        Scanner teclado = new Scanner(System.in);
        Archivo miArchivo = new Archivo();
        System.out.println("Bienvenido al programa");
        String menu = "\n--------------------------------------------------------\n| Seleccione alguna de las siguientes opciones:        |\n| (1) Ingreso nuevo paciente                           |\n| (2) Ver datos paciente                               |\n| (3) Recomendaciones paciente                         |\n| (4) Estadistica                                      |\n| (5) Guardar y Salir                                  |\n| (6) Leer Archivo                                     |\n--------------------------------------------------------\nOpcion a elegir: ";
        System.out.println(menu);
        int op = teclado.nextInt();
        teclado.nextLine(); 
        while(op != 5){
            switch(op){
                case 1:{
                    try{
                    System.out.println("\nSelecciono Opcion 1 \n----Ingreso de nuevo paciente----");
                    System.out.println("Ingrese el nombre del paciente: ");
                    String nombre = teclado.nextLine();
                    System.out.println("Ingrese el apellido: ");
                    String apellidos = teclado.nextLine();
                    System.out.println("Ingrese el edad: ");
                    int edad = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese el peso en Kg: ");
                    int peso = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese si realiza ejercicio (si/no): ");
                    String realizaEjercicio = teclado.nextLine();
                    System.out.println("Ingrese el numero de comidas al dia: ");
                    int numComida = teclado.nextInt();
                    System.out.println("Ingrese el sexo o genero (hombre/mujer): ");
                    teclado.nextLine();
                    String sexo = teclado.nextLine();
                    System.out.println("Ingrese la estatura en Metros: ");
                    float estatura = teclado.nextFloat();
                    teclado.nextLine();
                    float datoIMC = peso / (estatura*estatura);
                    
                    listadoPacientes.agregarPacientes(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
                    }
                    catch (Exception e){
                        teclado.next();
                        System.out.println("\nEntrada incorrecta");
                        System.out.println(menu);
                        System.out.println("Ingrese la opción que desea: ");
                        op = teclado.nextInt();
                        teclado.nextLine();
                        }
                    break;
                }
                case 2:{
                    System.out.println("\nSelecciono Opcion 2\n----Ver datos paciente----");
                    System.out.println(listadoPacientes.pacientesFichaMedica());
                    break;
                }
                case 3:{
                    System.out.println("\nSelecciono Opcion 3\n----Recomendaciones paciente----");
                    break;
                }
                case 4:{
                    System.out.println("\nSelecciono Opcion 4\n----Ver estadisticas----");
                    System.out.println(listadoPacientes.estadistica());
                    break;
                }case 5:{
                    op = 5;
                    System.out.println("Guardar y cerrar archivo");
                    listadoPacientes.getPacientes();

                    ArrayList<String> lineas = miArchivo.leerArchivo();
                    for (String linea : lineas) {
                        System.out.println(linea);
                    }
                    miArchivo.leerArchivoString();
                    
                    break;
                }case 6:{
                    System.out.println("Leer datos paciente");
                    listadoPacientes.getPacientes();
                }

                    
            }
            System.out.println(menu);
            op = teclado.nextInt();
            teclado.nextLine();
        }
    }
}


//esta es una prueba
