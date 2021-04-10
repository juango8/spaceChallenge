package models

import interfaces.SpaceShip

open class Rocket(
    var cost: Int,
    var weight: Double,
    var actualCargoWeight: Double,
    var capacity: Double
) : SpaceShip {

    private val itemList: MutableList<Item> = mutableListOf()


    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    // returns true if the rocket can carry such item or false if it will exceed the weight limit
    final override fun canCarry(newItem: Item): Boolean {
        return (actualCargoWeight + newItem.weight) <= capacity
    }

    // updates the current weight of the rocket.
    final override fun carry(newItem: Item) {
        itemList.add(newItem)
        actualCargoWeight += newItem.weight
    }
}