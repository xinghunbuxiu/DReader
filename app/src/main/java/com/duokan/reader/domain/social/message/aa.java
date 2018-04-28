package com.duokan.reader.domain.social.message;

import android.content.Context;
import com.duokan.p023b.C0247i;
import org.json.JSONObject;

public abstract class aa {
    /* renamed from: a */
    public static C1151k m8503a(JSONObject jSONObject) {
        return C1151k.m8577a(jSONObject, C1147g.m8565a());
    }

    /* renamed from: a */
    public static String m8504a(Context context, C1151k c1151k) {
        int i;
        switch (c1151k.f5556c) {
            case 5:
                i = C0247i.personal__comment_message_item_view__reply_type_text;
                break;
            case 6:
                i = C0247i.personal__comment_message_item_view__like_type_text;
                break;
            case 10:
                i = C0247i.personal__comment_message_item_view__reply_of_reply_type_text;
                break;
            case 14:
                C1149i c1149i = (C1149i) c1151k.f5561h;
                if (c1149i.f5548e != 0) {
                    if (c1149i.f5548e != 2) {
                        if (c1149i.f5548e != 1) {
                            i = C0247i.personal__feed_message_item_view__reply_type_text;
                            break;
                        }
                        i = C0247i.personal__note_feed_message_item_view__reply_type_text;
                        break;
                    }
                    i = C0247i.personal__book_feed_message_item_view__reply_type_text;
                    break;
                }
                i = C0247i.personal__comment_feed_message_item_view__reply_type_text;
                break;
            case 15:
                i = C0247i.personal__feed_message_item_view__reply_of_reply_type_text;
                break;
            case 17:
                C1141b c1141b = (C1141b) c1151k.f5561h;
                if (c1141b.f5532a.f2127c != 2) {
                    if (c1141b.f5532a.f2127c != 4) {
                        if (c1141b.f5532a.f2127c != 1) {
                            i = C0247i.personal__comment_message_item_view__reply_type_text;
                            break;
                        }
                        i = C0247i.personal__feed_message_item_view__reply_type_text_v4;
                        break;
                    }
                    i = C0247i.personal__comment_message_item_view__reply_of_reply_type_text;
                    break;
                }
                i = C0247i.personal__comment_feed_message_item_view__reply_type_text;
                break;
            case 18:
                C1142c c1142c = (C1142c) c1151k.f5561h;
                if (c1142c.f5533a.f2132b != 0) {
                    if (c1142c.f5533a.f2132b != 1) {
                        i = C0247i.personal__comment_message_item_view__tip_type_text;
                        break;
                    }
                    i = C0247i.personal__feed_message_item_view__vote_type_text;
                    break;
                }
                i = C0247i.personal__comment_message_item_view__vote_type_text;
                break;
            case 19:
                return "";
            default:
                throw new IllegalArgumentException();
        }
        return context.getString(i);
    }
}
