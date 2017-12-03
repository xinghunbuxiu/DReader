package com.duokan.reader.domain.cloud;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;

import com.duokan.core.a.a;
import com.duokan.core.app.ah;
import com.duokan.core.app.ai;
import com.duokan.core.sys.TaskHandler;
import com.duokan.reader.ReaderEnv;

import org.json.JSONObject;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class DkSharedStorageManager implements ah {
    protected static a a = new a(Uri.fromFile(new File(ReaderEnv.get().getDatabaseDirectory(), "localstorage.db")).toString());
    private static final ai b = new ai();
    private final Context c;
    private final HashMap d = new HashMap();

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
        this.c = context;
    }

    public static void a(Context context, ReaderEnv readerEnv) {
        b.a(new DkSharedStorageManager(context, readerEnv));
    }

    public static DkSharedStorageManager a() {
        return (DkSharedStorageManager) b.a();
    }

    public String a(String str) {
        Serializable a = a.a(str);
        return a == null ? "" : (String) a;
    }

    public void a(String str, String str2, boolean z) {
        try {
            SharedKey value = SharedKey.value(str);
            Serializable a = a.a(str);
            if ((a == null || !TextUtils.equals(str2, (String) a)) && !a(str2, (String) a)) {
                a(value, (Serializable) str2);
            }
        } catch (Exception e) {
        }
        if (z) {
            a.c(str, (Serializable) str2);
        } else {
            a.b(str, (Serializable) str2);
        }
    }

    public void b(String str) {
        try {
            c(SharedKey.value(str));
        } catch (Exception e) {
        }
        a.b(str);
    }

    public String a(SharedKey sharedKey) {
        try {
            return a(sharedKey.mUrl);
        } catch (Exception e) {
            return "";
        }
    }

    public void a(SharedKey sharedKey, String str, boolean z) {
        try {
            a(sharedKey.mUrl, str, z);
        } catch (Exception e) {
        }
    }

    public void b(SharedKey sharedKey) {
        try {
            b(sharedKey.mUrl);
        } catch (Exception e) {
        }
    }

    public void a(av avVar, SharedKey... sharedKeyArr) {
        for (SharedKey a : sharedKeyArr) {
            a(a, avVar);
        }
    }

    private boolean a(String str, String str2) {
        try {
            return new JSONObject(str).optJSONObject("__data__").equals(new JSONObject(str2).optJSONObject("__data__"));
        } catch (Exception e) {
            return false;
        }
    }

    private void a(SharedKey sharedKey, Serializable serializable) {
        List list = (List) this.d.get(sharedKey);
        if (list != null) {
            TaskHandler.postTask(new at(this, list, sharedKey, serializable));
        }
    }

    private void c(SharedKey sharedKey) {
        List list = (List) this.d.get(sharedKey);
        if (list != null) {
            TaskHandler.postTask(new au(this, list, sharedKey));
        }
    }

    private void a(SharedKey sharedKey, av avVar) {
        List list = (List) this.d.get(sharedKey);
        if (list == null) {
            list = new LinkedList();
            this.d.put(sharedKey, list);
        }
        list.add(avVar);
    }
}
