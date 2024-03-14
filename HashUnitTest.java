public class HashUnitTest {

    public static void main(String[] args) {
        testOrganicHashFunction();
        testMD5HashFunction();
    }

    public static void testOrganicHashFunction() {
        HashFunction hashFunction = new OrganicHashFunction();
        String data = "Hello, world!";
        String hashedData = hashFunction.hash(data);
        if (data.equals(hashedData)) {
            System.out.println("OrganicHashFunction funciona.");
        } else {
            System.out.println("OrganicHashFunction no funciona.");
        }
    }

    public static void testMD5HashFunction() {
        HashFunction hashFunction = new MD5HashFunction();
        String data = "Hello, world!";
        String expectedHash = "65a8e27d8879283831b664bd8b7f0ad4";
        String hashedData = hashFunction.hash(data);
        if (expectedHash.equals(hashedData)) {
            System.out.println("MD5HashFunction funciona.");
        } else {
            System.out.println("MD5HashFunction no funciona.");
        }
    }
}
