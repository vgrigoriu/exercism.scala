object PerfectNumbers {
  def classify(n: Int): Either[String, NumberType.Value] =
    if (n < 1)
      Left("Classification is only possible for natural numbers.")
    else
      Right((1 to n / 2) filter (n % _ == 0) sum match {
        case sum if sum > n =>
          NumberType.Abundant
        case sum if sum == n =>
          NumberType.Perfect
        case sum if sum < n =>
          NumberType.Deficient
      })
}
