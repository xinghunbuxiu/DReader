package com.duokan.reader.domain.plugins.dict;

import com.duokan.b.f;
import com.duokan.b.g;
import com.duokan.b.i;
import com.duokan.core.app.y;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.aj;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.b;
import com.duokan.reader.domain.downloadcenter.k;
import com.duokan.reader.ui.general.HeaderView;
import com.duokan.reader.ui.general.hd;
import com.duokan.reader.ui.reading.sh;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DictDownloadController extends hd implements k {
    private HatGridView a;
    private sh b;
    private aj c = null;
    private final List d = new ArrayList();

    enum DictDownloadState {
        FRESH,
        RUNNING,
        PAUSED,
        DOWNLOADED
    }

    public DictDownloadController(y yVar) {
        super(yVar);
        setContentView(g.reading__translation_settings__view);
        this.b = (sh) getContext().queryFeature(sh.class);
        ((HeaderView) findViewById(f.reading__translation_settings__header)).setLeftTitle(i.reading__translation_settings__header);
        this.a = (HatGridView) findViewById(f.reading__translation_settings__dict_list);
        this.c = new a(this);
        this.a.setAdapter(this.c);
        a();
    }

    public void a(DownloadCenterTask downloadCenterTask) {
        this.c.d();
    }

    public void b(DownloadCenterTask downloadCenterTask) {
        this.c.d();
    }

    private void a() {
        this.d.add(new i(this, "英汉词典", "ec_xiaobai.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p01fn2Iw1kmm/jxcT5b01vIjKrN.zip", "95622d8a6a5f665b559b823e0aa9c77c", "2.50M"));
        this.d.add(new i(this, "汉英词典", "ce_xiaobai.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p01W7D6BWnnX/91Yrw9TM6rOXBj.zip", "7581400b32e3904a092e7436bd3caefc", "1.78M"));
        this.d.add(new i(this, "汉汉词典", "cc.dic", "http://ota.read.duokan.com/mfsv2/download/s010/p015SNEXd0iT/pZeWr94JTjorm7.zip", "29d3dba9de5f39f617369a856feea182", "3.38MB"));
        this.c.d();
    }

    private DictDownloadState a(String str) {
        if (new File(str).exists()) {
            return DictDownloadState.DOWNLOADED;
        }
        if (new File(str + ".tmp").exists()) {
            DownloadCenterTask b = b.n().b(str);
            if (b != null) {
                if (b.b()) {
                    return DictDownloadState.PAUSED;
                }
                if (b.d()) {
                    return DictDownloadState.RUNNING;
                }
            }
            new File(str + ".tmp").delete();
        }
        return DictDownloadState.FRESH;
    }

    protected void onActive(boolean z) {
        b.n().a((k) this);
    }

    protected void onDeactive() {
        b.n().b((k) this);
        super.onDeactive();
    }
}
