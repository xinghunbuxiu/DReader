package com.duokan.reader.ui.personal;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.AccountType;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.PersonalAccount;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.bd;
import com.duokan.reader.ui.C0435s;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.bf;
import com.duokan.reader.ui.general.web.StorePageController;

public class MiAccountProfileSettingsController extends nm {
    /* renamed from: a */
    private final HeaderView f8206a = ((HeaderView) findViewById(C0255g.personal__miaccount_profile_settings_view__header));
    /* renamed from: c */
    private final DkLabelView f8207c;
    /* renamed from: d */
    private final bf f8208d;
    /* renamed from: e */
    private final View f8209e;
    /* renamed from: f */
    private final DkLabelView f8210f;
    /* renamed from: g */
    private final View f8211g;
    /* renamed from: h */
    private final DkLabelView f8212h;
    /* renamed from: i */
    private final View f8213i;
    /* renamed from: j */
    private final DkLabelView f8214j;
    /* renamed from: k */
    private final DkLabelView f8215k;
    /* renamed from: l */
    private final View f8216l;
    /* renamed from: m */
    private final View f8217m;
    /* renamed from: n */
    private final View f8218n;
    /* renamed from: o */
    private final View f8219o;
    /* renamed from: p */
    private final View f8220p;
    /* renamed from: q */
    private C0586j f8221q;
    /* renamed from: r */
    private ct f8222r;

    class ChangePasswordController extends StorePageController {
        public ChangePasswordController(IFeature mFeature) {
            super(mFeature);
            setPageTitleLeft(true);
            setPageTitle(getString(C0258j.personal__miaccount_change_password_view__title));
        }

        protected boolean onBack() {
            requestDetach();
            return true;
        }
    }

    public MiAccountProfileSettingsController(IFeature mFeature) {
        super(mFeature, true);
        setContentView(C0256h.personal__miaccount_profile_settings_view);
        this.f8206a.setLeftTitle(C0258j.personal__miaccount_profile_settings_view__title);
        this.f8217m = findViewById(C0255g.personal__personal_settings_view__mi_milicenter);
        this.f8217m.setOnClickListener(new dc(this));
        this.f8207c = (DkLabelView) findViewById(C0255g.personal__miaccount_profile_settings_view__user_id);
        this.f8208d = (bf) findViewById(C0255g.personal__miaccount_profile_settings_view__avatar);
        this.f8208d.setOnClickListener(new dd(this));
        this.f8209e = findViewById(C0255g.personal__miaccount_profile_settings_view__nickname_container);
        this.f8209e.setOnClickListener(new de(this));
        this.f8210f = (DkLabelView) findViewById(C0255g.personal__miaccount_profile_settings_view__user_name_text);
        this.f8220p = findViewById(C0255g.personal__miaccount_profile_settings_view__user_name_next);
        this.f8211g = findViewById(C0255g.personal__miaccount_profile_settings_view__email_container);
        this.f8212h = (DkLabelView) findViewById(C0255g.personal__miaccount_profile_settings_view__email);
        this.f8213i = findViewById(C0255g.personal__miaccount_profile_settings_view__phone_container);
        this.f8214j = (DkLabelView) findViewById(C0255g.personal__miaccount_profile_settings_view__phone);
        this.f8215k = (DkLabelView) findViewById(C0255g.personal__miaccount_profile_settings_view__signature);
        findViewById(C0255g.personal__miaccount_profile_settings_view__signature_container).setOnClickListener(new df(this));
        this.f8216l = findViewById(C0255g.personal__miaccount_profile_settings_view__change_password);
        this.f8216l.setOnClickListener(new dg(this));
        this.f8218n = findViewById(C0255g.personal__personal_settings_view__mi_milicenter_container);
        this.f8219o = findViewById(C0255g.f412xd20dc6f);
        this.f8221q = new dh(this);
        C0709k.m3476a().m3494a(this.f8221q);
        m11353b();
        m11355c();
        C0672a b = C0709k.m3476a().m3502b(PersonalAccount.class);
        b.mo829a(getActivity(), new di(this));
        findViewById(C0255g.personal__personal_settings_view__logoff_container).setOnClickListener(new dj(this, b));
        C0435s c0435s = (C0435s) getContext().queryFeature(C0435s.class);
        findViewById(C0255g.personal__miaccount_profile_settings_view__scrollerview).setPadding(0, 0, 0, c0435s == null ? 0 : c0435s.getTheme().getPagePaddingBottom());
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        m11353b();
        m11355c();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0709k.m3476a().m3505b(this.f8221q);
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.f8222r != null) {
            this.f8222r.m11639a(i, i2, intent);
        }
    }

    /* renamed from: a */
    private void m11351a() {
        if (this.f8222r == null) {
            this.f8222r = new ct(getActivity());
        }
        this.f8222r.m11640a(new dl(this));
    }

    /* renamed from: b */
    private void m11353b() {
        UserAccount d = C0709k.m3476a().m3508d();
        User user = d.mo849s().f5458a;
        this.f8207c.setText(user.mUserId);
        this.f8210f.setText(user.mNickName);
        this.f8215k.setText(d.mo849s().f5459b.f5468i);
        AccountType e = d.mo835e();
        if (AccountType.XIAO_MI.equals(e)) {
            bd bdVar = (bd) d.mo836f();
            this.f8212h.setText(bdVar.f2403c);
            if (TextUtils.isEmpty(bdVar.f2403c)) {
                this.f8211g.setVisibility(8);
            }
            this.f8214j.setText(bdVar.f2404d);
            if (TextUtils.isEmpty(bdVar.f2404d)) {
                this.f8213i.setVisibility(8);
            }
            this.f8220p.setVisibility(0);
        } else if (AccountType.XIAOMI_GUEST.equals(e)) {
            this.f8218n.setVisibility(8);
            this.f8211g.setVisibility(8);
            this.f8213i.setVisibility(8);
            this.f8219o.setVisibility(8);
            this.f8208d.setClickable(false);
            this.f8209e.setClickable(false);
            this.f8220p.setVisibility(8);
        }
    }

    /* renamed from: c */
    private void m11355c() {
        this.f8208d.setMiAccount(C0709k.m3476a().m3508d());
    }
}
