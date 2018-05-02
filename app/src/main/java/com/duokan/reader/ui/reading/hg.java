package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.duokan.core.io.FileUtil;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.DkPublic;
import com.duokan.reader.domain.downloadcenter.C0780k;
import com.duokan.reader.domain.downloadcenter.C1016b;
import com.duokan.reader.domain.downloadcenter.C1025l;
import com.duokan.reader.domain.downloadcenter.DownloadCenterTask;
import com.duokan.reader.domain.downloadcenter.aa;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.general.FileTransferPrompter;
import com.duokan.reader.ui.general.FileTransferPrompter.FlowChargingTransferChoice;
import com.duokan.reader.ui.general.ap;
import com.duokan.reader.ui.general.be;

public class hg extends ap implements C0780k {
    /* renamed from: a */
    private final ProgressBar f10318a = ((ProgressBar) findViewById(C0255g.reading__tts_progress_view__progress_bar));
    /* renamed from: b */
    private final TtsManager f10319b = TtsManager.get();
    /* renamed from: c */
    private final TextView f10320c = ((TextView) findViewById(C0255g.reading__tts_progress_view__progress));
    /* renamed from: d */
    private final TtsSpeaker f10321d = new TtsSpeaker(this.f10323f);
    /* renamed from: e */
    private final String f10322e = "{\"accent\":\"普通话\",\"age\":20,\"appid\":\"597a9476\",\"description\":\"\",\"downloads\":0,\"engineType\":\"local\",\"engineVersion\":1,\"ent\":\"\",\"field\":\"\",\"isActive\":1,\"isDefault\":0,\"isNew\":0,\"isRecommend\":0,\"isVip\":0,\"largeIcon\":\"\",\"level\":0,\"listenPath\":\"\",\"name\":\"common\",\"nickname\":\"基础资源\",\"price\":0,\"resId\":700,\"resPath\":\"\",\"resSize\":2819436,\"sex\":\"female\",\"smallIcon\":\"https:\\/\\/bj.openstorage.cn\\/v1\\/iflytek\\/tts\\/common\\/icon\\/common.png\",\"sortId\":0,\"speakerId\":-1,\"updateTime\":\"\",\"version\":1}";
    /* renamed from: f */
    private final String f10323f = "{\"accent\":\"普通话\",\"age\":24,\"appid\":\"597a9476\",\"commonExpirationDate\":\"\",\"description\":\"\",\"downloads\":0,\"engineType\":\"local\",\"engineVersion\":1,\"ent\":\"\",\"experienceExpirationDate\":\"\",\"field\":\"普通发音人\",\"isActive\":1,\"isDefault\":0,\"isNew\":0,\"isRecommend\":0,\"isVip\":0,\"largeIcon\":\"https:\\/\\/bj.openstorage.cn\\/v1\\/iflytek\\/tts\\/common\\/icon\\/xiaoyan_big.png\",\"level\":0,\"listenPath\":\"aHR0cHM6Ly9iai5vcGVuc3RvcmFnZS5jbi92MS9pZmx5dGVrL3R0cy9jb21tb24vbGlzdGVuL3hpYW95YW4ubXAz\",\"name\":\"xiaoyan\",\"nickname\":\"王老师\",\"price\":0,\"resId\":712,\"resPath\":\"\",\"resSize\":2065412,\"sex\":\"female\",\"smallIcon\":\"https:\\/\\/bj.openstorage.cn\\/v1\\/iflytek\\/tts\\/common\\/icon\\/xiaoyan_small.png\",\"sortId\":11,\"speakerId\":3,\"updateTime\":\"\",\"version\":1}";
    /* renamed from: g */
    private DownloadCenterTask f10324g;

    public hg(Context context) {
        super(context);
        ViewGroup viewGroup = (ViewGroup) getContentView();
        viewGroup.removeAllViews();
        viewGroup.addView(LayoutInflater.from(getContext()).inflate(C0256h.reading__tts_progress_view, null));
    }

    protected void onShow() {
        C1016b.m7857p().m7872a((C0780k) this);
        if (!m14320a()) {
            be.m10286a(getContext(), C0258j.bookshelf__general_shared__download_failed, 0).show();
            dismiss();
        }
    }

    public void cancel() {
        if (m14321b()) {
            C1016b.m7857p().m7885c(this.f10324g);
            ap apVar = new ap(getContext());
            apVar.setOkLabelResid(C0258j.general__shared__stop);
            apVar.setCancelLabel(C0258j.general__shared__continue);
            apVar.setCancelOnBack(true);
            apVar.setCancelOnTouchOutside(true);
            apVar.setPrompt(C0258j.reading__tts_web_view__download_prompt);
            apVar.open(new hh(this));
            return;
        }
        super.cancel();
    }

    protected void onNo() {
        super.onNo();
    }

    protected void onDismiss() {
        super.onDismiss();
        C1016b.m7857p().m7880b((C0780k) this);
    }

    /* renamed from: a */
    private boolean m14313a(FlowChargingTransferChoice flowChargingTransferChoice) {
        try {
            C1025l c1025l = new C1025l();
            c1025l.f5079a = "讯飞语音包";
            c1025l.f5083e = new aa();
            c1025l.f5083e.f5036m = flowChargingTransferChoice;
            c1025l.f5080b = "https://cdn.cnbj1.fds.api.mi-img.com/dkreader/android/tts/xunfei_voices.zip";
            c1025l.f5081c = this.f10319b.getTtsDir().getAbsolutePath() + "/" + System.currentTimeMillis() + ".tts";
            this.f10324g = C1016b.m7857p().m7865a(c1025l);
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: a */
    public boolean m14320a() {
        try {
            if (!FileUtil.deleteFile(this.f10319b.getTtsDir())) {
                return false;
            }
            long defaultPackSize = this.f10319b.getDefaultPackSize();
            FileTransferPrompter.m9977a(getContext(), defaultPackSize, getContext().getString(C0258j.reading__tts_web_view__need_data), String.format(getContext().getString(C0258j.reading__tts_web_view__data_usage), new Object[]{DkPublic.formatBytes(defaultPackSize)}), new hi(this));
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    /* renamed from: b */
    public boolean m14321b() {
        return (this.f10324g == null || this.f10324g.m7792f()) ? false : true;
    }

    /* renamed from: c */
    private void m14317c() {
        if (this.f10324g != null) {
            C1016b.m7857p().m7871a(this.f10324g);
        }
        FileUtil.deleteFile(this.f10319b.getTtsDir());
        dismiss();
    }

    /* renamed from: d */
    private void m14319d() {
        if (this.f10324g != null) {
            C1016b.m7857p().m7879b(this.f10324g);
        }
    }

    public void onTaskRunning(DownloadCenterTask downloadCenterTask) {
        if (this.f10324g == downloadCenterTask) {
            m14311a(downloadCenterTask.m7799m());
        }
    }

    public void onTaskStatusChanged(DownloadCenterTask downloadCenterTask) {
        if (downloadCenterTask == this.f10324g) {
            if (downloadCenterTask.m7792f()) {
                this.f10324g = null;
                if (downloadCenterTask.m7794h()) {
                    be.m10286a(getContext(), C0258j.bookshelf__general_shared__download_failed, 0).show();
                    FileUtil.deleteFile(this.f10319b.getTtsDir());
                    dismiss();
                    return;
                }
                this.f10319b.setBaseResourceDownloaded(true);
                this.f10319b.addSelectedSpeaker(this.f10322e);
                this.f10319b.addSelectedSpeaker(this.f10323f);
                this.f10321d.mSpeakerPath = this.f10319b.generateSpeakerPath(this.f10319b.getTtsFileUri(this.f10321d) + "/" + this.f10321d.mName + ".jet");
                this.f10319b.addSpeaker(this.f10321d);
                C1016b.m7857p().m7887d(downloadCenterTask);
                dismiss();
                ap apVar = new ap(getContext());
                apVar.setOkLabelResid(C0258j.reading__tts_view__use_now);
                apVar.setNoLabel(C0258j.reading__tts_view__more_speaker);
                apVar.setCancelOnBack(true);
                apVar.setCancelOnTouchOutside(false);
                apVar.setTitle(C0258j.reading__tts_view__download_succeed);
                apVar.open(new hj(this));
            } else if (downloadCenterTask.m7789c()) {
                long defaultPackSize = this.f10319b.getDefaultPackSize() - downloadCenterTask.m7799m();
                if (defaultPackSize == 0) {
                    C1016b.m7857p().m7879b(downloadCenterTask);
                    return;
                }
                FileTransferPrompter.m9977a(getContext(), defaultPackSize, getContext().getString(C0258j.reading__tts_web_view__need_data), String.format(getContext().getString(C0258j.reading__tts_web_view__data_usage), new Object[]{DkPublic.formatBytes(defaultPackSize)}), new hk(this, downloadCenterTask));
            }
        }
    }

    /* renamed from: a */
    private void m14311a(long j) {
        int min = Math.min((int) ((((float) j) / ((float) this.f10319b.getDefaultPackSize())) * 100.0f), 100);
        if (this.f10318a != null) {
            this.f10318a.setProgress(min);
            this.f10320c.setText(min + "%");
        }
    }
}
