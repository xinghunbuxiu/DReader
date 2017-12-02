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
import com.duokan.b.i;
import com.duokan.core.ui.Scrollable;
import com.duokan.reader.domain.ad.e;
import com.duokan.reader.domain.ad.f;
import com.duokan.reader.domain.ad.g;
import com.duokan.reader.domain.ad.r;
import com.duokan.reader.domain.ad.x;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.ui.general.gw;

import org.apache.http.HttpStatus;

public class a {
    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int d = 0;
    private int e = 0;
    private final com.duokan.reader.domain.ad.a f = new com.duokan.reader.domain.ad.a();
    private final r g = new r(this.f);

    static /* synthetic */ int a(a aVar) {
        int i = aVar.b + 1;
        aVar.b = i;
        return i;
    }

    static /* synthetic */ int c(a aVar) {
        int i = aVar.c + 1;
        aVar.c = i;
        return i;
    }

    public void a(c cVar) {
        if (cVar.u()) {
            g.a().a(cVar.H());
        }
    }

    public View a(Context context) {
        View view = null;
        e b = g.a().b();
        if (b != null) {
            if (b.a()) {
                view = LayoutInflater.from(context).inflate(com.duokan.b.g.reading__fullscreen_ad_info_view, null, true);
            } else {
                view = LayoutInflater.from(context).inflate(com.duokan.b.g.reading__fullscreen_ad_image_view, null, true);
            }
            if (!(b.v == null || b.v.isEmpty())) {
                Glide.with(context).load(((f) b.v.get(0)).a).into((ImageView) view.findViewById(com.duokan.b.f.reading__large_image_view__image));
            }
            if (view != null) {
                TextView textView = (TextView) view.findViewById(com.duokan.b.f.reading__app_ad_view__download);
                View findViewById = view.findViewById(com.duokan.b.f.reading__fullscreen_ad_image_view__response_area);
                if (b.a()) {
                    if (b.h == e.a) {
                        view.findViewById(com.duokan.b.f.reading__app_ad_view__download).setVisibility(8);
                    } else {
                        view.findViewById(com.duokan.b.f.reading__app_ad_view__download).setVisibility(0);
                    }
                }
                a(context, b, view);
                a(context, b, findViewById, textView);
            }
        }
        return view;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(android.content.Context r8, android.view.ViewGroup r9, int r10) {
        /*
        r7 = this;
        r2 = 0;
        r0 = com.duokan.reader.domain.ad.g.a();
        r4 = r0.a(r10);
        if (r4 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r2;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r4.g;	 Catch:{ Throwable -> 0x00f0 }
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
        r0 = com.duokan.b.f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r1.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.TextView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r4, r1);	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r4, r1, r0);	 Catch:{ Throwable -> 0x00f0 }
    L_0x0023:
        r0 = r1;
        goto L_0x000c;
    L_0x0025:
        r0 = r4.h;	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.reader.domain.ad.e.b;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 != r1) goto L_0x0072;
    L_0x002b:
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x0037;
    L_0x002f:
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x0066;
    L_0x0037:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.b.g.reading__single_image_ad_view_download_icon;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
    L_0x0042:
        r0 = com.duokan.b.f.reading__single_image_view__image;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        if (r1 == 0) goto L_0x007e;
    L_0x004e:
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != 0) goto L_0x007e;
    L_0x0056:
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0066:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.b.g.reading__single_image_ad_view_download;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x0042;
    L_0x0072:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.b.g.reading__single_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        goto L_0x0042;
    L_0x007e:
        r1 = r4.h;	 Catch:{ Throwable -> 0x00f0 }
        r5 = com.duokan.reader.domain.ad.e.b;	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != r5) goto L_0x017e;
    L_0x0084:
        r1 = r4.q;	 Catch:{ Throwable -> 0x00f0 }
        r1 = android.text.TextUtils.isEmpty(r1);	 Catch:{ Throwable -> 0x00f0 }
        if (r1 != 0) goto L_0x017e;
    L_0x008c:
        r1 = r4.q;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0093:
        r0 = android.view.LayoutInflater.from(r8);	 Catch:{ Throwable -> 0x00f0 }
        r1 = com.duokan.b.g.reading__large_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.b.f.reading__app_ad_view__title_container;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r0.getLayoutParams();	 Catch:{ Throwable -> 0x00f0 }
        r1 = (android.widget.FrameLayout.LayoutParams) r1;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r4.h;	 Catch:{ Throwable -> 0x00f0 }
        r6 = com.duokan.reader.domain.ad.e.a;	 Catch:{ Throwable -> 0x00f0 }
        if (r5 != r6) goto L_0x00e5;
    L_0x00b2:
        r5 = com.duokan.b.f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 8;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
    L_0x00bd:
        r0.setLayoutParams(r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x017e;
    L_0x00c4:
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.isEmpty();	 Catch:{ Throwable -> 0x00f0 }
        if (r0 != 0) goto L_0x017e;
    L_0x00cc:
        r0 = com.duokan.b.f.reading__large_image_view__image;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x00e5:
        r5 = com.duokan.b.f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
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
        r1 = com.duokan.b.g.reading__multi_image_ad_view;	 Catch:{ Throwable -> 0x00f0 }
        r3 = 0;
        r3 = r0.inflate(r1, r9, r3);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.b.f.reading__app_ad_view__title_container;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.LinearLayout) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r0.getLayoutParams();	 Catch:{ Throwable -> 0x00f0 }
        r1 = (android.widget.FrameLayout.LayoutParams) r1;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r4.h;	 Catch:{ Throwable -> 0x00f0 }
        r6 = com.duokan.reader.domain.ad.e.a;	 Catch:{ Throwable -> 0x00f0 }
        if (r5 != r6) goto L_0x0173;
    L_0x0113:
        r5 = com.duokan.b.f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
        r5 = r3.findViewById(r5);	 Catch:{ Throwable -> 0x00f0 }
        r6 = 8;
        r5.setVisibility(r6);	 Catch:{ Throwable -> 0x00f0 }
    L_0x011e:
        r0.setLayoutParams(r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        if (r0 == 0) goto L_0x017e;
    L_0x0125:
        r0 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r0.size();	 Catch:{ Throwable -> 0x00f0 }
        r1 = 3;
        if (r0 < r1) goto L_0x017e;
    L_0x012e:
        r0 = com.duokan.b.f.reading__multi_image_view__img1;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 0;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.b.f.reading__multi_image_view__img2;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 1;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r0 = com.duokan.b.f.reading__multi_image_view__img3;	 Catch:{ Throwable -> 0x00f0 }
        r0 = r3.findViewById(r0);	 Catch:{ Throwable -> 0x00f0 }
        r0 = (android.widget.ImageView) r0;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r4.v;	 Catch:{ Throwable -> 0x00f0 }
        r5 = 2;
        r1 = r1.get(r5);	 Catch:{ Throwable -> 0x00f0 }
        r1 = (com.duokan.reader.domain.ad.f) r1;	 Catch:{ Throwable -> 0x00f0 }
        r1 = r1.a;	 Catch:{ Throwable -> 0x00f0 }
        r7.a(r8, r0, r1);	 Catch:{ Throwable -> 0x00f0 }
        r1 = r3;
        goto L_0x0013;
    L_0x0173:
        r5 = com.duokan.b.f.reading__app_ad_view__download;	 Catch:{ Throwable -> 0x00f0 }
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

    private void a(Context context, e eVar, View view) {
        if (eVar.h != e.b) {
            synchronized (this) {
                this.e++;
            }
            eVar.t = false;
        } else if (x.a(context, eVar.r)) {
            eVar.t = true;
        } else {
            synchronized (this) {
                this.d++;
            }
            eVar.t = false;
        }
        View findViewById = view.findViewById(com.duokan.b.f.reading__app_ad_view__ad_sign_bold);
        View findViewById2 = view.findViewById(com.duokan.b.f.reading__app_ad_view__ad_sign);
        TextView textView = (TextView) view.findViewById(com.duokan.b.f.reading__app_ad_view__title);
        if (TextUtils.isEmpty(eVar.s)) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            if (!(findViewById == null || findViewById2 == null)) {
                findViewById.setVisibility(0);
                findViewById2.setVisibility(8);
            }
        } else {
            if (textView != null) {
                textView.setText(eVar.s.trim());
                textView.setVisibility(0);
            }
            if (!(findViewById == null || findViewById2 == null)) {
                findViewById.setVisibility(8);
                findViewById2.setVisibility(0);
            }
        }
        textView = (TextView) view.findViewById(com.duokan.b.f.reading__app_ad_view__summary);
        if (!(TextUtils.isEmpty(eVar.e) || textView == null)) {
            textView.setText(eVar.e.trim());
            if (6 == eVar.g && eVar.h == e.b && (eVar.v == null || eVar.v.isEmpty())) {
                textView.post(new b(this, textView, context));
            }
        }
        textView = (TextView) view.findViewById(com.duokan.b.f.reading__app_ad_view__download);
        if (textView != null && eVar.h == e.b) {
            if (eVar.t) {
                textView.setText(i.general__shared__installed);
            } else if (this.f.a(eVar.r)) {
                textView.setText(i.general__shared__downloading);
            } else if (eVar.g != 6 || eVar.v == null || eVar.v.isEmpty()) {
                textView.setText(i.general__shared__download);
            } else {
                textView.setText(i.general__shared__click_download);
            }
        }
        View findViewById3 = view.findViewById(com.duokan.b.f.reading__app_ad_view__close);
        if (findViewById3 != null) {
            findViewById3.setOnClickListener(new c(this, view));
        }
        view.setTag(eVar);
    }

    private void a(Context context, e eVar, View view, TextView textView) {
        if (eVar.h == e.a) {
            view.setOnClickListener(new d(this, view, eVar, context));
        } else if (eVar.h == e.b) {
            view.setOnClickListener(new e(this, view, eVar, context, textView));
        }
    }

    private void a(Context context, ImageView imageView, String str) {
        if (context != null && imageView != null && !TextUtils.isEmpty(str)) {
            Drawable gwVar = new gw(context);
            gwVar.a(str);
            imageView.setImageDrawable(gwVar);
        }
    }

    public void a(View view) {
        e c = c(view);
        if (c != null) {
            synchronized (this) {
                this.a++;
            }
            g.a().a(c);
        }
    }

    public int a() {
        int i;
        synchronized (this) {
            i = this.a;
            this.a = 0;
        }
        return i;
    }

    public int b() {
        int i;
        synchronized (this) {
            i = this.b;
            this.b = 0;
        }
        return i;
    }

    public int c() {
        int i;
        synchronized (this) {
            i = this.c;
            this.c = 0;
        }
        return i;
    }

    public int d() {
        int i;
        synchronized (this) {
            i = this.d;
            this.d = 0;
        }
        return i;
    }

    public int e() {
        int i;
        synchronized (this) {
            i = this.e;
            this.e = 0;
        }
        return i;
    }

    private e c(View view) {
        if (view != null && (view.getTag() instanceof e)) {
            return (e) view.getTag();
        }
        return null;
    }

    private static boolean d(View view) {
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

    public void a(String str) {
        if (!this.g.a()) {
            this.f.b(str);
        }
    }

    public void b(String str) {
        this.f.c(str);
    }

    public void c(String str) {
        if (!this.g.a()) {
            this.f.d(str);
        }
    }

    public void d(String str) {
        if (!this.g.a()) {
            this.f.e(str);
        }
    }
}
