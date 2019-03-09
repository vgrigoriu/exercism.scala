object SpaceAge {
  val onEarth: Double => Double = onPlanet("Earth")
  def onMercury: Double => Double = onPlanet("Mercury")
  def onVenus: Double => Double = onPlanet("Venus")
  def onMars: Double => Double = onPlanet("Mars")
  def onJupiter: Double => Double = onPlanet("Jupiter")
  def onSaturn: Double => Double = onPlanet("Saturn")
  def onUranus: Double => Double = onPlanet("Uranus")
  def onNeptune: Double => Double = onPlanet("Neptune")

  private def onPlanet(planet: String) =
    (ageInSeconds: Double) => ageInSeconds / earthYearInSeconds / orbitalPeriod(planet)
  private val earthYearInSeconds = 60 * 60 * 24 * 365.25
  private val orbitalPeriod = Map(
    "Earth" -> 1.0,
    "Mercury" -> 0.2408467,
    "Venus" -> 0.61519726,
    "Mars" -> 1.8808158,
    "Jupiter" -> 11.862615,
    "Saturn" -> 29.447498,
    "Uranus" -> 84.016846,
    "Neptune" -> 164.79132
  )
}
