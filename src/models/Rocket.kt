package models

import interfaces.SpaceShip

open class Rocket: SpaceShip {

    private val itemList:MutableList<Item> = mutableListOf()
    var cost = 0
    var weight = 0.0
    var actualCargoWeight = 0.0
    var capacity = 0.0


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