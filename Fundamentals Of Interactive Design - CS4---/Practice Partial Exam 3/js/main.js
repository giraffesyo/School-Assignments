$('.colors').click(function() {
  $('.colors').removeClass('selected')
  $(this).addClass('selected')
})

$('#add').click(function() {
  //Store textarea value at time button is clicked
  const text = $('#text').val()
  //Store color at time button is clicked
  const color = $('.selected').data('color')

  //If both text and color are invalid, display error
  if (!text && !color) {
    $('.error').hide()
    $('#errorboth').show()
    return
  }

  //If no text was input, display error
  if (!text) {
    $('.error').hide()
    $('#errortext').show()
    return
  }

  //If no color was selected, display error
  if (!color) {
    $('.error').hide()
    $('#errorcolor').show()
    return
  }
  //We got past all validation, hide any old errors
  $('.error').hide()

  //Create a note with the text and color selected
  $('#notes-container').append(`
  <div class="note ${color}">
      <span class="delete" data-note="note1"></span>
      <span class="inner">${text}</span>
  </div>
  `)
})
