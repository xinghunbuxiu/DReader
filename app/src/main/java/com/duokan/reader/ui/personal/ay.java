package com.duokan.reader.ui.personal;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.social.message.C1139a;
import com.duokan.reader.domain.social.message.C1141b;
import com.duokan.reader.domain.social.message.C1142c;
import com.duokan.reader.domain.social.message.C1143d;
import com.duokan.reader.domain.social.message.C1144e;
import com.duokan.reader.domain.social.message.C1151k;
import com.duokan.reader.domain.social.message.aa;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkSmallFaceView;
import com.duokan.reader.ui.general.ReaderUi;

class ay {
    /* renamed from: a */
    private final IFeature f8291a;
    /* renamed from: b */
    private final C1151k f8292b;
    /* renamed from: c */
    private final View f8293c;
    /* renamed from: d */
    private final DkSmallFaceView f8294d;
    /* renamed from: e */
    private final TextView f8295e;
    /* renamed from: f */
    private final TextView f8296f;
    /* renamed from: g */
    private final View f8297g;

    public ay(IFeature mFeature, C1151k c1151k, View view, ViewGroup viewGroup) {
        this.f8291a = mFeature;
        this.f8292b = c1151k;
        Context context = (Context) mFeature;
        if (view == null || !(view.getTag() instanceof C1151k)) {
            this.f8293c = LayoutInflater.from(context).inflate(C0256h.personal__feed_message_item_view, viewGroup, false);
        } else {
            this.f8293c = view;
        }
        this.f8293c.setTag(this.f8292b);
        this.f8294d = (DkSmallFaceView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__face);
        this.f8294d.setUser(this.f8292b.m8578a());
        ((DkLabelView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__pub_name)).setText(ReaderUi.m10160a(this.f8292b.m8578a().getAliasForDisplay()));
        ((DkLabelView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__pub_type)).setText(aa.m8504a(context, this.f8292b));
        ((DkLabelView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__pub_time)).setText(ReaderUi.m10158a(context, this.f8292b.m8581c() * 1000));
        this.f8295e = (TextView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__reply);
        this.f8297g = this.f8293c.findViewById(C0255g.personal__feed_message_item_view__content_container);
        this.f8296f = (TextView) this.f8293c.findViewById(C0255g.personal__feed_message_item_view__content);
        this.f8296f.setBackgroundResource(C0254f.personal__message_item_view__comment_bg);
        this.f8296f.setTextColor(context.getResources().getColor(C0252d.general__shared__666666));
        switch (c1151k.f5556c) {
            case 5:
                m11427b();
                return;
            case 10:
                m11428c();
                return;
            case 17:
                m11431f();
                return;
            case 18:
                m11429d();
                return;
            case 19:
                m11430e();
                return;
            default:
                throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public View m11432a() {
        return this.f8293c;
    }

    /* renamed from: b */
    private void m11427b() {
        C1143d c1143d = (C1143d) this.f8292b.f5561h;
        this.f8295e.setText(c1143d.f5534a.f2137b);
        this.f8295e.setVisibility(0);
        if (TextUtils.isEmpty(c1143d.f5535b.l)) {
            this.f8297g.setVisibility(8);
            return;
        }
        this.f8296f.setText(c1143d.f5535b.l);
        this.f8296f.setVisibility(0);
        this.f8297g.setVisibility(0);
    }

    /* renamed from: c */
    private void m11428c() {
        C1144e c1144e = (C1144e) this.f8292b.f5561h;
        this.f8295e.setText(c1144e.f5538c.f2137b);
        this.f8295e.setVisibility(0);
        CharSequence charSequence = c1144e.f5536a.f2137b;
        if (TextUtils.isEmpty(charSequence)) {
            this.f8297g.setVisibility(8);
            return;
        }
        this.f8296f.setText(charSequence);
        this.f8296f.setVisibility(0);
        this.f8297g.setVisibility(0);
    }

    /* renamed from: d */
    private void m11429d() {
        C1142c c1142c = (C1142c) this.f8292b.f5561h;
        this.f8295e.setVisibility(8);
        CharSequence charSequence = c1142c.f5533a.f2134d;
        if (TextUtils.isEmpty(charSequence)) {
            this.f8297g.setVisibility(8);
            return;
        }
        this.f8296f.setText(charSequence);
        this.f8296f.setVisibility(0);
        this.f8297g.setVisibility(0);
    }

    /* renamed from: e */
    private void m11430e() {
        C1139a c1139a = (C1139a) this.f8292b.f5561h;
        this.f8295e.setText(c1139a.f5483a.f2121b);
        this.f8295e.setVisibility(0);
        CharSequence charSequence = c1139a.f5483a.f2122c;
        if (TextUtils.isEmpty(charSequence)) {
            this.f8297g.setVisibility(8);
            return;
        }
        this.f8296f.setText(charSequence);
        this.f8296f.setVisibility(0);
        this.f8297g.setVisibility(0);
    }

    /* renamed from: f */
    private void m11431f() {
        C1141b c1141b = (C1141b) this.f8292b.f5561h;
        this.f8295e.setText(c1141b.f5532a.f2126b);
        this.f8295e.setVisibility(0);
        CharSequence charSequence = c1141b.f5532a.f2129e;
        if (TextUtils.isEmpty(charSequence)) {
            this.f8297g.setVisibility(8);
            return;
        }
        this.f8296f.setText(charSequence);
        this.f8296f.setVisibility(0);
        this.f8297g.setVisibility(0);
    }
}
