package models

class U2 : Rocket() {

    init {
        cost = 120
        weight = 18000.0
        capacity = 11000.0
        actualCargoWeight = 0.0
    }

    // return true or false based on the actual probability of each type.
    override fun launch(): Boolean {
        val probability = ((0..999).random()) / 100
        return (0.04 * (actualCargoWeight / (capacity + weight))) <= probability
    }

    // return true or false based on the actual probability of each type.
    override fun land(): Boolean {
        val probability = ((0..999).random()) / 100
        return (0.08 * (actualCargoWeight / (capacity + weight))) <= probability
    }
}