package net.sonunte.hexkinetics.common.casting.actions

import at.petrak.hexcasting.api.spell.*
import at.petrak.hexcasting.api.spell.casting.CastingContext
import at.petrak.hexcasting.api.spell.iota.DoubleIota
import at.petrak.hexcasting.api.spell.iota.Iota
import at.petrak.hexcasting.api.spell.iota.NullIota

object OpVectorArgument : ConstMediaAction {

	override val argc = 2


	override fun execute(args: List<Iota>, ctx: CastingContext): List<Iota> {
		val vec = args.getVec3(0,argc)
		val num = args.getDouble(1, argc)
		// all types that can be converted to an iota will have .asActionResult
		// defined for them to make them easy to return as the result of an Action.

		return if (num <= 0) {
			listOf(NullIota())
		} else if (num == 1.0) {
			listOf(DoubleIota(vec.x))
		} else if (num == 2.0) {
			listOf(DoubleIota(vec.y))
		} else if (num == 3.0) {
			listOf(DoubleIota(vec.z))
		} else {
			listOf(NullIota())
		}

	}
}