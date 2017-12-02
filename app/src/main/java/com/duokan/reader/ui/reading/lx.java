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

import com.duokan.reader.domain.document.ah;
import com.duokan.reader.ui.general.be;
import com.duokan.reader.ui.reading.a.z;

import java.io.FileInputStream;

public abstract class lx implements OnCompletionListener, OnPreparedListener, z, ace {
    protected final sh a;
    protected mb b;
    protected Activity c;
    protected Handler d = new ly(this);
    private MediaPlayer e;
    private ah f;
    private Rect g;
    private BroadcastReceiver h;
    private boolean i = false;
    private AudioManager j = null;
    private OnAudioFocusChangeListener k = null;

    protected abstract void a();

    public abstract View b();

    public lx(Activity activity, sh shVar, ah ahVar, Rect rect, mb mbVar) {
        this.c = activity;
        this.a = shVar;
        this.f = ahVar;
        this.g = rect;
        this.e = new MediaPlayer();
        this.b = mbVar;
        this.h = new lz(this);
        this.c.registerReceiver(this.h, new IntentFilter("android.intent.action.SCREEN_OFF"));
        this.j = (AudioManager) this.c.getSystemService("audio");
        this.k = new ma(this);
    }

    public ah d() {
        return this.f;
    }

    public Rect e() {
        return this.g;
    }

    public boolean f() {
        g();
        return true;
    }

    public void g() {
        this.f = null;
        this.i = false;
        this.d.removeMessages(1);
        this.e.release();
        acb.a().c();
        this.b.a();
        try {
            this.c.unregisterReceiver(this.h);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (this.j != null && this.k != null) {
            this.j.abandonAudioFocus(this.k);
        }
    }

    public void c() {
    }

    public void a(Configuration configuration) {
    }

    public boolean h() {
        return false;
    }

    public boolean i() {
        return false;
    }

    public boolean j() {
        return false;
    }

    public void k() {
        be.a(this.c, j.reading__media_loading_failed, 1).show();
        g();
    }

    public void l() {
        try {
            this.e.setDataSource(new FileInputStream(acb.a().b()).getFD());
            this.e.setAudioStreamType(3);
            this.e.prepareAsync();
            this.e.setOnPreparedListener(this);
            this.e.setOnCompletionListener(this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void m() {
        this.b.c();
        acb.a().a(this.a.G().aF(), this.f, this.c, this);
        this.i = true;
        this.a.a(4, 0);
        if (this.j != null && this.k != null) {
            this.j.requestAudioFocus(this.k, 3, 1);
        }
    }

    protected MediaPlayer n() {
        return this.e;
    }
}
