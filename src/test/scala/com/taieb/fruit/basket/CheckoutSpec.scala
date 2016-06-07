package com.taieb.fruit.basket

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{Matchers, WordSpec}

/**
  * Created by or.taieb on 07/06/2016.
  */
@RunWith( classOf[JUnitRunner] )
class CheckoutSpec extends WordSpec with Matchers {

  "Checkout" when {

    "calculate price of basket" should {

      "respond with zero for empty basket" in {
        Checkout.items( EmptyBasket ).calculate should be ( BigDecimal( 0 ) )
      }

      "return £6.00 for ten apples" in {
        Checkout.items( List( Apple , Apple , Apple , Apple , Apple , Apple , Apple , Apple , Apple , Apple ) ).calculate should be ( BigDecimal( 6.0 ) )
      }

      "return £0.50 for two oranges" in {
        Checkout.items( List( Orange , Orange ) ).calculate should be ( BigDecimal( 0.50 ) )
      }

      "return sum of mixed basket" in {
        Checkout.items( List( Apple , Apple , Orange , Apple , Orange ) ).calculate should be ( BigDecimal( 2.30 ) )
      }
    }

    "convert list of strings to Basket ( a List of items )" should {

      "reject list with invalid items" in {
        an [IllegalArgumentException] should be thrownBy Checkout( List("Orange" , "Apple" , "Invalid") )
      }

      "reject varargs with invalid items" in {
        an [IllegalArgumentException] should be thrownBy Checkout( "Orange" , "Apple" , "Invalid" )
      }

      "convert each supported string to item" in {
        Checkout( "Apple" , "Orange" , "Orange" ).basket should be ( List( Apple , Orange , Orange ) )
      }

      "convert supported codes to items" in {
        Checkout( "A" , "O" , "A" ).basket should be ( List( Apple , Orange , Apple ) )
      }

    }

    "complete task" should {

      "return calculated price of string basked input" in {
        Checkout( "Orange" , "O" , "O" , "Apple" , "APPLE" , "A" , "Apple" ).calculate should be ( BigDecimal( 3.15 ) )
      }

    }

  }

}
