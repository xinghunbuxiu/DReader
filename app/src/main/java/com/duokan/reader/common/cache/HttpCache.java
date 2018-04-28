package com.duokan.reader.common.cache;

import java.io.Serializable;
import java.lang.reflect.Array;
import org.apache.http.Header;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;

public class HttpCache extends C0566g<HttpResponse> {
    /* renamed from: b */
    static final /* synthetic */ boolean f1853b = (!HttpCache.class.desiredAssertionStatus());

    public class CacheKey extends C0565h implements Serializable {
        static final /* synthetic */ boolean $assertionsDisabled = (!HttpCache.class.desiredAssertionStatus() ? true : $assertionsDisabled);
        private static final long serialVersionUID = 1;
        private final String[][] mRequestHeaders;
        private final String mRequestLine;

        public /* bridge */ /* synthetic */ boolean isSuitable(Object obj) {
            return super.isSuitable(obj);
        }

        public CacheKey(HttpRequest httpRequest) {
            if ($assertionsDisabled || httpRequest != null) {
                this.mRequestLine = httpRequest.getRequestLine().toString();
                Header[] allHeaders = httpRequest.getAllHeaders();
                this.mRequestHeaders = (String[][]) Array.newInstance(String.class, new int[]{allHeaders.length, 2});
                for (int i = 0; i < allHeaders.length; i++) {
                    this.mRequestHeaders[i][0] = allHeaders[i].getName();
                    this.mRequestHeaders[i][1] = allHeaders[i].getValue();
                }
                return;
            }
            throw new AssertionError();
        }

        public int hashCode() {
            return this.mRequestLine.hashCode();
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof CacheKey)) {
                return $assertionsDisabled;
            }
            CacheKey cacheKey = (CacheKey) obj;
            if (!this.mRequestLine.equals(cacheKey.mRequestLine) || this.mRequestHeaders.length != cacheKey.mRequestHeaders.length) {
                return $assertionsDisabled;
            }
            for (String[] a : this.mRequestHeaders) {
                if (!HttpCache.m2489b(cacheKey.mRequestHeaders, a)) {
                    return $assertionsDisabled;
                }
            }
            return true;
        }
    }

    class FileCacheKey extends com.duokan.reader.common.cache.FileCache.CacheKey {
        private static final long serialVersionUID = 1;
        private final String[][] mRequestHeaders;
        private final String mRequestLine;

        public FileCacheKey(CacheKey cacheKey) {
            super(cacheKey.mRequestLine);
            this.mRequestLine = cacheKey.mRequestLine;
            this.mRequestHeaders = cacheKey.mRequestHeaders;
        }

        public boolean equals(Object obj) {
            if (!(obj instanceof FileCacheKey)) {
                return false;
            }
            FileCacheKey fileCacheKey = (FileCacheKey) obj;
            if (!this.mRequestLine.equals(fileCacheKey.mRequestLine) || this.mRequestHeaders.length != fileCacheKey.mRequestHeaders.length) {
                return false;
            }
            for (String[] a : this.mRequestHeaders) {
                if (!HttpCache.m2489b(fileCacheKey.mRequestHeaders, a)) {
                    return false;
                }
            }
            return true;
        }
    }

    /* renamed from: b */
    private static boolean m2489b(String[][] strArr, String[] strArr2) {
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i][0].equals(strArr2[0]) && strArr[i][1].equals(strArr2[1])) {
                return true;
            }
            i++;
        }
        return false;
    }
}
