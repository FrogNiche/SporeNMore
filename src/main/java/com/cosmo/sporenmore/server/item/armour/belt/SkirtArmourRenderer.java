package com.cosmo.sporenmore.server.item.armour.belt;

import com.cosmo.sporenmore.SporeNMore;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SkirtArmourRenderer extends GeoArmorRenderer<SkirtArmour> {
    public SkirtArmourRenderer() {
        super(new DefaultedItemGeoModel<>(SporeNMore.modLoc("skirt")));
    }
}
