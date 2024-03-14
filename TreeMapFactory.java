public class TreeMapFactory implements MapFactory {
    @Override
    public Map<String, Estudiante> crearMapa(TipoMapa tipo) {
        if (tipo == TipoMapa.TREEMAP) {
            return new TreeMap<>();
        }
        return null;
    }
}
