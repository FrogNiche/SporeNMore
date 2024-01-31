package com.cosmo.sporenmore.server.entity;

import net.minecraft.resources.ResourceLocation;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import java.util.LinkedHashMap;
import java.util.Map;

public class CrunchType {
    private static final Map<ResourceLocation, CrunchType> CRUNCH_TYPE = new LinkedHashMap<>();

    private ResourceLocation id;
    private Pair<ResourceLocation, ResourceLocation> modelAndTexture;

    public CrunchType(ResourceLocation id, ResourceLocation model, ResourceLocation texture) {
        this(id, Pair.of(model, texture));
    }

    public CrunchType(ResourceLocation id, Pair<ResourceLocation, ResourceLocation> modelAndTexture) {
        this.id = id;
        this.modelAndTexture = modelAndTexture;
    }

    public ResourceLocation getId() {
        return id;
    }

    public void setId(ResourceLocation id) {
        this.id = id;
    }

    public ResourceLocation getTextureLocation() {
        return this.modelAndTexture.getRight();
    }

    public void setTextureLocation(ResourceLocation textureLocation) {
        this.modelAndTexture = Pair.of(this.modelAndTexture.getLeft(), textureLocation);
    }

    public ResourceLocation getModelLocation() {
        return this.modelAndTexture.getLeft();
    }

    public void setModelLocation(ResourceLocation modelLocation) {
        this.modelAndTexture = Pair.of(modelLocation, this.modelAndTexture.getRight());
    }



    public static CrunchType registerCrunchType(CrunchType crunchType) {
        ResourceLocation id = crunchType.getId();
        if (CRUNCH_TYPE.containsKey(id)) {
            throw new IllegalStateException(String.format("%s already exists in the SporelingType registry.", id.toString()));
        }
        CRUNCH_TYPE.put(id, crunchType);
        return crunchType;
    }

    @Nullable
    public static CrunchType getById(@Nullable String id) {
        if (id == null) {
            return null;
        } else {
            return getById(ResourceLocation.tryParse(id));
        }
    }

    @Nullable
    public static CrunchType getById(@Nullable ResourceLocation id) {
        return CRUNCH_TYPE.get(id);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CrunchType) {
            final CrunchType type = (CrunchType) obj;
            return type.getId().equals(this.getId()) &&
                    type.getModelLocation().equals(this.getModelLocation()) &&
                    type.getTextureLocation().equals(this.getTextureLocation());
        } else {
            return false;
        }
    }
}
