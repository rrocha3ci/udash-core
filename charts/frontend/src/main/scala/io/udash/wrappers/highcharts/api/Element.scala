/** Based on <a href="https://github.com/Karasiq/scalajs-highcharts">Karasiq wrapper</a>. */
package io.udash.wrappers.highcharts
package api

import io.udash.wrappers.highcharts.HighchartsUtils._

import scala.scalajs.js

// TODO not verified
@js.native
trait Element extends js.Object {

  /**
    * Add the element to the renderer canvas.
    * @param parent The element can be added to a <code>g</code> (group) element.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/renderer-g/" target="_blank">Elements added to a group</a>
    */
  def add(parent: js.Object = ???): Element = js.native

  /**
    * Apply numeric attributes to the SVG/VML element by animation. See <a href="#Element.attr()">Element.attr()</a> for more information on setting attributes.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/element-on/" target="_blank">Setting some attributes by animation</a>
    */
  def animate(attributes: js.Object = ???, animation: js.Object = ???): Element = js.native

  /**
    * Apply some CSS properties to the element
    * @param hash The object literal of CSS properties to apply. Properties should be hyphenated, not camelCased.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/renderer-text-on-chart/" target="_blank">Styled text</a>
    */
  def css(hash: js.Object = ???): Element = js.native

  /**
    * Apply an event handler to the element
    * @param eventType The event type to attach, for example 'click', 'mouseover', 'touch'.
    * @param handler The event handler function.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/element-on/" target="_blank">A clickable rectangle</a>.
    */
  def on(eventType: String = ???, handler: js.Function = ???): Element = js.native

  /**
    * Bring the element to the front. Alternatively, a zIndex attribute can be given.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/element-tofront/" target="_blank">Click an element to bring it to front</a>.
    */
  val toFront: Element = js.native

  /**
    * <p>Apply attributes to the SVG/VML elements. These attributes for the most parts correspond to SVG, but some are specific to Highcharts, like <code>zIndex</code> and <code>rotation</code>.</p>
    * 
    * <p>In order to set the rotation center for <code>rotation</code>, set x and y to 0 and use <code>translateX</code> and <code>translateY</code> attributes to position the element instead.</p>
    * 
    * <p>Attributes frequently used in Highcharts are <code>fill</code>, <code>stroke</code>, <code>stroke-width</code>.</p>
    * @param hash A set of attributes to apply.
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/renderer-rect/" target="_blank">Setting some attributes</a>
    */
  def attr(hash: js.Object = ???): Element = js.native

  /**
    * Destroy the element and free up memory
    */
  val destroy: js.Any = js.native

  /**
    * Get the bounding box of the element
    * @example <a href="http://jsfiddle.net/gh/get/jquery/1.7.2/highslide-software/highcharts.com/tree/master/samples/highcharts/members/renderer-on-chart/" target="_blank">Draw a rectangle based on a text's bounding box</a>.
    */
  val getBBox: js.Object = js.native
}
