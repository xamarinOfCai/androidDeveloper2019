package com.caijingjin.roombase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordDataBase wordDataBase;
    TextView textView;
    WordDao wordDao;
    Button buttonInsert,buttonUpdate,buttonClear,buttonDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wordDataBase = Room.databaseBuilder(this,WordDataBase.class,"word_database").allowMainThreadQueries().build();
        wordDao = wordDataBase.getWordDao();
        textView = findViewById(R.id.textView);
        updateView();
        buttonInsert = findViewById(R.id.insert);
        buttonInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word1 = new Word("Hello","您好！");
                Word word2 = new Word("Word","世界您好");
                wordDao.insertWords(word1,word2);
                updateView();
            }
        });
        buttonUpdate = findViewById(R.id.update);
        buttonUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Word word = new Word("Hi","你好啊");
                word.setId(300);
                wordDao.updateWord(word);
                updateView();
            }
        });

        buttonClear = findViewById(R.id.clear);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wordDao.deleteAllWords();
                updateView();
            }
        });
        buttonDelete = findViewById(R.id.delete);
        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<Word>words = wordDao.getAllWords();
                if(words.size() > 0 ){
                    Word firstWord = words.get(0);
                    wordDao.deleteWords(firstWord);
                }
                updateView();
            }
        });
    }

    void updateView(){
        List<Word>list = wordDao.getAllWords();
        StringBuilder text =new StringBuilder("");
        for (int i = 0; i < list.size(); i++) {
            Word word = list.get(i);
            text.append(word.getId()+":"+word.getWord()+"="+word.getChineseMeaning()+"\n");
        }
        textView.setText(text.toString());

    }
}
