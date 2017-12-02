package com.duokan.reader.ui.welcome;

import android.content.Context;

import com.duokan.b.i;
import com.duokan.reader.DkApp;
import com.duokan.reader.ui.general.ap;

public final class r extends ap {
    private final int a = addCheckBoxView(i.welcome__web_access_view__dont_show_again);

    public r(Context context) {
        super(context);
        setTitle(i.welcome__web_access_view__title);
        setPrompt(i.welcome__web_access_view__prompt);
        setNoLabel(i.welcome__web_access_view__cancel);
        setOkLabel(i.welcome__web_access_view__ok);
        setChecked(this.a, true);
        setCancelOnBack(false);
        setCancelOnTouchOutside(false);
    }

    public boolean a() {
        return !isChecked(this.a);
    }

    protected void onOk() {
        DkApp.get().setWebAccessConfirmed(true);
        if (a()) {
            DkApp.get().setWebAccessConfirmed(false);
        }
    }

    public void onNo() {
        getActivity().finish();
    }
}
