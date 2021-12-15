class Libro(val titulo: String, val autor: String, val numpag: Int, calificacion: Byte) {
    var calif: Byte = calificacion
        set(value) {
            if (value in 0..10) field = value
            else throw IndexOutOfBoundsException("La calificación debe estar entre 0 y 10")
        }
    init {
        require(calif in 0..10) { "La calificación debe estar entre 0 y 10" }
    }
    override fun toString(): String {
        return "\"$titulo\", escrito por: \"$autor\""
    }
}

class ConjuntoLibros(tamanio: Int) {
    private val size = tamanio
    var libros = arrayOfNulls<Libro>(size)

    fun añadirLibro(libro: Libro): String {
        return if (libro !in libros) {
            var counter = 0
            while (counter in 0 until size) {
                if (libros[counter] == null) {
                    libros[counter] = libro
                    counter = size
                } else counter++
            }
            "El libro $libro ha sido añadido."
        } else "El libro $libro ya había sido añadido anteriormente."
    }

    fun almacenados(): Int {
        var cantidad = 0
        for (i in 0 until size) {
            if (libros[i] != null) cantidad++
        }
        return cantidad
    }

    fun eliminar(titulo: String): String {
        val cantidadinicial = almacenados()
        var counter = 0
        while (counter in 0 until size) {
            if (libros[counter]?.titulo == titulo) {
                libros[counter] = null
                counter = size
            } else counter++
        }
        return if (cantidadinicial != almacenados()) "El libro \"$titulo\" ha sido eliminado con éxito."
        else "El libro \"$titulo\" no se ha encontrado entre la lista."
    }

    fun eliminar(condition: (Libro?) -> Boolean) {
        val pos = libros.indexOfFirst(condition)
        if (pos >= 0) libros[pos] = null
    }

    fun eliminarAutor(autor: String): String {
        val cantidadinicial = almacenados()
        for (i in 0 until size) {
            if (libros[i]?.autor == autor) libros[i] = null
        }
        return if (cantidadinicial != almacenados()) "Se ha eliminado ${cantidadinicial - almacenados()} libro(s) del autor \"$autor\" con éxito."
        else "No se encontró \"$autor\" entre los autores."
    }


}

fun main(){
    fun main() {
        val libreria = ConjuntoLibros(10)
        val libro = Libro("El renacer", "Hector", 714, 6)
        val libro2 = Libro("", "Jose", 220, 8)

        println(libreria.añadirLibro(libro))
        println(libreria.añadirLibro(libro2))
        libreria.eliminar { it?.titulo == "Caperucita" }
        libreria.eliminar { it?.autor == "Alex" }
        println(libreria.añadirLibro(libro2))
        println(libreria)
    }
}