package com.example.simanisapp.ui.artikel

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simanisapp.R
import com.example.simanisapp.adapter.ArtikelAdapter

class ArtikelFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_artikel, container, false)

        val titles = arrayOf(
            "Artikel 1",
            "Artikel 2",
            "Artikel 3"
        )

        val descriptions = arrayOf(
            "Deskripsi Artikel 1",
            "Deskripsi Artikel 2",
            "Deskripsi Artikel 3"
        )

        val imageResIds = intArrayOf(
            R.drawable.artikel,
            R.drawable.artikel,
            R.drawable.artikel
        )

        val links = arrayOf(
            "//hellosehat.com/nutrisi/fakta-gizi/konsumsi-gula-garam-dan-lemak-per-hari/",
            "//hellosehat.com/nutrisi/fakta-gizi/konsumsi-gula-garam-dan-lemak-per-hari/",
            "//hellosehat.com/nutrisi/fakta-gizi/konsumsi-gula-garam-dan-lemak-per-hari/"
        )

        val recyclerView = view.findViewById<RecyclerView>(R.id.textArtikel)

        recyclerView?.apply {
            layoutManager = LinearLayoutManager(requireContext())

            val adapter = ArtikelAdapter(
                titles, descriptions, imageResIds, links,
                object : ArtikelAdapter.OnItemClickListener {
                    override fun onItemClick(link: String) {
                        Toast.makeText(requireContext(), "Link: $link", Toast.LENGTH_SHORT).show()
                    }
                }
            )
            this.adapter = adapter
        } ?: run {
            Toast.makeText(requireContext(), "RecyclerView initialization failed", Toast.LENGTH_LONG).show()
        }

        return view
    }
}
