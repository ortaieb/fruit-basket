package com.taieb.fruit.basket

/**
  * Created by or.taieb on 07/06/2016.
  */
abstract class Item(val itemName : String, val unitPrice : Price, val offer : ( Int ) => BigDecimal )

case object Apple  extends Item( "Apple"  , ApplePrice , ( units : Int ) => { ( units / 2 + units % 2 ) * ApplePrice } )
case object Orange extends Item( "Orange" , OrangePrice , ( units : Int ) => { ( ( units / 3 ) * 2 + ( units % 3 ) ) * OrangePrice }  )
