package com.duokan.reader.ui.reading;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.res.Configuration;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaPlayer;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.SeekBar;
import android.widget.TextView;

import com.duokan.c.b;
import com.duokan.c.f;
import com.duokan.c.g;
import com.duokan.core.app.m;
import com.duokan.core.ui.et;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.reading.a.w;

import java.text.SimpleDateFormat;

public class afh extends lx {
    private et A;
    private final LayoutInflater e;
    private View f;
    private View g;
    private TextView h;
    private View i;
    private SurfaceView j;
    private View k;
    private View l;
    private TextView m;
    private TextView n;
    private SeekBar o;
    private ImageButton p;
    private ImageButton q;
    private boolean r = false;
    private boolean s = false;
    private boolean t = false;
    private boolean u = false;
    private DisplayMetrics v;
    private int w = 0;
    private float x = 1.0f;
    private final int y;
    private final int z;

    public afh(Activity activity, sh shVar, ah ahVar, Rect rect, mb mbVar) {
        super(activity, shVar, ahVar, rect, mbVar);
        this.e = LayoutInflater.from(activity);
        this.v = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(this.v);
        this.y = this.c.getRequestedOrientation();
        this.z = ((m) this.c).getCurrentOrientation();
        this.c.setRequestedOrientation(this.z);
        a(new RectF(e()));
        this.A = new et();
        this.A.a(new w(this));
        this.A.b(b());
        this.A.a(false);
        t();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.u = true;
        this.r = true;
        this.g.setVisibility(8);
        this.h.setVisibility(8);
        n().setDisplay(this.j.getHolder());
        n().start();
        this.d.sendEmptyMessageDelayed(1, 1000);
        o();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.t) {
            p();
        }
        g();
    }

    public void a(int i) {
        this.h.setText(i + "%");
    }

    protected void a() {
        if (this.r && !this.s && this.k.getVisibility() == 0) {
            this.o.setMax(n().getDuration());
            this.o.setProgress(n().getCurrentPosition());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            this.m.setText(simpleDateFormat.format(Integer.valueOf(n().getCurrentPosition())));
            this.n.setText("-" + simpleDateFormat.format(Long.valueOf((long) (n().getDuration() - n().getCurrentPosition()))));
        }
        v();
    }

    public View b() {
        return this.i;
    }

    public void a(Configuration configuration) {
        if (this.t) {
            s();
        }
    }

    public boolean h() {
        return this.t && this.k.getVisibility() == 0;
    }

    public boolean i() {
        if (!this.t) {
            return false;
        }
        u();
        this.o.setProgress(n().getCurrentPosition());
        this.k.setVisibility(0);
        return true;
    }

    public boolean j() {
        if (!this.t) {
            return false;
        }
        u();
        this.k.setVisibility(4);
        return true;
    }

    public boolean f() {
        if (this.t) {
            p();
            return true;
        }
        this.c.setRequestedOrientation(this.y);
        return super.f();
    }

    public void a(View view, PointF pointF, float f) {
        this.x *= f;
        if (((double) this.x) > 1.5d && !this.t) {
            p();
        } else if (((double) this.x) < 0.75d && this.t) {
            p();
        }
    }

    public boolean a(View view, PointF pointF) {
        if (this.t) {
            if (h()) {
                ((m) this.c).requestHideMenu();
            } else {
                ((m) this.c).requestShowMenu();
            }
            return true;
        } else if (!e().contains((int) pointF.x, (int) pointF.y)) {
            return false;
        } else {
            if (this.u) {
                if (this.k.getVisibility() == 0) {
                    this.k.setAnimation(AnimationUtils.loadAnimation(this.c, b.general__shared__alpha_dismiss));
                    this.k.setVisibility(4);
                } else {
                    u();
                    this.k.setVisibility(0);
                }
            }
            return true;
        }
    }

    private void a(RectF rectF) {
        this.i = this.e.inflate(h.general__videoplayer_view, null);
        this.f = this.i.findViewById(g.general__videoplayer_view__load);
        this.g = this.i.findViewById(g.general__videoplayer_view__loading);
        this.h = (TextView) this.i.findViewById(g.general__videoplayer_view__loadingmsg);
        this.k = this.i.findViewById(g.general__videoplayer_view__videocontroller);
        this.j = (SurfaceView) this.i.findViewById(g.general__videoplayer_view__videoview);
        this.j.getHolder().setType(3);
        this.j.getHolder().setFormat(-1);
        this.p = (ImageButton) this.i.findViewById(g.general__videoplayer_view__statusicon);
        this.p.setOnClickListener(new afi(this));
        this.q = (ImageButton) this.i.findViewById(g.general__videoplayer_view__sizechange);
        this.q.setOnClickListener(new afj(this));
        this.l = this.i.findViewById(g.general__videoplayer_view__playerschedule);
        this.m = (TextView) this.l.findViewById(g.general__videoplayer_view__playtime);
        this.n = (TextView) this.l.findViewById(g.general__videoplayer_view__lefttime);
        this.o = (SeekBar) this.l.findViewById(g.general__videoplayer_view__playerseekbar);
        this.o.setOnSeekBarChangeListener(new afk(this));
        r();
    }

    private void o() {
        if (n().isPlaying()) {
            this.p.setImageResource(f.general__shared__voice_play_btn_pause);
        } else {
            this.p.setImageResource(f.general__shared__voice_play_btn_play);
        }
    }

    @TargetApi(18)
    private void p() {
        if (this.u) {
            this.t = !this.t;
            if (this.t) {
                ReaderUi.a(this.c, 11);
            } else {
                this.c.setRequestedOrientation(this.z);
            }
            r();
            q();
        }
    }

    private void q() {
        if (this.b != null) {
            this.A.a(this.t);
            this.b.a(this.t);
        }
    }

    private void r() {
        if (this.t) {
            this.q.setImageResource(f.general__shared__voice_play_btn_minisize);
            this.l.setVisibility(0);
            this.l.setEnabled(true);
            LayoutParams layoutParams = (LayoutParams) this.k.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.width = -1;
            layoutParams.addRule(12);
            this.k.setLayoutParams(layoutParams);
            this.a.a(8, 20);
            s();
            return;
        }
        this.q.setImageResource(f.general__shared__voice_play_btn_max);
        this.l.setVisibility(4);
        this.l.setEnabled(false);
        int width = e().width();
        int height = e().height();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(width, height);
        layoutParams2.leftMargin = e().left;
        layoutParams2.topMargin = e().top;
        layoutParams2.addRule(13, 0);
        this.j.getHolder().setFixedSize(width, height);
        this.j.setLayoutParams(layoutParams2);
        if (this.f.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(width, height);
            layoutParams3.leftMargin = layoutParams2.leftMargin;
            layoutParams3.topMargin = layoutParams2.topMargin;
            this.f.setLayoutParams(layoutParams3);
            ((LinearLayout) this.f).setGravity(17);
        }
        this.a.a(4, 24);
        if (!this.s && n().isPlaying()) {
            n().start();
        }
        layoutParams = (LayoutParams) this.k.getLayoutParams();
        layoutParams.leftMargin = e().left;
        layoutParams.width = width;
        layoutParams.addRule(8, g.general__videoplayer_view__videoview);
        layoutParams.addRule(12, 0);
        this.k.setLayoutParams(layoutParams);
    }

    private void s() {
        if (n().getVideoWidth() != 0) {
            int i;
            int i2;
            ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getMetrics(this.v);
            int videoWidth = n().getVideoWidth();
            int videoHeight = n().getVideoHeight();
            if ((((double) videoWidth) / ((double) this.v.widthPixels) > ((double) videoHeight) / ((double) this.v.heightPixels) ? 1 : 2) == 1) {
                i = (int) ((((double) this.v.widthPixels) / ((double) videoWidth)) * ((double) videoHeight));
                i2 = this.v.widthPixels;
            } else {
                i2 = (int) ((((double) this.v.heightPixels) / ((double) videoHeight)) * ((double) videoWidth));
                i = this.v.heightPixels;
            }
            n().pause();
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i2, i);
            layoutParams.addRule(13);
            this.j.setLayoutParams(layoutParams);
            this.j.getHolder().setFixedSize(i2, i);
            if (!this.s && this.r) {
                n().start();
            }
        }
    }

    private void t() {
        this.j.getHolder().addCallback(new afl(this));
        o();
    }

    private void u() {
        this.w = 0;
    }

    private void v() {
        if (this.k.getVisibility() != 0) {
            return;
        }
        if (this.w >= 3) {
            this.k.setAnimation(AnimationUtils.loadAnimation(this.c, b.general__shared__alpha_dismiss));
            this.k.setVisibility(4);
            this.w = 0;
            return;
        }
        this.w++;
    }
}
