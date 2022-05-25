package uz.eloving.psychorotte

object Constants {
    fun getQuestions():ArrayList<QuestionModel>{
        val question = ArrayList<QuestionModel>()
        question.add(QuestionModel(
            "Sizni kimni sevasiz ?",
            "Munisa",
            "Munisa",
            "Munisa",
            "Munisa",
            "Munisa"
        ))
        question.add(QuestionModel(
            "Sizni kimni sevasiz ? 2",
            "Munisa 2",
            "Munisa 2",
            "Munisa 2",
            "Munisa 2",
            "Munisa 2"
        ))
        return question
    }
}