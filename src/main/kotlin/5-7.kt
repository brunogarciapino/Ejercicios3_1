class Coche(var color: String, val marca: String, val modelo: String, val caballos: Int, val num_puertas: Byte, val matricula: String) {

    override fun toString(): String {
        return "Color: $color, Marca: $marca, Modelo: $modelo, Caballos:$caballos, Numero de puertas:$num_puertas, Matricula:$matricula"
    }
}


fun main() {
    var coche1 = Coche("negro", "Opel", "Corsa", 190, 4, "ZLM3827")
    var coche2 = Coche("blanco", "Mercedes", "AMG", 290, 4, "MKT6474")
    var coche3 = Coche("verde", "Mustang", "GT350", 600, 2, "JBA8267")

    coche1.color="Rojo"
    coche2.color="Amarillo"
    println(coche1)
    println(coche2)
    println(coche3)}