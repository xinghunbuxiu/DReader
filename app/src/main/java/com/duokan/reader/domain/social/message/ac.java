package com.duokan.reader.domain.social.message;

import android.content.Context;

import com.duokan.b.i;

import org.json.JSONObject;

public abstract class ac {
    public static k a(JSONObject jSONObject) {
        return k.a(jSONObject, g.a());
    }

    public static String a(Context context, k kVar) {
        int i;
        switch (kVar.c) {
            case 5:
                i = i.personal__comment_message_item_view__reply_type_text;
                break;
            case 6:
                i = i.personal__comment_message_item_view__like_type_text;
                break;
            case 10:
                i = i.personal__comment_message_item_view__reply_of_reply_type_text;
                break;
            case 14:
                i iVar = (i) kVar.h;
                if (iVar.e != 0) {
                    if (iVar.e != 2) {
                        if (iVar.e != 1) {
                            i = i.personal__feed_message_item_view__reply_type_text;
                            break;
                        }
                        i = i.personal__note_feed_message_item_view__reply_type_text;
                        break;
                    }
                    i = i.personal__book_feed_message_item_view__reply_type_text;
                    break;
                }
                i = i.personal__comment_feed_message_item_view__reply_type_text;
                break;
            case 15:
                i = i.personal__feed_message_item_view__reply_of_reply_type_text;
                break;
            case 17:
                b bVar = (b) kVar.h;
                if (bVar.a.c != 2) {
                    if (bVar.a.c != 4) {
                        if (bVar.a.c != 1) {
                            i = i.personal__comment_message_item_view__reply_type_text;
                            break;
                        }
                        i = i.personal__feed_message_item_view__reply_type_text_v4;
                        break;
                    }
                    i = i.personal__comment_message_item_view__reply_of_reply_type_text;
                    break;
                }
                i = i.personal__comment_feed_message_item_view__reply_type_text;
                break;
            case 18:
                c cVar = (c) kVar.h;
                if (cVar.a.b != 0) {
                    if (cVar.a.b != 1) {
                        i = i.personal__comment_message_item_view__tip_type_text;
                        break;
                    }
                    i = i.personal__feed_message_item_view__vote_type_text;
                    break;
                }
                i = i.personal__comment_message_item_view__vote_type_text;
                break;
            case 19:
                return "";
            default:
                throw new IllegalArgumentException();
        }
        return context.getString(i);
    }
}
