import kotlinx.html.*
import kotlinx.html.head
import kotlinx.html.html
import kotlinx.html.stream.appendHTML
import kotlinx.html.style
import kotlinx.html.table
import kotlinx.html.tbody
import kotlinx.html.unsafe
import java.io.File
import java.util.UUID

fun main() {
  val text = buildString {
    appendLine("<!DOCTYPE html>")
    appendHTML().html {
      head {
        style {
          unsafe {
            raw("""
body {
}

table.propertyTable {
	width: 600px;
	border: 1px solid;
}

table.propertyTable tbody th {
	padding: 8px;
	font-weight: bold;
}

table.propertyTable tbody td {
	padding: 8px;
}

table.dataTable {
	width: 950px;
	border: 1px solid black;
}

table.dataTable td, table.dataTable th  {
	border: 1px solid black;
}

table.dataTable td.matched {
	background-color: lightgreen;
}

"""
            )
          }
        }
      }

      body {
        table(classes = "dataTable") {
          tbody {
            tr {
              td { +"Id" }
              td(classes = "matched") { +"Some matched description" }
              td(classes = "matched") { +"21.55" }
              td { +"LOL" }
            }
            tr {
              td { +"Id" }
              td(classes = "matched") { +"Some matched description" }
              td(classes = "matched") { +"21.55" }
              td { +"LOL" }
            }
            tr {
              td { +"Id" }
              td(classes = "matched") { +"Some matched description" }
              td(classes = "matched") { +"21.55" }
              td { +"LOL" }
            }
            tr {
              td { +"Id" }
              td(classes = "matched") { +"Some matched description" }
              td(classes = "matched") { +"21.55" }
              td { +"LOL" }
            }
          }
        }

        hr {  }

        table(classes = "propertyTable") {
          tbody {
            tr {
              th { +"Id" }
              td { +UUID.randomUUID().toString() }
            }
          }
        }
      }
    }
    appendLine()
  }

  File("/other-drive/test.html").writeText(text)
}

class TestHtml {

}
