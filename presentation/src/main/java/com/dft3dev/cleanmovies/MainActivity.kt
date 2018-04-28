package com.dft3dev.cleanmovies

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.dft3dev.domain.interactor.GetMovieById
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var getMovieById: GetMovieById? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {

        }
    }
}
