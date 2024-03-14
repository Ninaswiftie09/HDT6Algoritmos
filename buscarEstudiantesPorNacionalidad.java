import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public List<Estudiante> buscarEstudiantesPorNacionalidad(Map<String, Estudiante> mapa, String country) {
    List<Estudiante> estudiantesEncontrados = new ArrayList<>();
    for (Estudiante estudiante : mapa.values()) {
        if (estudiante.getNacionalidad().equalsIgnoreCase(country)) {
            estudiantesEncontrados.add(estudiante);
        }
    }
    return estudiantesEncontrados;
}
