package com.duokan.reader.ui.bookshelf;

import android.net.wifi.WifiManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.duokan.core.app.IFeature;

import java.net.InetAddress;

public class ir extends iv {
    private View h;
    private TextView i;
    private TextView j;
    private TextView k;
    private TextView l;

    public ir(IFeature featrue) {
        super(featrue);
        View inflate = LayoutInflater.from(getContext()).inflate(h.bookshelf__wifi_book_transfer_view, (ViewGroup) getContentView(), false);
        this.h = inflate.findViewById(g.bookshelf__wifi_book_transfer_view__setting);
        this.i = (TextView) inflate.findViewById(g.bookshelf__wifi_book_transfer_view__title);
        this.j = (TextView) inflate.findViewById(g.bookshelf__wifi_book_transfer_view__subtitle);
        this.k = (TextView) inflate.findViewById(g.bookshelf__wifi_book_transfer_view__wifi_icon);
        this.l = (TextView) inflate.findViewById(g.bookshelf__wifi_book_transfer_view__address);
        this.h.setOnClickListener(new is(this));
        inflate.findViewById(g.bookshelf__wifi_book_transfer_view__cancel).setOnClickListener(new it(this));
        a(inflate);
    }

    protected void c() {
        int wifiState = ((WifiManager) getContext().getSystemService("wifi")).getWifiState();
        switch (wifiState) {
            case 1:
                this.h.setVisibility(0);
                this.i.setText(j.bookshelf__wifi_book_transfer_view__wifi_disable);
                this.i.setTextColor(getResources().getColor(d.general__shared__333333));
                this.j.setText(j.bookshelf__wifi_book_transfer_view__check_wifi);
                this.j.setVisibility(0);
                this.k.setText(j.bookshelf__wifi_book_transfer_view__http_server_disable);
                break;
            case 3:
                this.h.setVisibility(8);
                this.i.setText(j.bookshelf__wifi_book_transfer_view__wifi_enable);
                this.i.setTextColor(getResources().getColor(d.general__shared__318aee));
                this.j.setVisibility(8);
                break;
        }
        this.k.setSelected(false);
        this.l.setVisibility(8);
        if (wifiState == 3) {
            InetAddress a = f.b().a();
            if (a != null) {
                this.k.setSelected(true);
                this.l.setVisibility(0);
                this.k.setText(j.bookshelf__wifi_book_transfer_view__http_addr);
                this.l.setText("http://" + a.getHostAddress() + ":" + this.c.a());
                return;
            }
            this.k.setText(j.bookshelf__wifi_transfer_view__get_url);
            runLater(new iu(this), 2000);
        }
    }

    protected void d() {
        if (this.a != null) {
            this.j.setVisibility(0);
            this.j.setText(j.bookshelf__wifi_book_transfer_view__transfer_tips);
            return;
        }
        this.j.setVisibility(8);
    }
}
