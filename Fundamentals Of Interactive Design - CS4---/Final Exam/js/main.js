$(document).ready(function() {
  // Initialize data store
  if (store.get('team-1') == null) {
    store.set('team-1', 'russia')
  }
  if (store.get('team-2') == null) {
    store.set('team-2', 'saudi-arabia')
  }
  if (store.get('team-3') == null) {
    store.set('team-3', 'egypt')
  }
  if (store.get('team-4') == null) {
    store.set('team-4', 'uruguay')
  }
  rebuildList()
})

$('.arrow-up').click(function() {
  //Find out which country was clicked
  const countryClicked = $(this)
    .parent()
    .attr('class')
  const currentPosition = parseInt(
    $(this)
      .parent()
      .attr('id')[4],
    10
  )

  //Do nothing if we're already at the top
  if (currentPosition !== 1) {
    const countryAbove = store.get(`team-${currentPosition - 1}`)
    store.set(`team-${currentPosition}`, countryAbove)
    store.set(`team-${currentPosition - 1}`, countryClicked)
    rebuildList()
  }
})

$('.arrow-down').click(function() {
  //Find out which country was clicked
  const countryClicked = $(this)
    .parent()
    .attr('class')
  const currentPosition = parseInt(
    $(this)
      .parent()
      .attr('id')[4],
    10
  )

  //Do nothing if we're already at the top
  if (currentPosition !== 4) {
    const countryAbove = store.get(`team-${currentPosition + 1}`)
    store.set(`team-${currentPosition}`, countryAbove)
    store.set(`team-${currentPosition + 1}`, countryClicked)
    rebuildList()
  }
})

function rebuildList() {
  $('.group div').each(function() {
    $(this).removeClass()
  })

  $('#pos-1').addClass(store.get('team-1'))
  $('#pos-2').addClass(store.get('team-2'))
  $('#pos-3').addClass(store.get('team-3'))
  $('#pos-4').addClass(store.get('team-4'))
}
