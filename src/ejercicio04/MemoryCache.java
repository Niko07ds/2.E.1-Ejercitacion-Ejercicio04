package ejercicio04;

import java.util.HashMap;
import java.util.Map;

public class MemoryCache {

    // Instancia única de la caché
    private static MemoryCache instance;

    // Almacena los datos de la caché de forma privada
    private final Map<String, String> cache;

    // Constructor privado para impedir otras instancias
    private MemoryCache() {
        cache = new HashMap<>();
        System.out.println("Caché en memoria inicializada.");
    }

    // Devuelve la instancia única y la crea solo cuando es necesario
    public static synchronized MemoryCache getInstance() {
        if (instance == null) {
            instance = new MemoryCache();
        }

        return instance;
    }

    // Almacena un elemento o actualiza su valor si la clave ya existe
    public synchronized void put(String key, String value) {
        if (key == null || key.isBlank()) {
            throw new IllegalArgumentException(
                    "La clave no puede estar vacía."
            );
        }

        if (value == null) {
            throw new IllegalArgumentException(
                    "El valor no puede ser nulo."
            );
        }

        if (cache.containsKey(key)) {
            System.out.println("Actualizando elemento: " + key);
        } else {
            System.out.println("Almacenando elemento: " + key);
        }

        cache.put(key, value);
    }

    // Recupera un elemento mediante su clave
    public synchronized String get(String key) {
        if (!cache.containsKey(key)) {
            System.out.println("No existe un elemento con la clave: " + key);
            return null;
        }

        return cache.get(key);
    }

    // Comprueba si una clave existe en la caché
    public synchronized boolean containsKey(String key) {
        return cache.containsKey(key);
    }

    // Elimina un elemento mediante su clave
    public synchronized void remove(String key) {
        if (cache.containsKey(key)) {
            cache.remove(key);
            System.out.println("Elemento eliminado: " + key);
        } else {
            System.out.println("No existe un elemento con la clave: " + key);
        }
    }

    // Devuelve la cantidad de elementos almacenados
    public synchronized int size() {
        return cache.size();
    }
}
