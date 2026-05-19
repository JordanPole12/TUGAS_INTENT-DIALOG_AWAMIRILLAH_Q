package com.nim2430511004.registrasiseminarcompose

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

class HasilActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val nama = intent.getStringExtra("NAMA") ?: ""
        val nim = intent.getStringExtra("NIM") ?: ""
        val prodi = intent.getStringExtra("PRODI") ?: ""
        val semester = intent.getStringExtra("SEMESTER") ?: ""
        val email = intent.getStringExtra("EMAIL") ?: ""

        setContent {
            MaterialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    HasilRegistrasiScreen(
                        nama = nama,
                        nim = nim,
                        prodi = prodi,
                        semester = semester,
                        email = email,
                        onOpenWebsite = {
                            val browserIntent = Intent(
                                Intent.ACTION_VIEW,
                                Uri.parse("https://fe.ummi.ac.id/") //sudah mengganti website tujuan pada Implicit Intent
                            )
                            startActivity(browserIntent)
                        }
                    )
                }
            }
        }
    }
}

@Composable
fun HasilRegistrasiScreen(
    nama: String,
    nim: String,
    prodi: String,
    semester: String,
    email: String,
    onOpenWebsite: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            text = "Hasil Registrasi Seminar",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(text = "Nama   : $nama")
        Text(text = "NIM    : $nim")
        Text(text = "Prodi  : $prodi")
        Text(text = "Semester  : $semester")
        Text(text = "Email  : $email")

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = onOpenWebsite,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Buka Website Seminar")
        }
    }
}





