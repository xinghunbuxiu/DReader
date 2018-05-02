package com.duokan.reader.domain.micloud;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.duokan.reader.domain.micloud.n */
public class C1073n extends bf {
    /* renamed from: a */
    private ArrayList<bi> f5289a = new ArrayList();
    /* renamed from: b */
    private boolean f5290b;
    /* renamed from: c */
    private ArrayList<bi> f5291c = new ArrayList();

    public C1073n(String str, String str2, List<bi> list, boolean z, int i) {
        super(str, str2, ((bi) list.get(0)).m8154d(), 2, i);
        this.f5289a.addAll(list);
        this.f5290b = z;
    }

    /* renamed from: a */
    protected void mo1489a(JSONObject jSONObject) {
        super.mo1489a(jSONObject);
        this.f5289a.addAll(bi.m8148a(jSONObject.getJSONArray("delete_files_task__cloud_file_infos")));
        this.f5290b = jSONObject.optBoolean("delete_files_task__permanent");
        this.f5291c.addAll(bi.m8148a(jSONObject.getJSONArray("delete_files_task__deleted_file_infos")));
    }

    /* renamed from: b */
    protected void mo1490b(JSONObject jSONObject) {
        super.mo1490b(jSONObject);
        try {
            JSONArray jSONArray = new JSONArray();
            Iterator it = this.f5289a.iterator();
            while (it.hasNext()) {
                jSONArray.put(((bi) it.next()).m8150a());
            }
            jSONObject.put("delete_files_task__cloud_file_infos", jSONArray);
            jSONObject.put("delete_files_task__permanent", this.f5290b);
            jSONArray = new JSONArray();
            it = this.f5291c.iterator();
            while (it.hasNext()) {
                jSONArray.put(((bi) it.next()).m8150a());
            }
            jSONObject.put("delete_files_task__deleted_file_infos", jSONArray);
        } catch (JSONException e) {
        }
    }

    /* renamed from: w */
    public List<bi> m8253w() {
        return this.f5289a;
    }

    /* renamed from: x */
    public boolean m8254x() {
        return this.f5290b;
    }

    /* renamed from: y */
    public List<bi> m8255y() {
        return this.f5291c;
    }

    /* renamed from: a */
    public void m8250a(bi biVar) {
        if (!this.f5291c.contains(biVar)) {
            this.f5291c.add(biVar);
        }
    }
}
