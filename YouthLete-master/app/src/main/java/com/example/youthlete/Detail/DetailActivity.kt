package com.example.youthlete.Detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youthlete.R
import com.example.youthlete.adapter.CoursesAdapter
import com.example.youthlete.model.Sports

class DetailActivity : AppCompatActivity() {
    companion object {
        const val EXTRA_SPORT = "extra_sport"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val sport = intent.getSerializableExtra(EXTRA_SPORT) as? Sports
        if (sport != null) {
            val nameTextView: TextView = findViewById(R.id.text_nama)
            val imageView: ImageView = findViewById(R.id.imageView)
            val descriptionTextView: TextView = findViewById(R.id.text_description)
            val coursesRecyclerView: RecyclerView = findViewById(R.id.tv_kursu)

            nameTextView.text = sport.name
            imageView.setImageResource(sport.imageResId)
            descriptionTextView.text = sport.desc

            val layoutManager = LinearLayoutManager(this)
            coursesRecyclerView.layoutManager = layoutManager

            val coursesAdapter = CoursesAdapter(sport.courses)
            coursesRecyclerView.adapter = coursesAdapter
            coursesAdapter.notifyDataSetChanged()
        }
    }
}