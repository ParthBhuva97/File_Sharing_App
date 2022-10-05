package com.shareit.file_sharing_app

import android.app.AlertDialog
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.textfield.TextInputEditText

class Home : AppCompatActivity() {

    private val REQUIRED_PERMISSIONS = arrayOf(
        "android.permission.ACCESS_COARSE_LOCATION",
        "android.permission.BLUETOOTH",
        "android.permission.BLUETOOTH_ADMIN",
        "android.permission.ACCESS_WIFI_STATE",
        "android.permission.CHANGE_WIFI_STATE",
        "android.permission.ACCESS_FINE_LOCATION",
        "android.permission.BLUETOOTH_ADVERTISE",
        "android.permission.BLUETOOTH_CONNECT",
        "android.permission.BLUETOOTH_SCAN",
        "android.permission.READ_EXTERNAL_STORAGE"
    )

    private val REQUEST_CODE_PERMISSIONS = 1001

    private lateinit var sendButton : FloatingActionButton
    private lateinit var receiveButton : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        sendButton = findViewById(R.id.sendButton)
        receiveButton = findViewById(R.id.receiveButton)

        sendButton.setOnClickListener {
            if(allPermissionsGranted()){
                val mDialogView = LayoutInflater.from(this@Home).inflate(R.layout.send_files,null)
                val mBuilder = AlertDialog.Builder(this@Home)
                    .setView(mDialogView)
                    .setTitle("Enter File Name :")
                val mAlertDialog = mBuilder.show()
                val sendFileButton = mDialogView.findViewById<Button>(R.id.selectFilesButton)
                val fileName = mDialogView.findViewById<TextInputEditText>(R.id.nameInput)
            }
            else{
                ActivityCompat.requestPermissions(this,REQUIRED_PERMISSIONS,REQUEST_CODE_PERMISSIONS)
            }

        }
    }

    private fun allPermissionsGranted():Boolean{
        for (permission in REQUIRED_PERMISSIONS){
            return ContextCompat.checkSelfPermission(this,permission) == PackageManager.PERMISSION_GRANTED
        }
        return true
    }
}