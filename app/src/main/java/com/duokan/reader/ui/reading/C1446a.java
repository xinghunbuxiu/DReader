package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.duokan.core.ui.Scrollable;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.ad.C0744a;
import com.duokan.reader.domain.ad.C0748e;
import com.duokan.reader.domain.ad.C0749f;
import com.duokan.reader.domain.ad.C0750g;
import com.duokan.reader.domain.ad.C0761r;
import com.duokan.reader.domain.ad.C0767x;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.ui.general.gl;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.reading.a */
public class C1446a {
    /* renamed from: a */
    private int f9252a = 0;
    /* renamed from: b */
    private int f9253b = 0;
    /* renamed from: c */
    private int f9254c = 0;
    /* renamed from: d */
    private int f9255d = 0;
    /* renamed from: e */
    private int f9256e = 0;
    /* renamed from: f */
    private final C0744a f9257f = new C0744a();
    /* renamed from: g */
    private final C0761r f9258g = new C0761r(this.f9257f);

    /* renamed from: a */
    static /* synthetic */ int m12743a(C1446a c1446a) {
        int i = c1446a.f9253b + 1;
        c1446a.f9253b = i;
        return i;
    }

    /* renamed from: c */
    static /* synthetic */ int m12749c(C1446a c1446a) {
        int i = c1446a.f9254c + 1;
        c1446a.f9254c = i;
        return i;
    }

    /* renamed from: a */
    public void m12757a(C0800c c0800c) {
        if (c0800c.mo1018u()) {
            C0750g.m3561a().m3585a(c0800c.m4156I());
        }
    }

    /* renamed from: a */
    public View m12754a(Context context) {
        View view = null;
        C0748e b = C0750g.m3561a().m3587b();
        if (b != null) {
            if (b.m3558a()) {
                view = LayoutInflater.from(context).inflate(C0245g.reading__fullscreen_ad_info_view, null, true);
            } else {
                view = LayoutInflater.from(context).inflate(C0245g.reading__fullscreen_ad_image_view, null, true);
            }
            if (!(b.f2538w == null || b.f2538w.isEmpty())) {
                Glide.with(context).load(((C0749f) b.f2538w.get(0)).f2540a).into((ImageView) view.findViewById(C0244f.reading__large_image_view__image));
            }
            if (view != null) {
                TextView textView = (TextView) view.findViewById(C0244f.reading__app_ad_view__download);
                View findViewById = view.findViewById(C0244f.reading__fullscreen_ad_image_view__response_area);
                if (b.m3558a()) {
                    if (b.f2523h == C0748e.f2516a) {
                        view.findViewById(C0244f.reading__app_ad_view__download).setVisibility(8);
                    } else {
                        view.findViewById(C0244f.reading__app_ad_view__download).setVisibility(0);
                    }
                }
                m12745a(context, b, view);
                m12746a(context, b, findViewById, textView);
            }
        }
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    /* renamed from: a */
    public android.view.View m12755a(android.content.Context r8, android.view.ViewGroup r9, int r10) {
        /*
        r7 = this;
        r2 = 0;
        r0 = com.duokan.reader.domain.ad.C0750g.m3561a();
        r4 = r0.m3583a(r10);
        if (r4 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r2;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r4.f2522g;	 Catch:{ Throwable -> 0x00f0 }
        switch(r0) {
            case 4: goto L_0x0093;
            case 5: goto L_0x0012;
            case 6: goto L_0x0025;
            case 7: goto L_0x00f4;
            default: goto L_0x0012;
        };	 Catch:{ Throwable -> 0x00f0 }
    L_0x0012:
        r1 = r2;
    L_0x0013:
        if (r1 == 0) goto L_0x0023;
    L_0x0015:
        r0 = com.duokan.p023b.C0244f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r1.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.TextView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12745a(r8, r4, r1);	 Catch:{ Throwable -> 0x00f0 }
        r7.m12746a(r8, r4, r1, r0);	 Catch:{ Throwable -> 0x00f0 }
    L_0x0023:
        r0 = r1;
        goto L_0x000c;
    L_0x0025:
        r0 = r4.f2523h;	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.reader.domain.ad.C0748e.f2517b;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 != r1) goto L_0x0072;
    L_0x002b:
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x0037;
    L_0x002f:
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x0066;
    L_0x0037:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.p023b.C0245g.reading__single_image_ad_view_download_icon;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
    L_0x0042:
        r0 = com.duokan.p023b.C0244f.reading__single_image_view__image;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        if (r1 == 0) goto L_0x007e;
    L_0x004e:
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != 0) goto L_0x007e;
    L_0x0056:
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.C0749f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.f2540a;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0066:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.p023b.C0245g.reading__single_image_ad_view_download;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x0042;
    L_0x0072:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.p023b.C0245g.reading__single_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x0042;
    L_0x007e:
        r1 = r4.f2523h;	 Catch:{ Throwable -> 0x00f0 }
        r5 = com.duokan.reader.domain.ad.C0748e.f2517b;	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != r5) goto L_0x017e;
    L_0x0084:
        r1 = r4.f2532q;	 Catch:{ Throwable -> 0x00f0 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != 0) goto L_0x017e;
    L_0x008c:
        r1 = r4.f2532q;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0093:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.p023b.C0245g.reading__large_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.p023b.C0244f.reading__app_ad_view__title_container;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r0.getLayoutParams();	 Catch:{ Throwable -> 0x00f0 }
        r1 = (android.widget.FrameLayout.LayoutParams) r1;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r4.f2523h;	 Catch:{ Throwable -> 0x00f0 }
        r6 = com.duokan.reader.domain.ad.C0748e.f2516a;	 Catch:{ Throwable -> 0x00f0 }
        if (r5 != r6) goto L_0x00e5;
    L_0x00b2:
        r5 = com.duokan.p023b.C0244f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 8;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
    L_0x00bd:
        r0.setLayoutParams(r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x017e;
    L_0x00c4:
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r0 != 0) goto L_0x017e;
    L_0x00cc:
        r0 = com.duokan.p023b.C0244f.reading__large_image_view__image;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.C0749f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.f2540a;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x00e5:
        r5 = com.duokan.p023b.C0244f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 0;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x00bd;
    L_0x00f0:
        r0 = move-exception;
        r0 = r2;
        goto L_0x000c;
    L_0x00f4:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.p023b.C0245g.reading__multi_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.p023b.C0244f.reading__app_ad_view__title_container;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r0.getLayoutParams();	 Catch:{ Throwable -> 0x00f0 }
        r1 = (android.widget.FrameLayout.LayoutParams) r1;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r4.f2523h;	 Catch:{ Throwable -> 0x00f0 }
        r6 = com.duokan.reader.domain.ad.C0748e.f2516a;	 Catch:{ Throwable -> 0x00f0 }
        if (r5 != r6) goto L_0x0173;
    L_0x0113:
        r5 = com.duokan.p023b.C0244f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 8;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
    L_0x011e:
        r0.setLayoutParams(r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x017e;
    L_0x0125:
        r0 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.size();	 Catch:{ Throwable -> 0x00f0 }
        r1 = 3;
        if (r0 < r1) goto L_0x017e;
    L_0x012e:
        r0 = com.duokan.p023b.C0244f.reading__multi_image_view__img1;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.C0749f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.f2540a;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.p023b.C0244f.reading__multi_image_view__img2;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 1;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.C0749f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.f2540a;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.p023b.C0244f.reading__multi_image_view__img3;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.f2538w;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 2;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.C0749f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.f2540a;	 Catch:{ Throwable -> 0x00f0 }
        r7.m12744a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0173:
        r5 = com.duokan.p023b.C0244f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 0;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x011e;
    L_0x017e:
        r1 = r3;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.duokan.reader.ui.reading.a.a(android.content.Context, android.view.ViewGroup, int):android.view.View");
    }

    /* renamed from: a */
    private void m12745a(Context context, C0748e c0748e, View view) {
        if (c0748e.f2523h != C0748e.f2517b) {
            synchronized (this) {
                this.f9256e++;
            }
            c0748e.f2536u = false;
        } else if (C0767x.m3611a(context, c0748e.f2533r)) {
            c0748e.f2536u = true;
        } else {
            synchronized (this) {
                this.f9255d++;
            }
            c0748e.f2536u = false;
        }
        View findViewById = view.findViewById(C0244f.reading__app_ad_view__ad_sign_bold);
        View findViewById2 = view.findViewById(C0244f.reading__app_ad_view__ad_sign);
        TextView textView = (TextView) view.findViewById(C0244f.reading__app_ad_view__title);
        if (TextUtils.isEmpty(c0748e.f2534s)) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (!(findViewById == null || findViewById2 == null)) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
            }
        } else {
            if (textView != null) {
                textView.setText(c0748e.f2534s.trim());
                textView.setVisibility(0);
            }
            if (!(findViewById == null || findViewById2 == null)) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
            }
        }
        textView = (TextView) view.findViewById(C0244f.reading__app_ad_view__summary);
        if (!(TextUtils.isEmpty(c0748e.f2520e) || textView == null)) {
            textView.setText(c0748e.f2520e.trim());
            if (6 == c0748e.f2522g && c0748e.f2523h == C0748e.f2517b && (c0748e.f2538w == null || c0748e.f2538w.isEmpty())) {
                textView.post(new C1448b(this, textView, context));
            }
        }
        textView = (TextView) view.findViewById(C0244f.reading__app_ad_view__download);
        if (textView != null && c0748e.f2523h == C0748e.f2517b) {
            if (c0748e.f2536u) {
                textView.setText(C0247i.general__shared__installed);
            } else if (this.f9257f.m3532a(c0748e.f2533r)) {
                textView.setText(C0247i.general__shared__downloading);
            } else if (c0748e.f2522g != 6 || c0748e.f2538w == null || c0748e.f2538w.isEmpty()) {
                textView.setText(C0247i.general__shared__download);
            } else {
                textView.setText(C0247i.general__shared__click_download);
            }
        }
        View findViewById3 = view.findViewById(C0244f.reading__app_ad_view__close);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new C1449c(this, view));
        }
        view.setTag(c0748e);
    }

    /* renamed from: a */
    private void m12746a(Context context, C0748e c0748e, View view, TextView textView) {
        if (c0748e.f2523h == C0748e.f2516a) {
            view.setOnClickListener(new C1450d(this, view, c0748e, context));
        } else if (c0748e.f2523h == C0748e.f2517b) {
            view.setOnClickListener(new C1452e(this, view, c0748e, context, textView));
        }
    }

    /* renamed from: a */
    private void m12744a(Context context, ImageView imageView, String str) {
        if (context != null && imageView != null && !TextUtils.isEmpty(str)) {
            Drawable glVar = new gl(context);
            glVar.m10720a(str);
            imageView.setImageDrawable(glVar);
        }
    }

    /* renamed from: a */
    public void m12756a(View view) {
        C0748e c = m12750c(view);
        if (c != null) {
            synchronized (this) {
                this.f9252a++;
            }
            C0750g.m3561a().m3584a(c);
        }
    }

    /* renamed from: a */
    public int m12753a() {
        int i;
        synchronized (this) {
            i = this.f9252a;
            this.f9252a = 0;
        }
        return i;
    }

    /* renamed from: b */
    public int m12759b() {
        int i;
        synchronized (this) {
            i = this.f9253b;
            this.f9253b = 0;
        }
        return i;
    }

    /* renamed from: c */
    public int m12761c() {
        int i;
        synchronized (this) {
            i = this.f9254c;
            this.f9254c = 0;
        }
        return i;
    }

    /* renamed from: d */
    public int m12763d() {
        int i;
        synchronized (this) {
            i = this.f9255d;
            this.f9255d = 0;
        }
        return i;
    }

    /* renamed from: e */
    public int m12765e() {
        int i;
        synchronized (this) {
            i = this.f9256e;
            this.f9256e = 0;
        }
        return i;
    }

    /* renamed from: c */
    private C0748e m12750c(View view) {
        if (view != null && (view.getTag() instanceof C0748e)) {
            return (C0748e) view.getTag();
        }
        return null;
    }

    /* renamed from: d */
    private static boolean m12752d(View view) {
        for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof Scrollable) {
                if (((Scrollable) parent).getIdleTime() < HttpStatus.SC_INTERNAL_SERVER_ERROR) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    /* renamed from: a */
    public void m12758a(String str) {
        if (!this.f9258g.m3610a()) {
            this.f9257f.m3533b(str);
        }
    }

    /* renamed from: b */
    public void m12760b(String str) {
        this.f9257f.m3535c(str);
    }

    /* renamed from: c */
    public void m12762c(String str) {
        if (!this.f9258g.m3610a()) {
            this.f9257f.m3536d(str);
        }
    }

    /* renamed from: d */
    public void m12764d(String str) {
        if (!this.f9258g.m3610a()) {
            this.f9257f.m3537e(str);
        }
    }
}
