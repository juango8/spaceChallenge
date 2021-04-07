package models

class U1: Rocket() {

    init {
        cost = 100
        weight = 10000.0
        capacity = 8000.0
        actualCargoWeight = weight
    }

    // return true or false based on the actual probability of each type.
    override fun launch(): Boolean {
        val probability = ((0..9999).random())/100
        return (0.05 * (actualCargoWeight/(capacity+weight))) <= probability
    }

    // return true or false based on the actual probability of each type.
    override fun land(): Boolean {
        val probability = ((0..9999).random())/100
        return (0.01 * (actualCargoWeight/(capacity+weight))) <= probability
    }
}