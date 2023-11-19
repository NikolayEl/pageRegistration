package ru.nelshin.pageregistration

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.Images
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import com.razorpay.ExternalWalletListener
import com.razorpay.PaymentData
import com.razorpay.PaymentResultWithDataListener
import org.json.JSONObject

class ItemActivity : AppCompatActivity(), PaymentResultWithDataListener, ExternalWalletListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        Checkout.preload(applicationContext)
        val co = Checkout()
        // apart from setting it in AndroidManifest.xml, keyId can also be set
        // programmatically during runtime
        co.setKeyID("rzp_test_zK4GRG0PCyK4n8")

        val title: TextView = findViewById(R.id.item_list_title_one)
        val text: TextView = findViewById(R.id.item_list_text)
        //val image: TextView = findViewById(R.id.item_list_image)
        val btn: TextView = findViewById(R.id.button_buy)

        val imageClose: ImageView = findViewById(R.id.item_list_image_close)
        imageClose.setImageResource(R.drawable.back2)

        imageClose.setOnClickListener{
            //val intent = Intent(this, ItemsActivity::class.java)
            //startActivity(intent)
            finish()
        }


        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        //image.id = intent.getIntExtra("itemImage", this.taskId)

        btn.setOnClickListener {
            startPayment()
        }

    }

    private fun startPayment() {
        /*
        *  You need to pass the current activity to let Razorpay create CheckoutActivity
        * */
        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Elshin&Co")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#f00");
            options.put("currency","RUB");
            options.put("order_id", "order_N2GI7X0FM5Tzbh");
            options.put("amount",10000000)//pass amount in currency subunits

            //val prefill = JSONObject()
            //prefill.put("email","gaurav.kumar@example.com")
            //prefill.put("contact","9876543210")

            //options.put("prefill",prefill)
            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }

    override fun onPaymentSuccess(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onPaymentError(p0: Int, p1: String?, p2: PaymentData?) {
        TODO("Not yet implemented")
    }

    override fun onExternalWalletSelected(p0: String?, p1: PaymentData?) {
        TODO("Not yet implemented")
    }
}