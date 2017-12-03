package com.duokan.reader.ui.account;

import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.common.i;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.account.oauth.ThirdOAuth;
import com.duokan.reader.domain.account.oauth.TokenStore;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.general.ia;

public class z extends ActivatedController {
    private final TokenStore a = TokenStore.getInstance();
    private TextView b;
    private TextView c;
    private LinearLayout d;
    private LinearLayout e;
    private ThirdOAuth f;

    public z(IFeature featrue) {
        super(featrue);
        setContentView(h.account__share_account_view);
        ((HeaderView) findViewById(g.account__share_account_view__header)).setLeftTitle(j.account__account_view__third_part_accounts);
        this.d = (LinearLayout) findViewById(g.account_sina_ll);
        this.e = (LinearLayout) findViewById(g.account_yingxiang_ll);
        this.b = (TextView) findViewById(g.personal__personal_settings_view__account_sina_text);
        this.c = (TextView) findViewById(g.account_yingxiang);
        this.d.setOnClickListener(new ah());
        this.e.setOnClickListener(new ah());
        findViewById(g.personal__personal_settings_view__sync_evernote).setOnClickListener(new aa(this));
        findViewById(g.personal__personal_settings_view__wifi_sync_evernote).setOnClickListener(new ac(this));
        findViewById(g.personal__account_cmreader_ll).setOnClickListener(new ad(this));
        a();
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        b();
    }

    protected void onDetachFromStub() {
        if (this.f != null) {
            this.f.onDeactive();
        }
    }

    private void a() {
        findViewById(g.personal__personal_settings_view__sync_evernote).setSelected(ReaderEnv.get().getSyncEvernoteEnabled());
        findViewById(g.personal__personal_settings_view__wifi_sync_evernote).setSelected(ReaderEnv.get().getIsOnlyWifiSyncEvernote());
    }

    private void a(String str) {
        ia iaVar = new ia(getContext());
        iaVar.b(j.share_no_bind);
        if (!this.a.canAccessTokenSyncToCloud(str)) {
            iaVar.b(j.share_change_account);
        }
        iaVar.a(new ae(this, str));
        iaVar.show();
    }

    private void b(String str) {
        if (i.a(getContext())) {
            if (this.f != null) {
                this.f.onDeactive();
            }
            this.f = ThirdOAuth.produceThird(getActivity(), str);
            this.f.onActive();
            if (TextUtils.equals("yinxiang", str) || TextUtils.equals("evernote", str)) {
                this.a.unbindAccessToken(getContext(), "evernote", null);
                this.a.unbindAccessToken(getContext(), "yinxiang", null);
                b();
            }
            this.f.oauth(new ag(this));
            return;
        }
        be.a(getContext(), getContext().getString(j.report_no_network_error), 0).show();
    }

    private void b() {
        if (this.a.isBindAccessToken(getContext(), "sina")) {
            this.b.setText(this.a.getUserName(getContext(), "sina"));
        } else {
            this.b.setText(getContext().getString(j.account_bind_sina));
        }
        if (this.a.isBindAccessToken(getContext(), "yinxiang")) {
            this.c.setText(this.a.getUserName(getContext(), "yinxiang"));
        } else if (this.a.isBindAccessToken(getContext(), "evernote")) {
            this.c.setText(this.a.getUserName(getContext(), "evernote"));
        } else {
            this.c.setText(getContext().getString(j.account_bind_yingxiang));
        }
    }
}
