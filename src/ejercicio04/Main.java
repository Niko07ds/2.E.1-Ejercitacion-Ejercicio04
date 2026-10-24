package ejercicio04;

public class Main {

    public static void main(String[] args) {

        // Obtenemos la instancia única de la caché
        MemoryCache cache1 = MemoryCache.getInstance();

        // Almacenamos perfiles de usuarios
        cache1.put("usuario.101", "Ana - ana@email.com");
        cache1.put("usuario.102", "Carlos - carlos@email.com");

        // Recuperamos un perfil
        System.out.println("Perfil recuperado: " +
                cache1.get("usuario.101"));

        // Verificamos si una clave existe
        System.out.println("¿Existe usuario.101? " +
                cache1.containsKey("usuario.101"));

        // Actualizamos un perfil existente
        cache1.put("usuario.101", "Ana - ana.nuevo@email.com");

        // Comprobamos el valor actualizado
        System.out.println("Perfil actualizado: " +
                cache1.get("usuario.101"));

        // Obtenemos nuevamente la instancia
        MemoryCache cache2 = MemoryCache.getInstance();

        // Comprobamos que ambas referencias usan la misma caché
        System.out.println("¿Es la misma caché? " +
                (cache1 == cache2));

        // Recuperamos el perfil desde la segunda referencia
        System.out.println("Perfil desde cache2: " +
                cache2.get("usuario.102"));

        // Eliminamos un perfil
        cache2.remove("usuario.102");

        // Comprobamos el estado final
        System.out.println("¿Existe usuario.102? " +
                cache1.containsKey("usuario.102"));

        System.out.println("Cantidad de elementos: " +
                cache1.size());
    }
}
