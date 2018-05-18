package com.duokan.reader.ui.account;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.duokan.common.CommonUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.hp;

/* renamed from: com.duokan.reader.ui.account.m */
public class C1261m extends ActivatedController {
    /* renamed from: a */
    private final TokenStore f5963a = TokenStore.getInstance();
    /* renamed from: b */
    private TextView f5964b;
    /* renamed from: c */
    private TextView f5965c;
    /* renamed from: d */
    private LinearLayout f5966d;
    /* renamed from: e */
    private LinearLayout f5967e;
    /* renamed from: f */
    private ThirdOAuth f5968f;

    public C1261m(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.account__share_account_view);
        ((HeaderView) findViewById(C0255g.account__share_account_view__header)).setLeftTitle(C0258j.account__account_view__third_part_accounts);
        this.f5966d = (LinearLayout) findViewById(C0255g.account_sina_ll);
        this.f5967e = (LinearLayout) findViewById(C0255g.account_yingxiang_ll);
        this.f5964b = (TextView) findViewById(C0255g.personal__personal_settings_view__account_sina_text);
        this.f5965c = (TextView) findViewById(C0255g.account_yingxiang);
        this.f5966d.setOnClickListener(new C1269u());
        this.f5967e.setOnClickListener(new C1269u());
        findViewById(C0255g.personal__personal_settings_view__sync_evernote).setOnClickListener(new C1262n(this));
        findViewById(C0255g.personal__personal_settings_view__wifi_sync_evernote).setOnClickListener(new C1264p(this));
        findViewById(C0255g.personal__account_cmreader_ll).setOnClickListener(new C1265q(this));
        m9003a();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        m9007b();
    }

    protected void onDetachFromStub() {
        if (this.f5968f != null) {
            this.f5968f.onDeactive();
        }
    }

    /* renamed from: a */
    private void m9003a() {
        findViewById(C0255g.personal__personal_settings_view__sync_evernote).setSelected(ReaderEnv.get().getSyncEvernoteEnabled());
        findViewById(C0255g.personal__personal_settings_view__wifi_sync_evernote).setSelected(ReaderEnv.get().getIsOnlyWifiSyncEvernote());
    }

    /* renamed from: a */
    private void m9006a(String str) {
        hp hpVar = new hp(getContext());
        hpVar.m9769b(C0258j.share_no_bind);
        if (!this.f5963a.canAccessTokenSyncToCloud(str)) {
            hpVar.m9769b(C0258j.share_change_account);
        }
        hpVar.m9767a(new C1266r(this, str));
        hpVar.show();
    }

    /* renamed from: b */
    private void m9010b(String str) {
        if (CommonUtils.m604a(getContext())) {
            if (this.f5968f != null) {
                this.f5968f.onDeactive();
            }
            this.f5968f = ThirdOAuth.produceThird(getActivity(), str);
            this.f5968f.onActive();
            if (TextUtils.equals("yinxiang", str) || TextUtils.equals("evernote", str)) {
                this.f5963a.unbindAccessToken(getContext(), "evernote", null);
                this.f5963a.unbindAccessToken(getContext(), "yinxiang", null);
                m9007b();
            }
            this.f5968f.oauth(new C1268t(this));
            return;
        }
        be.m10287a(getContext(), getContext().getString(C0258j.report_no_network_error), 0).show();
    }

    /* renamed from: b */
    private void m9007b() {
        if (this.f5963a.isBindAccessToken(getContext(), "weibo")) {
            this.f5964b.setText(this.f5963a.getUserName(getContext(), "weibo"));
        } else {
            this.f5964b.setText(getContext().getString(C0258j.account_bind_sina));
        }
        if (this.f5963a.isBindAccessToken(getContext(), "yinxiang")) {
            this.f5965c.setText(this.f5963a.getUserName(getContext(), "yinxiang"));
        } else if (this.f5963a.isBindAccessToken(getContext(), "evernote")) {
            this.f5965c.setText(this.f5963a.getUserName(getContext(), "evernote"));
        } else {
            this.f5965c.setText(getContext().getString(C0258j.account_bind_yingxiang));
        }
    }
}
