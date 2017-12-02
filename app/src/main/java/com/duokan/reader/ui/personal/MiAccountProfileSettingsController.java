package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.duokan.core.app.y;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.bh;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.bf;
import com.duokan.reader.ui.general.web.StorePageController;
import com.duokan.reader.ui.s;

public class MiAccountProfileSettingsController extends my {
    private final HeaderView a = ((HeaderView) findViewById(g.personal__miaccount_profile_settings_view__header));
    private final DkLabelView c;
    private final bf d;
    private final View e;
    private final DkLabelView f;
    private final View g;
    private final DkLabelView h;
    private final View i;
    private final DkLabelView j;
    private final DkLabelView k;
    private final View l;
    private final View m;
    private final View n;
    private final View o;
    private final View p;
    private h q;
    private da r;

    class ChangePasswordController extends StorePageController {
        public ChangePasswordController(y yVar) {
            super(yVar);
            setPageTitleLeft(true);
            setPageTitle(getString(j.personal__miaccount_change_password_view__title));
        }

        protected boolean onBack() {
            requestDetach();
            return true;
        }
    }

    public MiAccountProfileSettingsController(y yVar) {
        super(yVar, true);
        setContentView(com.duokan.c.h.personal__miaccount_profile_settings_view);
        this.a.setLeftTitle(j.personal__miaccount_profile_settings_view__title);
        this.m = findViewById(g.personal__personal_settings_view__mi_milicenter);
        this.m.setOnClickListener(new di(this));
        this.c = (DkLabelView) findViewById(g.personal__miaccount_profile_settings_view__user_id);
        this.d = (bf) findViewById(g.personal__miaccount_profile_settings_view__avatar);
        this.d.setOnClickListener(new dj(this));
        this.e = findViewById(g.personal__miaccount_profile_settings_view__nickname_container);
        this.e.setOnClickListener(new dk(this));
        this.f = (DkLabelView) findViewById(g.personal__miaccount_profile_settings_view__user_name_text);
        this.p = findViewById(g.personal__miaccount_profile_settings_view__user_name_next);
        this.g = findViewById(g.personal__miaccount_profile_settings_view__email_container);
        this.h = (DkLabelView) findViewById(g.personal__miaccount_profile_settings_view__email);
        this.i = findViewById(g.personal__miaccount_profile_settings_view__phone_container);
        this.j = (DkLabelView) findViewById(g.personal__miaccount_profile_settings_view__phone);
        this.k = (DkLabelView) findViewById(g.personal__miaccount_profile_settings_view__signature);
        findViewById(g.personal__miaccount_profile_settings_view__signature_container).setOnClickListener(new dl(this));
        this.l = findViewById(g.personal__miaccount_profile_settings_view__change_password);
        this.l.setOnClickListener(new dm(this));
        this.n = findViewById(g.personal__personal_settings_view__mi_milicenter_container);
        this.o = findViewById(g.personal__miaccount_profile_settings_view__change_password_container);
        this.q = new dn(this);
        i.f().a(this.q);
        b();
        c();
        a b = i.f().b(PersonalAccount.class);
        b.a(getActivity(), new do(this));
        findViewById(g.personal__personal_settings_view__logoff_container).setOnClickListener(new dp(this, b));
        s sVar = (s) getContext().queryFeature(s.class);
        findViewById(g.personal__miaccount_profile_settings_view__scrollerview).setPadding(0, 0, 0, sVar == null ? 0 : sVar.getTheme().getPagePaddingBottom());
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        b();
        c();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        i.f().b(this.q);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.r != null) {
            this.r.a(i, i2, intent);
        }
    }

    private void a() {
        if (this.r == null) {
            this.r = new da(getActivity());
        }
        this.r.a(new dr(this));
    }

    private void b() {
        UserAccount c = i.f().c();
        User user = c.s().a;
        this.c.setText(user.mUserId);
        this.f.setText(user.mNickName);
        this.k.setText(c.s().b.i);
        AccountType e = c.e();
        if (AccountType.XIAO_MI.equals(e)) {
            bh bhVar = (bh) c.f();
            this.h.setText(bhVar.c);
            if (TextUtils.isEmpty(bhVar.c)) {
                this.g.setVisibility(8);
            }
            this.j.setText(bhVar.d);
            if (TextUtils.isEmpty(bhVar.d)) {
                this.i.setVisibility(8);
            }
            this.p.setVisibility(0);
        } else if (AccountType.XIAOMI_GUEST.equals(e)) {
            this.n.setVisibility(8);
            this.g.setVisibility(8);
            this.i.setVisibility(8);
            this.o.setVisibility(8);
            this.d.setClickable(false);
            this.e.setClickable(false);
            this.p.setVisibility(8);
        }
    }

    private void c() {
        this.d.setMiAccount(i.f().c());
    }
}
