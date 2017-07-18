package connection.rxconnection.session;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import connection.rxconnection.model.ModelLoginCustomer;


public class SessionUser {
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private final String sessionName = "login";
    private final String key = "user";
    private final String day = "day";

    public SessionUser(Context context) {
        sharedPreferences = context.getSharedPreferences(sessionName, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public void setUser(ModelLoginCustomer user) {
        editor.putString(key, new Gson().toJson(user));
        editor.commit();
    }

    public ModelLoginCustomer getUser() {
        String customer = sharedPreferences.getString(key, null);
        return customer != null ? new Gson().fromJson(customer, ModelLoginCustomer.class) : null;
    }

    public void setDay(int day) {
        editor.putInt(this.day, day).commit();
    }

    public int getDay() {
        return sharedPreferences.getInt(day, 0);
    }

    public void clearUser() {
        editor.clear();
        editor.commit();
    }
}
