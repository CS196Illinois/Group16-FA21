package com.example.courspider

import android.content.DialogInterface
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.dialog.*

class MainActivity : AppCompatActivity() {
    var scoreInput = 0
    var weightInput = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn.setOnClickListener {
            var builder = AlertDialog.Builder(this)

            var v1 = layoutInflater.inflate(R.layout.dialog, null)
            builder.setView(v1)

            var listener = DialogInterface.OnClickListener { p0, p1 ->
                var alert = p0 as AlertDialog
                var edit1: EditText? = alert.findViewById<EditText>(R.id.editText)
                var edit2: EditText? = alert.findViewById<EditText>(R.id.editText2)

                tv.text = "${edit1?.text}"
                scoreInput = edit1.toString().toInt()
                tv.append("${edit2?.text}")
                weightInput = edit2.toString().toInt()

            }

            builder.setPositiveButton("OK", listener)
            builder.setNegativeButton("Cancel", null)

            builder.show()
        }
    }

}