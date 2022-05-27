package uz.eloving.psychorotte

object Constants {
    fun getQuestions():ArrayList<QuestionModel>{
        val question = ArrayList<QuestionModel>()
        question.add(QuestionModel(
            "Python dasturlash tili yaratuvchisi kim ?",
            "Guido van Rossum",
            "Bjarne Straustrap",
            "Larry Page",
            "Sergey Brin",
            "Guido van Rossum"
        ))
        question.add(QuestionModel(
            "Python qaysi yilda yaratilgan ?",
            "1995",
            "1991",
            "1987",
            "1985",
            "1991"
        ))
        return question
    }
}