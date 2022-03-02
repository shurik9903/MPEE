"use strict";

export const RefreshStyle_module =  (function(){

    class RefreshStyle_class{

        setClick(){
                $('.table tbody tr').click(function(){
                    $('.table tbody td').attr('contenteditable', 'false');
                    $('.table tbody tr').removeClass('active');
                    $('.table tbody tr').find("button").remove()

                    $(this).addClass('active');
                    let but = $('<button/>',
                        {
                            text: 'Delete',
                            click: function () {
                                this.table = document.getElementById("MyTable").getElementsByTagName('tbody')[0];
                                this.table.deleteRow($(this).parent().get(0).rowIndex-1);
                            }
                        });

                    $(this).append(but);
                });
        };

        setDblClick(){
            $('.table tbody td').dblclick(function() {
                    $('.table tbody td').attr('contenteditable', 'false');
                    $('.table tbody tr').removeClass('active');


                    $(this).attr('contenteditable', 'true');
                    $(this).addClass('active');
                    $(this).focus();
            });
        };

        setHover(){
            $('.table tr').hover(function(){
                    $(this).addClass('hover');
                }, function() {
                    $(this).removeClass('hover');
            });
        };
    }

    let setClick = function(){
        new RefreshStyle_class().setClick();
    }

    let setDblClick = function(){
        new RefreshStyle_class().setDblClick();
    }

    let setHover = function(){
        new RefreshStyle_class().setHover();
    }

    let AllRefresh = function(){
        new RefreshStyle_class().setClick();
        new RefreshStyle_class().setDblClick();
        new RefreshStyle_class().setHover();
    }

    return{
        setClick: setClick,
        setDblClick: setDblClick,
        setHover: setHover,
        AllRefresh: AllRefresh
    }

})();
