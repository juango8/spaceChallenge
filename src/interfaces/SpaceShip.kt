package interfaces

import models.Item

interface SpaceShip {
    // returns true or false, if the launch was successful or if the rocket has crashed
    fun launch(): Boolean
    // returns true or false based on the success of the landing
    fun land(): Boolean
    // takes an Item as an argument,
    // returns true if the rocket can carry such item or false if it will exceed the weight limit
    fun canCarry(newItem:Item = Item("nn",0)): Boolean
    // takes an Item object as an argument,
    // updates the current weight of the rocket.
    fun carry(newItem: Item)
}