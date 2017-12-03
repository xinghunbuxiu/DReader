package com.duokan.reader.domain.account;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.b.b;
import com.duokan.b.c;
import com.duokan.b.e;
import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.ui.BoxView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ui.general.ak;
import com.duokan.reader.ui.general.hm;

import java.util.List;

public class w extends ak {
    private final b a;

    public w(Context context, String str, List list, b bVar) {
        super(context);
        setContentView(g.account__choose_login_dialog);
        if (ReaderEnv.get().forHd()) {
            setGravity(17);
            ((BoxView) getContentView()).setMaxWidth(UTools.closeAnimation(getContext(), 380.0f));
        } else {
            setGravity(80);
        }
        a();
        PersonalAccount personalAccount = (PersonalAccount) i.f().b(PersonalAccount.class);
        LinearLayout linearLayout = (LinearLayout) findViewById(f.account__choose_login_dialog__container);
        if (!TextUtils.isEmpty(str)) {
            ((TextView) findViewById(f.account__choose_login_dialog__title)).setText(str);
        }
        View view = null;
        for (String str2 : list) {
            View a;
            if (TextUtils.equals("MI_SYSTEM", str2)) {
                a = a(context.getString(i.account__choose_login_dialog__system), context.getResources().getColor(c.general__shared__c1));
                a.setOnClickListener(new x(this, personalAccount, bVar));
                a.setText(String.format(context.getString(i.account__choose_login_dialog__system), new Object[]{MiAccount.b(context).name}));
            } else if (TextUtils.equals("MI_LOCAL", str2)) {
                a = a(context.getString(i.account__choose_login_dialog__local), context.getResources().getColor(c.general__shared__c6));
                a.setOnClickListener(new y(this, personalAccount, bVar));
                if (list.contains("MI_SYSTEM")) {
                    a.setText(i.account__choose_login_dialog__local);
                } else {
                    a.setText(i.account__shared__mi_login);
                }
            } else if (TextUtils.equals("WX_LOGIN", str2)) {
                a = a(context.getString(i.account__choose_login_dialog__wx), context.getResources().getColor(c.general__shared__c6));
                a.setOnClickListener(new z(this, personalAccount, bVar));
            } else {
                a = view;
            }
            linearLayout.addView(a);
            view = a;
        }
        this.a = bVar;
        linearLayout.getChildAt(linearLayout.getChildCount() - 1).setBackgroundResource(e.general__shared__dialog_button_background_last);
    }

    protected boolean onTouchOutside() {
        if (this.a != null) {
            this.a.a(i.f().b(PersonalAccount.class), "");
        }
        return super.onTouchOutside();
    }

    private TextView a(String str, int i) {
        TextView textView = (TextView) LayoutInflater.from(getContext()).inflate(g.general__common_dialog_view__button, null);
        int b = UTools.closeAnimation(getContext(), 20.0f);
        textView.getPaint().setFakeBoldText(true);
        textView.setPadding(0, b, 0, b);
        textView.setBackgroundResource(e.general__shared__dialog_button_background);
        textView.setText(str);
        textView.setTextColor(i);
        return textView;
    }

    private void a() {
        int b = UTools.closeAnimation(getContext(), 8.0f);
        getContentView().setBackgroundDrawable(new hm(new ColorDrawable(getContext().getResources().getColor(c.general__shared__dialog)), (float) b));
        if (ReaderEnv.get().forHd()) {
            setEnterAnimation(b.general__shared__scale_center_in);
            setExitAnimation(b.general__shared__scale_center_out);
            return;
        }
        setEnterAnimation(b.general__shared__push_down_in);
        setExitAnimation(b.general__shared__push_down_out);
    }
}
