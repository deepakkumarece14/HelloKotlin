package com.deepak.hellokotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastBtn.onClick { toast("hello toast!!") }
        snackbarBtn.onClick {
            snackbar(rootLayout,"Snackbar from Anko")
        }

        alertBtn.onClick {
            _ ->       //just to remove the warning of it implicit parameter
            alert("Hello, I am an alert from Kotlin Anko Library") {
                yesButton { toast("thanks for clicking me") }
                noButton { toast("I don't mind!!") }
            }.show()
        }
        appCompatAlertBtn.onClick {
            //            alert(Appcompat,"Hello, I am an alert from Kotlin").show()
            toast("Working on it...")
        }
        customAlertBtn.onClick {
            _ ->       //just to remove the warning of it implicit parameter
            alert {
                lateinit var message: EditText
                customView { message = editText{ hint = "Message"} }
                yesButton { toast("Yours Message: ${message.text}") }
            }.show()
        }
        listAlertBtn.onClick {
            val hero = listOf("IronMan","Thor","Dr. Strange","Hulk")
            selector("Select your favourite superhero.",hero) { _, i ->
                longToast("${hero[i]} That's amazing, I like it too.")
            }
        }
        processDialogBtn.onClick {
            val files = (1..9).random()
            indeterminateProgressDialog(title = "Downloading",message = "$files files are downloading...")
        }
        activityWithoutXML.onClick {
            startActivity<XmlLessActivity>()
        }
    }

    private fun ClosedRange<Int>.random() = Random().nextInt(endInclusive + 1 - start) + start
}
