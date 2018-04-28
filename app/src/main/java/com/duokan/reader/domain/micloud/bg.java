package com.duokan.reader.domain.micloud;

import android.content.Context;
import com.duokan.reader.common.async.work.C0529q;
import com.duokan.reader.common.async.work.C0533k;
import java.util.concurrent.ThreadPoolExecutor;

public abstract class bg<TItem extends bf, TWork extends af<TItem>> extends C0533k<TItem, TWork> {
    /* renamed from: a */
    private final String f5185a;
    /* renamed from: b */
    private final String f5186b;

    public bg(Context context, String str, String str2, C0529q<TItem> c0529q, ThreadPoolExecutor threadPoolExecutor) {
        super(context, c0529q, threadPoolExecutor);
        this.f5185a = str;
        this.f5186b = str2;
    }

    /* renamed from: i */
    public final String m8041i() {
        return this.f5185a;
    }

    /* renamed from: j */
    public final String m8042j() {
        return this.f5186b;
    }
}
