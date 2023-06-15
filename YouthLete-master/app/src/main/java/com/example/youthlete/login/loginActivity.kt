package com.example.youthlete.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import com.example.youthlete.MainActivity
import com.example.youthlete.databinding.ActivityLoginBinding
import com.example.youthlete.register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class loginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    lateinit var auth: FirebaseAuth
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        sharedPreferences = getSharedPreferences("LOGIN_STATUS", Context.MODE_PRIVATE)

        if (sharedPreferences.getBoolean("LOGGED_IN", false)) {
            // Jika pengguna sudah login, langsung buka halaman utama
            openMainActivity()
            finish() // Tambahkan finish() agar pengguna tidak dapat kembali ke halaman login setelah login berhasil
        }

        binding.tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }

        binding.btLogin.setOnClickListener {

            val email = binding.edtemail.text.toString()
            val password = binding.edtpw.text.toString()

            // Bagian email

            if (email.isEmpty()) {
                binding.edtemail.error = "email harus diisi"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                binding.edtemail.error = "email tidak valid"
                binding.edtemail.requestFocus()
                return@setOnClickListener
            }

            // Bagian password

            if (password.isEmpty()) {
                binding.edtpw.error = "password harus diisi"
                binding.edtpw.requestFocus()
                return@setOnClickListener
            }

            if (password.length < 8) {
                binding.edtpw.error = "Password minimal 8 Karakter"
                binding.edtpw.requestFocus()
                return@setOnClickListener
            }

            loginFirebase(email, password)
        }

        binding.edtpw.transformationMethod = PasswordTransformationMethod.getInstance()
    }

    private fun loginFirebase(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Selamat datang $email", Toast.LENGTH_SHORT).show()

                    // Set status login pengguna ke true menggunakan Shared Preferences
                    val editor = sharedPreferences.edit()
                    editor.putBoolean("LOGGED_IN", true)
                    editor.apply()

                    openMainActivity()
                    finish() // Tambahkan finish() agar pengguna tidak dapat kembali ke halaman login setelah login berhasil
                } else {
                    Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
    }

    private fun openMainActivity() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

