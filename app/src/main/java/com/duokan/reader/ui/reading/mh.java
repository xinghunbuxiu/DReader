package com.duokan.reader.ui.reading;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.media.AudioManager;
import android.media.AudioManager.OnAudioFocusChangeListener;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnPreparedListener;
import android.os.Handler;
import android.view.View;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.reading.p054a.C1445z;
import java.io.FileInputStream;

public abstract class mh implements OnCompletionListener, OnPreparedListener, C1445z, acr {
    /* renamed from: a */
    protected final su f9725a;
    /* renamed from: b */
    protected ml f9726b;
    /* renamed from: c */
    protected Activity f9727c;
    /* renamed from: d */
    protected Handler f9728d = new mi(this);
    /* renamed from: e */
    private MediaPlayer f9729e;
    /* renamed from: f */
    private ah f9730f;
    /* renamed from: g */
    private Rect f9731g;
    /* renamed from: h */
    private BroadcastReceiver f9732h;
    /* renamed from: i */
    private boolean f9733i = false;
    /* renamed from: j */
    private AudioManager f9734j = null;
    /* renamed from: k */
    private OnAudioFocusChangeListener f9735k = null;

    /* renamed from: a */
    protected abstract void mo2265a();

    /* renamed from: b */
    public abstract View mo2270b();

    public mh(Activity activity, su suVar, ah ahVar, Rect rect, ml mlVar) {
        this.f9727c = activity;
        this.f9725a = suVar;
        this.f9730f = ahVar;
        this.f9731g = rect;
        this.f9729e = new MediaPlayer();
        this.f9726b = mlVar;
        this.f9732h = new mj(this);
        this.f9727c.registerReceiver(this.f9732h, new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.f9734j = (AudioManager) this.f9727c.getSystemService("audio");
        this.f9735k = new mk(this);
    }

    /* renamed from: d */
    public ah m13679d() {
        return this.f9730f;
    }

    /* renamed from: e */
    public Rect m13680e() {
        return this.f9731g;
    }

    /* renamed from: f */
    public boolean mo2271f() {
        m13682g();
        return true;
    }

    /* renamed from: g */
    public void m13682g() {
        this.f9730f = null;
        this.f9733i = false;
        this.f9728d.removeMessages(1);
        this.f9729e.release();
        aco.m13312a().m13323c();
        this.f9726b.mo2426a();
        try {
            this.f9727c.unregisterReceiver(this.f9732h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.f9734j != null && this.f9735k != null) {
            this.f9734j.abandonAudioFocus(this.f9735k);
        }
    }

    /* renamed from: c */
    public void mo2514c() {
    }

    /* renamed from: a */
    public void mo2267a(Configuration configuration) {
    }

    /* renamed from: h */
    public boolean mo2272h() {
        return false;
    }

    /* renamed from: i */
    public boolean mo2273i() {
        return false;
    }

    /* renamed from: j */
    public boolean mo2274j() {
        return false;
    }

    /* renamed from: k */
    public void mo2263k() {
        be.m10286a(this.f9727c, C0258j.reading__media_loading_failed, 1).show();
        m13682g();
    }

    /* renamed from: l */
    public void mo2264l() {
        try {
            this.f9729e.setDataSource(new FileInputStream(aco.m13312a().m13322b()).getFD());
            this.f9729e.setAudioStreamType(3);
            this.f9729e.prepareAsync();
            this.f9729e.setOnPreparedListener(this);
            this.f9729e.setOnCompletionListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: m */
    protected void m13688m() {
        this.f9726b.mo2429c();
        aco.m13312a().m13321a(this.f9725a.mo1992G().aH(), this.f9730f, this.f9727c, this);
        this.f9733i = true;
        this.f9725a.mo2040a(4, 0);
        if (this.f9734j != null && this.f9735k != null) {
            this.f9734j.requestAudioFocus(this.f9735k, 3, 1);
        }
    }

    /* renamed from: n */
    protected MediaPlayer m13689n() {
        return this.f9729e;
    }
}
