//Get all notes from localstorage and add them to our page
let tempNotes = store.get('notes')
const notes = tempNotes ? [...tempNotes] : []
if (notes.length !== 0) {
  for (let i = 0; i < notes.length; i++) {
    const note = notes[i]
    addNote(note)
  }
}

$('.colors').click(function() {
  $('.colors').removeClass('selected')
  $(this).addClass('selected')
})

$('#add').click(function() {
  //Store textarea value at time button is clicked
  const text = $('#text').val()
  //Store color at time button is clicked
  const color = $('.selected').data('color')
  const id = notes.length !== 0 ? notes[notes.length - 1].id + 1 : 1
  const note = { id, color, text }

  //If both text and color are invalid, display error
  if (!note.text && !note.color) {
    $('.error').hide()
    $('#errorboth').show()
    return
  }

  //If no text was input, display error
  if (!note.text) {
    $('.error').hide()
    $('#errortext').show()
    return
  }

  //If no color was selected, display error
  if (!note.color) {
    $('.error').hide()
    $('#errorcolor').show()
    return
  }
  //We got past all validation, hide any old errors
  $('.error').hide()

  //Create a note with the text and color selected
  addNote(note)
  notes.push(note)

  //Store the note into localstorage
  store.set('notes', notes)
})

//Delete note when delete icon is clicked
$('#notes-container').on('click', '.delete', function() {
  const id = $(this).data('id')
  let idToRemove = -1
  for (note in notes) {
    if (notes[note].id === id) {
      idToRemove = note
    }
  }
  if (idToRemove === -1) throw new Error('That was already removed')
  else {
    notes.splice(idToRemove, 1)
    store.set('notes', notes)
    if (notes.length === 0) store.remove('notes')
    $(this)
      .parent()
      .hide()
  }
})

//Adds the passed in note to the page
function addNote(note) {
  $('#notes-container').append(`
  <div class="note ${note.color}">
      <span class="delete" data-id="${note.id}"></span>
      <span class="inner">${note.text}</span>
  </div>
  `)
  $('textarea').val('')
  $('.colors').removeClass('selected')
}
