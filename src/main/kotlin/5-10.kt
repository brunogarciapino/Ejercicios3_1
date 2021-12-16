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

class ConjuntoLibros(tamaño: Int) {
    private val size = tamaño
    var libros = arrayOfNulls<Libro>(size)

    fun añadirLibro(libro: Libro): String {}
    fun almacenados(): Int {
        var cantidad = 0
        for (i in 0 until size) {
            if (libros[i] != null) cantidad++
        }
        return cantidad
    }
    fun eliminar(titulo: String): String {}
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
        val libro = Libro("El Renacer", "Hector", 714, 6)
        val libro2 = Libro("", "Jose", 220, 8)

        println(libreria.añadirLibro(libro))
        println(libreria.añadirLibro(libro2))
        println(libreria.añadirLibro(libro2))
        println(libreria)
    }
}