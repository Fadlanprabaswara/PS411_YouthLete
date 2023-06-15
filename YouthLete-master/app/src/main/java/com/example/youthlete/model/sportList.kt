package com.example.youthlete.model

import com.example.youthlete.R

object sportList {
    val sportss = listOf(
        Sports(
            "Sepak Bola",
            "30",
            R.drawable.soccer_image,
            "sepak bola adalah sebuah cabang olahraga yang menggunakan sebuah bola yang terbuat dari kulit atau karet dan dimainkan oleh dua tim, yang mana masing-masing Tim terdiri dari sebelas pemain dan ada juga beberapa pemain yang berperan sebagai pemain pengganti",
            listOf(
                Course("Pengenalan Sepak Bola",R.drawable.soccer),
                Course("Teknik Dasar Sepak Bola",R.drawable.soccer_technique),
                Course("Strategi Permainan",R.drawable.soccer_strategy)
            )
        ),
        Sports(
            "Bulutangkis",
            "40",
            R.drawable.badminton_image,
            " Bulu tangkis adalah suatu olahraga raket yang dimainkan oleh dua orang (untuk tunggal) atau dua pasangan (untuk ganda) yang saling berlawanan. Di Indonesia, bulu tangkis termasuk satu di antara olahraga populer.",
            listOf(
                Course("Pengenalan Bulutangkis",R.drawable.badminton),
                Course("Teknik Dasar Bulutangkis",R.drawable.badminton_technique),
                Course("Strategi Bermain",R.drawable.badminton_stratgy)
            )
        ),
        Sports(
            "Renang",
            "3",
            R.drawable.swimming_image,
            " Renang merupakan satu di antara cabang olahraga akuatik. Renang adalah upaya untuk menggerakkan (mengapungkan atau mengangkat) semua bagian tubuh ke atas permukaan air.",
            listOf(
                Course("Pengenalan Renang",R.drawable.swimming),
                Course("Teknik Dasar Renang",R.drawable.swimming_technique),
                Course("Gaya Kupu-kupu",R.drawable.swimming_butterfly)
            )
        ),
        Sports(
            "Fighter",
            "6",
            R.drawable.sports_boxing,
            "Seni bela diri campuran atau lebih dikenal dengan sebutan Mixed Martial Arts (MMA) adalah olahraga kontak yang memperbolehkan berbagai teknik pertarungan, seperti pergumulan, tendangan, dan pukulan.Di dalam MMA, masing-masing praktisi didorong untuk mengkombinasikan teknik dari berbagai cabang seni bela diri untuk melumpuhkan lawan",
            listOf(
                Course("Abductors",R.drawable.abductor),
                Course("Adductors",R.drawable.adductors),
                Course("Biceps",R.drawable.biceps),
                Course("Calves",R.drawable.calves),
                Course("Chest",R.drawable.chest),
                Course("Foreams",R.drawable.forearms),
            )
        ),
        Sports(
            "Basketball",
            "8",
            R.drawable.sports_basketball,
            "Bola basket merupakan salah satu jenis olahraga yang menggunakan bola besar. Bola dimainkan secara berkelompok yang terdiri dari dua tim yang masing-masing beranggotakan lima orang. Kedua tim tersebut bersaing untuk mencetak poin sebanyak-banyaknya dengan cara memasukkan bola ke ring/basket lawan",
            listOf(
                Course("Abductors",R.drawable.abductor),
                Course("Adductors",R.drawable.adductors),
                Course("Biceps",R.drawable.biceps),
                Course("Calves",R.drawable.calves),
                Course("Chest",R.drawable.chest),
                Course("Glutes",R.drawable.glutes),
                Course("Hamstring",R.drawable.hamstring),
                Course("Lower_Back",R.drawable.lower_back),
            )
        ),
        Sports(
            "Volleyball",
            "8",
            R.drawable.sports_volley,
            "permainan olahraga yang dimainkan oleh dua grup berlawanan. Masing-masing grup memiliki enam orang pemain. Terdapat pula variasi permainan bola voli pantai yang masing-masing timnya hanya memiliki dua orang pemain.",
            listOf(
                Course("Abductors",R.drawable.abductor),
                Course("Adductors",R.drawable.adductors),
                Course("Biceps",R.drawable.biceps),
                Course("Calves",R.drawable.calves),
                Course("Chest",R.drawable.chest),
                Course("Shoulder",R.drawable.shoulder),
                Course("Hamstring",R.drawable.hamstring),
                Course("Glutes",R.drawable.glutes),
            )
        )
    )
}