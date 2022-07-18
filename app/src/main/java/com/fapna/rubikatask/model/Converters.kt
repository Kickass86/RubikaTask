package com.fapna.rubikatask.model

import androidx.room.TypeConverter
import com.google.gson.Gson
import java.util.*

class Converters {

    @TypeConverter
    fun gsonToDates(json: String?): Date {
        return Gson().fromJson(json, Date::class.java)
    }

    @TypeConverter
    fun factDatesToGson(geocodes: Date): String? {
        return Gson().toJson(geocodes)
    }
}