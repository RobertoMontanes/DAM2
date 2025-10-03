$(document).ready(function () {

  var colCont = 0

  $(document).on("click", "#btn-add-row", function () {
    var colums

    for (let index = 0; index <= colCont; index++) {
      if (index == colCont) {
        colums += "<td><button class='btn btn-danger btn-delete-row'>Borrar fila</button></td>"
      } else {
        colums += "<td><input></input></td>"
      }
    }

    $("#table-body").append("<tr>"+colums+"</tr>");
  });

  $(document).on("click", ".btn-delete-row", function () {
    var elemento = $(this);
    elemento.parent().parent().remove();
  });

  $(document).on("click","#btn-add-col",function() {
    $("#table-head-row").prepend("<th id='id"+(colCont+1)+"'>NOMBRE COLUMNA <button class='btn btn-danger btn-del-col'>Borrar Col</button></th>")
      colCont++

    for (let index = 0; index < $("#table-body").children().length; index++) {
      const element = $("#table-body").children().eq(index);
      
      while (element.children().length <= colCont) {        
        element.prepend("<td><input></input></td>")
      }
    }

  $(document).on("click",".btn-del-col",function() {
    var parent = $(this).parent();
    var indice;
    for (let index = 0; index < $("#table-head-row").children().length; index++) {
      const element = $("#table-head-row").children().eq(index);
      if (element.attr('id') == parent.attr('id') ) {
        indice = index;
        element.remove()
      }
    }    

    for (let index1 = 0; index1 < $("#table-body").children().length; index1++) {
      var par = $("#table-body").children().eq(index1);
      par.children().eq(indice).remove()
    }

  })
    
  })
}); 
