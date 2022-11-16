//actualizado el 07/11/2022
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Integer;

public class Principal {
    public static void main(String[] args){
        //Archivo miArchivo = new Archivo("./lstadoPaciente.csv");

        ManejoDatos listadoPacientes = new ManejoDatos();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa");
        //String menu = "Seleccione alguna de las siguientes opciones: \n(1) Ingreso nuevo paciente \n(2) Ver datos paciente \n(3) Recomendaciones paciente \n(4) Estadistica \n (5) Guardar y Salir \n (6) Leer Archivo";
        String menu = "\n--------------------------------------------------------\n| Seleccione alguna de las siguientes opciones:        |\n| (1) Ingreso nuevo paciente                           |\n| (2) Ver datos paciente                               |\n| (3) Recomendaciones paciente                         |\n| (4) Estadistica                                      |\n| (5) Guardar y Salir                                  |\n| (6) Leer Archivo                                     |\n--------------------------------------------------------\nOpcion a elegir: ";
        System.out.println(menu);
        int op = teclado.nextInt();
        teclado.nextLine();
        while(op != 5){
            switch(op){
                case 1:{
                    try{
                        System.out.println("Selecciono Opcion 1 \n----Ingreso de nuevo paciente----");
                        System.out.println("Ingrese el nombre del paciente: ");
                        String nombre = teclado.nextLine();
                        System.out.println("Ingrese el apellido: ");
                        String apellidos = teclado.nextLine(); ;
                        System.out.println("Ingrese el edad: ");
                        int edad = teclado.nextInt();
                        teclado.nextLine();
                        System.out.println("Ingrese el peso en Lb: ");
                        double peso = teclado.nextDouble();
                        teclado.nextLine();
                        System.out.println("Ingrese si realiza ejercicio \n (1) Estilo de Vida Sedentario \n (2) Estilo de Vida Ligeramente activo \n (3) Estilo de Vida Activo o Moderadamente activo \n (4) Estilo de Vida Vigoroso: ");
                        String realizaEjercicio = teclado.nextLine();
                        System.out.println("Ingrese el numero de comidas al dia: ");
                        int numComida = teclado.nextInt();
                        System.out.println("Ingrese el sexo o genero (hombre/mujer): ");
                        teclado.nextLine();
                        String sexo = teclado.nextLine();
                        System.out.println("Ingrese la estatura en 'cm': ");
                        double estaturaCM = teclado.nextDouble();
                        double estaturaM = estaturaCM*0.01; 
                        double pesoKG = peso*1/2.20462; 
                        
    
                        teclado.nextLine();
                        
                        double datoIMC = pesoKG / (estaturaM*estaturaM);
                        System.out.println("El IMC es: "+datoIMC);
                        
                        listadoPacientes.agregarPacientes(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estaturaCM);
                        
                    }
                    catch (Exception e){
                        teclado.next();
                        System.out.println("Entrada incorrecta");
                        System.out.println(menu);
                        System.out.println("Ingrese la opción que desea: ");
                        op = teclado.nextInt();
                        teclado.nextLine();
                
                        } 
                    break;
                }
                case 2:{
                    System.out.println("Selecciono Opcion 2\n----Ver datos paciente----");
                    System.out.println(listadoPacientes.pacientesFichaMedica());
                    break;
                }
                case 3:{
                    System.out.println("Selecciono Opcion 3\n----Recomendaciones paciente----");

                    // ver recomndaciones 
                    //Recomendaciones notaMedicaRe = new Recomendaciones();
                    
                    //System.out.println(listadoPacientes.enviarPacientes().getClass().getSimpleName());
                    
                    //System.out.println(listadoPacientes.getPacientes());
                    System.out.println("Ingrese el nombre a buscar");
                    String nombreBuscar = teclado.nextLine();
                    
                    Recomendaciones NotaRDocRecomentacion = new Recomendaciones();
                    //1NotaRDocRecomentacion.AgregarListadoPersonas(listadoPacientes.estadistica());
                   NotaRDocRecomentacion.AgregarListadoPersonas(listadoPacientes.getPacientes(),nombreBuscar);


                    System.out.println("Hola: "+NotaRDocRecomentacion.toString());
                    
                    System.out.println(NotaRDocRecomentacion.CalculadorString());

                    break;
                }
                case 4:{
                    System.out.println("Selecciono Opcion 4\n----Ver estadisticas----");
                    System.out.println(listadoPacientes.estadistica());


                    break;
                }case 5:{
                    op = 5;
                    System.out.println("Guardar y cerrar archivo");

                    break;
                }case 6:{
                    System.out.println("Leer datos pasiente");
                    listadoPacientes.getPacientes();
                    listadoPacientes.LeerDatosNuevos();
                    listadoPacientes.getListadoPersonas();

                    //listadoPacientes.setPacientes();
                    //listadoPacientes.agregarPacientes(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estaturaCM);



                }

                    
            }
            System.out.println(menu);
            op = teclado.nextInt();
            teclado.nextLine();
        }
    }
}