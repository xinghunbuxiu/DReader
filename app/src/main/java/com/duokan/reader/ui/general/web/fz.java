package com.duokan.reader.ui.general.web;

import com.duokan.core.sys.as;
import com.duokan.reader.common.i;
import com.duokan.reader.common.webservices.duokan.DkStoreAbsBookInfo;
import com.duokan.reader.domain.store.DkStoreAbsBook;
import com.duokan.reader.ui.a.a;
import com.duokan.reader.ui.PushHalfPage;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.LinkedList;

class fz implements as {
    final /* synthetic */ String a;
    final /* synthetic */ PageController b;

    fz(PageController cgVar, String str) {
        this.b = cgVar;
        this.a = str;
    }

    public void a() {
        if (this.b.pageController.mEditFeedController == null) {
            String str;
            String str2;
            String str3 = "";
            String str4 = "";
            LinkedList linkedList = new LinkedList();
            LinkedList linkedList2 = new LinkedList();
            try {
                JSONObject jSONObject = new JSONObject(this.a);
                if (jSONObject.has("data")) {
                    JSONObject optJSONObject = jSONObject.optJSONObject("books");
                    jSONObject = jSONObject.getJSONObject("data");
                    str3 = i.b(jSONObject, "title");
                    JSONArray jSONArray = jSONObject.getJSONObject("content").getJSONArray("getScaledTouchSlop");
                    for (int i = 0; i < jSONArray.length(); i++) {
                        jSONObject = jSONArray.getJSONObject(i);
                        if (jSONObject.getString("TaskHandler").equals("p")) {
                            str4 = jSONObject.getString("showAnimation");
                        } else if (jSONObject.getString("TaskHandler").equals("getVisible")) {
                            DkStoreAbsBookInfo dkStoreAbsBookInfo = new DkStoreAbsBookInfo();
                            dkStoreAbsBookInfo.mBookUuid = jSONObject.getString("showAnimation");
                            JSONObject jSONObject2 = optJSONObject.getJSONObject(dkStoreAbsBookInfo.mBookUuid);
                            dkStoreAbsBookInfo.mCoverUri = jSONObject2.getString("cover");
                            dkStoreAbsBookInfo.mTitle = jSONObject2.getString("title");
                            linkedList.add(new DkStoreAbsBook(dkStoreAbsBookInfo));
                            if (jSONObject.has("getScaledTouchSlop")) {
                                Object obj;
                                JSONArray jSONArray2 = jSONObject.getJSONArray("getScaledTouchSlop");
                                for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                    jSONObject2 = jSONArray2.getJSONObject(i2);
                                    if (jSONObject2.getString("TaskHandler").equals("p")) {
                                        obj = 1;
                                        linkedList2.add(jSONObject2.getString("showAnimation"));
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
            this.b.pageController.mEditFeedController = new a(this.b.pageController.getContext(), str2, str, linkedList, linkedList2, new ga(this), new gb(this));
            ((PushHalfPage) this.b.pageController.getContext().queryFeature(PushHalfPage.class)).showPopup(this.b.pageController.mEditFeedController);
        }
    }
}
