package com.example.unj.cs.hw4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.unj.cs.hw4.fragment.FavoriteCoffeeFragment
import com.example.unj.cs.hw4.fragment.ListCoffeeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val coffeeList = listOf<Coffee>(
            Coffee(
                R.drawable.arabika,
                "Arabika",
                "Kopi yang paling populer di dunia."
            ),
            Coffee(
                R.drawable.robusta,
                "Robusta",
                "Kopi ini memiliki aroma yang kuat dan terasa kasar."
            ),
            Coffee(
                R.drawable.liberika,
                "Liberika",
                "Kopi ini memiliki ukuran lebih besar daripada kopi arabika dan kopi robusta."
            ),
            Coffee(
                R.drawable.balikintanami,
                "Bali Kintanami",
                "Kopi yang memiliki daya tarik berasal dari daerah Bali."
            ),
            Coffee(
                R.drawable.gayo,
                "Gayo",
                "Kopi yang kaya cita rasanya yang berasal dari tanah Gayo, Aceh."
            ),
            Coffee(
                R.drawable.papuawamena,
                "Papua Wamena",
                "Aroma pada kopi ini juga memiliki ciri khas dengan sensasi dari bunga yang wangi."
            ),
            Coffee(
                R.drawable.sidikalang,
                "Sidakalang",
                "kopi Sidikalang ini turunan langsung dari varietas typica."
            ),
            Coffee(
                R.drawable.javapreanger,
                "Java Preanger",
                "Kopi yang dibudidayakan di daerah sekitar Priangan, Jawa Barat."
            ),
            Coffee(
                R.drawable.mandailing,
                "Mandailing",
                "Salah satu jenis kopi arabika yang ditanam di daerah Sumatera Utara."
            ),
            Coffee(
                R.drawable.toraja,
                "Toraja",
                "Kopi dari hasil produksi Toraja ini terkenal dengan tingkat keasaman yang relatif tinggi."
            )
        )

        val recyclerView = findViewById<RecyclerView>(R.id.rv_coffee)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = CoffeeAdapter(this, coffeeList){
            val intent = Intent(this, DetailCoffeeActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)

        }

        val listcoffeeFragment = ListCoffeeFragment()
        val favoritecoffeeFragment = FavoriteCoffeeFragment()

        makeCurrentFragment (listcoffeeFragment)

        val bottom_navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_list_coffee -> makeCurrentFragment(listcoffeeFragment)
                R.id.menu_favorite_coffee -> makeCurrentFragment(favoritecoffeeFragment)
            }
            true
        }
    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_nav, fragment)
            commit()
        }
    }
}