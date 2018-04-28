package com.duokan.reader.common.cache;

import java.io.File;
import java.io.Serializable;

public class FileCache extends C0566g<File> {

    public class CacheKey extends C0565h implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!FileCache.class.desiredAssertionStatus() ? true : $assertionsDisabled);
        private static final long serialVersionUID = 1;
        public final Object mFileTag;

        public /* bridge */ /* synthetic */ boolean isSuitable(Object obj) {
            return super.isSuitable(obj);
        }

        public CacheKey(Object obj) {
            if ($assertionsDisabled || obj != null) {
                this.mFileTag = obj;
                return;
            }
            throw new AssertionError();
        }

        public int hashCode() {
            return this.mFileTag.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CacheKey)) {
                return $assertionsDisabled;
            }
            return this.mFileTag.equals(((CacheKey) obj).mFileTag);
        }
    }
}
