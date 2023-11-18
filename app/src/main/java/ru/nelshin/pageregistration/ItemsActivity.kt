package ru.nelshin.pageregistration

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_items)

        val itemsList: RecyclerView = findViewById(R.id.itemsList)
        val items = arrayListOf<Item>()

        items.add(Item(1, "sofa2", "Диван", "Краткое описание дивана", "Длинное описание дивана", 90000))
        items.add(Item(2, "armchair", "Кресло", "Краткое описание кресла", "Длинное описание кресла", 25000))
        items.add(Item(3, "bed", "Кровать", "Краткое описание кровати", "Длинное описание кровати", 120000))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}