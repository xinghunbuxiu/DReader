package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.core.p026a.C0272a;
import com.duokan.core.sys.UThread;
import com.duokan.reader.ReaderEnv;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONObject;

public class DkSharedStorageManager implements ai {
    /* renamed from: a */
    protected static C0272a f3597a = new C0272a(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), "localstorage.db")).toString());
    /* renamed from: b */
    private static final aj<DkSharedStorageManager> f3598b = new aj();
    /* renamed from: c */
    private final Context f3599c;
    /* renamed from: d */
    private final HashMap<SharedKey, List<ao>> f3600d = new HashMap();

    public enum SharedKey {
        USER_PRIVILEGE("/store/v0/time_limited/get"),
        COUPON_COUNT("/store/v0/coupon/list"),
        USER_FAV_COUNT("USER_FAV_COUNT"),
        USER_RECOMMEND_COUNT("USER_RECOMMEND_COUNT"),
        USER_READ_COUNT("USER_READ_COUNT"),
        CART_CACHE("cart_cache");
        
        String mUrl;

        private SharedKey(String str) {
            this.mUrl = str;
        }

        static SharedKey value(String str) {
            SharedKey[] values = values();
            for (int i = 0; i < values.length; i++) {
                if (TextUtils.equals(values[i].mUrl, str)) {
                    return values[i];
                }
            }
            throw new RuntimeException("no such key");
        }
    }

    private DkSharedStorageManager(Context context, ReaderEnv readerEnv) {
        this.f3599c = context;
    }

    /* renamed from: a */
    public static void m5017a(Context context, ReaderEnv readerEnv) {
        f3598b.m709a(new DkSharedStorageManager(context, readerEnv));
    }

    /* renamed from: a */
    public static DkSharedStorageManager m5016a() {
        return (DkSharedStorageManager) f3598b.m707a();
    }

    /* renamed from: a */
    public String m5023a(String str) {
        Serializable a = f3597a.m630a(str);
        return a == null ? "" : (String) a;
    }

    /* renamed from: a */
    public void m5026a(String str, String str2, boolean z) {
        try {
            SharedKey value = SharedKey.value(str);
            Serializable a = f3597a.m630a(str);
            if ((a == null || !TextUtils.equals(str2, (String) a)) && !m5020a(str2, (String) a)) {
                m5019a(value, (Serializable) str2);
            }
        } catch (Exception e) {
        }
        if (z) {
            f3597a.m637c(str, (Serializable) str2);
        } else {
            f3597a.m634b(str, (Serializable) str2);
        }
    }

    /* renamed from: b */
    public void m5028b(String str) {
        try {
            m5021c(SharedKey.value(str));
        } catch (Exception e) {
        }
        f3597a.m633b(str);
    }

    /* renamed from: a */
    public String m5022a(SharedKey sharedKey) {
        try {
            return m5023a(sharedKey.mUrl);
        } catch (Exception e) {
            return "";
        }
    }

    /* renamed from: a */
    public void m5024a(SharedKey sharedKey, String str, boolean z) {
        try {
            m5026a(sharedKey.mUrl, str, z);
        } catch (Exception e) {
        }
    }

    /* renamed from: b */
    public void m5027b(SharedKey sharedKey) {
        try {
            m5028b(sharedKey.mUrl);
        } catch (Exception e) {
        }
    }

    /* renamed from: a */
    public void m5025a(ao aoVar, SharedKey... sharedKeyArr) {
        for (SharedKey a : sharedKeyArr) {
            m5018a(a, aoVar);
        }
    }

    /* renamed from: a */
    private boolean m5020a(String str, String str2) {
        try {
            return new JSONObject(str).optJSONObject("__data__").equals(new JSONObject(str2).optJSONObject("__data__"));
        } catch (Exception e) {
            return false;
        }
    }

    /* renamed from: a */
    private void m5019a(SharedKey sharedKey, Serializable serializable) {
        List list = (List) this.f3600d.get(sharedKey);
        if (list != null) {
            UThread.runOnThread(new am(this, list, sharedKey, serializable));
        }
    }

    /* renamed from: c */
    private void m5021c(SharedKey sharedKey) {
        List list = (List) this.f3600d.get(sharedKey);
        if (list != null) {
            UThread.runOnThread(new an(this, list, sharedKey));
        }
    }

    /* renamed from: a */
    private void m5018a(SharedKey sharedKey, ao aoVar) {
        List list = (List) this.f3600d.get(sharedKey);
        if (list == null) {
            list = new LinkedList();
            this.f3600d.put(sharedKey, list);
        }
        list.add(aoVar);
    }
}
