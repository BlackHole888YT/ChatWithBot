package com.example.chatwithbot;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity implements InputFragment.OnMessageSendListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        // Добавляем ChatFragment
        if (savedInstanceState == null) {
            fragmentManager.beginTransaction()
                    .replace(R.id.chat_fragment_container, new ChatFragment())
                    .replace(R.id.input_fragment_container, new InputFragment())
                    .commit();
        }
    }

    @Override
    public void onMessageSend(String message) {
        // Передаем сообщение в ChatFragment
        ChatFragment chatFragment = (ChatFragment) getSupportFragmentManager()
                .findFragmentById(R.id.chat_fragment_container);

        if (chatFragment != null) {
            chatFragment.addMessage(message, true);
        }
    }
}
