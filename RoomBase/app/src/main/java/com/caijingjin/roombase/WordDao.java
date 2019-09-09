package com.caijingjin.roombase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao //database access object
public interface WordDao {


    @Insert
    void insertWords(Word... words);

    @Update
    void updateWord(Word... words);

    @Delete
    void deleteWords(Word... words);


    @Query("DELETE FROM WORD")
    void deleteAllWords();

    @Query("SELECT * FROM WORD ORDER BY ID DESC")
    List<Word> getAllWords();
}
