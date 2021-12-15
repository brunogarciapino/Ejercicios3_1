class Tiempo(var hora: Int, var min: Int = 0, var sec: Int = 0) {

    init {
        require(hora >= 0 && min >= 0 && sec >= 0) { "Has introducido valores no permitidos" }

        while (sec >= 60) {
            sec -= 60
            min += 1
        }
        while (min >= 60) {
            min -= 60
            hora += 1
        }
    }

    override fun toString(): String {
        return "${this.hora}h ${this.min}m ${this.sec}s"
    }
}

fun introducirdato(datos: String): Int {
    return if (datos == "") {
        0
    } else {
        try {
            datos.toInt()
        } catch (_: Exception) {
            -1
        }
    }
}


fun main() {
    val tiempo: Tiempo
    var hora:Int
    var minuto:Int
    var segundo:Int

    println("Introduce la hora")
    hora = readLine()?.toInt() ?: 0
    println("Introduce los minutos")
    minuto = readLine()?.toInt() ?: 0
    println("Introduce los segundos")
    segundo = readLine()?.toInt() ?: 0
    tiempo = Tiempo(hora,minuto,segundo)
    println(tiempo)

}
