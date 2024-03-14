public interface MapFactory {
    Map<String, Estudiante> crearMapa(TipoMapa tipo);

    enum TipoMapa {
        HASHMAP,
        TREEMAP,
        LINKEDHASHMAP
    }
}