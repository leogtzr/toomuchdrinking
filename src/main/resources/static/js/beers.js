function hideAlerts() {
  $('.alert-success').hide();
  $('.alert-danger').hide();
}

function cleanFields() {
  $('#drinkname').val('');
  $('#ml').val('');
  $('#abv').val('');
}

$('#adddrink').on('submit', function(e) {
  hideAlerts();

  var drinkName = $('#drinkname').val();
  var type = $('#type').val();
  var qty = $('#qty').val();
  var ml = $('#ml').val();
  var abv = $('#abv').val();

  $.ajax({
    data: { drinkName: drinkName, type: type, qty: qty, ml: ml, abv: abv },
    method: 'POST',
    url: 'add',
    async: false
  })
  .done(function(data) {
    $('.alert-success').show();
    cleanFields();
  })
  .fail(function(jqXHR, textStatus) {
    $('.alert-danger').show();
  });
  
  e.preventDefault();
});