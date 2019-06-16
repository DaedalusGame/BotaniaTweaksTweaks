package botaniatweakstweaks;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import quaternary.botaniatweaks.modules.botania.config.BotaniaConfig;

import java.io.File;

@Mod(modid = BotaniaTweaksTweaks.MODID, acceptedMinecraftVersions = "[1.12, 1.13)", dependencies = "after:botaniatweaks")
@Mod.EventBusSubscriber
public class BotaniaTweaksTweaks
{
    public static final String MODID = "botaniatweakstweaks";

    public static Configuration config;
    public static int decay_time = 72000;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        File suggestedConfigurationFile = new File(Loader.instance().getConfigDir(), "botaniatweaks.cfg");
        config = new Configuration(suggestedConfigurationFile);
        config.load();

        decay_time = config.getInt("passiveDecayTimerPlus", "balance.decay", 72000, 1, Integer.MAX_VALUE, "Ignore the option above. Can only be set to a positive integer. Muahaha.");

        if (config.hasChanged()) {
            config.save();
        }

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent(priority = EventPriority.LOWEST)
    public void onTick(TickEvent event) {
        BotaniaConfig.PASSIVE_DECAY_TIMER = decay_time;
    }
}
