package com.example.notes

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.notes.database.NotesDatabase
import com.example.notes.entities.Notes
import kotlinx.android.synthetic.main.fragment_create_note.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import kotlin.math.log


class CreateNoteFragment : BaseFragment() {

     val colorLive = MutableLiveData<String>().apply {
        value = "#4e33ff"
    }

    var currColor = "#4e33ff"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_create_note, container, false)
    }

    @SuppressLint("SimpleDateFormat")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val simpleDateFormat = SimpleDateFormat("yyyy/M/dd hh:mm:ss")
        tv_data.text = simpleDateFormat.format(java.util.Date())

        image_done.setOnClickListener() {
            saveNote()
            requireActivity().supportFragmentManager.popBackStack()
        }

        image_back.setOnClickListener() {
           requireActivity().supportFragmentManager.popBackStack()
        }

        dividerButton.setOnClickListener() {
            NoteBottomSheetFragment(this).show(requireActivity().supportFragmentManager, null)
        }

        colorLive.observe(viewLifecycleOwner) {
            leftView.setBackgroundColor(Color.parseColor(it))
            currColor = it
        }
    }

    private fun saveNote() {
        if (edit_title.text.isNullOrEmpty()) {
            Toast.makeText(context, "Title Required", Toast.LENGTH_SHORT).show()
        }

        if (ed_sub_title.text.isNullOrEmpty()) {
            Toast.makeText(context, "Note sub title Required", Toast.LENGTH_SHORT).show()
        }

        if (edit_text_desc.text.isNullOrEmpty()) {
            Toast.makeText(context, "Note Description Required", Toast.LENGTH_SHORT).show()
        }

        launch {
            val notes = Notes()
            notes.title = edit_title.text.toString()
            notes.subTitle = ed_sub_title.text.toString()
            notes.noteText = edit_text_desc.text.toString()
            notes.dataTime = tv_data.text.toString()
            notes.color = currColor
            context?.let {
                NotesDatabase.getInstance(it).noteDao().insert(notes)
            }

            edit_title.setText("")
            ed_sub_title.setText("")
            edit_text_desc.setText("")
        }
    }

    private fun replaceFragment(fragment: Fragment, isTransition: Boolean) {
        val beginTransaction = requireActivity().supportFragmentManager.beginTransaction()
        if (isTransition) {
            beginTransaction.setCustomAnimations(
                android.R.anim.slide_in_left,
                android.R.anim.slide_out_right
            )
        }
        beginTransaction.replace(R.id.frame_layout, fragment).addToBackStack("home")
        beginTransaction.commit()
    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment CreateNoteFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            CreateNoteFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}