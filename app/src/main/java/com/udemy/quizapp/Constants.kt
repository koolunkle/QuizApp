package com.udemy.quizapp

object Constants {

    fun getQuestion(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()

        val firstQuestion = Question(
            1,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Armenia",
            "Austria",
            1
        )
        questionsList.add(firstQuestion)

        val secondQuestion = Question(
            2,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Angola",
            "Austria",
            "Australia",
            "Armenia",
            3
        )
        questionsList.add(secondQuestion)

        val thirdQuestion = Question(
            3,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Belarus",
            "Belize",
            "Brunei",
            "Brazil",
            4
        )
        questionsList.add(thirdQuestion)

        val fourthQuestion = Question(
            4,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Bahamas",
            "Belgium",
            "Barbados",
            "Belize",
            2
        )
        questionsList.add(fourthQuestion)

        val fifthQuestion = Question(
            5,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Gabon",
            "France",
            "Fiji",
            "Finland",
            3
        )
        questionsList.add(fifthQuestion)

        val sixthQuestion = Question(
            6,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Germany",
            "Georgia",
            "Greece",
            "none of these",
            1
        )
        questionsList.add(sixthQuestion)

        val seventhQuestion = Question(
            7,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Dominica",
            "Egypt",
            "Denmark",
            "Ethiopia",
            3
        )
        questionsList.add(seventhQuestion)

        val eighthQuestion = Question(
            8,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Ireland",
            "India",
            "Hungary",
            "Iran",
            2
        )
        questionsList.add(eighthQuestion)

        val ninthQuestion = Question(
            9,
            "What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "Jordan",
            "Palestine",
            "Sudan",
            "New Zealand",
            4
        )
        questionsList.add(ninthQuestion)

        return questionsList
    }

}