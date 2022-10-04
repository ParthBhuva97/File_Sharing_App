package com.shareit.file_sharing_app

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class Home : AppCompatActivity() {
    private lateinit var sendButton : FloatingActionButton
    private lateinit var receiveButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sendButton = findViewById(R.id.sendButton)
        receiveButton = findViewById(R.id.receiveButton)

        sendButton.setOnClickListener {
            val mDialogView = LayoutInflater.from(this@Home).inflate(R.layout.send_files,null)
            val mBuilder = AlertDialog.Builder(this@Home)
                .setView(mDialogView)
                .setTitle("Enter File Name :")
            val mAlertDialog = mBuilder.show()
            val sendFileButton = mDialogView.findViewById<Button>(R.id.selectFilesButton)
            val fileName = mDialogView.findViewById<TextInputEditText>(R.id.nameInput)

        }
    }
}