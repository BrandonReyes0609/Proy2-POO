import java.util.Scanner;

public class Principal {
    public static void main(String[] args){

        ManejoDatos listadoPacientes = new ManejoDatos();
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bienvenido al programa");
        System.out.println("Seleccione alguna de las siguientes opciones: \n(1) Ingreso nuevo paciente \n(2) Ver datos paciente \n(3) Recomendaciones paciente \n(4) Estadistica \n (5) Salir");
        int op = teclado.nextInt(); 
        while(op != 5){
            switch(op){
                case 1:{
                    System.out.println("Selecciono Opcion 1 \nIngrso nuevo paciente");
                    System.out.println("Ingrese el nombre del paciente");
                    teclado.next();
                    String  nombre = teclado.nextLine();
                    System.out.println("Ingrese el apellido ");
                    String apellidos = teclado.nextLine(); ;
                    System.out.println("Ingrese la edad");
                    int edad = teclado.nextInt();
                    System.out.println("Ingrese la talla ");
                    int talla = teclado.nextInt();
                    System.out.println("Ingrese el peso en Kg");
                    int peso = teclado.nextInt();
                    teclado.nextLine();
                    System.out.println("Ingrese el realiza ejercicio (si/no)");
                    String realizaEjercicio = teclado.nextLine();
                    System.out.println("Ingrese el numero de comidas al dia");
                    int numComida = teclado.nextInt();
                    System.out.println("Ingrese el el sexo o genero (hombre/mujer/otro)");
                    teclado.nextLine();
                    String sexo = teclado.nextLine();
                    //System.out.println("Ingrese el ");
                    System.out.println("Ingrese la estatura en Metros");
                    float estatura = teclado.nextFloat();
                    System.out.println("Ingrese el ");
                    float datoIMC = peso / (estatura*estatura);
                    
                    listadoPacientes.agregarPaceintes(nombre, apellidos, edad, talla, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
            
                    break;
                }case 2:{
                    System.out.println("Selecciono Opcion 2 \n Ver datos paciente");
                    System.out.println(listadoPacientes.pascientesFichaMedica());

                    break;
                }case 3:{
                    System.out.println("Selecciono Opcion 3 \n Recomendaciones paciente");

                    break;
                }case 4:{
                    System.out.println("Selecciono Opcion 4 \n Ver estadistica");
                    System.out.println(listadoPacientes.estadistica());
                    break;
                }case 5:{
                    op = 5;
                    break;
                }
                
            }
            System.out.println("Seleccione alguna de las siguientes opciones: \n(1) Ingreso nuevo paciente \n(2) Ver datos paciente \n(3) Recomendaciones paciente \n(4) Estadistica \n (5) Salir");
            op = teclado.nextInt();
            
        }
    }
}
