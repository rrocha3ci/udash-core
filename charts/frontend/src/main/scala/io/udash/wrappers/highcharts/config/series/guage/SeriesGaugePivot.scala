/** Based on <a href="https://github.com/Karasiq/scalajs-highcharts">Karasiq wrapper</a>. */
package io.udash.wrappers.highcharts
package config
package series.guage

import io.udash.wrappers.highcharts.HighchartsUtils._

import scala.scalajs.js
import scala.scalajs.js.`|`


//TODO not verified
@js.annotation.ScalaJSDefined
class SeriesGaugePivot extends js.Object {

  /**
    * The background color or fill of the pivot.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/plotoptions/gauge-pivot/" target="_blank">Pivot options demonstrated</a>
    */
  val backgroundColor: js.UndefOr[String | js.Object] = js.undefined

  /**
    * The border or stroke color of the pivot. In able to change this, the borderWidth must also be set to something other than the default 0.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/plotoptions/gauge-pivot/" target="_blank">Pivot options demonstrated</a>
    */
  val borderColor: js.UndefOr[String | js.Object] = js.undefined

  /**
    * The border or stroke width of the pivot.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/plotoptions/gauge-pivot/" target="_blank">Pivot options demonstrated</a>
    */
  val borderWidth: js.UndefOr[Double] = js.undefined

  /**
    * The pixel radius of the pivot.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/plotoptions/gauge-pivot/" target="_blank">Pivot options demonstrated</a>
    */
  val radius: js.UndefOr[Double] = js.undefined
}

object SeriesGaugePivot {
  /**
    * @param backgroundColor The background color or fill of the pivot.
    * @param borderColor The border or stroke color of the pivot. In able to change this, the borderWidth must also be set to something other than the default 0.
    * @param borderWidth The border or stroke width of the pivot.
    * @param radius The pixel radius of the pivot.
    */
  def apply(backgroundColor: js.UndefOr[String | js.Object] = js.undefined, borderColor: js.UndefOr[String | js.Object] = js.undefined, borderWidth: js.UndefOr[Double] = js.undefined, radius: js.UndefOr[Double] = js.undefined): SeriesGaugePivot = {
    val backgroundColorOuter: js.UndefOr[String | js.Object] = backgroundColor
    val borderColorOuter: js.UndefOr[String | js.Object] = borderColor
    val borderWidthOuter: js.UndefOr[Double] = borderWidth
    val radiusOuter: js.UndefOr[Double] = radius
    new SeriesGaugePivot {
      override val backgroundColor: js.UndefOr[String | js.Object] = backgroundColorOuter
      override val borderColor: js.UndefOr[String | js.Object] = borderColorOuter
      override val borderWidth: js.UndefOr[Double] = borderWidthOuter
      override val radius: js.UndefOr[Double] = radiusOuter
    }
  }
}
