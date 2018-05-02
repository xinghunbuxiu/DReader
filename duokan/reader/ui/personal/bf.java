package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.c.h;
import com.duokan.core.app.IFeature;
import com.duokan.reader.domain.social.message.a;
import com.duokan.reader.domain.social.message.ac;
import com.duokan.reader.domain.social.message.b;
import com.duokan.reader.domain.social.message.c;
import com.duokan.reader.domain.social.message.e;
import com.duokan.reader.domain.social.message.k;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkSmallFaceView;
import com.duokan.reader.ui.general.ReaderUi;

class bf {
    private final IFeature a;
    private final k b;
    private final View c;
    private final DkSmallFaceView d;
    private final TextView e;
    private final TextView f;
    private final View g;

    public bf(IFeature featrue, k kVar, View view, ViewGroup viewGroup) {
        this.a = featrue;
        this.b = kVar;
        Context context = (Context) featrue;
        if (view == null || !(view.getTag() instanceof k)) {
            this.c = LayoutInflater.from(context).inflate(h.personal__feed_message_item_view, viewGroup, false);
        } else {
            this.c = view;
        }
        this.c.setTag(this.b);
        this.d = (DkSmallFaceView) this.c.findViewById(g.personal__feed_message_item_view__face);
        this.d.setUser(this.b.a());
        ((DkLabelView) this.c.findViewById(g.personal__feed_message_item_view__pub_name)).setText(ReaderUi.a(this.b.a().getAliasForDisplay()));
        ((DkLabelView) this.c.findViewById(g.personal__feed_message_item_view__pub_type)).setText(ac.a(context, this.b));
        ((DkLabelView) this.c.findViewById(g.personal__feed_message_item_view__pub_time)).setText(ReaderUi.a(context, this.b.c() * 1000));
        this.e = (TextView) this.c.findViewById(g.personal__feed_message_item_view__reply);
        this.g = this.c.findViewById(g.personal__feed_message_item_view__content_container);
        this.f = (TextView) this.c.findViewById(g.personal__feed_message_item_view__content);
        this.f.setBackgroundResource(f.personal__message_item_view__comment_bg);
        this.f.setTextColor(context.getResources().getColor(d.general__shared__666666));
        switch (kVar.c) {
            case 5:
                b();
                return;
            case 10:
                c();
                return;
            case 17:
                f();
                return;
            case 18:
                d();
                return;
            case 19:
                e();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    public View a() {
        return this.c;
    }

    private void b() {
        com.duokan.reader.domain.social.message.d dVar = (com.duokan.reader.domain.social.message.d) this.b.h;
        this.e.setText(dVar.a.b);
        this.e.setVisibility(0);
        if (TextUtils.isEmpty(dVar.b.l)) {
            this.g.setVisibility(8);
            return;
        }
        this.f.setText(dVar.b.l);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    private void c() {
        e eVar = (e) this.b.h;
        this.e.setText(eVar.c.b);
        this.e.setVisibility(0);
        CharSequence charSequence = eVar.a.b;
        if (TextUtils.isEmpty(charSequence)) {
            this.g.setVisibility(8);
            return;
        }
        this.f.setText(charSequence);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    private void d() {
        c cVar = (c) this.b.h;
        this.e.setVisibility(8);
        CharSequence charSequence = cVar.a.d;
        if (TextUtils.isEmpty(charSequence)) {
            this.g.setVisibility(8);
            return;
        }
        this.f.setText(charSequence);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    private void e() {
        a aVar = (a) this.b.h;
        this.e.setText(aVar.a.b);
        this.e.setVisibility(0);
        CharSequence charSequence = aVar.a.c;
        if (TextUtils.isEmpty(charSequence)) {
            this.g.setVisibility(8);
            return;
        }
        this.f.setText(charSequence);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }

    private void f() {
        b bVar = (b) this.b.h;
        this.e.setText(bVar.a.b);
        this.e.setVisibility(0);
        CharSequence charSequence = bVar.a.e;
        if (TextUtils.isEmpty(charSequence)) {
            this.g.setVisibility(8);
            return;
        }
        this.f.setText(charSequence);
        this.f.setVisibility(0);
        this.g.setVisibility(0);
    }
}
