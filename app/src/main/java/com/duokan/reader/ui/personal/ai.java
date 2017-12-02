package com.duokan.reader.ui.personal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.reader.domain.micloud.bj;

public class ai extends FrameLayout {
    private final View a;
    private final View b;
    private final TextView c;

    public ai(Context context) {
        this(context, null);
    }

    public ai(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(g.bookshelf__cloud_storage_space_stats_view, this, true);
        this.a = findViewById(f.bookshelf__cloud_storage_space_stats_view__querying);
        this.b = findViewById(f.bookshelf__cloud_storage_space_stats_view__storage_quota);
        this.c = (TextView) this.b.findViewById(f.bookshelf__cloud_storage_space_stats_view__storage_quota_tips);
    }

    public void a(bj bjVar, long j) {
        double d = 0.0d;
        if (bjVar == null || bjVar.a <= 0) {
            this.a.setVisibility(0);
            this.b.setVisibility(4);
            return;
        }
        this.a.setVisibility(4);
        this.b.setVisibility(0);
        double d2 = (((double) (bjVar.a - bjVar.b)) * 100.0d) / ((double) bjVar.a);
        if (d2 >= 0.0d) {
            d = d2;
        }
        d = Math.floor(d * 10.0d) / 10.0d;
        this.c.setText(getResources().getString(i.bookshelf__upload_books_view__storage_quota_used, new Object[]{com.duokan.common.i.a(bjVar.a)}) + String.format("%1$.1f%%", new Object[]{Double.valueOf(d)}));
    }
}
