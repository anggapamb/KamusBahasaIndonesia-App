package com.anggapambudi.kbbionline.activities

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.anggapambudi.kbbionline.R
import com.anggapambudi.kbbionline.adapter.KamusAdapter
import com.anggapambudi.kbbionline.model.KamusResponse
import com.anggapambudi.kbbionline.model.ResultListsItem
import com.anggapambudi.kbbionline.retrofit.ApiServive
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var list = ArrayList<ResultListsItem>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvLinearLayout.visibility = View.GONE

        //create progress dialog
        val progressDialog = ProgressDialog(this@MainActivity)
        progressDialog.setTitle("Mohon Tunggu")
        progressDialog.setCancelable(false)
        progressDialog.setMessage("Sedang mencari data...")

        btnCariKata.onClick {
            if (editKata.text.trim().toString().isEmpty()) {
                toast("Form tidak boleh kosong!")
            } else {

                val kataInput = editKata.text.trim()

                progressDialog.show()
                ApiServive.instance.getData("$kataInput").enqueue(object : Callback<KamusResponse>{
                    override fun onResponse(call: Call<KamusResponse>, response: Response<KamusResponse>) {
                        progressDialog.dismiss()
                        list.clear()

                        val dataKata = response.body()?.data?.resultLists
                        dataKata?.let { list.addAll(it) }

                        tvRecyclerview.layoutManager = LinearLayoutManager(this@MainActivity)
                        tvRecyclerview.adapter = KamusAdapter(list)

                        tvLinearLayout.visibility = View.VISIBLE

                    }

                    override fun onFailure(call: Call<KamusResponse>, t: Throwable) {
                        toast("Oops! internet anda bermasalah")
                        progressDialog.dismiss()
                    }

                })

            }
        }

    }

}
