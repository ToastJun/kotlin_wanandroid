package com.toast.wanandroid

import com.toast.wanandroid.sunflower.rxjava.createObservableForTest
import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        Derived("wwj", "last")
    }

    @Test
    fun rxjava() {
        createObservableForTest()
    }
}

open class Base(val name: String) {
    init { println("Initializing Base") }

    val test: String = "test".also { println("Init test in Base") }

    open val size: Int = name.length.also { println("Initializing size in Base: $it") }

}

class Derived( name: String, val lastName: String )
    : Base(name.capitalize().also { println("Argument for Base: $it") }) {
    init { println("Initializing Derived") }

    override val size: Int = (super.size + lastName.length).also { println("Initializing size in Derived: $it") }
}

/**
 * Argument for Base wwj
 * Initializing Base
 * Initializing size in Base: 3
 * Initializing Derived
 * Initializing size in Derived: 7
 * */