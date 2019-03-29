package com.sirius.software.remotecontroller

import android.annotation.SuppressLint
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタン配列
        val imageButton = arrayOf<ImageButton>(
                imageButton0, imageButton1, imageButton2, imageButton3, imageButton4, imageButton5,
                imageButton6, imageButton7, imageButton8, imageButton9, imageButton10, imageButton11,
                imageButton12, imageButton13, imageButton14, imageButton15, imageButton16)

        // ボタン配列を要素ごとに処理
        imageButton.forEachIndexed { index, button ->
            // 押されたボタンを特定するためにタグを付ける
            button.setTag(index)

            // タッチイベントを登録
            button.setOnTouchListener(object : View.OnTouchListener {
                // タッチされたら
                @SuppressLint("ClickableViewAccessibility")
                override fun onTouch(v: View, m: MotionEvent): Boolean {
                    // 押されたボタンをタグから特定する
                    val btn = imageButton[Integer.parseInt(v.getTag().toString())]

                    // 指が触れているとき
                    if (m.action == MotionEvent.ACTION_DOWN) {
                        // ボタンのハイライト有効
                        btn.setColorFilter(Color.argb(150, 255, 255, 255))

                    // 指が離れたとき
                    } else if (m.action == MotionEvent.ACTION_UP) {
                        // ボタンのハイライト無効
                        btn.setColorFilter(Color.argb(0, 255, 255, 255))

                        // ボタンの説明をトースト表示
                        Toast.makeText(v.context, btn.contentDescription, Toast.LENGTH_SHORT).show()
                    }
                    return true
                }
            })
        }

    }
}
