package dev.kenuki.snakegamejavafx.util

import java.util.*
import kotlin.random.asKotlinRandom
import kotlin.random.nextInt

object AppleGenerator {
	@JvmStatic
	fun add(javaRandom: Random, amount: Int, field: Array<Array<Entity?>>) {
		val random = javaRandom.asKotlinRandom()

		val listOfEmpty = ArrayList<Pair<Int, Int>>()

		for ((y, row) in field.withIndex()) {
			for ((x, cell) in row.withIndex()) {
				if (cell == Entity.AIR) {
					listOfEmpty.add(y to x)
				}
			}
		}

		assert(listOfEmpty.size >= amount) { "ЫААААААА" }

		for (i in 0..<amount) {
			val index = random.nextInt(0..<listOfEmpty.size)

			val (y, x) = listOfEmpty.removeAt(index)

			field[y][x] = Entity.APPLE
		}
	}
}
