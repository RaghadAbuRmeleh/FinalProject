package com.example.finalproj;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class NoteUtils {

    private static final String PREFS_NAME = "notes_app";
    private static final String NOTES_KEY = "notes";

    public static void saveNotes(Context context, List<Note> notes) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();
        Gson gson = new Gson();
        String json = gson.toJson(notes);
        editor.putString(NOTES_KEY, json);
        editor.apply();
    }

    public static List<Note> loadNotes(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Gson gson = new Gson();
        String json = prefs.getString(NOTES_KEY, null);
        Type type = new TypeToken<ArrayList<Note>>() {}.getType();
        List<Note> notes = gson.fromJson(json, type);
        return notes == null ? new ArrayList<>() : notes;
    }
}
