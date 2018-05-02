package com.duokan.reader.domain.store;

import android.content.Context;
import android.util.Pair;
import com.duokan.p023b.C0247i;
import com.duokan.reader.common.webservices.duokan.DkStoreSpecialEventInfo;
import java.lang.reflect.Array;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.duokan.reader.domain.store.n */
public class C1188n {
    /* renamed from: a */
    private final DkStoreSpecialEventInfo f5669a;

    /* renamed from: a */
    public boolean m8726a() {
        long currentTimeMillis = System.currentTimeMillis() - (this.f5669a.mServerTime - this.f5669a.mClientTime);
        return this.f5669a.mStartTime <= currentTimeMillis && currentTimeMillis <= this.f5669a.mEndTime;
    }

    /* renamed from: a */
    public Pair<String, Integer> m8725a(Context context, int i) {
        try {
            JSONArray jSONArray = this.f5669a.mStrategy;
            int[][] iArr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{jSONArray.length(), 2});
            int[] iArr2 = new int[]{0, 0};
            int i2 = 0;
            while (i2 < jSONArray.length()) {
                JSONArray jSONArray2 = jSONArray.getJSONArray(i2);
                iArr[i2][0] = (int) Math.round(jSONArray2.getDouble(0) * 100.0d);
                iArr[i2][1] = (int) Math.round(jSONArray2.getDouble(1) * 100.0d);
                if (i >= iArr[i2][0] && iArr2[0] < iArr[i2][0]) {
                    iArr2 = iArr[i2];
                }
                i2++;
            }
            if (iArr2[0] == 0) {
                return null;
            }
            i2 = iArr2[1] * (i / iArr2[0]);
            return new Pair(String.format(context.getString(C0247i.store__shopping_cart_payment_view__special_event), new Object[]{Float.valueOf(((float) iArr2[0]) / 100.0f), Float.valueOf(((float) iArr2[1]) / 100.0f)}), Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    public static float m8724a(Context context, List<C1188n> list, int i) {
        if (list == null) {
            return 0.0f;
        }
        float f = 0.0f;
        for (C1188n c1188n : list) {
            float intValue;
            if (c1188n.m8726a()) {
                Pair a = c1188n.m8725a(context, i);
                if (a != null) {
                    intValue = f + ((float) ((Integer) a.second).intValue());
                    f = intValue;
                }
            }
            intValue = f;
            f = intValue;
        }
        return f;
    }
}
