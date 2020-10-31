package com.nicej.singleactivity.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Applications(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "title") var title: String,
    @ColumnInfo(name = "description") var description: String
)