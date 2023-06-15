package com.example.youthlete.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.youthlete.Detail.DetailActivity
import com.example.youthlete.R
import com.example.youthlete.adapter.SportsAdapter
import com.example.youthlete.model.Sports
import com.example.youthlete.model.sportList


// HomeFragment.kt
class HomeFragment : Fragment() {

    private lateinit var sportsAdapter: SportsAdapter
    private val originalSportsList: List<Sports> = sportList.sportss.toList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.rv_stories)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        sportsAdapter = SportsAdapter(originalSportsList, object : SportsAdapter.OnItemClickListener {
            override fun onItemClick(sports: Sports) {
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra(DetailActivity.EXTRA_SPORT, sports)
                startActivity(intent)
            }
        })
        recyclerView.adapter = sportsAdapter

        val searchEditText: EditText = view.findViewById(R.id.searchEditText)
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                search(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        return view
    }

    private fun search(query: String) {
        val filteredList = originalSportsList.filter { sports ->
            sports.name.contains(query, ignoreCase = true)
        }
        sportsAdapter.updateList(filteredList)
    }
}