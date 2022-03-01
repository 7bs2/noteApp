package com.example.notes

import android.annotation.SuppressLint
import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_bottom_sheet.*

class NoteBottomSheetFragment(private val fragment: CreateNoteFragment) : BottomSheetDialogFragment() {


    lateinit var lastImageView: ImageView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_bottom_sheet, container)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }


    private fun initView() {
        lastImageView = sheet1

        sheet1.setOnClickListener() {
            if (lastImageView != it as ImageView) {
                lastImageView.setImageResource(R.drawable.place)
                it.setImageResource(R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#4e33ff"
        }
        sheet2.setOnClickListener() {

            if (lastImageView != it as ImageView) {
                lastImageView.setImageResource(R.drawable.place)
                Log.i("wb", "ssss")
                it.setImageResource(R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#ffd633"
        }
        sheet3.setOnClickListener() {
            if (lastImageView != it as ImageView) {

                lastImageView.setImageResource(R.drawable.place)
                Log.i("wb", "ssss")
                it.setImageResource(R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#ae3b76"
        }
        sheet4.setOnClickListener() {
            if (lastImageView != it as ImageView) {
                lastImageView.setImageResource(R.drawable.place)
                it.setImageResource(R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#31E1B2"
        }
        sheet5.setOnClickListener() {
            if (lastImageView != it as ImageView) {
                lastImageView.setImageResource(R.drawable.place)
                it.setImageResource(R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#ff7746"
        }
        sheet6.setOnClickListener() {
            if (lastImageView != it as ImageView) {
                lastImageView.setImageResource(R.drawable.place)
                it.setImageResource( R.drawable.ic_check)
            }
            lastImageView = it as ImageView
            fragment.colorLive.value = "#2B2B2B"
        }

    }
}