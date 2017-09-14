var TableManaged = function () {

    return {

        //main function to initiate the module
        init: function (tablesettings) {
            
           /* if (!jQuery().dataTable) {
                return;
            }*/
            $('#sample_1').dataTable( tablesettings).fnDraw();
        }
    };

}();