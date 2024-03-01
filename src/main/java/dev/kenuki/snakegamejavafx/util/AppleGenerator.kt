package dev.kenuki.snakegamejavafx.util

import java.util.*
import kotlin.random.asKotlinRandom
import kotlin.random.nextInt

object AppleGenerator {
	@JvmStatic
	fun add(javaRandom: Random, amount: Int, field: Array<Array<Entity?>>) {
		val random = javaRandom.asKotlinRandom()

		val list_of_empty = ArrayList<Pair<Int, Int>>()

		for ((y, row) in field.withIndex()) {
			for ((x, cell) in row.withIndex()) {
				if (cell == Entity.AIR) {
					list_of_empty.add(y to x);
				}
			}
		}

		assert(list_of_empty.size >= amount) { "ЫААААААА" }

		for (i in 0..<amount) {
			val index = random.nextInt(0..<list_of_empty.size);

			val (y, x) = list_of_empty.removeAt(index)

			field[y][x] = Entity.APPLE
		}
	}
}
