import java.lang.reflect.Array;
import java.security.cert.X509CRL;
import java.util.ArrayList;
import java.util.Arrays;
/*
 * Audrey Samantha Bhor López - 22545
    Brandon Javier Reyes Morales - 22992
    Wilson Alejandro Calderón A. - 22018
    Jose Angel Morales Farfan - 22689

 */
public class ManejoDatos{
    private ArrayList<FichaMedica> pacientes;
    private ArrayList<String> listadoDatos;
    private ArrayList<String> list1;
    private ArrayList<String> list2;
    private String cadenaEscrbribir = "";

    Archivo miArchivo = new Archivo("./stadoPaciente.csv");

    public ManejoDatos(){
        pacientes = new ArrayList<FichaMedica>();
        listadoDatos = new ArrayList<String>();
        
        
    }
    
    /** 
     * @param nombre
     * @param apellidos
     * @param edad
     * @param peso
     * @param realizaEjercicio
     * @param numComida
     * @param sexo
     * @param datoIMC
     * @param estatura;
     */
    public void agregarPacientes(String nombre,String apellidos,int edad,double peso,String realizaEjercicio,int numComida,String sexo,double datoIMC,double estatura){
        FichaMedica nuevFichaMedica = new FichaMedica(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
        this.pacientes.add(nuevFichaMedica);
        //Integer.toString(edad)
        cadenaEscrbribir = cadenaEscrbribir + nombre+","+apellidos+","+Integer.toString(edad)+","+Double.toString(peso)+","+realizaEjercicio+","+Integer.toString(numComida)+","+sexo+","+Double.toString(datoIMC)+","+Double.toString(estatura)+"\n";
        System.out.println("Se guardaron datos");
        //System.out.println(cadenaEscrbribir);
        // aqui podemos mandar los datos para guardar
        //miArchivo.escribirArchivo("nombre,edad,color,genero,raza\nlaika,8,negro,hembra,labrador\nlisa,0,manto negro,hembra,pastor alemán\n");
        miArchivo.escribirArchivo(cadenaEscrbribir);

        //miArchivo.escribirArchivo("nombre,edad,color,genero,raza\nlaika,8,negro,hembra,labrador\nlisa,0,manto negro,hembra,pastor alemán\n");

    }

    
    /** 
     * @return ArrayList<FichaMedica>
     */
    public ArrayList<FichaMedica> getPacientes() {
        return this.pacientes;
    }

    
    /** 
     * @param pacientes
     */
    public void setPacientes(ArrayList<FichaMedica> pacientes) {
        this.pacientes = pacientes;
    }


    
    /** 
     * @return String
     */
    @Override
    public String toString() {
        return "{" +
            " pacientes='" + getPacientes() + "'" +
            "}";
    }


    public ArrayList<FichaMedica> enviarPacientes() {
        return this.pacientes;
    }

    public String pacientesFichaMedica(){
        int i = 0; 
        String resultados = "";
        if(pacientes.size()>0){
            while (i<pacientes.size()){
                resultados = resultados + "\n------ Paciente " + i + " ------\n";
                resultados = resultados + ""+ pacientes.get(i).getNombre()+" "+pacientes.get(i).getApellidos()+"\n";
                resultados = resultados + "Edad: "+ pacientes.get(i).getEdad()+"\n";
                resultados = resultados + "Peso: "+ pacientes.get(i).getPeso()+"\n";
                resultados = resultados + "Realiza Ejercicio: "+ pacientes.get(i).getRealizaEjercicio()+"\n";
                resultados = resultados + "Sexo o Genero: "+ pacientes.get(i).getSexo() +"\n";
                resultados = resultados + "Numero de Comida: "+ pacientes.get(i).getNumComida()+"\n";
                resultados = resultados + "Dato IMC: "+ pacientes.get(i).getDatoIMC()+"\n";
                resultados = resultados + "Estatura: "+ pacientes.get(i).getEstatura()+"\n";

                resultados = resultados + "-----------------------------\n";
                i++;
            }
        }
        else {
            resultados = "\nNo hay pacientes para mostrar.";
        }  
        return resultados;
    }

    public String estadistica(){
        String estadisticas = "";
        if(pacientes.size()>0){
            estadisticas = "Estadisticas de los datos recolectados\n--------------------------------------------------------\n";
            double sumaimc = 0;
            int i = 0;
            for (FichaMedica ficha : pacientes){
                sumaimc = sumaimc + ficha.getDatoIMC();
                i++;
            }
            double promedioimc = sumaimc/i;
            estadisticas = "IMC Promedio: "+promedioimc;
            double sumaimch = 0;
            double sumaimcm = 0;
            double sumaimco = 0;
            int ih = 0;
            int im = 0;
            int io = 0;
            for (FichaMedica ficha : pacientes){
                if(ficha.getSexo().equals("hombre") || ficha.getSexo().equals("Hombre")){
                    sumaimch = sumaimch + ficha.getDatoIMC();
                    ih++;
                }
                if(ficha.getSexo().equals("mujer") || ficha.getSexo().equals("Mujer")){
                    sumaimcm = sumaimcm + ficha.getDatoIMC();
                    im++;
                }
                if(ficha.getSexo().equals("otro") || ficha.getSexo().equals("Otro")){
                    sumaimco = sumaimco + ficha.getDatoIMC();
                    io++;
                    }
            }
            double promedioimch = sumaimc/ih;
            double promedioimcm = sumaimc/im;
            double promedioimco = sumaimc/io;
            estadisticas = estadisticas + "\nIMC Promedio para 'Hombres': " + promedioimch + "\nIMC Promedio para 'Mujeres': " + promedioimcm + "\n";
            estadisticas = estadisticas + "\nTotal de fichas medicas registradas:\n'Hombres: "+ ih +"'Mujeres': "+ im + "'Total': " + i;
        }
        else {
            estadisticas = "No hay pacientes de los cuales sacar estadisticas.";
        }
        return estadisticas;
    }

    public String recomendacionesString(){
        /*
         * Docuemntación de apoyo
         * https://www.cdc.gov/healthyweight/spanish/assessing/bmi/adult_bmi/metric_bmi_calculator/bmi_calculator.html
         */
        int i = 0;
        String resultados = "";
        if(pacientes.size()>0){
            while (i<pacientes.size()){
                resultados = resultados + "\n------ Paciente " + i + " ------\n";
                resultados = resultados + ""+ pacientes.get(i).getNombre()+" "+pacientes.get(i).getApellidos()+"\n";
                resultados = resultados + "Edad: "+ pacientes.get(i).getEdad()+"\n";
                resultados = resultados + "Peso: "+ pacientes.get(i).getPeso()+"\n";
                resultados = resultados + "Realiza Ejercicio: "+ pacientes.get(i).getRealizaEjercicio()+"\n";
                resultados = resultados + "Sexo o Genero: "+ pacientes.get(i).getSexo() +"\n";
                resultados = resultados + "Numero de Comida: "+ pacientes.get(i).getNumComida()+"\n";
                resultados = resultados + "Dato IMC: "+ pacientes.get(i).getDatoIMC()+"\n";
                resultados = resultados + "Estatura: "+ pacientes.get(i).getEstatura()+"\n";

                resultados = resultados + "-----------------------------\n";
                i++;

            }
        }
        else {
            resultados = "\nNo hay pacientes para mostrar.";
        }        
        return resultados;

    }

    
    public void LeerDatosNuevos(){
        cadenaEscrbribir = "";

        //System.out.println(miArchivo.leerArchivoString());
        //<ArrayList> listado = miArchivo.leerArchivoString();
        String listadoA =  miArchivo.leerArchivoString();
        //listadoDatos = Arrays.asList(listadoA.split("\\s+"));
        this.list1 = new ArrayList<String>(Arrays.asList(listadoA.split("\n")));
        System.out.println(list1);

        int i = 0;
        
        System.out.println(list1.size());

        while(i < list1.size()){

            String nombre1 = "";
            String apellidos1 = "";
            int edad1 = 0;
            double peso1 = 0.0;
            String realizaEjercicio1 = "";
            int numComida1 = 0;
            String sexo1 = "";
            double datoIMC1 = 0.0;
            double estaturaCM1 = 0.0;

            //System.out.println(list1.get(i));
            //Recibir dator
            //System.out.println((i));
            String datoRecibido = list1.get(i);
            int x = 0;
            this.list2 = new ArrayList<String>(Arrays.asList(datoRecibido.split(",")));
            while(x < list2.size()){
                String datoRecibido2 = list2.get(x);
                System.out.println(datoRecibido2);

                switch(x){
                    case 0:{
                        nombre1 = datoRecibido2;
                        break;
                    }
                    case 1:{
                        apellidos1 = datoRecibido2;
                        break;
                    }
                    case 2:{
                        edad1  =   Integer.valueOf(datoRecibido2); 
                        break;
                    }
                    case 3:{
                        peso1 = Double.valueOf(datoRecibido2);
                        break;
                    }
                    case 4:{
                        realizaEjercicio1 = datoRecibido2;
                        break;
                    }
                    case 5:{
                        numComida1 = Integer.parseInt(datoRecibido2);
                        break;
                    }
                    case 6:{
                        sexo1 = String.valueOf(datoRecibido2);
                        break;
                    }
                    case 7:{
                        datoIMC1 = Double.parseDouble(datoRecibido2);
                        break;
                    }
                    case 8:{
                        estaturaCM1 =  Double.parseDouble(datoRecibido2);
                    }
                    System.out.println("x: "+x);
                }

                x++;
            }
            agregarPacientes(nombre1, apellidos1, edad1, peso1, realizaEjercicio1, numComida1, sexo1, datoIMC1, estaturaCM1);

            System.out.println("i: "+i);

            i++;
        }

        //String stringDatos = miArchivo.leerArchivoString();//.split("\\s+");

        //System.out.println("stringDatos: "+stringDatos);
        //FichaMedica nuevFichaMedica = new FichaMedica(nombre, apellidos, edad, peso, realizaEjercicio, numComida, sexo, datoIMC, estatura);
        //System.out.println((miArchivo.leerArchivo()).getClass().getSimpleName());
        
        
    }

    public ArrayList<String> getListadoPersonas() {
        return this.list1;
    }

    public ArrayList<String> getListadoPersona2() {
        return this.list2;
    }
}
