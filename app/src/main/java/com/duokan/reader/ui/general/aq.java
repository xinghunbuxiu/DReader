package com.duokan.reader.ui.general;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;
import com.duokan.reader.ReaderEnv;
import java.io.File;

class aq implements CacheDirectoryGetter {
    /* renamed from: a */
    final /* synthetic */ CustomGlideModule f6936a;

    aq(CustomGlideModule customGlideModule) {
        this.f6936a = customGlideModule;
    }

    public File getCacheDirectory() {
        return ReaderEnv.get().getCacheDirectory();
    }
}
