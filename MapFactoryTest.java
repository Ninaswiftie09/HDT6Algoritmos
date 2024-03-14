import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Map;

import org.junit.Test;

public class MapFactoryTest {

    @Test
    public void testCrearHashMap() {
        MapFactory factory = new HashMapFactory();
        Map<String, Estudiante> mapa = factory.crearMapa(MapFactory.TipoMapa.HASHMAP);
        assertNotNull(mapa);
        assertEquals(HashMap.class, mapa.getClass());
    }

    @Test
    public void testCrearTreeMap() {
        MapFactory factory = new TreeMapFactory();
        Map<String, Estudiante> mapa = factory.crearMapa(MapFactory.TipoMapa.TREEMAP);
        assertNotNull(mapa);
        assertEquals(TreeMap.class, mapa.getClass());
    }

    @Test
    public void testCrearLinkedHashMap() {
        MapFactory factory = new LinkedHashMapFactory();
        Map<String, Estudiante> mapa = factory.crearMapa(MapFactory.TipoMapa.LINKEDHASHMAP);
        assertNotNull(mapa);
        assertEquals(LinkedHashMap.class, mapa.getClass());
    }
}
