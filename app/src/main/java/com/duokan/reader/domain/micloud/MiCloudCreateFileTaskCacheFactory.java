package com.duokan.reader.domain.micloud;

import android.text.TextUtils;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0577j;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONObject;

public class MiCloudCreateFileTaskCacheFactory implements ag<C1068i> {
    /* renamed from: a */
    private static final MiCloudCreateFileTaskCacheFactory f5147a = new MiCloudCreateFileTaskCacheFactory();
    /* renamed from: b */
    private final HashMap<String, HashMap<String, UserNamespaceTaskCache>> f5148b = new HashMap();

    class UserNamespaceTaskCache implements C0529q<C1068i> {
        /* renamed from: a */
        private final String f5144a;
        /* renamed from: b */
        private final String f5145b;
        /* renamed from: c */
        private C0572d<UserNamespaceTaskCacheInfo, C1068i, JSONObject> f5146c;

        class UserNamespaceTaskCacheInfo implements Serializable {
            public String mAccountUuid;
            public String mNamespace;

            private UserNamespaceTaskCacheInfo() {
                this.mAccountUuid = null;
                this.mNamespace = null;
            }
        }

        public UserNamespaceTaskCache(String str, String str2) {
            this.f5144a = str;
            this.f5145b = str2;
        }

        /* renamed from: c */
        public synchronized Collection<C1068i> mo742c() {
            m7987a();
            return this.f5146c.queryItems();
        }

        /* renamed from: a */
        public synchronized void m7989a(C1068i c1068i) {
            m7987a();
            this.f5146c.insertItem(c1068i);
        }

        /* renamed from: b */
        public synchronized void m7992b(C1068i c1068i) {
            m7987a();
            this.f5146c.updateItem(c1068i);
        }

        /* renamed from: c */
        public synchronized void m7995c(C1068i c1068i) {
            m7987a();
            this.f5146c.deleteItem(c1068i);
        }

        /* renamed from: b */
        public void mo740b() {
            m7987a();
            this.f5146c.clearItems();
        }

        /* renamed from: a */
        private void m7987a() {
            if (this.f5146c == null) {
                this.f5146c = new C0572d("MiCloudCreateFileTaskCacheKey_" + this.f5144a + "_" + this.f5145b, C0577j.f1885a, new an(), new am(), 0);
                UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = (UserNamespaceTaskCacheInfo) this.f5146c.queryInfo();
                if (TextUtils.isEmpty(userNamespaceTaskCacheInfo.mAccountUuid)) {
                    userNamespaceTaskCacheInfo.mAccountUuid = this.f5144a;
                    userNamespaceTaskCacheInfo.mNamespace = this.f5145b;
                    this.f5146c.updateInfo(userNamespaceTaskCacheInfo);
                }
            }
        }
    }

    private MiCloudCreateFileTaskCacheFactory() {
    }

    /* renamed from: a */
    public static MiCloudCreateFileTaskCacheFactory m7997a() {
        return f5147a;
    }

    /* renamed from: a */
    public synchronized C0529q<C1068i> mo1477a(String str, String str2) {
        C0529q<C1068i> c0529q;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.f5148b.get(str);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.f5148b.put(str, hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = hashMap2;
        }
        c0529q = (UserNamespaceTaskCache) hashMap.get(str2);
        if (c0529q == null) {
            c0529q = new UserNamespaceTaskCache(str, str2);
            hashMap.put(str2, c0529q);
        }
        return c0529q;
    }
}
