package com.example.androidapp.datastore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.preferencesKey
import androidx.datastore.preferences.createDataStore
import androidx.lifecycle.lifecycleScope
import com.example.androidapp.R
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class DataStoreActivity : AppCompatActivity() {
    private lateinit var etkey: EditText
    private lateinit var etValue: EditText
    private lateinit var etReadKey: EditText
    private lateinit var btnSave: Button
    private lateinit var btnRead: Button
    private lateinit var tvResult: TextView

    private lateinit var dataStore: DataStore<Preferences>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_store)

        etkey = findViewById(R.id.etKey)
        etValue = findViewById(R.id.etValue)
        etReadKey = findViewById(R.id.etReadKey)
        btnSave = findViewById(R.id.btnSave)
        btnRead = findViewById(R.id.btnRead)
        tvResult = findViewById(R.id.tvResult)

        dataStore = createDataStore(name = "settings")
        btnSave.setOnClickListener {
            lifecycleScope.launch {
                save(
                    etkey.text.toString(), etValue.text.toString()
                )
            }
        }

        btnRead.setOnClickListener {
            lifecycleScope.launch {
                val value = read(etReadKey.text.toString())
                tvResult.text = value ?: "No value found"
            }
        }

    }

    private suspend fun save(key: String, value: String) {
        val dataStoreKey = preferencesKey<String>(key)
        dataStore.edit { settings ->
            settings[dataStoreKey] = value
        }
    }

    private suspend fun read(key: String): String? {
        val dataStoreKey = preferencesKey<String>(key)
        val preferences = dataStore.data.first()
        return preferences[dataStoreKey]
    }
}