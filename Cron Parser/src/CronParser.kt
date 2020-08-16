import kotlin.text.StringBuilder

class CronParser {

    companion object {
        fun parse(cron: Cron) {

            if (Helper.isParsableBaseCron(cron)) return

            var result = """
               ${parseSeconds(cron.seconds)}
               ${parseMinutes(cron.minutes)}
               ${parseHours(cron.hours)}
               ${parseDaysOfMonth(cron.daysOfMonth)}
               ${parseMonths(cron.months)}
               ${parseDaysOfWeek(cron.daysOfWeek)}
               ${parseYears(cron.years)}
           """.trimIndent()

            println(result)
        }


        private fun parseSeconds(seconds: String): String {

            if (seconds.equals(Constants.STAR) or (seconds == "0"))
                return "Every second."

            if (seconds.length == 1 || seconds.length == 2)
                return "At the second: $seconds."

            if (seconds.contains(Constants.COMMA.value)
                    and !seconds.contains(Constants.HYPHEN.value)
                    and !seconds.contains(Constants.SLASH.value))
                return Helper.parseCommaString("At the seconds: ", seconds)

            if (seconds.contains(Constants.HYPHEN.value)
                    and !seconds.contains(Constants.COMMA.value)
                    and !seconds.contains(Constants.SLASH.value))
                return Helper.parseHyphenString("Every second between the seconds: ", seconds)

            if (seconds.contains(Constants.SLASH.value)
                    and !seconds.contains(Constants.HYPHEN.value)
                    and !seconds.contains(Constants.COMMA.value))
                return Helper.parseSlashString("second", seconds)

            if (!seconds.contains(Constants.SLASH.value)
                    and seconds.contains(Constants.HYPHEN.value)
                    and seconds.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedHyphenString("second", seconds)

            if (seconds.contains(Constants.SLASH.value)
                    and !seconds.contains(Constants.HYPHEN.value)
                    and seconds.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedSlashString("second", seconds)

            if (seconds.contains(Constants.SLASH.value)
                    and seconds.contains(Constants.HYPHEN.value)
                    and seconds.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedSlashString("second", seconds)

            return ""
        }

        private fun parseMinutes(minutes: String): String {
            if (minutes.equals(Constants.STAR) or (minutes == "0"))
                return "Every minute."

            if (minutes.length == 1 || minutes.length == 2)
                return "At the minute: $minutes."

            if (minutes.contains(Constants.COMMA.value)
                    and !minutes.contains(Constants.HYPHEN.value)
                    and !minutes.contains(Constants.SLASH.value))
                return Helper.parseCommaString("At the minute: ", minutes)

            if (minutes.contains(Constants.HYPHEN.value)
                    and !minutes.contains(Constants.COMMA.value)
                    and !minutes.contains(Constants.SLASH.value))
                return Helper.parseHyphenString("Every minute between the minutes: ", minutes)

            if (minutes.contains(Constants.SLASH.value)
                    and !minutes.contains(Constants.HYPHEN.value)
                    and !minutes.contains(Constants.COMMA.value))
                return Helper.parseSlashString("minutes", minutes)

            if (!minutes.contains(Constants.SLASH.value)
                    and minutes.contains(Constants.HYPHEN.value)
                    and minutes.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedHyphenString("minute", minutes)

            if (minutes.contains(Constants.SLASH.value)
                    and !minutes.contains(Constants.HYPHEN.value)
                    and minutes.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedSlashString("minute", minutes)

            if (minutes.contains(Constants.SLASH.value)
                    and minutes.contains(Constants.HYPHEN.value)
                    and minutes.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedSlashString("minute", minutes)

            return ""
        }

        private fun parseHours(hours: String): String {
            if (hours.equals(Constants.STAR) or (hours == "0"))
                return "Every hour."

            if (hours.length == 1 || hours.length == 2)
                return "At the hour: $hours."

            if (hours.contains(Constants.COMMA.value)
                    and !hours.contains(Constants.HYPHEN.value)
                    and !hours.contains(Constants.SLASH.value))
                return Helper.parseCommaString("At the hour: ", hours)

            if (hours.contains(Constants.HYPHEN.value)
                    and !hours.contains(Constants.COMMA.value)
                    and !hours.contains(Constants.SLASH.value))
                return Helper.parseHyphenString("Every minute between the hours: ", hours)

            if (hours.contains(Constants.SLASH.value)
                    and !hours.contains(Constants.HYPHEN.value)
                    and !hours.contains(Constants.COMMA.value))
                return Helper.parseSlashString("hours", hours)

            if (!hours.contains(Constants.SLASH.value)
                    and hours.contains(Constants.HYPHEN.value)
                    and hours.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedHyphenString("hour", hours)

            if (hours.contains(Constants.SLASH.value)
                    and !hours.contains(Constants.HYPHEN.value)
                    and hours.contains(Constants.COMMA.value))
                return Helper.parseCommaSeparatedSlashString("hour", hours)

            if (hours.contains(Constants.SLASH.value)
                    and hours.contains(Constants.HYPHEN.value)
                    and hours.contains(Constants.COMMA.value))
                return Helper.parseChsString("hour", hours)

            return ""
        }

        private fun parseDaysOfMonth(daysOfMonth: String): String {
            return ""
        }

        private fun parseMonths(months: String): String {
            return ""
        }

        private fun parseDaysOfWeek(daysOfWeek: String): String {
            return ""
        }

        private fun parseYears(years: String?): String {
            return ""
        }


    }
}

