package ru.nelshin.pageregistration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

internal fun isValidPassword(password: String): Boolean {
    if (password.length < 8) return false
    if (password.filter { it.isDigit() }.firstOrNull() == null) return false
    if (password.filter { it.isLetter() }.filter { it.isUpperCase() }
            .firstOrNull() == null) return false
    if (password.filter { it.isLetter() }.filter { it.isLowerCase() }
            .firstOrNull() == null) return false
    if (password.filter { !it.isLetterOrDigit() }.firstOrNull() == null) return false

    return true
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_password)
        val buttonReg: Button = findViewById(R.id.button_reg)
        val lintToAuth: TextView = findViewById(R.id.link_to_auth)

        lintToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        buttonReg.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val password = userPass.text.toString().trim()

            if (login == "" || password == "" || email == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else if (login.length <= 3)
                Toast.makeText(
                    this,
                    "Имя пользователя должно быть больше 3 симоволов, попробуйте снова.",
                    Toast.LENGTH_LONG
                ).show()
            else if (!(email.contains('@') && email.contains('.')))
                Toast.makeText(
                    this,
                    "такого e-mail не существует, введите заново",
                    Toast.LENGTH_LONG
                ).show()
            else if (!isValidPassword(password))
                Toast.makeText(
                    this,
                    "Пароль должен быть больше 8 символов, содержать: строчные буквы, заглавные буквы, цифры, символы. Попробуйте задать пароль снова.",
                    Toast.LENGTH_LONG
                ).show()
            else {
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