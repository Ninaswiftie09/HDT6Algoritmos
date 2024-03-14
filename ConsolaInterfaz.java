import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class ConsolaInterfaz {

    private Map<String, Estudiante> mapa;

    public ConsolaInterfaz(Map<String, Estudiante> mapa) {
        this.mapa = mapa;
    }

    public void iniciar() {
        cargarDatosDesdeArchivo(); // Cargar datos previo a la búsqueda
        Scanner scanner = new Scanner(System.in);
        boolean ejecutando = true;
        while (ejecutando) {
            System.out.println("\nMenú:");
            System.out.println("1. Buscar estudiante por postalZip");
            System.out.println("2. Buscar estudiantes por nacionalidad");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir nueva línea después de nextInt()
            switch (opcion) {
                case 1:
                    buscarPorPostalZip(scanner);
                    break;
                case 2:
                    buscarPorNacionalidad(scanner);
                    break;
                case 3:
                    ejecutando = false;
                    break;
                default:
                    System.out.println("Opción inválida. Inténtelo de nuevo.");
            }
        }
        scanner.close();
    }

    private void cargarDatosDesdeArchivo() {
        try {
            FileReader reader = new FileReader("estudiantes.json.json");
            // Aquí debes implementar la lógica para leer los datos del archivo JSON y agregarlos al mapa
            // Ejemplo:
            // mapa = LectorArchivo.leerArchivo(reader);
            reader.close();
            System.out.println("Datos cargados desde el archivo estudiantes.json.json");
        } catch (IOException e) {
            System.out.println("Error al cargar los datos desde el archivo estudiantes.json.json: " + e.getMessage());
        }
    }

    private void buscarPorPostalZip(Scanner scanner) {
        System.out.print("Ingrese el postalZip a buscar: ");
        String postalZip = scanner.nextLine();
        Estudiante estudiante = buscarEstudiantePorPostalZip(mapa, postalZip);
        if (estudiante != null) {
            System.out.println("Estudiante encontrado: " + estudiante);
        } else {
            System.out.println("No se encontró ningún estudiante con el postalZip especificado.");
        }
    }

    private void buscarPorNacionalidad(Scanner scanner) {
        System.out.print("Ingrese la nacionalidad a buscar: ");
        String nacionalidad = scanner.nextLine();
        List<Estudiante> estudiantes = buscarEstudiantesPorNacionalidad(mapa, nacionalidad);
        if (!estudiantes.isEmpty()) {
            System.out.println("Estudiantes encontrados:");
            for (Estudiante estudiante : estudiantes) {
                System.out.println(estudiante);
            }
        } else {
            System.out.println("No se encontraron estudiantes con la nacionalidad especificada.");
        }
    }

    private Estudiante buscarEstudiantePorPostalZip(Map<String, Estudiante> mapa, String postalZip) {
        for (Estudiante estudiante : mapa.values()) {
            if (estudiante.getPostalZip().equals(postalZip)) {
                return estudiante;
            }
        }
        return null;
    }

    private List<Estudiante> buscarEstudiantesPorNacionalidad(Map<String, Estudiante> mapa, String nacionalidad) {
        // Implementa la lógica de búsqueda de estudiantes por nacionalidad aquí
        // Retorna una lista de estudiantes que coinciden con la nacionalidad
        // Si no se encuentra ningún estudiante, retorna una lista vacía
        return null; //
    }

    public static void main(String[] args) {
        
        Map<String, Estudiante> mapaEstudiantes = obtenerMapaDeEstudiantes();
        ConsolaInterfaz interfaz = new ConsolaInterfaz(mapaEstudiantes);
        interfaz.iniciar();
    }
}
