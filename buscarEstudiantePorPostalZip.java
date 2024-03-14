public Estudiante buscarEstudiantePorPostalZip(Map<String, Estudiante> mapa, String postalZip) {
    for (Estudiante estudiante : mapa.values()) {
        if (estudiante.getPostalZip().equals(postalZip)) {
            return estudiante;
        }
    }
    return null; // Retorna null si no se encuentra ningún estudiante con el postalZip especificado
}
