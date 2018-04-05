$('.keypoints a').click(function() {
  $('.keypoints a').removeClass('selected')
  $(this).addClass('selected')

  
  let clicked = $(this).data("key")

  $(".aside").hide()
  switch (clicked) {
    case 1: 
      $('#item-1').fadeIn()
      break
    case 2:
      $('#item-2').fadeIn()
      break
    case 3: 
      $('#item-3').fadeIn()
      break
    case 4:
      $('#item-4').fadeIn()
      break
    case 5:
      $('#item-5').fadeIn()
      break
    default:
      $('#item-1').fadeIn()
      break
  }
})
