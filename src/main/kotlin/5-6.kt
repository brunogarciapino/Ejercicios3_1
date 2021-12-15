class Rectangulo(val base:Int,val altura: Int){

    fun area():Int = base*altura
    fun perimetro():Int = 2*(base*altura)
    override fun toString(): String {
        return super.toString()
    }
}



fun main() {

    var rectangulo1= Rectangulo(6, 8)
    var rectangulo2= Rectangulo(10,14)
    println("El primer rectángulo es: ${rectangulo1.toString()}, la base es: ${rectangulo1.area().toString()} y el perímetro es ${rectangulo1.perimetro()
        .toString()} ")
    println("El segundo rectángulo es: ${rectangulo2.toString()}, la base es: ${rectangulo2.area().toString()} y el perímetro es ${rectangulo2.perimetro()
        .toString()} ")
}
