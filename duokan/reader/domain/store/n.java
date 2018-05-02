package com.duokan.reader.domain.store;

import android.content.Context;
import android.util.Pair;

import com.duokan.reader.common.webservices.duokan.DkStoreSpecialEventInfo;

import org.json.JSONArray;
import org.json.JSONException;

import java.lang.reflect.Array;
import java.util.List;

public class n {
    private final DkStoreSpecialEventInfo a;

    public boolean a() {
        long currentTimeMillis = System.currentTimeMillis() - (this.a.mServerTime - this.a.mClientTime);
        return this.a.mStartTime <= currentTimeMillis && currentTimeMillis <= this.a.mEndTime;
    }

    public Pair a(Context context, int i) {
        try {
            JSONArray jSONArray = this.a.mStrategy;
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
            return new Pair(String.format(context.getString(i.store__shopping_cart_payment_view__special_event), new Object[]{Float.valueOf(((float) iArr2[0]) / 100.0f), Float.valueOf(((float) iArr2[1]) / 100.0f)}), Integer.valueOf(i2));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static float a(Context context, List list, int i) {
        if (list == null) {
            return 0.0f;
        }
        float f = 0.0f;
        for (n nVar : list) {
            float intValue;
            if (nVar.a()) {
                Pair a = nVar.a(context, i);
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
