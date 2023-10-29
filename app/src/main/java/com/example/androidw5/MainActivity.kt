package com.example.androidw5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val itemList = arrayListOf<ItemModel>()

        // Danh sách các tiêu đề và nội dung ngẫu nhiên
        val randomTitles = listOf(
            "Xin Chào",
            "Thông báo quan trọng",
            "Khuyến mãi đặc biệt",
            "Chương trình hấp dẫn",
            "Cơ hội lớn"
        )

        val randomContents = listOf(
            "Chúng tôi xin gửi thông báo này đến bạn.",
            "Chúng tôi có tin tức quan trọng để thông báo.",
            "Bạn không thể bỏ lỡ cơ hội này.",
            "Chương trình khuyến mãi dành riêng cho bạn.",
            "Mời bạn tham gia vào sự kiện quan trọng này."
        )

        // Danh sách các tên email ngẫu nhiên
        val randomEmails = listOf(
            "sonpham@gmail.com",
            "bkfromheart@yahoo.com",
            "itandroid@hotmail.com",
            "vieclam@gmail.com",
            "20205124@yahoo.com"
        )

        // Tạo dữ liệu mẫu
        for (i in 1..10) {
            val randomEmail = randomEmails[Random().nextInt(randomEmails.size)]
            val randomTitle = randomTitles[Random().nextInt(randomTitles.size)]
            val randomContent = randomContents[Random().nextInt(randomContents.size)]

            itemList.add(
                ItemModel(
                    randomEmail,
                    randomTitle,
                    randomContent,
                    String.format(
                        "%02d:%02d %s",
                        Random().nextInt(12) + 1,
                        Random().nextInt(60),
                        if (Random().nextBoolean()) "AM" else "PM"
                    )
                )
            )
        }

        val adapter = ItemAdapter(itemList)
        val listView = findViewById<ListView>(R.id.listView)
        listView.adapter = adapter
    }
}
