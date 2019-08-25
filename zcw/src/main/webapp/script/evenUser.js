$("tbody .btn-success").click(function(){
    window.location.href = "assignRole.html";
});
$("tbody .btn-primary").click(function(){
    $("#lableText").load("edit1.html");
    //window.location.href = "edit1.html";
});

function openMenu(ob){
    if ( $(this).find("ul") ) {
        $(this).toggleClass("tree-closed");
        if ( $(this).hasClass("tree-closed") ) {
            $("ul", this).hide("fast");
        } else {
            $("ul", this).show("fast");
        }
    }

};