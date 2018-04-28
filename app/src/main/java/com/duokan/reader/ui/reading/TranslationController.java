package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import com.duokan.core.app.IFeature;
import com.duokan.core.app.ActivatedController;
import com.duokan.core.sys.UThread;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.dv;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.plugins.dict.C1115j;
import com.duokan.reader.domain.plugins.dict.C1122q;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.DkTextView;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;
import org.apache.http.HttpStatus;

public class TranslationController extends ActivatedController {
    /* renamed from: a */
    private final DkTextView f9167a;
    /* renamed from: b */
    private final ViewGroup f9168b;
    /* renamed from: c */
    private boolean f9169c = false;
    /* renamed from: d */
    private String f9170d;
    /* renamed from: e */
    private C1122q f9171e = null;
    /* renamed from: f */
    private final DkLabelView f9172f;
    /* renamed from: g */
    private final View f9173g;
    /* renamed from: h */
    private final MediaPlayer f9174h;
    /* renamed from: i */
    private boolean f9175i;
    /* renamed from: j */
    private LinearScrollView f9176j;

    enum LineType {
        PRONOUN,
        ATTR,
        MEANING,
        EXTRA
    }

    public TranslationController(IFeature mFeature, adx adx, su suVar) {
        super(mFeature);
        setContentView(C0256h.reading__translation_view);
        this.f9167a = (DkTextView) findViewById(C0255g.reading__translation_view__word);
        this.f9167a.setMaxLines(1);
        this.f9168b = (ViewGroup) findViewById(C0255g.reading__translation_view__meanings);
        this.f9172f = (DkLabelView) findViewById(C0255g.reading__translation_after_download);
        this.f9174h = new MediaPlayer();
        this.f9176j = (LinearScrollView) getContentView().findViewById(C0255g.reading__translation_view__scrollview);
        findViewById(C0255g.reading__translation_view__dict_baidu).setOnClickListener(new adn(this, adx));
        findViewById(C0255g.reading__translation_view__dict_wiki).setOnClickListener(new adp(this, adx));
        findViewById(C0255g.reading__translation_view__dict_search).setOnClickListener(new adq(this, suVar, adx));
        findViewById(C0255g.reading__translation_view__settings).setOnClickListener(new adr(this, adx));
        this.f9173g = findViewById(C0255g.reading__translation_view__voice);
        this.f9173g.setOnClickListener(new ads(this));
        C1115j.m8411a().m8422b();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.f9174h.release();
    }

    /* renamed from: a */
    public void m12609a() {
        if (!this.f9169c) {
            this.f9169c = true;
        }
    }

    /* renamed from: b */
    public void m12611b() {
        if (this.f9169c) {
            this.f9169c = false;
            getContentView().scrollTo(0, 0);
        }
    }

    /* renamed from: a */
    public void m12610a(String str, ady ady) {
        this.f9175i = false;
        this.f9176j.scrollTo(0, 0);
        String trim = str.trim();
        this.f9170d = trim;
        this.f9171e = null;
        this.f9167a.setText("");
        this.f9168b.removeAllViews();
        if (TextUtils.isEmpty(trim)) {
            this.f9168b.setVisibility(8);
            this.f9172f.setVisibility(0);
            return;
        }
        this.f9173g.setVisibility(4);
        this.f9167a.setText(trim);
        this.f9167a.setChsToChtChars(m12602d().mo2003T());
        UThread.postDelayed(new adt(this, ady), 200);
        C1115j.m8411a().m8421a(this.f9170d, new adu(this, ady));
    }

    /* renamed from: c */
    private void m12597c() {
        C1115j.m8411a().m8420a(this.f9170d, new adv(this));
    }

    /* renamed from: a */
    private boolean m12593a(String str) {
        if (Pattern.compile("^[a-zA-Z\\-]+$").matcher(str).find()) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private void m12589a(LineType lineType, String str) {
        if (!TextUtils.isEmpty(str)) {
            View dkTextView = new DkTextView(getContext());
            this.f9168b.addView(dkTextView, new LayoutParams(-1, -2));
            dkTextView.setGravity(119);
            dkTextView.setPadding(0, dv.m1932b(getContext(), 10.0f), 0, 0);
            dkTextView.setChsToChtChars(m12602d().mo2003T());
            dkTextView.setTextSize((float) Math.round(((float) m12602d().mo1988C()) * 0.875f));
            dkTextView.setTextPixelSize(m12602d().mo1988C());
            int rgb = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
            int rgb2 = Color.rgb(122, 103, 85);
            int rgb3 = Color.rgb(153, 153, 153);
            switch (ado.f9526a[lineType.ordinal()]) {
                case 1:
                    dkTextView.setTextColor(rgb2);
                    dkTextView.setEnTypefaceFile(new File(ReaderEnv.get().getKernelFontDirectory(), "dk-symbol.ttf"));
                    dkTextView.setGravity(119);
                    break;
                case 2:
                    dkTextView.setTextColor(rgb);
                    break;
                case 3:
                    dkTextView.setEnTypefaceFile(new File(ReaderEnv.get().getKernelFontDirectory(), "dk-symbol.ttf"));
                    dkTextView.setTextColor(rgb3);
                    break;
            }
            dkTextView.setTextColor(rgb3);
            dkTextView.setText(str);
        }
    }

    /* renamed from: d */
    private su m12602d() {
        return (su) getContext().queryFeature(su.class);
    }

    /* renamed from: b */
    private void m12596b(String str) {
        try {
            this.f9174h.setOnPreparedListener(new adw(this));
            this.f9174h.reset();
            this.f9174h.setDataSource(str);
            this.f9174h.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m12598c(String str) {
        try {
            File file = new File(C1115j.f5406b);
            if (file.exists()) {
                file.delete();
            } else {
                file.mkdirs();
            }
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(Base64.decode(str.getBytes("ascii"), 0));
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (Exception e) {
            }
            try {
                this.f9174h.reset();
                this.f9174h.setDataSource(C1115j.f5406b);
                this.f9174h.prepare();
                this.f9174h.start();
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
    }
}
