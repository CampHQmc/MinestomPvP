package io.github.bloepiloepi.pvp.legacy;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import static net.minestom.server.MinecraftServer.*;

/**
 * Class which contains settings for legacy knockback.
 * <br><br>
 * For further documentation, see the <a href="https://github.com/kernitus/BukkitOldCombatMechanics/blob/d222286fd84fe983fdbdff79699182837871ab9b/src/main/resources/config.yml#L279">config of BukkitOldCombatMechanics</a>
 */
public record LegacyKnockbackSettings(double horizontal, double vertical,
                                      double verticalLimit,
                                      double extraHorizontal, double extraVertical) {
	public static final LegacyKnockbackSettings DEFAULT = builder().build();
	
	public LegacyKnockbackSettings(double horizontal, double vertical, double verticalLimit,
	                               double extraHorizontal, double extraVertical) {
		this.horizontal = horizontal * TICK_PER_SECOND * 0.8;
		this.vertical = (vertical - 0.04) * TICK_PER_SECOND;
		this.verticalLimit = verticalLimit * TICK_PER_SECOND;
		this.extraHorizontal = extraHorizontal * TICK_PER_SECOND * 0.8;
		this.extraVertical = (extraVertical - 0.04) * TICK_PER_SECOND;
	}
	
	@Contract(value = " -> new", pure = true)
	public static @NotNull Builder builder() {
		return new Builder();
	}
	
	public static class Builder {
		private double horizontal = 0.4, vertical = 0.4;
		private double verticalLimit = 0.4;
		private double extraHorizontal = 0.5, extraVertical = 0.1;
		
		@SuppressWarnings("unused")	//API
		public Builder horizontal(double horizontal) {
			this.horizontal = horizontal;
			return this;
		}

		@SuppressWarnings("unused")	//API
		public Builder vertical(double vertical) {
			this.vertical = vertical;
			return this;
		}

		@SuppressWarnings("unused")	//API
		public Builder verticalLimit(double verticalLimit) {
			this.verticalLimit = verticalLimit;
			return this;
		}

		@SuppressWarnings("unused")	//API
		public Builder extraHorizontal(double extraHorizontal) {
			this.extraHorizontal = extraHorizontal;
			return this;
		}

		@SuppressWarnings("unused")	//API
		public Builder extraVertical(double extraVertical) {
			this.extraVertical = extraVertical;
			return this;
		}
		
		public LegacyKnockbackSettings build() {
			return new LegacyKnockbackSettings(horizontal, vertical, verticalLimit, extraHorizontal, extraVertical);
		}
	}
}
