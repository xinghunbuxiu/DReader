package com.duokan.reader.domain.social.message;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.domain.account.C0709k;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.domain.social.message.h */
public class C1148h extends DkMessagesManager implements ai {
    /* renamed from: a */
    private static final int[] f5542a = new int[]{5, 10, 17, 19, 18};
    /* renamed from: b */
    private static final aj<C1148h> f5543b = new aj();

    private C1148h(Context context, C1153o c1153o, C0709k c0709k) {
        super(context, c1153o, c0709k, f5542a, "FeedMessagesCache", HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: a */
    public static void m8568a(Context context, C1153o c1153o, C0709k c0709k) {
        f5543b.m709a(new C1148h(context, c1153o, c0709k));
    }

    /* renamed from: a */
    public static C1148h m8567a() {
        return (C1148h) f5543b.m707a();
    }
}
