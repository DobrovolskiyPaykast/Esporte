package growimgs.example.testwork

class DataBase(
    val day1: List<days>,
    val day3: List<days>,
    val day5: List<days>,
    val day7: List<days>,
    val day9: List<days>,
    val day11: List<days>,
    val day13: List<days>,
    val day15: List<days>,
    val day17: List<days>,
    val day19: List<days>,
    val day21: List<days>,
    val day23: List<days>,
    val day25: List<days>,
    val day27: List<days>,
    val day29: List<days>,
    val rules: List<String>,
    val breakfast: List<String>,
    val snack1: List<String>,
    val lunch: List<String>,
    val snack2: List<String>,
    val dinner: List<String>,
)

data class days (
    val one: List<String>,
    val two: List<String>,
    val three: List<String>,
    val four: List<String>
)


data class day (
    val name: String,
    val povtor: String,
    val opis: String,
)