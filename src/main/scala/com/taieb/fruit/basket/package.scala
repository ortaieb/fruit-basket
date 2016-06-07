package com.taieb.fruit

/**
  * Created by or.taieb on 07/06/2016.
  */
package object basket {

  type Basket = List[Item]

  type Price = BigDecimal


  val EmptyBasket = List[Item]()

  val ApplePrice = BigDecimal( 0.60 )
  val OrangePrice = BigDecimal( 0.25 )

  implicit class StringToItem( input : String ) {
    def asItem() = input.toUpperCase match {
      case "APPLE" => Apple
      case "A" => Apple
      case "ORANGE" => Orange
      case "O" => Orange
      case _ => throw new IllegalArgumentException( "Unsupported item identifier" )
    }
  }
}
