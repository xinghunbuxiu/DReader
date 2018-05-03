package com.duokan.reader.ui.personal;

import android.text.TextUtils;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.reader.common.C0590d;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.domain.account.C0586j;
import com.duokan.reader.domain.account.C0672a;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import com.duokan.reader.ui.general.dk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class bc extends ActivatedController implements ad, C0586j {
    /* renamed from: a */
    private final DkWebListView f8305a;
    /* renamed from: b */
    private final Map<String, Integer> f8306b = new HashMap();
    /* renamed from: c */
    private final List<DkFeedbackThreadInfo> f8307c = new ArrayList();
    /* renamed from: d */
    private C0672a f8308d;
    /* renamed from: e */
    private boolean f8309e = false;

    public bc(IFeature mFeature) {
        super(mFeature);
        if (C0709k.m3476a().m3507c()) {
            this.f8308d = C0709k.m3476a().m3508d();
        }
        this.f8305a = new DkWebListView(getContext());
        this.f8305a.setBackgroundColor(-1);
        setContentView(this.f8305a);
        this.f8305a.setAdapter(new bd(this));
        this.f8305a.setRowDivider(new dk(getResources().getColor(C0252d.general__shared__cccccc)));
        this.f8305a.m9955a(AnimUtils.m1932b(getContext(), 15.0f), 0, AnimUtils.m1932b(getContext(), 15.0f), AnimUtils.m1932b(getContext(), 60.0f));
        this.f8305a.m9962b(0, 0, 0, 0);
        m11440c();
        m11444a();
        C0590d.m2643a().m2656c();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        C0709k.m3476a().m3494a((C0586j) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C0709k.m3476a().m3505b((C0586j) this);
    }

    /* renamed from: a */
    public void mo1870a(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        if (this.f8308d != null) {
            this.f8307c.add(0, dkFeedbackThreadInfo);
            this.f8306b.put(dkFeedbackThreadInfo.mThreadId, Integer.valueOf(dkFeedbackThreadInfo.mReplyCount));
            DkSharedStorageManager.m5016a().m5026a("read_threads_" + this.f8308d.mo832b(), new JSONObject(this.f8306b).toString(), true);
            if (this.f8305a.getAdapter().m8789l() == ListState.EMPTY) {
                this.f8305a.getAdapter().m8785a(false);
            } else {
                this.f8305a.getAdapter().mo1691d();
            }
        }
    }

    /* renamed from: b */
    public void m11447b(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        this.f8307c.remove(dkFeedbackThreadInfo);
        if (this.f8305a.getAdapter().mo506c() == 0) {
            this.f8305a.getAdapter().m8785a(false);
        } else {
            this.f8305a.getAdapter().mo1691d();
        }
    }

    /* renamed from: a */
    public void mo1869a(int i) {
        m11436a(i, (DkFeedbackThreadInfo) this.f8307c.get(i));
    }

    /* renamed from: a */
    public void m11444a() {
        this.f8305a.m9954a();
    }

    /* renamed from: a */
    private void m11436a(int i, DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        new bf(this, C0643q.f2173a, dkFeedbackThreadInfo, i).open();
    }

    /* renamed from: b */
    private void m11437b() {
        if (this.f8308d != null) {
            new bg(this, C0643q.f2173a).open();
        } else {
            this.f8305a.getAdapter().m8785a(false);
        }
    }

    /* renamed from: c */
    private void m11440c() {
        try {
            if (this.f8308d != null) {
                String a = DkSharedStorageManager.m5016a().m5023a("read_threads_" + this.f8308d.mo832b());
                if (TextUtils.isEmpty(a)) {
                    a = DkSharedStorageManager.m5016a().m5023a("read_threads");
                    DkSharedStorageManager.m5016a().m5026a("read_threads_" + this.f8308d.mo832b(), a, true);
                    this.f8309e = true;
                }
                JSONObject jSONObject = new JSONObject(a);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    a = (String) keys.next();
                    this.f8306b.put(a, Integer.valueOf(jSONObject.getInt(a)));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void onAccountLoginedTopHalf(C0672a c0672a) {
    }

    public void onAccountLoginedBottomHalf(C0672a c0672a) {
        this.f8308d = c0672a;
        m11440c();
        m11444a();
    }

    public void onAccountLogoff(C0672a c0672a) {
        this.f8308d = null;
        this.f8307c.clear();
        m11444a();
    }

    public void onAccountDetailChanged(C0672a c0672a) {
    }
}
