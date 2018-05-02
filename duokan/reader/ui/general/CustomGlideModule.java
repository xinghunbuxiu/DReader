package com.duokan.reader.ui.general;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.duokan.reader.ui.general.b.d;

import java.io.InputStream;

public class CustomGlideModule implements GlideModule {
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        glideBuilder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setDiskCache(new DiskLruCacheFactory(new aq(this), 104857600));
    }

    public void registerComponents(Context context, Glide glide) {
        glide.register(n.class, InputStream.class, new d());
    }
}
