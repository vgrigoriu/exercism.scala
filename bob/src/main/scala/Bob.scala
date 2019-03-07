object Bob {
  def response(statement: String): String =
    if (isSilence(statement)) {
      "Fine. Be that way!"
    } else if (isShouting(statement) && isQuestion(statement)) {
      "Calm down, I know what I'm doing!"
    } else if (isShouting(statement)) {
      "Whoa, chill out!"
    } else if (isQuestion(statement)) {
      "Sure."
    } else {
      "Whatever."
    }

  def isSilence(statement: String): Boolean =
    statement.trim.isEmpty

  def isShouting(statement: String): Boolean = {
    val letters = statement.filter(_.isLetter)
    !letters.isEmpty && letters.forall(_.isUpper)
  }

  def isQuestion(statement: String): Boolean =
    statement.trim.last == '?'
}
