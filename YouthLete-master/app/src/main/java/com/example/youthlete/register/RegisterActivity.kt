package com.example.youthlete.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.util.Patterns
import android.widget.Toast
import com.example.youthlete.databinding.ActivityRegisterBinding
import com.example.youthlete.login.loginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    lateinit var binding: ActivityRegisterBinding
    lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        auth = FirebaseAuth.getInstance()

        binding.btRegister.setOnClickListener{
            val email = binding.emailEt.text.toString()
            val password = binding.pwEt.text.toString()

            //bagian email

            if (email.isEmpty()){
                binding.textInputEmail.error ="email harus diisi"
                binding.textInputEmail.requestFocus()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                binding.textInputEmail.error ="email tidak valid"
                binding.textInputEmail.requestFocus()
                return@setOnClickListener
            }

            //bagianpw

            if (password.isEmpty()){
                binding.textInputPW.error ="password harus diisi"
                binding.textInputPW.requestFocus()
                return@setOnClickListener
            }

            if (password.length <  8){
                binding.textInputPW.error = "Password minimal 8 Karakter"
                binding.textInputPW.requestFocus()
                return@setOnClickListener
            }
            
            RegisterFirebase(email,password)


        }

        // Set password input type to display asterisks
        binding.pwEt.transformationMethod = PasswordTransformationMethod.getInstance()

    }

    private fun RegisterFirebase(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this){
                if (it.isSuccessful){
                    Toast.makeText(this,"Register berhasil", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this,loginActivity::class.java)
                    startActivity(intent)
                }else{
                    Toast.makeText(this,"${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }

    }
}