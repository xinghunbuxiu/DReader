package com.duokan.reader.domain.micloud;

import android.text.TextUtils;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.cache.C0572d;
import com.duokan.reader.common.cache.C0577j;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.json.JSONObject;

public class MiCloudDownloadFileTaskCacheFactory implements ag<C1084z> {
    /* renamed from: a */
    private static final MiCloudDownloadFileTaskCacheFactory f5152a = new MiCloudDownloadFileTaskCacheFactory();
    /* renamed from: b */
    private final HashMap<String, HashMap<String, UserNamespaceTaskCache>> f5153b = new HashMap();

    class UserNamespaceTaskCache implements C0529q<C1084z> {
        /* renamed from: a */
        private final String f5149a;
        /* renamed from: b */
        private final String f5150b;
        /* renamed from: c */
        private C0572d<UserNamespaceTaskCacheInfo, C1084z, JSONObject> f5151c;

        class UserNamespaceTaskCacheInfo implements Serializable {
            public String mAccountUuid;
            public String mNamespace;

            private UserNamespaceTaskCacheInfo() {
                this.mAccountUuid = null;
                this.mNamespace = null;
            }
        }

        public UserNamespaceTaskCache(String str, String str2) {
            this.f5149a = str;
            this.f5150b = str2;
        }

        /* renamed from: c */
        public synchronized Collection<C1084z> mo742c() {
            m7999a();
            return this.f5151c.queryItems();
        }

        /* renamed from: a */
        public synchronized void m8001a(C1084z c1084z) {
            m7999a();
            this.f5151c.insertItem(c1084z);
        }

        /* renamed from: b */
        public synchronized void m8004b(C1084z c1084z) {
            m7999a();
            this.f5151c.updateItem(c1084z);
        }

        /* renamed from: c */
        public synchronized void m8007c(C1084z c1084z) {
            m7999a();
            this.f5151c.deleteItem(c1084z);
        }

        /* renamed from: b */
        public void mo740b() {
            m7999a();
            this.f5151c.clearItems();
        }

        /* renamed from: a */
        private void m7999a() {
            if (this.f5151c == null) {
                this.f5151c = new C0572d("MiCloudDownloadFileTaskCacheKey_" + this.f5149a + "_" + this.f5150b, C0577j.f1885a, new ax(), new aw(), 0);
                UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = (UserNamespaceTaskCacheInfo) this.f5151c.queryInfo();
                if (TextUtils.isEmpty(userNamespaceTaskCacheInfo.mAccountUuid)) {
                    userNamespaceTaskCacheInfo.mAccountUuid = this.f5149a;
                    userNamespaceTaskCacheInfo.mNamespace = this.f5150b;
                    this.f5151c.updateInfo(userNamespaceTaskCacheInfo);
                }
            }
        }
    }

    private MiCloudDownloadFileTaskCacheFactory() {
    }

    /* renamed from: a */
    public static MiCloudDownloadFileTaskCacheFactory m8008a() {
        return f5152a;
    }

    /* renamed from: a */
    public synchronized C0529q<C1084z> mo1477a(String str, String str2) {
        C0529q<C1084z> c0529q;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.f5153b.get(str);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.f5153b.put(str, hashMap2);
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
