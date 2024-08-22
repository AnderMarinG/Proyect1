import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

/**
 * La clase Coleccion representa una colección de personas y proporciona métodos para gestionar y analizar datos de la encuesta.
 * 
 *@param personas ArrayList de personas
 *
 * @author Mariana Carrasquilla
 * @author Jhon Anderson Marin
 * @version 1.1
 * 
 * Se modificó el método escribir, para que sólo pusiera una persona a la vez, y no tuviera que escribir todo
 * el array dentro del archivo de texto
 * 
 * Se modifico el método buscarPersonas, para que lo encontrara independientemente de las mayusculas o minusculas
 */
public class Coleccion
{

    private ArrayList<Persona> personas;

    /**
     * Constructor de la clase Coleccion que inicializa la lista de personas.
     */
    public Coleccion()    {
        personas = new ArrayList<>();
    }

    /**
     * Agrega una persona a la colección.
     * 
     * @param persona La persona a agregar a la colección.
     */
    public void agregarPersona(Persona persona) {
        personas.add(persona);
    }

    /**
     * Lee los datos de un archivo de texto y crea objetos Persona con esa información, separando las respuestas con espacios.
     */
    public void leerDatos() {
        personas.clear();
        try (Scanner sc = new Scanner(new FileReader("encuesta.txt"))) {
            while (sc.hasNextLine()) {
                String linea = sc.nextLine();
                String[] partes = linea.split(" ");
                String nombre = partes[0];
                int[] resp = new int[5];
                for (int i = 1; i < partes.length; i++) {
                    resp[i-1]= Integer.parseInt(partes[i]);
                }
                personas.add(new Persona(nombre, resp));
            }

        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado ");
        }
    }

    /**
     * Escribe una persona en el archibo de texto
     * 
     */
    public void escribirDatos(Persona persona) {
        try { 
            FileWriter escribir = new FileWriter("encuesta.txt", true);
            escribir.write('\n' + persona.toString());
            escribir.close();
        } catch (IOException e){
            System.out.println("Archivo no encontrado");
        }

    }
    
    /**
     * Calcula la afinidad entre dos personas basado en sus respuestas.
     * 
     * @param p1 La primera persona.
     * @param p2 La segunda persona.
     * @return La afinidad entre las dos personas.
     */
    public double match(Persona p1, Persona p2){
        int[] arrP1 = p1.getRespuestas();
        int[] arrP2 = p2.getRespuestas();
        double sumatoriaMultiplicacion = 0;
        int pitagorasP1 = 0;
        int pitagorasP2 = 0;
        for(int i = 0; i < arrP1.length; i++){
            sumatoriaMultiplicacion = sumatoriaMultiplicacion + arrP1[i] * arrP2[i];
            pitagorasP1 = pitagorasP1 + arrP1[i] * arrP1[i];
            pitagorasP2 = pitagorasP2 + arrP2[i] * arrP2[i];
        }
        double resultado = sumatoriaMultiplicacion / (Math.sqrt(pitagorasP1) * Math.sqrt(pitagorasP2));
        return resultado;
    }

    /**
     * Busca una persona en la colección por su nombre.
     * 
     * @param nombre El nombre de la persona a buscar.
     * @return La posición de la persona en la colección, o -1 si no se encuentra.
     *  Sin importar mayuscula o minusculas
     */
    public int buscarPersona(String nombre){
        int encontrado = -1;
        for(int i = 0; i < personas.size(); i++){
            Persona personaPosi = personas.get(i);
            if((personaPosi.getNombre().toLowerCase()).equals(nombre.toLowerCase())){
                return i;
            }
        }
        return encontrado;
    }

    /**
     * Obtiene la lista de personas en la colección.
     * 
     * @return La lista de personas en la colección.
     */
    public ArrayList<Persona> getPersonas(){
        return this.personas;
    }
}