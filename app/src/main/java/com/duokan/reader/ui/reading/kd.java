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

import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.c.h;
import com.duokan.core.app.e;
import com.duokan.core.app.y;
import com.duokan.core.ui.dv;
import com.duokan.reader.DkApp;
import com.duokan.reader.DkReader;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.ReaderEnv.PrivatePref;
import com.duokan.reader.common.webservices.WebSession;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.document.epub.as;
import com.duokan.reader.domain.statistics.a;
import com.duokan.reader.ui.general.HangTagView;
import com.duokan.reader.ui.general.gi;
import com.duokan.reader.ui.general.web.StorePageController;

import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class kd extends e {
    private static WebSession a = null;
    private static kn b = null;
    private final ho c = ((ho) getContext().queryFeature(ho.class));
    private final HangTagView d;
    private final FrameLayout e;
    private final FrameLayout f;
    private kn g = null;
    private long h = 0;
    private StorePageController i = null;

    public kd(y yVar) {
        super(yVar);
        setContentView(h.reading__hang_ad_view);
        this.d = (HangTagView) findViewById(g.reading__hang_ad_view__ad);
        this.d.setTagChainDrawable(getContext().getResources().getDrawable(f.reading__shared__hang_ad_chain));
        this.d.setOnScrollListener(new ke(this));
        this.d.setOnClickListener(new kf(this));
        this.e = (FrameLayout) findViewById(g.reading__hang_ad_view__help_bg);
        this.f = (FrameLayout) findViewById(g.reading__hang_ad_view__help);
        this.f.setBackgroundDrawable(new kg(this));
    }

    public void a(gi giVar) {
        b();
        if (this.d.getVisibility() != 0) {
            b(b);
        }
        if (this.c.a((as) ((gn) giVar).h())) {
            e();
        } else {
            f();
        }
    }

    protected boolean onBack() {
        if (this.i != null) {
            this.i.requestDetach();
            return true;
        } else if (this.f.getVisibility() != 0) {
            return super.onBack();
        } else {
            h();
            return true;
        }
    }

    protected boolean onRequestDetach(e eVar) {
        if (eVar != this.i) {
            return super.onRequestDetach(eVar);
        }
        e eVar2 = this.i;
        this.i = null;
        dv.f(eVar2.getContentView(), new kh(this, eVar2));
        return true;
    }

    public static void a() {
        if (com.duokan.reader.common.c.f.b().e() && a == null) {
            a = new ki(i.f().e());
            a.open();
        }
    }

    public static boolean b() {
        if (b == null) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() / 1000;
        if (currentTimeMillis < b.c && currentTimeMillis >= b.d) {
            b = null;
            return false;
        } else if (b.a != j()) {
            return true;
        } else {
            b = null;
            return false;
        }
    }

    private void a(String str) {
        if (this.i == null) {
            this.i = new StorePageController(getContext());
            this.i.loadUrl(str);
            ((ViewGroup) getContentView()).addView(this.i.getContentView(), new LayoutParams(-1, -1));
            addSubController(this.i);
            e eVar = this.i;
            dv.d(eVar.getContentView(), new kj(this, eVar));
            d();
        }
    }

    private void b(kn knVar) {
        int i = -1;
        int i2 = knVar != null ? knVar.a : -1;
        if (this.g != null) {
            i = this.g.a;
        }
        if (i != i2) {
            if (this.g != null) {
                this.d.setVisibility(4);
                this.g = null;
            }
            if (knVar != null) {
                try {
                    Options options = new Options();
                    options.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(knVar.g.getAbsolutePath(), options);
                    Options options2 = new Options();
                    int b = dv.b(getContext(), 64.0f);
                    options2.inSampleSize = Math.min(options.outWidth / b, options.outHeight / b);
                    Bitmap decodeFile = BitmapFactory.decodeFile(knVar.g.getAbsolutePath(), options2);
                    View imageView = new ImageView(getContext());
                    imageView.setImageBitmap(decodeFile);
                    imageView.setScaleType(ScaleType.CENTER_INSIDE);
                    this.d.setVisibility(4);
                    this.d.a(imageView, new LayoutParams(b, b));
                    this.g = knVar;
                } catch (Throwable th) {
                }
            }
        }
    }

    private void d() {
        if (this.g != null) {
            a(this.g.a);
            if (this.d.getVisibility() == 0) {
                this.d.setVisibility(4);
                dv.c(this.d, new kk(this));
            }
        }
    }

    private void e() {
        if (this.g != null) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.h >= TimeUnit.MINUTES.toMillis(5)) {
                this.h = currentTimeMillis;
                if (this.d.getVisibility() != 0) {
                    this.d.setVisibility(0);
                    dv.h(this.d, new kl(this));
                    a.k().e("reading/hang-ad/" + this.g.a + "/show");
                }
            }
        }
    }

    private void f() {
        if (this.g != null && this.d.getVisibility() == 0) {
            this.d.setVisibility(4);
            dv.f(this.d, null);
            h();
        }
    }

    private void g() {
        if (ReaderEnv.get().getPrefBoolean(PrivatePref.READING, "hang_ad_show_help", true) && this.g != null && this.f.getVisibility() != 0) {
            this.f.setVisibility(0);
            this.e.setVisibility(0);
            this.f.setOnTouchListener(new km(this));
            dv.b(this.e, null);
            dv.b(this.f, null);
        }
    }

    private void h() {
        ReaderEnv.get().setPrefBoolean(PrivatePref.READING, "hang_ad_show_help", false);
        if (this.g != null && this.f.getVisibility() == 0) {
            this.f.setVisibility(4);
            this.e.setVisibility(4);
            dv.c(this.f, null);
            dv.c(this.e, null);
        }
    }

    private static kn i() {
        kn knVar = null;
        List<kn> b = b(new File(DkApp.get().getCacheDir(), "hang_ad"));
        if (!b.isEmpty()) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            int j = j();
            for (kn knVar2 : b) {
                kn knVar22;
                if (knVar22.a != j) {
                    if (currentTimeMillis < knVar22.c || currentTimeMillis >= knVar22.d || !knVar22.g.exists() || (knVar != null && knVar.b >= knVar22.b && (knVar.b != knVar22.b || knVar.c >= knVar22.c))) {
                        knVar22 = knVar;
                    }
                    knVar = knVar22;
                }
            }
        }
        return knVar;
    }

    private static List b(File file) {
        Object linkedList = new LinkedList();
        File cacheDir = DkReader.get().getCacheDir();
        JSONObject a = com.duokan.reader.common.i.a(file, null);
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
                        kn knVar = new kn();
                        knVar.a = i2;
                        knVar.b = i3;
                        knVar.c = j;
                        knVar.d = j2;
                        knVar.e = optInt;
                        knVar.f = Uri.parse(optString);
                        knVar.h = string;
                        knVar.g = file2;
                        if (knVar.f != null) {
                            linkedList.add(knVar);
                        }
                    }
                }
            } catch (Throwable th) {
            }
        }
        return linkedList;
    }

    private static int j() {
        return ReaderEnv.get().getPrefInt(PrivatePref.READING, "hang_ad_last_closed", -1);
    }

    private static void a(int i) {
        ReaderEnv.get().setPrefInt(PrivatePref.READING, "hang_ad_last_closed", i);
        ReaderEnv.get().commitPrefs();
    }
}
