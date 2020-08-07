import java.lang.IllegalArgumentException

fun main(vararg args: String){

    println("Please enter your math problem...")
    var calInput = readLine()
    while(calInput.isNullOrBlank().not()) {
        println("You entered $calInput")

        // Convert user input into array to grab specific values
        val operation= calInput?.split(' ')

        // Make sure is a valid Math problem
        if (operation?.size == 3) {

            // Get Arithmetic operation
            val operator  = operation.get(1)

            // get operation values and make sure Math operations can be done on them
            val LHS = operation[0].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input: ${operation[0]}")
            val RHS = operation[2].toDoubleOrNull() ?: throw IllegalArgumentException("Invalid input: ${operation[2]}")

           val result =  when (operator) {
                "+" -> LHS.plus(RHS)
                "-" -> LHS.minus(RHS)
                "*" -> LHS.times(RHS)
                "/" -> LHS.div(RHS)
                else -> throw IllegalArgumentException("Invalid operator specified: $operator")
            }

            println(result)
        }else{
            println("Invalid operation specified: $operation")
        }


        calInput = readLine()
    }

    // Program exited
    println("Thank for using Calculator!!")
}