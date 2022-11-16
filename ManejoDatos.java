import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class ManejoDatos{
    private ArrayList<FichaMedica> pacientes;
    private ArrayList<String> listadoDatos;
    private ArrayList<String> list1;

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
        String cadenaEscrbribir = nombre+","+Integer.toString(edad)+","+Double.toString(peso)+","+realizaEjercicio+","+Integer.toString(numComida)+","+sexo+","+Double.toString(datoIMC)+","+Double.toString(estatura)+"\n";

        System.out.println(cadenaEscrbribir);
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
            estadisticas = estadisticas + "\nIMC Promedio para 'Hombres': " + promedioimch + "\nIMC Promedio para 'Mujeres': " + promedioimcm + "\nIMC Promedio para 'Otro': " + promedioimco + "\n";
            estadisticas = estadisticas + "\nTotal de fichas medicas registradas:\n'Hombres: "+ ih +"'Mujeres': "+ im + "'Otro': "+ io + "'Total': " + i;
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
        //System.out.println(miArchivo.leerArchivoString());
        //<ArrayList> listado = miArchivo.leerArchivoString();
        String listadoA =  miArchivo.leerArchivoString();
        //listadoDatos = Arrays.asList(listadoA.split("\\s+"));
        this.list1 = new ArrayList<String>(Arrays.asList(listadoA.split(",")));
        System.out.println(list1);

        int i = 0;
        System.out.println(list1.size());

        while(i < list1.size()){
            System.out.println(list1.get(i));
            //System.out.println((i));
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

    
}
