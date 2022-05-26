package uz.eloving.psychorotte

object Constants {
    fun getQuestions():ArrayList<QuestionModel>{
        val question = ArrayList<QuestionModel>()
        question.add(QuestionModel(
            "Savol1",
            "Variant1",
            "Variant2",
            "Variant3",
            "Variant4",
            "Variant1"
        ))
        question.add(QuestionModel(
            "Savol2",
            "Variant1",
            "Variant2",
            "Variant3",
            "Variant4",
            "Variant1"
        ))
        return question
    }
}