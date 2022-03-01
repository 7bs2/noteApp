package com.example.notes.dao

import androidx.room.*
import com.example.notes.entities.Notes


@Dao
interface NoteDao {
    @Query("select * from notes order by id desc")
    suspend fun allNotes(): List<Notes>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note: Notes)

    @Delete
    suspend fun deleteNote(note: Notes)
}