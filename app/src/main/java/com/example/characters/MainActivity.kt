package com.example.characters

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        registerForContextMenu(characterImage)
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        if (characterText.text.isNotEmpty()) {
            menuInflater.inflate(R.menu.context, menu)
        }
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            R.id.mail -> {
                val subject = getString(R.string.app_name)
                val text = "キャラクター名：${characterText.text}"
                val uri = Uri.fromParts("mailto", "warafffk10@gmail.com", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra(Intent.EXTRA_SUBJECT, subject)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.sms -> {
                val text = "キャラクター名：${characterText.text}"
                val uri = Uri.fromParts("smsto", "09051289963", null)
                val intent = Intent(Intent.ACTION_SENDTO, uri)
                intent.putExtra("sms_body", text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }

    /**
     * メニューを表示する
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item?.itemId) {
            //ホームボタンで表示された画像をクリアする
            R.id.home -> {
                characterImage.setImageDrawable(null)
                return true
            }
            R.id.FF7_character1 -> {
                characterImage.setImageResource(R.drawable.image5)
                characterText.text = getString(R.string.FF7_character1_text)
                return true
            }
            R.id.FF9_character2 -> {
                characterImage.setImageResource(R.drawable.image2)
                characterText.text = getString(R.string.FF9_character2_text)
                return true
            }
            R.id.FF10_character1 -> {
                characterImage.setImageResource(R.drawable.image1)
                characterText.text = getString(R.string.FF10_character1_text)
                return true
            }
            R.id.FF13_character1 -> {
                characterImage.setImageResource(R.drawable.image3)
                characterText.text = getString(R.string.FF13_character1_text)
                return true
            }
            R.id.FF15_character1 -> {
                characterImage.setImageResource(R.drawable.image4)
                characterText.text = getString(R.string.FF15_character1_text)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}