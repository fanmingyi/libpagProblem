package com.example.simpleapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.simpleapp.databinding.ActivityMainBinding
import org.libpag.PAGFile

class MainActivity : AppCompatActivity() {
    companion object {
        val KEY_CALLBACK = "KEY_CALLBACK"
    }

    private val pagSpeaking by lazy {
        PAGFile.Load(this.assets, "chat_wt_speaking.pag")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val items = mutableListOf<String>()
        for (i in 0..0) {
            items.add("item ${i}")
        }
        val myAdapter = MyAdapter(items)
        binding.list.adapter = myAdapter

        binding.list.layoutManager = LinearLayoutManager(this)
        myAdapter.notifyDataSetChanged()

        var showAni = false
        binding.btnChangeAni.setOnClickListener {
            showAni = !showAni
            myAdapter.notifyItemChanged(0, showAni)
        }


    }

}