object FlattenArray {
  def flatten(list: List[Any]): List[Any] =
    list.flatMap(thing => thing match {
      case l: List[Any] => flatten(l)
      case null => List()
      case o: Any => List(o)
    })
}
