package com.duokan.reader.ui.welcome;

import android.content.Context;
import com.duokan.p023b.C0247i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ap;

/* renamed from: com.duokan.reader.ui.welcome.r */
public final class C1557r extends ap {
    /* renamed from: a */
    private final int f11627a = addCheckBoxView(C0247i.welcome__web_access_view__dont_show_again);

    public C1557r(Context context) {
        super(context);
        setTitle(C0247i.welcome__web_access_view__title);
        setPrompt(C0247i.welcome__web_access_view__prompt);
        setNoLabel(C0247i.welcome__web_access_view__cancel);
        setOkLabelResid(C0247i.welcome__web_access_view__ok);
        setChecked(this.f11627a, true);
        setCancelOnBack(false);
        setCancelOnTouchOutside(false);
    }

    /* renamed from: a */
    public boolean m15584a() {
        return !isChecked(this.f11627a);
    }

    protected void onOk() {
        DkApp.get().setWebAccessConfirmed(true);
        if (m15584a()) {
            DkApp.get().setWebAccessConfirmed(false);
        }
    }

    public void onNo() {
        getActivity().finish();
    }
}
