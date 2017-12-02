package com.duokan.reader.ui.general;

import com.bumptech.glide.load.engine.cache.DiskLruCacheFactory.CacheDirectoryGetter;
import com.duokan.reader.ReaderEnv;

import java.io.File;

class aq implements CacheDirectoryGetter {
    final /* synthetic */ CustomGlideModule a;

    aq(CustomGlideModule customGlideModule) {
        this.a = customGlideModule;
    }

    public File getCacheDirectory() {
        return ReaderEnv.get().getCacheDirectory();
    }
}
