package com.deepak.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.EditText
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class XmlLessActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        XmlLessActivityUi().setContentView(this)
    }
}

class XmlLessActivityUi : AnkoComponent<XmlLessActivity> {
    private val xmlStyles = { v: Any->
        when(v) {
            is Button -> v.textSize = 20f
            is EditText -> v.textSize = 16f
        }
    }

    override fun createView(ui: AnkoContext<XmlLessActivity>) = with(ui) {
        verticalLayout {
            padding = dip(16)
            val name = editText{
                hint = "Name"
            }
            button("Submit") {
                onClick { toast("Thanks for trying ${name.text}") }
            }.lparams(width = wrapContent) {
                gravity = Gravity.CENTER
                margin = dip(16)
            }
        }
    }.applyRecursively(xmlStyles)
}