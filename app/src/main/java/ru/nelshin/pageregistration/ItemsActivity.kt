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

        val shortDescriptionSofa: String = "Диван Брера двухместный"
        val shortDescriptionArmchair: String = "Кресло мягкое для отдыха"
        val shortDescriptionBed: String = "Кровать Фиеста 160х200 см Венге МиФ"

        val longDescriptionSofa: String =
            "Материал: каркас - калиброванный брус хвойных пород, березовая фанера, наполнение подушек - ППУ марки «Memory», приспинные подушки заполнены силиконизированным"

        val longDescriptionArmchair: String =
            "Стильное мягкое кресло Честер создано для комфортного отдыха и чтения книг. Мягкая изогнутая спинка с \"ушами\", глубокое посадочное место с приятной на " +
                    "ощупь подушечкой под спину и удобные подлокотники уверенно стоят на высоких ножках из массива дерева Бук. Данная модель гармонично вписывается как в современные, так и в консервативные " +
                    "интерьеры за счет баланса стилей заключенных в нем, а именно Модерн, Британская классика середины ХХ века и Скандинавский. Ножки в цвет, черные."

        val longDescriptionBed: String =
            "Современная двуспальная кровать Фиеста 160х200 см. Каркас и фасад кровати изготовлен из ЛДСП, производится данная модель в двух расцветках: Дуб беленый/Венге, " +
                    "Ясень шимо светлый/Ясень шимо темный. Общие габариты кровати(ШхДхВ): 163.2х203.2х80 см. Производитель кровати мебельная фабрика МиФ.\n" +
                    "Также кровать Фиеста производится в таких размерах как: 90х200,120х200, 140х200, 160х200"

        items.add(Item(1, "sofa2", "Диван", shortDescriptionSofa, longDescriptionSofa, 90000))
        items.add(
            Item(
                2,
                "armchair",
                "Кресло",
                shortDescriptionArmchair,
                longDescriptionArmchair,
                25000
            )
        )
        items.add(Item(3, "bed", "Кровать", shortDescriptionBed, longDescriptionBed, 120000))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items, this)
    }
}