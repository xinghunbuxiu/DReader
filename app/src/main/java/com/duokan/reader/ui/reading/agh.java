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
import com.duokan.core.app.BaseActivity;
import com.duokan.core.ui.et;
import com.duokan.p024c.C0250b;
import com.duokan.p024c.C0254f;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.ReaderUi;
import com.duokan.reader.ui.reading.p054a.C1442w;
import java.text.SimpleDateFormat;

public class agh extends mh {
    /* renamed from: A */
    private et f9736A;
    /* renamed from: e */
    private final LayoutInflater f9737e;
    /* renamed from: f */
    private View f9738f;
    /* renamed from: g */
    private View f9739g;
    /* renamed from: h */
    private TextView f9740h;
    /* renamed from: i */
    private View f9741i;
    /* renamed from: j */
    private SurfaceView f9742j;
    /* renamed from: k */
    private View f9743k;
    /* renamed from: l */
    private View f9744l;
    /* renamed from: m */
    private TextView f9745m;
    /* renamed from: n */
    private TextView f9746n;
    /* renamed from: o */
    private SeekBar f9747o;
    /* renamed from: p */
    private ImageButton f9748p;
    /* renamed from: q */
    private ImageButton f9749q;
    /* renamed from: r */
    private boolean f9750r = false;
    /* renamed from: s */
    private boolean f9751s = false;
    /* renamed from: t */
    private boolean f9752t = false;
    /* renamed from: u */
    private boolean f9753u = false;
    /* renamed from: v */
    private DisplayMetrics f9754v;
    /* renamed from: w */
    private int f9755w = 0;
    /* renamed from: x */
    private float f9756x = 1.0f;
    /* renamed from: y */
    private final int f9757y;
    /* renamed from: z */
    private final int f9758z;

    public agh(Activity activity, su suVar, ah ahVar, Rect rect, ml mlVar) {
        super(activity, suVar, ahVar, rect, mlVar);
        this.f9737e = LayoutInflater.from(activity);
        this.f9754v = new DisplayMetrics();
        ((WindowManager) activity.getSystemService("window")).getDefaultDisplay().getMetrics(this.f9754v);
        this.f9757y = this.c.getRequestedOrientation();
        this.f9758z = ((BaseActivity) this.c).getCurrentOrientation();
        this.c.setRequestedOrientation(this.f9758z);
        m13690a(new RectF(m13680e()));
        this.f9736A = new et();
        this.f9736A.m2041a(new C1442w(this));
        this.f9736A.m2046b(mo2270b());
        this.f9736A.m2043a(false);
        m13703t();
    }

    public void onPrepared(MediaPlayer mediaPlayer) {
        this.f9753u = true;
        this.f9750r = true;
        this.f9739g.setVisibility(8);
        this.f9740h.setVisibility(8);
        m13689n().setDisplay(this.f9742j.getHolder());
        m13689n().start();
        this.d.sendEmptyMessageDelayed(1, 1000);
        m13698o();
    }

    public void onCompletion(MediaPlayer mediaPlayer) {
        if (this.f9752t) {
            m13699p();
        }
        m13682g();
    }

    /* renamed from: a */
    public void mo2266a(int i) {
        this.f9740h.setText(i + "%");
    }

    /* renamed from: a */
    protected void mo2265a() {
        if (this.f9750r && !this.f9751s && this.f9743k.getVisibility() == 0) {
            this.f9747o.setMax(m13689n().getDuration());
            this.f9747o.setProgress(m13689n().getCurrentPosition());
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("mm:ss");
            this.f9745m.setText(simpleDateFormat.format(Integer.valueOf(m13689n().getCurrentPosition())));
            this.f9746n.setText("-" + simpleDateFormat.format(Long.valueOf((long) (m13689n().getDuration() - m13689n().getCurrentPosition()))));
        }
        m13705v();
    }

    /* renamed from: b */
    public View mo2270b() {
        return this.f9741i;
    }

    /* renamed from: a */
    public void mo2267a(Configuration configuration) {
        if (this.f9752t) {
            m13702s();
        }
    }

    /* renamed from: h */
    public boolean mo2272h() {
        return this.f9752t && this.f9743k.getVisibility() == 0;
    }

    /* renamed from: i */
    public boolean mo2273i() {
        if (!this.f9752t) {
            return false;
        }
        m13704u();
        this.f9747o.setProgress(m13689n().getCurrentPosition());
        this.f9743k.setVisibility(0);
        return true;
    }

    /* renamed from: j */
    public boolean mo2274j() {
        if (!this.f9752t) {
            return false;
        }
        m13704u();
        this.f9743k.setVisibility(4);
        return true;
    }

    /* renamed from: f */
    public boolean mo2271f() {
        if (this.f9752t) {
            m13699p();
            return true;
        }
        this.c.setRequestedOrientation(this.f9757y);
        return super.mo2271f();
    }

    /* renamed from: a */
    public void mo2268a(View view, PointF pointF, float f) {
        this.f9756x *= f;
        if (((double) this.f9756x) > 1.5d && !this.f9752t) {
            m13699p();
        } else if (((double) this.f9756x) < 0.75d && this.f9752t) {
            m13699p();
        }
    }

    /* renamed from: a */
    public boolean mo2269a(View view, PointF pointF) {
        if (this.f9752t) {
            if (mo2272h()) {
                ((BaseActivity) this.c).requestHideMenu();
            } else {
                ((BaseActivity) this.c).requestShowMenu();
            }
            return true;
        } else if (!m13680e().contains((int) pointF.x, (int) pointF.y)) {
            return false;
        } else {
            if (this.f9753u) {
                if (this.f9743k.getVisibility() == 0) {
                    this.f9743k.setAnimation(AnimationUtils.loadAnimation(this.c, C0250b.general__shared__alpha_dismiss));
                    this.f9743k.setVisibility(4);
                } else {
                    m13704u();
                    this.f9743k.setVisibility(0);
                }
            }
            return true;
        }
    }

    /* renamed from: a */
    private void m13690a(RectF rectF) {
        this.f9741i = this.f9737e.inflate(C0256h.general__videoplayer_view, null);
        this.f9738f = this.f9741i.findViewById(C0255g.general__videoplayer_view__load);
        this.f9739g = this.f9741i.findViewById(C0255g.general__videoplayer_view__loading);
        this.f9740h = (TextView) this.f9741i.findViewById(C0255g.general__videoplayer_view__loadingmsg);
        this.f9743k = this.f9741i.findViewById(C0255g.general__videoplayer_view__videocontroller);
        this.f9742j = (SurfaceView) this.f9741i.findViewById(C0255g.general__videoplayer_view__videoview);
        this.f9742j.getHolder().setType(3);
        this.f9742j.getHolder().setFormat(-1);
        this.f9748p = (ImageButton) this.f9741i.findViewById(C0255g.general__videoplayer_view__statusicon);
        this.f9748p.setOnClickListener(new agi(this));
        this.f9749q = (ImageButton) this.f9741i.findViewById(C0255g.general__videoplayer_view__sizechange);
        this.f9749q.setOnClickListener(new agj(this));
        this.f9744l = this.f9741i.findViewById(C0255g.general__videoplayer_view__playerschedule);
        this.f9745m = (TextView) this.f9744l.findViewById(C0255g.general__videoplayer_view__playtime);
        this.f9746n = (TextView) this.f9744l.findViewById(C0255g.general__videoplayer_view__lefttime);
        this.f9747o = (SeekBar) this.f9744l.findViewById(C0255g.general__videoplayer_view__playerseekbar);
        this.f9747o.setOnSeekBarChangeListener(new agk(this));
        m13701r();
    }

    /* renamed from: o */
    private void m13698o() {
        if (m13689n().isPlaying()) {
            this.f9748p.setImageResource(C0254f.general__shared__voice_play_btn_pause);
        } else {
            this.f9748p.setImageResource(C0254f.general__shared__voice_play_btn_play);
        }
    }

    @TargetApi(18)
    /* renamed from: p */
    private void m13699p() {
        if (this.f9753u) {
            this.f9752t = !this.f9752t;
            if (this.f9752t) {
                ReaderUi.m10153a(this.c, 11);
            } else {
                this.c.setRequestedOrientation(this.f9758z);
            }
            m13701r();
            m13700q();
        }
    }

    /* renamed from: q */
    private void m13700q() {
        if (this.b != null) {
            this.f9736A.m2043a(this.f9752t);
            this.b.mo2427a(this.f9752t);
        }
    }

    /* renamed from: r */
    private void m13701r() {
        if (this.f9752t) {
            this.f9749q.setImageResource(C0254f.general__shared__voice_play_btn_minisize);
            this.f9744l.setVisibility(0);
            this.f9744l.setEnabled(true);
            LayoutParams layoutParams = (LayoutParams) this.f9743k.getLayoutParams();
            layoutParams.leftMargin = 0;
            layoutParams.width = -1;
            layoutParams.addRule(12);
            this.f9743k.setLayoutParams(layoutParams);
            this.a.mo2040a(8, 20);
            m13702s();
            return;
        }
        this.f9749q.setImageResource(C0254f.general__shared__voice_play_btn_max);
        this.f9744l.setVisibility(4);
        this.f9744l.setEnabled(false);
        int width = m13680e().width();
        int height = m13680e().height();
        ViewGroup.LayoutParams layoutParams2 = new LayoutParams(width, height);
        layoutParams2.leftMargin = m13680e().left;
        layoutParams2.topMargin = m13680e().top;
        layoutParams2.addRule(13, 0);
        this.f9742j.getHolder().setFixedSize(width, height);
        this.f9742j.setLayoutParams(layoutParams2);
        if (this.f9738f.getVisibility() == 0) {
            ViewGroup.LayoutParams layoutParams3 = new LayoutParams(width, height);
            layoutParams3.leftMargin = layoutParams2.leftMargin;
            layoutParams3.topMargin = layoutParams2.topMargin;
            this.f9738f.setLayoutParams(layoutParams3);
            ((LinearLayout) this.f9738f).setGravity(17);
        }
        this.a.mo2040a(4, 24);
        if (!this.f9751s && m13689n().isPlaying()) {
            m13689n().start();
        }
        layoutParams = (LayoutParams) this.f9743k.getLayoutParams();
        layoutParams.leftMargin = m13680e().left;
        layoutParams.width = width;
        layoutParams.addRule(8, C0255g.general__videoplayer_view__videoview);
        layoutParams.addRule(12, 0);
        this.f9743k.setLayoutParams(layoutParams);
    }

    /* renamed from: s */
    private void m13702s() {
        if (m13689n().getVideoWidth() != 0) {
            int i;
            int i2;
            ((WindowManager) this.c.getSystemService("window")).getDefaultDisplay().getMetrics(this.f9754v);
            int videoWidth = m13689n().getVideoWidth();
            int videoHeight = m13689n().getVideoHeight();
            if ((((double) videoWidth) / ((double) this.f9754v.widthPixels) > ((double) videoHeight) / ((double) this.f9754v.heightPixels) ? 1 : 2) == 1) {
                i = (int) ((((double) this.f9754v.widthPixels) / ((double) videoWidth)) * ((double) videoHeight));
                i2 = this.f9754v.widthPixels;
            } else {
                i2 = (int) ((((double) this.f9754v.heightPixels) / ((double) videoHeight)) * ((double) videoWidth));
                i = this.f9754v.heightPixels;
            }
            m13689n().pause();
            ViewGroup.LayoutParams layoutParams = new LayoutParams(i2, i);
            layoutParams.addRule(13);
            this.f9742j.setLayoutParams(layoutParams);
            this.f9742j.getHolder().setFixedSize(i2, i);
            if (!this.f9751s && this.f9750r) {
                m13689n().start();
            }
        }
    }

    /* renamed from: t */
    private void m13703t() {
        this.f9742j.getHolder().addCallback(new agl(this));
        m13698o();
    }

    /* renamed from: u */
    private void m13704u() {
        this.f9755w = 0;
    }

    /* renamed from: v */
    private void m13705v() {
        if (this.f9743k.getVisibility() != 0) {
            return;
        }
        if (this.f9755w >= 3) {
            this.f9743k.setAnimation(AnimationUtils.loadAnimation(this.c, C0250b.general__shared__alpha_dismiss));
            this.f9743k.setVisibility(4);
            this.f9755w = 0;
            return;
        }
        this.f9755w++;
    }
}
