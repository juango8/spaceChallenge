package models

import interfaces.SpaceShip

class Rocket: SpaceShip {
    override fun launch(): Boolean {
        return true
    }

    override fun land(): Boolean {
        return true
    }

    override fun canCarry(newItem: Item): Boolean {
        TODO("Not yet implemented")
    }

    override fun carry(newItem: Item) {
        TODO("Not yet implemented")
    }
}