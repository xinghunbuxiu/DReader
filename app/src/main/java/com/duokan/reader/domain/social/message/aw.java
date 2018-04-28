package com.duokan.reader.domain.social.message;

import android.content.Context;
import com.duokan.core.app.ai;
import com.duokan.core.app.aj;
import com.duokan.reader.domain.account.C0709k;
import org.apache.http.HttpStatus;

public class aw extends DkMessagesManager implements ai {
    /* renamed from: a */
    private static final int[] f5530a = new int[]{13};
    /* renamed from: b */
    private static final aj<aw> f5531b = new aj();

    private aw(Context context, C1153o c1153o, C0709k c0709k) {
        super(context, c1153o, c0709k, f5530a, "SystemMessagesCache", HttpStatus.SC_INTERNAL_SERVER_ERROR);
    }

    /* renamed from: a */
    public static void m8538a(Context context, C1153o c1153o, C0709k c0709k) {
        f5531b.m709a(new aw(context, c1153o, c0709k));
    }

    /* renamed from: a */
    public static aw m8537a() {
        return (aw) f5531b.m707a();
    }
}
