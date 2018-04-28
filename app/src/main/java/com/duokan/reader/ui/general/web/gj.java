package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.C0611i;
import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.C0437t;
import com.duokan.reader.ui.p049a.C1214a;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONObject;

class gj implements as {
    /* renamed from: a */
    final /* synthetic */ String f7888a;
    /* renamed from: b */
    final /* synthetic */ ci f7889b;

    gj(ci ciVar, String str) {
        this.f7889b = ciVar;
        this.f7888a = str;
    }

    /* renamed from: a */
    public void mo1831a() {
        if (this.f7889b.f7581b.mEditFeedController == null) {
            String str;
            String str2;
            String str3 = "";
            String str4 = "";
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                JSONObject jSONObject = new JSONObject(this.f7888a);
                if (jSONObject.has("data")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("books");
                    jSONObject = jSONObject.getJSONObject("data");
                    str3 = C0611i.m2793b(jSONObject, "title");
                    JSONArray jSONArray = jSONObject.getJSONObject("content").getJSONArray("d");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.getString("t").equals("p")) {
                            str4 = jSONObject.getString("c");
                        } else if (jSONObject.getString("t").equals("b")) {
                            DkStoreAbsBookInfo dkStoreAbsBookInfo = new DkStoreAbsBookInfo();
                            dkStoreAbsBookInfo.mBookUuid = jSONObject.getString("c");
                            JSONObject jSONObject2 = optJSONObject.getJSONObject(dkStoreAbsBookInfo.mBookUuid);
                            dkStoreAbsBookInfo.mCoverUri = jSONObject2.getString("cover");
                            dkStoreAbsBookInfo.mTitle = jSONObject2.getString("title");
                            linkedList.add(new DkStoreAbsBook(dkStoreAbsBookInfo));
                            if (jSONObject.has("d")) {
                                Object obj;
                                JSONArray jSONArray2 = jSONObject.getJSONArray("d");
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    jSONObject2 = jSONArray2.getJSONObject(i2);
                                    if (jSONObject2.getString("t").equals("p")) {
                                        obj = 1;
                                        linkedList2.add(jSONObject2.getString("c"));
                                        break;
                                    }
                                }
                                obj = null;
                                if (obj == null) {
                                    linkedList2.add("");
                                }
                            } else {
                                linkedList2.add("");
                            }
                        } else {
                            continue;
                        }
                    }
                }
                str = str4;
                str2 = str3;
            } catch (Throwable th) {
                str = str4;
                Throwable th2 = th;
                str2 = str3;
                th2.printStackTrace();
            }
            this.f7889b.f7581b.mEditFeedController = new C1214a(this.f7889b.f7581b.getContext(), str2, str, linkedList, linkedList2, new gk(this), new gl(this));
            ((C0437t) this.f7889b.f7581b.getContext().queryFeature(C0437t.class)).showPopup(this.f7889b.f7581b.mEditFeedController);
        }
    }
}
