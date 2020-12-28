package botaniatweakstweaks;

import net.minecraftforge.fml.relauncher.ReflectionHelper;
import quaternary.botaniatweaks.modules.shared.lib.GeneratingFlowers;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.Map;

public class NicerTryerHandler {
    private static Map<String, GeneratingFlowers.FlowerData> nameToData;
    private static Map<String, GeneratingFlowers.FlowerData> classToData;

    public static void tryNicely() { //Would you kindly
        BotaniaTweaksTweaks.LOG.info("Trying very nicely...");

        nameToData = (Map<String, GeneratingFlowers.FlowerData>) doYouMindIfI("namesToData");
        classToData = (Map<String, GeneratingFlowers.FlowerData>) doYouMindIfI("classesToData");

        pleaseAcceptMyHumbleOffering(new GeneratingFlowers.FlowerData("botania", "hydroangeas", "vazkii.botania.common.block.subtile.generating.SubTileHydroangeas", false));
    }

    private static Object doYouMindIfI(String s) {
        Field field = ReflectionHelper.findField(GeneratingFlowers.class, s);
        field.setAccessible(true);
        try {
            return field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void pleaseAcceptMyHumbleOffering(GeneratingFlowers.FlowerData data) {
        Collection<GeneratingFlowers.FlowerData> flowers = GeneratingFlowers.getAllFlowerDatas();
        flowers.removeIf(flowerData -> flowerData.name.equals(data.name));
        flowers.add(data);
        nameToData.put(data.name, data);
        classToData.put(data.className, data);
    }
}
