import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LectorArchivo {
    private static final String DEFAULT_FILE_NAME = "estudiantes.json";

    public static List<Estudiante> leerEstudiantes() {
        return leerEstudiantes(DEFAULT_FILE_NAME);
    }

    public static List<Estudiante> leerEstudiantes(String nombreArchivo) {
        List<Estudiante> estudiantes = new ArrayList<>();
        JSONParser parser = new JSONParser();

        try (FileReader reader = new FileReader(nombreArchivo)) {
            JSONArray estudiantesJSON = (JSONArray) parser.parse(reader);

            for (Object obj : estudiantesJSON) {
                JSONObject estudianteJSON = (JSONObject) obj;
                String name = (String) estudianteJSON.get("name");
                String phone = (String) estudianteJSON.get("phone");
                String email = (String) estudianteJSON.get("email");
                String postalZip = (String) estudianteJSON.get("postalZip");
                String country = (String) estudianteJSON.get("country");

                Estudiante estudiante = new Estudiante(name, phone, email, postalZip, country);
                estudiantes.add(estudiante);
            }
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return estudiantes;
    }
}
