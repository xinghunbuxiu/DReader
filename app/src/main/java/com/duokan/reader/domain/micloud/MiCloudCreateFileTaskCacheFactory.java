package com.duokan.reader.domain.micloud;

import android.text.TextUtils;

import com.duokan.reader.common.async.work.q;
import com.duokan.reader.common.cache.d;
import com.duokan.reader.common.cache.j;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

public class MiCloudCreateFileTaskCacheFactory implements ag {
    private static final MiCloudCreateFileTaskCacheFactory a = new MiCloudCreateFileTaskCacheFactory();
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

        public synchronized void a(i iVar) {
            a();
            this.c.insertItem(iVar);
        }

        public synchronized void b(i iVar) {
            a();
            this.c.updateItem(iVar);
        }

        public synchronized void c(i iVar) {
            a();
            this.c.deleteItem(iVar);
        }

        public void b() {
            a();
            this.c.clearItems();
        }

        private void a() {
            if (this.c == null) {
                this.c = new d("MiCloudCreateFileTaskCacheKey_" + this.a + "_" + this.b, j.a, new an(), new am(), 0);
                UserNamespaceTaskCacheInfo userNamespaceTaskCacheInfo = (UserNamespaceTaskCacheInfo) this.c.queryInfo();
                if (TextUtils.isEmpty(userNamespaceTaskCacheInfo.mAccountUuid)) {
                    userNamespaceTaskCacheInfo.mAccountUuid = this.a;
                    userNamespaceTaskCacheInfo.mNamespace = this.b;
                    this.c.updateInfo(userNamespaceTaskCacheInfo);
                }
            }
        }
    }

    private MiCloudCreateFileTaskCacheFactory() {
    }

    public static MiCloudCreateFileTaskCacheFactory a() {
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
