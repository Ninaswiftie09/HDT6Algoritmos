public class LinkedHashMapFactory implements MapFactory {
    @Override
    public Map<String, Estudiante> crearMapa(TipoMapa tipo) {
        if (tipo == TipoMapa.LINKEDHASHMAP) {
            return new LinkedHashMap<>();
        }
        return null;
    }
}
