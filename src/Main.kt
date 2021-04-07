import models.Rocket
import models.Simulation

fun main() {
    val simulation = Simulation()
    val dataPhase1 = simulation.loadItems("/home/juango/Codigos/RAVN/challenges/spaceChallenge/src/data/phase-1.txt")
    val dataPhase2 = simulation.loadItems("/home/juango/Codigos/RAVN/challenges/spaceChallenge/src/data/phase-2.txt")

    val listOfU1sPhase1 = simulation.loadU1(dataPhase1)
    val listOfU1sPhase2 = simulation.loadU1(dataPhase2)


    val totalBudgetU1 = simulation.runSimulation(listOfU1sPhase1 as ArrayList<Rocket>) +
            simulation.runSimulation(listOfU1sPhase2 as ArrayList<Rocket>)

    val listOfU2sPhase1 = simulation.loadU2(dataPhase1)
    val listOfU2sPhase2 = simulation.loadU2(dataPhase2)

    val totalBudgetU2 = simulation.runSimulation(listOfU2sPhase1 as ArrayList<Rocket>) + simulation
        .runSimulation(listOfU2sPhase2 as ArrayList<Rocket>)

    println("We'll need $totalBudgetU1 millions to U1 Rockets")
    println("We'll need $totalBudgetU2 millions to U2 Rockets")
}