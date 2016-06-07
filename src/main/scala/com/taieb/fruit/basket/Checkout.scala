package com.taieb.fruit.basket

/**
  * Created by or.taieb on 07/06/2016.
  */
class Checkout( val basket : Basket ) {

  def calculate() : BigDecimal = {

    basket
      .groupBy( item => item )
      .map( item => (item._1 -> item._2.size ) )
      .map( item => item._1.price * item._2 )
      .sum

  }
}

object Checkout {

  def items( itemNames : List[Item] ): Checkout = new Checkout( itemNames )
  def apply( itemNames : List[String] ): Checkout = new Checkout( itemNames.map( _.asItem ) )
  def apply( itemNames : String* ): Checkout = new Checkout( itemNames.toList.map( _.asItem ) )

}
