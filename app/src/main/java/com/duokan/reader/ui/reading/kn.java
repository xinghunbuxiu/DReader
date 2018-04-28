package com.duokan.reader.ui.reading;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkReader;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.p037c.C0559f;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.document.epub.as;
import com.duokan.reader.domain.statistics.C1163a;
import com.duokan.reader.ui.general.HangTagView;
import com.duokan.reader.ui.general.gc;
import com.duokan.reader.ui.general.web.StorePageController;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

public class kn extends ActivatedController {
    /* renamed from: a */
    private static WebSession f10513a = null;
    /* renamed from: b */
    private static kx f10514b = null;
    /* renamed from: c */
    private final hy f10515c = ((hy) getContext().queryFeature(hy.class));
    /* renamed from: d */
    private final HangTagView f10516d;
    /* renamed from: e */
    private final FrameLayout f10517e;
    /* renamed from: f */
    private final FrameLayout f10518f;
    /* renamed from: g */
    private kx f10519g = null;
    /* renamed from: h */
    private long f10520h = 0;
    /* renamed from: i */
    private StorePageController f10521i = null;

    public kn(IFeature mFeature) {
        super(mFeature);
        setContentView(C0256h.reading__hang_ad_view);
        this.f10516d = (HangTagView) findViewById(C0255g.reading__hang_ad_view__ad);
        this.f10516d.setTagChainDrawable(getContext().getResources().getDrawable(C0254f.reading__shared__hang_ad_chain));
        this.f10516d.setOnScrollListener(new ko(this));
        this.f10516d.setOnClickListener(new kp(this));
        this.f10517e = (FrameLayout) findViewById(C0255g.reading__hang_ad_view__help_bg);
        this.f10518f = (FrameLayout) findViewById(C0255g.reading__hang_ad_view__help);
        this.f10518f.setBackgroundDrawable(new kq(this));
    }

    /* renamed from: a */
    public void m14579a(gc gcVar) {
        m14567b();
        if (this.f10516d.getVisibility() != 0) {
            m14566b(f10514b);
        }
        if (this.f10515c.mo2357a((as) ((gs) gcVar).mo2332h())) {
            m14572e();
        } else {
            m14574f();
        }
    }

    protected boolean onBack() {
        if (this.f10521i != null) {
            this.f10521i.requestDetach();
            return true;
        } else if (this.f10518f.getVisibility() != 0) {
            return super.onBack();
        } else {
            m14576h();
            return true;
        }
    }

    protected boolean onRequestDetach(ActivatedController c0303e) {
        if (c0303e != this.f10521i) {
            return super.onRequestDetach(c0303e);
        }
        ActivatedController c0303e2 = this.f10521i;
        this.f10521i = null;
        dv.m1961f(c0303e2.getContentView(), new kr(this, c0303e2));
        return true;
    }

    /* renamed from: a */
    public static void m14559a() {
        if (C0559f.m2476b().m2486e() && f10513a == null) {
            f10513a = new ks(C0709k.m3476a().m3511f());
            f10513a.open();
        }
    }

    /* renamed from: b */
    public static boolean m14567b() {
        if (f10514b == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < f10514b.f10535c && currentTimeMillis >= f10514b.f10536d) {
            f10514b = null;
            return false;
        } else if (f10514b.f10533a != m14578j()) {
            return true;
        } else {
            f10514b = null;
            return false;
        }
    }

    /* renamed from: a */
    private void m14563a(String str) {
        if (this.f10521i == null) {
            this.f10521i = new StorePageController(getContext());
            this.f10521i.loadUrl(str);
            ((ViewGroup) getContentView()).addView(this.f10521i.getContentView(), new LayoutParams(-1, -1));
            addSubController(this.f10521i);
            ActivatedController c0303e = this.f10521i;
            dv.m1954d(c0303e.getContentView(), new kt(this, c0303e));
            m14570d();
        }
    }

    /* renamed from: b */
    private void m14566b(kx kxVar) {
        int i = -1;
        int i2 = kxVar != null ? kxVar.f10533a : -1;
        if (this.f10519g != null) {
            i = this.f10519g.f10533a;
        }
        if (i != i2) {
            if (this.f10519g != null) {
                this.f10516d.setVisibility(4);
                this.f10519g = null;
            }
            if (kxVar != null) {
                try {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(kxVar.f10539g.getAbsolutePath(), options);
                    Options options2 = new Options();
                    int b = dv.m1932b(getContext(), 64.0f);
                    options2.inSampleSize = Math.min(options.outWidth / b, options.outHeight / b);
                    Bitmap decodeFile = BitmapFactory.decodeFile(kxVar.f10539g.getAbsolutePath(), options2);
                    View imageView = new ImageView(getContext());
                    imageView.setImageBitmap(decodeFile);
                    imageView.setScaleType(ScaleType.CENTER_INSIDE);
                    this.f10516d.setVisibility(4);
                    this.f10516d.m10140a(imageView, new LayoutParams(b, b));
                    this.f10519g = kxVar;
                } catch (Throwable th) {
                }
            }
        }
    }

    /* renamed from: d */
    private void m14570d() {
        if (this.f10519g != null) {
            m14560a(this.f10519g.f10533a);
            if (this.f10516d.getVisibility() == 0) {
                this.f10516d.setVisibility(4);
                dv.hideAnimation(this.f10516d, new ku(this));
            }
        }
    }

    /* renamed from: e */
    private void m14572e() {
        if (this.f10519g != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f10520h >= TimeUnit.MINUTES.toMillis(5)) {
                this.f10520h = currentTimeMillis;
                if (this.f10516d.getVisibility() != 0) {
                    this.f10516d.setVisibility(0);
                    dv.loadNetError(this.f10516d, new kv(this));
                    C1163a.m8627k().m8657d("reading/hang-ad/" + this.f10519g.f10533a + "/show");
                }
            }
        }
    }

    /* renamed from: f */
    private void m14574f() {
        if (this.f10519g != null && this.f10516d.getVisibility() == 0) {
            this.f10516d.setVisibility(4);
            dv.m1961f(this.f10516d, null);
            m14576h();
        }
    }

    /* renamed from: g */
    private void m14575g() {
        if (ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "hang_ad_show_help", true) && this.f10519g != null && this.f10518f.getVisibility() != 0) {
            this.f10518f.setVisibility(0);
            this.f10517e.setVisibility(0);
            this.f10518f.setOnTouchListener(new kw(this));
            dv.showAnimation(this.f10517e, null);
            dv.showAnimation(this.f10518f, null);
        }
    }

    /* renamed from: h */
    private void m14576h() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "hang_ad_show_help", false);
        if (this.f10519g != null && this.f10518f.getVisibility() == 0) {
            this.f10518f.setVisibility(4);
            this.f10517e.setVisibility(4);
            dv.hideAnimation(this.f10518f, null);
            dv.hideAnimation(this.f10517e, null);
        }
    }

    /* renamed from: i */
    private static kx m14577i() {
        kx kxVar = null;
        List<kx> b = m14564b(new File(DkApp.get().getCacheDir(), "hang_ad"));
        if (!b.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int j = m14578j();
            for (kx kxVar2 : b) {
                kx kxVar22;
                if (kxVar22.f10533a != j) {
                    if (currentTimeMillis < kxVar22.f10535c || currentTimeMillis >= kxVar22.f10536d || !kxVar22.f10539g.exists() || (kxVar != null && kxVar.f10534b >= kxVar22.f10534b && (kxVar.f10534b != kxVar22.f10534b || kxVar.f10535c >= kxVar22.f10535c))) {
                        kxVar22 = kxVar;
                    }
                    kxVar = kxVar22;
                }
            }
        }
        return kxVar;
    }

    /* renamed from: b */
    private static List<kx> m14564b(File file) {
        Object linkedList = new LinkedList();
        File cacheDir = DkReader.get().getCacheDir();
        JSONObject a = C0611i.m2790a(file, null);
        if (a != null) {
            try {
                JSONArray jSONArray = a.getJSONArray("content");
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    int i2 = jSONObject.getInt("id");
                    int i3 = jSONObject.getInt(LogFactory.PRIORITY_KEY);
                    long j = jSONObject.getLong("effective_date");
                    long j2 = jSONObject.getLong("expire_date");
                    String optString = jSONObject.optString("action", "");
                    int optInt = jSONObject.optInt("timeout");
                    String string = jSONObject.getString("promotion_pic");
                    File file2 = new File(cacheDir, String.format("hang_ad_pic%d.img", new Object[]{Integer.valueOf(i2)}));
                    if (currentTimeMillis < j2) {
                        kx kxVar = new kx();
                        kxVar.f10533a = i2;
                        kxVar.f10534b = i3;
                        kxVar.f10535c = j;
                        kxVar.f10536d = j2;
                        kxVar.f10537e = optInt;
                        kxVar.f10538f = Uri.parse(optString);
                        kxVar.f10540h = string;
                        kxVar.f10539g = file2;
                        if (kxVar.f10538f != null) {
                            linkedList.add(kxVar);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return linkedList;
    }

    /* renamed from: j */
    private static int m14578j() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, "hang_ad_last_closed", -1);
    }

    /* renamed from: a */
    private static void m14560a(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, "hang_ad_last_closed", i);
        ReaderEnv.get().commitPrefs();
    }
}
