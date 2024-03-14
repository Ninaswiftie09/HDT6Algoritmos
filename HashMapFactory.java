

public class HashMapFactory implements MapFactory {
    
    @Override
    public Map<String, Estudiante> crearMapa(TipoMapa tipo) {
        if (tipo == TipoMapa.HASHMAP) {
            return new HashMap<>();
            
        }
        return null;
    }
    
}
