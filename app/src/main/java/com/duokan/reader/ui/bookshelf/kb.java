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
import com.duokan.reader.ui.C0435s;
import java.net.InetAddress;

public class kb extends kf {
    /* renamed from: h */
    private View f6702h;
    /* renamed from: i */
    private TextView f6703i;
    /* renamed from: j */
    private TextView f6704j;
    /* renamed from: k */
    private TextView f6705k;
    /* renamed from: l */
    private TextView f6706l;

    public kb(IFeature mFeature) {
        super(mFeature);
        View inflate = LayoutInflater.from(getContext()).inflate(C0256h.bookshelf__wifi_book_transfer_view, (ViewGroup) getContentView(), false);
        this.f6702h = inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__setting);
        this.f6703i = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__title);
        this.f6704j = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__subtitle);
        this.f6705k = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__wifi_icon);
        this.f6706l = (TextView) inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__address);
        this.f6702h.setOnClickListener(new kc(this));
        inflate.findViewById(C0255g.bookshelf__wifi_book_transfer_view__cancel).setOnClickListener(new kd(this));
        m9490a(inflate);
        inflate.setPadding(0, ((C0435s) mFeature.queryFeature(C0435s.class)).getTheme().getHeaderPaddingTop(), 0, 0);
    }

    /* renamed from: e */
    protected void mo1721e() {
        int wifiState = ((WifiManager) getContext().getSystemService("wifi")).getWifiState();
        switch (wifiState) {
            case 1:
                this.f6702h.setVisibility(0);
                this.f6703i.setText(C0258j.bookshelf__wifi_book_transfer_view__wifi_disable);
                this.f6703i.setTextColor(getResources().getColor(C0252d.general__shared__333333));
                this.f6704j.setText(C0258j.bookshelf__wifi_book_transfer_view__check_wifi);
                this.f6704j.setVisibility(0);
                this.f6705k.setText(C0258j.bookshelf__wifi_book_transfer_view__http_server_disable);
                break;
            case 3:
                this.f6702h.setVisibility(8);
                this.f6703i.setText(C0258j.bookshelf__wifi_book_transfer_view__wifi_enable);
                this.f6703i.setTextColor(getResources().getColor(C0252d.general__shared__318aee));
                this.f6704j.setVisibility(8);
                break;
        }
        this.f6705k.setSelected(false);
        this.f6706l.setVisibility(8);
        if (wifiState == 3) {
            InetAddress a = C0559f.m2476b().getInetAddress();
            if (a != null) {
                this.f6705k.setSelected(true);
                this.f6706l.setVisibility(0);
                this.f6705k.setText(C0258j.bookshelf__wifi_book_transfer_view__http_addr);
                this.f6706l.setText("http://" + a.getHostAddress() + ":" + this.c.m2222a());
                return;
            }
            this.f6705k.setText(C0258j.bookshelf__wifi_transfer_view__get_url);
            runLater(new ke(this), 2000);
        }
    }

    /* renamed from: f */
    protected void mo1724f() {
        if (this.a != null) {
            this.f6704j.setVisibility(0);
            this.f6704j.setText(C0258j.bookshelf__wifi_book_transfer_view__transfer_tips);
            return;
        }
        this.f6704j.setVisibility(8);
    }
}
