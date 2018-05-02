package com.duokan.reader.ui.personal;

import android.widget.TextView;

import com.duokan.c.h;
import com.duokan.c.j;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.ui.UTools;
import com.duokan.reader.common.webservices.duokan.ae;
import com.duokan.reader.ui.general.DkWebListView;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.dk;
import com.duokan.reader.ui.general.eo;

import java.util.ArrayList;
import java.util.List;

public class bo extends ActivatedController {
    private final DkWebListView a;
    private final List b = new ArrayList();
    private final eo c;
    private final String d;
    private final int e;
    private final ae f;
    private String g;

    public bo(IFeature featrue, String str, int i, ae aeVar) {
        super(featrue);
        setContentView(h.personal__feedback_thread_view);
        ((HeaderView) findViewById(g.personal__feedback_thread_view__header)).setLeftTitle(j.personal__feedback_thread_view__title);
        ((TextView) findViewById(g.personal__feedback_thread_view__reply)).setOnClickListener(new bp(this));
        this.a = (DkWebListView) findViewById(g.personal__feedback_thread_view__replies);
        this.a.setAdapter(new bq(this));
        this.a.setRowDivider(new dk(getResources().getColor(d.general__shared__cccccc)));
        this.a.setBackgroundColor(-1);
        this.a.a(UTools.getMinimumHeight(getContext(), 15.0f), 0, UTools.getMinimumHeight(getContext(), 15.0f), 0);
        this.a.b(0, 0, 0, 0);
        this.c = new eo(getContext());
        this.d = str;
        this.e = i;
        this.f = aeVar;
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        if (z) {
            this.a.a();
        }
    }

    private void a(int i) {
        new bs(this, i).open();
    }

    private void a(String str) {
        new bu(this, getContext(), str).show();
    }
}
