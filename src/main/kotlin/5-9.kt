class Cuenta(val numerocuenta: String, var saldo: Double = .0) {

    fun pago(cantidad: Double) {
        this.saldo -= cantidad
    }

    fun abono(cantidad: Double) {
        this.saldo += cantidad
    }

    fun transferencia(cantidad: Double, cuentadestino: Cuenta) {
        cuentadestino.abono(cantidad)
        this.saldo -= cantidad

    }

    override fun toString(): String {
        return "[${this.numerocuenta}]"
    }
}

class Persona(val DNI: String, val cuentas: MutableList<Cuenta> = mutableListOf()) {

    init {
        require(cuentas.size <= 3) { "No se puede añadir más de 3 cuentas" }
    }

    fun addcuenta(nuevacuenta: Cuenta) {
        if (cuentas.size <= 3) {
            cuentas.add(nuevacuenta)
        } else throw IndexOutOfBoundsException("No puedes añadir más de 3 cuentas")
    }

    fun esmorosa(): String {}

fun saldos(cuenta: Cuenta): String {
    return "Saldo de la cuenta $cuenta: ${cuenta.saldo}"
}


fun main() {
    val persona1 = Persona("77162229N")
    val cuenta1 = Cuenta("IBAN46 8832 9923")
    val cuenta2 = Cuenta("IBAN46 4234 3546", 700.00)
    persona1.addcuenta(cuenta1)
    persona1.addcuenta(cuenta2)

    println(saldos(cuenta1))
    println(saldos(cuenta2))

    println("Abono de 1100€ a la cuenta $cuenta1")
    cuenta1.abono(1100.00)
    println("Pago de 750€ a la cuenta $cuenta2")
    cuenta2.pago(750.00)
    println(saldos(cuenta1))
    println(saldos(cuenta2))
    println("Transferencia de 500€ de la cuenta $cuenta1 a la cuenta $cuenta2")
    cuenta1.transferencia(500.00, cuenta2)
    println(saldos(cuenta1))
    println(saldos(cuenta2))
}