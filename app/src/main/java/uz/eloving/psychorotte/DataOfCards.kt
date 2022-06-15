package uz.eloving.psychorotte

import android.content.Context



class MockData {
    companion object {
        fun getDataOfCards(ctx: Context): ArrayList<DataOfCards> {
            val list = ArrayList<DataOfCards>()
            list.add(
                DataOfCards(
                    R.drawable.travel,
                    "1-Daraja",
                    "Boshlang'ich",
                    "Yuqori - ${PrefManager.getBeginnerHighScore(ctx)}",
                    "#ED788D",
                    "#FFB300"
                )
            )
            list.add(
                DataOfCards(
                    R.drawable.air_ballon_with_clouds,
                    "2-Daraja",
                    "O'rganuvchi",
                    "Yuqori - ${PrefManager.getMediumHighScore(ctx)}",
                    "#2962FF",
                    "#FF03DAC5"
                )
            )
            list.add(
                DataOfCards(
                    R.drawable.photo,
                    "3-Daraja",
                    "Tajribali",
                    "Yuqori - ${PrefManager.getProHighScore(ctx)}",
                    "#FFB300",
                    "#FF6D00"
                )
            )
            return list
        }
    }
    data class DataOfCards(
        val image: Int,
        val level: String,
        val type: String,
        val highScore: String,
        val cardBg: String,
        val btnBg:String
    )
}