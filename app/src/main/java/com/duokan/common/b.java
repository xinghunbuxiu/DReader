package com.duokan.common;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;

import com.duokan.reader.domain.account.UserAccount;
import com.duokan.reader.domain.account.i;
import com.duokan.reader.domain.bookshelf.a;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ef;
import com.duokan.reader.domain.cloud.DkCloudComment;
import com.duokan.reader.domain.document.g;

import org.apache.http.protocol.HTTP;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class b {
    static final /* synthetic */ boolean a = (!b.class.desiredAssertionStatus());

    public static void a(Context context, c cVar, HashMap hashMap, List list) {
        if (a || (list != null && list.size() > 0)) {
            Intent intent = new Intent("android.intent.action.SEND");
            UserAccount c = i.f().c();
            String c2 = c == null ? "" : c.c();
            intent.putExtra("android.intent.extra.EMAIL", new String[]{c2});
            String format = String.format(context.getString(com.duokan.b.i.reading__export_notes_title), new Object[]{cVar.aw()});
            if (TextUtils.isEmpty(cVar.B())) {
                c2 = "";
            } else {
                c2 = String.format(context.getString(com.duokan.b.i.reading__export_notes_author), new Object[]{cVar.B()});
            }
            intent.putExtra("android.intent.extra.SUBJECT", format + c2);
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String string = context.getString(com.duokan.b.i.reading__export_notes_item_note);
            stringBuffer.append(cVar.aw()).append("\n\n");
            if (!TextUtils.isEmpty(cVar.B())) {
                stringBuffer.append(cVar.B()).append("\n");
            }
            for (a aVar : list) {
                if (hashMap.containsKey(aVar)) {
                    stringBuffer.append("\n").append(" ").append(((g) hashMap.get(aVar)).e()).append("\n");
                }
                stringBuffer.append(" ").append(simpleDateFormat.format(new Date(aVar.g()))).append("\n");
                stringBuffer.append(aVar.a(false)).append("\n");
                if (!TextUtils.isEmpty(((ef) aVar).m())) {
                    stringBuffer.append(String.format(string, new Object[]{((ef) aVar).m()})).append("\n");
                }
            }
            intent.putExtra("android.intent.extra.TEXT", stringBuffer.toString());
            intent.setType(HTTP.PLAIN_TEXT_TYPE);
            context.startActivity(Intent.createChooser(intent, context.getString(com.duokan.b.i.reading__export_notes_prompt_title)));
            return;
        }
        throw new AssertionError();
    }

    public static void a(Context context, List list, String str, String str2) {
        if (a || (list != null && list.size() > 0)) {
            Intent intent = new Intent("android.intent.action.SEND");
            UserAccount c = i.f().c();
            String c2 = c == null ? "" : c.c();
            intent.putExtra("android.intent.extra.EMAIL", new String[]{c2});
            c2 = String.format(context.getString(com.duokan.b.i.reading__export_notes_title), new Object[]{str});
            if (!TextUtils.isEmpty(str2)) {
                c2 = c2 + String.format(context.getString(com.duokan.b.i.reading__export_notes_author), new Object[]{str2});
            }
            intent.putExtra("android.intent.extra.SUBJECT", c2);
            StringBuffer stringBuffer = new StringBuffer();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String string = context.getString(com.duokan.b.i.reading__export_notes_item_note);
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
            context.startActivity(Intent.createChooser(intent, context.getString(com.duokan.b.i.reading__export_notes_prompt_title)));
            return;
        }
        throw new AssertionError();
    }
}
