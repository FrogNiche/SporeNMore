package com.cosmo.sporenmore.server.item.armour.belt;

import com.cosmo.sporenmore.SporeNMore;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class BeltArmourRenderer extends GeoArmorRenderer<BeltArmour> {
    public BeltArmourRenderer() {
        super(new DefaultedItemGeoModel<>(SporeNMore.modLoc("belt")));
    }
}
