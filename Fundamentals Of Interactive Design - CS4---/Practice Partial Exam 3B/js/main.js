//Load initial vote scores
$(document).ready(function() {
  let votes = store.get('votes')
  //If we didn't have any vote object stored in localstorage, create one.
  if (!votes) {
    votes = { amlo: 0, zavala: 0, bronco: 0, meade: 0, anaya: 0 }
    store.set('votes', votes)
  }
  recount(votes)
})

//Login
$('.login_button').click(function() {
  const INE = $('#ine').val()
  if (!INE) {
    $('.error1')
      .fadeIn(1000)
      .delay(2000)
      .fadeOut(1000)
  } else {
    store.set('active', INE)
    $('#login').hide()
    $('#voting').show()
  }
})

//Record Votes
$('.candidate').click(function() {
  const INE = store.get('active')
  const voters = store.get('voters') || []
  const votes = store.get('votes')
  if (voters.indexOf(INE) === -1) {
    //Store voter in voters
    voters.push(INE)
    store.set('voters', voters)
    //Store vote
    const vote = $(this).data('candidate')
    votes[vote]++
    store.set('votes', votes)
    recount(votes)
  } else {
    $('.error3').fadeIn(1000)
  }
})

function recount(votes) {
  //Loop thorugh the candidates and set their votes.
  $('.candidate').each(function() {
    const currentCandidate = $(this).data('candidate')
    $(this).html(`<span>${votes[currentCandidate]}</span>`)
  })
}
