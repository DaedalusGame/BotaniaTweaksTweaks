package botaniatweakstweaks;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = BotaniaTweaksTweaks.MODID, acceptedMinecraftVersions = "[1.12, 1.13)", dependencies = "before:botania_tweaks")
@Mod.EventBusSubscriber
public class BotaniaTweaksTweaks
{
    public static final String MODID = "botaniatweakstweaks";
    public static final Logger LOG = LogManager.getLogger("Botania Tweaks Tweaks");

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        //I wonder if there's anything pettier than grudgecoders
        NicerTryerHandler.tryNicely();
    }
}
