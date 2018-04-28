package com.duokan.reader.domain.micloud;

import android.content.Context;
import cn.kuaipan.android.exception.KscException;
import com.duokan.reader.common.C0564c;
import com.google.android.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.util.Map;

public class ay extends C0564c {
    /* renamed from: a */
    private static Map<Class<?>, Integer> f5206a = Maps.newHashMap();
    /* renamed from: b */
    private static Map<Class<?>, Integer> f5207b = Maps.newHashMap();
    /* renamed from: c */
    private static Map<Class<?>, Integer> f5208c = Maps.newHashMap();

    static {
        f5207b.put(IOException.class, Integer.valueOf(-10003));
        f5208c.put(IOException.class, Integer.valueOf(-20001));
    }

    /* renamed from: a */
    public static int m8101a(Exception exception) {
        Class cls;
        for (cls = exception.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            Integer num = (Integer) f5207b.get(exception.getClass());
            if (num != null) {
                return num.intValue();
            }
        }
        for (cls = exception.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            num = (Integer) f5206a.get(exception.getClass());
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* renamed from: b */
    public static int m8102b(Exception exception) {
        Class cls;
        for (cls = exception.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            Integer num = (Integer) f5208c.get(exception.getClass());
            if (num != null) {
                return num.intValue();
            }
        }
        for (cls = exception.getClass(); cls != Object.class; cls = cls.getSuperclass()) {
            num = (Integer) f5206a.get(exception.getClass());
            if (num != null) {
                return num.intValue();
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static int m8100a(Context context, File file, KscException kscException) {
        switch (kscException.getErrorCode()) {
            case 200000:
            case 220011:
            case 220056:
            case 220057:
            case 220058:
            case 220059:
            case 220060:
            case 220061:
            case 220208:
            case 240019:
            case 240401:
            case 403002:
                return -30004;
            case 220010:
            case 220211:
            case 250701:
                return -30006;
            case 220015:
            case 220210:
            case 241301:
                return -30009;
            case 220214:
                return -30007;
            case 403000:
            case 403003:
            case 403004:
            case 500004:
                return -30010;
            case 403001:
                return -30002;
            case 500005:
                return -30008;
            case 504000:
            case 504022:
            case 504101:
            case 504110:
            case 504111:
            case 504113:
            case 504400:
            case 504500:
            case 504501:
                return -30003;
            default:
                return -30001;
        }
    }

    /* renamed from: a */
    public static int m8099a(Context context, KscException kscException) {
        switch (kscException.getErrorCode()) {
            case 220011:
            case 220208:
            case 240019:
            case 240401:
                return -30011;
            case 220214:
                return -30007;
            case 403000:
            case 403001:
            case 403003:
            case 403004:
            case 500004:
                return -30010;
            case 500005:
                return -30008;
            case 504000:
            case 504022:
            case 504101:
            case 504110:
            case 504111:
            case 504113:
            case 504400:
            case 504500:
            case 504501:
                return -30003;
            default:
                return -30001;
        }
    }
}
