package com.duokan.reader.ui.reading;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;

import com.duokan.core.app.ActivatedController;
import com.duokan.core.app.IFeature;
import com.duokan.core.sys.TaskHandler;
import com.duokan.core.ui.LinearScrollView;
import com.duokan.core.ui.UTools;
import com.duokan.reader.ReaderEnv;
import com.duokan.reader.domain.plugins.dict.q;
import com.duokan.reader.ui.general.DkLabelView;
import com.duokan.reader.ui.general.deprecatedDkTextView;

import org.apache.http.HttpStatus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.regex.Pattern;

public class TranslationController extends ActivatedController {
    private final deprecatedDkTextView a;
    private final ViewGroup b;
    private boolean c = false;
    private String d;
    private q e = null;
    private final DkLabelView f;
    private final View g;
    private final MediaPlayer h;
    private boolean i;
    private LinearScrollView j;

    enum LineType {
        PRONOUN,
        ATTR,
        MEANING,
        EXTRA
    }

    public TranslationController(IFeature featrue, adk com_duokan_reader_ui_reading_adk, sh shVar) {
        super(featrue);
        setContentView(h.reading__translation_view);
        this.a = (deprecatedDkTextView) findViewById(g.reading__translation_view__word);
        this.a.setMaxLines(1);
        this.b = (ViewGroup) findViewById(g.reading__translation_view__meanings);
        this.f = (DkLabelView) findViewById(g.reading__translation_after_download);
        this.h = new MediaPlayer();
        this.j = (LinearScrollView) getContentView().findViewById(g.reading__translation_view__scrollview);
        findViewById(g.reading__translation_view__dict_baidu).setOnClickListener(new ada(this, com_duokan_reader_ui_reading_adk));
        findViewById(g.reading__translation_view__dict_wiki).setOnClickListener(new adc(this, com_duokan_reader_ui_reading_adk));
        findViewById(g.reading__translation_view__dict_search).setOnClickListener(new add(this, shVar, com_duokan_reader_ui_reading_adk));
        findViewById(g.reading__translation_view__settings).setOnClickListener(new ade(this, com_duokan_reader_ui_reading_adk));
        this.g = findViewById(g.reading__translation_view__voice);
        this.g.setOnClickListener(new adf(this));
        j.a().b();
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        this.h.release();
    }

    public void a() {
        if (!this.c) {
            this.c = true;
        }
    }

    public void b() {
        if (this.c) {
            this.c = false;
            getContentView().scrollTo(0, 0);
        }
    }

    public void a(String str, adl com_duokan_reader_ui_reading_adl) {
        this.i = false;
        this.j.scrollTo(0, 0);
        String trim = str.trim();
        this.d = trim;
        this.e = null;
        this.a.setText("");
        this.b.removeAllViews();
        if (TextUtils.isEmpty(trim)) {
            this.b.setVisibility(8);
            this.f.setVisibility(0);
            return;
        }
        this.g.setVisibility(4);
        this.a.setText(trim);
        this.a.setChsToChtChars(d().T());
        TaskHandler.postDelayed(new adg(this, com_duokan_reader_ui_reading_adl), 200);
        j.a().a(this.d, new adh(this, com_duokan_reader_ui_reading_adl));
    }

    private void c() {
        j.a().a(this.d, new adi(this));
    }

    private boolean a(String str) {
        if (Pattern.compile("^[a-zA-Z\\-]+$").matcher(str).find()) {
            return true;
        }
        return false;
    }

    private void a(LineType lineType, String str) {
        if (!TextUtils.isEmpty(str)) {
            View com_duokan_reader_ui_general_deprecatedDkTextView = new deprecatedDkTextView(getContext());
            this.b.addView(com_duokan_reader_ui_general_deprecatedDkTextView, new LayoutParams(-1, -2));
            com_duokan_reader_ui_general_deprecatedDkTextView.setGravity(119);
            com_duokan_reader_ui_general_deprecatedDkTextView.setPadding(0, UTools.closeAnimation(getContext(), 10.0f), 0, 0);
            com_duokan_reader_ui_general_deprecatedDkTextView.setChsToChtChars(d().T());
            com_duokan_reader_ui_general_deprecatedDkTextView.setTextSize(Math.round(((float) d().C()) * 0.875f));
            int rgb = Color.rgb(HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT, HttpStatus.SC_NO_CONTENT);
            int rgb2 = Color.rgb(122, 103, 85);
            int rgb3 = Color.rgb(153, 153, 153);
            switch (adb.a[lineType.ordinal()]) {
                case 1:
                    com_duokan_reader_ui_general_deprecatedDkTextView.setTextColor(rgb2);
                    com_duokan_reader_ui_general_deprecatedDkTextView.setEnTypefaceFile(new File(ReaderEnv.get().getKernelFontDirectory(), "dk-symbol.ttf"));
                    com_duokan_reader_ui_general_deprecatedDkTextView.setGravity(119);
                    break;
                case 2:
                    com_duokan_reader_ui_general_deprecatedDkTextView.setTextColor(rgb);
                    break;
                case 3:
                    com_duokan_reader_ui_general_deprecatedDkTextView.setEnTypefaceFile(new File(ReaderEnv.get().getKernelFontDirectory(), "dk-symbol.ttf"));
                    com_duokan_reader_ui_general_deprecatedDkTextView.setTextColor(rgb3);
                    break;
            }
            com_duokan_reader_ui_general_deprecatedDkTextView.setTextColor(rgb3);
            com_duokan_reader_ui_general_deprecatedDkTextView.setText(str);
        }
    }

    private sh d() {
        return (sh) getContext().queryFeature(sh.class);
    }

    private void b(String str) {
        try {
            this.h.setOnPreparedListener(new adj(this));
            this.h.reset();
            this.h.setDataSource(str);
            this.h.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void c(String str) {
        try {
            File file = new File(j.b);
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
                this.h.reset();
                this.h.setDataSource(j.b);
                this.h.prepare();
                this.h.start();
            } catch (Exception e2) {
            }
        } catch (Exception e3) {
        }
    }
}
