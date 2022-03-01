package com.example.notes.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "Notes")
data class Notes(
    @PrimaryKey(autoGenerate = true)
    var id:Int? = null,

    @ColumnInfo(name = "title")
    var title: String? = null,

    @ColumnInfo(name = "sub_title")
    var subTitle: String? = null,

    @ColumnInfo(name = "note_text")
    var noteText: String? = null,

    @ColumnInfo(name = "img_path")
    var imgPath: String? = null,

    @ColumnInfo(name = "web_link")
    var webLink: String? = null,

    @ColumnInfo(name = "color")
    var color: String? = "#4e33ff",

    @ColumnInfo(name = "data_time")
    var dataTime: String? = null
): Serializable