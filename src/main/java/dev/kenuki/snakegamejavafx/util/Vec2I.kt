package dev.kenuki.snakegamejavafx.util

class Vec2I {
	@JvmField
	var x: Int

	@JvmField
	var y: Int

	constructor() {
		x = 0
		y = 0
	}

	constructor(x: Int, y: Int) {
		this.x = x
		this.y = y
	}

	constructor(vec: Vec2I) {
		x = vec.x
		y = vec.y
	}

	override fun toString(): String {
		return String.format(
			"Vec2I@%s{x=%d,y=%d}", Integer.toHexString(
				System.identityHashCode(
					this
				)
			), x, y
		)
	}
}
