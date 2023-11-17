package ru.nelshin.pageregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText  = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_password)
        val buttonReg: Button = findViewById(R.id.button_reg)

        buttonReg.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPass.text.toString().trim()

            if(login == "" || password == "" || email == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else{
                val user = User(login, email, password)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userPass.text.clear()
                userEmail.text.clear()
            }
        }
    }
}