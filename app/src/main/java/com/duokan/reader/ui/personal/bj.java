package com.duokan.reader.ui.personal;

import android.text.TextUtils;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.common.webservices.duokan.DkFeedbackThreadInfo;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.domain.account.a;
import com.duokan.reader.domain.account.h;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.cloud.DkSharedStorageManager;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.DkWebListView.ListState;
import com.duokan.reader.ui.general.dk;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class bj extends ActivatedController implements ae, h {
    private final DkWebListView a;
    private final Map b = new HashMap();
    private final List c = new ArrayList();
    private a d;
    private boolean e = false;

    public bj(IFeature featrue) {
        super(featrue);
        if (i.f().b()) {
            this.d = i.f().c();
        }
        this.a = new DkWebListView(getContext());
        this.a.setBackgroundColor(-1);
        setContentView(this.a);
        this.a.setAdapter(new bk(this));
        this.a.setRowDivider(new dk(getResources().getColor(d.general__shared__cccccc)));
        this.a.a(UTools.closeAnimation(getContext(), 15.0f), 0, UTools.closeAnimation(getContext(), 15.0f), UTools.closeAnimation(getContext(), 60.0f));
        this.a.b(0, 0, 0, 0);
        c();
        a();
        com.duokan.reader.common.d.a().c();
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        i.f().a((h) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        i.f().b((h) this);
    }

    public void a(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        if (this.d != null) {
            this.c.add(0, dkFeedbackThreadInfo);
            this.b.put(dkFeedbackThreadInfo.mThreadId, Integer.valueOf(dkFeedbackThreadInfo.mReplyCount));
            DkSharedStorageManager.a().a("read_threads_" + this.d.b(), new JSONObject(this.b).toString(), true);
            if (this.a.getAdapter().l() == ListState.EMPTY) {
                this.a.getAdapter().a(false);
            } else {
                this.a.getAdapter().d();
            }
        }
    }

    public void b(DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        this.c.remove(dkFeedbackThreadInfo);
        if (this.a.getAdapter().c() == 0) {
            this.a.getAdapter().a(false);
        } else {
            this.a.getAdapter().d();
        }
    }

    public void a(int i) {
        a(i, (DkFeedbackThreadInfo) this.c.get(i));
    }

    public void a() {
        this.a.a();
    }

    private void a(int i, DkFeedbackThreadInfo dkFeedbackThreadInfo) {
        new bm(this, dkFeedbackThreadInfo, i).open();
    }

    private void b() {
        if (this.d != null) {
            new bn(this).open();
        } else {
            this.a.getAdapter().a(false);
        }
    }

    private void c() {
        try {
            if (this.d != null) {
                String a = DkSharedStorageManager.a().a("read_threads_" + this.d.b());
                if (TextUtils.isEmpty(a)) {
                    a = DkSharedStorageManager.a().a("read_threads");
                    DkSharedStorageManager.a().a("read_threads_" + this.d.b(), a, true);
                    this.e = true;
                }
                JSONObject jSONObject = new JSONObject(a);
                Iterator keys = jSONObject.keys();
                while (keys.hasNext()) {
                    a = (String) keys.next();
                    this.b.put(a, Integer.valueOf(jSONObject.getInt(a)));
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(a aVar) {
    }

    public void b(a aVar) {
        this.d = aVar;
        c();
        a();
    }

    public void c(a aVar) {
        this.d = null;
        this.c.clear();
        a();
    }

    public void d(a aVar) {
    }
}
