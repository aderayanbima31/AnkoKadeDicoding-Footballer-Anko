package com.example.derayanbimaalamsyah.ankokadedicoding

import android.content.ClipData
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.derayanbimaalamsyah.ankokadedicoding.ItemClub
import com.example.derayanbimaalamsyah.ankokadedicoding.R.array.*
import com.example.derayanbimaalamsyah.ankokadedicoding.RecyclerViewAdapter
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class MainActivity : AppCompatActivity() {


    private var items: MutableList<ItemClub> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        initData()

        verticalLayout {

            recyclerView {
                lparams(width = matchParent, height = wrapContent)
                layoutManager = LinearLayoutManager(ctx)
                adapter = RecyclerViewAdapter(ctx, items)
            }
        }


    }

    private fun initData() {
        val name = resources.getStringArray(club_name)
        val image = resources.obtainTypedArray(club_image)
        val detail = resources.getStringArray(club_detail)

        items.clear()
        for(i in name.indices){
            items.add(ItemClub(name[i], image.getResourceId(i, 0), detail[i]))
        }

        image.recycle()
    }
}
