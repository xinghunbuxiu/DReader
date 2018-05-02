package com.duokan.core.sys;

class asyncCacheRun implements Runnable {
    final AsyncCache asyncCache;

    asyncCacheRun(AsyncCache asyncCache) {
        this.asyncCache = asyncCache;
    }

    public void run() {
        this.asyncCache.a();
    }
}
