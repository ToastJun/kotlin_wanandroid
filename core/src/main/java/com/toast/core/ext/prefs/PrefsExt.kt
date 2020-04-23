package com.toast.core.ext.prefs

import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @author toast
 * @date 2020/4/23 18:03
 * @description
 */

private inline fun <T> SharedPreferences.delegate(
    key: String? = null,
    defaultValue: T,
    crossinline getter: SharedPreferences.(String, T) -> T,
    crossinline setter: Editor.(String, T) -> Editor
): ReadWriteProperty<Any, T> =
        object: ReadWriteProperty<Any, T> {
            override fun getValue(thisRef: Any, property: KProperty<*>): T {
                return getter(key ?: property.name, defaultValue)
            }

            override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
                edit().setter(key ?: property.name, value).apply()
            }
        }

fun SharedPreferences.int(key: String? = null, defaultInt: Int = 0): ReadWriteProperty<Any, Int> {
    return delegate(key, defaultInt, SharedPreferences::getInt, Editor::putInt)
}

fun SharedPreferences.long(key: String? = null, defaultLong: Long = 0L): ReadWriteProperty<Any, Long> {
    return delegate(key, defaultLong, SharedPreferences::getLong, Editor::putLong)
}

fun SharedPreferences.float(key: String? = null, defaultFloat: Float = 0f): ReadWriteProperty<Any, Float> {
    return delegate(key, defaultFloat, SharedPreferences::getFloat, Editor::putFloat)
}

fun SharedPreferences.boolean(key: String? = null, defaultBoolean: Boolean = false): ReadWriteProperty<Any, Boolean> {
    return delegate(key, defaultBoolean, SharedPreferences::getBoolean, Editor::putBoolean)
}

fun SharedPreferences.string(key: String? = null, defaultString: String = ""): ReadWriteProperty<Any, String> {
    return delegate(key, defaultString, {str1, str2 -> getString(str1, str2) as String}, Editor::putString)
}

fun SharedPreferences.stringSet(key: String? = null, defaultStringSet: Set<String> = emptySet()): ReadWriteProperty<Any, Set<String>> {
    return delegate(key, defaultStringSet, {it, set -> getStringSet(it, set) as Set<String>}, Editor::putStringSet)
}