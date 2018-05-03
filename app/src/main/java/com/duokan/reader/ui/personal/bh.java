package com.duokan.reader.ui.personal;

import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.webservices.duokan.C0643q;
import com.duokan.reader.common.webservices.duokan.DkFeedbackReply;
import com.duokan.reader.common.webservices.duokan.ad;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.em;
import java.util.ArrayList;
import java.util.List;

public class bh extends ActivatedController {
    /* renamed from: a */
    private final DkWebListView f8320a;
    /* renamed from: b */
    private final List<DkFeedbackReply> f8321b = new ArrayList();
    /* renamed from: c */
    private final em f8322c;
    /* renamed from: d */
    private final String f8323d;
    /* renamed from: e */
    private final int f8324e;
    /* renamed from: f */
    private final ad f8325f;
    /* renamed from: g */
    private String f8326g;

    public bh(IFeature mFeature, String str, int i, ad adVar) {
        super(mFeature);
        setContentView(C0256h.personal__feedback_thread_view);
        ((HeaderView) findViewById(C0255g.personal__feedback_thread_view__header)).setLeftTitle(C0258j.personal__feedback_thread_view__title);
        ((TextView) findViewById(C0255g.personal__feedback_thread_view__reply)).setOnClickListener(new bi(this));
        this.f8320a = (DkWebListView) findViewById(C0255g.personal__feedback_thread_view__replies);
        this.f8320a.setAdapter(new bj(this));
        this.f8320a.setRowDivider(new dk(getResources().getColor(C0252d.general__shared__cccccc)));
        this.f8320a.setBackgroundColor(-1);
        this.f8320a.m9955a(AnimUtils.m1932b(getContext(), 15.0f), 0, AnimUtils.m1932b(getContext(), 15.0f), 0);
        this.f8320a.m9962b(0, 0, 0, 0);
        this.f8322c = new em(getContext());
        this.f8323d = str;
        this.f8324e = i;
        this.f8325f = adVar;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.f8320a.m9954a();
        }
    }

    /* renamed from: a */
    private void m11456a(int i) {
        new bl(this, C0643q.f2173a, i).open();
    }

    /* renamed from: a */
    private void m11459a(String str) {
        new bn(this, getContext(), str).show();
    }
}
