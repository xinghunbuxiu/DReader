package com.duokan.reader.domain.account;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p023b.C0240b;
import com.duokan.p023b.C0241c;
import com.duokan.p023b.C0243e;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.hb;
import java.util.List;

public class ad extends ak {
    /* renamed from: a */
    private final C0420b f2350a;

    public ad(Context context, String str, List<String> list, C0420b c0420b) {
        super(context);
        setContentView(C0245g.account__choose_login_dialog);
        if (ReaderEnv.get().forHd()) {
            setGravity(17);
            ((BoxView) getContentView()).setMaxWidth(AnimUtils.m1932b(getContext(), 380.0f));
        } else {
            setGravity(80);
        }
        m3361a();
        PersonalAccount personalAccount = (PersonalAccount) C0709k.m3476a().m3502b(PersonalAccount.class);
        LinearLayout linearLayout = (LinearLayout) findViewById(C0244f.account__choose_login_dialog__container);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(C0244f.account__choose_login_dialog__title)).setText(str);
        }
        View view = null;
        for (String str2 : list) {
            View a;
            if (TextUtils.equals("MI_SYSTEM", str2)) {
                a = m3360a(context.getString(C0247i.account__choose_login_dialog__system), context.getResources().getColor(C0241c.general__shared__c1));
                a.setOnClickListener(new ae(this, c0420b));
                if (MiAccount.m3187c(context) == null) {
                    a.setText(context.getString(C0247i.account__shared__mi_login));
                } else {
                    a.setText(String.format(context.getString(C0247i.account__choose_login_dialog__system), new Object[]{r2.name}));
                }
            } else if (TextUtils.equals("MI_LOCAL", str2)) {
                a = m3360a(context.getString(C0247i.account__choose_login_dialog__local), context.getResources().getColor(C0241c.general__shared__c6));
                a.setOnClickListener(new af(this, c0420b));
                if (list.contains("MI_SYSTEM")) {
                    a.setText(C0247i.account__choose_login_dialog__local);
                } else {
                    a.setText(C0247i.account__shared__mi_login);
                }
            } else if (TextUtils.equals("WX_LOGIN", str2)) {
                a = m3360a(context.getString(C0247i.account__choose_login_dialog__wx), context.getResources().getColor(C0241c.general__shared__c6));
                a.setOnClickListener(new ag(this, c0420b));
            } else {
                a = view;
            }
            linearLayout.addView(a);
            view = a;
        }
        this.f2350a = c0420b;
        linearLayout.getChildAt(linearLayout.getChildCount() - 1).setBackgroundResource(C0243e.general__shared__dialog_button_background_last);
    }

    protected boolean onTouchOutside() {
        if (this.f2350a != null) {
            this.f2350a.onLoginError(C0709k.m3476a().m3502b(PersonalAccount.class), "");
        }
        return super.onTouchOutside();
    }

    /* renamed from: a */
    private TextView m3360a(String str, int i) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(C0245g.general__common_dialog_view__button, null);
        int b = AnimUtils.m1932b(getContext(), 20.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setPadding(0, b, 0, b);
        textView.setBackgroundResource(C0243e.general__shared__dialog_button_background);
        textView.setText(str);
        textView.setTextColor(i);
        return textView;
    }

    /* renamed from: a */
    private void m3361a() {
        int b = AnimUtils.m1932b(getContext(), 8.0f);
        getContentView().setBackgroundDrawable(new hb(new ColorDrawable(getContext().getResources().getColor(C0241c.general__shared__dialog)), (float) b));
        if (ReaderEnv.get().forHd()) {
            setEnterAnimation(C0240b.general__shared__scale_center_in);
            setExitAnimation(C0240b.general__shared__scale_center_out);
            return;
        }
        setEnterAnimation(C0240b.general__shared__push_down_in);
        setExitAnimation(C0240b.general__shared__push_down_out);
    }
}
