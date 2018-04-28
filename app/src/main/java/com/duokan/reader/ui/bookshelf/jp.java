package com.duokan.reader.ui.bookshelf;

import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0252d;
import com.duokan.p024c.C0255g;
import com.duokan.p024c.C0256h;
import com.duokan.p024c.C0258j;
import com.duokan.reader.common.p037c.C0559f;
import java.net.InetAddress;

public class jp extends jt {
    /* renamed from: h */
    private View f6683h;
    /* renamed from: i */
    private TextView f6684i;
    /* renamed from: j */
    private TextView f6685j;
    /* renamed from: k */
    private TextView f6686k;
    /* renamed from: l */
    private TextView f6687l;

    public jp(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__wifi_book_transfer_view, (ViewGroup) getContentView(), false);
        this.f6683h = inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__setting);
        this.f6684i = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__title);
        this.f6685j = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__subtitle);
        this.f6686k = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__wifi_icon);
        this.f6687l = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__address);
        this.f6683h.setOnClickListener(new jq(this));
        inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__cancel).setOnClickListener(new jr(this));
        m9490a(inflate);
    }

    /* renamed from: e */
    protected void mo1721e() {
        int wifiState = ((WifiManager) getContext().getSystemService("wifi")).getWifiState();
        switch (wifiState) {
            case 1:
                this.f6683h.setVisibility(0);
                this.f6684i.setText(C0258j.bookshelf__wifi_book_transfer_view__wifi_disable);
                this.f6684i.setTextColor(getResources().getColor(C0252d.general__shared__333333));
                this.f6685j.setText(C0258j.bookshelf__wifi_book_transfer_view__check_wifi);
                this.f6685j.setVisibility(0);
                this.f6686k.setText(C0258j.bookshelf__wifi_book_transfer_view__http_server_disable);
                break;
            case 3:
                this.f6683h.setVisibility(8);
                this.f6684i.setText(C0258j.bookshelf__wifi_book_transfer_view__wifi_enable);
                this.f6684i.setTextColor(getResources().getColor(C0252d.general__shared__318aee));
                this.f6685j.setVisibility(8);
                break;
        }
        this.f6686k.setSelected(false);
        this.f6687l.setVisibility(8);
        if (wifiState == 3) {
            InetAddress a = C0559f.m2476b().m2479a();
            if (a != null) {
                this.f6686k.setSelected(true);
                this.f6687l.setVisibility(0);
                this.f6686k.setText(C0258j.bookshelf__wifi_book_transfer_view__http_addr);
                this.f6687l.setText("http://" + a.getHostAddress() + ":" + this.c.m2222a());
                return;
            }
            this.f6686k.setText(C0258j.bookshelf__wifi_transfer_view__get_url);
            runLater(new js(this), 2000);
        }
    }

    /* renamed from: f */
    protected void mo1722f() {
        if (this.a != null) {
            this.f6685j.setVisibility(0);
            this.f6685j.setText(C0258j.bookshelf__wifi_book_transfer_view__transfer_tips);
            return;
        }
        this.f6685j.setVisibility(8);
    }
}
