package com.cosmo.sporenmore.server.item.armour.furry_hoodie;

import com.cosmo.sporenmore.SporeNMore;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FurryHoodieRenderer extends GeoArmorRenderer<FurryHoodie> {
    public FurryHoodieRenderer() {
        super(new DefaultedItemGeoModel<>(SporeNMore.modLoc("furry_hoodie")));
    }
}
