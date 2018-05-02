package com.duokan.reader.ui.reading;

import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.DownloadType;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.bookshelf.hv;
import com.duokan.reader.ui.general.gs;
import java.util.LinkedList;

public class afm extends gs implements C0780k, hv {
    /* renamed from: a */
    private final afn f9638a = new afn(this, getContext(), this);
    /* renamed from: b */
    private final LinkedList<TtsSpeaker> f9639b = new LinkedList();
    /* renamed from: c */
    private final LinkedList<TtsSpeaker> f9640c = new LinkedList();

    public afm(IFeature mFeature) {
        super(mFeature);
        setContentView(this.f9638a);
    }

    protected void onActive(boolean z) {
        super.onActive(z);
        this.f9638a.m11523b(true);
    }

    protected void onAttachToStub() {
        super.onAttachToStub();
        C1016b.m7857p().m7872a((C0780k) this);
    }

    protected void onDetachFromStub() {
        super.onDetachFromStub();
        C1016b.m7857p().m7880b((C0780k) this);
    }

    /* renamed from: a */
    public void mo1878a(int i, int i2) {
        this.f9638a.mo2231c(i, i2);
    }

    /* renamed from: b */
    public void mo1880b() {
        this.f9638a.mo2232q();
    }

    /* renamed from: c */
    public void mo1882c() {
        this.f9638a.m11532m();
    }

    /* renamed from: d */
    public void mo1883d() {
        this.f9638a.m11533n();
    }

    /* renamed from: a */
    public void mo1879a(Runnable runnable) {
        this.f9638a.m13518a(runnable);
    }

    /* renamed from: e */
    public int mo1884e() {
        return this.f9638a.getSelectedCount();
    }

    /* renamed from: f */
    public void mo1885f() {
        this.f9638a.mo1891a();
    }

    /* renamed from: g */
    public boolean mo1886g() {
        return this.f9638a.mo1939c();
    }

    /* renamed from: h */
    public void mo1887h() {
        this.f9638a.mo1892b();
    }

    /* renamed from: b */
    public void mo1881b(int i, int i2) {
        this.f9638a.m11522b(i, i2);
    }

    /* renamed from: i */
    public String mo1888i() {
        return getString(C0258j.reading__tts_setting_view__edit_title);
    }

    /* renamed from: j */
    public String mo1889j() {
        return getString(C0258j.reading__tts_setting_view__edit_selected);
    }

    /* renamed from: k */
    public String mo1890k() {
        return null;
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask.m7802p().mo1474a() == DownloadType.TTS_PACK && downloadCenterTask.m7793g()) {
            this.f9638a.m11523b(false);
        }
    }
}
