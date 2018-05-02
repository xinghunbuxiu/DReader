package com.duokan.reader.ui.reading;

import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.account.User;
import com.duokan.reader.domain.tts.TtsManager;
import com.duokan.reader.domain.tts.TtsManager.TtsSpeaker;
import com.duokan.reader.ui.bookshelf.hd;
import com.duokan.reader.ui.general.DkSmallFaceView;
import com.duokan.reader.ui.general.expandable.ViewMode;
import java.util.Iterator;

class afq extends hd {
    /* renamed from: a */
    final /* synthetic */ afm f9646a;
    /* renamed from: c */
    final /* synthetic */ afn f9647c;

    afq(afn afn, afm afm) {
        this.f9647c = afn;
        this.f9646a = afm;
    }

    /* renamed from: d */
    public /* synthetic */ Object mo509d(int i) {
        return m13535h(i);
    }

    /* renamed from: a */
    public View mo482a(View view, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f9647c.getContext()).inflate(C0256h.reading__tts_setting_empty_view, null);
        inflate.findViewById(C0255g.reading__tts_setting_empty_view__add_speaker).setOnClickListener(new afr(this));
        return inflate;
    }

    /* renamed from: d */
    public View mo508d(int i, View view, ViewGroup viewGroup) {
        return m13524e(i, view, viewGroup);
    }

    /* renamed from: c */
    public int mo506c() {
        return this.f9647c.f9641a.f9639b.size() + this.f9647c.f9641a.f9640c.size();
    }

    /* renamed from: h */
    public TtsSpeaker m13535h(int i) {
        Pair a = this.f9647c.m13515a(i);
        if (((Integer) a.first).intValue() > 0) {
            return (TtsSpeaker) this.f9647c.f9641a.f9640c.get(((Integer) a.second).intValue());
        }
        if (this.f9647c.f9641a.f9639b.isEmpty()) {
            return (TtsSpeaker) this.f9647c.f9641a.f9640c.get(((Integer) a.second).intValue());
        }
        return (TtsSpeaker) this.f9647c.f9641a.f9639b.get(((Integer) a.second).intValue());
    }

    /* renamed from: a */
    public int mo486a() {
        int i = 0;
        if (!this.f9647c.f9641a.f9640c.isEmpty()) {
            i = 1;
        }
        if (this.f9647c.f9641a.f9639b.isEmpty()) {
            return i;
        }
        return i + 1;
    }

    /* renamed from: e */
    protected boolean mo1712e() {
        mo1557e(0);
        return true;
    }

    /* renamed from: e */
    protected void mo1557e(int i) {
        this.f9647c.f9641a.f9640c.clear();
        this.f9647c.f9641a.f9639b.clear();
        Iterator it = TtsManager.get().getSpeakerList().iterator();
        while (it.hasNext()) {
            TtsSpeaker ttsSpeaker = (TtsSpeaker) it.next();
            if (ttsSpeaker.mEngineType.equals("local")) {
                this.f9647c.f9641a.f9639b.add(ttsSpeaker);
            } else {
                this.f9647c.f9641a.f9640c.add(ttsSpeaker);
            }
        }
        m8785a(false);
    }

    /* renamed from: b */
    protected void mo1555b() {
    }

    /* renamed from: a */
    public int mo487a(int i) {
        if (i == 1 || this.f9647c.f9641a.f9639b.isEmpty()) {
            return this.f9647c.f9641a.f9640c.size();
        }
        return this.f9647c.f9641a.f9639b.size();
    }

    /* renamed from: a */
    public View mo488a(int i, View view, ViewGroup viewGroup) {
        return m13523a(i, viewGroup);
    }

    /* renamed from: a */
    private View m13523a(int i, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(this.f9647c.getContext()).inflate(C0256h.reading__tts_setting_view_item_header_view, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(C0255g.reading__tts_setting_view__label);
        if (i == 0) {
            inflate.findViewById(C0255g.reading__tts_setting_view__divider_top).setVisibility(8);
            textView.setText(this.f9647c.f9641a.getString(this.f9647c.f9641a.f9639b.size() > 0 ? C0258j.reading__tts_setting_view__local : C0258j.reading__tts_setting_view__cloud));
        } else {
            textView.setText(this.f9647c.f9641a.getString(C0258j.reading__tts_setting_view__cloud));
        }
        return inflate;
    }

    /* renamed from: e */
    private View m13524e(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.f9647c.getContext()).inflate(C0256h.reading__tts_setting_view_item_view, viewGroup, false);
        }
        TtsSpeaker h = m13535h(i);
        DkSmallFaceView dkSmallFaceView = (DkSmallFaceView) view.findViewById(C0255g.reading__tts_setting_view__speaker_icon);
        User user = new User();
        user.mIconUrl = h.mUserIcon;
        dkSmallFaceView.setUser(user);
        ((TextView) view.findViewById(C0255g.reading__tts_setting_view__speaker_gender)).setText(h.mField);
        ((TextView) view.findViewById(C0255g.reading__tts_setting_view__speaker_name)).setText(h.mNickname);
        CheckBox checkBox = (CheckBox) view.findViewById(C0255g.reading__tts_setting_view__checkbox);
        View findViewById = view.findViewById(C0255g.reading__tts_setting_view__container);
        if (mo1714f() == ViewMode.Edit) {
            checkBox.setVisibility(0);
            findViewById.setVisibility(8);
            Pair a = this.f9647c.m13515a(i);
            checkBox.setChecked(mo1713b(((Integer) a.first).intValue(), ((Integer) a.second).intValue()));
        } else {
            findViewById.setVisibility(0);
            checkBox.setVisibility(8);
            checkBox = (CheckBox) view.findViewById(C0255g.reading__tts_setting_view__status);
            findViewById = view.findViewById(C0255g.reading__tts_setting_view__select);
            if (TtsManager.get().getCurrentSpeaker().equals(h)) {
                checkBox.setVisibility(0);
                checkBox.setChecked(true);
                findViewById.setVisibility(4);
            } else {
                checkBox.setVisibility(4);
                findViewById.setVisibility(0);
            }
        }
        view.findViewById(C0255g.reading__tts_setting_view__select).setOnClickListener(new aft(this, h));
        return view;
    }
}
