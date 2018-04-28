package com.duokan.reader.domain.plugins.dict;

import com.duokan.core.app.IFeature;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.aj;
import com.duokan.p023b.C0244f;
import com.duokan.p023b.C0245g;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.gs;
import com.duokan.reader.ui.reading.su;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DictDownloadController extends gs implements C0780k {
    /* renamed from: a */
    private HatGridView f5382a;
    /* renamed from: b */
    private su f5383b;
    /* renamed from: c */
    private aj f5384c = null;
    /* renamed from: d */
    private final List<C1114i> f5385d = new ArrayList();

    enum DictDownloadState {
        FRESH,
        RUNNING,
        PAUSED,
        DOWNLOADED
    }

    public DictDownloadController(IFeature mFeature) {
        super(mFeature);
        setContentView(C0245g.reading__translation_settings__view);
        this.f5383b = (su) getContext().queryFeature(su.class);
        ((HeaderView) findViewById(C0244f.reading__translation_settings__header)).setLeftTitle(C0247i.reading__translation_settings__header);
        this.f5382a = (HatGridView) findViewById(C0244f.reading__translation_settings__dict_list);
        this.f5384c = new C1106a(this);
        this.f5382a.setAdapter(this.f5384c);
        m8394a();
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        this.f5384c.mo1691d();
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        this.f5384c.mo1691d();
    }

    /* renamed from: a */
    private void m8394a() {
        this.f5385d.add(new C1114i(this, "英汉词典", "ec_xiaobai.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p01fn2Iw1kmm/jxcT5b01vIjKrN.zip", "95622d8a6a5f665b559b823e0aa9c77c", "2.50M"));
        this.f5385d.add(new C1114i(this, "汉英词典", "ce_xiaobai.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p01W7D6BWnnX/91Yrw9TM6rOXBj.zip", "7581400b32e3904a092e7436bd3caefc", "1.78M"));
        this.f5385d.add(new C1114i(this, "汉汉词典", "cc.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p015SNEXd0iT/pZeWr94JTjorm7.zip", "29d3dba9de5f39f617369a856feea182", "3.38MB"));
        this.f5384c.mo1691d();
    }

    /* renamed from: a */
    private DictDownloadState m8392a(String str) {
        if (new File(str).exists()) {
            return DictDownloadState.DOWNLOADED;
        }
        if (new File(str + ".tmp").exists()) {
            DownloadCenterTask b = C1016b.m7857p().m7877b(str);
            if (b != null) {
                if (b.m7788b()) {
                    return DictDownloadState.PAUSED;
                }
                if (b.m7790d()) {
                    return DictDownloadState.RUNNING;
                }
            }
            new File(str + ".tmp").delete();
        }
        return DictDownloadState.FRESH;
    }

    protected void onActive(boolean z) {
        C1016b.m7857p().m7872a((C0780k) this);
    }

    protected void onDeactive() {
        C1016b.m7857p().m7880b((C0780k) this);
        super.onDeactive();
    }
}
