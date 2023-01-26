package io.github.bloepiloepi.pvp.utils;

import org.jetbrains.annotations.Contract;

import static net.minestom.server.MinecraftServer.TICK_PER_SECOND;

public final class Utils {
    public static final int STANDARD_TPS = 20;
    public static final float TPS_MULTIPLIER = (float) TICK_PER_SECOND / STANDARD_TPS;  //NOTE(CamperSamu): use float for accuracy, consider option for int instead
    public static final int TPS_MUL_ROUND = Math.round(TPS_MULTIPLIER);

    private Utils(){}

    @Contract(pure = true)
    @SuppressWarnings("unused") //API
    public static double scaleToTps (final double in)  {
        return in * TPS_MULTIPLIER;
    }
}
