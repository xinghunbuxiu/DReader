package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.duokan.common.CommonUtils;
import com.duokan.core.ui.AnimUtils;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.BubbleFloatingView;
import java.text.SimpleDateFormat;
import org.apache.http.HttpStatus;

/* renamed from: com.duokan.reader.ui.reading.y */
public class C1473y extends mh {
    /* renamed from: e */
    private SeekBar f11173e;
    /* renamed from: f */
    private TextView f11174f;
    /* renamed from: g */
    private TextView f11175g;
    /* renamed from: h */
    private View f11176h;
    /* renamed from: i */
    private ImageButton f11177i;
    /* renamed from: j */
    private BubbleFloatingView f11178j;

    public C1473y(Activity activity, su suVar, ah ahVar, Rect rect, ml mlVar) {
        super(activity, suVar, ahVar, rect, mlVar);
        this.f11178j = (BubbleFloatingView) LayoutInflater.from(activity).inflate(C0256h.general__bubble_floating_view, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.f11178j.m9925a(m15095o(), new LayoutParams(Math.min(displayMetrics.widthPixels - CommonUtils.dip2px(this.c, 20.0f), CommonUtils.dip2px(this.c, 320.0f)), -2));
        this.f11178j.setUpArrow(C0254f.reading__shared__arrow_top);
        this.f11178j.setDownArrow(C0254f.reading__shared__arrow_bottom);
        this.f11178j.m9924a(AnimUtils.m1932b((Context) activity, 15.0f), 0, AnimUtils.m1932b((Context) activity, 15.0f), 0);
        this.f11178j.m9926a(new Rect[]{m13680e()}, false, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        m13688m();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f11176h.setEnabled(true);
        this.f11173e.setEnabled(true);
        mo2265a();
        this.f11173e.setMax(m13689n().getDuration());
        this.d.sendEmptyMessageDelayed(1, 1000);
        m13689n().start();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        m13689n().seekTo(0);
        this.f11173e.setProgress(0);
        m13682g();
    }

    /* renamed from: a */
    public void mo2266a(int i) {
        this.f11174f.setText(i + "%");
        this.f11176h.setEnabled(false);
        this.f11173e.setEnabled(false);
    }

    /* renamed from: a */
    protected void mo2265a() {
        this.f11173e.setProgress(m13689n().getCurrentPosition());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        this.f11174f.setText(simpleDateFormat.format(Integer.valueOf(m13689n().getCurrentPosition())) + "/" + simpleDateFormat.format(Integer.valueOf(m13689n().getDuration())));
        if (m13689n().isPlaying()) {
            this.f11177i.setImageResource(C0254f.general__shared__voice_pause_btn);
        } else {
            this.f11177i.setImageResource(C0254f.general__shared__voice_play_btn);
        }
    }

    /* renamed from: b */
    public View mo2270b() {
        return this.f11178j;
    }

    /* renamed from: a */
    public boolean mo2269a(View view, PointF pointF) {
        if (this.f11178j.getVisibility() != 0) {
            return false;
        }
        this.f11178j.setVisibility(4);
        if (!m13689n().isPlaying()) {
            m13682g();
        }
        return true;
    }

    /* renamed from: a */
    public void mo2268a(View view, PointF pointF, float f) {
    }

    /* renamed from: c */
    public void mo2514c() {
        if (this.f11178j.getVisibility() != 0) {
            this.f11178j.setVisibility(0);
        }
    }

    /* renamed from: o */
    private View m15095o() {
        View inflate = LayoutInflater.from(this.c).inflate(C0256h.reading__audioplayerwindow_view, null);
        this.f11175g = (TextView) inflate.findViewById(C0255g.reading__audioplayerwindow_view__title);
        this.f11175g.setText(m13679d().mo1410a());
        this.f11177i = (ImageButton) inflate.findViewById(C0255g.reading__audioplayerwindow_view__status_icon);
        this.f11177i.setImageResource(C0254f.general__shared__voice_play_btn);
        this.f11177i.setFocusableInTouchMode(false);
        this.f11177i.setFocusable(false);
        this.f11177i.setClickable(false);
        this.f11176h = inflate.findViewById(C0255g.reading__audioplayerwindow_view__playercontroller);
        this.f11176h.setOnClickListener(new C1474z(this));
        this.f11173e = (SeekBar) inflate.findViewById(C0255g.reading__audioplayerwindow_view__playerschedule);
        this.f11173e.setOnSeekBarChangeListener(new aa(this));
        this.f11174f = (TextView) inflate.findViewById(C0255g.reading__audioplayerwindow_view__time);
        this.f11174f.setText("00:00/00:00");
        return inflate;
    }
}
