class Helper {
    companion object {

        fun isParsableBaseCron(cron: Cron): Boolean {
            var cronStr = "${cron.seconds} ${cron.minutes} ${cron.hours} " +
                    "${cron.daysOfMonth} ${cron.months} ${cron.daysOfWeek} "
            if (cron.years != null) cronStr += cron.years
            return parseBaseCron(cronStr)

        }

        private fun parseBaseCron(cronStr: String): Boolean {
            when (cronStr) {

                BaseCron.CRON1.value, BaseCron.CRON2.value,
                BaseCron.CRON3.value, BaseCron.CRON4.value -> {
                    println("Every second.")
                    return true
                }
                BaseCron.CRON5.value, BaseCron.CRON6.value,
                BaseCron.CRON7.value, BaseCron.CRON8.value -> {
                    println("Every minute.")
                    return true
                }
                BaseCron.CRON9.value, BaseCron.CRON10.value,
                BaseCron.CRON11.value, BaseCron.CRON12.value -> {
                    println("At the beginning of every hour.")
                    return true
                }
                BaseCron.CRON13.value, BaseCron.CRON14.value,
                BaseCron.CRON15.value, BaseCron.CRON16.value -> {
                    println("At midnight, every day.")
                    return true
                }
                else -> return false
            }
            return false
        }


        fun parseCommaString(timeVal: String?, input: String): String {
            var builder: StringBuilder = StringBuilder()
            input.split(Constants.COMMA.value).forEach { str ->
                builder.append(":$str ")
            }
            return "${timeVal ?: ""} $builder"
        }

        fun parseHyphenString(timeVal: String?, input: String): String {
            return "${timeVal ?: ""} ${input.split(Constants.HYPHEN.value[0])} " +
                    "and ${input.split(Constants.HYPHEN.value[1])}"

        }

        fun parseSlashString(timeVal: String?, input: String): String {
            if (input.contains(Constants.STAR.value))
                return "Every ${input.split(Constants.SLASH.value)[1]} ${timeVal ?: ""}, " +
                        "starting at $timeVal :0 "
            return "Every ${input.split(Constants.SLASH.value)[1]} ${timeVal ?: ""}, " +
                    "starting at ${input.split(Constants.SLASH.value)[0]}. "

        }

        fun parseCommaSeparatedHyphenString(timeVal: String?, input: String): String {
            var builder = StringBuilder()
            input.split(Constants.COMMA.value).filter {
                it.contains(Constants.HYPHEN.value)
            }
                    .forEach { str -> builder.append(parseHyphenString(timeVal, str)) }

            var csv: String = input.split(Constants.COMMA.value).filter {
                !it.contains(Constants.HYPHEN.value)
            }.joinToString(",")
            builder.append(parseCommaString(timeVal, csv))
            return "$builder"
        }

        fun parseCommaSeparatedSlashString(timeVal: String?, input: String): String {
            var builder = StringBuilder()
            input.split(Constants.COMMA.value).filter {
                it.contains(Constants.SLASH.value)
            }
                    .forEach { str -> builder.append(parseSlashString(timeVal, str)) }
            var csv: String = input.split(Constants.COMMA.value).filter {
                !it.contains(Constants.HYPHEN.value)
            }.joinToString(",")
            builder.append(parseCommaString(timeVal, csv))
            return "$builder"

        }

        fun parseChsString(timeVal: String?, input: String): String {
            var builder = StringBuilder()

            //Hyphens
            input.split(Constants.COMMA.value).filter { it.contains(Constants.HYPHEN.value) }
                    .forEach { str -> builder.append(parseHyphenString(timeVal, str)) }
            //Slash
            input.split(Constants.COMMA.value).filter { it.contains(Constants.SLASH.value) }
                    .forEach { str -> builder.append(parseSlashString(timeVal, str)) }
            //CSV
            var csv = input.split(Constants.COMMA.value).filter {
                !it.contains(Constants.HYPHEN.value
                ) && !it.contains(Constants.SLASH.value)
            }.joinToString(",")


            return "$builder"


        }
    }


}