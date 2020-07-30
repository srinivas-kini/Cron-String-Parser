enum class Constants(val value: String) {
    //, - * ? / L W #
    SLASH("/"),
    COMMA(","),
    STAR("*"),
    HYPHEN("-"),
    HASH("#"),
    QUESTION_MARK("?"),
    L("L"),
    W("W")

}

enum class Day(val value: String) {
    //SUN-SAT
    SUN("Sunday"),
    M0N("Monday"),
    TUE("Tuesday"),
    WED("Wednesday"),
    THU("Thursday"),
    FRI("Friday"),
    SAT("Saturday"),

}

enum class Month(val value: String) {
    //JAN-DEC
    JAN("January"),
    FEB("February"),
    MARCH("March"),
    APRIL("April"),
    MAY("May"),
    JUNE("June"),
    JULY("July"),
    AUGUST("August"),
    SEPTEMBER("September"),
    OCTOBER("October"),
    NOVEMBER("November"),
    DECEMBER("December")

}

enum class BaseCron(val value: String) {
    CRON1("* * * ? * * *"),
    CRON2("* * * * * ? *"),
    CRON3("* * * * * ?"),
    CRON4("* * * ? * *"),
    CRON5("0 * * ? * *"),
    CRON6("0 * * * * ?"),
    CRON7("0 * * ? * * *"),
    CRON8("0 * * * * ? *"),
    CRON9("0 0 * * * ?"),
    CRON10("0 0 * * * ? *"),
    CRON11("0 0 * ? * *"),
    CRON12("0 0 * ? * * *"),
    CRON13("0 0 0 * * ?"),
    CRON14("0 0 0 * * ? *"),
    CRON15("0 0 0 ? * *"),
    CRON16("0 0 0 ? * * *"),

}