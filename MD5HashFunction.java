import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5HashFunction implements HashFunction {

    @Override
    public String calcularHash(String dato) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(dato.getBytes());
            
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            // Manejar la excepción de manera adecuada
            e.printStackTrace();
            throw new RuntimeException("No se pudo calcular el hash MD5", e);
        }
    }
}
