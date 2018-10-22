package com.example.derayanbimaalamsyah.ankokadedicoding

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*

class DetailActivity : AppCompatActivity() {

    private var namaClub : String = ""
    private var logoClub : Int = 0
    private var detailClub : String = ""

    lateinit var  namaClubTextView: TextView
    lateinit var logoClubImageView: ImageView
    lateinit var detailClubTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        verticalLayout {
            padding = dip(16)


            logoClubImageView = imageView().
                    lparams(width =dip(100), height = wrapContent){
                        gravity = Gravity.CENTER
                    }
            namaClubTextView = textView().
                    lparams(width= wrapContent){
                        gravity= Gravity.CENTER
                        topMargin =dip(16)
                    }
            detailClubTextView =textView().
                    lparams(width= wrapContent){
                        topMargin= dip(8)
                    }
        }

        //Intent put extra
        namaClub = intent.getStringExtra(JUDUL)
        logoClub = intent.getIntExtra(GAMBAR,0)
        detailClub = intent.getStringExtra(DESKRIPSI)


        Glide.with(logoClubImageView).load(logoClub).into(logoClubImageView)
        namaClubTextView.text = namaClub
        detailClubTextView.text = detailClub
    }


    companion object {
        const  val JUDUL = "judul"
        const  val GAMBAR = "gambar"
        const  val DESKRIPSI = "deskripsi"
    }
}


