$(document).ready(function() {

    $('#adddrink').on('submit', function(e) {

        var drinkName = $('#drinkname').val();
        var type = $('#type').val();
        var qty = $('#qty').val();
        var ml = $('#ml').val();
        var abv = $('#abv').val();

        var response = $.ajax(
            {
                data: {drinkName: drinkName, type: type, qty: qty, ml: ml, abv: abv},
                method: 'POST',
                url: 'add'
            }
        ).responseText;

        console.log(response);

        e.preventDefault();
    });

});
