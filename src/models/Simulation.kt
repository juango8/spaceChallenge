package models

import java.io.File
import java.io.FileNotFoundException

class Simulation {
    fun loadItems(fileName: String): ArrayList<Item> {
        val itemList: ArrayList<Item> = ArrayList()
        try {
            File(fileName).forEachLine {
                val data = it.split("=")
                if (data.isNotEmpty()) {
                    val newItem = Item(data[0], data[1].toInt())
                    itemList.add(newItem)
                }
            }
        } catch (e: FileNotFoundException) {

        }
        return itemList
    }

    // It first tries to fill up 1 rocket with as many items as possible before creating a new rocket object and
    // filling that one until all items are loaded. The method then returns the ArrayList of those U1 rockets that
    // are fully loaded.
    fun loadU1(itemList: ArrayList<Item>): ArrayList<U1> {
        val u1RocketList = ArrayList<U1>()
        var iteratorItemList = 0

        while (iteratorItemList<itemList.size) {
            val rocket = U1()
            while (iteratorItemList<itemList.size && rocket.canCarry(itemList[iteratorItemList])) {
                rocket.carry(itemList[iteratorItemList])
                iteratorItemList += 1
            }
            u1RocketList.add(rocket)
        }
        return u1RocketList
    }

    fun loadU2(itemList: ArrayList<Item>): ArrayList<U2> {
        val u2RocketList = ArrayList<U2>()
        var iteratorItemList = 0

        while (iteratorItemList<itemList.size) {
            val rocket = U2()
            while (iteratorItemList<itemList.size && rocket.canCarry(itemList[iteratorItemList])) {
                rocket.carry(itemList[iteratorItemList])
                iteratorItemList += 1
            }
            u2RocketList.add(rocket)
        }
        return u2RocketList
    }

    // this method takes an ArrayList of Rockets and calls launch and land methods for each of the rockets in the ArrayList.
    // Every time a rocket explodes or crashes (i.e if launch or land return false) it will have to send that rocket again.
    // All while keeping track of the total budget required to send each rocket safely to Mars.
    // runSimulation then returns the total budget required to send all rockets (including the crashed ones).
    fun runSimulation(rocketList: ArrayList<Rocket>): Int {
        var totalBudget = 0
        for (rocket in rocketList) {
            do {
                totalBudget += rocket.cost
            } while (rocket.launch() && rocket.land())
        }

        return totalBudget
    }
}