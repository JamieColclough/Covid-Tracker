package com.example.covidtracker.api

import java.util.*

data class CovidData (val totalCases: Int, val totalDeaths: Int, val lastUpdatedAtSource: Date, val casesByState : List<StateCaseData>)

data class StateCaseData(val name: String, val casesReported: Int)