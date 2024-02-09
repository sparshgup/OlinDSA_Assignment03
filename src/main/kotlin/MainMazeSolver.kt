package org.example

fun main() {
    // Example maze inputs
    val exampleMaze1 = listOf(
        "#######",
        "#S....#",
        "#.###.#",
        "#...#.T",
        "#######"
    )

    val exampleMaze2 = listOf(
        "##########",
        "#S.#.....#",
        "#..####.#.",
        "#.#####.#.",
        "#.#...###.",
        "#...#...T#",
        "##########"
    )

    val mazeSolver1 = MazeSolver(exampleMaze1)
    val path1 = mazeSolver1.solve()
    println("Path for maze 1:")
    path1.forEach { point ->
        println("${point.i} ${point.j}")
    }

    val mazeSolver2 = MazeSolver(exampleMaze2)
    val path2 = mazeSolver2.solve()
    println("\nPath for maze 2:")
    path2.forEach { point ->
        println("${point.i} ${point.j}")
    }
}
