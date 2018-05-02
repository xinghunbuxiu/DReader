package com.duokan.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.duokan.p023b.C0247i;
import com.duokan.reader.domain.account.C0709k;
import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ea;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.C0901g;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.apache.http.protocol.HTTP;

/* renamed from: com.duokan.common.b */
public class C0260b {
    /* renamed from: a */
    static final /* synthetic */ boolean f437a = (!C0260b.class.desiredAssertionStatus());

    /* renamed from: a */
    public static void m569a(Context context, C0800c c0800c, HashMap<C0798a, C0901g> hashMap, List<C0798a> list) {
        if (f437a || (list != null && list.size() > 0)) {
            Intent intent = new Intent("android.intent.action.SEND");
            UserAccount d = C0709k.m3476a().m3508d();
            String c = d == null ? "" : d.mo833c();
            intent.putExtra("android.intent.extra.EMAIL", new String[]{c});
            String format = String.format(context.getString(C0247i.reading__export_notes_title), new Object[]{c0800c.ay()});
            if (TextUtils.isEmpty(c0800c.m4150C())) {
                c = "";
            } else {
                c = String.format(context.getString(C0247i.reading__export_notes_author), new Object[]{c0800c.m4150C()});
            }
            intent.putExtra("android.intent.extra.SUBJECT", format + c);
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String string = context.getString(C0247i.reading__export_notes_item_note);
            stringBuffer.append(c0800c.ay()).append("\n\n");
            if (!TextUtils.isEmpty(c0800c.m4150C())) {
                stringBuffer.append(c0800c.m4150C()).append("\n");
            }
            for (C0798a c0798a : list) {
                if (hashMap.containsKey(c0798a)) {
                    stringBuffer.append("\n").append(" ").append(((C0901g) hashMap.get(c0798a)).mo1202e()).append("\n");
                }
                stringBuffer.append(" ").append(simpleDateFormat.format(new Date(c0798a.m3730g()))).append("\n");
                stringBuffer.append(c0798a.m3715a(false)).append("\n");
                if (!TextUtils.isEmpty(((ea) c0798a).m4384m())) {
                    stringBuffer.append(String.format(string, new Object[]{((ea) c0798a).m4384m()})).append("\n");
                }
            }
            intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            context.startActivity(Intent.createChooser(intent, context.getString(C0247i.reading__export_notes_prompt_title)));
            return;
        }
        throw new AssertionError();
    }

    /* renamed from: a */
    public static void m570a(Context context, List<DkCloudComment> list, String str, String str2) {
        if (f437a || (list != null && list.size() > 0)) {
            Intent intent = new Intent("android.intent.action.SEND");
            UserAccount d = C0709k.m3476a().m3508d();
            String c = d == null ? "" : d.mo833c();
            intent.putExtra("android.intent.extra.EMAIL", new String[]{c});
            c = String.format(context.getString(C0247i.reading__export_notes_title), new Object[]{str});
            if (!TextUtils.isEmpty(str2)) {
                c = c + String.format(context.getString(C0247i.reading__export_notes_author), new Object[]{str2});
            }
            intent.putExtra("android.intent.extra.SUBJECT", c);
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String string = context.getString(C0247i.reading__export_notes_item_note);
            stringBuffer.append(str).append("\n\n");
            if (!TextUtils.isEmpty(str2)) {
                stringBuffer.append(str2).append("\n");
            }
            for (DkCloudComment dkCloudComment : list) {
                stringBuffer.append(" ").append(simpleDateFormat.format(dkCloudComment.getCreationDate())).append("\n");
                stringBuffer.append(dkCloudComment.getSample()).append("\n");
                if (!TextUtils.isEmpty(dkCloudComment.getNoteText())) {
                    stringBuffer.append(String.format(string, new Object[]{dkCloudComment.getNoteText()})).append("\n");
                }
            }
            intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            context.startActivity(Intent.createChooser(intent, context.getString(C0247i.reading__export_notes_prompt_title)));
            return;
        }
        throw new AssertionError();
    }
}
