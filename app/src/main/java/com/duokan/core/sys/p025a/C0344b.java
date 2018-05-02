package com.duokan.core.sys.p025a;

import android.content.Context;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.core.sys.a.b */
public class C0344b extends ap {
    /* renamed from: a */
    private final IPermissionsResultListener f613a;
    /* renamed from: b */
    private final C0340e f614b;

    public C0344b(Context context, C0340e c0340e, IPermissionsResultListener rermissionsResult) {
        super(context);
        this.f613a = rermissionsResult;
        this.f614b = c0340e;
        setTitle(C0247i.welcome__web_access_view__title);
        setPrompt(c0340e.mo400b());
        setNoLabel(C0247i.welcome__web_access_view__cancel);
        setOkLabelResid(C0247i.welcome__web_access_view__ok);
        setCancelOnBack(false);
        setCancelOnTouchOutside(false);
    }

    /* renamed from: a */
    public void m829a() {
        show();
    }

    protected void onOk() {
        this.f614b.mo401e();
        this.f613a.onSuccess();
    }

    protected void onNo() {
        this.f613a.onFail();
    }
}
