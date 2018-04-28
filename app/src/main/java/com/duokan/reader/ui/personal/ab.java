package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.duokan.common.C0267i;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.micloud.bj;

public class ab extends FrameLayout {
    /* renamed from: a */
    private final View f8240a;
    /* renamed from: b */
    private final View f8241b;
    /* renamed from: c */
    private final TextView f8242c;

    public ab(Context context) {
        this(context, null);
    }

    public ab(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(C0245g.bookshelf__cloud_storage_space_stats_view, this, true);
        this.f8240a = findViewById(C0244f.bookshelf__cloud_storage_space_stats_view__querying);
        this.f8241b = findViewById(C0244f.bookshelf__cloud_storage_space_stats_view__storage_quota);
        this.f8242c = (TextView) this.f8241b.findViewById(C0244f.bookshelf__cloud_storage_space_stats_view__storage_quota_tips);
    }

    /* renamed from: a */
    public void m11374a(bj bjVar, long j) {
        double d = 0.0d;
        if (bjVar == null || bjVar.f5251a <= 0) {
            this.f8240a.setVisibility(0);
            this.f8241b.setVisibility(4);
            return;
        }
        this.f8240a.setVisibility(4);
        this.f8241b.setVisibility(0);
        double d2 = (((double) (bjVar.f5251a - bjVar.f5252b)) * 100.0d) / ((double) bjVar.f5251a);
        if (d2 >= 0.0d) {
            d = d2;
        }
        d = Math.floor(d * 10.0d) / 10.0d;
        this.f8242c.setText(getResources().getString(C0247i.bookshelf__upload_books_view__storage_quota_used, new Object[]{C0267i.m599a(bjVar.f5251a)}) + String.format("%1$.1f%%", new Object[]{Double.valueOf(d)}));
    }
}
