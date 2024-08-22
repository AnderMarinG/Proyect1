import java.util.Scanner;
/**
*Clase principal, donde se ejecutará el código y se dará la interacción con el usuario.
*
* @author Mariana Carrasquilla
* @author Jhon Anderson Marin
* @version 1.1
* Se modifico el main correspondientemente al cambio de la clase colección
* Ahora lee los datos de manera predeterminada
* Aún se usa la opción A, pero se especifica en qué caso
*/
public class Main {
    /**
     * El método main es el punto de entrada del programa donde se manejará el menú y las interacciones del usuario con cada opción.
     * 
     * @param args Arreglo de String 
     */
    public static void main(String[] args) {
        Coleccion coleccion = new Coleccion();
        Scanner scanner = new Scanner(System.in);
        char opcion;

        coleccion.leerDatos();
        do {
            mostrarMenu();
            opcion = scanner.next().charAt(0);
            switch (opcion) {
                case 'A':
                    coleccion.leerDatos();
                    System.out.println("Los datos de su archivo se han leído y almacenado correctamente");
                    continue;
                case 'B':
                    System.out.println("ingrese el nombre de la persona a agregar");
                    String nombre = scanner.next();
                    int[] respuestas = new int[5];
                    System.out.println("Ingrese las respuestas a las preguntas (valores entre 0 y 10):");
                    System.out.println("1. ¿Qué tanto te gusta escuchar música?");
                    System.out.println("2. ¿Qué tanto te gusta estudiar?");
                    System.out.println("3. ¿Qué tanto te gusta dibujar?");
                    System.out.println("4. ¿Qué tanto te gusta ejercitarte?");
                    System.out.println("5. ¿Qué tanto te gusta dormir?");
                    for(int i=0; i<respuestas.length; i++){
                        System.out.println("respuesta " + (i+1) + ": ");
                        respuestas[i] = scanner.nextInt();
                    }
                    Persona nuevaPersona = new Persona(nombre, respuestas);
                    coleccion.agregarPersona(nuevaPersona);
                    coleccion.escribirDatos(nuevaPersona);
                    System.out.println("Persona agregada correctamente.");
                    continue;
                case 'C':
                    if((coleccion.getPersonas().size() < 2)){
                        System.out.println("No hay suficientes personas para hacer los matches");
                        continue;
                    }
                    coleccionMatches coleccionMatch = new coleccionMatches();
                    System.out.println("Elige la persona con la que se harán los matches (exactamente): ");
                    String elegido = scanner.next();
                    int posElegido = coleccion.buscarPersona(elegido);
                    if(posElegido == -1){
                        System.out.println("Esta persona no está");
                        continue;
                    }
                    for(int i = 0; i < (coleccion.getPersonas()).size(); i++){
                        Persona personai = (coleccion.getPersonas()).get(i);
                        Persona personaElegida = (coleccion.getPersonas()).get(posElegido);
                        if(posElegido != i){
                            double afinidad = coleccion.match(personaElegida, personai);
                            String nombres = personaElegida.getNombre() + " - " + personai.getNombre();
                            Match temp =  new Match(afinidad, nombres, personaElegida.getRespuestas(), personai.getRespuestas());
                            coleccionMatch.agregarMatches(temp);
                        }
                    }
                    coleccionMatch.selectionSortArraylistDescendente();
                    coleccionMatch.imprimirMatches();
                    continue;
                case 'D':
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
          
        } while (opcion != 'D');
        scanner.close();
    }
    /**
    * Este método imprime el menú para mostrarle al usuario las opciones a elegir.
    */
    static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("A. Leer el archivo con los datos (En caso de modificar los datos durante la ejecución) ");
        System.out.println("B. Recibir nueva persona con sus respuestas");
        System.out.println("C. Encontrar la persona más afín");
        System.out.println("D. Terminar");
        System.out.println();
        System.out.print("Ingrese la opción deseada en MAYÚSCULA: ");
    }
}