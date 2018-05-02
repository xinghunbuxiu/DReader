package com.duokan.reader.domain.micloud;

import android.text.TextUtils;

import com.duokan.reader.common.async.work.q;
import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.j;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class MiCloudDownloadFileTaskCacheFactory implements ag {
    private static final MiCloudDownloadFileTaskCacheFactory a = new MiCloudDownloadFileTaskCacheFactory();
    private final HashMap b = new HashMap();

    class UserNamespaceTaskCache implements q {
        private final String a;
        private final String b;
        private d c;

        class UserNamespaceTaskCacheInfo implements Serializable {
            public String mAccountUuid;
            public String mNamespace;

            private UserNamespaceTaskCacheInfo() {
                this.mAccountUuid = null;
                this.mNamespace = null;
            }
        }

        public UserNamespaceTaskCache(String str, String str2) {
            this.a = str;
            this.b = str2;
        }

        public synchronized Collection c() {
            a();
            return this.c.queryItems();
        }

        public synchronized void a(z zVar) {
            a();
            this.c.insertItem(zVar);
        }

        public synchronized void b(z zVar) {
            a();
            this.c.updateItem(zVar);
        }

        public synchronized void c(z zVar) {
            a();
            this.c.deleteItem(zVar);
        }

        public void b() {
            a();
            this.c.clearItems();
        }

        private void a() {
            if (this.c == null) {
                this.c = new d("MiCloudDownloadFileTaskCacheKey_" + this.a + "_" + this.b, j.a, new ax(), new aw(), 0);
                UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = (UserNamespaceTaskCacheInfo) this.c.queryInfo();
                if (TextUtils.isEmpty(userNamespaceTaskCacheInfo.mAccountUuid)) {
                    userNamespaceTaskCacheInfo.mAccountUuid = this.a;
                    userNamespaceTaskCacheInfo.mNamespace = this.b;
                    this.c.updateInfo(userNamespaceTaskCacheInfo);
                }
            }
        }
    }

    private MiCloudDownloadFileTaskCacheFactory() {
    }

    public static MiCloudDownloadFileTaskCacheFactory a() {
        return a;
    }

    public synchronized q a(String str, String str2) {
        q qVar;
        HashMap hashMap;
        HashMap hashMap2 = (HashMap) this.b.get(str);
        if (hashMap2 == null) {
            hashMap2 = new HashMap();
            this.b.put(str, hashMap2);
            hashMap = hashMap2;
        } else {
            hashMap = hashMap2;
        }
        qVar = (UserNamespaceTaskCache) hashMap.get(str2);
        if (qVar == null) {
            qVar = new UserNamespaceTaskCache(str, str2);
            hashMap.put(str2, qVar);
        }
        return qVar;
    }
}
