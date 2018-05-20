package com.duokan.reader.ui.general;

import android.content.Context;

import com.bumptech.glide.Glide;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.engine.cache.DiskCache;
import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory;
import com.bumptech.glide.module.GlideModule;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.p053b.Factory;

import java.io.File;
import java.io.InputStream;

public class CustomGlideModule implements GlideModule {
    public void applyOptions(Context context, GlideBuilder glideBuilder) {
        glideBuilder.setDecodeFormat(DecodeFormat.PREFER_ARGB_8888).setDiskCache(new DiskLruCacheFactory(new DiskLruCacheFactory.CacheDirectoryGetter() {
            @Override
            public File getCacheDirectory() {

                return ReaderEnv.get().getCacheDirectory();
            }
        }, DiskCache.Factory.DEFAULT_DISK_CACHE_SIZE));
    }

    public void registerComponents(Context context, Glide glide) {
        glide.register(CustomGlideUrl.class, InputStream.class, new Factory());
    }
}
