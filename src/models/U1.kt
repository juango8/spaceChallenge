package models

class U1() : Rocket(
    cost = 100,
    weight = 10000.0,
    actualCargoWeight = 0.0,
    capacity = 8000.0
) {
    companion object {
        const val probabilityLaunch = 0.05
        const val probabilityLand = 0.01
    }

    // return true or false based on the actual probability of each type.
    override fun launch(): Boolean {
        val probability = ((0..999).random()) / 100.0
        return (probabilityLaunch * (actualCargoWeight / (capacity + weight))) <= probability
    }

    // return true or false based on the actual probability of each type.
    override fun land(): Boolean {
        val probability = ((0..999).random()) / 100.0
        return (probabilityLand * (actualCargoWeight / (capacity + weight))) <= probability
    }
}