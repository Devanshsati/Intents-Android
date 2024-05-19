package com.example.intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.intents.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.button1.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://devanshsati.github.io/Portfolio/"))
            startActivity(intent)
        }
        binding.button2.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:9999999999"))
            startActivity(intent)
        }
        binding.button3.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
        binding.button4.setOnClickListener {
            val text: String = binding.editTextText.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, text)
            startActivity(Intent.createChooser(intent, "Share via"))
        }
        binding.button5.setOnClickListener {
            val intent = Intent(this,ProfileActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}