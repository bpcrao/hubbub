package hubbub



class DailyDigestJob {
    static triggers = {
      simple repeatInterval: 5000l // execute job once in 5 seconds
    }

    def execute() {
   print "Scheduled => JOB"
    }
}
