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

import com.duokan.core.ui.UTools;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.BubbleFloatingView;

import org.apache.http.HttpStatus;

import java.text.SimpleDateFormat;

public class y extends lx {
    private SeekBar e;
    private TextView f;
    private TextView g;
    private View h;
    private ImageButton i;
    private BubbleFloatingView j;

    public y(Activity activity, sh shVar, ah ahVar, Rect rect, mb mbVar) {
        super(activity, shVar, ahVar, rect, mbVar);
        this.j = (BubbleFloatingView) LayoutInflater.from(activity).inflate(h.general__bubble_floating_view, null);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        this.j.a(o(), new LayoutParams(Math.min(displayMetrics.widthPixels - i.a(this.c, 20.0f), i.a(this.c, 320.0f)), -2));
        this.j.setUpArrow(f.reading__shared__arrow_top);
        this.j.setDownArrow(f.reading__shared__arrow_bottom);
        this.j.a(UTools.closeAnimation((Context) activity, 15.0f), 0, UTools.closeAnimation((Context) activity, 15.0f), 0);
        this.j.a(new Rect[]{e()}, false, (int) HttpStatus.SC_INTERNAL_SERVER_ERROR);
        m();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.h.setEnabled(true);
        this.e.setEnabled(true);
        a();
        this.e.setMax(n().getDuration());
        this.d.sendEmptyMessageDelayed(1, 1000);
        n().start();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        n().seekTo(0);
        this.e.setProgress(0);
        g();
    }

    public void a(int i) {
        this.f.setText(i + "%");
        this.h.setEnabled(false);
        this.e.setEnabled(false);
    }

    protected void a() {
        this.e.setProgress(n().getCurrentPosition());
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
        this.f.setText(simpleDateFormat.format(Integer.valueOf(n().getCurrentPosition())) + "/" + simpleDateFormat.format(Integer.valueOf(n().getDuration())));
        if (n().isPlaying()) {
            this.i.setImageResource(f.general__shared__voice_pause_btn);
        } else {
            this.i.setImageResource(f.general__shared__voice_play_btn);
        }
    }

    public View b() {
        return this.j;
    }

    public boolean a(View view, PointF pointF) {
        if (this.j.getVisibility() != 0) {
            return false;
        }
        this.j.setVisibility(4);
        if (!n().isPlaying()) {
            g();
        }
        return true;
    }

    public void a(View view, PointF pointF, float f) {
    }

    public void c() {
        if (this.j.getVisibility() != 0) {
            this.j.setVisibility(0);
        }
    }

    private View o() {
        View inflate = LayoutInflater.from(this.c).inflate(h.reading__audioplayerwindow_view, null);
        this.g = (TextView) inflate.findViewById(g.reading__audioplayerwindow_view__title);
        this.g.setText(d().a());
        this.i = (ImageButton) inflate.findViewById(g.reading__audioplayerwindow_view__status_icon);
        this.i.setImageResource(f.general__shared__voice_play_btn);
        this.i.setFocusableInTouchMode(false);
        this.i.setFocusable(false);
        this.i.setClickable(false);
        this.h = inflate.findViewById(g.reading__audioplayerwindow_view__playercontroller);
        this.h.setOnClickListener(new z(this));
        this.e = (SeekBar) inflate.findViewById(g.reading__audioplayerwindow_view__playerschedule);
        this.e.setOnSeekBarChangeListener(new aa(this));
        this.f = (TextView) inflate.findViewById(g.reading__audioplayerwindow_view__time);
        this.f.setText("00:00/00:00");
        return inflate;
    }
}
