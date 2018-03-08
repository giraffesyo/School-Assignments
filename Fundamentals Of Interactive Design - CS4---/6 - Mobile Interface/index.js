//Create global variables to store user responses
var gender = ''
var animal = ''
var color = ''
var total = 0
var res = ""

// Show border arounded currently selected
$('.item').on('click', function() {
  $('.item').removeClass('selected')
  $(this).addClass('selected')
  total = $(this).data('g')
  gender = $(this).text()
})

//Show next slide
$('.next').on('click', function() {
  //Move to the next slide

  if (gender) {
    $('#slide1').hide()
    $('#slide2').show()
  } else {
    //Error should be shown
    $('.error').fadeIn()
  }
})



$('.animal').on('click', function() {
  animal = $(this).text()
  total += $(this).data('g')
  $('#slide2').hide()
  $('#slide3').show()
})

$('#slide3 li').on('click', function() {
  color = $(this).text()
  total += $(this).data('g')
  $('#slide3').hide()
  $('#slide4').show()
  switch (total) {
    case 641:
      $('.avatar').css('background-position', '0 0')
      res = "Naruto"
      break
    case 531:
      $('.avatar').css('background-position', '-200px 0')
      res = "Sasuke"
      break
    case 631:
      $('.avatar').css('background-position', '-395px 0')
      res = "Sakura"
      break
    case 541:
      $('.avatar').css('background-position', '-595px 0')
      res = "Kakashi"
      break
    case 532:
      $('.avatar').css('background-position', '0px 220px')
      res = "Itachi"
      break
    case 632:
      $('.avatar').css('background-position', '-204px 220px')
      res = "Kisama"
      break
    case 542:
      $('.avatar').css('background-position', '-405px 220px')
      res = "Tsunade"
      break
    case 642:
      $('.avatar').css('background-position', '-605px 220px')
      res = "Orochimaru"
      break
  }

  $('.results').text(res)

})
