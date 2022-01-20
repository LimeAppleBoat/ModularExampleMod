package com.jab125.example.base.mixin;

import com.terraformersmc.modmenu.util.mod.Mod;
import com.terraformersmc.modmenu.util.mod.fabric.CustomValueUtil;
import com.terraformersmc.modmenu.util.mod.fabric.FabricMod;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.metadata.ModMetadata;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.HashSet;
import java.util.Set;

/**
 * add "examplemod:module-lifecycle" on all submodules except the base module
 * dont remove this, this saves a lot of lines of code
 */
@Pseudo
@Mixin(FabricMod.class)
@Environment(EnvType.CLIENT)
public abstract class FabricModMixin {
    @Shadow @Final private ModMetadata metadata;

    @Shadow @Final private Set<Mod.Badge> badges;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void exampleModBase$injectInit(ModContainer t, CallbackInfo ci) {
        String id = metadata.getId();
        if (metadata.containsCustomValue("examplemod:module-lifecycle")) {
            if (FabricLoader.getInstance().isModLoaded("examplemod")) {
                ((ModMenuDataAccessor)((FabricMod)(Object)this).getModMenuData()).callFillParentIfEmpty("examplemod");
            } else {
                ((ModMenuDataAccessor)((FabricMod)(Object)this).getModMenuData()).callFillParentIfEmpty("examplemod");
            }
            if ("deprecated".equals(CustomValueUtil.getString("examplemod:module-lifecycle", metadata).orElse(null))) {
                badges.add(Mod.Badge.DEPRECATED);
            }
        }
    }
}
