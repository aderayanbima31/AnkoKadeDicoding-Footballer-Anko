package com.example.derayanbimaalamsyah.ankokadedicoding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.example.derayanbimaalamsyah.ankokadedicoding.R.array.*
import com.example.derayanbimaalamsyah.ankokadedicoding.adapter.ClubAdapter
import com.example.derayanbimaalamsyah.ankokadedicoding.model.ClubModel
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {

    //variable untuk items
    private val items : MutableList<ClubModel> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()

        //INI DIGUNAKAN PADA SAAT RECYCLEVIEW DIBUAT DENGAN XML
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = ClubAdapter(this, items) {itemClicked(it)}


        // RECYCLE VIEW MENGGUNAKAN ANKO LAYOUT
        verticalLayout {

            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = ClubAdapter(ctx, items)
            }
        }


    }

    private fun initData(){
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val description = resources.getStringArray(club_detail)
        items.clear()
        for (i in name.indices) {
            items.add(ClubModel(name[i],
                    image.getResourceId(i, 0), description[i]))
        }

        image.recycle()
    }

//    //function untuk onclick pada list -> Intent to Detail Activity
//    private fun itemClicked(items : ClubModel){
//
//        startActivity<DetailActivity>(DetailActivity.JUDUL to  items.name, DetailActivity.GAMBAR to items.image, DetailActivity.DESKRIPSI to items.description)
//    }

}