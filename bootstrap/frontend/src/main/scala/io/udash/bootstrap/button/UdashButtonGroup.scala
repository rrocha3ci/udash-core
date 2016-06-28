package io.udash.bootstrap
package button

import io.udash._
import io.udash.properties.ModelPart
import org.scalajs.dom

import scala.concurrent.ExecutionContext
import scalatags.JsDom.all._

class UdashButtonGroup[ItemType, ElemType <: Property[ItemType]] private
                      (val items: io.udash.properties.SeqProperty[ItemType, ElemType],
                       size: ButtonSize, vertical: Boolean, justified: Boolean, toggle: Boolean)
                      (itemFactory: (ElemType) => dom.Element) extends UdashBootstrapComponent {

  import io.udash.bootstrap.BootstrapTags._

  private lazy val classes: List[Modifier] = BootstrapStyles.Button.btnGroup ::
    BootstrapStyles.Button.btnGroupVertical.styleIf(vertical) ::
    BootstrapStyles.Button.btnGroupJustified.styleIf(justified) ::
    size :: Nil

  lazy val render: dom.Element = {
    div(role := "group", classes, if (toggle) dataToggle := "buttons" else ())(
      repeat(items)(
        // "To use justified button groups with <button> elements, you must wrap each button in a button group.
        // Most browsers don't properly apply our CSS for justification to <button> elements,
        // but since we support button dropdowns, we can work around that." ~ http://getbootstrap.com/components/#btn-groups
        if (justified) (item) => div(BootstrapStyles.Button.btnGroup)(itemFactory(item)).render
        else itemFactory
      )
    ).render
  }
}

object UdashButtonGroup {
  trait CheckboxModel {
    def text: String
    def checked: Boolean
  }
  case class DefaultCheckboxModel(override val text: String, override val checked: Boolean) extends CheckboxModel
  val defaultCheckboxFactory = (el: CastableProperty[CheckboxModel]) => {
    val model = el.asModel
    UdashButton.toggle(active = model.subProp(_.checked))(model.subProp(_.text).get).render
  }

  def apply(size: ButtonSize = ButtonSize.Default, vertical: Boolean = false, justified: Boolean = false)
           (buttons: dom.Element*)(implicit ec: ExecutionContext): UdashButtonGroup[Int, Property[Int]] = {
    val idxs = SeqProperty[Int](0 until buttons.size)
    reactive[Int, Property[Int]](idxs, size, vertical, justified)(idx => buttons(idx.get))
  }

  def reactive[ItemType, ElemType <: Property[ItemType]]
           (items: io.udash.properties.SeqProperty[ItemType, ElemType],
            size: ButtonSize = ButtonSize.Default, vertical: Boolean = false, justified: Boolean = false)
           (itemFactory: (ElemType) => dom.Element): UdashButtonGroup[ItemType, ElemType] =
    new UdashButtonGroup[ItemType, ElemType](items, size, vertical, justified, false)(itemFactory)

  def checkboxes[ItemType <: CheckboxModel : ModelPart, ElemType <: CastableProperty[ItemType]]
                (items: io.udash.properties.SeqProperty[ItemType, ElemType],
                 size: ButtonSize = ButtonSize.Default, vertical: Boolean = false, justified: Boolean = false)
                (itemFactory: (ElemType) => dom.Element): UdashButtonGroup[ItemType, ElemType] =
    new UdashButtonGroup[ItemType, ElemType](items, size, vertical, justified, false)(itemFactory)

  def radio[ItemType <: CheckboxModel : ModelPart, ElemType <: CastableProperty[ItemType]]
           (items: io.udash.properties.SeqProperty[ItemType, ElemType],
            size: ButtonSize = ButtonSize.Default, vertical: Boolean = false, justified: Boolean = false)
           (implicit ec: ExecutionContext): UdashButtonGroup[ItemType, ElemType] = {
    val radioId = UdashBootstrap.newId()
    val selected = Property[String]("")
    new UdashButtonGroup[ItemType, ElemType](items, size, vertical, justified, true)(el => {
      val model = el.asModel
      UdashButton(active = model.subProp(_.checked))(model.subProp(_.text).get).radio(radioId, selected)
    })
  }
}