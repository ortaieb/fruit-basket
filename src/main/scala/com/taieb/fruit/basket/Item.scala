package com.taieb.fruit.basket

/**
  * Created by or.taieb on 07/06/2016.
  */
abstract class Item( val itemName : String , val price : Price )

case object Apple  extends Item( "Apple"  , ApplePrice )
case object Orange extends Item( "Orange" , OrangePrice )
